package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.lang.CompressedData.LANGUAGE_ENGLISH;
import static ca.infoway.messagebuilder.datatype.lang.Compression.GZIP;
import static ca.infoway.messagebuilder.datatype.lang.Compression.gunzip;
import static ca.infoway.messagebuilder.datatype.lang.MediaType.PLAIN_TEXT;
import static ca.infoway.messagebuilder.datatype.lang.MediaType.XML_TEXT;
import static ca.infoway.messagebuilder.platform.Base64.decodeBase64String;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.CompressedData;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.MediaType;

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
				new EDImpl<EncapsulatedData>(new EncapsulatedData(PLAIN_TEXT, null, "this is some text & some \"more\"".getBytes())));
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueWithNoMediaType() throws Exception {
		String expectedResult =
			"<name representation=\"B64\">" +
			"dGhpcyBpcyBzb21lIHRleHQ=</name>" + LINE_SEPARATOR;

		String result = new EdPropertyFormatter().format(getContext("name"), 
				new EDImpl<EncapsulatedData>(new EncapsulatedData(null, null, "this is some text".getBytes())));
		assertEquals("something in text node", expectedResult, result);
	}
	
	@Test
	public void testFormatValueCompressedXmlData() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" reference=\"http://www.i-proving.ca\" representation=\"B64\">" +
				"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  "http://www.i-proving.ca", "<xml>foo</xml>".getBytes(), GZIP, LANGUAGE_ENGLISH);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		
		
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "<xml>foo</xml>");
	}
	
	@Test
	public void testFormatValueCompressedXmlDataEmptyContent() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" reference=\"http://www.i-proving.ca\" representation=\"B64\">" +
				"H4sIAAAAAAAAAAMAAAAAAAAAAAA=</name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  "http://www.i-proving.ca", "".getBytes(), GZIP, LANGUAGE_ENGLISH);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		
		assertEquals("element", clearPayload(expectedResult), clearPayload(result));
		assertEquals("element payload", decodeAndUnzip(extractPayload(result)), "");
	}

	@Test
	public void testFormatValueCompressedXmlDataNullContent() throws Exception {
		String expectedResult = "<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/xml\" reference=\"http://www.i-proving.ca\" representation=\"B64\"></name>" + LINE_SEPARATOR;
		EncapsulatedData data = new CompressedData(XML_TEXT,  "http://www.i-proving.ca", null, GZIP, LANGUAGE_ENGLISH);
		String result = new EdPropertyFormatter().format(getContext("name"), new EDImpl<EncapsulatedData>(data));
		assertEquals("something in text node", expectedResult, result);
	}

	@Test
	public void testFormatValueCompressedTextData() throws Exception {
		String expectedResult = 
			"<name compression=\"GZ\" language=\"ENG\" mediaType=\"text/plain\" reference=\"http://www.i-proving.ca\" representation=\"B64\">" +
			"H4sIAAAAAAAAALOpyM2xS8vPt9EHMQATOK6nDgAAAA==</name>" + LINE_SEPARATOR;
		
		EncapsulatedData data = new CompressedData(PLAIN_TEXT,  "http://www.i-proving.ca", "<xml>foo</xml>".getBytes(), GZIP, LANGUAGE_ENGLISH);
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

		EncapsulatedData ed = new EncapsulatedData(MediaType.PLAIN_TEXT, null, "<cats think they're > humans & dogs 99% of the time/>".getBytes());
		
		String result = new EdPropertyFormatter().format(
				getContext("name"), 
				new EDImpl<EncapsulatedData>(ed));
		assertEquals("something in text node", expectedResult.trim(), result.trim());
	}
	
	private String clearPayload(String result) {
		return result.replaceAll(">.*<", "><");
	}

	private String extractPayload(String result) {
		return result.replaceAll("(<name.*>(.*)</name>)", "$2");
	}
	
	
}