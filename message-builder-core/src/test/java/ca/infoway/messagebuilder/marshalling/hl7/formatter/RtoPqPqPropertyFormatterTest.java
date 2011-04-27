/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;


import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.datatype.lang.UnitsOfMeasureCaseSensitive.MILLILITRE;

import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;

public class RtoPqPqPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity> ();
        ratio.setNumerator(new PhysicalQuantity(new BigDecimal("1.00"), MILLIGRAM));
        ratio.setDenominator(new PhysicalQuantity(new BigDecimal("10.00"), MILLILITRE));
        
		String result = new RtoPqPqPropertyFormatter().format(getContext("name"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(ratio));
		assertXml("result", "<name><numerator unit=\"mg\" value=\"1.00\" xsi:type=\"PQ\"/><denominator unit=\"ml\" value=\"10.00\" xsi:type=\"PQ\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoQtyQtyPropertyFormatter().format(getContext("name"), new RTOImpl<BigDecimal, BigDecimal>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
}
