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
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class MoR2ElementParserTest extends MarshallingTestCase {

	private XmlToModelResult result;
	
	@Override
	@Before
	public void setUp() throws Exception {
		this.result = new XmlToModelResult();
	}
	
	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		MO mo = (MO) new MoR2ElementParser().parse(createContext(), node, null);
		assertNull("null result", mo.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, mo.getNullFlavor());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("MO", Money.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null);
	}
	
	private ParseContext createContextSxcm() {
		return ParserContextImpl.create("SXCM<MO>", Money.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null);
	}
	
	@Test
	public void testParseNullNodeWithExtraInfo() throws Exception {
		
		// the schema says this should fail, but MB short circuits processing when a NF is detected
		
		Node node = createNode("<something nullFlavor=\"NA\" value=\"11.33\"/>");
		MO mo = (MO) new MoR2ElementParser().parse(createContext(), node, null);
		assertNull("null result", mo.getValue());
		assertEquals("null flavor", NullFlavor.NOT_APPLICABLE, mo.getNullFlavor());
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		MO mo = (MO) new MoR2ElementParser().parse(createContext(), node, result);
		// according to the R2 schemas, this is a perfectly valid state
		assertTrue("result", this.result.isValid());
		assertNull(mo.getBareValue());
	}

	@Test
	public void testParseNoCurrencyAttributeNode() throws Exception {
		Node node = createNode("<something value=\"12.34\" notcurrency=\"CAD\" />");
		Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertTrue("result", this.result.isValid());
        assertResultAsExpected(parseResult, new BigDecimal("12.34"), null);
	}
	
	@Test
	public void testParseValidTwoAttributes() throws Exception {
		Node node = createNode("<something value=\"12.00\" currency=\"CAD\" />");
		Money result = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertTrue("result", this.result.isValid());
		assertResultAsExpected(result, new BigDecimal("12.00"), Currency.CANADIAN_DOLLAR);
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorNotAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"12.00\" currency=\"CAD\" />");
		BareANY intAny = new MoR2ElementParser().parse(createContext(), node, this.result);
		assertEquals("correct value returned", new Money(new BigDecimal(12.00), Currency.CANADIAN_DOLLAR), intAny.getBareValue());
		assertNull("no operator", ((ANYMetaData) intAny).getOperator());
		assertFalse(this.result.isValid());
		assertEquals("1 error expected", 1, this.result.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"12.00\" currency=\"CAD\" />");
		BareANY intAny = new MoR2ElementParser().parse(createContextSxcm(), node, this.result);
		assertEquals("correct value returned", new Money(new BigDecimal(12.00), Currency.CANADIAN_DOLLAR), intAny.getBareValue());
		assertTrue("no errors", this.result.isValid());
		assertEquals("operator", SetOperator.PERIODIC_HULL, ((ANYMetaData) intAny).getOperator());
	}
	
	@Test
	public void testParseValueAttributeValidWithDefaultOperator() throws Exception {
		Node node = createNode("<something value=\"12.00\" currency=\"CAD\" />");
		BareANY intAny = new MoR2ElementParser().parse(createContextSxcm(), node, this.result);
		assertEquals("correct value returned", new Money(new BigDecimal(12.00), Currency.CANADIAN_DOLLAR), intAny.getBareValue());
		assertTrue("no errors", this.result.isValid());
		assertEquals("operator", SetOperator.INCLUDE, ((ANYMetaData) intAny).getOperator());
	}

	@Test
	public void testParseValidTwoAttributesMaxDigits() throws Exception {
		Node node = createNode("<something value=\"12345678901.12\" currency=\"CAD\" />");
		Money result = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertTrue("result", this.result.isValid());
		assertResultAsExpected(result, new BigDecimal("12345678901.12"), Currency.CANADIAN_DOLLAR);
	}
	
	@Test
	public void testParseValidTwoAttributesDifferentOrder() throws Exception {
        Node node = createNode("<something currency=\"CAD\" value=\"12\" />");
        Money result = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertTrue("result", this.result.isValid());
        assertResultAsExpected(result, new BigDecimal("12"), Currency.CANADIAN_DOLLAR);
	}
	
	@Test
    public void testParseValidTwoAttributesPlusExtra() throws Exception {
        Node node = createNode("<something value=\".4\" currency=\"CAD\" something=\"monkey\" />");
        Money result = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertTrue("result", this.result.isValid());
        assertResultAsExpected(result, new BigDecimal(".4"), Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseInvalidValue() throws Exception {
        Node node = createNode("<something value=\"12.00X\" currency=\"CAD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
        assertResultAsExpected(parseResult, null, Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseMissingValue() throws Exception {
        Node node = createNode("<something value=\"\" currency=\"CAD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
        assertResultAsExpected(parseResult, null, Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseValueManyDigits() throws Exception {
        Node node = createNode("<something value=\"123456789012.123\" currency=\"CAD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertTrue(this.result.isValid());
        assertResultAsExpected(parseResult, new BigDecimal("123456789012.123"), Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseInvalidValueNotAllDigitsBeforeDecimal() throws Exception {
        Node node = createNode("<something value=\"0x12\" currency=\"CAD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertFalse(this.result.isValid()); // not all digits; not a number (the first error does not occur for .NET)
        assertResultAsExpected(parseResult, null, Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseInvalidValueNotAllDigitsAfterDecimal() throws Exception {
        Node node = createNode("<something value=\"1122.1a\" currency=\"CAD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
        assertFalse(this.result.isValid());
        assertEquals(1, this.result.getHl7Errors().size()); // not all digits; not a number
        assertResultAsExpected(parseResult, null, Currency.CANADIAN_DOLLAR);
    }
    
	@Test
    public void testParseInvalidCurrency() throws Exception {
        Node node = createNode("<something value=\"12.00\" currency=\"XXX\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertFalse("result", result.isValid());
        assertEquals(1, this.result.getHl7Errors().size());
        assertResultAsExpected(parseResult, new BigDecimal("12.00"), null);
    }
    
	@Test
    public void testParseUnallowedCurrency() throws Exception {
        Node node = createNode("<something value=\"123.0\" currency=\"USD\" />");
        Money parseResult = (Money) new MoR2ElementParser().parse(createContext(), node, this.result).getBareValue();
		assertTrue("result", result.isValid());
        assertResultAsExpected(parseResult, new BigDecimal("123.0"), Currency.US_DOLLAR);
    }
    
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new MoR2ElementParser().parse(createContext(), node, this.result);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected MO node to have no children", e.getMessage());
		}
	}
	
	private void assertResultAsExpected(Money result, BigDecimal value, Currency currency) {
		assertNotNull("populated result returned", result);
		
		if (result.getAmount() == null) {
			assertNull("value", result.getAmount());
		} else {
			assertEquals("value", value, result.getAmount());
		}
		if (result.getCurrency() == null) {
			assertNull("currency", result.getCurrency());
		} else {
	        assertEquals("currency", currency, result.getCurrency());
		}
	}
}