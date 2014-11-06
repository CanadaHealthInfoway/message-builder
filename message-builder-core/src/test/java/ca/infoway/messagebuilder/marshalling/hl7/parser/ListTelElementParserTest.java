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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.xml.Cardinality;

public class ListTelElementParserTest extends ParserTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top><telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=1\"/>" + 
				                    "<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-416-555-2345;ext=2\"/></top>");

		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02, null, null, null, Cardinality.create("0-4"), null), 
				asList(node.getChildNodes()), this.xmlResult);
		
		assertTrue(this.xmlResult.isValid());
		@SuppressWarnings("unchecked")
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		TelecommunicationAddress phone1 = list.get(0);
		TelecommunicationAddress phone2 = list.get(1);
		assertEquals("+1-519-555-2345;ext=1", phone1.getAddress());
		assertEquals("+1-416-555-2345;ext=2", phone2.getAddress());
	}
	
	@Test
	public void testParseWithMinimumViolation() throws Exception {
		Node node = createNode("<top><telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=1\"/>" + 
				                    "<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-416-555-2345;ext=2\"/></top>");

		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02, null, null, null, Cardinality.create("3-5"), null), 
				asList(node.getChildNodes()), this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("Number of elements (2) is less than the specified minimum (3)", this.xmlResult.getHl7Errors().get(0).getMessage());
		
		@SuppressWarnings("unchecked")
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 2, list.size());
		TelecommunicationAddress phone1 = list.get(0);
		TelecommunicationAddress phone2 = list.get(1);
		assertEquals("+1-519-555-2345;ext=1", phone1.getAddress());
		assertEquals("+1-416-555-2345;ext=2", phone2.getAddress());
	}
	
	@Test
	public void testParseWithMaximumViolation() throws Exception {
		Node node = createNode("<top><telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=1\"/>" +
									"<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=2\"/>" +
									"<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-519-555-2345;ext=3\"/>" +
				                    "<telecom specializationType=\"TEL.PHONE\" value=\"tel:+1-416-555-2345;ext=4\"/></top>");

		BareANY result = new ListElementParser().parse(ParserContextImpl.create("LIST<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02, null, null, null, Cardinality.create("1-2"), null), 
				asList(node.getChildNodes()), this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("Number of elements (4) is more than the specified maximum (2)", this.xmlResult.getHl7Errors().get(0).getMessage());
		
		@SuppressWarnings("unchecked")
		List<TelecommunicationAddress> list = ((LIST<TEL,TelecommunicationAddress>) result).rawList();
		assertNotNull("null", list);
		assertEquals("size", 4, list.size());
		TelecommunicationAddress phone1 = list.get(0);
		TelecommunicationAddress phone2 = list.get(1);
		TelecommunicationAddress phone3 = list.get(2);
		TelecommunicationAddress phone4 = list.get(3);
		assertEquals("+1-519-555-2345;ext=1", phone1.getAddress());
		assertEquals("+1-519-555-2345;ext=2", phone2.getAddress());
		assertEquals("+1-519-555-2345;ext=3", phone3.getAddress());
		assertEquals("+1-416-555-2345;ext=4", phone4.getAddress());
	}
}
