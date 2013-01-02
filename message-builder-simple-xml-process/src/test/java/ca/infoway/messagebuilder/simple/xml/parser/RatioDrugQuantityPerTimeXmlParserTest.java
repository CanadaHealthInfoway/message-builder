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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

@RunWith(Theories.class)
public class RatioDrugQuantityPerTimeXmlParserTest extends AbstractXmlParserTest<RTO<PhysicalQuantity, PhysicalQuantity>> {
	
	public RatioDrugQuantityPerTimeXmlParserTest() {
		super(new RatioDrugQuantityPerTimeXmlParser(), "drugOverTime", new RTOImpl<PhysicalQuantity, PhysicalQuantity>());
	}
	
	@Test
	public void shouldParseValue() throws Exception {
		RTOImpl<PhysicalQuantity, PhysicalQuantity> rto = new RTOImpl<PhysicalQuantity, PhysicalQuantity>(new Ratio<PhysicalQuantity, PhysicalQuantity>(
				new PhysicalQuantity(new BigDecimal("5.3"), UnitsOfMeasureCaseSensitive.MILLILITRE), 
				new PhysicalQuantity(new BigDecimal("10"), UnitsOfMeasureCaseSensitive.DAY)));
		assertEquals(
				 "<drugOverTime><drugQuantity unit=\"ml\" value=\"5.3\"/><time unit=\"d\" value=\"10\"/></drugOverTime>",
				 this.parser.parse(createContext(), rto));
	}

	@Override
	protected RTO<PhysicalQuantity, PhysicalQuantity> createAnyWithNullFlavor(NullFlavor nullFlavor) {
		RTOImpl<PhysicalQuantity, PhysicalQuantity> rto = new RTOImpl<PhysicalQuantity, PhysicalQuantity>();
		rto.setNullFlavor(nullFlavor);
		return rto;
	}

}
