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
 * Last modified: $LastChangedDate: 2012-08-23 17:52:18 -0400 (Thu, 23 Aug 2012) $
 * Revision:      $LastChangedRevision: 6035 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive.MILLILITRE;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.basic.Currency;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RtoMoPqElementParserTest extends CeRxDomainValueTestCase {

	@SuppressWarnings("unchecked")
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		RTO<Money, PhysicalQuantity> rto = (RTO<Money, PhysicalQuantity>) new RtoMoPqElementParser().parse(createContext(), node, null);
		
		assertNull("value", rto.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, rto.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParseContextImpl.create("RTO<PQ.DRUG,PQ.DRUG>", Ratio.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        Ratio<Money, PhysicalQuantity> ratio = (Ratio<Money, PhysicalQuantity>) new RtoMoPqElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertNotNull("ratio", ratio);
		assertNull("numerator", ratio.getNumerator());
		assertNull("denominator", ratio.getDenominator());
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something><numerator value=\"1234.45\" currency=\"CAD\"/><denominator value=\"2345.67\" unit=\"mL\" /></something>");
        Ratio<Money, PhysicalQuantity> ratio = (Ratio<Money, PhysicalQuantity>) new RtoMoPqElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertNotNull("ratio", ratio);
        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator().getAmount());
        assertEquals("numerator unit", Currency.CANADIAN_DOLLAR.getCodeValue(), ratio.getNumerator().getCurrency().getCodeValue());
        assertEquals("denominator", new BigDecimal("2345.67"), ratio.getDenominator().getQuantity());
        assertEquals("denominator unit", MILLILITRE.getCodeValue(), ratio.getDenominator().getUnit().getCodeValue());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something><numerator value=\"monkey\" /><denominator value=\"2345.67\" /></something>");
		new RtoMoPqElementParser().parse(createContext(), node, this.xmlResult);
		assertEquals(2, this.xmlResult.getHl7Errors().size()); // no currency; monkey is invalid value
	}
}
