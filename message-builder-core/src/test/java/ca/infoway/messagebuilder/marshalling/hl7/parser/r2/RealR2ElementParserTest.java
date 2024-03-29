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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class RealR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		REAL real = (REAL) new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertNull("null returned", real.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, real.getNullFlavor());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	private ParseContext createContext(String type) {
		return ParseContextImpl.create(type, BigDecimal.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		REAL real = (REAL) new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertNull("null returned", real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		REAL real = (REAL) new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertNull("null returned", real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidFraction() throws Exception {
		Node node = createNode("<something value=\"0.2345\" />");
		BareANY real = new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("0.2345"), 
				real.getBareValue());
		assertNull("no null flavor", real.getNullFlavor());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorNotAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1345.67\" />");
		BareANY intAny = new RealR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertEquals("correct value returned", new BigDecimal("1345.67"), intAny.getBareValue());
		assertNull("no operator", ((ANYMetaData) intAny).getOperator());
		assertFalse(this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1345.67\" />");
		BareANY intAny = new RealR2ElementParser().parse(createContext("SXCM<INT>"), node, this.xmlResult);
		assertEquals("correct value returned", new BigDecimal("1345.67"), intAny.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.PERIODIC_HULL, ((ANYMetaData) intAny).getOperator());
	}
	
	@Test
	public void testParseValueAttributeValidWithDefaultOperator() throws Exception {
		Node node = createNode("<something value=\"1345.67\" />");
		BareANY intAny = new RealR2ElementParser().parse(createContext("SXCM<INT>"), node, this.xmlResult);
		assertEquals("correct value returned", new BigDecimal("1345.67"), intAny.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.INCLUDE, ((ANYMetaData) intAny).getOperator());
	}

	@Test
	public void testParseValueAttributeValidOneWithZeroesAfterDecimal() throws Exception {
		Node node = createNode("<something value=\"1.0000\" />");
		BareANY real = new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("1.0000"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealLoneDecimal() throws Exception {
		Node node = createNode("<something value=\"1.\" />");
		BareANY real = new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("1"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealZero() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		assertEquals("correct value returned", 
				new BigDecimal(0), 
				new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealLotsOfDigits() throws Exception {
		Node node = createNode("<something value=\"9999.9999\" />");
		BareANY real = new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertEquals("correct value returned", 
				new BigDecimal("9999.9999"), 
				real.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidRealNegative() throws Exception {
		Node node = createNode("<something value=\"-999.9999\" />");
		BigDecimal bigDecimal = new BigDecimal("-999.9999");
		assertEquals("correct value returned", 
				bigDecimal, 
				new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"value\" value=\"1345\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1345"), 
				new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected REAL node to have no children", e.getMessage());
		}
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult);
		assertEquals("errors", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("error message", 
				"Value \"monkey\" of type REAL is not a valid number", 
				this.xmlResult.getHl7Errors().get(0).getMessage());
	}

	@Test
	public void testParseValidValueAttributeNothingBeforeDecimal() throws Exception {
		Node node = createNode("<something value=\".11\" />");
		assertEquals("correct value returned", 
				new BigDecimal(".11"), 
				new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertEquals("errors", 0, this.xmlResult.getHl7Errors().size());
	}
	
	// try a test with a hex value (these pass NumberUtil.isNumber, but fail when used to create a BigDecimal)
	@Test
	public void testParseValueAttributeInvalidAsHexValue() throws Exception {
		Node node = createNode("<something value=\"0x1a\" />");
		assertNull(new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertEquals("1 error", 1, this.xmlResult.getHl7Errors().size());
	}
	
	
	@Test
	public void testParseValidValueAttributeNothingAfterDecimal() throws Exception {
		Node node = createNode("<something value=\"1.\" />");
		assertEquals("correct value returned", 
				new BigDecimal("1."), 
				new RealR2ElementParser().parse(createContext("REAL"), node, this.xmlResult).getBareValue());
		assertEquals("errors", 0, this.xmlResult.getHl7Errors().size());
	}
}
