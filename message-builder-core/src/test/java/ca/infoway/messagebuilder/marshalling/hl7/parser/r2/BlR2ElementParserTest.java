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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;

public class BlR2ElementParserTest extends CeRxDomainValueTestCase {
	
	private ParseContext contextBL;
	private ParseContext contextBN;
	private XmlToModelResult result;
	private BlR2ElementParser parser;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.contextBL = ParserContextImpl.create("BL", Boolean.class, SpecificationVersion.V02R02, null, null, null, null);
		this.contextBN = ParserContextImpl.create("BN", Boolean.class, SpecificationVersion.R02_04_03, null, null, null, null);
		this.result = new XmlToModelResult();
		this.parser = new BlR2ElementParser();
	}

	// BL tests

	@Test
	public void testParseEmptyNodeBL() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", process(node, true));
		assertFalse("result", this.result.isValid());
	}

	private Boolean process(Node node, boolean asBL) throws Exception {
		return (Boolean) this.parser.parse(asBL ? this.contextBL : this.contextBN, node, this.result).getBareValue();
	}

	@Test
	public void testParseNullFlavorNodeBL() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		assertNull("null returned", process(node, true));
		assertTrue("result", this.result.isValid());

		node = createNode("<something nullFlavor=\"NI\" value=\"true\"/>");
		assertNull("null returned even though true was specified", process(node, true));
		assertTrue("result", this.result.isValid());
	}

	@Test
	public void testParseNoValueAttributeNodeBL() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", process(node, true));
		assertFalse("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueAttributeTrueBL() throws Exception {
		Node node = createNode("<something value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node, true));
		assertTrue("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueAttributeFalseBL() throws Exception {
		Node node = createNode("<something value=\"false\" />");
		assertEquals("correct value returned", Boolean.FALSE, process(node, true));
		assertTrue("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueWrongCaseBL() throws Exception {
		Node node = createNode("<something value=\"False\" />");
		Boolean b = process(node, true);
		assertFalse("valid", this.result.isValid());
		assertEquals("correct value returned", Boolean.FALSE, b);
	}
	
	@Test
	public void testParseValueAttributeTruePlusExtraAttributeBL() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node, true));
		assertTrue("result", this.result.isValid());
	}

	@Test
	public void testParseInvalidValueAttributeBL() throws Exception {
		Node node = createNode("<something value=\"19990355\" />");
		assertNull("null returned", process(node, true));
		assertFalse("error", this.result.isValid());
	}

	// BN tests
	
	@Test
	public void testParseEmptyNodeBN() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", process(node, false));
		assertFalse("result", this.result.isValid());
	}

	@Test
	public void testParseNullFlavorNodeBN() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		assertNull("null returned", process(node, false));
		assertFalse("result", this.result.isValid());
		
		this.result.clearErrors();

		node = createNode("<something nullFlavor=\"NI\" value=\"true\"/>");
		assertNull("null returned even though true was specified", process(node, false));
		assertFalse("result", this.result.isValid());
	}

	@Test
	public void testParseNoValueAttributeNodeBN() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", process(node, false));
		assertFalse("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueAttributeTrueBN() throws Exception {
		Node node = createNode("<something value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node, false));
		assertTrue("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueAttributeFalseBN() throws Exception {
		Node node = createNode("<something value=\"false\" />");
		assertEquals("correct value returned", Boolean.FALSE, process(node, false));
		assertTrue("result", this.result.isValid());
	}
	
	@Test
	public void testParseValueWrongCaseBN() throws Exception {
		Node node = createNode("<something value=\"False\" />");
		Boolean b = process(node, false);
		assertFalse("valid", this.result.isValid());
		assertEquals("correct value returned", Boolean.FALSE, b);
	}
	
	@Test
	public void testParseValueAttributeTruePlusExtraAttributeBN() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node, false));
		assertTrue("result", this.result.isValid());
	}

	@Test
	public void testParseInvalidValueAttributeBN() throws Exception {
		Node node = createNode("<something value=\"19990355\" />");
		assertNull("null returned", process(node, false));
		assertFalse("error", this.result.isValid());
	}
	
}
