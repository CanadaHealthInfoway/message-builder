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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.datatype.lang.util.Compression.GZIP;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.PLAIN_TEXT;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.XML_TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.platform.BytesUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdElementParserTest extends CeRxDomainValueTestCase {

	private static final String TEXT_SIMPLE = Base64.encodeBase64String("This is a test".getBytes());

	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		ED<EncapsulatedData> ed = (ED<EncapsulatedData>) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("data", ed.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ed.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParserContextImpl.create(type, EncapsulatedData.class, version, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		BareANY parseResult = new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult);
		assertNull("data", parseResult.getBareValue());
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size()); // missing mediaType and content
	}

	@Test
	public void testParseTextNodeNoCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\">" + TEXT_SIMPLE +
				"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", TEXT_SIMPLE, new String(data.getContent()));
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}

	@Test
	public void testParseTextNodeWithCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"B64\">" + TEXT_SIMPLE +
		"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("content", "This is a test", new String(data.getContent()));
		assertEquals("media type", X_DocumentMediaType.PLAIN_TEXT, data.getMediaType());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"<through/>" +
				"</something>");
		try {
			new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult);
			fail("expected exception");
		} catch (XmlToModelTransformationException e) {
			// expected
		}
		
		node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		try {
			new EdElementParser().parse(createContext("ED.DOCREF", SpecificationVersion.V02R02), node, this.xmlResult);
			fail("expected exception");
		} catch (XmlToModelTransformationException e) {
			// expected
		}
	}
	
	@Test
	public void testParseValueCompressedXmlData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("content", "<xml>foo</xml>", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@Test
	public void testParseValueCompressedXmlEmptyData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("content", "", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@Test
	public void testParseValueCompressedXmlNullData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\"></name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size()); // content missing
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertNull("content", data.getUncompressedContent());
	}

	@Test
	public void testParseValueCompressedTextData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("media type", PLAIN_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "en-CA", data.getLanguage());
		assertEquals("content", "<xml>foo</xml>", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>this is a text node</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());  // must provide specializationType and mediaType
		assertEquals("signature", 
				"this is a text node", 
				new String(value.getContent()));
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something specializationType=\"ED.DOC\" mediaType=\"text/plain\" reference=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}
	
	@Test
	public void testParseReferenceTypeUsingNewerReferenceFormat() throws Exception {
		Node node = createNode("<text specializationType=\"ED.DOCREF\" mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}

	@Test
	public void testParseDocAndReferenceUsingNewerReferenceFormat() throws Exception {
		Node node = createNode("<text specializationType=\"ED.DOC\" mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>text value</text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("text returned", "text value", new String(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}

	@Test
	public void testParseReferenceTypeUsingNewerReferenceFormatWithInvalidSpecializationType() throws Exception {
		Node node = createNode("<text specializationType=\"ED.SIGNATURE\" mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}

	@Test
	public void testParseCompressionNotAllowedForEdRef() throws Exception {
		Node node = createNode("<something compression=\"GZ\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.REF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}
	
	@Test
	public void testParseCompressionPassesWithGZForCerxEdDocOrRef() throws Exception {
		Node node = createNode("<something compression=\"GZ\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}
	
	@Test
	public void testParseCompressionFailsWithNonGZForCerxEdDocOrRef() throws Exception {
		Node node = createNode("<something compression=\"DF\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}
	
	@Test
	public void testParseCompressionMustBeDfOrGz() throws Exception {
		Node node = createNode("<text compression=\"DFGZ\" specializationType=\"ED.DOC\" mediaType=\"text/html\">text value</text>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.HTML_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}

	@Test
	public void testCantHaveBothRefAndContentForCerxEdDocOrRef() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" reference=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size()); // reference should be as element; can't have both reference and content
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}

	@Test
	public void testMustHaveOneOfRefOrContentForCerxEdDocOrRef() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\"></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}

	@Test
	public void testParseRepresentationInvalid() throws Exception {
		Node node = createNode("<something representation=\"TXTB64\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}
	
	@Test
	public void testParseRepresentationValidTXT() throws Exception {
		Node node = createNode("<something representation=\"TXT\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}
	
	@Test
	public void testParseRepresentationValidB64() throws Exception {
		String content = Base64.encodeBase64String("text value".getBytes());
		Node node = createNode("<something representation=\"B64\" compression=\"DF\" mediaType=\"text/plain\">" + content + "</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOC", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference", value.getReference());
	}
	
	@Test
	public void testParseFailsDueToContentNotAllowed() throws Exception {
		Node node = createNode("<something reference=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\" compression=\"DF\" mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size()); // reference should be an element; can't have content
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
	}
	
	@Test
	public void testParseFailsDueToMissingReference() throws Exception {
		Node node = createNode("<something compression=\"DF\" mediaType=\"text/plain\"/>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("nor text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertNull("no reference returned", value.getReference());
	}
	
	@Test
	public void testParseSucceedsWithValidLanguage() throws Exception {
		Node node = createNode("<something language=\"en-CA\" compression=\"DF\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
		assertEquals("en-CA", value.getLanguage());
	}
	
	@Test
	public void testParseFailsWithInvalidLanguage() throws Exception {
		Node node = createNode("<something language=\"eng\" compression=\"DF\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCREF", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
		assertEquals("eng", value.getLanguage());
	}
	
	@Test
	public void testParseFailsWithInvalidLanguageForCeRx() throws Exception {
		Node node = createNode("<something language=\"en-CA\" compression=\"GZ\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
		assertEquals("en-CA", value.getLanguage());
	}
	
	@Test
	public void testParsePassesWithValidLanguageForCeRx() throws Exception {
		Node node = createNode("<something language=\"eng\" compression=\"GZ\" mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createContext("ED.DOCORREF", SpecificationVersion.V01R04_3), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNull("no text returned", value.getContent());
		assertEquals("proper media type returned", X_DocumentMediaType.PLAIN_TEXT, value.getMediaType());
		assertEquals("proper reference returned", "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", value.getReference());
		assertEquals("eng", value.getLanguage());
	}
	
	// charset not permitted pre-MR2009
	
}

