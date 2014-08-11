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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.r2.TsR2PropertyFormatter.DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.r2.TsR2PropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ;
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
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

/**
 * @author administrator
 * @sharpen.ignore Timezone handling
 */
public class TsR2PropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception  {
		Map<String,String>  result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null), null, new TSImpl());
		
		// a null value for TS elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsDate() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null), calendar1, null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "19990423101112.0000" + getCurrentTimeZone(calendar1);
		assertEquals("value as expected", expectedValue, result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsDateWithOperatorNotAllowed() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		TS ts = new TSImpl(calendar1);
		ts.setOperator(SetOperator.PERIODIC_HULL);
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), calendar1, ts);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "19990423101112.0000" + getCurrentTimeZone(calendar1);
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertFalse(xmlResult.isValid());
		assertEquals(1, xmlResult.getHl7Errors().size());
	}

	@Test
	public void testSxcmGetAttributeNameValuePairsDateWithOperatorAllowed() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		TS ts = new TSImpl(calendar1);
		ts.setOperator(SetOperator.PERIODIC_HULL);
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "SXCM<TS>", null, null, false, SpecificationVersion.R02_04_02, null, null, null), calendar1, ts);
		assertEquals("map size", 2, result.size());
		assertTrue(xmlResult.isValid());
		
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "19990423101112.0000" + getCurrentTimeZone(calendar1);
		assertEquals("value as expected", expectedValue, result.get("value"));
		
		assertTrue("key as expected", result.containsKey("operator"));
		assertEquals("value as expected", "P", result.get("operator"));
	}

	@Test
	public void testSxcmGetAttributeNameValuePairsDateWithNoOperator() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		TS ts = new TSImpl(calendar1);
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "SXCM<TS>", null, null, false, SpecificationVersion.R02_04_02, null, null, null), calendar1, ts);
		assertEquals("map size", 1, result.size());
		assertTrue(xmlResult.isValid());
		
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "19990423101112.0000" + getCurrentTimeZone(calendar1);
		assertEquals("value as expected", expectedValue, result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsInvalidDatePattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMMddHHmmss.SSS0ZZZZZ");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999Apr23101112.0000" + getCurrentTimeZone(calendar);
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertEquals(1, xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidPartialDateTimePatternWithTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMddHHZZZZZ");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999042310" + getCurrentTimeZone(calendar);
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidPartTimePattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMddHHZZZZZ");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999042310" + getCurrentTimeZone(calendar);
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void testGetAttributeNameValuePairsUsingPartTimePattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMM");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "199904";
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertTrue(xmlResult.isValid());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidDatePatternMissingTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithValidPatternMissingTZ = new DateWithPattern(calendar, "yyyyMMddHH");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.R02_04_02, null, null, null), dateWithValidPatternMissingTZ, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "1999042310", result.get("value"));
		// non-R2 formatter would complain about missing TZ; R2 schema does not explicitly state this is true
		assertTrue(xmlResult.isValid());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidDatePatternForCeRxMissingTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMddHH");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(xmlResult, null, "name", "TS", null, null, false, SpecificationVersion.V01R04_3, null, null, null), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999042310";
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void testGetAttributeNameValuePairsDateWithDatePatternInformation() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null), 
				new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(calendar1, "yyyyMMddHHmmss"), null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "19990423101112", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsDateWithMillisAndTimezoneDatePatternInformation() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, null), 
				new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(calendar, "yyyyMMddHHmmss.SSSZZZZZ"), null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		// SPD: hard to verify result date string since it is timezone dependent. we check length instead
		assertEquals("value length as expected", "yyyyMMddHHmmss.SSSZZZZZ".length(), result.get("value").length());
	}
	
	@Test
	public void testGetAttributeNameValuePairsDateWithMillisAndTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		String resultXml = new TsR2PropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, null), 
				new TSImpl(calendar)
		);
		String result = resultXml.substring("<name value=\"".length(), resultXml.indexOf("\"/>"));
				
		assertEquals("value length as expected", "yyyyMMddHHmmss.SSS0ZZZZZ".length(), result.length());
		assertTrue("value as expected", result.startsWith("19990423101112.000"));
	}
	
	@Test
	public void testVersionDefault() throws Exception  {
		String value = "19990423101112.0000";
		handleVersion((SpecificationVersion) null, value, true);
	}

	@Test
	public void testVersionNew() throws Exception  {
		String value = "19990423101112.0000";
		handleVersion(SpecificationVersion.R02_04_02, value, true);
	}
	
	@Test
	public void testVersionOld() throws Exception  {
		handleVersion(SpecificationVersion.V01R04_3, "19990423101112.0000", true);
	}
	
	private void handleVersion(SpecificationVersion version, String expected, boolean withTimeZone) {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsR2PropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, version, null, null, null), calendar, null);
		assertEquals("map size", 1, result.size());
		
		String expectedValue = withTimeZone?expected+getCurrentTimeZone(calendar):expected;
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", expectedValue, result.get("value"));
	}
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void testGetValueGeneratesDifferentStringsForDifferentTimeZones() throws Exception  {
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		String gmtSixValue = new TsR2PropertyFormatter().getValue(calendar, createFormatContextWithTimeZone(TimeZone.getTimeZone("GMT-6")), null);
		String gmtFiveValue = new TsR2PropertyFormatter().getValue(calendar, createFormatContextWithTimeZone(TimeZone.getTimeZone("GMT-5")), null);
		assertFalse(StringUtils.equals(gmtSixValue, gmtFiveValue));
	}

	private FormatContextImpl createFormatContextWithTimeZone(TimeZone timeZone) {
		return new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, null, false, null, null, timeZone, null);
	}
	
	@Test
	public void testDateFormatPrecedence() throws Exception {
		VersionNumber version = SpecificationVersion.V02R02_AB;
		System.clearProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral()
				);

		String dateWithPatternPattern = "test1_mmddyy";
		String overridePattern = "test2_MMDDYY";

		Date dateWithPattern = new DateWithPattern(new Date(), dateWithPatternPattern);
		Date normalDate = new Date();
		
		TsR2PropertyFormatter formatter = new TsR2PropertyFormatter();
		
		assertEquals("Should use default format if nothing else provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, version));
		
		System.setProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral(),
				overridePattern);
		
		assertEquals("Should use override format when provided", 
				overridePattern, formatter.determineDateFormat(normalDate, version));
		assertEquals("Should always use override format when provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, SpecificationVersion.V02R02));
		assertEquals("Should always use override format when provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_3));
		assertEquals("Should always use override format when provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should always use override format when provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, SpecificationVersion.R02_04_03));
		
		assertEquals("Should use date with pattern always when provided", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, version));
		assertEquals("Should use date with pattern always when provided even if version is CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, SpecificationVersion.V01R04_3));
		assertEquals("Should use date with pattern always when provided even if version is SK CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, SpecificationVersion.V01R04_2_SK));
		
		System.clearProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral()
				);
	}
	
	private String getCurrentTimeZone(Date calendar) {
		SimpleDateFormat tzformat = new SimpleDateFormat("Z");
		String currentTimeZone = tzformat.format(calendar);
		return currentTimeZone;
	}
}
