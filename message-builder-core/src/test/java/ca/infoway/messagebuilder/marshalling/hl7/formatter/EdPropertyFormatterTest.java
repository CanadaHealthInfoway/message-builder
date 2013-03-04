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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.lang.util.Compression.GZIP;
import static ca.infoway.messagebuilder.datatype.lang.util.Compression.gunzip;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.HTML_TEXT;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.PLAIN_TEXT;
import static ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType.XML_TEXT;
import static ca.infoway.messagebuilder.platform.Base64.decodeBase64String;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.Compression;
import ca.infoway.messagebuilder.platform.Base64;

public class EdPropertyFormatterTest extends FormatterTestCase {

 	@Test
	public void testFormatValueNull() throws Exception {
		String expectedResult =
			  "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), new EDImpl<EncapsulatedData>());
		assertTrue(this.result.isValid());
		assertEquals("named null format", expectedResult, result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String expectedResult =
			  "<name mediaType=\"text/plain\">" +
			  "this is some text &amp; some &quot;more&quot;</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "this is some text & some \"more\"".getBytes())));
		assertTrue(this.result.isValid());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueMissingContent() throws Exception {
		String expectedResult =
			  "<name mediaType=\"text/plain\">" +
			  "</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "".getBytes())));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithSpecializationType() throws Exception {
		String expectedResult =
			  "<name mediaType=\"text/plain\" specializationType=\"ED.DOC\" xsi:type=\"ED\">" +
			  "this is some text &amp; some &quot;more&quot;</name>" + LINE_SEPARATOR;

		EDImpl<EncapsulatedData> edImp = new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "this is some text & some \"more\"".getBytes()));
		edImp.setDataType(StandardDataType.ED_DOC);
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOCORREF"), 
				edImp);
		assertTrue(this.result.isValid());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithMissingSpecializationType() throws Exception {
		String expectedResult =
			  "<name mediaType=\"text/plain\" specializationType=\"ED.DOC\" xsi:type=\"ED\">" +
			  "this is some text &amp; some &quot;more&quot;</name>" + LINE_SEPARATOR;

		EDImpl<EncapsulatedData> edImp = new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "this is some text & some \"more\"".getBytes()));
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOCORREF"), 
				edImp);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithWrongSpecializationType() throws Exception {
		String expectedResult =
			  "<name mediaType=\"text/plain\" specializationType=\"ED.DOC\" xsi:type=\"ED\">" +
			  "this is some text &amp; some &quot;more&quot;</name>" + LINE_SEPARATOR;

		EDImpl<EncapsulatedData> edImp = new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "this is some text & some \"more\"".getBytes()));
		edImp.setDataType(StandardDataType.ED_SIGNATURE);
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOCORREF"), 
				edImp);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithNoMediaType() throws Exception {
		String expectedResult =
			"<name representation=\"B64\">" +
			"dGhpcyBpcyBzb21lIHRleHQ=</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(null, null, null, "this is some text".getBytes())));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueCompressedXmlData() throws Exception {
		byte[] content = "<xml>foo</xml>".getBytes();
		String finalContent = Base64.encodeBase64String(Compression.gzip(content));

		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				finalContent + "</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  null, content, GZIP, "en-CA");
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), new EDImpl<EncapsulatedData>(data));
		
		assertTrue(this.result.isValid());
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "<xml>foo</xml>");
	}
	
	@Test
	public void testFormatValueCompressedXmlDataEmptyContent() throws Exception {
		byte[] content = "".getBytes();
		String finalContent = Base64.encodeBase64String(Compression.gzip(content));
		
		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				finalContent + "</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  null, content, GZIP, "en-CA");
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), new EDImpl<EncapsulatedData>(data));
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "");
	}

	@Test
	public void testFormatValueCompressedXmlDataNullContent() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\"><reference value=\"http://www.i-proving.ca\"/></name>";
		EncapsulatedData data = new CompressedData(XML_TEXT,  "http://www.i-proving.ca", null, GZIP, "en-CA");
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), new EDImpl<EncapsulatedData>(data));

		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}

	@Test
	public void testFormatValueCompressedTextData() throws Exception {
		String contentAsString = "<xml>foo</xml>";
		byte[] content = contentAsString.getBytes();
		String finalContent = Base64.encodeBase64String(Compression.gzip(content));
		
		String expectedResult = 
			"<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"B64\">" +
					finalContent + "</name>" + LINE_SEPARATOR;
		
		EncapsulatedData data = new CompressedData(PLAIN_TEXT, null, content, GZIP, "en-CA");
		String result = new EdPropertyFormatter().format(getContext("name", "ED.DOC"), new EDImpl<EncapsulatedData>(data));
		
		assertTrue(this.result.isValid());
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), contentAsString);
	}

	private String decodeAndUnzip(String payload) throws IOException {
		return new String(gunzip(decodeBase64String(payload)));
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		
		String expectedResult = 
			"<name mediaType=\"text/plain\">&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>" + LINE_SEPARATOR;

		EncapsulatedData ed = new EncapsulatedData(PLAIN_TEXT, null, null, "<cats think they're > humans & dogs 99% of the time/>".getBytes());
		
		String result = new EdPropertyFormatter().format(
				getContext("name", "ED.DOC"), 
				new EDImpl<EncapsulatedData>(ed));
		
		assertTrue(this.result.isValid());
		assertEquals("something in text node", expectedResult.trim(), result.trim());
	}
	
	private String clearPayload(String result) {
		return result.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("> +", ">").replaceAll(" +<", "<");
	}

	private String extractPayload(String result) {
		return result.replaceAll("(<name.*>(.*)</name>)", "$2");
	}
	
	@Test
	public void testReferenceForSKBug() throws Exception {
		String expectedResult = "<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></text>";
		EncapsulatedData data = new EncapsulatedData(HTML_TEXT, "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", null, null);
		String result = new EdPropertyFormatter().format(getContext("text", "ED.DOCREF"), new EDImpl<EncapsulatedData>(data));
		
		assertTrue(this.result.isValid());
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}
	
	@Test
	public void testReferenceWithContent() throws Exception {
		String expectedResult = "<text mediaType=\"text/plain\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/>this is some text</text>";
		EncapsulatedData data = new EncapsulatedData(PLAIN_TEXT, "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", null, "this is some text".getBytes());
		String result = new EdPropertyFormatter().format(getContext("text", "ED.DOC"), new EDImpl<EncapsulatedData>(data));
		
		assertTrue(this.result.isValid());
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}
	
	@Test
	public void testMissingReference() throws Exception {
		String expectedResult = "<text mediaType=\"text/html\"></text>";
		EncapsulatedData data = new EncapsulatedData(HTML_TEXT, null, null, null);
		String result = new EdPropertyFormatter().format(getContext("text", "ED.DOCREF"), new EDImpl<EncapsulatedData>(data));
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}

}