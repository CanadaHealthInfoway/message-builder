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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RtoQtyQtyElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		RTO<BigDecimal, BigDecimal> rto = (RTO<BigDecimal, BigDecimal>) new RtoQtyQtyElementParser().parse(createContext(), node, null);
		assertNull("value", rto.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, rto.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("RTO<QTY,QTY>", Ratio.class, SpecificationVersion.NEWFOUNDLAND, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        Ratio<BigDecimal, BigDecimal> ratio = (Ratio<BigDecimal, BigDecimal>) new RtoQtyQtyElementParser().parse(null, node, null).getBareValue();
		assertNotNull("ratio", ratio);
		assertNull("numerator", ratio.getNumerator());
		assertNull("denominator", ratio.getDenominator());
	}

	@Test
	public void testParseValidAttributes() throws Exception {
		Node node = createNode("<something><numerator value=\"1234.45\" /><denominator value=\"2345.67\" /></something>");
        Ratio<BigDecimal, BigDecimal> ratio = (Ratio<BigDecimal, BigDecimal>) new RtoQtyQtyElementParser().parse(null, node, null).getBareValue();
        assertNotNull("ratio", ratio);
        assertEquals("numerator", new BigDecimal("1234.45"), ratio.getNumerator());
        assertEquals("denominator", new BigDecimal("2345.67"), ratio.getDenominator());
	}
	
	@Test
	public void testParseInvalidValueAttribute() throws Exception {
        Node node = createNode("<something><numerator value=\"monkey\" /><denominator value=\"2345.67\" /></something>");
		try {
			new RtoQtyQtyElementParser().parse(null, node, null);
			fail("expected exception");
			
		} catch (NumberFormatException e) {
			// expected
		}
	}
}

