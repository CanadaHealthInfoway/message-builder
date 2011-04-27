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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class StElementParserTest extends MarshallingTestCase {
	
	@Test
	public void shouldParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		ST st = (ST) new StElementParser().parse(createStContext("ST"), node, this.xmlJavaResult);
		
		assertNull("null returned", st.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, st.getNullFlavor());
	}

	private ParseContext createStContext(String type) {
		return ParserContextImpl.create(type, String.class, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.OPTIONAL, null, 25);
	}

	@Test
	public void shouldParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertEquals("null returned", 
				"", 
				new StElementParser().parse(createStContext("ST"), node, this.xmlJavaResult).getBareValue());
	}

	@Test
	public void shouldRespectMaximumLength() throws Exception {
		ParseContext context = createStContext("ST");
		Node node = createNode("<something>This is a fairly long value; too long, in fact, for the field</something>");
		assertEquals("null returned", 
				"This is a fairly long val", 
				new StElementParser().parse(
						context, 
						node, this.xmlJavaResult).getBareValue());
		assertFalse("valid", this.xmlJavaResult.isValid());
		
		System.out.println(this.xmlJavaResult.getHl7Errors().get(0).getMessage());
		assertEquals("message", 
				"The specified string (\"This is a fairly long value; too long, in fact,...\") exceeds the maximum length of 25.  The string has been truncated.",
				this.xmlJavaResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void shouldParseTextNode() throws Exception {
		Node node = createNode("<something>text value</something>");
		assertEquals("proper text returned", 
				"text value", 
				new StElementParser().parse(createStContext("ST"), node, this.xmlJavaResult).getBareValue());
	}
	
	@Test
	public void shouldParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something language=\"fr-CA\" representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
		ST result = (ST) new StElementParser().parse(createStContext("ST.LANG"), node, this.xmlJavaResult);
		assertEquals("proper text returned", "text value", result.getValue());
		assertEquals("proper language returned", "fr-CA", result.getLanguage());
	}
	
	@Test
	public void shouldParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		try {
			new StElementParser().parse(createStContext("ST"), node, this.xmlJavaResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected ST node to have at most one child", e.getMessage());
		}
	}

	@Test
	public void shouldParseNotATextNode() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new StElementParser().parse(createStContext("ST"), node, this.xmlJavaResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected ST node to have a text node", e.getMessage());
		}
	}
}
