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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-08-28 18:38:55 -0400 (Tue, 28 Aug 2012) $
 * Revision:      $LastChangedRevision: 6038 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.PIVL_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.CalendarCycle;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class PivlTsR2PropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testFullPivl() throws Exception {
		Date lowDate = DateUtil.getDate(1999, 0, 23);
		Date lowDateWithPattern = new DateWithPattern(lowDate, "yyyyMMdd");
		Date highDate = DateUtil.getDate(2013, 4, 7);
		Date highDateWithPattern = new DateWithPattern(highDate, "yyyyMMdd");
		Interval<Date> phase = IntervalFactory.createLowHigh(lowDateWithPattern, highDateWithPattern);

		PhysicalQuantity period = new PhysicalQuantity(new BigDecimal(11), DefaultTimeUnit.DAY);
		
		PeriodicIntervalTimeR2 pivl = new PeriodicIntervalTimeR2(phase, period, CalendarCycle.DAY_OF_THE_MONTH, true);
		
		String result = new PivlTsR2PropertyFormatter().format(getContext("periodicInterval", "PIVL<TS>"), new PIVL_R2Impl(pivl));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval alignment=\"D\" institutionSpecified=\"true\"><phase><low value=\"19990123\"/><high value=\"20130507\"/></phase><period unit=\"d\" value=\"11\"/></periodicInterval>", result);
	}
	
	@Test
	public void testNoValue() throws Exception {
		
		String result = new PivlTsR2PropertyFormatter().format(getContext("periodicInterval", "PIVL<TS>"), new PIVL_R2Impl((PeriodicIntervalTimeR2) null));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testNullFlavor() throws Exception {
		
		String result = new PivlTsR2PropertyFormatter().format(getContext("periodicInterval", "PIVL<TS>"), new PIVL_R2Impl(NullFlavor.TEMPORARILY_UNAVAILABLE));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval nullFlavor=\"NAV\"/>", result);
	}
	
	@Test
	public void testMissingValues() throws Exception {
		
		PeriodicIntervalTimeR2 pivl = new PeriodicIntervalTimeR2(null, null);
		
		String result = new PivlTsR2PropertyFormatter().format(getContext("periodicInterval", "PIVL<TS>"), new PIVL_R2Impl(pivl));
		
		// from a strict reading of the schema, this is a perfectly valid PIVL_TS
		assertXml("result", "<periodicInterval></periodicInterval>", result);
		assertTrue(this.result.isValid());
	}
	
}
