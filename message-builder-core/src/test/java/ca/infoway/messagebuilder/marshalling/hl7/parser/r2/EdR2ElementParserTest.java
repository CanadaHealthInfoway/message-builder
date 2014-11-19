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

import static ca.infoway.messagebuilder.datatype.lang.util.Compression.GZIP;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.XML_TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.util.EdRepresentation;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdR2ElementParserTest extends CeRxDomainValueTestCase {

	private static final String TEXT_SIMPLE_B64 = Base64.encodeBase64String("This is a test".getBytes());

	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		ED<EncapsulatedDataR2> ed = (ED<EncapsulatedDataR2>) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("data", ed.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ed.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, EncapsulatedDataR2.class, version, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		BareANY parseResult = new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult);
		assertNull("data", parseResult.getBareValue());
		assertTrue(this.xmlResult.isValid());
	}

	@Test
	public void testParseTextNodeNoCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\">" + TEXT_SIMPLE_B64 +
				"</something>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", TEXT_SIMPLE_B64, data.getTextContent());
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}

	@Test
	public void testParseTextNodeWithCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"B64\">" + TEXT_SIMPLE_B64 +
		"</something>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", TEXT_SIMPLE_B64, data.getTextContent());
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}
	
	@Test
	public void testParseManyChildTextNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"<through/>" +
				"</something>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertNotNull(data);
		assertNull(data.getTextContent());
		assertNotNull(data.getDocumentContent());
		assertXml("content", "<monkey/>", data.getDocumentContentAsString(-1));
	}
	
	@Test
	public void testParseValueCompressedXmlData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertEquals("content", "H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==", data.getTextContent());
	}
	
	@Test
	public void testParseValueCompressedXmlEmptyData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertEquals("content", "H4sIAAAAAAAAAAMAAAAAAAAAAAA=", data.getTextContent());
	}
	
	@Test
	public void testParseValueCompressedXmlNullData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\"></name>");
		EncapsulatedDataR2 data = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("representation", EdRepresentation.B64, data.getRepresentation());
		assertNull("content", data.getTextContent());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>this is a text node</something>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("signature", 
				"this is a text node", 
				value.getTextContent());
	}
	
	@Test
	public void testParseDocAndReferenceUsingNewerReferenceFormat() throws Exception {
		Node node = createNode("<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>text value</text>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("text returned", "text value", new String(value.getTextContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference().getAddress());
		assertEquals("proper reference returned", "https", value.getReference().getUrlScheme().getCodeValue());
	}

	@Test
	public void testParseDocWithTooManyReferences() throws Exception {
		Node node = createNode("<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/><reference value=\"https://should.not.be.here.ca/monograph/WPDM00002197.html\"/>text value</text>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("ED types only allow a single reference. Found: 2", this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("text returned", "text value", new String(value.getTextContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference().getAddress());
		assertEquals("proper reference returned", "https", value.getReference().getUrlScheme().getCodeValue());
	}

	@Test
	public void testParseRepresentationInvalid() throws Exception {
		Node node = createNode("<something representation=\"TXTB64\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper text returned", "text value", value.getTextContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}
	
	@Test
	public void testParseRepresentationValidTXT() throws Exception {
		Node node = createNode("<something representation=\"TXT\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value", value.getTextContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}
	
	@Test
	public void testParseTxtButSentWithB64() throws Exception {
		String content = "text value should be b64 encoded";
		Node node = createNode("<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" + content + "</something>");
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value should be b64 encoded", value.getTextContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
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
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNull(value.getTextContent());
		assertNull(value.getDocumentContent());
		assertTrue("proper text returned", value.getCdataContent().startsWith("Since this is a CDATA"));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference().getAddress());
		assertEquals("proper reference returned", "https", value.getReference().getUrlScheme().getCodeValue());
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
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper representation returned", EdRepresentation.B64, value.getRepresentation());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference().getAddress());
		assertEquals("proper reference returned", "https", value.getReference().getUrlScheme().getCodeValue());
		
		assertEquals("proper thumbnail media type returned", X_DocumentMediaType.HTML_TEXT, value.getThumbnail().getMediaType());
		assertEquals("proper thumbnail representation returned", EdRepresentation.TXT, value.getThumbnail().getRepresentation());
		assertEquals("proper thumbnail reference returned", "thumbnail.ca/monograph/WPDM00002197.html", value.getThumbnail().getReference().getAddress());
		assertEquals("proper thumbnail reference returned", "https", value.getThumbnail().getReference().getUrlScheme().getCodeValue());
		assertEquals("proper thumbnail text returned", "thumbnail text value", value.getThumbnail().getTextContent());
		
		assertNull(value.getTextContent());
		assertNull(value.getDocumentContent());
		assertTrue("proper text returned", value.getCdataContent().startsWith("Since this is a CDATA"));
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
		EncapsulatedDataR2 value = (EncapsulatedDataR2) new EdR2ElementParser().parse(createContext("ED", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("ED properties appear to be out of order"));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper representation returned", EdRepresentation.B64, value.getRepresentation());
		assertEquals("proper reference returned", "pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference().getAddress());
		assertEquals("proper reference returned", "https", value.getReference().getUrlScheme().getCodeValue());
		
		assertEquals("proper thumbnail media type returned", X_DocumentMediaType.HTML_TEXT, value.getThumbnail().getMediaType());
		assertEquals("proper thumbnail representation returned", EdRepresentation.TXT, value.getThumbnail().getRepresentation());
		assertEquals("proper thumbnail reference returned", "thumbnail.ca/monograph/WPDM00002197.html", value.getThumbnail().getReference().getAddress());
		assertEquals("proper thumbnail reference returned", "https", value.getThumbnail().getReference().getUrlScheme().getCodeValue());
		assertEquals("proper thumbnail text returned", "thumbnail text value", value.getThumbnail().getTextContent());
		
		assertNull(value.getTextContent());
		assertNull(value.getDocumentContent());
		assertTrue("proper text returned", value.getCdataContent().startsWith("Since this is a CDATA"));
	}
}

