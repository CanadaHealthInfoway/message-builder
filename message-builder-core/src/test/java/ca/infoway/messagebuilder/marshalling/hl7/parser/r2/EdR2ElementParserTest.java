/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static ca.infoway.messagebuilder.datatype.lang.util.Compression.GZIP;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.XML_TEXT;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.EdElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdR2ElementParserTest extends CeRxDomainValueTestCase {

	private static final String TEXT_SIMPLE_B64 = Base64.encodeBase64String("This is a test".getBytes());

	private TelR2ElementParser telParser = new TelR2ElementParser();
	
	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		ED<EncapsulatedData> ed = (ED<EncapsulatedData>) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("data", ed.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ed.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, EncapsulatedData.class, version, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		BareANY parseResult = new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult);
		assertNull("data", parseResult.getBareValue());
		assertTrue(this.xmlResult.isValid());
	}

	@Test
	public void testParseTextNodeNoCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\">" + TEXT_SIMPLE_B64 +
				"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", TEXT_SIMPLE_B64, data.getContent());
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}

	@Test
	public void testParseTextNodeWithCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"B64\">" + TEXT_SIMPLE_B64 +
		"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", TEXT_SIMPLE_B64, data.getContent());
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}
	
	@Test
	public void testParseManyChildTextNodesAllowed() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"<through/>" +
				"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull(data);
		assertNotNull(data.getContent());
		assertXml("content", "<monkey/>" + System.getProperty("line.separator") + 
				"<shines/>" + System.getProperty("line.separator") + 
				"<through/>", removeExtraSpaces(data.getContent()));
	}
	
	//For .NET compatibility
	private String removeExtraSpaces(String xmlString) {
		return xmlString.replaceAll(" />", "/>");
	}
	
	@Test
	public void testParseValueCompressedXmlData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertEquals("content", "H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==", data.getContent());
	}
	
	@Test
	public void testParseValueCompressedXmlEmptyData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertEquals("content", "H4sIAAAAAAAAAAMAAAAAAAAAAAA=", data.getContent());
	}
	
	@Test
	public void testParseValueCompressedXmlNullData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\"></name>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertNull("content", data.getContent());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>this is a text node</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("signature", 
				"this is a text node", 
				value.getContent());
	}
	
	@Test
	public void testParseTrickyTextNodeThatReallyIsntText() throws Exception {
		Node node = createNode("<something>this is a text node<br/>with some extra<br/>formatting</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("mixed text", 
				"this is a text node<br/>with some extra<br/>formatting", 
				removeExtraSpaces(value.getContent()));
	}
	
	@Test
	public void testParseTextCommentsCdataAndElements() throws Exception {
		Node node = createNode(          
				"<text>\n" +
				"	this is some text\n" +
				"	<![CDATA[& this is some > CDATA text]]>\n" +
				"	<!--  with a comment -->\n" +
				"	<table xmlns:fred=\"urn:hl7-org:fred\">\n" +
				"		<thead>\n" +
				"			<tr>\n" +
				"				<th>and some html</th>\n" +
				"			</tr>\n" +
				"		</thead>\n" +
				"	</table>\n" +
				"</text>\n"
			);
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertXml("mixed text", 
				"this is some text\n" +
				"\t&amp; this is some &gt; CDATA text\n" +
				"<!--  with a comment -->\n" +
				"<table xmlns:fred=\"urn:hl7-org:fred\">\n" +
				"<thead>\n" +
				"<tr>\n" +
				"<th>and some html</th>\n" +
				"</tr>\n" +
				"</thead>\n" +
				"</table>\n",
				value.getContent(),
				false);
	}
	
	@Test
	public void testParseDocAndReferenceUsingNewerReferenceFormat() throws Exception {
		Node node = createNode("<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>text value</text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("text returned", "text value", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReferenceObj().getAddress());
		assertEquals("proper reference returned", "https", value.getReferenceObj().getUrlScheme().getCodeValue());
	}

	@Test
	public void testParseDocWithTooManyReferences() throws Exception {
		Node node = createNode("<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/><reference value=\"https://should.not.be.here.ca/monograph/WPDM00002197.html\"/>text value</text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("ED types only allow a single reference. Found: 2", this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("text returned", "text value", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReferenceObj().getAddress());
		assertEquals("proper reference returned", "https", value.getReferenceObj().getUrlScheme().getCodeValue());
	}

	@Test
	public void testParseRepresentationInvalid() throws Exception {
		Node node = createNode("<something representation=\"TXTB64\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper text returned", "text value", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReferenceObj());
	}
	
	@Test
	public void testParseRepresentationValidTXT() throws Exception {
		Node node = createNode("<something representation=\"TXT\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReferenceObj());
	}
	
	@Test
	public void testParseRepresentationValidTXTWithEmbeddedElements() throws Exception {
		Node node = createNode("<something representation=\"TXT\" compression=\"DF\" mediaType=\"text/plain\">text value<br/>with some<br/>unescaped characters;</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value<br/>with some<br/>unescaped characters;", removeExtraSpaces(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReferenceObj());
	}
	
	@Test
	public void testParseRepresentationValidTXTWithEscapedValues() throws Exception {
		Node node = createNode("<something representation=\"TXT\" compression=\"DF\" mediaType=\"text/plain\">text value&lt;br/&gt;with some&lt;br/&gt;escaped characters;</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value&lt;br/&gt;with some&lt;br/&gt;escaped characters;", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReferenceObj());
	}
	
	@Test
	public void testParseTxtButSentWithB64() throws Exception {
		String content = "text value should be b64 encoded";
		Node node = createNode("<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" + content + "</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value should be b64 encoded", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReferenceObj());
	}
	
	@Test
	public void testParseFullWithCdataNoThumbnail() throws Exception {
		Node node = createNode(
				"<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" +
				"<reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>" +
				"" +
				"<![CDATA[" +
				         "Since this is a CDATA section" +
				         "I can use all sorts of reserved characters" +
				         "like > < \" and &" +
				         "or write things like" +
				         "<foo></bar>" +
				         "but my document is still well formed!" +
				     "]]>" +				
				"</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertTrue("proper text returned", value.getContent().startsWith("Since this is a CDATA"));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReferenceObj().getAddress());
		assertEquals("proper reference returned", "https", value.getReferenceObj().getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseFullWithCdataAndThumbnail() throws Exception {
		Node node = createNode(
				"<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" +
				"<reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>" +
				"<thumbnail representation=\"TXT\" mediaType=\"text/html\"><reference value=\"https://thumbnail.ca/monograph/WPDM00002197.html\"/>thumbnail text value</thumbnail>" +				
				"<![CDATA[" +
				         "Since this is a CDATA section" +
				         "I can use all sorts of reserved characters" +
				         "like > < \" and &" +
				         "or write things like" +
				         "<foo></bar>" +
				         "but my document is still well formed!" +
				     "]]>" +				
				"</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper representation returned", EdRepresentation.B64, value.getRepresentation());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReferenceObj().getAddress());
		assertEquals("proper reference returned", "https", value.getReferenceObj().getUrlScheme().getCodeValue());
		
		assertEquals("proper thumbnail media type returned", X_DocumentMediaType.HTML_TEXT, value.getThumbnail().getMediaType());
		assertEquals("proper thumbnail representation returned", EdRepresentation.TXT, value.getThumbnail().getRepresentation());
		assertEquals("proper thumbnail reference returned", "thumbnail.ca/monograph/WPDM00002197.html", value.getThumbnail().getReferenceObj().getAddress());
		assertEquals("proper thumbnail reference returned", "https", value.getThumbnail().getReferenceObj().getUrlScheme().getCodeValue());
		assertEquals("proper thumbnail text returned", "thumbnail text value", value.getThumbnail().getContent());
		
		assertTrue("proper text returned", value.getContent().startsWith("Since this is a CDATA"));
	}
	
	@Test
	public void testParseFullWithCdataAndThumbnailOutOfOrder() throws Exception {
		Node node = createNode(
				"<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" +
				"<thumbnail representation=\"TXT\" mediaType=\"text/html\"><reference value=\"https://thumbnail.ca/monograph/WPDM00002197.html\"/>thumbnail text value</thumbnail>" +				
				"<reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>" +
				"<![CDATA[" +
				         "Since this is a CDATA section" +
				         "I can use all sorts of reserved characters" +
				         "like > < \" and &" +
				         "or write things like" +
				         "<foo></bar>" +
				         "but my document is still well formed!" +
				     "]]>" +				
				"</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser(this.telParser, true).parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("ED properties appear to be out of order"));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper representation returned", EdRepresentation.B64, value.getRepresentation());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReferenceObj().getAddress());
		assertEquals("proper reference returned", "https", value.getReferenceObj().getUrlScheme().getCodeValue());
		
		assertEquals("proper thumbnail media type returned", X_DocumentMediaType.HTML_TEXT, value.getThumbnail().getMediaType());
		assertEquals("proper thumbnail representation returned", EdRepresentation.TXT, value.getThumbnail().getRepresentation());
		assertEquals("proper thumbnail reference returned", "thumbnail.ca/monograph/WPDM00002197.html", value.getThumbnail().getReferenceObj().getAddress());
		assertEquals("proper thumbnail reference returned", "https", value.getThumbnail().getReferenceObj().getUrlScheme().getCodeValue());
		assertEquals("proper thumbnail text returned", "thumbnail text value", value.getThumbnail().getContent());
		
		assertTrue("proper text returned", value.getContent().startsWith("Since this is a CDATA"));
	}
}

