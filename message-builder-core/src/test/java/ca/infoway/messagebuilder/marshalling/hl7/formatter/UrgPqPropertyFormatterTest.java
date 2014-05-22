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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.datatype.lang.util.UncertainRangeFactory;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class UrgPqPropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testBasic() throws Exception {
		UncertainRange<PhysicalQuantity> urg = UncertainRangeFactory.createLowHigh(createQuantity("55", CeRxDomainTestValues.MILLIMETER), createQuantity("60", CeRxDomainTestValues.MILLIMETER));
		urg.setHighInclusive(true);
		urg.setLowInclusive(false);
		
		String result = new UrgPqPropertyFormatter().format(getContext("name", "URG<PQ.BASIC>"), new URGImpl<PQ, PhysicalQuantity>(urg));
		
		assertXml("result", "<name><low inclusive=\"false\" unit=\"mm\" value=\"55\"/><high inclusive=\"true\" unit=\"mm\" value=\"60\"/></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testBasicForBC() throws Exception {
		UncertainRange<PhysicalQuantity> urg = new UncertainRange<PhysicalQuantity>(
				new PhysicalQuantity(new BigDecimal(1), null), new PhysicalQuantity(new BigDecimal(124), ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.GRAMS_PER_LITRE), null, null, Representation.LOW_HIGH, NullFlavor.NO_INFORMATION, null, null, true, false); 
		
		URGImpl<PQ, PhysicalQuantity> dataType = new URGImpl<PQ, PhysicalQuantity>(urg);
		dataType.setOriginalText("<124");
		
		String result = new UrgPqPropertyFormatter().format(getContext("name", "URG<PQ.LAB>", SpecificationVersion.V02R04_BC), dataType);
		
		assertXml("result", "<name><originalText>&lt;124</originalText><low inclusive=\"true\" nullFlavor=\"NI\" value=\"1\"/><high inclusive=\"false\" unit=\"g/L\" value=\"124\"/></name>", result);
		assertTrue(this.result.isValid());
	}

	@Test
	public void testNullCase() throws Exception {
		String result = new UrgPqPropertyFormatter().format(getContext("name", "URG<PQ.BASIC>"), new URGImpl<PQ, PhysicalQuantity>());
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	private PhysicalQuantity createQuantity(String quantity, UnitsOfMeasureCaseSensitive unit) {
		return new PhysicalQuantity(new BigDecimal(quantity), unit);
	}
}
