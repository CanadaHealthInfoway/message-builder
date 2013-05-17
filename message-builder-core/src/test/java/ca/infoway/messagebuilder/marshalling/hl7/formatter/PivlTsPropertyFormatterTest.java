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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeSk;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.DefaultTimeUnit;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class PivlTsPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasicCase() throws Exception {
		
		PhysicalQuantity quantity = new PhysicalQuantity(new BigDecimal(1), DefaultTimeUnit.DAY);
		PeriodicIntervalTime frequency = PeriodicIntervalTime.createFrequency(3, quantity);
		
		String result = new PivlTsPropertyFormatter().format(getContext("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl(frequency));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval><frequency><numerator value=\"3\"/><denominator unit=\"d\" value=\"1\"/></frequency></periodicInterval>", result);
	}
	
	@Test
	public void testBasicCaseForSk() throws Exception {
		
		PhysicalQuantity lowQuantity = new PhysicalQuantity(new BigDecimal(1), DefaultTimeUnit.DAY);
		PhysicalQuantity highQuantity = new PhysicalQuantity(new BigDecimal(4), DefaultTimeUnit.DAY);
		PeriodicIntervalTimeSk frequencySk = PeriodicIntervalTimeSk.createFrequencySk(3, lowQuantity, highQuantity);
		
		String result = new PivlTsPropertyFormatter().format(getContextSk("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl(frequencySk));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval><frequency><numerator value=\"3\"/><denominator><low unit=\"d\" value=\"1\"/><high unit=\"d\" value=\"4\"/></denominator></frequency></periodicInterval>", result);
	}
	
	protected FormatContext getContextSk(String name, String type) {
		return new FormatContextImpl(this.result, null, name, type, null, null, false, SpecificationVersion.V01R04_2_SK, null, null, null);
	}

	@Test
	public void testNoObject() throws Exception {
		
		String result = new PivlTsPropertyFormatter().format(getContext("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl((PeriodicIntervalTime) null));
		
		assertTrue(this.result.isValid());
		assertXml("result", "<periodicInterval nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testMissingValues() throws Exception {
		
		PeriodicIntervalTime frequency = PeriodicIntervalTime.createFrequency(null, null);
		
		String result = new PivlTsPropertyFormatter().format(getContext("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl(frequency));
		
		assertXml("result", "<periodicInterval></periodicInterval>", result);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
	}
	
	@Test
	public void testMissingValuesSk() throws Exception {
		
		PeriodicIntervalTimeSk frequencySk = PeriodicIntervalTimeSk.createFrequencySk(null, null, null);
		
		String result = new PivlTsPropertyFormatter().format(getContextSk("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl(frequencySk));
		
		assertXml("result", "<periodicInterval></periodicInterval>", result);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
	}
	
	@Test
	public void testMissingQuantitiesSk() throws Exception {
		
		PeriodicIntervalTimeSk frequencySk = PeriodicIntervalTimeSk.createFrequencySk(2, null, null);
		
		String result = new PivlTsPropertyFormatter().format(getContextSk("periodicInterval", "PIVL<TS.DATETIME>"), new PIVLImpl(frequencySk));
		
		assertXml("result", "<periodicInterval></periodicInterval>", result);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
	}
	
}
