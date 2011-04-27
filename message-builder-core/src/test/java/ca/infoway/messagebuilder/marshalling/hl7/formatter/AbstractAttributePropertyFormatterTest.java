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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.STImpl;

public class AbstractAttributePropertyFormatterTest extends FormatterTestCase {

	private class TestableAttributePropertyFormatter extends AbstractAttributePropertyFormatter<String> {
		private final Map<String, String> nameValuePairs = new HashMap<String, String>();
		
		@Override
		Map<String, String> getAttributeNameValuePairs(FormatContext context, String string) {
			return this.nameValuePairs;
		}
		
		public void addNameValuePair(String name, String value) {
			this.nameValuePairs.put(name, value);
		}
	}

	@Test
	public void testFormatValueNonNull() throws Exception {
		// no name-value pairs
		TestableAttributePropertyFormatter formatter = new TestableAttributePropertyFormatter();
		
		String result = formatter.format(getContext("name"), new STImpl("something"));
		assertEquals("named null format", addLineSeparator("<name/>"), result);

		// one name-value pair
		formatter.addNameValuePair("name1", "value1");
		
		result = formatter.format(getContext("name"), new STImpl("something"));
		assertEquals("named null format", addLineSeparator("<name name1=\"value1\"/>"), result);

		// two name-value pairs
		formatter.addNameValuePair("name2", "value2");
		
		result = formatter.format(getContext("name"), new STImpl("something"));
		assertEquals("named null format", addLineSeparator("<name name1=\"value1\" name2=\"value2\"/>"), result);
	}
	
	@Test
	public void testFormatValueIndent() throws Exception {
		TestableAttributePropertyFormatter formatter = new TestableAttributePropertyFormatter();
		
		String result = formatter.format(getContext("name"), new STImpl(), 0);
		assertEquals("named null format", addLineSeparator("<name nullFlavor=\"NI\"/>"), result);
		
		result = formatter.format(getContext("name"), new STImpl(), 1);
		assertEquals("named null format", addLineSeparator("  <name nullFlavor=\"NI\"/>"), result);
		
		result = formatter.format(getContext("name"), new STImpl(), 2);
		assertEquals("named null format", addLineSeparator("    <name nullFlavor=\"NI\"/>"), result);
	}
	
	private String addLineSeparator(String value) {
		return value + LINE_SEPARATOR;
	}
}
