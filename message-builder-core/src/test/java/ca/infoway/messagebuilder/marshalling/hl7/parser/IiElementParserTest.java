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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IiElementParserTest extends CeRxDomainValueTestCase {
	
	private XmlToModelResult result;
	private static final IiValidationUtils II_VALIDATION_UTILS = new IiValidationUtils();

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
		assertTrue(this.result.isValid());
	}

	private ParseContext createContext(String type) {
		return createContext(type, SpecificationVersion.V02R02);
	}

	private ParseContext createContext(String type, SpecificationVersion version) {
		return ParserContextImpl.create(type, null, version, null, null, ConformanceLevel.OPTIONAL, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		// errors should be: 1) use must be BUS 2) root is mandatory 
		Node node = createNode("<something/>");
		new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertFalse("result", result.isValid());
		assertEquals(2, this.result.getHl7Errors().size());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		// errors should be: 1) use must be BUS 2) root is mandatory 
		Node node = createNode("<something notvalue=\"\" />");
		new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertFalse("result", result.isValid());
		assertEquals(2, this.result.getHl7Errors().size());
	}
	
	@Test
	public void testParseValidOneAttribute() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiBus() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiBusAndVerAsBus() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" use=\"BUS\" specializationType=\"II.BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS_AND_VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBusAndVerAsVer() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" use=\"VER\" specializationType=\"II.VER\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS_AND_VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBusAndVerDefaultToIiBus() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS_AND_VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Specialization type must be II.BUS or II.VER; II.BUS will be assumed. "));
	}
	
	@Test
	public void testParseInvalidIiBusAndVerDefaultToIiBusAsABestGuess() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS_AND_VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(2, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Specialization type must be II.BUS or II.VER; II.BUS will be assumed. "));
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(1).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(1).getMessage().contains("use"));
	}
	
	@Test
	public void testParseInvalidIiBusAndVerDefaultToIiVer() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" use=\"VER\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS_AND_VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Specialization type must be II.BUS or II.VER; II.VER will be assumed. "));
	}
	
	@Test
	public void testParseValidIiBusVer() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" use=\"BUS\" version=\"1\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUSVER"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertEquals("version", "1", ii.getValue().getVersion());
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiPublicVer() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" version=\"1\" displayable=\"true\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.PUBLICVER"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue");
		assertEquals("version", "1", ii.getValue().getVersion());
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiToken() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.TOKEN"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiTokenBadUuid() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "garbage\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.TOKEN"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString() + "garbage", null);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("should be a UUID"));
	}
	
	@Test
	public void testParseValidIiVer() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" use=\"VER\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.VER"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiOid() throws Exception {
		Node node = createNode("<something root=\"111.222.333\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.OID"), node, this.result);
		assertResultAsExpected(ii.getValue(), "111.222.333", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiOid() throws Exception {
		Node node = createNode("<something root=\"not_an_oid\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.OID"), node, this.result);
		assertResultAsExpected(ii.getValue(), "not_an_oid", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("does not appear to be a valid oid"));
	}
	
	@Test
	public void testParseValidIiOidForMR2009() throws Exception {
		Node node = createNode("<something root=\"111.222.333\" use=\"BUS\" />");
		ParseContext context = createContext("II.OID", SpecificationVersion.R02_04_03);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "111.222.333", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiOidForMR2009() throws Exception {
		Node node = createNode("<something root=\"111.222.333\" use=\"BSU\" />");
		ParseContext context = createContext("II.OID", SpecificationVersion.R02_04_03);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "111.222.333", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertFalse(this.result.isValid());
	}
	
	@Test
	public void testParseValidMultipleAttributesDifferentOrder() throws Exception {
		Node node = createNode("<something use=\"BUS\" extension=\"extensionValue\"  root=\"1.2.2.1\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.2.1", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidMultipleAttributesPlusExtra() throws Exception {
		Node node = createNode("<something extra=\"extraValue\" root=\"2.1.2.1\" extension=\"extensionValue\" displayable=\"true\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.PUBLIC"), node, this.result);
		assertResultAsExpected(ii.getValue(), "2.1.2.1", "extensionValue");
		assertTrue(this.result.isValid());
	}

	@Test
	public void testParseInvalidMissingSpecializationType() throws Exception {
		// TM/BM - decided that validating for SpecializationType for the II case caused CHI and users more grief than benefit (LATER: TM - code does not agree with this statement!)
		Node node = createNode("<something root=\"1.3.1.2\" extension=\"extensionValue\" />");
		II ii = (II) new IiElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.3.1.2", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Missing specializationType"));
	}
	
	@Test
	public void testParseInvalidUnknownSpecializationType() throws Exception {
		Node node = createNode("<something root=\"1.3.1.2\" extension=\"extensionValue\" specializationType=\"II.DOES_NOT_EXIST\" />");
		II ii = (II) new IiElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.3.1.2", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("Invalid specializationType"));
	}
	
	@Test
	public void testParseSpecializationTypeProvidedWhenNotNecessary() throws Exception {
		Node node = createNode("<something root=\"1.3.1.2\" extension=\"extensionValue\" use=\"BUS\" specializationType=\"II.BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.3.1.2", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("A specializationType should not be specified for non-abstract type: II.BUS"));
	}
	
	@Test
	public void testParseValidMissingSpecializationTypeForCeRx() throws Exception {
		Node node = createNode("<something root=\"1.2.3.4\" extension=\"extensionValue\" />");
		ParseContext context = createContext("II", SpecificationVersion.V01R04_3);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.4", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidMissingSpecializationTypeForAB() throws Exception {
		Node node = createNode("<something root=\"1.2.3.3\" extension=\"extensionValue\" />");
		ParseContext context = createContext("II", SpecificationVersion.V02R02_AB);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.3", "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidMissingSpecializationTypeForAB() throws Exception {
		Node node = createNode("<something root=\"1.2.3.3\" extension=\"extensionValue\" use=\"BUS\" />");
		ParseContext context = createContext("II.BUS_AND_VER", SpecificationVersion.V02R02_AB);
		II ii = (II) new IiElementParser().parse(context, node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.3", "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("specialization type"));
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
	
	@Test
	public void testParseValidIiBusWithMaxRootLength() throws Exception {
		String maxLengthRoot = "123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.1234567890";
		Node node = createNode("<something root=\"" + maxLengthRoot + "\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), maxLengthRoot, "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBusWithMaxRootLengthPlusOne() throws Exception {
		String maxLengthRootPlusOne = "0" + "123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.1234567890";
		Node node = createNode("<something root=\"" + maxLengthRootPlusOne + "\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), maxLengthRootPlusOne, "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("exceeds maximum allowed length"));
	}
	
	@Test
	public void testParseValidIiBusWithMaxExtensionLength() throws Exception {
		String maxExtension = "12345678901234567890";
		Node node = createNode("<something root=\"1.2.3.3\" extension=\"" + maxExtension +  "\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.3", maxExtension);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBusWithMaxExtensionLengthPlusOne() throws Exception {
		String maxExtensionPlusOne = "0" + "12345678901234567890";
		Node node = createNode("<something root=\"1.2.3.3\" extension=\"" + maxExtensionPlusOne +  "\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.3.3", maxExtensionPlusOne);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("exceeds maximum allowed length"));
	}
	
	@Test
	public void testParseValidIiBusWithMaxRootLengthForCeRx() throws Exception {
		String maxLengthRoot = "123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.1234567890";
		Node node = createNode("<something root=\"" + maxLengthRoot + "\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS", SpecificationVersion.V01R04_3), node, this.result);
		assertResultAsExpected(ii.getValue(), maxLengthRoot, "extensionValue");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBusWithMaxRootLengthPlusOneForCeRx() throws Exception {
		String maxLengthRootPlusOne = "0" + "123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.1234567890";
		Node node = createNode("<something root=\"" + maxLengthRootPlusOne + "\" extension=\"extensionValue\" use=\"BUS\" />");
		II ii = (II) new IiElementParser().parse(createContext("II.BUS", SpecificationVersion.V01R04_3), node, this.result);
		assertResultAsExpected(ii.getValue(), maxLengthRootPlusOne, "extensionValue");
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("exceeds maximum allowed length"));
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
		assertTrue(oid, II_VALIDATION_UTILS.isOid(oid));
	}
	private void assertNotOid(String oid) {
		assertFalse(oid, II_VALIDATION_UTILS.isOid(oid));
	}
}
