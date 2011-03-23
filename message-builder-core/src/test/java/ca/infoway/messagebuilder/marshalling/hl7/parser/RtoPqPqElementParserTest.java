package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLILITRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RtoPqPqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		RTO<PhysicalQuantity, PhysicalQuantity> rto = (RTO<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqElementParser().parse(createContext(), node, null);
		
		assertNull("value", rto.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, rto.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("RTO<PQ,PQ>", Ratio.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqElementParser().parse(null, node, null).getBareValue();
		assertNotNull("ratio", ratio);
		assertNull("numerator", ratio.getNumerator());
		assertNull("denominator", ratio.getDenominator());
	}

	@Test
	public void testParseValidAttributes() throws Exception {
        resolver.addDomainValue(MILLIGRAM, UnitsOfMeasureCaseSensitive.class);
        resolver.addDomainValue(MILLILITRE, UnitsOfMeasureCaseSensitive.class);
        
		Node node = createNode("<something><numerator value=\"1234.45\" unit=\"mg\"/><denominator value=\"2345.67\" unit=\"ml\" /></something>");
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = (Ratio<PhysicalQuantity, PhysicalQuantity>) new RtoPqPqElementParser().parse(null, node, null).getBareValue();
        assertNotNull("ratio", ratio);
        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator().getQuantity());
        assertEquals("numerator unit", MILLIGRAM, ratio.getNumerator().getUnit());
        assertEquals("denominator", new BigDecimal("2345.67"), ratio.getDenominator().getQuantity());
        assertEquals("denominator unit", MILLILITRE.getCodeValue(), ratio.getDenominator().getUnit().getCodeValue());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something><numerator value=\"monkey\" /><denominator value=\"2345.67\" /></something>");
		try {
			new RtoPqPqElementParser().parse(null, node, null);
			fail("expected exception");
			
		} catch (NumberFormatException e) {
			// expected
		}
	}
}
