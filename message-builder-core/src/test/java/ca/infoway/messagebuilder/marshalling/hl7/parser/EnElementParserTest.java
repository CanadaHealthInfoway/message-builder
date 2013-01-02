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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.OrganizationNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class EnElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		EN<? extends EntityName> en = (EN<? extends EntityName>) new EnElementParser().parse(createContext(), node, this.xmlResult);
		assertNull("entity name", en.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, en.getNullFlavor());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("EN", EntityName.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        EntityName entityName = (EntityName) new EnElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertNotNull("entity name", entityName);
		assertEquals("number of name parts", 0, entityName.getParts().size());
		assertEquals("number of name uses", 0, entityName.getUses().size());
        assertTrue("returned class", entityName instanceof TrivialName);
	}

	@Test
    public void testParseTrivialName() throws Exception {
        Node node = createNode(
                  "<something>trivial name</something>");
        
        EntityName entityName = (EntityName) new EnElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertNotNull("entity name", entityName);
        assertEquals("number of name parts", 1, entityName.getParts().size());
        assertNamePartAsExpected("name", entityName.getParts().get(0), null, "trivial name");
        assertTrue("returned class", entityName instanceof TrivialName);
    }

	@Test
    public void testParseOrganizationName() throws Exception {
        Node node = createNode(
                  "<something>trivial name<suffix>Inc</suffix></something>");
        
        EntityName entityName = (EntityName) new EnElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertNotNull("entity name", entityName);
        assertEquals("number of name parts", 2, entityName.getParts().size());
        assertNamePartAsExpected("name", entityName.getParts().get(0), null, "trivial name");
        assertNamePartAsExpected("suffix", entityName.getParts().get(1), OrganizationNamePartType.SUFFIX, "Inc");
        assertTrue("returned class", entityName instanceof OrganizationName);
    }

	@Test
    public void testParsePersonName() throws Exception {
        Node node = createNode(
                  "<something><given>Steve</given><family>Shaw</family><suffix>Inc</suffix></something>");
        
        EntityName entityName = (EntityName) new EnElementParser().parse(createContext(), node, this.xmlResult).getBareValue();
        assertNotNull("entity name", entityName);
        assertEquals("number of name parts", 3, entityName.getParts().size());
        assertNamePartAsExpected("given", entityName.getParts().get(0), PersonNamePartType.GIVEN, "Steve");
        assertNamePartAsExpected("family", entityName.getParts().get(1), PersonNamePartType.FAMILY, "Shaw");
        assertNamePartAsExpected("suffix", entityName.getParts().get(2), PersonNamePartType.SUFFIX, "Inc");
        assertTrue("returned class", entityName instanceof PersonName);
    }

    private void assertNamePartAsExpected(String message, EntityNamePart namePart, NamePartType expectedType, String expectedValue) {
        assertEquals(message + " type", expectedType, namePart.getType());
        assertEquals(message + " value", expectedValue, namePart.getValue());
    }
}
