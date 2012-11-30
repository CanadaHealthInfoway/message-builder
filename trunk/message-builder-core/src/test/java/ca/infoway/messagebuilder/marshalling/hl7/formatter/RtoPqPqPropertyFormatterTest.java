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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class RtoPqPqPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity> ();
        ratio.setNumerator(new PhysicalQuantity(new BigDecimal("1.00"), MILLIGRAM));
        ratio.setDenominator(new PhysicalQuantity(new BigDecimal("10.00"), MILLILITRE));
        
		String result = new RtoPqPqPropertyFormatter().format(getContext("name", "RTO<PQ.DRUG,PQ.DRUG>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(ratio));
		assertXml("result", "<name><numerator unit=\"mg\" value=\"1.00\"/><denominator unit=\"ml\" value=\"10.00\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoPqPqPropertyFormatter().format(getContext("name", "RTO<PQ.DRUG,PQ.TIME>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testInvalidNullCase() throws Exception {
		String result = new RtoPqPqPropertyFormatter().format(getContext("name", "RTO<PQ.DRUG,PQ.TIME>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(new Ratio<PhysicalQuantity, PhysicalQuantity>()));
		assertNotNull(result);
		assertFalse(this.result.isValid());
		assertEquals(3, this.result.getHl7Errors().size()); // mandatory fields missing x 2, rto has no value
	}
}
