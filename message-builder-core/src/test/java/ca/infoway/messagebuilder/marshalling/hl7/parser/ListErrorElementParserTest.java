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

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.Cardinality;

public class ListErrorElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		XmlToModelResult result = new XmlToModelResult();
		Node node = createNode("<top><name>Fred</name>" + 
				                    "<name>Flinstone</name></top>");
		new ListElementParser().parse(
				ParseContextImpl.create("LIST<ABCDEFGHIJKLMNOPQRSTUVWXYZ>", null, SpecificationVersion.V02R02, null, null, null, Cardinality.create("1-5"), null), 
				asList(node.getChildNodes()), result);
		
		assertFalse("valid", result.isValid());
		for (Hl7Error error : result.getHl7Errors()) {
			System.out.println(error);
		}
	}
}
