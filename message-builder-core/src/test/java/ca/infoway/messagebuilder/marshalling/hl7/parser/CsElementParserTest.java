/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class CsElementParserTest extends MarshallingTestCase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
        CodeResolverRegistry.registerResolver(MockEnum.class, new EnumBasedCodeResolver(MockEnum.class));
	}

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		CS acknowledgementCondition = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		assertTrue(acknowledgementCondition.hasNullFlavor());
		assertEquals(NullFlavor.NO_INFORMATION, acknowledgementCondition.getNullFlavor());
	}

	@Test
	public void testParseContainsCodeSystem() throws Exception {
		Node node = createNode("<something code=\"ER\" codeSystem=\"1.2.3.4\" />");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		
		assertNotNull("cs", cs);
		assertNotNull("code", cs.getValue());
		assertFalse("valid", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseContainsDisplayName() throws Exception {
		Node node = createNode("<something code=\"ER\" displayName=\"Error\" />");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		assertNotNull("cs", cs);
		assertNotNull("code", cs.getValue());
		assertFalse("valid", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseContainsCodeSystemName() throws Exception {
		Node node = createNode("<something code=\"ER\" codeSystemName=\"My code system\" />");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		assertNotNull("cs", cs);
		assertNotNull("code", cs.getValue());
		assertFalse("valid", this.xmlResult.isValid());
	}
	
	@Test
	public void testParseContainsOriginalText() throws Exception {
		Node node = createNode("<something code=\"ER\"><originalText>My original text</originalText></something>");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		
		assertNotNull("cs", cs);
		assertNotNull("code", cs.getValue());
		assertFalse("valid", this.xmlResult.isValid());
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		assertNull("empty node returns null", cs.getValue());
	}

	@Test
	public void testParseNoCodeAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, SpecificationVersion.V02R02, ConformanceLevel.OPTIONAL), 
				node, this.xmlResult);
		assertNull("node with no code attribute returns null", cs.getValue());
	}
	
	@Test
	public void testParseValid() throws Exception {
		Node node = createNode("<something code=\"ER\" />");
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockCode.class, SpecificationVersion.V02R02, ConformanceLevel.OPTIONAL), 
				node, null);
		assertEquals("node with code attribute returns value", "ER", cs.getValue().getCodeValue());
	}
	
	@Test
	public void testParseValidEnumCode() throws Exception {
		Node node = createNode("<something code=\"FRED\" />");
		
		XmlToModelResult result = new XmlToModelResult();
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockEnum.class, V02R02, OPTIONAL), 
				node, result);
		assertEquals("enum found properly", MockEnum.FRED, cs.getValue());
		assertEquals("error message count", 0, result.getHl7Errors().size());
	}
	
	@Test
	public void testParseInvalidEnumCode() throws Exception {
		Node node = createNode("<something code=\"ER\" />");
		
		CS cs = (CS) new CsElementParser().parse(
				ParserContextImpl.create("CS", MockEnum.class, V02R02, OPTIONAL), 
				node, this.xmlResult);
		assertNull("bogus enum not found", cs.getValue());
		assertEquals("error message count", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("error message", 
				"The code, \"ER\", in element <something> is not a valid value for domain type \"MockEnum\"", 
				this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("error type", 
				Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, 
				this.xmlResult.getHl7Errors().get(0).getHl7ErrorCode());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");

        CS cs = (CS) new CsElementParser().parse(
        		ParserContextImpl.create("CS", MockCode.class, V02R02, OPTIONAL), 
        		node, this.xmlResult);
        assertNull("empty node with children returns null", cs.getValue());
	}
}
