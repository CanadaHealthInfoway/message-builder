package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetStringPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<ST>", ConformanceLevel.MANDATORY), 
				new SETImpl<ST, String>(STImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<ST>", ConformanceLevel.MANDATORY), 
				SETImpl.<ST, String>create(STImpl.class, makeSet( "Fred", "Wilma" )));
		assertXml("non null", "<blah>Fred</blah><blah>Wilma</blah>", result);
	}

}
