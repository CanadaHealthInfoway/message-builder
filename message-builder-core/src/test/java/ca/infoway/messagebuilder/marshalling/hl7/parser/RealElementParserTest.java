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

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RealElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		REAL real = (REAL) new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertNull("null returned", real.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, real.getNullFlavor());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	private ParseContext createContext(String type) {
		return ParserContextImpl.create(type, BigDecimal.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		REAL real = (REAL) new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertNull("null returned", real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		REAL real = (REAL) new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertNull("null returned", real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidRealConf() throws Exception {
		Node node = createNode("<something value=\"0.2345\" />");
		BareANY real = new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("0.2345"), 
				real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealConfMax() throws Exception {
		Node node = createNode("<something value=\"1.0000\" />");
		BareANY real = new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("1.0000"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealConfMaxNoZeros() throws Exception {
		Node node = createNode("<something value=\"1.\" />");
		BareANY real = new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("1"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealConfMin() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		assertEquals("correct value returned", 
				new BigDecimal(0), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeInvalidRealConfMinLotsOfZeros() throws Exception {
		Node node = createNode("<something value=\"000.0000\" />");
		assertEquals("correct value returned", 
				new BigDecimal("000.0000"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertEquals("1 errors", 1, this.xmlResult.getHl7Errors().size()); // too many chars before decimal
	}
	
	@Test
	public void testParseValueAttributeInvalidRealConfNegative() throws Exception {
		Node node = createNode("<something value=\"-1\" />");
		assertEquals("correct value returned", 
				new BigDecimal("-1"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertEquals("2 errors", 2, this.xmlResult.getHl7Errors().size()); // too many chars before decimal, value less than zero 
	}

	@Test
	public void testParseValueAttributeInvalidRealConfTooLarge() throws Exception {
		Node node = createNode("<something value=\"1.0001\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1.0001"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseValueAttributeValidRealCoordMax() throws Exception {
		Node node = createNode("<something value=\"9999.9999\" />");
		BareANY real = new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("9999.9999"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealCoordMin() throws Exception {
		Node node = createNode("<something value=\"-999.9999\" />");
		BigDecimal bigDecimal = new BigDecimal("-999.9999");
		assertEquals("correct value returned", 
				bigDecimal, 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeInvalidRealCoordTooLarge() throws Exception {
		Node node = createNode("<something value=\"10000\" />");
		BareANY real = new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("10000"), 
				real.getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeInvalidRealCoordTooSmall() throws Exception {
		Node node = createNode("<something value=\"-1000\" />");
		assertEquals("correct value returned", 
				new BigDecimal(-1000), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeInvalidRealCoordMultipleErrors() throws Exception {
		Node node = createNode("<something value=\"10000.00000\" />");
		assertEquals("correct value returned", 
				new BigDecimal("10000.00000"), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertEquals("2 errors", 2, this.xmlResult.getHl7Errors().size()); // too many characters before and after decimal
	}
	
	@Test
	public void testParseValueAttributeValidRealCoordTooManyDigitsAfterDecimal() throws Exception {
		Node node = createNode("<something value=\"9999.99999\" />");
		assertEquals("correct value returned", 
				new BigDecimal("9999.99999"), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidRealCoord() throws Exception {
		Node node = createNode("<something value=\"78.2345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("78.2345"), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"value\" value=\"1345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1345"), 
				new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected REAL.CONF node to have no children", e.getMessage());
		}
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertEquals("errors", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("error message", 
				"Value \"monkey\" of type REAL.CONF is not a valid number", 
				this.xmlResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseInvalidValueAttribute1() throws Exception {
		Node node = createNode("<something value=\"1.11\" />");
		new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult);
		assertEquals("errors", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("error message", 
				"Value 1.11 of type REAL.CONF must be between 0 and 1 (inclusive).", 
				this.xmlResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseValidValueAttributeNothingBeforeDecimal() throws Exception {
		Node node = createNode("<something value=\".11\" />");
		assertEquals("correct value returned", 
				new BigDecimal(".11"), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertEquals("errors", 0, this.xmlResult.getHl7Errors().size());
	}
	
	// try a test with a hex value (these pass NumberUtil.isNumber, but fail when used to create a BigDecimal)
	@Test
	public void testParseValueAttributeInvalidAsHexValue() throws Exception {
		Node node = createNode("<something value=\"0x1a\" />");
		assertNull(new RealElementParser().parse(createContext("REAL.COORD"), node, this.xmlResult).getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	
	@Test
	public void testParseValidValueAttributeNothingAfterDecimal() throws Exception {
		Node node = createNode("<something value=\"1.\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1."), 
				new RealElementParser().parse(createContext("REAL.CONF"), node, this.xmlResult).getBareValue());
		assertEquals("errors", 0, this.xmlResult.getHl7Errors().size());
	}
}
