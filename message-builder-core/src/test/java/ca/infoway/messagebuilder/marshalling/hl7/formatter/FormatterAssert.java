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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.URLScheme;

public class FormatterAssert extends Assert {

	static void assertInvalidUrlScheme(AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> formatter, URLScheme urlScheme) {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(urlScheme);
		
		try {
			formatter.getAttributeNameValuePairs(new FormatContextImpl("name", null, null), address);
			fail("expected exception");
			
		} catch (ModelToXmlTransformationException e) {
			assertTrue("expected message", e.getMessage().contains("URLScheme " + urlScheme.getCodeValue() + " is not supported"));
		}
	}

	static void assertValidUrlScheme(AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> formatter, URLScheme urlScheme, String expected) throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(urlScheme);
		
		Map<String, String> result = formatter.getAttributeNameValuePairs(new FormatContextImpl("name", null, null), address);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", expected, result.get("value"));
	}

	public static void assertContainsSame(String description, Set<String> expected, Set<String> actual) {
		assertEquals(description + " size", expected.size(), actual.size());
		for (String s : expected) {
			actual.remove(s);
		}
		assertEquals(description + " contains " + expected, 0, actual.size());
	}

	public static Set<String> toSet(String attribute) {
		return new HashSet<String>(Arrays.asList(StringUtils.split(attribute)));
	}
}
