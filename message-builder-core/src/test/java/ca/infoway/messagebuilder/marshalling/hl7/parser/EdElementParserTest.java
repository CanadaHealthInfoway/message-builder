/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.datatype.lang.Compression.GZIP;
import static ca.infoway.messagebuilder.datatype.lang.MediaType.PLAIN_TEXT;
import static ca.infoway.messagebuilder.datatype.lang.MediaType.XML_TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.MediaType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.platform.Base64;
import ca.infoway.messagebuilder.platform.BytesUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdElementParserTest extends CeRxDomainValueTestCase {

	private static final String TEXT_SIMPLE = Base64.encodeBase64String("This is a test".getBytes());

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		ED<EncapsulatedData> ed = (ED<EncapsulatedData>) new EdElementParser().parse(createContext(), node, null);
		assertNull("data", ed.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, ed.getNullFlavor());
	}
	private ParseContext createContext() {
		return ParserContextImpl.create("ED", EncapsulatedData.class, SpecificationVersion.NEWFOUNDLAND, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertEquals("data", null, new EdElementParser().parse(null, node, null).getBareValue());
	}

	@Test
	public void testParseTextNodeNoCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\">" + TEXT_SIMPLE +
				"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("content", TEXT_SIMPLE, new String(data.getContent()));
		assertEquals("media type", MediaType.PLAIN_TEXT, data.getMediaType());
	}

	@Test
	public void testParseTextNodeWithCompression() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"B64\">" + TEXT_SIMPLE +
		"</something>");
		EncapsulatedData data = (EncapsulatedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("content", "This is a test", new String(data.getContent()));
		assertEquals("media type", MediaType.PLAIN_TEXT, data.getMediaType());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		try {
			new EdElementParser().parse(null, node, null);
			fail("expected exception");
		} catch (XmlToModelTransformationException e) {
			// expected
		}
	}
	
	@Test
	public void testParseValueCompressedXmlData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "ENG", data.getLanguage());
		assertEquals("content", "<xml>foo</xml>", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@Test
	public void testParseValueCompressedXmlEmptyData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "ENG", data.getLanguage());
		assertEquals("content", "", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@Test
	public void testParseValueCompressedXmlNullData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" representation=\"B64\"></name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("media type", XML_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "ENG", data.getLanguage());
		assertNull("content", data.getUncompressedContent());
	}

	@Test
	public void testParseValueCompressedTextData() throws Exception {
		Node node = createNode("<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/plain\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>");
		CompressedData data = (CompressedData) new EdElementParser().parse(null, node, null).getBareValue();
		assertEquals("media type", PLAIN_TEXT, data.getMediaType());
		assertEquals("Compression type", GZIP, data.getCompression());
		assertEquals("language", "ENG", data.getLanguage());
		assertEquals("content", "<xml>foo</xml>", BytesUtil.asString(data.getUncompressedContent()));
	}
	
	@SuppressWarnings("deprecation")
	private ParseContext createEdContext() {
		return ParserContextImpl.create("ED.DOCORREF", String.class, SpecificationVersion.V02R02, null);
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>this is a text node</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createEdContext(), node, null).getBareValue();
		assertEquals("signature", 
				"this is a text node", 
				new String(value.getContent()));
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\">text value</something>");
		EncapsulatedData value = (EncapsulatedData) new EdElementParser().parse(createEdContext(), node, null).getBareValue();
		assertEquals("proper text returned", "text value", BytesUtil.asString(value.getContent()));
	}
	
}

