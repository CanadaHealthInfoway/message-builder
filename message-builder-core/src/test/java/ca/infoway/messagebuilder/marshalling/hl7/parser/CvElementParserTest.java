package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.SpecificationVersion.V02R02;
import static ca.infoway.messagebuilder.xml.CodingStrength.CNE;
import static ca.infoway.messagebuilder.xml.CodingStrength.CWE;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
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
        //CodeResolverRegistry.registerResolver(MockEnum.class, new EnumBasedCodeResolver(MockEnum.class));
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
        this.parser = new CvElementParser();
	}
	
	@Test
    public void testParseNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"NI\"/>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.NO_INFORMATION, cv.getNullFlavor());
    }

	@Test
    public void testParseOtherNullNode() throws Exception {
        Node node = createNode("<something nullFlavor=\"OTH\"/>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("value", cv.getValue());
        assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseOtherNullNodeWithWrongCodeSystem() throws Exception {
    	Node node = createNode("<something nullFlavor=\"OTH\" codeSystem=\"1.2.3.4.wrong.code.system\" />");
    	CV cv = (CV) this.parser.parse(
    			ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
    			node, this.xmlJavaResult);
    	
    	assertEquals("code system", "1.2.3.4.wrong.code.system", cv.getValue().getCodeSystem());
    	assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseOtherNullNodeWithCodeSystem() throws Exception {
    	Node node = createNode("<something nullFlavor=\"OTH\" codeSystem=\"1.2.3.4.5\" originalText=\"ahhh\"><originalText>ahhh</originalText></something>");
    	CV cv = (CV) this.parser.parse(
    			ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
    			node, this.xmlJavaResult);
    	
    	assertEquals("code system", "1.2.3.4.5", cv.getValue().getCodeSystem());
    	assertEquals("original text", "ahhh", cv.getOriginalText());
    	assertEquals("null flavor", NullFlavor.OTHER, cv.getNullFlavor());
    }
    
	@Test
    public void testParseEmptyNode() throws Exception {
        Node node = createNode("<something/>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("empty node returns null", cv.getValue());
    }

	@Test
	public void testParseCWEMustHaveOriginalTextOrCode() throws Exception {
		Node node = createNode("<something/>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL, CWE), 
				node, this.xmlJavaResult);
		
		assertFalse("valid", this.xmlJavaResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCWEMustHaveNonEmptyOriginalTextOrCode() throws Exception {
		Node node = createNode("<something><originalText></originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL, CWE), 
				node, this.xmlJavaResult);
		
		assertFalse("valid", this.xmlJavaResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNENullFlavorOtherMustHaveOriginalText() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL, CNE), 
				node, this.xmlJavaResult);
		
		assertFalse("valid", this.xmlJavaResult.isValid());
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNENonNullMustNotHaveOriginalText() throws Exception {
		Node node = createNode("<something code=\"codeAbc\" codesystem=\"1.2.3.4\"><originalText>some text</originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL, CNE), 
				node, this.xmlJavaResult);
		
		assertFalse("valid", this.xmlJavaResult.isValid());
		assertNotNull("original text", cv.getOriginalText());  // preserve what we can, even if an error is logged
		assertNull("empty node returns null", cv.getValue());
	}
	
	@Test
	public void testParseCNEWithNullCanHaveOriginalText() throws Exception {
		Node node = createNode("<something nullFlavor=\"OTH\"><originalText>some text</originalText></something>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL, CNE), 
				node, this.xmlJavaResult);
		
		assertTrue("valid", this.xmlJavaResult.isValid());
		assertTrue(this.xmlJavaResult.getHl7Errors().isEmpty());
		assertNotNull("original text", cv.getOriginalText());
		assertNull("returns null value", cv.getValue());
	}
	
	@Test
	public void testParseEmptyNodeCNE() throws Exception {
		Node node = createNode("<something/>");
		CV cv = (CV) this.parser.parse(
				createContext("CV", MockCharacters.class, V02R02.getVersionLiteral(), MANDATORY, CNE), 
				node, this.xmlJavaResult);
		assertNull("empty node returns null", cv.getValue());
		assertFalse("valid", this.xmlJavaResult.isValid());
	}
	
	private ParseContext createContext(
			final String typeName, 
			final Class<?> c,
			final String version, 
			final ConformanceLevel conformance, 
			final CodingStrength strength) {
		
		return ParserContextImpl.create(typeName, c, version, conformance, strength, null);
	}

	@Test
    public void testParseNoCodeAttributeNode() throws Exception {
        Node node = createNode("<something notvalue=\"\" />");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseInvalid() throws Exception {
        Node node = createNode("<something code=\"ER\" />");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("node with no code attribute returns null", cv.getValue());
    }
    
	@Test
    public void testParseValidWithEmptyNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"\"/>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }

	@Test
    public void testParseInvalidNullFavorAttributeValue() throws Exception {
    	
        Node node = createNode("<something nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), node, this.xmlJavaResult);
        
		assertEquals("warning message count", 1, this.xmlJavaResult.getHl7Errors().size());
    }

	@Test
    public void testParseValidWithInvalidNullFavorAttributeValue() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" nullFlavor=\"NOT A VALID NULL FAVOR VALUE\"/>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
    }
    
	@Test
	public void testParseContainsOriginalTextAndNullFlavor() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"><originalText>My original text</originalText></something>");
		CV cs = (CV) this.parser.parse(
				ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, this.xmlJavaResult);
		
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, cs.getNullFlavor());
		assertEquals("original text", "My original text", cs.getOriginalText());
		assertTrue("valid", this.xmlJavaResult.isValid());
	}
	
	@Test
    public void testParseValidWithOriginalText() throws Exception {
        Node node = createNode("<something code=\"BARNEY\" ><originalText>Errr....</originalText></something>");
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertEquals("node with no code attribute returns null", "BARNEY", cv.getValue().getCodeValue());
        assertEquals("original text", "Errr....", cv.getOriginalText());
    }
    
	@Test
    public void testParseValidWithOriginalTextNoCodeSet() throws Exception {
        Node node = createNode("<something><originalText>Errr....</originalText></something>");
        // Adding to set used to fail on hashCode() call in OriginalTextWrapper
        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        
        Set<Code> set = new LinkedHashSet<Code>();
        set.add(cv.getValue());
        assertEquals("original text", "Errr....", cv.getOriginalText());
    }
    
	@Test
    public void testParseValidWithEmptyOriginalText() throws Exception {
    	Node node = createNode("<something><originalText /></something>");
    	CV cv = (CV) this.parser.parse(
    			ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
    			node, this.xmlJavaResult);
    	assertNull("no original text",  cv.getOriginalText());
    }
    
	@Test
    public void testParseTooManyChildNodes() throws Exception {
        Node node = createNode(
                "<something>" +
                "<monkey/>" +
                "</something>");

        CV cv = (CV) this.parser.parse(
        		ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
        		node, this.xmlJavaResult);
        assertNull("empty node with children returns null", cv.getValue());
    }
    
	@Test
	public void testParseValidEnumCode() throws Exception {
		Node node = createNode("<something code=\"FRED\" />");
		
		CV cv = (CV) this.parser.parse(
				ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, this.xmlJavaResult);
		assertEquals("enum found properly", MockEnum.FRED, cv.getValue());
		assertFalse("valid", this.xmlJavaResult.isValid());
	}
	
	@Test
	public void testParseInvalidEnumCode() throws Exception {
		Node node = createNode("<something code=\"ER\" codeSystem=\"1.2.3\"/>");
		
		XmlToModelResult result = new XmlToModelResult();
		CV cv = (CV) this.parser.parse(
				ParserContextImpl.create("CV", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, 
				result);
		
		assertNull("bogus enum not found", cv.getValue().getCodeValue());
		assertEquals("error message count", 1, result.getHl7Errors().size());
		assertEquals("error message", 
				"The code, \"ER\", in element <something> is not a valid value for domain type \"MockCharacters\"", 
				result.getHl7Errors().get(0).getMessage());
		assertEquals("error type", 
				Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, 
				result.getHl7Errors().get(0).getHl7ErrorCode());
	}
	
	@Test
	public void testParseValidTranslation() throws Exception {
		Node node = createNode("<something code=\"BARNEY\" codeSystem=\"1.2.3.4.5\"><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\" /></something>");
		
		XmlToModelResult result = new XmlToModelResult();
		CD cd = (CD) this.parser.parse(
				ParserContextImpl.create("CD", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, 
				result);
		
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enum found", cd.getTranslations().isEmpty());
		assertTrue("translation enum found", cd.getTranslations().size() == 1);
		assertEquals("error message count", 0, result.getHl7Errors().size());
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
		
		XmlToModelResult result = new XmlToModelResult();
		CD cd = (CD) this.parser.parse(
				ParserContextImpl.create("CD", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, 
				result);
		
		assertNotNull("main enum found", cd.getValue());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertTrue("translation enum not found", cd.getTranslations().isEmpty());
		assertEquals("error message count", 9, result.getHl7Errors().size());
		assertTrue("error message", result.getHl7Errors().get(0).getMessage().startsWith("CD should not include the 'codeSystemName' property."));
		assertTrue("error message", result.getHl7Errors().get(1).getMessage().startsWith("CD should not include the 'codeSystemVersion' property."));
		assertTrue("error message", result.getHl7Errors().get(2).getMessage().startsWith("CD should not include the 'displayName' property."));
		assertTrue("error message", result.getHl7Errors().get(3).getMessage().startsWith("CD should not include the 'qualifier' property."));
		assertTrue("error message", result.getHl7Errors().get(4).getMessage().startsWith("CD should not include the 'nullFlavor' property."));
		assertTrue("error message", result.getHl7Errors().get(5).getMessage().startsWith("CD should not include the 'originalText' property."));
		assertTrue("error message", result.getHl7Errors().get(6).getMessage().startsWith("CD should not include the 'translation' property."));
		assertTrue("error message", result.getHl7Errors().get(7).getMessage().startsWith("Attribute code is mandatory for node /something/translation"));
		assertTrue("error message", result.getHl7Errors().get(8).getMessage().startsWith("Attribute codeSystem is mandatory for node /something/translation"));
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
		
		XmlToModelResult result = new XmlToModelResult();
		CD cd = (CD) this.parser.parse(
				ParserContextImpl.create("CD", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, 
				result);
		
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enums found", cd.getTranslations().isEmpty());
		assertTrue("translation enums found", cd.getTranslations().size() == 10);
		assertEquals("error message count", 0, result.getHl7Errors().size());
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
		
		XmlToModelResult result = new XmlToModelResult();
		CD cd = (CD) this.parser.parse(
				ParserContextImpl.create("CD", MockCharacters.class, V02R02.getVersionLiteral(), OPTIONAL), 
				node, 
				result);
		
		assertNotNull("main enum found", cd.getValue());
		assertFalse("translation enums found", cd.getTranslations().isEmpty());
		assertTrue("translation enums found", cd.getTranslations().size() == 11);
		assertEquals("error message count", 1, result.getHl7Errors().size());
		assertEquals("main code", "BARNEY", cd.getValue().getCodeValue());
		assertEquals("translation", "FRED", cd.getTranslations().get(0).getValue().getCodeValue());
		assertEquals("translation", "BETTY", cd.getTranslations().get(10).getValue().getCodeValue());
		assertEquals("error message", 
				"A maximum of 10 translations are allowed for any given code.", 
				result.getHl7Errors().get(0).getMessage());
		assertEquals("error type", 
				Hl7ErrorCode.DATA_TYPE_ERROR, 
				result.getHl7Errors().get(0).getHl7ErrorCode());
	}
}
