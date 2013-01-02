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

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class AdElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		AD ad = (AD) (new AdElementParser()).parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("null returned", null, ad.getValue());
	}

	private ParseContext createContext(String type, VersionNumber version) {
		return ParserContextImpl.create(type, PostalAddress.class, version, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertNotNull("empty node", ad.getValue());
        assertTrue("empty node value", ad.getValue().getParts().isEmpty());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
        assertPostalAddressPartAsExpected("text node", ad.getValue().getParts().get(0), null, "text value", null);
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
        assertPostalAddressPartAsExpected("text node with attributes", ad.getValue().getParts().get(0), null, "text value", null);
	}

	@Test
    public void testParseAll() throws Exception {
        Node node = createNode(
                  "<something> <city>city name</city>freeform<delimiter>,</delimiter>\n<state code=\"ON\">Ontario</state></something>");
        
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        
        PostalAddress postalAddress = ad.getValue();
        
        assertEquals("number of name uses", 0, postalAddress.getUses().size());
        assertEquals("number of name parts", 4, postalAddress.getParts().size());
        
        assertPostalAddressPartAsExpected("city", postalAddress.getParts().get(0), PostalAddressPartType.CITY, "city name", null);
        assertPostalAddressPartAsExpected("free", postalAddress.getParts().get(1), null, "freeform", null);
        assertPostalAddressPartAsExpected("delimiter comma", postalAddress.getParts().get(2), PostalAddressPartType.DELIMITER, ",", null);
        assertPostalAddressPartAsExpected("state", postalAddress.getParts().get(3), PostalAddressPartType.STATE, "Ontario", "ON");
    }

	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode("<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals("message", "Address part type not valid: monkey (<monkey>)", this.xmlResult.getHl7Errors().get(0).getMessage());
    }
    
    private void assertPostalAddressPartAsExpected(String message, PostalAddressPart postalAddressPart, PostalAddressPartType expectedType, String expectedValue, String expectedCode) {
        assertEquals(message + " type", expectedType, postalAddressPart.getType());
        assertEquals(message + " value", expectedValue, postalAddressPart.getValue());
        assertEquals(message + " code", expectedCode, postalAddressPart.getCode() == null ? null : postalAddressPart.getCode().getCodeValue());
    }
    
	@Test
    public void testUsesNoUse() throws Exception {
        Node node = createNode("<something/>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertEquals("zero uses", 0, ad.getValue().getUses().size());
    }
    
	@Test
    public void testUsesOneUse() throws Exception {
        Node node = createNode("<something use=\"H\"/>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertEquals("one use", 1, ad.getValue().getUses().size());
        assertTrue("contains HOME use", ad.getValue().getUses().contains(X_BasicPostalAddressUse.HOME));
    }
    
	@Test
    public void testUsesMultipleUses() throws Exception {
        Node node = createNode("<something use=\"H PHYS PST\"/>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        
        PostalAddress postalAddress = ad.getValue();
		assertEquals("one use", 3, postalAddress.getUses().size());
        assertTrue("contains HOME use", postalAddress.getUses().contains(X_BasicPostalAddressUse.HOME));
        assertTrue("contains PHYS use", postalAddress.getUses().contains(X_BasicPostalAddressUse.PHYSICAL));
        assertTrue("contains POSTAL use", postalAddress.getUses().contains(X_BasicPostalAddressUse.POSTAL));
    }
    
	@Test
    public void testUsesUnknownUse() throws Exception {
        Node node = createNode("<something use=\"XXX\"/>");
        AD ad = (AD) new AdElementParser().parse(createContext("AD.BASIC", V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("no uses", 0, ad.getValue().getUses().size());
    }
}
