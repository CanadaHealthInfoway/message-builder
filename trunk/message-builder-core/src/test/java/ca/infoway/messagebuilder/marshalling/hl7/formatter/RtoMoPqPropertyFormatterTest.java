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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-08-20 19:01:34 -0400 (Mon, 20 Aug 2012) $
 * Revision:      $LastChangedRevision: 6032 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;


import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class RtoMoPqPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
        Ratio<Money, PhysicalQuantity> ratio = new Ratio<Money, PhysicalQuantity> ();
        ratio.setNumerator(new Money(new BigDecimal("1.00"), Currency.CANADIAN_DOLLAR));
        ratio.setDenominator(new PhysicalQuantity(new BigDecimal("10.00"), MILLILITRE));
        
		String result = new RtoMoPqPropertyFormatter().format(getContext("name", "RTO<MO.CAD,PQ.BASIC>"), new RTOImpl<Money, PhysicalQuantity>(ratio));
		assertXml("result", "<name><numerator currency=\"CAD\" value=\"1.00\"/><denominator unit=\"ml\" value=\"10.00\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoMoPqPropertyFormatter().format(getContext("name", "RTO<MO.CAD,PQ.BASIC>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
}
