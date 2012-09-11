/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import static ca.infoway.messagebuilder.domainvalue.basic.MediaType.HTML_TEXT;
import static ca.infoway.messagebuilder.domainvalue.basic.MediaType.PLAIN_TEXT;
import static ca.infoway.messagebuilder.domainvalue.basic.MediaType.XML_TEXT;
import static ca.infoway.messagebuilder.platform.Base64.decodeBase64String;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.domainvalue.basic.MediaType;

public class EdPropertyFormatterTest extends FormatterTestCase {

 	@Test
	public void testFormatValueNull() throws Exception {
		String expectedResult =
			  "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>());
		assertEquals("named null format", expectedResult, result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String expectedResult =
			  "<name>" +
			  "this is some text &amp; some &quot;more&quot;</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, null, "this is some text & some \"more\"".getBytes(), null)));
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithNoMediaType() throws Exception {
		String expectedResult =
			"<name representation=\"B64\">" +
			"dGhpcyBpcyBzb21lIHRleHQ=</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(null, null, null, "this is some text".getBytes(), null)));
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueCompressedXmlData() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  null, "<xml>foo</xml>".getBytes(), GZIP, "en-CA", null);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		
		
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "<xml>foo</xml>");
	}
	
	@Test
	public void testFormatValueCompressedXmlDataEmptyContent() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  null, "".getBytes(), GZIP, "en-CA", null);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "");
	}

	@Test
	public void testFormatValueCompressedXmlDataNullContent() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/xml\" representation=\"B64\"><reference value=\"http://www.i-proving.ca\"/></name>";
		EncapsulatedData data = new CompressedData(XML_TEXT,  "http://www.i-proving.ca", null, GZIP, "en-CA", null);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}

	@Test
	public void testFormatValueCompressedTextData() throws Exception {
		String expectedResult = 
			"<name compression=\"GZ\" language=\"en-CA\" mediaType=\"text/plain\" representation=\"B64\">" +
			"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>" + LINE_SEPARATOR;
		
		EncapsulatedData data = new CompressedData(PLAIN_TEXT, null, "<xml>foo</xml>".getBytes(), GZIP, "en-CA", null);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "<xml>foo</xml>");
	}

	private String decodeAndUnzip(String payload) throws IOException {
		return new String(gunzip(decodeBase64String(payload)));
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		
		String expectedResult = 
			"<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>" + LINE_SEPARATOR;

		EncapsulatedData ed = new EncapsulatedData(MediaType.PLAIN_TEXT, null, null, "<cats think they're > humans & dogs 99% of the time/>".getBytes(), null);
		
		String result = new EdPropertyFormatter().format(
				getContext("name"), 
				new EDImpl<EncapsulatedData>(ed));
		assertEquals("something in text node", expectedResult.trim(), result.trim());
	}
	
	private String clearPayload(String result) {
		return result.replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll(">.+?<", "><");
	}

	private String extractPayload(String result) {
		return result.replaceAll("(<name.*>(.*)</name>)", "$2");
	}
	
	
	@Test
	public void testReferenceForSKBug() throws Exception {
		String expectedResult = "<text mediaType=\"text/html\"><reference value=\"https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html\"/></text>";
		EncapsulatedData data = new EncapsulatedData(HTML_TEXT, "https://pipefq.ehealthsask.ca/monograph/WPDM00002197.html", null, null, null);
		String result = new EdPropertyFormatter().format(getContext("text"), new EDImpl<EncapsulatedData>(data));
		assertEquals("something in text node", expectedResult, clearPayload(result));
	}

}