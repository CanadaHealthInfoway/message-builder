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
 * Last modified: $LastChangedDate: 2013-05-16 19:43:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6876 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class SetIiR2ElementParserTest extends ParserTestCase {

	@Test
	public void testParseMissingFixedConstraint() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.2.3.4\" extension=\"5678\" />" +
				"</top>");
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("constraintName", "II");
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("a_fixed_value");
		constraints.getRelationships().add(rootConstraint);
		Relationship extConstraint = new Relationship();
		extConstraint.setName("extension");
		extConstraint.setFixedValue("an_extension");
		constraints.getRelationships().add(extConstraint);
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		
		BareANY result = new SetR2ElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), constraints), 
				asList(node.getChildNodes()), xmlToModelResult);
		@SuppressWarnings("unchecked")
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertTrue(xmlToModelResult.isValid()); // only has a warning
		assertEquals("size", 1, xmlToModelResult.getHl7Errors().size());
		assertEquals("Expected to find an identifier with: root={a_fixed_value},extension={an_extension}", xmlToModelResult.getHl7Errors().get(0).getMessage());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorCode());
		assertEquals(Hl7ErrorLevel.WARNING, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorLevel());
		assertNotNull("null", rawSet);
		assertEquals("size", 1, rawSet.size());
		assertEquals(new Identifier("1.2.3.4", "5678"), rawSet.iterator().next());
	}

	@Test
	public void testParseMissingFixedtemplateIdConstraint() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.2.3.4\" extension=\"5678\" />" +
				"</top>");
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("constraintName.templateId", "II");
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("a_fixed_value");
		constraints.getRelationships().add(rootConstraint);
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		
		BareANY result = new SetR2ElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), constraints), 
				asList(node.getChildNodes()), xmlToModelResult);
		@SuppressWarnings("unchecked")
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertTrue(xmlToModelResult.isValid()); // only has a warning
		assertEquals("size", 1, xmlToModelResult.getHl7Errors().size());
		assertEquals("Expected to find an identifier with: root={a_fixed_value},extension={null}", xmlToModelResult.getHl7Errors().get(0).getMessage());
		assertEquals(Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorCode());
		assertEquals(Hl7ErrorLevel.WARNING, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorLevel());
		assertNotNull("null", rawSet);
		assertEquals("size", 1, rawSet.size());
		assertEquals(new Identifier("1.2.3.4", "5678"), rawSet.iterator().next());
	}

	@Test
	public void testParseMatchingFixedTemplateIdConstraint() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.2.3.4\"/>" +
				"</top>");
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("constraintName.templateId", "II");
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("1.2.3.4");
		constraints.getRelationships().add(rootConstraint);
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		
		BareANY result = new SetR2ElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), constraints), 
				asList(node.getChildNodes()), xmlToModelResult);
		@SuppressWarnings("unchecked")
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertTrue(xmlToModelResult.isValid()); // only has an info message
		assertEquals("size", 1, xmlToModelResult.getHl7Errors().size());
		assertEquals("Found match for templateId fixed constraint: root={1.2.3.4},extension={null}", xmlToModelResult.getHl7Errors().get(0).getMessage());
		assertEquals(Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorCode());
		assertEquals(Hl7ErrorLevel.INFO, xmlToModelResult.getHl7Errors().get(0).getHl7ErrorLevel());
		assertNotNull("null", rawSet);
		assertEquals("size", 1, rawSet.size());
		assertEquals(new Identifier("1.2.3.4"), rawSet.iterator().next());
	}

	@Test
	public void testParseMatchingFixedNonTemplateIdConstraint() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.2.3.4\"/>" +
				"</top>");
		
		ConstrainedDatatype constraints = new ConstrainedDatatype("constraintName.somethingElse", "II");
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("1.2.3.4");
		constraints.getRelationships().add(rootConstraint);
		
		XmlToModelResult xmlToModelResult = new XmlToModelResult();
		
		BareANY result = new SetR2ElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), constraints), 
				asList(node.getChildNodes()), xmlToModelResult);
		@SuppressWarnings("unchecked")
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertTrue(xmlToModelResult.isValid()); // only has an info message
		assertTrue(xmlToModelResult.getHl7Errors().isEmpty());
		assertNotNull("null", rawSet);
		assertEquals("size", 1, rawSet.size());
		assertEquals(new Identifier("1.2.3.4"), rawSet.iterator().next());
	}

}
