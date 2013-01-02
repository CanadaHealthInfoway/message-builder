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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.SC;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.domainvalue.State;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ScElementParserTest extends CeRxDomainValueTestCase {
    
    private static String EMPTY_STRING = "";

    @Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		SC<Code> sc = (SC<Code>) new ScElementParser<Code>().parse(createContext(), node, null);
		
		assertNull("null returned", sc.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, sc.getNullFlavor());
	}
    
	private ParseContext createContext() {
		return ParserContextImpl.create("SC", CodedString.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser<Code>().parse(null, node, null).getBareValue();
        assertEquals("empty string returned", EMPTY_STRING, result.getValue());
        assertEquals("null code", null, result.getCode());
	}

	@Test
	public void testParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
		CodedString<Code> result = (CodedString<Code>) new ScElementParser<Code>().parse(null, node, null).getBareValue();
		assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
	}
	
	@Test
    public void testParseTextNodeWithAttributes() throws Exception {
        Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser<Code>().parse(null, node, null).getBareValue();
        assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
    }
    
	@Test
    public void testParseTextNodeWithCodeAttributes() throws Exception {
        Node node = createNode("<something representation=\"TXT\" mediaType=\"text/plain\" code=\"AB\">text value</something>");
        CodedString<Code> result = (CodedString<Code>) new ScElementParser<Code>().parse(
        		ParserContextImpl.create("SC", new CodedString<State>(null ,null).getClass(), SpecificationVersion.V02R02, null, null, null), 
        		node, 
        		null).getBareValue();
        assertEquals("proper text returned", "text value", result.getValue());
        assertEquals("null code", null, result.getCode());
    }
    
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		try {
			new ScElementParser().parse(null, node, null);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected SC node to have at most one child", e.getMessage());
		}
	}

	@Test
	public void testParseNotATextNode() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new ScElementParser().parse(null, node, null);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected SC node to have a text node", e.getMessage());
		}
	}
}
