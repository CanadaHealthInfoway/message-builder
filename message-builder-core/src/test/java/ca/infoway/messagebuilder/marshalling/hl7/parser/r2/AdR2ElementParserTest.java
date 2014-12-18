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

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.basic.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class AdR2ElementParserTest extends MarshallingTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		AD ad = (AD) (new AdR2ElementParser()).parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("null returned", null, ad.getValue());
	}

	private ParseContext createContext(String type, VersionNumber version) {
		return ParseContextImpl.create(type, PostalAddress.class, version, null, null, ConformanceLevel.POPULATED, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertNotNull("empty node", ad.getValue());
        assertTrue("empty node value", ad.getValue().getParts().isEmpty());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
        assertPostalAddressPartAsExpected("text node", ad.getValue().getParts().get(0), null, "text value");
	}
	
	@Test
	public void testParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct number of parts", 1, ad.getValue().getParts().size());
		assertNull(ad.getValue().getIsNotOrdered());
        assertPostalAddressPartAsExpected("text node with attributes", ad.getValue().getParts().get(0), null, "text value");
	}

	@Test
    public void testParseAll() throws Exception {
		Date useable1 = DateUtil.getDate(2008, 5, 25, 0, 0, 0, 0);
		Date useable2 = DateUtil.getDate(2012, 8, 3, 0, 0, 0, 0);

        Node node = createNode(
                  "<something isNotOrdered=\"true\"> " +
	                  "<city>city name</city>" +
	                  "freeform" +
	                  "<delimiter>,</delimiter>" +
	                  "\n" +
	                  "<state>Ontario</state>" +
	                  "<useablePeriod operator=\"P\" value=\"20080625\" />" +
	                  "<useablePeriod value=\"20120903\" />" +
                  "</something>");
        
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        
        PostalAddress postalAddress = ad.getValue();
        
        assertEquals("number of name uses", 0, postalAddress.getUses().size());
        assertEquals("number of name parts", 4, postalAddress.getParts().size());
        assertEquals("number of useablePeriods", 2, postalAddress.getUseablePeriods().size());
        
        assertTrue(ad.getValue().getIsNotOrdered());
        
        assertPostalAddressPartAsExpected("city", postalAddress.getParts().get(0), PostalAddressPartType.CITY, "city name");
        assertPostalAddressPartAsExpected("free", postalAddress.getParts().get(1), null, "freeform");
        assertPostalAddressPartAsExpected("delimiter comma", postalAddress.getParts().get(2), PostalAddressPartType.DELIMITER, ",");
        assertPostalAddressPartAsExpected("state", postalAddress.getParts().get(3), PostalAddressPartType.STATE, "Ontario");
        
        assertTrue(postalAddress.getUseablePeriods().containsKey(useable1));
        assertEquals(SetOperator.PERIODIC_HULL, postalAddress.getUseablePeriods().get(useable1));
        
        assertTrue(postalAddress.getUseablePeriods().containsKey(useable2));
        assertEquals(SetOperator.INCLUDE, postalAddress.getUseablePeriods().get(useable2));
    }

	@Test
    public void testParseUseablePeriodOutOfOrder() throws Exception {
		Date useable1 = DateUtil.getDate(2008, 5, 25, 0, 0, 0, 0);
		Date useable2 = DateUtil.getDate(2012, 8, 3, 0, 0, 0, 0);

        Node node = createNode(
                  "<something isNotOrdered=\"true\"> " +
	                  "<city>city name</city>" +
	                  "freeform" +
	                  "<useablePeriod operator=\"P\" value=\"20080625\" />" +
	                  "<delimiter>,</delimiter>" +
	                  "\n" +
	                  "<state>Ontario</state>" +
	                  "<useablePeriod value=\"20120903\" />" +
                  "</something>");
        
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
        
        PostalAddress postalAddress = ad.getValue();
        
        assertEquals("number of name uses", 0, postalAddress.getUses().size());
        assertEquals("number of name parts", 4, postalAddress.getParts().size());
        assertEquals("number of useablePeriods", 2, postalAddress.getUseablePeriods().size());
        
        assertTrue(ad.getValue().getIsNotOrdered());
        
        assertPostalAddressPartAsExpected("city", postalAddress.getParts().get(0), PostalAddressPartType.CITY, "city name");
        assertPostalAddressPartAsExpected("free", postalAddress.getParts().get(1), null, "freeform");
        assertPostalAddressPartAsExpected("delimiter comma", postalAddress.getParts().get(2), PostalAddressPartType.DELIMITER, ",");
        assertPostalAddressPartAsExpected("state", postalAddress.getParts().get(3), PostalAddressPartType.STATE, "Ontario");
        
        assertTrue(postalAddress.getUseablePeriods().containsKey(useable1));
        assertEquals(SetOperator.PERIODIC_HULL, postalAddress.getUseablePeriods().get(useable1));
        
        assertTrue(postalAddress.getUseablePeriods().containsKey(useable2));
        assertEquals(SetOperator.INCLUDE, postalAddress.getUseablePeriods().get(useable2));
    }
	
	@Test
    public void testParseFailure() throws Exception {
        Node node = createNode("<something><monkey>prefix 1</monkey>Organization name<delimiter>,</delimiter><suffix>Inc</suffix></something>");
        
        new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals("message", "Address part type not valid: monkey (<monkey>)", this.xmlResult.getHl7Errors().get(0).getMessage());
    }
    
    private void assertPostalAddressPartAsExpected(String message, PostalAddressPart postalAddressPart, PostalAddressPartType expectedType, String expectedValue) {
        assertEquals(message + " type", expectedType, postalAddressPart.getType());
        assertEquals(message + " value", expectedValue, postalAddressPart.getValue());
    }
    
	@Test
    public void testUsesNoUse() throws Exception {
        Node node = createNode("<something/>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertEquals("zero uses", 0, ad.getValue().getUses().size());
    }
    
	@Test
    public void testUsesOneUse() throws Exception {
        Node node = createNode("<something use=\"H\"/>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        assertEquals("one use", 1, ad.getValue().getUses().size());
        assertTrue("contains HOME use", ad.getValue().getUses().iterator().next().getCodeValue().equals(PostalAddressUse.HOME.getCodeValue()));
    }
    
	@Test
    public void testUsesMultipleUses() throws Exception {
        Node node = createNode("<something use=\"H PHYS PST\"/>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
        
		Set<String> uses = new HashSet<String>();
        PostalAddress postalAddress = ad.getValue();
		for (ca.infoway.messagebuilder.domainvalue.PostalAddressUse postalAddressUse : postalAddress.getUses()) {
			uses.add(postalAddressUse.getCodeValue());
		}
		
		assertEquals("three uses", 3, postalAddress.getUses().size());
        assertTrue("contains HOME use", uses.contains(X_BasicPostalAddressUse.HOME.getCodeValue()));
        assertTrue("contains PHYS use", uses.contains(X_BasicPostalAddressUse.PHYSICAL.getCodeValue()));
        assertTrue("contains POSTAL use", uses.contains(X_BasicPostalAddressUse.POSTAL.getCodeValue()));
    }
    
	@Test
    public void testUsesUnknownUse() throws Exception {
        Node node = createNode("<something use=\"XXX\"/>");
        AD ad = (AD) new AdR2ElementParser().parse(createContext("AD", V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("no uses", 0, ad.getValue().getUses().size());
    }
}
