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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Test;

public class RealConfPropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);

		// a null value for REAL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testFormatCorrectly() throws Exception {
		String realValue = "0.2564";

		Map<String, String> result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new BigDecimal(realValue));
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", realValue, result.get("value"));
	}
	
	@Test
	public void testValueShouldBeGreaterThanZero() throws Exception{
		String realValue = "-0.56";
		assertTrue("BigDecimal value must be greater than: 0", 
						new RealConfPropertyFormatter().isInvalidValue(null, new BigDecimal(realValue)));
	}
	
	@Test
	public void testValueEqualsToZero() throws Exception{
		String realValue = "0.0";
		Map<String, String> result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new BigDecimal(realValue));
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.0000", result.get("value"));		
	}
	
	@Test
	public void testValueShouldBeLessThanOne() throws Exception{
		String realValue = "1.001";
		assertTrue("BigDecimal value must be Less than: 1", 
						new RealConfPropertyFormatter().isInvalidValue(null, new BigDecimal(realValue)));
	}
	
	@Test
	public void testRoundedToFourDecimalPlacesFloor() throws Exception{
		String realValue = "0.256444444";

		Map<String, String> result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new BigDecimal(realValue));
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.2564", result.get("value"));
	}
	
	@Test
	public void testRoundedToFourDecimalPlacesCieling() throws Exception{
		String realValue = "0.256455555";

		Map<String, String> result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new BigDecimal(realValue));
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.2565", result.get("value"));
	}
	
	@Test
	public void testValueEqualsToOne() throws Exception{
		String realValue = "1.0";
		Map<String, String> result = new RealConfPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new BigDecimal(realValue));
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "1.0000", result.get("value"));
	}
}
