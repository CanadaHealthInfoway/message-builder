package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class GtsBoundedPivlPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/>" +
				"<high specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period unit=\"min\" value=\"3\"/></comp></name>", result);
	}

	@Test
	public void testBasicFreq() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.MINUTE)));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/>" +
				"<width unit=\"min\" value=\"3\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator specializationType=\"INT.NONNEG\" value=\"3\" xsi:type=\"INT\"/>" +
				"<denominator specializationType=\"PQ.TIME\" unit=\"min\" value=\"3\" xsi:type=\"PQ\"/>" +
				"</frequency></comp></name>", result);
	}
	
	@Test
	public void testBasicPeriodPhase() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/>" +
				"<high specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}

	@Test
	public void testBasicPhase() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/>" +
				"<high specializationType=\"TS.FULLDATE\" value=\"19691231\" xsi:type=\"TS\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
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
