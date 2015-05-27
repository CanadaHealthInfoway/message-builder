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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_02;
import static ca.infoway.messagebuilder.SpecificationVersion.V01R04_3;
import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static ca.infoway.messagebuilder.xml.CodingStrength.CNE;
import static ca.infoway.messagebuilder.xml.CodingStrength.CWE;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class CvElementParserTest extends MarshallingTestCase {
	
	private CvElementParser parser;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new CvElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, cv.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseCodeWithNullNode() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\" nullFlavor=\"OTH\"/>");
        CD cd = (CD) this.parser.parse(
        		ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertEquals("value", "BARNEY", cd.getValue().getCodeValue());
        assertEquals("null flavor", NullFlavor.OTHER, cd.getNullFlavor());
    }
    
	@Test
    public void testParseOtherNullNodeWithWrongCodeSystem() throws Exception {
    	Node node = createNode("<something nullFlavor=\"OTH\" codeSystem=\"1.2.3.4.wrong.code.system\" />");
    	CV cv = (CV) this.parser.parse(
    			ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
    			node, this.xmlResult);
    	
        assertTrue(this.xmlResult.isValid());
    	assertEquals("code system", "1.2.3.4.wrong.code.system", cv.getValue().getCodeSystem());
    	assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseOtherNullNodeWithCodeSystem() throws Exception {
    	Node node = createNode("<something nullFlavor=\"OTH\" codeSystem=\"1.2.3.4.5\"><originalText>ahhh</originalText></something>");
    	CV cv = (CV) this.parser.parse(
    			ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
    			node, this.xmlResult);
    	
        assertTrue(this.xmlResult.isValid());
    	assertEquals("code system", "1.2.3.4.5", cv.getValue().getCodeSystem());
    	assertEquals("original text", "ahhh", cv.getOriginalText());
    	assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("empty node returns null", cv.getValue());
    }

	@Test
	public void testParseCWEMustHaveOriginalTextOrCode() throws Exception {
		Node node = createNode("<something/>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CWE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCWEMustHaveNonEmptyOriginalTextOrCode() throws Exception {
		Node node = createNode("<something><originalText></originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CWE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNEMustHaveNonEmptyCodeAndCodeSystem() throws Exception {
		Node node = createNode("<something code=\"\" codeSystem=\"\" />");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseValidCNENullFlavor() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertTrue("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
		assertEquals("NI", cv.getNullFlavor().getCodeValue());
	}
	
	@Test
	public void testParseInvalidCNENullFlavorWithOriginalTextAndSomethingElse() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\" codeSystem=\"this_isnt_allowed\"><originalText>some text</originalText></something>");
		CD cd = (CD) this.parser.parse(
				createContext("CD", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("this_isnt_allowed", cd.getValue().getCodeSystem());
		assertEquals("OTH", cd.getNullFlavor().getCodeValue());
		assertEquals("some text", cd.getOriginalText());
	}
	
	@Test
	public void testParseValidCNENullFlavorWithOriginalTextAtMaxLength() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"><originalText>123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890</originalText></something>");
		CD cd = (CD) this.parser.parse(
				createContext("CD", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertTrue("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cd.getValue());
		assertEquals("OTH", cd.getNullFlavor().getCodeValue());
		assertEquals("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", cd.getOriginalText());
	}
	
	@Test
	public void testParseValidCNENullFlavorWithOriginalTextAtMaxLengthPlusOne() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"><originalText>1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901</originalText></something>");
		CD cd = (CD) this.parser.parse(
				createContext("CD", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNull("empty node returns null", cd.getValue());
		assertEquals("OTH", cd.getNullFlavor().getCodeValue());
		assertEquals("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901", cd.getOriginalText());
	}
	
	@Test
	public void testParseCNENullFlavorOtherMustHaveOriginalText() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNENonNullMustNotHaveOriginalText() throws Exception {
		Node node = createNode("<something code=\"codeAbc\" codesystem=\"1.2.3.4\"><originalText>some text</originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertFalse("valid", this.xmlResult.isValid());
		assertNotNull("original text", cv.getOriginalText());  // preserve what we can, even if an error is logged
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNEWithNullCanHaveOriginalText() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"><originalText>some text</originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, OPTIONAL, CNE), 
				node, this.xmlResult);
		
		assertTrue("valid", this.xmlResult.isValid());
		assertTrue(this.xmlResult.getHl7Errors().isEmpty());
		assertNotNull("original text", cv.getOriginalText());
		assertNull("returns null value", cv.getValue());
	}
	
	@Test
	public void testParseEmptyNodeCNE() throws Exception {
		Node node = createNode("<something/>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02, MANDATORY, CNE), 
				node, this.xmlResult);
		assertFalse("valid", this.xmlResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	private ParseContext createContext(
			final String typeName, 
			final Class<?> c,
			final VersionNumber version, 
			final ConformanceLevel conformance, 
			final CodingStrength strength) {
		
		return ParseContextImpl.create(typeName, c, version, null, null, conformance, null, strength, null, null, false);
	}

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(3, this.xmlResult.getHl7Errors().size());
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseInvalidCWE() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" />");
        CD cd = (CD) this.parser.parse(
        		ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, CodingStrength.CWE, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size()); // code system is mandatory when providing code and is CWE
        assertEquals("BARNEY", cd.getValue().getCodeValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(2, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), node, this.xmlResult);
        
        assertFalse(this.xmlResult.isValid());
		assertEquals("warning message count", 2, this.xmlResult.getHl7Errors().size()); // invalid NF; code/codeSystem are mandatory
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(2, this.xmlResult.getHl7Errors().size());
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }
    
	@Test
	public void testParseContainsOriginalTextAndNullFlavor() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"><originalText>My original text</originalText></something>");
		CV cs = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, cs.getNullFlavor());
		assertEquals("original text", "My original text", cs.getOriginalText());
	}
	
	@Test
    public void testParseValidWithOriginalText() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\"><originalText>Errr....</originalText></something>");
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertTrue(this.xmlResult.isValid());
        assertEquals("BARNEY", cv.getValue().getCodeValue());
        assertEquals("1.2.3.4.5", cv.getValue().getCodeSystem());
        assertEquals("original text", "Errr....", cv.getOriginalText());
    }
    
	@Test
    public void testParseValidWithOriginalTextNoCodeSet() throws Exception {
        Node node = createNode("<something><originalText>Errr....</originalText></something>");
        // Adding to set used to fail on hashCode() call in OriginalTextWrapper
        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, CodingStrength.CWE, null, null, false), 
        		node, this.xmlResult);
        
        assertTrue(this.xmlResult.isValid());
        assertEquals("original text", "Errr....", cv.getOriginalText());
    }
    
	@Test
    public void testParseValidWithEmptyOriginalText() throws Exception {
    	Node node = createNode("<something><originalText /></something>");
    	CV cv = (CV) this.parser.parse(
    			ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, CodingStrength.CWE, null, null, false), 
    			node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());  // need one of code or OT
    	assertNull("no original text",  cv.getOriginalText());
    }
    
	@Test
    public void testParseTooManyChildNodes() throws Exception {
        Node node = createNode(
                "<something>" +
                "<monkey/>" +
                "</something>");

        CV cv = (CV) this.parser.parse(
        		ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
        		node, this.xmlResult);
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size()); // must provide code/codeSystem (monkey element effectively ignored; this is what it seems to have always been doing)
        assertNull("empty node with children returns null", cv.getValue());
    }
    
	@Test
	public void testParseValidEnumCodeButNoCodeSystem() throws Exception {
		Node node = createNode("<something code=\"FRED\" />");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, cv.getValue());
	}
	
	@Test
	public void testParseValidEnumCodeWithCodeSystem() throws Exception {
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.FRED, cv.getValue());
	}
	
	@Test
	public void testParseValidCodeWithMaxCodeValueCeRx() throws Exception {
		Node node = createNode("<something code=\"12345678901234567890\" codeSystem=\"1.2.3.4.5\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V01R04_3, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.CERX_MAX, cv.getValue());
	}
	
	@Test
	public void testParseValidCodeWithMaxPlus1CodeValueCeRx() throws Exception {
		Node node = createNode("<something code=\"123456789012345678901\" codeSystem=\"1.2.3.4.5\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V01R04_3, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("enum found properly", MockEnum.CERX_MAX_PLUS_1, cv.getValue());
	}
	
	@Test
	public void testParseValidCodeWithMaxCodeValueMr2009() throws Exception {
		Node node = createNode("<something code=\"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890\" codeSystem=\"1.2.3.4.5\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, R02_04_02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertTrue("valid", this.xmlResult.isValid());
		assertEquals("enum found properly", MockEnum.MR2009_MAX, cv.getValue());
	}
	
	@Test
	public void testParseValidCodeWithMaxPlus1CodeValueMr2009() throws Exception {
		Node node = createNode("<something code=\"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\" codeSystem=\"1.2.3.4.5\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, R02_04_02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("enum found properly", MockEnum.MR2009_MAX_PLUS_1, cv.getValue());
	}
	
	@Test
	public void testParseValidEnumCodeWithCodeSystemButUnallowedAttribute() throws Exception {
		Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" displayName=\"unallowed\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, this.xmlResult);
		assertFalse("valid", this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("enum found properly", MockEnum.FRED, cv.getValue());
		assertEquals("display name", "unallowed", cv.getDisplayName());
	}
	
	@Test
	public void testParseInvalidEnumCode() throws Exception {
		Node node = createNode("<something code=\"ER\" codeSystem=\"1.2.3\"/>");
		
		CV cv = (CV) this.parser.parse(
				ParseContextImpl.create("CV", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 1, this.xmlResult.getHl7Errors().size()); // invalid code
		assertNull("bogus enum not found", cv.getValue().getCodeValue());
		assertEquals("error message", 
				"The code, \"ER\", in element <something> is not a valid value for domain type \"MockCharacters\"", 
				this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("error type", 
				Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, 
				this.xmlResult.getHl7Errors().get(0).getHl7ErrorCode());
	}
	
	@Test
	public void testParseValidTranslation() throws Exception {
		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\"><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" /></something>");
		
		CD cd = (CD) this.parser.parse(
				ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertTrue(this.xmlResult.isValid());
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enum found", cd.getTranslations().isEmpty());
		assertTrue("translation enum found", cd.getTranslations().size() == 1);
		assertEquals("error message count", 0, this.xmlResult.getHl7Errors().size());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertEquals("translation", "FRED", cd.getTranslations().get(0).getValue().getCodeValue());
	}
	
	@Test
	public void testParseInvalidTranslation() throws Exception {
		// triggers every error for translations
		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\">" +
				"<translation nullFlavor=\"OTH\" codeSystemName=\"aName\" codeSystemVersion=\"123\" displayName=\"aName\" >" +
				"  <originalText>should not be here</originalText>" +
				"  <translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"  <qualifier />" +
				"</translation>" +
				"</something>");
		
		CD cd = (CD) this.parser.parse(
				ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals("error message count", 8, this.xmlResult.getHl7Errors().size());
        
		assertNotNull("main enum found", cd.getValue());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertEquals("translation enum not found", 1, cd.getTranslations().size());
		
		assertTrue("error message", this.xmlResult.getHl7Errors().get(0).getMessage().startsWith("CD should not include the 'codeSystemName' property."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(1).getMessage().startsWith("CD should not include the 'codeSystemVersion' property."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(2).getMessage().startsWith("CD should not include the 'qualifier' property."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(3).getMessage().startsWith("(translation level) Translation may not contain other translations."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(4).getMessage().startsWith("(translation level) Translation may not contain a NullFlavor."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(5).getMessage().startsWith("(translation level) Translation may not contain originalText."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(6).getMessage().startsWith("(translation level) Translation may not contain displayName."));
		assertTrue("error message", this.xmlResult.getHl7Errors().get(7).getMessage().startsWith("(translation level) Code and codeSystem properties must be provided."));
	}
	
	@Test
	public void testParseMaximumValidTranslation() throws Exception {
		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\">" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" /></something>");
		
		CD cd = (CD) this.parser.parse(
				ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertTrue(this.xmlResult.isValid());
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enums found", cd.getTranslations().isEmpty());
		assertTrue("translation enums found", cd.getTranslations().size() == 10);
		assertEquals("error message count", 0, this.xmlResult.getHl7Errors().size());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertEquals("translation", "FRED", cd.getTranslations().get(0).getValue().getCodeValue());
		assertEquals("translation", "WILMA", cd.getTranslations().get(9).getValue().getCodeValue());
	}
	
	@Test
	public void testParseTooManyTranslations() throws Exception {
		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\">" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BAM_BAM\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"WILMA\" codeSystem=\"1.2.3.4.5\" />" +
				"<translation code=\"BETTY\" codeSystem=\"1.2.3.4.5\" /></something>");
		
		CD cd = (CD) this.parser.parse(
				ParseContextImpl.create("CD", MockCharacters.class, V02R02, null, null, OPTIONAL, null, null, false), 
				node, 
				this.xmlResult);
		
        assertFalse(this.xmlResult.isValid());
        assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enums found", cd.getTranslations().isEmpty());
		assertTrue("translation enums found", cd.getTranslations().size() == 11);
		assertEquals("error message count", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertEquals("translation", "FRED", cd.getTranslations().get(0).getValue().getCodeValue());
		assertEquals("translation", "BETTY", cd.getTranslations().get(10).getValue().getCodeValue());
		assertTrue("error message", this.xmlResult.getHl7Errors().get(0).getMessage().startsWith("A maximum of 10 translations are allowed."));
		assertEquals("error type", 
				Hl7ErrorCode.DATA_TYPE_ERROR, 
				this.xmlResult.getHl7Errors().get(0).getHl7ErrorCode());
	}
}
