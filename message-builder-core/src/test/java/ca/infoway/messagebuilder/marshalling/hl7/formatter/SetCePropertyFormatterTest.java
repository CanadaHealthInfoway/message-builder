package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetCePropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CE>", ConformanceLevel.MANDATORY), 
				new SETImpl<CE, Code>(CEImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CE>", ConformanceLevel.MANDATORY), 
				SETImpl.<CE, Code>create(CEImpl.class, 
        			makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertXml("non null", "<blah code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\"/><blah code=\"kg\" codeSystem=\"2.16.840.1.113883.5.141\"/>", result);
    }

}
