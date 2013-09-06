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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class TsFullDatePropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String,String>  result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", null, null, null), null, new TSImpl());

		// a null value for TS elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}

	@Test
	public void testGetAttributeNameValuePairsDate() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS.DATE", null, null, false, SpecificationVersion.R02_04_02, null, null, null), calendar, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "19990423", result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void testGetAttributeNameValuePairsInvalidDatePattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMMdd");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS.DATE", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected (even though invalid)", "1999Apr23", result.get("value"));
		assertEquals(1, xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testGetAttributeNameValuePairsForDateWithPattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithPattern = new DateWithPattern(calendar, "yyyyMM");
		
		// note that a Date and a DateWithPattern only work for equals() because the
		// Java implementation we are using uses "instanceof" instead of "getClass()" for its preliminary comparison 
		assertEquals("same dates should be equal", calendar, dateWithPattern);
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS.DATE", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithPattern, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "199904", result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void testGetValueGeneratesDifferentStringsForDifferentTimeZones() throws Exception  {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("Canada/Ontario"));
		Date date = format.parse("1999-02-01");
		
		String gmtSixValue = new TsFullDatePropertyFormatter().getValue(date, createFormatContextWithTimeZone(TimeZone.getTimeZone("Canada/Saskatchewan")), null);
		String gmtFiveValue = new TsFullDatePropertyFormatter().getValue(date, createFormatContextWithTimeZone(TimeZone.getTimeZone("Canada/Ontario")), null);
		assertFalse(StringUtils.equals(gmtSixValue, gmtFiveValue));
	}

	private FormatContextImpl createFormatContextWithTimeZone(TimeZone timeZone) {
		return new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, null, false, null, timeZone, null, null);
	}
}
