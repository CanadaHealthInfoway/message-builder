package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class RatioDrugQuantityPerTimeXmlParserTest extends AbstractXmlParserTest<RTO<PhysicalQuantity, PhysicalQuantity>> {
	
	public RatioDrugQuantityPerTimeXmlParserTest() {
		super(new RatioDrugQuantityPerTimeXmlParser(), "drugOverTime", new RTOImpl<PhysicalQuantity, PhysicalQuantity>());
	}
	
	@Test
	public void shouldParseValue() throws Exception {
		RTOImpl<PhysicalQuantity, PhysicalQuantity> rto = new RTOImpl<PhysicalQuantity, PhysicalQuantity>(new Ratio<PhysicalQuantity, PhysicalQuantity>(
				new PhysicalQuantity(new BigDecimal("5.3"), UnitsOfMeasureCaseSensitive.MILLILITRE), 
				new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.DAY)));
		assertEquals(
				 "<drugOverTime><drugQuantity unit=\"ml\" value=\"5.3\"/><time unit=\"d\" value=\"10\"/></drugOverTime>",
				 this.parser.parse(createContext(), rto));
	}

	@Override
	protected RTO<PhysicalQuantity, PhysicalQuantity> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		RTOImpl<PhysicalQuantity, PhysicalQuantity> rto = new RTOImpl<PhysicalQuantity, PhysicalQuantity>();
		rto.setNullFlavor(nullFlavor);
		return rto;
	}

}
