package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetCdPropertyFormatterTest extends FormatterTestCase {

	private SetPropertyFormatter formatter;

	@Before
	public void setUp() throws Exception {
		this.formatter = new SetPropertyFormatter();
	}
	
	@Test
    public void testFormatValueNull() throws Exception {
        String result = this.formatter.format(
        		new FormatContextImpl("blah", "SET<CD>", ConformanceLevel.MANDATORY), 
				new SETImpl<CD, Code>(CDImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNullNotMandatory() throws Exception {
    	String result = this.formatter.format(
    			new FormatContextImpl("blah", "SET<CD>", ConformanceLevel.OPTIONAL), 
    			null);
    	assertXml("null", "", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        String result = this.formatter.format(
        		new FormatContextImpl("blah", "SET<CD>", ConformanceLevel.MANDATORY), 
				SETImpl.<CD, Code>create(CDImpl.class, 
						makeSet( UnitsOfMeasureCaseSensitive.CENTIMETRE, UnitsOfMeasureCaseSensitive.KILOGRAM )));
        assertXml("non null", "<blah code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\"/><blah code=\"kg\" codeSystem=\"2.16.840.1.113883.5.141\"/>", result);
    }

	@Test
    public void testFormatValueEmptySet() throws Exception {
    	String result = this.formatter.format(
    			new FormatContextImpl("blah", "SET<CD>", ConformanceLevel.POPULATED), 
				SETImpl.<CD, Code>create(CDImpl.class, new HashSet<Code>()));
    	assertXml("non null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
}
