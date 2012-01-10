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

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class RatioMoneyPerUnitXmlParserTest extends AbstractXmlParserTest<RTO<Money, PhysicalQuantity>> {
	
	public RatioMoneyPerUnitXmlParserTest() {
		super(new RatioMoneyPerUnitXmlParser(), "moneyPerUnit", new RTOImpl<Money, PhysicalQuantity>());
	}

	@Test
	public void shouldParseValue() throws Exception {
		RTOImpl<Money, PhysicalQuantity> rto = new RTOImpl<Money, PhysicalQuantity>(new Ratio<Money, PhysicalQuantity>(
				new Money(new BigDecimal("5.3"), Currency.CANADIAN_DOLLAR), 
				new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.DAY)));
		assertEquals(
				 "<moneyPerUnit><money currency=\"CAD\" value=\"5.3\"/><unit unit=\"d\" value=\"10\"/></moneyPerUnit>",
				 this.parser.parse(createContext(), rto));
	}

	@Override
	protected RTO<Money, PhysicalQuantity> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		RTOImpl<Money, PhysicalQuantity> rto = new RTOImpl<Money, PhysicalQuantity>();
		rto.setNullFlavor(nullFlavor);
		return rto;
	}

}
