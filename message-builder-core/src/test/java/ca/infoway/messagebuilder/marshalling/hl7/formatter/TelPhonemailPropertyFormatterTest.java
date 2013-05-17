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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertContainsSame;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertInvalidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertValidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.TelValidationUtils;

public class TelPhonemailPropertyFormatterTest {

	private ModelToXmlResult xmlResult = new ModelToXmlResult();

	@After
	public void teardown() {
		this.xmlResult.clearErrors();
	}
	
	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE"), null, new TELImpl());

		assertTrue(this.xmlResult.isValid());
		
		// a null value for TEL.PHONEMAIL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey(AbstractPropertyFormatter.NULL_FLAVOR_ATTRIBUTE_NAME));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	private FormatContextImpl createContext(String type) {
		return createContext(type, SpecificationVersion.R02_04_03);
	}

	private FormatContextImpl createContext(String type, SpecificationVersion version) {
		return new FormatContextImpl(this.xmlResult, null, "name", type, null, null, false, version, null, null, null);
	}

	@Test
	public void testGetAttributeNameValuePairsTelPhonemailValid() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE"), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelPhonemailWithSpecializationType() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		
		TELImpl bareAny = new TELImpl();
		bareAny.setDataType(StandardDataType.TEL_PHONE);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONEMAIL"), address, bareAny);
		
		assertTrue(this.xmlResult.isValid());
		
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelPhonemailMissingSpecializationType() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONEMAIL"), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelAllMissingSpecializationType() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.ALL"), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelPhonemailMissingSpecializationType2() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		TELImpl bareAny = new TELImpl();
		bareAny.setDataType(null);
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONEMAIL"), address, bareAny);
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsPhonemailAllValidSchemes() throws Exception {
		FormatContextImpl context = createContext("TEL.PHONE");
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FAX, context, "fax:");
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.TELEPHONE, context, "tel:");
		
		context = createContext("TEL.EMAIL");
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MAILTO, context, "mailto:");
	}

	@Test
	public void testGetAttributeNameValuePairsAllInvalidSchemes() throws Exception {
		FormatContextImpl context = createContext("TEL.PHONE");
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FILE, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FTP, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.HTTP, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.HTTPS, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MLLP, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MODEM, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.TELNET, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.NFS, context);
	}
	
	@Test
	public void testGetAttributeNameValuePairsIncludeUses() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		address.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE"), address, new TELImpl());
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
		
		assertTrue("use key as expected", result.containsKey("use"));
		assertEquals("use as expected", "H", result.get("use"));

		address.addAddressUse(CeRxDomainTestValues.MOBILE_CONTACT);
		result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE"), address, new TELImpl());
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 2, result.size());
		
		assertTrue("use key as expected", result.containsKey("use"));
		
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("H MC"), uses);
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidAddressUses() throws Exception {
		assertInvalidAddressUse(CeRxDomainTestValues.ANSWERING_SERVICE);
		assertInvalidAddressUse(CeRxDomainTestValues.BAD_ADDRESS);
		assertInvalidAddressUse(CeRxDomainTestValues.PRIMARY_HOME);
		assertInvalidAddressUse(CeRxDomainTestValues.PUBLIC);
		assertInvalidAddressUse(CeRxDomainTestValues.VACATION_HOME);
	}
	
	private void assertInvalidAddressUse(TelecommunicationAddressUse addressUse) {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.setAddress("4167620032");
		address.addAddressUse(addressUse);

		this.xmlResult.clearErrors();
		new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE"), address, new TELImpl());
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("expected message", "TelecomAddressUse is not valid: " + addressUse.getCodeValue(), this.xmlResult.getHl7Errors().get(0).getMessage());
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllValidAddressUses() throws Exception {
		assertValidAddressUse(CeRxDomainTestValues.EMERGENCY_CONTACT);
		assertValidAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		assertValidAddressUse(CeRxDomainTestValues.MOBILE_CONTACT);
		assertValidAddressUse(CeRxDomainTestValues.PAGER);
		assertValidAddressUse(CeRxDomainTestValues.TEMPORARY_ADDRESS);
		assertValidAddressUse(CeRxDomainTestValues.WORK_PLACE);
	}
	
	private void assertValidAddressUse(TelecommunicationAddressUse addressUse) throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.addAddressUse(addressUse);
		address.setAddress("someAddress");
		
		this.xmlResult.clearErrors();
		FormatContextImpl context = createContext("TEL.PHONE");
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(context, address, new TELImpl());
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("use"));
		assertEquals("value as expected", addressUse.getCodeValue(), result.get("use"));
	}
	
	@Test
	public void testTelEmailWithValidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.MAILTO);
		// mailto: + 43 = 50 (max)
		address.setAddress("1234567890123456789012345678901234567890123");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.EMAIL"), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "mailto:" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelEmailWithInvalidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.MAILTO);
		// mailto: + 44 = 51 (max+1)
		address.setAddress("12345678901234567890123456789012345678901234");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.EMAIL"), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "mailto:" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelPhoneForMr2009WithValidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		// tel: + 36 = 40 (max)
		address.setAddress("123456789012345678901234567890123456");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.R02_04_02), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelPhoneForMr2009WithInvalidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		// tel: + 37 = 41 (max + 1)
		address.setAddress("1234567890123456789012345678901234567");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.R02_04_02), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelPhoneForMr2007WithValidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		// tel: + 21 = 25 (max)
		address.setAddress("123456789012345678901");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.V02R02), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelPhoneForMr2007WithInvalidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		// tel: + 22 = 26 (max + 1)
		address.setAddress("1234567890123456789012");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.V02R02), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:" + address.getAddress(), result.get("value"));
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidUsesForEmail() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.MAILTO);
		address.setAddress("value");
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.ANSWERING_MACHINE); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.BAD); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL); // invalid 
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.DIRECT); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.EMERGENCY_CONTACT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.HOME);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.MOBILE);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PAGER); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PRIMARY_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PUBLISHED); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.TEMPORARY);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.VACATION_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.WORKPLACE);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.EMAIL"), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(9, this.xmlResult.getHl7Errors().size()); // 8 bad uses + 1 for too many
		
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "mailto:value", result.get("value"));
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("EC H MC TMP WP"), uses);
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidUsesForMr2009Phone() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.setAddress("value");
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.ANSWERING_MACHINE); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.BAD); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL); 
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.DIRECT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.EMERGENCY_CONTACT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.HOME);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.MOBILE);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PAGER);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PRIMARY_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PUBLISHED); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.TEMPORARY);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.VACATION_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.WORKPLACE);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.R02_04_02), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(6, this.xmlResult.getHl7Errors().size()); // 5 bad uses + 1 for too many
		
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "fax:value", result.get("value"));
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("CONF DIR EC H MC PG TMP WP"), uses);
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidUsesForMr2007Phone() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.setAddress("value");
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.ANSWERING_MACHINE); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.BAD); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL); // invalid 
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.DIRECT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.EMERGENCY_CONTACT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.HOME);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.MOBILE);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PAGER);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PRIMARY_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PUBLISHED); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.TEMPORARY);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.VACATION_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.WORKPLACE);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.V02R02), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(7, this.xmlResult.getHl7Errors().size()); // 6 bad uses + 1 for too many
		
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "fax:value", result.get("value"));
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("DIR EC H MC PG TMP WP"), uses);
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidUsesForCerxPhone() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.setAddress("value");
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.ANSWERING_MACHINE); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.BAD); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL); // invalid 
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.DIRECT); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.EMERGENCY_CONTACT);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.HOME);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.MOBILE);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PAGER);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PRIMARY_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PUBLISHED); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.TEMPORARY);
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.VACATION_HOME); // invalid
		address.addAddressUse(ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.WORKPLACE);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(createContext("TEL.PHONE", SpecificationVersion.V01R04_3), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(8, this.xmlResult.getHl7Errors().size()); // 7 bad uses + 1 for too many
		
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "fax:value", result.get("value"));
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("EC H MC PG TMP WP"), uses);
	}

	@Test
	public void testCeRxDatatypeDetermination() {
		TelecommunicationAddress telecomAddress = new TelecommunicationAddress();
		String type = "TEL.PHONEMAIL";
		VersionNumber version = SpecificationVersion.V01R04_3;
		Hl7Errors errors = this.xmlResult;
		
		telecomAddress.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		assertEquals("TEL.PHONE", new TelValidationUtils().determineActualType(telecomAddress, type, null, version, null, null, errors, true));
		assertTrue(this.xmlResult.isValid());
		
		telecomAddress.setUrlScheme(CeRxDomainTestValues.FAX);
		assertEquals("TEL.PHONE", new TelValidationUtils().determineActualType(telecomAddress, type, null, version, null, null, errors, true));
		assertTrue(this.xmlResult.isValid());
		
		telecomAddress.setUrlScheme(CeRxDomainTestValues.MAILTO);
		assertEquals("TEL.EMAIL", new TelValidationUtils().determineActualType(telecomAddress, type, null, version, null, null, errors, true));
		assertTrue(this.xmlResult.isValid());
		
		telecomAddress.setUrlScheme(CeRxDomainTestValues.FTP); // this error will be caught elsewhere
		assertEquals("TEL.PHONE", new TelValidationUtils().determineActualType(telecomAddress, type, null, version, null, null, errors, true));
		assertTrue(this.xmlResult.isValid());
		
	}
}
