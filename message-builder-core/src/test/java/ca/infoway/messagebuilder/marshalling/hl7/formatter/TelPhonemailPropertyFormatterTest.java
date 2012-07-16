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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertContainsSame;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertInvalidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertValidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class TelPhonemailPropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), null);

		// a null value for TEL.PHONEMAIL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey(AbstractPropertyFormatter.NULL_FLAVOR_ATTRIBUTE_NAME));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelPhonemailValid() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsPhonemailAllValidSchemes() throws Exception {
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FAX, "fax:");
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MAILTO, "mailto://");
		assertValidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.TELEPHONE, "tel:");
	}

	@Test
	public void testGetAttributeNameValuePairsAllInvalidSchemes() throws Exception {
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FILE);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.FTP);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.HTTP);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.HTTPS);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MLLP);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.MODEM);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.TELNET);
		assertInvalidUrlScheme(new TelPhonemailPropertyFormatter(), CeRxDomainTestValues.NFS);
	}
	
	@Test
	public void testGetAttributeNameValuePairsIncludeUses() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.TELEPHONE);
		address.setAddress("value");
		address.addAddressUse(CeRxDomainTestValues.HOME_ADDRESS);
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address);
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "tel:value", result.get("value"));
		
		assertTrue("use key as expected", result.containsKey("use"));
		assertEquals("use as expected", "H", result.get("use"));

		address.addAddressUse(CeRxDomainTestValues.MOBILE_CONTACT);
		result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address);
		assertEquals("map size", 2, result.size());
		
		assertTrue("use key as expected", result.containsKey("use"));
		
		
		Set<String> uses = toSet(result.get("use"));
		assertContainsSame("uses", toSet("H MC"), uses);
	}
	
	@Test
	public void testGetAttributeNameValuePairsAllInvalidAddressUses() throws Exception {
		assertInvalidAddressUse(CeRxDomainTestValues.ANSWERING_SERVICE);
		assertInvalidAddressUse(CeRxDomainTestValues.BAD_ADDRESS);
		assertInvalidAddressUse(CeRxDomainTestValues.DIRECT);
		assertInvalidAddressUse(CeRxDomainTestValues.PRIMARY_HOME);
		assertInvalidAddressUse(CeRxDomainTestValues.PUBLIC);
		assertInvalidAddressUse(CeRxDomainTestValues.VACATION_HOME);
	}
	
	private void assertInvalidAddressUse(TelecommunicationAddressUse addressUse) {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FAX);
		address.addAddressUse(addressUse);
		
		try {
			new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address);
			fail("expected exception");
			
		} catch (ModelToXmlTransformationException e) {
			assertEquals("expected message", "Telecommunication address use " + addressUse.getCodeValue() + " is not supported for TEL.PHONEMAIL data", e.getMessage());
		}
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
		
		Map<String, String> result = new TelPhonemailPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address);
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("use"));
		assertEquals("value as expected", addressUse.getCodeValue(), result.get("use"));
	}
}
