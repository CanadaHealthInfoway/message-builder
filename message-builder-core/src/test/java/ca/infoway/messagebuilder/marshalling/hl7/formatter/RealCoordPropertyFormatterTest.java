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
 * Last modified: $LastChangedDate: 2012-08-02 19:48:16 -0400 (Thu, 02 Aug 2012) $
 * Revision:      $LastChangedRevision: 6014 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.After;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class RealCoordPropertyFormatterTest {
	
	private static class TestableRealCoordPropertyFormatter extends RealCoordPropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<BigDecimal> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, BigDecimal t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}	
	}

	private ModelToXmlResult modelToXmlResult = new ModelToXmlResult();
	
	@After
	public void teardown() {
		this.modelToXmlResult.clearErrors();
	}

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), null, new REALImpl());

		// a null value for REAL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}

	@Test
	public void testFormatCorrectly() throws Exception {
		String realValue = "0.2564";

		Map<String, String> result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", realValue, result.get("value"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testValueHasTooManyDigitsToRightOfDecimal() throws Exception{
		String realValue = "-0.56899";
		BigDecimal bigDecimal = new BigDecimal(realValue);
		String result = new TestableRealCoordPropertyFormatter().format(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new REALImpl(bigDecimal));
		assertEquals("xml output", "<name value=\"-0.5690\"/>", result.trim());
		assertEquals("1 error", 1, this.modelToXmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testValueEqualsToZero() throws Exception{
		String realValue = "0.0";
		Map<String, String> result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.0", result.get("value"));		
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
	
	@Test
	public void testValueHasTooManyDigitsToLeftOfDecimal() throws Exception{
		String realValue = "12345.0001";
		BigDecimal bigDecimal = new BigDecimal(realValue);
		String result = new TestableRealCoordPropertyFormatter().format(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new REALImpl(bigDecimal));
		assertEquals("xml output", "<name value=\"2345.0001\"/>", result.trim());
		assertEquals("1 error", 1, this.modelToXmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testValueHasTooManyDigitsOnBothSidesOfDecimal() throws Exception{
		String realValue = "123456.123456";
		BigDecimal bigDecimal = new BigDecimal(realValue);
		String result = new TestableRealCoordPropertyFormatter().format(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new REALImpl(bigDecimal));
		assertEquals("xml output", "<name value=\"3456.1235\"/>", result.trim());
		assertEquals("2 errors", 2, this.modelToXmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testRoundedToFourDecimalPlacesFloor() throws Exception{
		String realValue = "0.256444444";

		Map<String, String> result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.2564", result.get("value"));
		assertEquals("1 error", 1, this.modelToXmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testRoundedToFourDecimalPlacesCeiling() throws Exception{
		String realValue = "0.256455555";

		Map<String, String> result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "0.2565", result.get("value"));
		assertEquals("1 error", 1, this.modelToXmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testValueEqualsToOne() throws Exception{
		String realValue = "1.0";
		Map<String, String> result = new TestableRealCoordPropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.modelToXmlResult, null, "name", null, null, null, false), new BigDecimal(realValue), null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "1.0", result.get("value"));
		assertTrue("no errors", this.modelToXmlResult.isValid());
	}
}
