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
 * Last modified: $LastChangedDate: 2014-03-13 09:26:14 -0400 (Thu, 13 Mar 2014) $
 * Revision:      $LastChangedRevision: 8457 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IiR2ElementParserTest extends CeRxDomainValueTestCase {
	
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
		II ii = (II) new IiR2ElementParser().parse(createContext("II.BUS"), node, this.result);
		assertNotNull("null result", ii);
		assertTrue("has null flavor", ii.hasNullFlavor());
		assertEquals("NI null flavor", NullFlavor.NO_INFORMATION, ii.getNullFlavor());
		assertTrue(this.result.isValid());
	}

	private ParseContext createContext(String type) {
		return createContext(type, SpecificationVersion.V02R02);
	}

	private ParseContext createContext(String type, SpecificationVersion version) {
		return ParseContextImpl.create(type, null, version, null, null, ConformanceLevel.OPTIONAL, null, null, false);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		// error should be: root is mandatory 
		Node node = createNode("<something/>");
		new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertFalse("result", result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		// error should be: root is mandatory 
		Node node = createNode("<something notvalue=\"\" />");
		new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertFalse("result", result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
	}
	
	@Test
	public void testParseValidOneAttribute() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null, null, null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIi() throws Exception {
		Node node = createNode("<something root=\"1.222.333\" extension=\"extensionValue\" assigningAuthorityName=\"aaName\" displayable=\"d_true\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.222.333", "extensionValue", "aaName", "d_true");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidIiAsUuid() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString(), null, null, null);
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiBadUuid() throws Exception {
		UUID uuid = UUID.randomUUID();
		Node node = createNode("<something root=\"" + uuid.toString() + "_garbage\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), uuid.toString() + "_garbage", null);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("must conform to be either a UUID, RUID, or OID."));
	}
	
	@Test
	public void testParseValidIiOid() throws Exception {
		Node node = createNode("<something root=\"111.222.333\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "111.222.333", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseInvalidIiOid() throws Exception {
		Node node = createNode("<something root=\"345.333.444\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "345.333.444", null);
		assertEquals("type", Identifier.class, ii.getValue().getClass());
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorCode.DATA_TYPE_ERROR, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("must conform to be either a UUID, RUID, or OID."));
	}
	
	@Test
	public void testParseValidMultipleAttributesDifferentOrder() throws Exception {
		Node node = createNode("<something displayable=\"d_false\" extension=\"extensionValue\"  root=\"1.2.2.1\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II"), node, this.result);
		assertResultAsExpected(ii.getValue(), "1.2.2.1", "extensionValue", null, "d_false");
		assertTrue(this.result.isValid());
	}
	
	@Test
	public void testParseValidMultipleAttributesPlusExtra() throws Exception {
		Node node = createNode("<something extra=\"extraValue\" root=\"2.1.2.1\" extension=\"extensionValue\" displayable=\"true\" />");
		II ii = (II) new IiR2ElementParser().parse(createContext("II.PUBLIC"), node, this.result);
		assertResultAsExpected(ii.getValue(), "2.1.2.1", "extensionValue", null, "true");
		assertTrue(this.result.isValid());
	}

	private void assertResultAsExpected(Identifier result, String rootValue, String extensionValue) {
		assertResultAsExpected(result, rootValue, extensionValue, null, null);
	}

	private void assertResultAsExpected(Identifier result, String rootValue, String extensionValue, String assigningAuthorityName, String displayable) {
		assertNotNull("populated result returned", result);
		assertEquals("root", rootValue, result.getRoot());
		assertEquals("extension", extensionValue, result.getExtension());
	}

	@Test
	public void testIsOid() throws Exception {
		assertOid("1.2.3");
		assertNotOid("1.2.3.");
		assertNotOid("1.2.3..4");
		assertOid("0.2.3");
		assertOid("01.2.3");
		assertOid("1.2.3");
		assertOid("2.2.3");
		assertNotOid("3.2.3.4");
		assertNotOid("4.2.3.4");
		assertNotOid("5.2.3.4");
		assertNotOid("6.2.3.4");
		assertNotOid("7.2.3.4");
		assertNotOid("8.2.3.4");
		assertNotOid("9.2.3.4");
		assertNotOid("91.2.3.4");
		assertOid("1.22.33.456");
		assertOid("1.22.3.456.333.23231.123");
		assertOid("1.22.3.456.333.23231.0");
	}
	
	private void assertOid(String oid) {
		assertTrue(oid, II_VALIDATION_UTILS.isOid(oid, true));
	}
	private void assertNotOid(String oid) {
		assertFalse(oid, II_VALIDATION_UTILS.isOid(oid, true));
	}
}
