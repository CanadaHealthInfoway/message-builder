package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;


public class GtsBoundedPivlElementParserTest extends MarshallingTestCase {

	@Test
	public void shouldParseNullFlavor() throws Exception {
		Node node = createNode("<effectiveTime nullFlavor=\"NI\"></effectiveTime>");
		ParseContext context = ParserContextImpl.create("GTS.BOUNDEDPIVL", GeneralTimingSpecification.class, V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY);
		GTS gts = (GTS) new GtsBoundedPivlElementParser().parse(context, node, this.xmlJavaResult);
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, gts.getNullFlavor());
	}
	
	@Test
	public void shouldParseValidInformation() throws Exception {
		Node node = createNode("<effectiveTime>" +
				"  <comp operator=\"I\">" +
				"    <low specializationType=\"TS.FULLDATE\" value=\"20050803\"/>" +
				"    <width specializationType=\"TS.FULLDATE\" value=\"3\" unit=\"wk\"/>" +
				"  </comp>" +
				"  <comp>" +
				"    <frequency>" +
				"      <numerator specializationType=\"INT.NONNEG\" value=\"3\"/>" +
				"      <denominator specializationType=\"PQ.TIME\" value=\"1\" unit=\"d\"/>" +
				"    </frequency>" +
				"  </comp>" +
				"</effectiveTime>");
		ParseContext context = ParserContextImpl.create("GTS.BOUNDEDPIVL", GeneralTimingSpecification.class, V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY);
		GeneralTimingSpecification result = (GeneralTimingSpecification) new GtsBoundedPivlElementParser().parse(context, node, this.xmlJavaResult).getBareValue();
		
		assertNotNull("result", result);
		
		assertEquals("interval width value", new BigDecimal("3"), ((DateDiff) result.getDuration().getWidth()).getValueAsPhysicalQuantity().getQuantity());
		assertEquals("interval width unit", "wk", ((DateDiff) result.getDuration().getWidth()).getUnit().getCodeValue());
		
		assertEquals("frequency times", new Integer(3), result.getFrequency().getRepetitions());
		assertEquals("frequency period value", new BigDecimal("1"), result.getFrequency().getQuantity().getQuantity());
		assertEquals("frequency period unit", "d", result.getFrequency().getQuantity().getUnit().getCodeValue());
	}
	
	@Test
	public void shouldDetectIncorrectElementType() throws Exception {
		Node node = createNode("<effectiveTime>" +
				"  <comp operator=\"I\">" +
				"    <low specializationType=\"TS.FULLDATE\" value=\"20050803\"/>" +
				"    <width specializationType=\"TS.FULLDATE\" value=\"3\" unit=\"wk\"/>" +
				"  </comp>" +
				"  <fred>" +
				"    <frequency>" +
				"      <numerator specializationType=\"INT.NONNEG\" value=\"3\"/>" +
				"      <denominator specializationType=\"PQ.TIME\" value=\"1\" unit=\"d\"/>" +
				"    </frequency>" +
				"  </fred>" +
				"</effectiveTime>");
		ParseContext context = ParserContextImpl.create("GTS.BOUNDEDPIVL", GeneralTimingSpecification.class, V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY);
		new GtsBoundedPivlElementParser().parse(context, node, this.xmlJavaResult);
		
		assertFalse("valid", this.xmlJavaResult.isValid());
	}
}
