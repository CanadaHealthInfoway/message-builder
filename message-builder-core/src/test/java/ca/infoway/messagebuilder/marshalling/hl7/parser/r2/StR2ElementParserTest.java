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
 * Last modified: $LastChangedDate: 2014-02-26 12:52:49 -0500 (Wed, 26 Feb 2014) $
 * Revision:      $LastChangedRevision: 8412 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class StR2ElementParserTest extends MarshallingTestCase {
	
	@Test
	public void shouldParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		
		ST st = (ST) new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult);
		
		assertNull("null returned", st.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, st.getNullFlavor());
		assertTrue(this.xmlResult.isValid());
	}

	private ParseContext createStContext(String type) {
		return createStContext(type, 25);
	}
	
	private ParseContext createStContext(String type, int length) {
		return ParserContextImpl.create(type, String.class, SpecificationVersion.V02R02, null, null, ConformanceLevel.OPTIONAL, null, null, length, null);
	}

	@Test
	public void shouldParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertEquals("null returned", 
				"", 
				new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult).getBareValue());
		assertTrue(this.xmlResult.isValid());
	}

	@Test
	public void shouldRespectMaximumLength() throws Exception {
		ParseContext context = createStContext("ST");
		Node node = createNode("<something>This is a fairly long value; too long, in fact, for the field</something>");
		assertEquals("null returned", 
				"This is a fairly long val", 
				new StR2ElementParser().parse(
						context, 
						node, this.xmlResult).getBareValue());
		assertFalse("valid", this.xmlResult.isValid());
		
		System.out.println(this.xmlResult.getHl7Errors().get(0).getMessage());
		assertEquals("message", 
				"The specified string (\"This is a fairly long value; too long, in fact,...\") exceeds the maximum length of 25.  The string has been truncated.",
				this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void shouldParseTextNode() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"TXT\">text value</something>");
		assertEquals("proper text returned", 
				"text value", 
				new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult).getBareValue());
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void shouldParseTextNodeAsCdata() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"TXT\"><![CDATA[<cats think they're > humans & dogs 99% of the time/>]]></something>");
		BareANY parseResult = new StR2ElementParser().parse(createStContext("ST", 100), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertTrue(parseResult instanceof ST);
		assertTrue("noted as cdata", ((ST) parseResult).isCdata());
		assertEquals("proper text returned", 
				"<cats think they're > humans & dogs 99% of the time/>", 
				parseResult.getBareValue());
		
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void shouldParseTextNodeWithEmptyCdata() throws Exception {
		Node node = createNode("<something mediaType=\"text/plain\" representation=\"TXT\"><![CDATA[]]></something>");
		BareANY parseResult = new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertTrue(parseResult instanceof ST);
		assertTrue("noted as cdata", ((ST) parseResult).isCdata());
		assertEquals("proper text returned", 
				"", 
				parseResult.getBareValue());
		
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void shouldParseTextNodeWithSpecialCharactersNotCdata() throws Exception {
		Node node = createNode("<something>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</something>");
		BareANY parseResult = new StR2ElementParser().parse(createStContext("ST", 100), node, this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		assertTrue(parseResult instanceof ST);
		assertFalse("not cdata", ((ST) parseResult).isCdata());
		assertEquals("proper text returned", 
				"<cats think they're > humans & dogs 99% of the time/>", 
				parseResult.getBareValue());
		
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void shouldParseTextNodeWithAttributes() throws Exception {
		Node node = createNode("<something language=\"fr-CA\" representation=\"TXT\" mediaType=\"text/plain\">text value</something>");
		ST result = (ST) new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult);
		assertEquals("proper text returned", "text value", result.getValue());
		assertEquals("proper language returned", "fr-CA", result.getLanguage());
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void shouldParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"<shines/>" +
				"</something>");
		try {
			new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected ST node to have at most one child", e.getMessage());
		}
		assertTrue(this.xmlResult.isValid());
	}

	@Test
	public void shouldParseNotATextNode() throws Exception {
		Node node = createNode(
				"<something>" +
				"<monkey/>" +
				"</something>");
		try {
			new StR2ElementParser().parse(createStContext("ST"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected ST node to have a text node", e.getMessage());
		}
		assertTrue(this.xmlResult.isValid());
	}
}
