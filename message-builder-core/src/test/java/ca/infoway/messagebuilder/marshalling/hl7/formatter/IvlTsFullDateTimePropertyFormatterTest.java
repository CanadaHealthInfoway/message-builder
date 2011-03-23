package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class IvlTsFullDateTimePropertyFormatterTest extends FormatterTestCase {
	
	public static class CustomUnit extends EnumPattern implements UnitsOfMeasureCaseSensitive {
		private static final long serialVersionUID = -8455773998578575019L;
		public static final CustomUnit SANDWICH = new CustomUnit("SANDWICH"); 
		public static final CustomUnit COFFEE = new CustomUnit("COFFEE");
		public static final CustomUnit NEWSPAPER = new CustomUnit("NEWSPAPER");
		private CustomUnit(String name) {
			super(name);
		}
		public String getCodeSystem() {
			return null;
		}
		public String getCodeValue() {
			return name();
		}
	}
    
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomUnit() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(1, CustomUnit.SANDWICH));
        String result = new IvlTsPropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width unit=\"SANDWICH\" value=\"1\"/></name>", result);
    }
    
	@Test
	public void testNullable() throws Exception {
        Interval<Date> interval = IntervalFactory.<Date>createWidth(new DateDiff(NullFlavor.OTHER));
        String result = new IvlTsPropertyFormatter().format(getContext("name"), 
        		new IVLImpl<QTY<Date>, Interval<Date>>(interval));
        assertXml("result", "<name><width nullFlavor=\"OTH\"/></name>", result);
    }
    
    @Override
    protected FormatContext getContext(String name) {
    	return new FormatContextImpl(name, "IVL<TS.FULLDATETIME>", null);
    }
}
