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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.OrganizationNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class OnElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		ON on = (ON) new OnElementParser().parse(createContext(), node, null);
		assertNull("OrganizationName", on.getValue());
		assertTrue("has null flavor", on.hasNullFlavor());
		assertEquals("NI null flavor", NullFlavor.NO_INFORMATION, on.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("ON", OrganizationName.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        ON on = (ON) new OnElementParser().parse(createContext(), node, null);
        
        OrganizationName organizationName = on.getValue();
        
        assertNotNull("OrganizationName", organizationName);
		assertEquals("number of name parts", 0, organizationName.getParts().size());
		assertEquals("number of name uses", 0, organizationName.getUses().size());
	}

	@Test
	public void testParseNoWeirdParts() throws Exception {
		Node node = createNode(
				  "<something>Organization name</something>");
		
        OrganizationName organizationName = (OrganizationName) new OnElementParser().parse(createContext(), node, null).getBareValue();
        assertEquals("number of name parts", 1, organizationName.getParts().size());
        assertNamePartAsExpected("name", organizationName.getParts().get(0), null, "Organization name");
	}

	@Test
    public void testParseAll() throws Exception {
        Node node = createNode(
                  "<something><prefix>prefix 1</prefix>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        OrganizationName organizationName = (OrganizationName) new OnElementParser().parse(createContext(), node, null).getBareValue();
        assertEquals("number of name uses", 0, organizationName.getUses().size());
        assertEquals("number of name parts", 4, organizationName.getParts().size());
        
        assertNamePartAsExpected("prefix prefix 1", organizationName.getParts().get(0), OrganizationNamePartType.PREFIX, "prefix 1");
        assertNamePartAsExpected("name", organizationName.getParts().get(1), null, "Organization name");
        assertNamePartAsExpected("delimiter comma", organizationName.getParts().get(2), OrganizationNamePartType.DELIMETER, ",");
        assertNamePartAsExpected("suffix Inc", organizationName.getParts().get(3), OrganizationNamePartType.SUFFIX, "Inc");
    }
    
	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode(
                  "<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        try {
            new OnElementParser().parse(createContext(), node, null);
            fail("expected exception");
        } catch (XmlToModelTransformationException e) {
            assertEquals("message", "Unexpected part of type: monkey", e.getMessage());
        }
    }
    
    private void assertNamePartAsExpected(String message, EntityNamePart namePart, NamePartType expectedType, String expectedValue) {
        assertEquals(message + " type", expectedType, namePart.getType());
        assertEquals(message + " value", expectedValue, namePart.getValue());
    }
}
