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

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class PhysicalQuantityUncertainRangeXmlParserTest extends AbstractXmlParserTest<URG<PQ, PhysicalQuantity>> {
	
	@DataPoint public static final UrgAndExpectedXml XML_LOW_HIGH = new UrgAndExpectedXml(
			createIvlLowHigh(
					new PhysicalQuantity(new BigDecimal("5"), UnitsOfMeasureCaseSensitive.MILLIGRAM), 
					new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.MILLIGRAM), 
					StandardDataType.IVL_PQ), 
					"<range><from unit=\"mg\" value=\"5\"/><to unit=\"mg\" value=\"10\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_LOW = new UrgAndExpectedXml(
			createIvlLow(new PhysicalQuantity(new BigDecimal("5"), UnitsOfMeasureCaseSensitive.MILLIGRAM), StandardDataType.IVL_PQ), 
			"<range><from unit=\"mg\" value=\"5\"/></range>");

	@DataPoint public static final UrgAndExpectedXml XML_HIGH = new UrgAndExpectedXml(
			createIvlHigh(new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.MILLIGRAM), StandardDataType.IVL_PQ),
			"<range><to unit=\"mg\" value=\"10\"/></range>");

	public PhysicalQuantityUncertainRangeXmlParserTest() {
		super(new PhysicalQuantityUncertainRangeXmlParser(), "range", new URGImpl<PQ, PhysicalQuantity>());
	}
	
	@Theory
	public void shouldParseValue(UrgAndExpectedXml ivlAndXml) throws Exception {
		 assertEquals(ivlAndXml.expectedXml, this.parser.parse(createContext(), ivlAndXml.urg));
	}
	
	static class UrgAndExpectedXml {
		private final URG<PQ, PhysicalQuantity> urg;
		private final String expectedXml;
		public UrgAndExpectedXml(URG<PQ, PhysicalQuantity> urg, String expectedXml) {
			this.urg = urg;
			this.expectedXml = expectedXml;
		}
		public URG<PQ, PhysicalQuantity> getUrg() { 
			return this.urg;
		}
		public String getExpectedXml() {
			return this.expectedXml;
		}
	}

	private static URG<PQ, PhysicalQuantity> createIvlLowHigh(PhysicalQuantity low, PhysicalQuantity high, StandardDataType dataType) {
		return createUrg(dataType, UncertainRange.createLowHigh(low, high));
	}

	private static URG<PQ, PhysicalQuantity> createUrg(StandardDataType dataType, UncertainRange<PhysicalQuantity> range) {
		URGImpl<PQ, PhysicalQuantity> urg = new URGImpl<PQ, PhysicalQuantity>(range);
		urg.setDataType(dataType);
		return urg;
	}

	private static URG<PQ, PhysicalQuantity> createIvlLow(PhysicalQuantity low, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createLow(low));
	}

	private static URG<PQ, PhysicalQuantity> createIvlHigh(PhysicalQuantity high, StandardDataType dataType) {
		return createUrg(dataType,  UncertainRange.createHigh(high));
	}

	@Override
	protected URG<PQ, PhysicalQuantity> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		URGImpl<PQ, PhysicalQuantity> ivl = new URGImpl<PQ, PhysicalQuantity>();
		ivl.setNullFlavor(nullFlavor);
		return ivl;
	}

}
