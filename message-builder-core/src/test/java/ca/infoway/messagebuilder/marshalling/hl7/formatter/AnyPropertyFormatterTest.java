package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;


public class AnyPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
		UncertainRange<PhysicalQuantity> urg = UncertainRange.createLowHigh(createQuantity("55", ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLIMETER), createQuantity("60", ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLIMETER));
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>(urg);
		urgImpl.setDataType(StandardDataType.URG_PQ);
		String result = new AnyPropertyFormatter().format(new FormatContextImpl("name", "ANY.LAB", null), urgImpl, 0);
		assertXml("result", "<name specializationType=\"URG_PQ\" xsi:type=\"URG_PQ\"><low unit=\"mm\" value=\"55\"/><high unit=\"mm\" value=\"60\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		URGImpl<PQ, PhysicalQuantity> urgImpl = new URGImpl<PQ, PhysicalQuantity>();
		urgImpl.setDataType(StandardDataType.URG_PQ);		
		String result = new AnyPropertyFormatter().format(new FormatContextImpl("name", "ANY.LAB", null), 
				urgImpl, 0);
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
