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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.TestableAbstractValueNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IntR2PropertyFormatterTest extends FormatterTestCase {
	
	private static class TestableIntR2PropertyFormatter extends IntR2PropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<Integer> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, Integer t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}
	}

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new TestableIntR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", null, null, null, false), null, new INTImpl());

		// a null value for INT elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
		assertTrue("no errors", this.result.isValid());
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerValid() throws Exception {
		String integerValue = "34";
		Map<String, String> result = new TestableIntR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", null, null, null, false), new Integer(integerValue), null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));
		assertTrue("no errors", this.result.isValid());
	}

	@Test
	public void testNullCaseMandatory() throws Exception {
		String result = new TestableIntR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.POPULATED, null, false), new INTImpl());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
		assertTrue("no errors", this.result.isValid());
	}
	
	@Test
	public void testNullCasePopulated() throws Exception {
		String result = new TestableIntR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.POPULATED, null, false), new INTImpl());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
		assertTrue("no errors", this.result.isValid());
	}
	
	@Test
	public void testNullCaseNotMandatory() throws Exception {
		String result = new TestableIntR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.OPTIONAL, null, false), null);
		assertTrue("result", StringUtils.isBlank(result));
		assertTrue("no errors", this.result.isValid());
	}
	
	@Test
	public void testGetAttributeNameValuePairsIntegerZero() throws Exception {
		String integerValue = "0";
		Map<String, String> result = new TestableIntR2PropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(this.result, null, "name", null, null, null, false), new Integer(integerValue), null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));
		assertTrue("no errors", this.result.isValid());
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerNegative() throws Exception {
		String integerValue = "-1";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.REQUIRED, null, false);
		Integer integer = new Integer(integerValue);
		Map<String, String> result = new TestableIntR2PropertyFormatter().getAttributeNameValuePairsForTest(context, integer, new INTImpl(integer));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));

		context.getModelToXmlResult().clearErrors();
		
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				new INTImpl(integer));
		assertEquals("xml output as expected", "<name value=\"-1\"/>", output.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testGetAttributeNameValuePairsIntegerZeroNoWarnings() throws Exception {
		String integerValue = "0";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.REQUIRED, null, false);
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				new INTImpl(new Integer(integerValue)));
		assertEquals("xml output as expected", "<name value=\"0\"/>", output.trim());
		assertTrue("no errors", context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testIntegerOperatorNotAllowed() throws Exception {
		String integerValue = "123";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.REQUIRED, null, false);
		
		INTImpl dataType = new INTImpl(new Integer(integerValue));
		dataType.setOperator(SetOperator.INCLUDE);
		
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				dataType);
		assertEquals("xml output as expected", "<name value=\"123\"/>", output.trim());
		assertFalse(context.getModelToXmlResult().isValid());
		assertEquals(1, context.getModelToXmlResult().getHl7Errors().size());
	}
	
	@Test
	public void testIntegerWithRegionOfInterest() throws Exception {
		String integerValue = "123";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "INT", ConformanceLevel.REQUIRED, null, false);
		
		INTImpl dataType = new INTImpl(new Integer(integerValue));
		dataType.setUnsorted(true);
		
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				dataType);
		assertEquals("xml output as expected", "<name unsorted=\"true\" value=\"123\"/>", output.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testSxcmOperatorAllowed() throws Exception {
		String integerValue = "123";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "SXCM<INT>", ConformanceLevel.REQUIRED, null, false);
		
		INTImpl dataType = new INTImpl(new Integer(integerValue));
		dataType.setOperator(SetOperator.INCLUDE);
		
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				dataType);
		assertEquals("xml output as expected", "<name operator=\"I\" value=\"123\"/>", output.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testSxcmNoOperator() throws Exception {
		String integerValue = "123";
		FormatContextImpl context = new FormatContextImpl(this.result, null, "name", "SXCM<INT>", ConformanceLevel.REQUIRED, null, false);
		
		INTImpl dataType = new INTImpl(new Integer(integerValue));
		
		String output = new TestableIntR2PropertyFormatter().format(
				context,
				dataType);
		assertEquals("xml output as expected", "<name value=\"123\"/>", output.trim());
		assertTrue(context.getModelToXmlResult().isValid());
	}
}
