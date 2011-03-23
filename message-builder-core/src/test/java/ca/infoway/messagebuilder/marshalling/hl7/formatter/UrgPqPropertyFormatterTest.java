package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;

public class UrgPqPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
		UncertainRange<PhysicalQuantity> urg = UncertainRange.createLowHigh(createQuantity("55", CeRxDomainTestValues.MILLIMETER), createQuantity("60", CeRxDomainTestValues.MILLIMETER));
		String result = new UrgPqPropertyFormatter().format(getContext("name"), 
				new URGImpl<PQ, PhysicalQuantity>(urg));
		assertXml("result", "<name><low unit=\"mm\" value=\"55\"/><high unit=\"mm\" value=\"60\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = new UrgPqPropertyFormatter().format(getContext("name"), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
