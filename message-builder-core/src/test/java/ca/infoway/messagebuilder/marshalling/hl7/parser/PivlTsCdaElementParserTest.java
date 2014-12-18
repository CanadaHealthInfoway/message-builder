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
 * Last modified: $LastChangedDate: 2014-08-11 11:35:13 -0400 (Mon, 11 Aug 2014) $
 * Revision:      $LastChangedRevision: 8844 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.PIVLTSCDAR1;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PivlTsCdaElementParserTest extends MarshallingTestCase {

	private PivlTsCdaElementParser parser = new PivlTsCdaElementParser();
	
	@Test
	public void testPivlPhasePeriod() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
        Node node = createNode("<pivl><period unit=\"d\" value=\"1\"/><phase><low value=\"20120503\"/><high value=\"20120708\"/></phase></pivl>");
		ParseContext context = ParseContextImpl.create("PIVLTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), null, true);
		
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), result);
		
		PhysicalQuantity expectedPeriod = new PhysicalQuantity(BigDecimal.ONE, UnitsOfMeasureCaseSensitive.DAY);
		Date dateLow = DateUtil.getDate(2012, 4, 3);
		DateWithPattern dateWithPatternLow = new DateWithPattern(dateLow, "yyyyMMdd");
		Date dateHigh = DateUtil.getDate(2012, 6, 8);
		DateWithPattern dateWithPatternHigh = new DateWithPattern(dateHigh, "yyyyMMdd");
		Interval<Date> expectedPhase = IntervalFactory.createLowHigh((Date) dateWithPatternLow, (Date) dateWithPatternHigh);

		assertTrue(result.isValid());
		assertTrue(parseResult instanceof PIVLTSCDAR1);
		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) parseResult.getBareValue();
		assertEquals(expectedPeriod.getQuantity(), pivl.getPeriod().getQuantity());
		assertEquals(expectedPeriod.getUnit().getCodeValue(), pivl.getPeriod().getUnit().getCodeValue());
		assertEquals(expectedPhase, pivl.getPhase());
		assertNull(pivl.getFrequencyRepetitions());
		assertNull(pivl.getFrequencyQuantity());
	}
	
	@Test
	public void testPivlFrequency() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
        Node node = createNode("<pivl><frequency><numerator value=\"4\"/><denominator unit=\"d\" value=\"1\"/></frequency></pivl>");
		ParseContext context = ParseContextImpl.create("PIVLTSCDAR1", null, SpecificationVersion.R02_04_03, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1"), null, true);
		
		BareANY parseResult = this.parser.parse(context, Arrays.asList(node), result);
		
		PhysicalQuantity expectedFrequencyQuantity = new PhysicalQuantity(BigDecimal.ONE, UnitsOfMeasureCaseSensitive.DAY);

		assertTrue(result.isValid());
		assertTrue(parseResult instanceof PIVLTSCDAR1);
		PeriodicIntervalTimeR2 pivl = (PeriodicIntervalTimeR2) parseResult.getBareValue();
		assertEquals(expectedFrequencyQuantity.getQuantity(), pivl.getFrequencyQuantity().getQuantity());
		assertEquals(expectedFrequencyQuantity.getUnit().getCodeValue(), pivl.getFrequencyQuantity().getUnit().getCodeValue());
		assertEquals((Integer) 4, pivl.getFrequencyRepetitions());
		assertNull(pivl.getPeriod());
		assertNull(pivl.getPhase());
	}
}
