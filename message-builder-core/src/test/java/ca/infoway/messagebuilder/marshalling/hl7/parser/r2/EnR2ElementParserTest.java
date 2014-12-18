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
 * Last modified: $LastChangedDate: 2014-02-14 12:41:04 -0500 (Fri, 14 Feb 2014) $
 * Revision:      $LastChangedRevision: 8400 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EnR2ElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PN pn = (PN) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("PersonName", pn.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pn.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, PersonName.class, version, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PersonName", personName);
		assertEquals("number of name parts", 0, personName.getParts().size());
		assertEquals("number of name uses", 0, personName.getUses().size());
	}

	@Test
	public void testParseSimpleNameNode() throws Exception {
		Node node = createNode("<something use=\"L\">John Doe</something>");
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertNotNull("PersonName", personName);
		assertEquals("number of name parts", 1, personName.getParts().size());
		assertEquals("name", "John Doe", personName.getParts().get(0).getValue());
		assertNull(personName.getParts().get(0).getType());
		Set<EntityNameUse> uses = personName.getUses();
		assertEquals("number of name uses", 1, uses.size());
		assertEquals("name use", "L", new ArrayList<EntityNameUse>(uses).get(0).getCodeValue());
	}

	@Test
	public void testParseSimpleNameNodeWithInvalidUse() throws Exception {
		Node node = createNode("<something use=\"123\">John Doe</something>");
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNotNull("PersonName", personName);
		assertEquals("number of name parts", 1, personName.getParts().size());
		assertEquals("name", "John Doe", personName.getParts().get(0).getValue());
		assertNull(personName.getParts().get(0).getType());
		assertTrue("no uses", personName.getUses().isEmpty());
	}

	 @Test
	public void testParsePrefixes() throws Exception {
		Node node = createNode(
				  "<something use=\"L\">"
				+ "  <prefix>Mr.</prefix>" 
				+ "</something>");
		
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertEquals("number of name parts", 1, personName.getParts().size());
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);

		node = createNode(
				  "<something use=\"L\">"
				+ "  <prefix>Mr.</prefix>" 
				+ "  <prefix>Mrs.</prefix>" 
				+ "</something>");

        personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("number of name partsd second time", 2, personName.getParts().size());
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);
        assertNamePartAsExpected("prefix Mrs", personName.getParts().get(1), PersonNamePartType.PREFIX, "Mrs.", null);
	}

	@Test
    public void testParseAll() throws Exception {
		Node node = createNode(
				  "<something use=\"L\">"
				+ "  <prefix>Mr.</prefix>" 
				+ "  <given qualifier=\"IN\">John</given>" 
				+ "  <given>Jimmy</given>" 
				+ "  <family qualifier=\"IN\">Jones</family>" 
				+ "  <suffix>ESQ</suffix>" 
				+ "  <validTime><low value=\"20060403\"/><high value=\"20131127\"/></validTime>" 
				+ "</something>");
		
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertEquals("number of name uses", 1, personName.getUses().size());
        assertEquals("number of name parts", 5, personName.getParts().size());
        assertNotNull(personName.getValidTime());
        assertEquals(DateUtil.getDate(2006, 3, 3), personName.getValidTime().getLow());
        assertEquals(DateUtil.getDate(2013, 10, 27), personName.getValidTime().getHigh());
        
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);
        assertNamePartAsExpected("given John", personName.getParts().get(1), PersonNamePartType.GIVEN, "John", "IN");
        assertNamePartAsExpected("given Jimmy", personName.getParts().get(2), PersonNamePartType.GIVEN, "Jimmy", null);
        assertNamePartAsExpected("family Jones", personName.getParts().get(3), PersonNamePartType.FAMILY, "Jones", "IN");
        assertNamePartAsExpected("suffix ESQ", personName.getParts().get(4), PersonNamePartType.SUFFIX, "ESQ", null);
	}
	
	@Test
    public void testParseAllPlusUntypedValue() throws Exception {
		Node node = createNode(
				"<name use=\"L\">Prime Minister of Canada" +
				"  <family>Landry</family>" +
				"  <prefix>MR.</prefix>" +
				"  <suffix>III</suffix>" +
				"  <given>Chris</given>" +
				"  <given>William</given>" +
				"  <given qualifier=\"IN\">A.</given>" +
				"</name>");
		
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertEquals("number of name uses", 1, personName.getUses().size());
        assertEquals("number of name parts", 7, personName.getParts().size());

        assertNamePartAsExpected("Untyped Prime Minister of Canada", personName.getParts().get(0), null, "Prime Minister of Canada", null);
        assertNamePartAsExpected("family Landry", personName.getParts().get(1), PersonNamePartType.FAMILY, "Landry", null);
        assertNamePartAsExpected("prefix MR.", personName.getParts().get(2), PersonNamePartType.PREFIX, "MR.", null);
        assertNamePartAsExpected("suffix III", personName.getParts().get(3), PersonNamePartType.SUFFIX, "III", null);
        assertNamePartAsExpected("given Chris", personName.getParts().get(4), PersonNamePartType.GIVEN, "Chris", null);
        assertNamePartAsExpected("given William", personName.getParts().get(5), PersonNamePartType.GIVEN, "William", null);
        assertNamePartAsExpected("given A.", personName.getParts().get(6), PersonNamePartType.GIVEN, "A.", "IN");
	}	
    
	@Test
    public void testParseAllWithLsQualifier() throws Exception {
		Node node = createNode(
				"<name>" +
				"  <given qualifier=\"LS\">Andrew</given>" +
				"</name>");
		
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertTrue(personName.getUses().isEmpty());
        assertEquals("number of name parts", 1, personName.getParts().size());

        assertNamePartAsExpected("given Andrew", personName.getParts().get(0), PersonNamePartType.GIVEN, "Andrew", "LS");
	}	
    
	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode(
                  "<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("message", "Unexpected part of type: monkey (<monkey>)", this.xmlResult.getHl7Errors().get(0).getMessage());
    }
    
	@Test
	public void testParseEmptyPrefix() throws Exception {
		Node node = createNode(
				  "<something use=\"L\">"
				+ "  <prefix></prefix>" 
				+ "</something>");
		
		PersonName personName = (PersonName) new PnR2ElementParser().parse(createContext("EN", SpecificationVersion.R02_04_02), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals("number of warnings", 1, this.xmlResult.getHl7Errors().size()); // empty part
        assertEquals("number of name parts", 0, personName.getParts().size());
        assertEquals("warnings", "Expected PN child node \"prefix\" to have a text node (<prefix/>)", xmlResult.getHl7Errors().get(0).getMessage());
        assertEquals("warnings", "/something/prefix", xmlResult.getHl7Errors().get(0).getPath());
	}

    private void assertNamePartAsExpected(String message, EntityNamePart namePart, NamePartType expectedType, String expectedValue, String expectedQualifier) {
        assertEquals(message + " type", expectedType, namePart.getType());
        assertEquals(message + " value", expectedValue, namePart.getValue());
        assertEquals(message + " qualifier", expectedQualifier, namePart.getQualifier() == null ? null : namePart.getQualifier().getCodeValue());
    }
}
