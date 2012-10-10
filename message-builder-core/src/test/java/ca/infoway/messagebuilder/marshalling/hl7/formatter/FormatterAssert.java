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

import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.URLScheme;

public class FormatterAssert extends Assert {

	static void assertInvalidUrlScheme(AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> formatter, URLScheme urlScheme, FormatContext context) {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(urlScheme);
		address.setAddress("sometext");
		
		formatter.getAttributeNameValuePairs(context, address, new TELImpl());

		assertFalse(context.getModelToXmlResult().isValid());
		assertEquals(1, context.getModelToXmlResult().getHl7Errors().size());
		assertTrue("expected message", context.getModelToXmlResult().getHl7Errors().get(0).getMessage().contains("Scheme " + urlScheme.getCodeValue() + " is not valid"));
	}

	static void assertValidUrlScheme(AbstractValueNullFlavorPropertyFormatter<TelecommunicationAddress> formatter, URLScheme urlScheme, FormatContext context, String expected) throws Exception {
		TelecommunicationAddress address = new TelecommunicationAddress();
		address.setUrlScheme(urlScheme);
		
		Map<String, String> result = formatter.getAttributeNameValuePairs(context, address, new TELImpl());
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
