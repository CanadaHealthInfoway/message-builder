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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class AdElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		AD ad = (AD) (new AdElementParser()).parse(createContext(), node, this.xmlResult);
		assertEquals("null returned", null, ad.getValue());
	}

	private ParseContext createContext() {
		return ParserContextImpl.create("AD", PostalAddress.class, SpecificationVersion.NEWFOUNDLAND, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        assertNotNull("empty node", ad.getValue());
        assertTrue("empty node value", ad.getValue().getParts().isEmpty());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
        assertPostalAddressPartAsExpected("text node", ad.getValue().getParts().get(0), null, "text value", null);
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
        assertPostalAddressPartAsExpected("text node with attributes", ad.getValue().getParts().get(0), null, "text value", null);
	}

	@Test
    public void testParseAll() throws Exception {
        Node node = createNode(
                  "<something> <city>city name</city>freeform<delimiter>,</delimiter>\n<state code=\"ON\">Ontario</state></something>");
        
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        
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
        Node node = createNode(
                  "<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        try {
            new AdElementParser().parse(null, node, null);
            fail("expected exception");
        } catch (XmlToModelTransformationException e) {
            assertEquals("message", "Unexpected part of type: monkey", e.getMessage());
        }
    }
    
    private void assertPostalAddressPartAsExpected(String message, PostalAddressPart postalAddressPart, PostalAddressPartType expectedType, String expectedValue, String expectedCode) {
        assertEquals(message + " type", expectedType, postalAddressPart.getType());
        assertEquals(message + " value", expectedValue, postalAddressPart.getValue());
        assertEquals(message + " code", expectedCode, postalAddressPart.getCode() == null ? null : postalAddressPart.getCode().getCodeValue());
    }
    
	@Test
    public void testUsesNoUse() throws Exception {
        Node node = createNode("<something/>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        assertEquals("zero uses", 0, ad.getValue().getUses().size());
    }
    
	@Test
    public void testUsesOneUse() throws Exception {
        Node node = createNode("<something use=\"H\"/>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        assertEquals("one use", 1, ad.getValue().getUses().size());
        assertTrue("contains HOME use", ad.getValue().getUses().contains(PostalAddressUse.HOME));
    }
    
	@Test
    public void testUsesMultipleUses() throws Exception {
        Node node = createNode("<something use=\"H PUB PST\"/>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        
        PostalAddress postalAddress = ad.getValue();
		assertEquals("one use", 3, postalAddress.getUses().size());
        assertTrue("contains HOME use", postalAddress.getUses().contains(PostalAddressUse.HOME));
        assertTrue("contains PUBLIC use", postalAddress.getUses().contains(PostalAddressUse.PUBLIC));
        assertTrue("contains POSTAL use", postalAddress.getUses().contains(PostalAddressUse.POSTAL));
    }
    
	@Test
    public void testUsesUnknownUse() throws Exception {
        Node node = createNode("<something use=\"XXX\"/>");
        AD ad = (AD) new AdElementParser().parse(null, node, null);
        assertEquals("no uses", 0, ad.getValue().getUses().size());
    }
}
