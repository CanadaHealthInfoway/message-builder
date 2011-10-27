/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.DefaultTimeUnit;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeSk;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class GtsBoundedPivlFormatterTest extends FormatterTestCase {
	
	@Before
	public void setup() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-6:00"));
	}
	
	@After
	public void teardown() {
		TimeZone.setDefault(null);
	}

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
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period unit=\"min\" value=\"3\"/></comp></name>", result);
	}

	@Test
	public void testBasicAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.R02_04_02, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period unit=\"min\" value=\"3\"/></comp></name>", result);
	}

	@Test
	public void testBasicAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
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
				"<low value=\"19691231\"/>" +
				"<width unit=\"min\" value=\"3\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator specializationType=\"INT.NONNEG\" value=\"3\" xsi:type=\"INT\"/>" +
				"<denominator specializationType=\"PQ.TIME\" unit=\"min\" value=\"3\" xsi:type=\"PQ\"/>" +
				"</frequency></comp></name>", result);
	}
	
	@Test
	public void testBasicFreqAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.MINUTE)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.R02_04_02, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"min\" value=\"3\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator specializationType=\"INT.NONNEG\" value=\"3\" xsi:type=\"INT\"/>" +
				"<denominator specializationType=\"PQ.TIME\" unit=\"min\" value=\"3\" xsi:type=\"PQ\"/>" +
				"</frequency></comp></name>", result);
	}
	
	@Test
	public void testBasicFreqAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.MINUTE)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"min\" value=\"3\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"3\"/>" +
				"<denominator unit=\"min\" value=\"3\"/>" +
				"</frequency></comp></name>", result);
	}
	
	@Test
	public void testBasicFreqAsCeRxAndSask() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.MINUTE))), 
				PeriodicIntervalTimeSk.createFrequencySk(3, createQuantity("3", DefaultTimeUnit.MINUTE), createQuantity("10", DefaultTimeUnit.MINUTE)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3_SK, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"min\" value=\"3\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"3\"/>" +
		        "<denominator>" +
			    "<low unit=\"min\" value=\"3\"/>" +
			    "<high unit=\"min\" value=\"10\"/>" +
		        "</denominator>" +
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
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}

	@Test
	public void testBasicPeriodPhaseAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.R02_04_02, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}

	@Test
	public void testBasicPeriodPhaseAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
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
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}
	
	@Test
	public void testBasicPhaseAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.R02_04_02, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}
	
	@Test
	public void testBasicPhaseAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, null, null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new UrgPqPropertyFormatter().format(getContext("name"), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testNullCaseAsMR2009() throws Exception {
		String result = new UrgPqPropertyFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.R02_04_02, null, null), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testNullCaseAsCeRx() throws Exception {
		String result = new UrgPqPropertyFormatter().format(new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, null, null), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
	
	@Test
	public void timeZoneHandling() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createFrequency(2, new PhysicalQuantity(BigDecimal.TEN, ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.DAY)));

		
		String result = new GtsBoundedPivlFormatter().format(
				new FormatContextImpl("name", "GTS.BOUNDEDPIVL", null, false, SpecificationVersion.V01R04_3, TimeZone.getTimeZone("GMT-7:00"), null), 
				new GTSImpl(gts));
		System.out.println(result);
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691230\"/>" +
				"<high value=\"19691230\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"2\"/><denominator unit=\"d\" value=\"10\"/></frequency></comp></name>", result);
	}	
}
