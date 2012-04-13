/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IiElementParserTest extends CeRxDomainValueTestCase {
	
	private XmlToModelResult result;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.result = new XmlToModelResult();
	}

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertNotNull("null result", ii);
		assertTrue("has null flavor", ii.hasNullFlavor());
		assertEquals("NI null flavor", NullFlavor.NO_INFORMATION, ii.getNullFlavor());
	}

	private ParseContext createContext(String type) {
		return createContext(type, SpecificationVersion.V02R02);
	}

	private ParseContext createContext(String type, SpecificationVersion version) {
		return ParserContextImpl.create(type, null, version, null, null, ConformanceLevel.OPTIONAL);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertFalse("result", result.isValid());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertFalse("result", result.isValid());
	}
	
	@Test
	public void testParseValidOneAttribute() throws Exception {
		Node node = createNode("<something root=\"rootValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", null);
	}
	
	@Test
	public void testParseValidTwoAttributes() throws Exception {
		Node node = createNode("<something root=\"rootValue\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
	}
	
	@Test
	public void testParseValidTwoAttributesAsId() throws Exception {
		Node node = createNode("<something root=\"rootValue\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.OID"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
		assertEquals("type", Identifier.class, ii.getValue().getClass());
	}
	
	@Test
	public void testParseValidTwoAttributesDifferentOrder() throws Exception {
		Node node = createNode("<something extension=\"extensionValue\"  root=\"rootValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
	}
	
	@Test
	public void testParseValidTwoAttributesPlusExtra() throws Exception {
		Node node = createNode("<something extra=\"extraValue\" root=\"rootValue\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
	}

	@Ignore
	@Test
	public void testParseInvalidMissingSpecializationType() throws Exception {
		// TM/BM - decided that validating for SpecializationType for the II case caused CHI and users more grief than benefit
		Node node = createNode("<something root=\"rootValue\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("specializationType"));
	}
	
	@Test
	public void testParseValidMissingSpecializationTypeForCeRx() throws Exception {
		Node node = createNode("<something root=\"rootValue\" extension=\"extensionValue\" />");
		ParseContext context = createContext("II", SpecificationVersion.V01R04_3);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidMissingSpecializationTypeForAB() throws Exception {
		Node node = createNode("<something root=\"rootValue\" extension=\"extensionValue\" />");
		ParseContext context = createContext("II", SpecificationVersion.V02R02_AB);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "rootValue", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidSpecializationType() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" specializationType=\"II.BUS\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiPublicForMr2007() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" displayable=\"true\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.PUBLIC"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiPublicForMr2007() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" displayable=\"true\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.PUBLIC"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("should not include"));
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("'use'"));
	}
	
	@Test
	public void testParseValidIiPublicForMr2009() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" displayable=\"true\" use=\"BUS\" />");
		ParseContext context = createContext("II.PUBLIC", SpecificationVersion.R02_04_03);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiPublicForMr2009() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" displayable=\"true\" />");
		ParseContext context = createContext("II.PUBLIC", SpecificationVersion.R02_04_03);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("requires the attribute use=\"BUS\""));
	}
	
	private void assertResultAsExpected(Identifier result, String rootValue, String extensionValue) {
		assertNotNull("populated result returned", result);
		
		if (rootValue == null) {
			assertNull("null root", result.getRoot());
		} else {
			assertEquals("root", rootValue, result.getRoot());
		}
		
		if (extensionValue == null) {
			assertNull("null extension", result.getExtension());
		} else {
			assertEquals("extension", extensionValue, result.getExtension());
		}
	}

	@Test
	public void testIsOid() throws Exception {
		assertOid("1.2.3");
		assertNotOid("1.2.3.");
		assertNotOid("1.2.3..4");
		assertNotOid(".2.3.4");
		assertOid("1.22.33.456");
		assertOid("1.22.3.456.333.23231.123");
		assertOid("1.22.3.456.333.23231.0");
	}
	
	private void assertOid(String oid) {
		assertTrue(oid, new IiElementParser().isOid(oid));
	}
	private void assertNotOid(String oid) {
		assertFalse(oid, new IiElementParser().isOid(oid));
	}
}
