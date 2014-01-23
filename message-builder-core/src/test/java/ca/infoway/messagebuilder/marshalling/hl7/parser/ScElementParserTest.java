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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.SC;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.domainvalue.State;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockCharacters;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@SuppressWarnings("unchecked")
public class ScElementParserTest extends CeRxDomainValueTestCase {
    
    private static String EMPTY_STRING = "";

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockCharacters.class, new EnumBasedCodeResolver(MockEnum.class));
	}
	
    @Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		SC<Code> sc = (SC<Code>) new ScElementParser().parse(createContext(), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertNull("null returned", sc.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, sc.getNullFlavor());
	}
    
	private ParseContext createContext() {
		return ParserContextImpl.create("SC", CodedString.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser().parse(null, node, this.xmlResult).getBareValue();

		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper error reported", "SC datatypes must have a string value (<something/>)", this.xmlResult.getHl7Errors().get(0).getMessage());
        assertEquals("empty string returned", EMPTY_STRING, result.getValue());
        assertEquals("null code", null, result.getCode());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
		CodedString<Code> result = (CodedString<Code>) new ScElementParser().parse(null, node, this.xmlResult).getBareValue();

		assertTrue(this.xmlResult.isValid());
		assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
	}
	
	@Test
    public void testParseTextNodeWithAttributes() throws Exception {
        Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser().parse(null, node, this.xmlResult).getBareValue();
        
		assertTrue(this.xmlResult.isValid());
        assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
    }
    
	@Test
    public void testParseTextNodeWithCodeAttributesSomeErrors() throws Exception {
        Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\" code=\"AB\">text value</something>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser().parse(
        		ParserContextImpl.create("SC", new CodedString<State>(null ,null).getClass(), SpecificationVersion.V02R02, null, null, null, null), 
        		node, 
        		this.xmlResult).getBareValue();
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("proper error reported", "For SC datatypes, if code or code system is provided then the other value must also be provided (<something code=\"AB\" mediaType=\"text/plain\" representation=\"TXT\">)", this.xmlResult.getHl7Errors().get(0).getMessage());
        assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
    }
    
	@Test
    public void testParseTextNodeWithCodeAttributes() throws Exception {
        ParseContext context = ParserContextImpl.create("SC", MockCharacters.class, SpecificationVersion.V02R02, null, null, null, null);
        
        Node node = createNode("<something code=\"FRED\" codeSystem=\"1.2.3.4.5\" displayName=\"some text\" codeSystemName=\"cs name\" codeSystemVersion=\"cs version\">text value</something>");
        
		CodedString<Code> result = (CodedString<Code>) new ScElementParser().parse(
        		context, 
        		node, 
        		this.xmlResult).getBareValue();
		
		assertTrue(this.xmlResult.isValid());
		assertEquals(MockEnum.FRED, result.getCode());
		assertEquals("cs name", result.getCodeSystemName());
		assertEquals("cs version", result.getCodeSystemVersion());
		assertEquals("some text", result.getDisplayName());
		assertEquals("text value", result.getValue());
    }
    
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		new ScElementParser().parse(null, node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
		assertEquals("proper error reported", "Expected SC node to have at most one child", this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("proper error reported", "SC datatypes must have a string value (<something>)", this.xmlResult.getHl7Errors().get(1).getMessage());
	}

	@Test
	public void testParseNotATextNode() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		new ScElementParser().parse(null, node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());
		assertEquals("proper error reported", "Expected SC node to have a text node", this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("proper error reported", "SC datatypes must have a string value (<something>)", this.xmlResult.getHl7Errors().get(1).getMessage());
	}
}
