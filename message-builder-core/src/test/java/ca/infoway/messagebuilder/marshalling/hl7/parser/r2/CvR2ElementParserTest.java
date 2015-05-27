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

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.CO;
import ca.infoway.messagebuilder.datatype.CV_R2;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;

@SuppressWarnings("unchecked")
public class CvR2ElementParserTest extends MarshallingTestCase {
	
	private CvR2ElementParser parser;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new CvR2ElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, cv.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNode() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"OTH\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", cv.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNodeAndCodeSystem() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" nullFlavor=\"OTH\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("value", "BARNEY", cv.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, MANDATORY, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("empty node returns null", cv.getValue());
    }

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), node, this.xmlResult);
        
        assertFalse(this.xmlResult.isValid());
		assertEquals("warning message count", 1, this.xmlResult.getHl7Errors().size()); // invalid NF
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }
    
	@Test
	public void testParseValidFull() throws Exception {
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\">" +
								"<originalText>some original text</originalText>" +
							   "</something>");
		
		CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, cv.getValue().getCode());
		assertEquals("aCsName", cv.getValue().getCodeSystemName());
		assertEquals("aCsVersion", cv.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", cv.getValue().getDisplayName());
		assertEquals("some original text", cv.getValue().getOriginalText().getContent());
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
		
		CV_R2<MockCharacters> cv = (CV_R2<MockCharacters>) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 5, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", cv.getValue());
		assertEquals("main code", "BARNEY", cv.getValue().getCodeValue());
		assertEquals("main code", "1.2.3.4.5", cv.getValue().getCodeSystem());
		assertEquals("aCsName", cv.getValue().getCodeSystemName());
		assertEquals("aCsVersion", cv.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", cv.getValue().getDisplayName());
		assertNull(cv.getValue().getOperator());
		assertNull(cv.getValue().getValue());
		assertNull(cv.getValue().getSimpleValue());
		assertEquals("some original text", cv.getValue().getOriginalText().getContent());
		assertEquals(0, cv.getValue().getTranslation().size());
		assertEquals(0, cv.getValue().getQualifier().size());
	}

	// some tests for CO (identical to CV)
	
	@Test
	public void testParseValidFullCo() throws Exception {
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\">" +
								"<originalText>some original text</originalText>" +
							   "</something>");
		
		CO<MockCharacters> co = (CO<MockCharacters>) this.parser.parse(
				ParseContextImpl.create("CO", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, co.getValue().getCode());
		assertEquals("aCsName", co.getValue().getCodeSystemName());
		assertEquals("aCsVersion", co.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", co.getValue().getDisplayName());
		assertEquals("some original text", co.getValue().getOriginalText().getContent());
	}
	
	@Test
	public void testParseFullCo() throws Exception {
		Node node = createNode(
				"<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" codeSystemName=\"aCsName\" codeSystemVersion=\"aCsVersion\" displayName=\"aDisplayName\" value=\"1.2\" operator=\"P\">" +
				"  some freeform text" +
				"  <originalText>some original text</originalText>" +
				"  <qualifier inverted=\"true\"><name code=\"cm\" codeSystem=\"1.2.3.4\"/><value code=\"normal\" codeSystem=\"2.16.840.1.113883.5.14\"/></qualifier>" +
				"  <qualifier inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><value code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/></qualifier>" +
				"  <translation code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"  <translation code=\"F\" codeSystem=\"2.16.840.1.113883.5.1\" />" +
				"</something>");
		
		CO<MockCharacters> co = (CO<MockCharacters>) this.parser.parse(
				ParseContextImpl.create("CO", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 5, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", co.getValue());
		assertEquals("main code", "BARNEY", co.getValue().getCodeValue());
		assertEquals("main code", "1.2.3.4.5", co.getValue().getCodeSystem());
		assertEquals("aCsName", co.getValue().getCodeSystemName());
		assertEquals("aCsVersion", co.getValue().getCodeSystemVersion());
		assertEquals("aDisplayName", co.getValue().getDisplayName());
		assertNull(co.getValue().getOperator());
		assertNull(co.getValue().getValue());
		assertNull(co.getValue().getSimpleValue());
		assertEquals("some original text", co.getValue().getOriginalText().getContent());
		assertEquals(0, co.getValue().getTranslation().size());
		assertEquals(0, co.getValue().getQualifier().size());
		
	}
}
