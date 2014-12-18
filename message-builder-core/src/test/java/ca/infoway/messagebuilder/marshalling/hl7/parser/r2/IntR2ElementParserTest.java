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

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.TrivialContext;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IntR2ElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		
		INT parsedInt = (INT) new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		
		assertNull("null returned", parsedInt.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, parsedInt.getNullFlavor());
		assertTrue("no errors", this.xmlResult.isValid());
	}

	private ParseContext createContext(String hl7Type) {
		return ParseContextImpl.create(hl7Type, Integer.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null, false);
	}
	
	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValid() throws Exception {
		Node node = createNode("<something value=\"1345\" />");
		INTImpl anyInt = (INTImpl) new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("correct value returned", new Integer("1345"), anyInt.getBareValue());
		assertFalse("unsorted default", anyInt.isUnsorted());
	}
	
	@Test
	public void testParseValueWithUnsorted() throws Exception {
		Node node = createNode("<something unsorted=\"true\" value=\"1345\" />");
		INTImpl anyInt = (INTImpl) new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("correct value returned", new Integer("1345"), anyInt.getBareValue());
		assertTrue("unsorted", anyInt.isUnsorted());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorNotAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1345\" />");
		BareANY intAny = new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertEquals("correct value returned", new Integer("1345"), intAny.getBareValue());
		assertNull("no operator", ((ANYMetaData) intAny).getOperator());
		assertFalse(this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidWithOperatorAllowed() throws Exception {
		Node node = createNode("<something operator=\"P\" value=\"1345\" />");
		BareANY intAny = new IntR2ElementParser().parse(createContext("SXCM<INT>"), node, this.xmlResult);
		assertEquals("correct value returned", new Integer("1345"), intAny.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.PERIODIC_HULL, ((ANYMetaData) intAny).getOperator());
	}
	
	@Test
	public void testParseValueAttributeValidWithDefaultOperator() throws Exception {
		Node node = createNode("<something value=\"1345\" />");
		BareANY intAny = new IntR2ElementParser().parse(createContext("SXCM<INT>"), node, this.xmlResult);
		assertEquals("correct value returned", new Integer("1345"), intAny.getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
		assertEquals("operator", SetOperator.INCLUDE, ((ANYMetaData) intAny).getOperator());
	}
	
	@Test
	public void testParseValueAttributeValidZero() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		assertEquals("correct value returned", new Integer("0"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidNegative() throws Exception {
		Node node = createNode("<something value=\"-1\" />");
		assertEquals("correct value returned", new Integer("-1"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeInvalidNegative() throws Exception {
		Node node = createNode("<something value=\"-\" />");
		assertEquals("correct value returned", null, new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeInvalidHexValue() throws Exception {
		Node node = createNode("<something value=\"0x1a\" />");
		assertEquals("correct value returned", new Integer("26"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"value\" value=\"1345\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseEmptyValue() throws Exception {
		Node node = createNode("<something value=\"\" />");
		assertEquals("correct value returned", null, new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseElementWithTextNodes() throws Exception {
		Node node = createNode("<something value=\"3\" >\n</something>");
		assertEquals("correct value returned", new Integer(3), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new IntR2ElementParser().parse(new TrivialContext("INT"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected INT node to have no children", e.getMessage());
		}
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"monkey\" />");
		new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testParseValueWithZeroForIntAttribute() throws Exception {
		Node node = createNode("<something value=\"0\" />");
		new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult);
		assertTrue("no errors", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeValidIntgerWithDecimal() throws Exception {
		Node node = createNode("<something value=\"1345.000\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testParseValueAttributeValidIntgerWithOtherDecimal() throws Exception {
		Node node = createNode("<something value=\"1345.999\" />");
		assertEquals("correct value returned", new Integer("1345"), new IntR2ElementParser().parse(createContext("INT"), node, this.xmlResult).getBareValue());
		assertFalse("error", this.xmlResult.isValid());
		assertEquals("1 error expected", 1, this.xmlResult.getHl7Errors().size());
	}
}