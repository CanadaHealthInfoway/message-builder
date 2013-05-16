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

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class BlElementParserTest extends CeRxDomainValueTestCase {
	
	private ParseContext context;
	private XmlToModelResult result;
	private BlElementParser parser;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.context = ParserContextImpl.create("BL", Boolean.class, SpecificationVersion.V02R02, null, null, null, null);
		this.result = new XmlToModelResult();
		this.parser = new BlElementParser();
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		assertNull("null returned", process(node));
		assertFalse("result", this.result.isValid());
	}

	private Boolean process(Node node) throws Exception {
		return (Boolean) this.parser.parse(this.context, node, this.result).getBareValue();
	}

	@Test
	public void testParseNullFlavorNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\"/>");
		assertNull("null returned", process(node));

		node = createNode("<something nullFlavor=\"NI\" value=\"true\"/>");
		assertNull("null returned even though true was specified", process(node));
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		assertNull("null returned", process(node));
	}
	
	@Test
	public void testParseValueAttributeTrue() throws Exception {
		Node node = createNode("<something value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node));
	}
	
	@Test
	public void testParseValueAttributeFalse() throws Exception {
		Node node = createNode("<something value=\"false\" />");
		assertEquals("correct value returned", Boolean.FALSE, process(node));
	}
	
	@Test
	public void testParseValueWrongCase() throws Exception {
		Node node = createNode("<something value=\"False\" />");
		Boolean b = process(node);
		assertEquals("correct value returned", Boolean.FALSE, b);
		assertFalse("valid", this.result.isValid());
	}
	
	@Test
	public void testParseValueAttributeTruePlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"true\" />");
		assertEquals("correct value returned", Boolean.TRUE, process(node));
	}

	@Test
	public void testParseInvalidValueAttribute() throws Exception {
		Node node = createNode("<something value=\"19990355\" />");
		process(node);
		assertFalse("error", this.result.isValid());
	}
}
