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

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSS;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.TimeZoneUtil;
import ca.infoway.messagebuilder.platform.DateFormatUtil;

public class TsFullDateTimePropertyFormatterTest {
	
	private static class TestableTsFullDateTimePropertyFormatter extends TsFullDateTimePropertyFormatter implements TestableAbstractValueNullFlavorPropertyFormatter<Date> {
		public Map<String, String> getAttributeNameValuePairsForTest(FormatContext context, Date t, BareANY bareAny) {
			return super.getAttributeNameValuePairs(context, t, bareAny);
		}
		public String getValueForTest(Date date, FormatContext context, BareANY bareAny) {
			return super.getValue(date, context, bareAny);
		}
	}

	// a hack to make sure our legacy NEWFOUNDLAND tests work
	private static final VersionNumber NEWFOUNDLAND_LEGACY_VERSION_HACK = new VersionNumber() {
		public String getVersionLiteral() {return "NEWFOUNDLAND";}
		public Hl7BaseVersion getBaseVersion() {return Hl7BaseVersion.MR2007;} // Newfoundland (as IWD currently implements it) is a mix of CeRx and V02R02
		public Hl7BaseVersion getBaseVersion(Typed datatype) {return getBaseVersion();}
	};

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception  {
		Map<String,String>  result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), null, new TSImpl());
		
		// a null value for TS elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsDate() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), calendar1, null);
		assertEquals("map size", 1, result.size());
		
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
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.DATETIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithInvalidPattern, null);
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
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.DATETIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithInvalidPattern, null);
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
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.FULLDATEPARTTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999042310" + getCurrentTimeZone(calendar);
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertTrue(xmlResult.getHl7Errors().isEmpty());
	}
	
	@Test
	public void testGetAttributeNameValuePairsInvalidPartTimePattern() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMM");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.FULLDATEPARTTIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "199904";
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertEquals(1, xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidDatePatternMissingTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithValidPatternMissingTZ = new DateWithPattern(calendar, "yyyyMMddHH");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.DATETIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithValidPatternMissingTZ, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "1999042310", result.get("value"));
		assertEquals(1, xmlResult.getHl7Errors().size());
		assertTrue(xmlResult.getHl7Errors().get(0).getMessage().contains("ZZZZZ"));
	}
	
	@Test
	public void testGetAttributeNameValuePairsInvalidDatePatternMissingTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMddHH");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.DATETIME", null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), dateWithInvalidPattern, null);
		assertEquals("map size", 1, result.size());
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "1999042310";
		assertEquals("value as expected", expectedValue, result.get("value"));
		assertEquals(1, xmlResult.getHl7Errors().size());
	}
	
	@Test
	public void testGetAttributeNameValuePairsValidDatePatternForCeRxMissingTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		DateWithPattern dateWithInvalidPattern = new DateWithPattern(calendar, "yyyyMMddHH");
		
		ModelToXmlResult xmlResult = new ModelToXmlResult();
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(xmlResult, null, "name", "TS.DATETIME", null, null, false, SpecificationVersion.V01R04_3, null, null, null, false), dateWithInvalidPattern, null);
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
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false), 
				new ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern(calendar1, "yyyyMMddHHmmss"), null);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "19990423101112", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsDateWithMillisAndTimezoneDatePatternInformation() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
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
		String resultXml = new TestableTsFullDateTimePropertyFormatter().format(
				new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, null, false), 
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
		handleVersion(SpecificationVersion.V01R04_3, "19990423101112", false);
	}
	
	private void handleVersion(SpecificationVersion version, String expected, boolean withTimeZone) {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TestableTsFullDateTimePropertyFormatter().getAttributeNameValuePairsForTest(new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, false, version, null, null, null, false), calendar, null);
		assertEquals("map size", 1, result.size());
		
		String expectedValue = withTimeZone?expected+getCurrentTimeZone(calendar):expected;
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", expectedValue, result.get("value"));
	}
	
	@Test
	public void testGetValueGeneratesDifferentStringsForDifferentTimeZones() throws Exception  {
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		String gmtSixValue = new TestableTsFullDateTimePropertyFormatter().getValueForTest(calendar, createFormatContextWithTimeZone(TimeZoneUtil.getTimeZone("GMT-6")), null);
		String gmtFiveValue = new TestableTsFullDateTimePropertyFormatter().getValueForTest(calendar, createFormatContextWithTimeZone(TimeZoneUtil.getTimeZone("GMT-5")), null);
		assertFalse(StringUtils.equals(gmtSixValue, gmtFiveValue));
	}

	private FormatContextImpl createFormatContextWithTimeZone(TimeZone timeZone) {
		return new FormatContextImpl(new ModelToXmlResult(), null, "name", null, null, null, null, false, null, null, timeZone, null, null, false);
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
		
		TsFullDateTimePropertyFormatter formatter = new TestableTsFullDateTimePropertyFormatter();
		
		assertEquals("Should use default format if nothing else provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, version));
		assertEquals("Should use old default format if nothing else provided and version is CeRx", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, SpecificationVersion.V01R04_3));
		assertEquals("Should use old default format if nothing else provided and version is SK CeRx", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should NOW use default format if nothing else provided and version is NFLD", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, NEWFOUNDLAND_LEGACY_VERSION_HACK));
		
		System.setProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral(),
				overridePattern);
		
		assertEquals("Should use override format when provided", 
				overridePattern, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, version));
		assertEquals("Should not use override format when provided version is only the base version of provided version", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, SpecificationVersion.V02R02));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, SpecificationVersion.V01R04_3));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, normalDate, NEWFOUNDLAND_LEGACY_VERSION_HACK));
		
		assertEquals("Should use date with pattern always when provided", 
				dateWithPatternPattern, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, dateWithPattern, version));
		assertEquals("Should use date with pattern always when provided even if version is CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, dateWithPattern, SpecificationVersion.V01R04_3));
		assertEquals("Should use date with pattern always when provided even if version is SK CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, dateWithPattern, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should use date with pattern always when provided even if version is NFLD", 
				dateWithPatternPattern, formatter.determineDateFormat(StandardDataType.TS_FULLDATETIME, dateWithPattern, NEWFOUNDLAND_LEGACY_VERSION_HACK));
		
		System.clearProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral()
				);
	}
	
	private String getCurrentTimeZone(Date calendar) {
		return DateFormatUtil.format(calendar, "Z");
	}
}
