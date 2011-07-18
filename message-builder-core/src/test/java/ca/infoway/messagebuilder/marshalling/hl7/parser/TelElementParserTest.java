/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TelElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		TEL tel = (TEL) new TelElementParser().parse(createContext(), node, null);
		assertNull("null returned", tel.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, tel.getNullFlavor());
	}
	
	private ParseContext createContext() {
		return ParserContextImpl.create("TEL", TelecommunicationAddress.class, SpecificationVersion.NEWFOUNDLAND, ConformanceLevel.POPULATED);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		try {
			new TelElementParser().parse(null, node, null);
			fail("Expected exception");
			
		} catch (NullPointerException e) {
			// expected
		}
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		try {
			new TelElementParser().parse(null, node, null);
			fail("Expected exception");
			
		} catch (NullPointerException e) {
			// expected
		}
	}
	
	@Test
	public void testParseInvalidValueAttributeNode() throws Exception {
		Node node = createNode("<something value=\"1234\" />");
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		new TelElementParser().parse(null, node, xmlToJavaResult);
		
		assertEquals("HL7 error count", 1, xmlToJavaResult.getHl7Errors().size());
		
		Hl7Error hl7Error = xmlToJavaResult.getHl7Errors().get(0);
		assertEquals("error message", "Expected TEL.URI node to have a URL scheme (e.g. 'http://')", hl7Error.getMessage());
		assertEquals("error message code", Hl7ErrorCode.SYNTAX_ERROR, hl7Error.getHl7ErrorCode());
	}
	
	@Test
	public void testParseInvalidValueUrlScheme() throws Exception {
		resolver.addDomainValue(null, URLScheme.class);
		Node node = createNode("<something value=\"mailfrom://monkey\" />");
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		new TelElementParser().parse(null, node, xmlToJavaResult);
		assertEquals("HL7 error count", 1, xmlToJavaResult.getHl7Errors().size());
		
		Hl7Error hl7Error = xmlToJavaResult.getHl7Errors().get(0);
		assertEquals("error message code", Hl7ErrorCode.DATA_TYPE_ERROR, hl7Error.getHl7ErrorCode());		
		assertEquals("error message", "Unrecognized URL scheme 'mailfrom' in element /something", hl7Error.getMessage());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"mailto://monkey@monkey\" />");
		TelecommunicationAddress address = (TelecommunicationAddress) new TelElementParser().parse(null, node, null).getBareValue();
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
			new TelElementParser().parse(new TrivialContext("TEL.URI"), node, null);
			fail("expected exception");
			
		} catch (XmlToModelTransformationException e) {
			// expected
			assertEquals("proper exception returned", "Expected TEL.URI node to have no children", e.getMessage());
		}
	}
	
	@Test
	public void testParseBlankChildNode() throws Exception {
		Node node = createNode(
				"<something value=\"mailfrom://monkey\">\n" +
		"</something>");
		new TelElementParser().parse(null, node, null);
	}
	
	@Test
	public void testParseValueAttributeAllUrlSchemes() throws Exception {
		assertValidValueAttribute("fax:1234", "1234", CeRxDomainTestValues.FAX);
		assertValidValueAttribute("fax:", "", CeRxDomainTestValues.FAX);
		
		assertValidValueAttribute("file:c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		assertValidValueAttribute("file://c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		assertValidValueAttribute("file:", "", CeRxDomainTestValues.FILE);
		
		assertValidValueAttribute("ftp:ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		assertValidValueAttribute("ftp://ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		assertValidValueAttribute("ftp:", "", CeRxDomainTestValues.FTP);
		
		assertValidValueAttribute("http:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		assertValidValueAttribute("http://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		assertValidValueAttribute("http:", "", CeRxDomainTestValues.HTTP);
		
		assertValidValueAttribute("https:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		assertValidValueAttribute("https://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		assertValidValueAttribute("https:", "", CeRxDomainTestValues.HTTPS);
		
		assertValidValueAttribute("mailto://monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		assertValidValueAttribute("mailto:monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		assertValidValueAttribute("mailto:", "", CeRxDomainTestValues.MAILTO);
		
		assertValidValueAttribute("nfs://nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);
		assertValidValueAttribute("nfs:nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);
		assertValidValueAttribute("nfs:", "", CeRxDomainTestValues.NFS);

		assertValidValueAttribute("tel:567-1111", "567-1111", CeRxDomainTestValues.TELEPHONE);
		assertValidValueAttribute("tel:", "", CeRxDomainTestValues.TELEPHONE);
	}
	
	private void assertValidValueAttribute(String value, String address, URLScheme urlScheme) throws Exception {
		Node node = createNode("<something value=\"" + value + "\" />");
		TelecommunicationAddress telecommunicationAddress = (TelecommunicationAddress) new TelElementParser().parse(null, node, null).getBareValue();
		assertEquals("correct address returned", address, telecommunicationAddress.getAddress());
		assertEquals("correct urlscheme returned", urlScheme.getCodeValue(), telecommunicationAddress.getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseAddressUse() throws Exception {
		AbstractSingleElementParser<TelecommunicationAddress> parser = new TelElementParser();
		
		Node node = createNode("<something use=\"H\" value=\"mailto://monkey@monkey\" />");
		Set<TelecommunicationAddressUse> addressUses = ((TelecommunicationAddress) parser.parse(null, node, null).getBareValue()).getAddressUses();
		assertEquals("address use count", 1, addressUses.size());
		
		assertContains("address use HOME", addressUses, CeRxDomainTestValues.HOME_ADDRESS);

		node = createNode("<something use=\"H WP\" value=\"mailto://monkey@monkey\" />");
		addressUses = ((TelecommunicationAddress) parser.parse(null, node, null).getBareValue()).getAddressUses();
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
