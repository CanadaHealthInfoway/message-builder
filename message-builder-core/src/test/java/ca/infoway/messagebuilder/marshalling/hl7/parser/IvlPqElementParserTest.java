package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

public class IvlPqElementParserTest extends CeRxDomainValueTestCase {

	private static final String mL = UnitsOfMeasureCaseSensitive.MILLILITRE.getCodeValue();
	private XmlToModelResult result;
	private IvlPqElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlPqElementParser();
	}
	
	private Interval<PhysicalQuantity> parse(Node node) throws XmlToModelTransformationException {
		return (Interval<PhysicalQuantity>) this.parser.parse(
				ParserContextImpl.create("IVL<PQ>", Interval.class, V02R02.getVersionLiteral(), null), 
				Arrays.asList(node), 
				this.result).getBareValue();
	}
	
	@Test
	public void testParseLowHigh() throws Exception {
		Node node = createNode("<name><low unit=\"ml\" value=\"1000\"/><high unit=\"ml\" value=\"2000\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
		assertNotNull("null", interval);
		assertEquals("low - value", 1000, interval.getLow().getQuantity().intValue());
		assertEquals("low - unit", mL, interval.getLow().getUnit().getCodeValue());
		assertEquals("high - value", 2000, interval.getHigh().getQuantity().intValue());
		assertEquals("high - unit", mL, interval.getHigh().getUnit().getCodeValue());
		assertEquals("centre - value", 1500, interval.getCentre().getQuantity().intValue());
		assertEquals("centre - unit", mL, interval.getCentre().getUnit().getCodeValue());
		assertEquals("width - value", 1000, interval.getWidth().getValue().getQuantity().intValue());
		assertEquals("width - unit", mL, interval.getWidth().getValue().getUnit().getCodeValue());
	}

	@Test
	public void testParseLowWidth() throws Exception {
		Node node = createNode("<name><low unit=\"ml\" value=\"1000\"/><width unit=\"ml\" value=\"1000\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
        assertNotNull("null", interval);
		assertEquals("low - value", 1000, interval.getLow().getQuantity().intValue());
		assertEquals("low - unit", mL, interval.getLow().getUnit().getCodeValue());
		assertEquals("high - value", 2000, interval.getHigh().getQuantity().intValue());
		assertEquals("high - unit", mL, interval.getHigh().getUnit().getCodeValue());
		assertEquals("centre - value", 1500, interval.getCentre().getQuantity().intValue());
		assertEquals("centre - unit", mL, interval.getCentre().getUnit().getCodeValue());
		assertEquals("width - value", 1000, interval.getWidth().getValue().getQuantity().intValue());
		assertEquals("width - unit", mL, interval.getWidth().getValue().getUnit().getCodeValue());
    }

	@Test
	public void testParseLow() throws Exception {
		Node node = createNode("<name><low unit=\"ml\" value=\"1000\"/></name>");
		Interval<PhysicalQuantity> interval = parse(node);
		assertNotNull("null", interval);
		assertEquals("low - value", 1000, interval.getLow().getQuantity().intValue());
		assertEquals("low - unit", mL, interval.getLow().getUnit().getCodeValue());
		assertNull("high", interval.getHigh());
		assertNull("centre", interval.getCentre());
		assertNull("width", interval.getWidth());
	}
}
