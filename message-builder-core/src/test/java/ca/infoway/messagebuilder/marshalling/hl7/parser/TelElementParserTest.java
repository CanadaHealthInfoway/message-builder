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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TelElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		TEL tel = (TEL) new TelElementParser().parse(createContext("TEL.PHONE", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("null returned", tel.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, tel.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParserContextImpl.create(type, TelecommunicationAddress.class, version, null, null, ConformanceLevel.POPULATED, null, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		new TelElementParser().parse(createContext("TEL.PHONE", SpecificationVersion.V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());  // missing scheme; missing address
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		new TelElementParser().parse(createContext("TEL.PHONE", SpecificationVersion.V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());  // missing scheme; missing address
	}
	
	@Test
	public void testParseInvalidValueAttributeNode() throws Exception {
		Node node = createNode("<something value=\"1234\" />");
		new TelElementParser().parse(createContext("TEL.PHONE", SpecificationVersion.V02R02), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals("HL7 error count", 1, this.xmlResult.getHl7Errors().size());
		
		Hl7Error hl7Error = this.xmlResult.getHl7Errors().get(0);
		assertEquals("error message", "TelecomAddress must have a valid URL scheme (e.g. 'http://') (<something value=\"1234\"/>)", hl7Error.getMessage());
		assertEquals("error message code", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());
	}
	
	@Test
	public void testParseInvalidValueUrlScheme() throws Exception {
		Node node = createNode("<something value=\"mailfrom://monkey\" />");
		
		new TelElementParser().parse(createContext("TEL.PHONE", SpecificationVersion.V02R02), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals("HL7 error count", 2, this.xmlResult.getHl7Errors().size());  // invalid scheme; must have a valid scheme
		
		Hl7Error hl7Error = this.xmlResult.getHl7Errors().get(0);
		assertEquals("error message code", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());		
		assertEquals("error message", "Unrecognized URL scheme 'mailfrom' in element /something", hl7Error.getMessage());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"mailto://monkey@monkey\" />");
		TelecommunicationAddress address = (TelecommunicationAddress) new TelElementParser().parse(createContext("TEL.EMAIL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct address returned", "monkey@monkey", address.getAddress());
		assertEquals("correct urlscheme returned", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something>\n" +
				"<monkey/>" +
				"</something>");
		try {
			new TelElementParser().parse(new TrivialContext("TEL.URI"), node, this.xmlResult);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected TEL.URI node to have no children", e.getMessage());
		}
	}
	
	@Test
	public void testParseBlankChildNode() throws Exception {
		Node node = createNode(
				"<something value=\"mailto://monkey\">\n" +
		"</something>");
		new TelElementParser().parse(createContext("TEL.EMAIL", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeAllUrlSchemes() throws Exception {
		assertValidValueAttribute("TEL.PHONE", "fax:1234", "1234", CeRxDomainTestValues.FAX);
		
		assertValidValueAttribute("TEL.URI", "file:c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		assertValidValueAttribute("TEL.URI", "file://c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		
		assertValidValueAttribute("TEL.URI", "ftp:ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		assertValidValueAttribute("TEL.URI", "ftp://ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		
		assertValidValueAttribute("TEL.URI", "http:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		assertValidValueAttribute("TEL.URI", "http://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		
		assertValidValueAttribute("TEL.URI", "https:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		assertValidValueAttribute("TEL.URI", "https://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		
		assertValidValueAttribute("TEL.EMAIL", "mailto://monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		assertValidValueAttribute("TEL.EMAIL", "mailto:monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		
		assertValidValueAttribute("TEL.URI", "nfs://nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);
		assertValidValueAttribute("TEL.URI", "nfs:nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);

		assertValidValueAttribute("TEL.PHONE", "tel:567-1111", "567-1111", CeRxDomainTestValues.TELEPHONE);
	}
	
	private void assertValidValueAttribute(String type, String value, String address, URLScheme urlScheme) throws Exception {
		Node node = createNode("<something value=\"" + value + "\" />");
		TelecommunicationAddress telecommunicationAddress = (TelecommunicationAddress) new TelElementParser().parse(createContext(type, SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct address returned", address, telecommunicationAddress.getAddress());
		assertEquals("correct urlscheme returned", urlScheme.getCodeValue(), telecommunicationAddress.getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseAddressUse() throws Exception {
		AbstractSingleElementParser<TelecommunicationAddress> parser = new TelElementParser();
		
		Node node = createNode("<something use=\"H\" value=\"mailto://monkey@monkey\" />");
		Set<TelecommunicationAddressUse> addressUses = ((TelecommunicationAddress) parser.parse(createContext("TEL.EMAIL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue()).getAddressUses();
		assertTrue(this.xmlResult.isValid());
		assertEquals("address use count", 1, addressUses.size());
		
		assertContains("address use HOME", addressUses, CeRxDomainTestValues.HOME_ADDRESS);

		node = createNode("<something use=\"H WP\" value=\"mailto://monkey@monkey\" />");
		addressUses = ((TelecommunicationAddress) parser.parse(createContext("TEL.EMAIL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue()).getAddressUses();
		assertTrue(this.xmlResult.isValid());
		assertEquals("address use count (2)", 2, addressUses.size());
		assertContains("address use HOME (2)", addressUses, CeRxDomainTestValues.HOME_ADDRESS);
		assertContains("address use WORKPLACE (2)", addressUses, CeRxDomainTestValues.WORK_PLACE);
	}

	private void assertContains(String description,
			Set<TelecommunicationAddressUse> addressUses,
			TelecommunicationAddressUse use) {
		boolean found = false;
		for (TelecommunicationAddressUse telecommunicationAddressUse : addressUses) {
			if (StringUtils.equals(use.getCodeValue(), telecommunicationAddressUse.getCodeValue())) {
				found = true;
				break;
			}
		}
		if (!found) {
			fail(description);
		}
		
	}
}
