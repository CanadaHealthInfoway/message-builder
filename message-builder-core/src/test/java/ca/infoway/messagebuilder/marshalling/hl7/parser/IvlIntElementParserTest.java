 package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

public class IvlIntElementParserTest extends CeRxDomainValueTestCase {

	private XmlToModelResult result;
	private ElementParser parser;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
		this.parser = new IvlIntElementParser();
	}
	
	private Interval<Integer> parse(Node node) throws XmlToModelTransformationException {
		BareANY ivl = this.parser.parse(ParserContextImpl.create("IVL<INT>", Interval.class, SpecificationVersion.V02R02.getVersionLiteral(), null), 
				Arrays.asList(node), 
				this.result);
		return (Interval<Integer>) (ivl.getBareValue());
	}
	
	
	@Test
	public void testParseLowHigh() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" /><high value=\"567\" /></range>");
		Interval<Integer> interval = parse(node);
		assertNotNull("null", interval);
		assertEquals("low", new Integer(123), interval.getLow());
		assertEquals("high", new Integer(567), interval.getHigh());
		assertEquals("centre", new Integer(345), interval.getCentre());
		assertEquals("width", new Integer(567-123), interval.getWidth().getValue());
		assertEquals("representation", Representation.LOW_HIGH, interval.getRepresentation());
	}

	@Test
	public void testParseCentreWidth() throws Exception {
		Node node = createNode(
				"<range><center value=\"15\" /><width value=\"10\" /></range>");
		Interval<Integer> interval = parse(node);
		assertNotNull("null", interval);
		assertEquals("low", new Integer(10), interval.getLow());
		assertEquals("high", new Integer(20), interval.getHigh());
		assertEquals("centre", new Integer(15), interval.getCentre());
		assertEquals("width", new Integer(10), interval.getWidth().getValue());
		assertEquals("representation", Representation.CENTRE_WIDTH, interval.getRepresentation());
	}
	
	@Test
	public void testParseCentreWidthWithRounding() throws Exception {
		Node node = createNode(
		"<range><center value=\"15\" /><width value=\"9\" /></range>");
		Interval<Integer> interval = parse(node);
		assertNotNull("null", interval);
		assertEquals("low", new Integer(11), interval.getLow());
		assertEquals("high", new Integer(20), interval.getHigh());
		assertEquals("centre", new Integer(15), interval.getCentre());
		assertEquals("width", new Integer(9), interval.getWidth().getValue());
		assertEquals("representation", Representation.CENTRE_WIDTH, interval.getRepresentation());
	}
}
