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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLTSCDAR1Impl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PivlTsCdaPropertyFormatterTest extends FormatterTestCase {
	
	private PivlTsCdaPropertyFormatter formatter = new PivlTsCdaPropertyFormatter();
	
	@Test
	public void testPivlPhasePeriod() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> phase = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);
		PhysicalQuantity period = new PhysicalQuantity(BigDecimal.ONE, UnitsOfMeasureCaseSensitive.DAY);
		PeriodicIntervalTimeR2 pivl = new PeriodicIntervalTimeR2(phase, period);
		BareANY dataType = new PIVLTSCDAR1Impl(pivl);
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "pivl", "PIVLTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, null, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		String expected = "<pivl><period unit=\"d\" value=\"1\"/><phase><low value=\"20120503\"/><high value=\"20120708\"/></phase></pivl>";
		assertXml("pivl output", expected, xml, true);
	}
	
	@Test
	public void testPivlFrequency() {
		ModelToXmlResult result = new ModelToXmlResult();
		PhysicalQuantity frequencyQuantity = new PhysicalQuantity(BigDecimal.ONE, UnitsOfMeasureCaseSensitive.DAY);
		PeriodicIntervalTimeR2 pivl = new PeriodicIntervalTimeR2(4, frequencyQuantity);
		BareANY dataType = new PIVLTSCDAR1Impl(pivl);
		
		FormatContext formatContext = new FormatContextImpl(
				result, "", "pivl", "PIVLTSCDAR1", null, ConformanceLevel.MANDATORY, Cardinality.create("1"), false, SpecificationVersion.R02_04_03, null, null, null, null, true);
		
		String xml = this.formatter.format(formatContext, dataType);
		
		assertTrue(result.isValid());
		String expected = "<pivl><frequency><numerator value=\"4\"/><denominator unit=\"d\" value=\"1\"/></frequency></pivl>";
		assertXml("pivl output", expected, xml, true);
	}
	
}
