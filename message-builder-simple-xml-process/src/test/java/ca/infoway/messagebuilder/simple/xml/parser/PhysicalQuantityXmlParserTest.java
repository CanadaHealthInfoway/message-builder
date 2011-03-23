package ca.infoway.messagebuilder.simple.xml.parser;

import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;


public class PhysicalQuantityXmlParserTest extends AbstractXmlParserTest<PQ> {

	public PhysicalQuantityXmlParserTest() {
		super(new PhysicalQuantityXmlParser(), "dose", new PQImpl());
	}

	@Test
	public void shouldParseValue() throws Exception {
        PhysicalQuantity physicalQuantity = new PhysicalQuantity(
        		new BigDecimal("33.45"), 
        		ENZYME_UNIT_MICROMOLES_MINUTE_PER_LITRE);
		
		assertEquals(
				"<dose unit=\"U/l\" value=\"33.45\"/>",
				this.parser.parse(createContext(), new PQImpl(physicalQuantity)));
        
	}
	
	@Override
	protected PQ createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new PQImpl(nullFlavor);
	}
	
}
