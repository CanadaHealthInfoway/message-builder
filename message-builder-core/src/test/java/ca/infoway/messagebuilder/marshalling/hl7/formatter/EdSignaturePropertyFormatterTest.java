package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EdSignaturePropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNullWithConformanceOptional() throws Exception {
		String expectedResult = "";
			
		FormatContext context = new FormatContextImpl("name", null, ConformanceLevel.OPTIONAL);
		String result = new EdSignaturePropertyFormatter().format(context, null);
		assertEquals("named null format", expectedResult, result);
	}

	@Test
	public void testFormatValueNull() throws Exception {
		// expected:
		// <name nullFlavor=\"NI\"/>
		
		String expectedResult = "<name nullFlavor=\"NI\"/>" + LINE_SEPARATOR;
		
		String result = new EdSignaturePropertyFormatter().format(getContext("name"), new EDImpl<String>());
		assertEquals("named null format", expectedResult, result);
	}

	@Test
	public void testFormatValueNonNull() throws Exception {
		// expected:
		// <name mediaType="text/xml">
		//   <signature xmlns="http://www.w3.org/2000/09/xmldsig#">signatureText</signature>
		// </name>

		String expectedResult = 
			  "<name mediaType=\"text/xml\">" + LINE_SEPARATOR
			+ "  <signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">signatureText</signature>" + LINE_SEPARATOR
			+ "</name>" + LINE_SEPARATOR;
			
		String result = new EdSignaturePropertyFormatter().format(getContext("name"), new EDImpl<String>("signatureText"));
		assertEquals("something in text node", expectedResult, result);
	}
}
