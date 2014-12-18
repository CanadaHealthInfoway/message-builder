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
 * Last modified: $LastChangedDate: 2013-09-06 10:36:09 -0400 (Fri, 06 Sep 2013) $
 * Revision:      $LastChangedRevision: 7861 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.EIVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.EventRelatedPeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.TimingEvent;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class EivlTsR2PropertyFormatterTest extends FormatterTestCase {

	@After
	public void teardown() {
		this.result.clearErrors();
	}
	
	private FormatContextImpl createContext(String type) {
		return new FormatContextImpl(this.result, null, "eventRelatedPeriod", type, null, null, false, SpecificationVersion.R02_04_03, null, null, null, false);
	}

	@Test
	public void testImpliedNullValue() throws Exception {
		String result = new EivlTsR2PropertyFormatter().format(createContext("EIVL<TS>"), new TELImpl());

		assertTrue(this.result.isValid());
		assertXml("xml output", "<eventRelatedPeriod nullFlavor=\"NI\"/>", result);
	}

	@Test
	public void testNullValue() throws Exception {
		String result = new EivlTsR2PropertyFormatter().format(createContext("EIVL<TS>"), new TELImpl(NullFlavor.NOT_APPLICABLE));

		assertTrue(this.result.isValid());
		assertXml("xml output", "<eventRelatedPeriod nullFlavor=\"NA\"/>", result);
	}

	@Test
	public void testEivlTsFull() throws Exception {
		PhysicalQuantity low = new PhysicalQuantity(new BigDecimal("120"), UnitsOfMeasureCaseSensitive.CENTIMETRE);
		PhysicalQuantity high = new PhysicalQuantity(new BigDecimal("170"), UnitsOfMeasureCaseSensitive.CENTIMETRE);
		Interval<PhysicalQuantity> ivl = IntervalFactory.createLowHigh(low, high);
		TimingEvent timingEvent = ca.infoway.messagebuilder.domainvalue.basic.TimingEvent.ACM;
		EventRelatedPeriodicIntervalTime event = new EventRelatedPeriodicIntervalTime(ivl, timingEvent);
		String result = new EivlTsR2PropertyFormatter().format(createContext("EIVL<TS>"), new EIVLImpl<EventRelatedPeriodicIntervalTime>(event));
		
		assertTrue(this.result.isValid());
		assertXml("xml output", "<eventRelatedPeriod><event code=\"ACM\" codeSystem=\"2.16.840.1.113883.5.139\" codeSystemName=\"TimingEvent\"/><offset><low unit=\"cm\" value=\"120\"/><high unit=\"cm\" value=\"170\"/></offset></eventRelatedPeriod>", result, true);
	}

}
