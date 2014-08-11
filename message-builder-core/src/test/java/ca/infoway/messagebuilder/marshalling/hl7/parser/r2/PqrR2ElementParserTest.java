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

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.PQR;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;

public class PqrR2ElementParserTest extends MarshallingTestCase {
	
	private PqrR2ElementParser parser;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new PqrR2ElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", pqr.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, pqr.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", pqr.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, pqr.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNode() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"OTH\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", pqr.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, pqr.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNodeAndCodeSystem() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" nullFlavor=\"OTH\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", pqr.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, pqr.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, MANDATORY, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("empty node returns null", pqr.getValue());
    }

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("node with no code attribute returns null", pqr.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", pqr.getValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", pqr.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), node, this.xmlResult);
        
        assertFalse(this.xmlResult.isValid());
		assertEquals("warning message count", 1, this.xmlResult.getHl7Errors().size()); // invalid NF
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        PQR pqr = (PQR) this.parser.parse(
        		ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", pqr.getValue().getCodeValue());
    }
    
	@Test
	public void testParseValidFull() throws Exception {
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\" value=\"1.2\">" +
								"<originalText>some original text</originalText>" +
							   "</something>");
		
		PQR pqr = (PQR) this.parser.parse(
				ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, pqr.getValue().getCode());
		assertEquals("aCsName", pqr.getValue().getCodeSystemName());
		assertEquals("aCsVersion", pqr.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", pqr.getValue().getDisplayName());
		assertEquals("some original text", pqr.getValue().getOriginalText().getContent());
		assertEquals(new BigDecimal("1.2"), pqr.getValue().getValue());
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
		
		PQR pqr = (PQR) this.parser.parse(
				ParserContextImpl.create("PQR", MockCharacters.class, V02R02, null, null, OPTIONAL, null), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 4, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", pqr.getValue());
		assertEquals("main code", "BARNEY", pqr.getValue().getCodeValue());
		assertEquals("main code", "1.2.3.4.5", pqr.getValue().getCodeSystem());
		assertEquals("aCsName", pqr.getValue().getCodeSystemName());
		assertEquals("aCsVersion", pqr.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", pqr.getValue().getDisplayName());
		assertNull(pqr.getValue().getOperator());
		assertEquals(new BigDecimal("1.2"), pqr.getValue().getValue());
		assertNull(pqr.getValue().getSimpleValue());
		assertEquals("some original text", pqr.getValue().getOriginalText().getContent());
		assertEquals(0, pqr.getValue().getTranslation().size());
		assertEquals(0, pqr.getValue().getQualifier().size());
	}

}
