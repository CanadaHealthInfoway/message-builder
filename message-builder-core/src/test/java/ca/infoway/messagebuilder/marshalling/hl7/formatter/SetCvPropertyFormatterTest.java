package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class SetCvPropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CV>", MANDATORY), 
				new SETImpl<CV, Code>(CVImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = new SetPropertyFormatter().format(
        		new FormatContextImpl("blah", "SET<CV>", MANDATORY), 
				SETImpl.<CV, Code>create(CVImpl.class, 
	        			makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertXml("non null", "<blah code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\"/><blah code=\"kg\" codeSystem=\"2.16.840.1.113883.5.141\"/>", result);
    }

}
