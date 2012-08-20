/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class PhysicalQuantityIntervalXmlParserTest extends AbstractXmlParserTest<IVL<PQ,Interval<PhysicalQuantity>>> {
	
	@DataPoint public static final IvlAndExpectedXml XML_LOW_HIGH = new IvlAndExpectedXml(
			createIvlLowHigh(
					new PhysicalQuantity(new BigDecimal("5"), UnitsOfMeasureCaseSensitive.MILLIGRAM), 
					new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.MILLIGRAM), 
					StandardDataType.IVL_PQ), 
					"<interval><from unit=\"mg\" value=\"5\"/><to unit=\"mg\" value=\"10\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_LOW = new IvlAndExpectedXml(
			createIvlLow(new PhysicalQuantity(new BigDecimal("5"), UnitsOfMeasureCaseSensitive.MILLIGRAM), StandardDataType.IVL_PQ), 
			"<interval><from unit=\"mg\" value=\"5\"/></interval>");

	@DataPoint public static final IvlAndExpectedXml XML_HIGH = new IvlAndExpectedXml(
			createIvlHigh(new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.MILLIGRAM), StandardDataType.IVL_PQ),
			"<interval><to unit=\"mg\" value=\"10\"/></interval>");

	public PhysicalQuantityIntervalXmlParserTest() {
		super(new PhysicalQuantityIntervalXmlParser(), "interval", new IVLImpl<PQ, Interval<PhysicalQuantity>>());
	}
	
	@Theory
	public void shouldParseValue(IvlAndExpectedXml ivlAndXml) throws Exception {
		 assertEquals(ivlAndXml.expectedXml, this.parser.parse(createContext(), ivlAndXml.ivl));
	}
	
	static class IvlAndExpectedXml {
		private final IVL<PQ, Interval<PhysicalQuantity>> ivl;
		private final String expectedXml;
		public IvlAndExpectedXml(IVL<PQ, Interval<PhysicalQuantity>> ivl, String expectedXml) {
			this.ivl = ivl;
			this.expectedXml = expectedXml;
		}
		public IVL<PQ, Interval<PhysicalQuantity>> getIvl() { 
			return this.ivl;
		}
		public String getExpectedXml() {
			return this.expectedXml;
		}
	}

	private static IVL<PQ, Interval<PhysicalQuantity>> createIvlLowHigh(PhysicalQuantity low, PhysicalQuantity high, StandardDataType dataType) {
		return createIvl(dataType, IntervalFactory.createLowHigh(low, high));
	}

	private static IVL<PQ, Interval<PhysicalQuantity>> createIvl(StandardDataType dataType, Interval<PhysicalQuantity> interval) {
		IVLImpl<PQ, Interval<PhysicalQuantity>> ivl = new IVLImpl<PQ, Interval<PhysicalQuantity>>(interval);
		ivl.setDataType(dataType);
		return ivl;
	}

	private static IVL<PQ, Interval<PhysicalQuantity>> createIvlLow(PhysicalQuantity low, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createLow(low));
	}

	private static IVL<PQ, Interval<PhysicalQuantity>> createIvlHigh(PhysicalQuantity high, StandardDataType dataType) {
		return createIvl(dataType,  IntervalFactory.createHigh(high));
	}

	@Override
	protected IVL<PQ, Interval<PhysicalQuantity>> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		IVLImpl<PQ, Interval<PhysicalQuantity>> ivl = new IVLImpl<PQ, Interval<PhysicalQuantity>>();
		ivl.setNullFlavor(nullFlavor);
		return ivl;
	}

}
