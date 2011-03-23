package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNameUse;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;

public class TnPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new TnPropertyFormatter().format(getContext("name"), new TNImpl());
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
        TnPropertyFormatter formatter = new TnPropertyFormatter();
		
		String result = formatter.format(getContext("name"), new TNImpl(new TrivialName("something")));
		assertEquals("something in text node", "<name>something</name>", result.trim());
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        TnPropertyFormatter formatter = new TnPropertyFormatter();
		
		TrivialName trivialName = new TrivialName("<cats think they're > humans & dogs 99% of the time/>");
		String result = formatter.format(getContext("name"), new TNImpl(trivialName));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
	@Test
    public void testFormatNameUses() throws Exception {
        EnPropertyFormatter formatter = new EnPropertyFormatter();
        
        EntityName name = new TrivialName("something");
        name.addUse(EntityNameUse.ALPHABETIC);
        name.addUse(EntityNameUse.IDEOGRAPHIC);

        // since the uses as a set, order is not guaranteed
        String result = formatter.format(getContext("name"), new ENImpl<EntityName>(name));
        assertTrue("open tag", result.startsWith("<name use=\""));
        assertTrue("ABC", result.contains("ABC IDE") || result.contains("IDE ABC"));
        assertTrue("close tag", result.trim().endsWith("\">something</name>"));
    }
}
