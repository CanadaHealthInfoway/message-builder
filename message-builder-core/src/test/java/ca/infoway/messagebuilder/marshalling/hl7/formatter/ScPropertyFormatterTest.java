package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.SCImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.domainvalue.basic.State;

public class ScPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ScPropertyFormatter().format(getContext("name"), null);
		assertTrue("named null format", StringUtils.isBlank(result));
	}
	
	@Test
    public void testFormatValueNullCode() throws Exception {
        ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("something", null); 
        
        String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
        assertEquals("something in text node", addLineSeparator("<name>something</name>"), result);
    }

	@Test
    public void testFormatValueCode() throws Exception {
        ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("something", State.ALBERTA); 
        
        String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
        assertEquals("something in text node", addLineSeparator("<name code=\"AB\">something</name>"), result);
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("<cats think they're > humans & dogs 99% of the time/>", null); 
		
		String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
	private String addLineSeparator(String value) {
		return value + LINE_SEPARATOR;
	}
}
