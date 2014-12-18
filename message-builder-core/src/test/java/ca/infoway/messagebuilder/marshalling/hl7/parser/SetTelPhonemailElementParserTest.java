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

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetTelPhonemailElementParserTest extends ParserTestCase {

	private ParserRegistry parserRegistry = ParserRegistry.getInstance();
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something specializationType=\"TEL.EMAIL\" value=\"mailto://Fred\"/>" +
				"<something specializationType=\"TEL.EMAIL\" value=\"mailto://Wilma\"/>" +
				"</top>");
		
		BareANY result = new SetElementParser(this.parserRegistry).parse(
				ParseContextImpl.create("SET<TEL.PHONEMAIL>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), null, false), 
				asList(node.getChildNodes()), 
				null);
		Set<TelecommunicationAddress> set = ((SET<TEL,TelecommunicationAddress>) result).rawSet();
		assertNotNull("null", set);
		assertEquals("size", 2, set.size());
		
		Set<String> expectedStrings = new HashSet<String>();
		expectedStrings.add("Fred");
		expectedStrings.add("Wilma");
		
		for (TelecommunicationAddress address : set) {
			assertEquals("urlscheme", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
			assertTrue("expected set contains address", expectedStrings.contains(address.getAddress()));
			expectedStrings.remove(address.getAddress());
		}
	}
	
	@Test
	public void testParseWithDuplicates() throws Exception {
		Node node = createNode("<top>" +
				"<telecom specializationType=\"TEL.EMAIL\"  value=\"mailto:doctorLocation@doctor.org\"/>" + 
				"<telecom specializationType=\"TEL.EMAIL\"  value=\"mailto:doctorLocation@doctor.org\"/>" +
				"</top>");
		
		BareANY result = new SetElementParser(this.parserRegistry).parse(
				ParseContextImpl.create("SET<TEL.PHONEMAIL>", null, SpecificationVersion.V01R04_3, null, null, ConformanceLevel.MANDATORY, Cardinality.create("1-5"), null, false), 
				asList(node.getChildNodes()), 
				this.xmlResult);
		
		Set<TelecommunicationAddress> set = ((SET<TEL,TelecommunicationAddress>) result).rawSet();
		assertNotNull("null", set);
		assertEquals("size", 1, set.size());
		
		for (TelecommunicationAddress address : set) {
			assertEquals("urlscheme", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
			assertEquals("address", "doctorLocation@doctor.org", address.getAddress());
		}
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("Duplicate value not allowed for SET", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
}
