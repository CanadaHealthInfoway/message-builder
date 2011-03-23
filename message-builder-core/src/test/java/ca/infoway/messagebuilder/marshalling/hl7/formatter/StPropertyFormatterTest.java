package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.STImpl;

public class StPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new StPropertyFormatter().format(getContext("name"), null);
		assertTrue("named null format", StringUtils.isBlank(result));
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(getContext("name"), new STImpl("something"));
		assertEquals("something in text node", addLineSeparator("<name>something</name>"), result);
	}

	@Test
	public void testFormatValueNonNullWithLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(new FormatContextImpl("name", "ST.LANG", null), new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"fr-CA\">something</name>"), result);
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(
				getContext("name"), 
				new STImpl("<cats think they're > humans & dogs 99% of the time/>"));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
	private String addLineSeparator(String value) {
		return value + LINE_SEPARATOR;
	}
}
