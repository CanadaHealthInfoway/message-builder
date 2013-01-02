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

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertInvalidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertValidUrlScheme;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class TelUriPropertyFormatterTest {
	
	private ModelToXmlResult xmlResult = new ModelToXmlResult();

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext(), null, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());

		// a null value for TEL.URI elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey(AbstractPropertyFormatter.NULL_FLAVOR_ATTRIBUTE_NAME));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	private FormatContextImpl createContext() {
		return new FormatContextImpl(this.xmlResult, null, "name", "TEL.URI", null, false, SpecificationVersion.R02_04_03, null, null, null);
	}

	@Test
	public void testGetAttributeNameValuePairsTelUriValid() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FILE);
		address.setAddress("value");
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext(), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "file://value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelUriInvalidUse() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FILE);
		address.setAddress("value");
		address.getAddressUses().add(TelecommunicationAddressUse.HOME);
		
		new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext(), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
	}

	@Test
	public void testGetAttributeNameValuePairsTelAllValidUris() throws Exception {
		FormatContextImpl context = createContext();
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FILE, context, "file://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FTP, context, "ftp://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.HTTP, context, "http://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.HTTPS, context, "https://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MAILTO, context, "mailto:");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.NFS, context, "nfs://");
	}

	@Test
	public void testGetAttributeNameValuePairsAllInvalidUris() throws Exception {
		FormatContextImpl context = createContext();
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FAX, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MLLP, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MODEM, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.TELEPHONE, context);
		this.xmlResult.clearErrors();
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.TELNET, context);
	}
	
	@Test
	public void testTelUriWithValidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FILE);
		// file:// + 248 = 255 (max)
		address.setAddress("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext(), address, new TELImpl());
		
		assertTrue(this.xmlResult.isValid());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "file://" + address.getAddress(), result.get("value"));
	}

	@Test
	public void testTelUriWithInvalidMaxLength() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FILE);
		// file:// + 249 = 256 (1 over max)
		address.setAddress("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(createContext(), address, new TELImpl());
		
		assertFalse(this.xmlResult.isValid());
		assertEquals(1, this.xmlResult.getHl7Errors().size());
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "file://" + address.getAddress(), result.get("value"));
	}

}
