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
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.parser.TrivialContext;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class TelR2ElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParseNullNode() throws Exception {
		Node node = createNode("<something nullFlavor=\"NI\" />");
		TEL tel = (TEL) new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
		assertNull("null returned", tel.getValue());
		assertEquals("null flavor", NullFlavor.NO_INFORMATION, tel.getNullFlavor());
	}
	
	private ParseContext createContext(String type, VersionNumber version) {
		return ParserContextImpl.create(type, TelecommunicationAddress.class, version, null, null, ConformanceLevel.POPULATED, null);
	}

	@Test
	public void testParseEmptyNode() throws Exception {
		Node node = createNode("<something/>");
		new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());  // missing scheme; missing address
	}

	@Test
	public void testParseNoValueAttributeNode() throws Exception {
		Node node = createNode("<something notvalue=\"\" />");
		new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(2, this.xmlResult.getHl7Errors().size());  // missing scheme; missing address
	}
	
	@Test
	public void testParseInvalidValueAttributeNode() throws Exception {
		Node node = createNode("<something value=\"1234\" />");
		new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals("HL7 error count", 1, this.xmlResult.getHl7Errors().size());
		
		Hl7Error hl7Error = this.xmlResult.getHl7Errors().get(0);
		assertEquals("error message", "TEL values must provide a URL scheme (i.e. mailto:)", hl7Error.getMessage());
	}
	
	@Test
	public void testParseInvalidValueUrlScheme() throws Exception {
		Node node = createNode("<something value=\"mailfrom://monkey\" />");
		
		new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals("HL7 error count", 1, this.xmlResult.getHl7Errors().size());  // invalid scheme
		
		Hl7Error hl7Error = this.xmlResult.getHl7Errors().get(0);
		assertEquals("error message", "Unrecognized URL scheme 'mailfrom' in element /something", hl7Error.getMessage());
	}
	
	@Test
	public void testParseValueAttributeValidPlusExtraAttribute() throws Exception {
		Node node = createNode("<something extra=\"extra\" value=\"mailto://monkey@monkey\" />");
		TelecommunicationAddress address = (TelecommunicationAddress) new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct address returned", "monkey@monkey", address.getAddress());
		assertEquals("correct urlscheme returned", CeRxDomainTestValues.MAILTO.getCodeValue(), address.getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseAll() throws Exception {
		Node node = createNode(
				"<something value=\"http://www.fred.ca\" use=\"HP CONF TMP\">\n" +
					"<useablePeriod value=\"19990303101112\"/>" +
					"<useablePeriod operator=\"E\" value=\"20050303101112\"/>" +
				"</something>");
		
		TelecommunicationAddress address = (TelecommunicationAddress) new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.R02_04_03), node, this.xmlResult).getBareValue();
		
		assertTrue(this.xmlResult.isValid());
		
		assertEquals("correct address returned", "www.fred.ca", address.getAddress());
		assertEquals("correct urlscheme returned", CeRxDomainTestValues.HTTP.getCodeValue(), address.getUrlScheme().getCodeValue());
		assertEquals("correct address uses", 3, address.getAddressUses().size());
		assertTrue(address.getAddressUses().contains(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PRIMARY_HOME));
		assertTrue(address.getAddressUses().contains(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL));
		assertTrue(address.getAddressUses().contains(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.TEMPORARY));
		assertEquals("correct number of useable periods", 2, address.getUseablePeriods().size());
		
		Iterator<Entry<Date, SetOperator>> iterator = address.getUseablePeriods().entrySet().iterator();
		Entry<Date, SetOperator> firstPeriod = iterator.next();
		Entry<Date, SetOperator> secondPeriod = iterator.next();
		
		assertEquals("first period", DateUtil.getDate(1999, 2, 3, 10, 11, 12, 0), firstPeriod.getKey());
		assertEquals("first operator", SetOperator.INCLUDE, firstPeriod.getValue());
		assertEquals("second period", DateUtil.getDate(2005, 2, 3, 10, 11, 12, 0), secondPeriod.getKey());
		assertEquals("second operator", SetOperator.EXCLUDE, secondPeriod.getValue());
	}
	
	@Test
	public void testParseTooManyChildNodes() throws Exception {
		Node node = createNode(
				"<something value=\"mailto:me@you.ca\">\n" +
				"<monkey/>" +
				"</something>");
		new TelR2ElementParser().parse(new TrivialContext("TEL"), node, this.xmlResult);
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("Unexpected TEL child element: \"monkey\"", this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testParseBlankChildNode() throws Exception {
		Node node = createNode(
				"<something value=\"mailto://monkey\">\n" +
		"</something>");
		new TelR2ElementParser().parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult);
		assertTrue(this.xmlResult.isValid());
	}
	
	@Test
	public void testParseValueAttributeAllUrlSchemes() throws Exception {
		assertValidValueAttribute("TEL", "fax:1234", "1234", CeRxDomainTestValues.FAX);
		
		assertValidValueAttribute("TEL", "file:c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		assertValidValueAttribute("TEL", "file://c:/temp", "c:/temp", CeRxDomainTestValues.FILE);
		
		assertValidValueAttribute("TEL", "ftp:ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		assertValidValueAttribute("TEL", "ftp://ftp.monkey.com", "ftp.monkey.com", CeRxDomainTestValues.FTP);
		
		assertValidValueAttribute("TEL", "http:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		assertValidValueAttribute("TEL", "http://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTP);
		
		assertValidValueAttribute("TEL", "https:www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		assertValidValueAttribute("TEL", "https://www.monkey.com", "www.monkey.com", CeRxDomainTestValues.HTTPS);
		
		assertValidValueAttribute("TEL", "mailto://monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		assertValidValueAttribute("TEL", "mailto:monkey@monkey", "monkey@monkey", CeRxDomainTestValues.MAILTO);
		
		assertValidValueAttribute("TEL", "nfs://nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);
		assertValidValueAttribute("TEL", "nfs:nfs.ca", "nfs.ca", CeRxDomainTestValues.NFS);

		assertValidValueAttribute("TEL", "tel:567-1111", "567-1111", CeRxDomainTestValues.TELEPHONE);
	}
	
	private void assertValidValueAttribute(String type, String value, String address, URLScheme urlScheme) throws Exception {
		Node node = createNode("<something value=\"" + value + "\" />");
		TelecommunicationAddress telecommunicationAddress = (TelecommunicationAddress) new TelR2ElementParser().parse(createContext(type, SpecificationVersion.V02R02), node, this.xmlResult).getBareValue();
		assertTrue(this.xmlResult.isValid());
		assertEquals("correct address returned", address, telecommunicationAddress.getAddress());
		assertEquals("correct urlscheme returned", urlScheme.getCodeValue(), telecommunicationAddress.getUrlScheme().getCodeValue());
	}
	
	@Test
	public void testParseAddressUse() throws Exception {
		AbstractSingleElementParser<TelecommunicationAddress> parser = new TelR2ElementParser();
		
		Node node = createNode("<something use=\"H\" value=\"mailto://monkey@monkey\" />");
		Set<TelecommunicationAddressUse> addressUses = ((TelecommunicationAddress) parser.parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue()).getAddressUses();
		assertTrue(this.xmlResult.isValid());
		assertEquals("address use count", 1, addressUses.size());
		
		assertContains("address use HOME", addressUses, CeRxDomainTestValues.HOME_ADDRESS);

		node = createNode("<something use=\"H WP\" value=\"mailto://monkey@monkey\" />");
		addressUses = ((TelecommunicationAddress) parser.parse(createContext("TEL", SpecificationVersion.V02R02), node, this.xmlResult).getBareValue()).getAddressUses();
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
