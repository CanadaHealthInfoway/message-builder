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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

public class IntPosPropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new IntPosPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);

		// a null value for INT elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerValid() throws Exception {
		String integerValue = "34";
		Map<String, String> result = new IntPosPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new Integer(integerValue));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerZero() throws Exception {
		String integerValue = "0";
		try {
			new IntPosPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new Integer(integerValue));
			fail("expected exception");

		} catch (ModelToXmlTransformationException e) {
			assertEquals("exception as expected", "Integer value must be positive: 0", e.getMessage());
		}
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerNegative() throws Exception {
		String integerValue = "-1";
		try {
			new IntPosPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new Integer(integerValue));
			fail("expected exception");

		} catch (ModelToXmlTransformationException e) {
			assertEquals("exception as expected", "Integer value must be positive: -1", e.getMessage());
		}
	}
}
