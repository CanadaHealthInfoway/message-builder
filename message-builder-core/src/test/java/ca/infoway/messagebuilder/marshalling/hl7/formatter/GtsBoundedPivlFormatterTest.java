/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeSk;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.TimeZoneUtil;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class GtsBoundedPivlFormatterTest extends FormatterTestCase {
	
	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@After
	public void teardown() {
	}

	@Test
	public void testBasicAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
								"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
									"<low value=\"19691231\"/>" +
									"<high value=\"19691231\"/>" +
								"</comp>" +
								"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
									"<period unit=\"d\" value=\"3\"/>" +
								"</comp>" +
							"</name>",
							result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriod(new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
								"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
									"<low value=\"19691231\"/>" +
									"<high value=\"19691231\"/>" +
								"</comp>" +
								"<comp xsi:type=\"PIVL_TS\">" +
									"<period unit=\"d\" value=\"3\"/>" +
								"</comp>" +
							"</name>",
							result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicFreq() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.DAY)));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"d\" value=\"3\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator specializationType=\"INT.NONNEG\" value=\"3\" xsi:type=\"INT\"/>" +
				"<denominator specializationType=\"PQ.TIME\" unit=\"d\" value=\"3\" xsi:type=\"PQ\"/>" +
				"</frequency></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicFreqAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.DAY)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"d\" value=\"3\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator specializationType=\"INT.NONNEG\" value=\"3\" xsi:type=\"INT\"/>" +
				"<denominator specializationType=\"PQ.TIME\" unit=\"d\" value=\"3\" xsi:type=\"PQ\"/>" +
				"</frequency></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicFreqAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))), 
				PeriodicIntervalTime.createFrequency(3, createQuantity("3", DefaultTimeUnit.DAY)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"d\" value=\"3\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"3\"/>" +
				"<denominator unit=\"d\" value=\"3\"/>" +
				"</frequency></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicFreqAsCeRxAndSask() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowWidth(DateUtil.getDate(1969, 11, 31), new DateDiff(createQuantity("3", DefaultTimeUnit.DAY))), 
				PeriodicIntervalTimeSk.createFrequencySk(3, createQuantity("3", DefaultTimeUnit.DAY), createQuantity("10", DefaultTimeUnit.DAY)));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_2_SK, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<width unit=\"d\" value=\"3\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"3\"/>" +
		        "<denominator>" +
			    "<low unit=\"d\" value=\"3\"/>" +
			    "<high unit=\"d\" value=\"10\"/>" +
		        "</denominator>" +
				"</frequency></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicPeriodPhase() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicPeriodPhaseAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicPeriodPhaseAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)), 
				PeriodicIntervalTime.createPeriodPhase(new DateDiff(new Date(0)), IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<period/><phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicPhase() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(getContext("name"), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicPhaseAsMR2009() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name specializationType=\"GTS.BOUNDEDPIVL\" xsi:type=\"SXPR_TS\">" +
				"<comp specializationType=\"IVL_TS.FULLDATE\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp operator=\"I\" specializationType=\"PIVL_TS.DATETIME\" xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testBasicPhaseAsCeRx() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createPhase(IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31))));
		String result = new GtsBoundedPivlFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691231\"/>" +
				"<high value=\"19691231\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<phase><low value=\"19691231\"/><high value=\"19691231\"/></phase></comp></name>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new UrgPqPropertyFormatter().format(getContext("name"), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testNullCaseAsMR2009() throws Exception {
		String result = new UrgPqPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testNullCaseAsCeRx() throws Exception {
		String result = new UrgPqPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), new URGImpl<PQ, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
		assertTrue(this.result.isValid());
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
	
	@Test
	public void timeZoneHandling() throws Exception {
		GeneralTimingSpecification gts = new GeneralTimingSpecification(
				IntervalFactory.<Date>createLowHigh(DateUtil.getDate(1969, 11, 31), DateUtil.getDate(1969, 11, 31)),  
				PeriodicIntervalTime.createFrequency(2, new PhysicalQuantity(BigDecimal.TEN, ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.DAY)));

		
		String result = new GtsBoundedPivlFormatter().format(
				new FormatContextImpl(this.result, null, "name", "GTS.BOUNDEDPIVL", null, null, false, SpecificationVersion.V01R04_3, TimeZoneUtil.getTimeZone("GMT-7"), null, null, false), 
				new GTSImpl(gts));
		assertXml("result", "<name xsi:type=\"SXPR_TS\">" +
				"<comp operator=\"I\" xsi:type=\"IVL_TS\">" +
				"<low value=\"19691230\"/>" +
				"<high value=\"19691230\"/></comp>" +
				"<comp xsi:type=\"PIVL_TS\">" +
				"<frequency><numerator value=\"2\"/><denominator unit=\"d\" value=\"10\"/></frequency></comp></name>", result);
		assertTrue(this.result.isValid());
	}	
}
