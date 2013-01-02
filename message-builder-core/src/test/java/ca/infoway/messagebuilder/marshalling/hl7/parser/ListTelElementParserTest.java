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

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;

public class ListTelElementParserTest extends ParserTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top><telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=1\"/>" + 
				                    "<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-416-555-2345;ext=2\"/></top>");

		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02, null, null, null), 
				asList(node.getChildNodes()), this.xmlResult);
		Assert.assertTrue(this.xmlResult.isValid());
		@SuppressWarnings("unchecked")
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		TelecommunicationAddress phone1 = list.get(0);
		TelecommunicationAddress phone2 = list.get(1);
		assertEquals("+1-519-555-2345;ext=1", phone1.getAddress());
		assertEquals("+1-416-555-2345;ext=2", phone2.getAddress());
	}
}
