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

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertInvalidUrlScheme;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterAssert.assertValidUrlScheme;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class TelUriPropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), null, null);

		// a null value for TEL.URI elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey(AbstractPropertyFormatter.NULL_FLAVOR_ATTRIBUTE_NAME));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelUriValid() throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(CeRxDomainTestValues.FILE);
		address.setAddress("value");
		Map<String, String> result = new TelUriPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null), address, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "file://value", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsTelAllValidUris() throws Exception {
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FILE, "file://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FTP, "ftp://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.HTTP, "http://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.HTTPS, "https://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MAILTO, "mailto://");
		assertValidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.NFS, "nfs://");
	}

	@Test
	public void testGetAttributeNameValuePairsAllInvalidUris() throws Exception {
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.FAX);
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MLLP);
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.MODEM);
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.TELEPHONE);
		assertInvalidUrlScheme(new TelUriPropertyFormatter(), CeRxDomainTestValues.TELNET);
	}
}
