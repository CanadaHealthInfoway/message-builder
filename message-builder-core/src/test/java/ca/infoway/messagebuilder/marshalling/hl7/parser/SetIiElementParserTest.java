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

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * @sharpen.ignore - test - translated manually 
 */
public class SetIiElementParserTest extends ParserTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"rootValue\" extension=\"fred\" />" +
				"<something root=\"rootValue2\" extension=\"extensionValue\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<II>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				asList(node.getChildNodes()), new XmlToModelResult());
		@SuppressWarnings("unchecked")
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		assertNotNull("null", rawSet);
		assertEquals("size", 2, rawSet.size());
		assertThat(rawSet, hasItem(new Identifier("rootValue", "fred")));
		assertThat(rawSet, hasItem(new Identifier("rootValue2", "extensionValue")));
	}

	@Test
	public void rawValueCanBeAddedToParsedValue() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.1\" extension=\"fred\" use=\"BUS\"/>" +
				"<something root=\"2.2\" extension=\"extensionValue\" use=\"BUS\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<II.BUS>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				asList(node.getChildNodes()), null);
		@SuppressWarnings({ "unchecked"})
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		
		rawSet.add(new Identifier("3.3", "newExtension"));
		
		assertEquals("size", 3, rawSet.size());
		assertThat(rawSet, hasItem(new Identifier("3.3", "newExtension")));
	}
	
	@Test
	public void duplicatesShouldLogValidationError() throws Exception {
		Node node = createNode("<top>" +
				"<something root=\"1.1\" extension=\"fred\" use=\"BUS\"/>" +
				"<something root=\"2.2\" extension=\"extensionValue\" use=\"BUS\" />" +
				"<something root=\"2.2\" extension=\"extensionValue\" use=\"BUS\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<II.BUS>", null, SpecificationVersion.V02R02, null, null, ConformanceLevel.MANDATORY, null), 
				asList(node.getChildNodes()), this.xmlResult);
		
		@SuppressWarnings({ "unchecked"})
		Set<Identifier> rawSet = ((SET<II,Identifier>) result).rawSet();
		assertEquals("size", 2, rawSet.size());
		assertThat(rawSet, hasItem(new Identifier("1.1", "fred")));
		assertThat(rawSet, hasItem(new Identifier("2.2", "extensionValue")));
		
		assertEquals("errors", 1, this.xmlResult.getHl7Errors().size());
		assertEquals("message", "Duplicate value not allowed for SET", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
}
