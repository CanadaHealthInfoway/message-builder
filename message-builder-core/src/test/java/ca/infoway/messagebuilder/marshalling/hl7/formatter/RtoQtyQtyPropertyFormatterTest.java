package ca.infoway.messagebuilder.marshalling.hl7.formatter;


import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Ratio;

public class RtoQtyQtyPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
        Ratio<BigDecimal, BigDecimal> ratio = new Ratio<BigDecimal, BigDecimal> ();
        ratio.setNumerator(new BigDecimal("1.00"));
        ratio.setDenominator(new BigDecimal("10.00"));
        
		String result = new RtoQtyQtyPropertyFormatter().format(getContext("name"), 
				new RTOImpl<BigDecimal, BigDecimal>(ratio));
		assertXml("result", "<name><numerator value=\"1.00\" xsi:type=\"QTY\"/><denominator value=\"10.00\" xsi:type=\"QTY\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoQtyQtyPropertyFormatter().format(getContext("name"), 
				new RTOImpl<BigDecimal, BigDecimal>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
}
