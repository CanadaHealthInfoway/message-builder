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
 * Last modified: $LastChangedDate: 2012-01-10 20:33:42 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3315 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;


import java.math.BigDecimal;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Ratio;

public class RtoQtyQtyPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testBasic() throws Exception {
        Ratio<BigDecimal, BigDecimal> ratio = new Ratio<BigDecimal, BigDecimal> ();
        ratio.setNumerator(new BigDecimal("1.00"));
        ratio.setDenominator(new BigDecimal("10.00"));
        
		String result = new RtoQtyQtyPropertyFormatter().format(getContext("name"), 
				new RTOImpl<BigDecimal, BigDecimal>(ratio));
		assertXml("result", "<name><numerator value=\"1.00\" xsi:type=\"QTY\"/><denominator value=\"10.00\" xsi:type=\"QTY\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoQtyQtyPropertyFormatter().format(getContext("name"), 
				new RTOImpl<BigDecimal, BigDecimal>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
}
