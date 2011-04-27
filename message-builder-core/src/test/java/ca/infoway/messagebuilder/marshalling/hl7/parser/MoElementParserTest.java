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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class MoElementParserTest extends MarshallingTestCase {

	private XmlToModelResult result;

	@Override
	@Before
	public void setUp() throws Exception {
		this.result = new XmlToModelResult();
	}
	
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		MO mo = (MO) new MoElementParser().parse(createContext(), node, null);
		assertNull("null result", mo.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, mo.getNullFlavor());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("MO", Money.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}
	
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		new MoElementParser().parse(null, node, result);
		assertFalse("valid", result.isValid());
	}

	@Test
	public void testParseNoCurrencyAttributeNode() throws Exception {
		Node node = createNode("<something value=\"12.34\" notcurrency=\"CAD\" />");
		new MoElementParser().parse(null, node, this.result);
		assertFalse("result", result.isValid());
	}
	
	@Test
	public void testParseValidTwoAttributes() throws Exception {
		Node node = createNode("<something value=\"12.00\" currency=\"CAD\" />");
		Money result = (Money) new MoElementParser().parse(null, node, this.result).getBareValue();
		assertResultAsExpected(result, new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
	}
	
	@Test
	public void testParseValidTwoAttributesDifferentOrder() throws Exception {
        Node node = createNode("<something currency=\"CAD\" value=\"12.00\" />");
        Money result = (Money) new MoElementParser().parse(null, node, this.result).getBareValue();
        assertResultAsExpected(result, new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
	}
	
	@Test
    public void testParseValidTwoAttributesPlusExtra() throws Exception {
        Node node = createNode("<something value=\"12.00\" currency=\"CAD\" something=\"monkey\" />");
        Money result = (Money) new MoElementParser().parse(null, node, this.result).getBareValue();
        assertResultAsExpected(result, new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseInvalidValue() throws Exception {
        Node node = createNode("<something value=\"12.00X\" currency=\"CAD\" />");
        try {
            new MoElementParser().parse(null, node, this.result);
            fail("expected exception");
        } catch (NumberFormatException e) {
            // expected
        }
    }
    
	@Test
    public void testParseInvalidCurrency() throws Exception {
        Node node = createNode("<something value=\"12.00\" currency=\"XXX\" />");
        new MoElementParser().parse(null, node, this.result);
		assertFalse("result", result.isValid());
    }
    
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new MoElementParser().parse(new TrivialContext("MO"), node, this.result);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected MO node to have no children", e.getMessage());
		}
	}
	
	private void assertResultAsExpected(Money result, BigDecimal value, Currency currency) {
		assertNotNull("populated result returned", result);
		
        assertEquals("value", value, result.getAmount());
        assertEquals("currency", currency, result.getCurrency());
	}
}
