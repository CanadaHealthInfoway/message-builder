package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class SetCsPropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CS>", MANDATORY), 
				new SETImpl<CS, Code>(CSImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CS>", MANDATORY),
				SETImpl.<CS, Code>create(CSImpl.class, 
	        			makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertXml("non null", "<blah code=\"cm\"/><blah code=\"kg\"/>", result);
    }

}
