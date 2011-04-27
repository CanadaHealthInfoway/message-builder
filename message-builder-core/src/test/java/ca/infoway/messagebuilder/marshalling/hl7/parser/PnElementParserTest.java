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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.EntityNameUse;
import ca.infoway.messagebuilder.datatype.lang.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class PnElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		PN pn = (PN) new PnElementParser().parse(createContext(), node, null);
		assertNull("PersonName", pn.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, pn.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("PN", PersonName.class, SpecificationVersion.NEWFOUNDLAND.getVersionLiteral(), ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		PersonName personName = (PersonName) new PnElementParser().parse(null, node, null).getBareValue();
		assertNotNull("PersonName", personName);
		assertEquals("number of name parts", 0, personName.getParts().size());
		assertEquals("number of name uses", 0, personName.getUses().size());
	}

	@Test
	public void testParseSimpleNameNode() throws Exception {
		Node node = createNode("<something use=\"L\">John Doe</something>");
		PersonName personName = (PersonName) new PnElementParser().parse(null, node, null).getBareValue();
		assertNotNull("PersonName", personName);
		assertEquals("number of name parts", 1, personName.getParts().size());
		assertEquals("name", "John Doe", personName.getParts().get(0).getValue());
		assertNull(personName.getParts().get(0).getType());
		Set<EntityNameUse> uses = personName.getUses();
		assertEquals("number of name uses", 1, uses.size());
		assertEquals("name use", "L", new ArrayList<EntityNameUse>(uses).get(0).getCodeValue());
	}

	 @Test
	public void testParsePrefixes() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <prefix>Mr.</prefix>" 
				+ "</something>");
		
		PersonName personName = (PersonName) new PnElementParser().parse(null, node, null).getBareValue();
        assertEquals("number of name parts", 1, personName.getParts().size());
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);

		node = createNode(
				  "<something>"
				+ "  <prefix>Mr.</prefix>" 
				+ "  <prefix>Mrs.</prefix>" 
				+ "</something>");

        personName = (PersonName) new PnElementParser().parse(null, node, null).getBareValue();
		assertEquals("number of name partsd second time", 2, personName.getParts().size());
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);
        assertNamePartAsExpected("prefix Mrs", personName.getParts().get(1), PersonNamePartType.PREFIX, "Mrs.", null);
	}

	@Test
    public void testParseAll() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <prefix>Mr.</prefix>" 
				+ "  <given qualifier=\"IN\">John</given>" 
				+ "  <given>Jimmy</given>" 
				+ "  <family qualifier=\"IN\">Jones</family>" 
				+ "  <suffix>ESQ</suffix>" 
				+ "</something>");
		
		PersonName personName = (PersonName) new PnElementParser().parse(null, node, null).getBareValue();
        assertEquals("number of name uses", 0, personName.getUses().size());
        assertEquals("number of name parts", 5, personName.getParts().size());
        
        assertNamePartAsExpected("prefix Mr", personName.getParts().get(0), PersonNamePartType.PREFIX, "Mr.", null);
        assertNamePartAsExpected("given John", personName.getParts().get(1), PersonNamePartType.GIVEN, "John", "IN");
        assertNamePartAsExpected("given Jimmy", personName.getParts().get(2), PersonNamePartType.GIVEN, "Jimmy", null);
        assertNamePartAsExpected("family Jones", personName.getParts().get(3), PersonNamePartType.FAMILY, "Jones", "IN");
        assertNamePartAsExpected("suffix ESQ", personName.getParts().get(4), PersonNamePartType.SUFFIX, "ESQ", null);
	}
    
	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode(
                  "<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        try {
            new PnElementParser().parse(null, node, null);
            fail("expected exception");
        } catch (XmlToModelTransformationException e) {
            assertEquals("message", "Unexpected part of type: monkey", e.getMessage());
        }
    }
    
	@Test
	public void testParseEmptyPrefix() throws Exception {
		Node node = createNode(
				  "<something>"
				+ "  <prefix></prefix>" 
				+ "</something>");
		
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		PersonName personName = (PersonName) new PnElementParser().parse(null, node, xmlToJavaResult).getBareValue();
        assertEquals("number of name parts", 0, personName.getParts().size());
        assertEquals("number of warnings", 1, xmlToJavaResult.getHl7Errors().size());
        assertEquals("warnings", "Expected PN child node \"prefix\" to have a text node", xmlToJavaResult.getHl7Errors().get(0).getMessage());
        assertEquals("warnings", "/something/prefix", xmlToJavaResult.getHl7Errors().get(0).getPath());
	}

    private void assertNamePartAsExpected(String message, EntityNamePart namePart, NamePartType expectedType, String expectedValue, String expectedQualifier) {
        assertEquals(message + " type", expectedType, namePart.getType());
        assertEquals(message + " value", expectedValue, namePart.getValue());
        assertEquals(message + " qualifier", expectedQualifier, namePart.getQualifier());
    }
}
