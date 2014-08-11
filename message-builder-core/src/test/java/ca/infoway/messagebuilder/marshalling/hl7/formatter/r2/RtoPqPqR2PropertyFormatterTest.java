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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2014-05-22 15:54:32 -0400 (Thu, 22 May 2014) $
 * Revision:      $LastChangedRevision: 8676 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLIGRAM;
import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class RtoPqPqR2PropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
        Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity> ();
        ratio.setNumerator(new PhysicalQuantity(new BigDecimal("1.00"), MILLIGRAM));
        ratio.setDenominator(new PhysicalQuantity(new BigDecimal("10.00"), MILLILITRE));
        
		String result = new RtoPqPqR2PropertyFormatter().format(getContext("name", "RTO<PQ,PQ>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(ratio));
		assertTrue(this.result.isValid());
		assertXml("result", "<name><numerator unit=\"mg\" value=\"1.00\"/><denominator unit=\"mL\" value=\"10.00\"/></name>", result);
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new RtoPqPqR2PropertyFormatter().format(getContext("name", "RTO<PQ,PQ>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>());
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testEmptyCase() throws Exception {
		String result = new RtoPqPqR2PropertyFormatter().format(getContext("name", "RTO<PQ,PQ>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(new Ratio<PhysicalQuantity, PhysicalQuantity>()));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Numerator and denominator must be non-null; both are mandatory for RTO types."));
		assertNotNull(result);
		assertXml("result", "<name></name>", result);
	}
	
	@Test
	public void testInvalidDenominatorZero() throws Exception {
		Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity>();
		ratio.setNumerator(new PhysicalQuantity(new BigDecimal(0), null));
		ratio.setDenominator(new PhysicalQuantity(new BigDecimal(0), null));
		
		String result = new RtoPqPqR2PropertyFormatter().format(getContext("name", "RTO<PQ,PQ>"), new RTOImpl<PhysicalQuantity, PhysicalQuantity>(ratio));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Denominator cannot be zero for RTO types."));
		assertNotNull(result);
		assertXml("result", "<name><numerator value=\"0\"/><denominator value=\"0\"/></name>", result);
	}
}
