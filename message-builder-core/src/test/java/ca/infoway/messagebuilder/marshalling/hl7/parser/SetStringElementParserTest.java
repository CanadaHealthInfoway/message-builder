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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetStringElementParserTest extends ParserTestCase {

	@Test
	@SuppressWarnings("unchecked")
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something>Fred</something>" +
				"<something>Wilma</something>" +
				"<something>Betty</something>" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<ST>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				null);
		Set<String> set = ((SET<ST,String>) result).rawSet();
		
		assertNotNull("null", set);
		assertEquals("size", 3, set.size());
		assertTrue("Fred", set.contains("Fred"));
		assertTrue("Wilma", set.contains("Wilma"));
		assertTrue("Betty", set.contains("Betty"));
	}
}
