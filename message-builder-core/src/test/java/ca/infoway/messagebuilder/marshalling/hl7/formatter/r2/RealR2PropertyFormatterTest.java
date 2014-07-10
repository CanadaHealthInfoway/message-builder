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
 * Last modified: $LastChangedDate: 2013-05-16 20:18:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6877 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

public class RealR2PropertyFormatterTest {

	private ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
	
	@After
	public void teardown() {
		this.modelToXmlResult.clearErrors();
	}
	
	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new RealR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), null, new REALImpl());

		// a null value for REAL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}

	@Test
	public void testFormatCorrectly() throws Exception {
		String realValue = "0.2564";

		Map<String, String> result = new RealR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", realValue, result.get("value"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testValueNegative() throws Exception{
		String realValue = "-0.56";
		BigDecimal bigDecimal = new BigDecimal(realValue);
		String result = new RealR2PropertyFormatter().format(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), new REALImpl(bigDecimal));
		assertEquals("xml output", "<name value=\"-0.56\"/>", result.trim());
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testValueEqualsToZero() throws Exception{
		String realValue = "0.0";
		Map<String, String> result = new RealR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.0", result.get("value"));		
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testManyDecimalPlaces() throws Exception{
		String realValue = "0.256444444";

		Map<String, String> result = new RealR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.256444444", result.get("value"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testValueEqualsToOne() throws Exception{
		String realValue = "1.0";
		Map<String, String> result = new RealR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.modelToXmlResult, null, "name", "REAL", null, null), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "1.0", result.get("value"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
}
