package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class SetTsPropertyFormatterTest extends FormatterTestCase {

	@Test
    public void testFormatValueNull() throws Exception {
        String result = new SetPropertyFormatter().format(new FormatContextImpl("blah", "SET<TS>", MANDATORY), 
        		new SETImpl<TS, Date>(TSImpl.class, NullFlavor.NO_INFORMATION));
        assertXml("null", "<blah nullFlavor=\"NI\"/>", result);
    }
    
	@Test
    public void testFormatValueNonNull() throws Exception {
        Date calendar1 = DateUtil.getDate(1999, 0, 1, 12, 29, 59, 0);
        Date calendar2 = DateUtil.getDate(2001, 1, 3, 13, 30, 00, 0);
        
        SETImpl<TS, Date> set = new SETImpl<TS, Date>(TSImpl.class);
        set.rawSet().addAll(makeSet(calendar1, calendar2));
        
		String result = new SetPropertyFormatter().format(
				new FormatContextImpl("blah", "SET<TS>", MANDATORY), 
				set);
		
        assertXml("non null", "<blah value=\"19990101122959.0000-0500\"/><blah value=\"20010203133000.0000-0500\"/>", result);
    }

    private Set<Date> makeSet(Date... dates) {
        return new LinkedHashSet<Date>(Arrays.asList( dates ));
    }
}
