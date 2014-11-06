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

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class OnR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		ON on = (ON) new OnR2ElementParser().parse(createContext(), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNull("OrganizationName", on.getValue());
		assertTrue("has null flavor", on.hasNullFlavor());
		assertEquals("NI null flavor", NullFlavor.NO_INFORMATION, on.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("ON", OrganizationName.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        ON on = (ON) new OnR2ElementParser().parse(createContext(), node, this.xmlResult);
        
		assertTrue(this.xmlResult.isValid());
        OrganizationName organizationName = on.getValue();
        
        assertNotNull("OrganizationName", organizationName);
		assertEquals("number of name parts", 0, organizationName.getParts().size());
		assertEquals("number of name uses", 0, organizationName.getUses().size());
	}

	@Test
	public void testParseNoWeirdParts() throws Exception {
		Node node = createNode(
				  "<something>Organization name</something>");
		
        OrganizationName organizationName = (OrganizationName) new OnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertEquals("number of name parts", 1, organizationName.getParts().size());
        assertNamePartAsExpected("name", organizationName.getParts().get(0), null, "Organization name");
	}

	@Test
    public void testParseAll() throws Exception {
        Node node = createNode(
                  "<something>" +
                  "<prefix>prefix 1</prefix>" +
                  "Organization name" +
                  "<delimiter>,</delimiter>" +
                  "<suffix>Inc</suffix>" +
  				  "<validTime><low value=\"20060403\"/><high value=\"20131127\"/></validTime>" + 
                  "</something>");
        
        OrganizationName organizationName = (OrganizationName) new OnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertEquals("number of name uses", 0, organizationName.getUses().size());
        assertEquals("number of name parts", 4, organizationName.getParts().size());
        assertNotNull(organizationName.getValidTime());
        assertEquals(DateUtil.getDate(2006, 3, 3), organizationName.getValidTime().getLow());
        assertEquals(DateUtil.getDate(2013, 10, 27), organizationName.getValidTime().getHigh());
        
        assertNamePartAsExpected("prefix prefix 1", organizationName.getParts().get(0), OrganizationNamePartType.PREFIX, "prefix 1");
        assertNamePartAsExpected("name", organizationName.getParts().get(1), null, "Organization name");
        assertNamePartAsExpected("delimiter comma", organizationName.getParts().get(2), OrganizationNamePartType.DELIMITER, ",");
        assertNamePartAsExpected("suffix Inc", organizationName.getParts().get(3), OrganizationNamePartType.SUFFIX, "Inc");
    }
    
	@Test
    public void testParseAllWithValidTimeIncorrectlyPlaced() throws Exception {
        Node node = createNode(
                  "<something>" +
                  "<prefix>prefix 1</prefix>" +
                  "<validTime><low value=\"20060403\"/><high value=\"20131127\"/></validTime>" + 
                  "Organization name" +
                  "<delimiter>,</delimiter>" +
                  "<suffix>Inc</suffix>" +
                  "</something>");
        
        OrganizationName organizationName = (OrganizationName) new OnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("validTime"));
		
        assertEquals("number of name uses", 0, organizationName.getUses().size());
        assertEquals("number of name parts", 4, organizationName.getParts().size());
        assertNotNull(organizationName.getValidTime());
        assertEquals(DateUtil.getDate(2006, 3, 3), organizationName.getValidTime().getLow());
        assertEquals(DateUtil.getDate(2013, 10, 27), organizationName.getValidTime().getHigh());
        
        assertNamePartAsExpected("prefix prefix 1", organizationName.getParts().get(0), OrganizationNamePartType.PREFIX, "prefix 1");
        assertNamePartAsExpected("name", organizationName.getParts().get(1), null, "Organization name");
        assertNamePartAsExpected("delimiter comma", organizationName.getParts().get(2), OrganizationNamePartType.DELIMITER, ",");
        assertNamePartAsExpected("suffix Inc", organizationName.getParts().get(3), OrganizationNamePartType.SUFFIX, "Inc");
    }
    
	@Test
    public void testParseAllWithLsQualifier() throws Exception {
		Node node = createNode(
				"<name>" +
				"  <prefix qualifier=\"LS\">IncCo</prefix>" +
				"</name>");
		
		OrganizationName orgName = (OrganizationName) new OnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
        assertTrue(orgName.getUses().isEmpty());
        assertEquals("number of name parts", 1, orgName.getParts().size());

        assertNamePartAsExpected("prefix", orgName.getParts().get(0), OrganizationNamePartType.PREFIX, "IncCo");
        assertEquals(orgName.getParts().get(0).getQualifier().getCodeValue(), "LS");
	}	
    
	@Test
    public void testParseDisallowedPartType() throws Exception {
        Node node = createNode(
                  "<something><prefix>prefix 1</prefix>Organization name<delimiter>,</delimiter><given>Inc</given></something>");
        
        OrganizationName organizationName = (OrganizationName) new OnR2ElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("given"));
        assertEquals("number of name uses", 0, organizationName.getUses().size());
        assertEquals("number of name parts", 3, organizationName.getParts().size());
        
        assertNamePartAsExpected("prefix prefix 1", organizationName.getParts().get(0), OrganizationNamePartType.PREFIX, "prefix 1");
        assertNamePartAsExpected("name", organizationName.getParts().get(1), null, "Organization name");
        assertNamePartAsExpected("delimiter comma", organizationName.getParts().get(2), OrganizationNamePartType.DELIMITER, ",");
    }
    
	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode(
                  "<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        new OnR2ElementParser().parse(createContext(), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertTrue(this.xmlResult.getHl7Errors().get(0).getMessage().contains("monkey"));
    }
    
    private void assertNamePartAsExpected(String message, EntityNamePart namePart, NamePartType expectedType, String expectedValue) {
        assertEquals(message + " type", expectedType, namePart.getType());
        assertEquals(message + " value", expectedValue, namePart.getValue());
    }
}
