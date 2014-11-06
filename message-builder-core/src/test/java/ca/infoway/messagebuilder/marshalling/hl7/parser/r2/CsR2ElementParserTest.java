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
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;

public class CsR2ElementParserTest extends MarshallingTestCase {
	
	private CsR2ElementParser parser;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new CsR2ElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cs.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, cs.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cs.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, cs.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNode() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"OTH\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", cs.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, cs.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNodeAndCodeSystem() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" nullFlavor=\"OTH\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());  // codeSystem not allowed
        assertEquals("value", "BARNEY", cs.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, cs.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, MANDATORY, null, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("empty node returns null", cs.getValue());
    }

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("node with no code attribute returns null", cs.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", cs.getValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cs.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), node, this.xmlResult);
        
        assertFalse(this.xmlResult.isValid());
		assertEquals("warning message count", 1, this.xmlResult.getHl7Errors().size()); // invalid NF
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        CS_R2 cs = (CS_R2) this.parser.parse(
        		ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cs.getValue().getCodeValue());
    }
    
	@Test
	public void testParseValidFull() throws Exception {
		Node node = createNode("<something code=\"FRED\" />");
		
		CS_R2 cs = (CS_R2) this.parser.parse(
				ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, cs.getValue().getCode());
	}
	
	@Test
	public void testParseFull() throws Exception {
		Node node = createNode(
				"<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\" value=\"1.2\" operator=\"P\">" +
				"  some freeform text" +
				"  <originalText>some original text</originalText>" +
				"  <qualifier inverted=\"true\"><name code=\"cm\" codeSystem=\"1.2.3.4\"/><value code=\"normal\" codeSystem=\"2.16.840.1.113883.5.14\"/></qualifier>" +
				"  <qualifier inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><value code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/></qualifier>" +
				"  <translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"  <translation code=\"F\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"</something>");
		
		CS_R2 cs = (CS_R2) this.parser.parse(
				ParserContextImpl.create("CS", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 10, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", cs.getValue());
		assertEquals("main code", "BARNEY", cs.getValue().getCodeValue());
		assertEquals("main code", "1.2.3.4.5", cs.getValue().getCodeSystem());
		assertNull(cs.getValue().getCodeSystemName());
		assertNull(cs.getValue().getCodeSystemVersion());
		assertNull(cs.getValue().getDisplayName());
		assertNull(cs.getValue().getOperator());
		assertNull(cs.getValue().getValue());
		assertNull(cs.getValue().getSimpleValue());
		assertNull(cs.getValue().getOriginalText());
		assertEquals(0, cs.getValue().getTranslation().size());
		assertEquals(0, cs.getValue().getQualifier().size());
		
	}
	
}
