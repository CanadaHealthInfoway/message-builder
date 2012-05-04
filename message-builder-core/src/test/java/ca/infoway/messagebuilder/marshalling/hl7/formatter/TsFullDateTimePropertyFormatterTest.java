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

import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSS;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSSZZZZZ;
import static ca.infoway.messagebuilder.marshalling.hl7.formatter.TsFullDateTimePropertyFormatter.DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.DateWithPattern;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class TsFullDateTimePropertyFormatterTest {

	// a hack to make sure our legacy NEWFOUNDLAND tests work
	private static final VersionNumber NEWFOUNDLAND_LEGACY_VERSION_HACK = new VersionNumber() {
		public String getVersionLiteral() {return "NEWFOUNDLAND";}
		public VersionNumber getBaseVersion() {return null;}
	};

	public TsFullDateTimePropertyFormatterTest() {
	    System.setProperty("user.timezone", Calendar.getInstance().getTimeZone().getDisplayName());
	}
	
	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception  {
		Map<String,String>  result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);
		
		// a null value for TS elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsDate() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), calendar1);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		String expectedValue = "19990423101112.0000" + getCurrentTimeZone();
		assertEquals("value as expected", expectedValue, result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsDateWithDatePatternInformation() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar1 = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(
				new FormatContextImpl("name", null, null), 
				new ca.infoway.messagebuilder.datatype.lang.DateWithPattern(calendar1, "yyyyMMddHHmmss"));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "19990423101112", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsDateWithMillisAndTimezoneDatePatternInformation() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(
				new FormatContextImpl("name", null, null, false, SpecificationVersion.R02_04_02, null, null), 
				new ca.infoway.messagebuilder.datatype.lang.DateWithPattern(calendar, "yyyyMMddHHmmss.SSSZZZZZ"));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		// SPD: hard to verify result date string since it is timezone dependent. we check length instead
		assertEquals("value length as expected", "yyyyMMddHHmmss.SSSZZZZZ".length(), result.get("value").length());
	}
	
	@Test
	public void testGetAttributeNameValuePairsDateWithMillisAndTimezone() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		String resultXml = new TsFullDateTimePropertyFormatter().format(
				new FormatContextImpl("name", null, null, false, SpecificationVersion.R02_04_02, null, null), 
				new TSImpl(calendar)
		);
		String result = resultXml.substring("<name value=\"".length(), resultXml.indexOf("\"/>"));
				
		assertEquals("value length as expected", "yyyyMMddHHmmss.SSS0ZZZZZ".length(), result.length());
		assertTrue("value as expected", result.startsWith("19990423101112.000"));
	}
	
	@Test
	public void testVersionDefault() throws Exception  {
		String value = "19990423101112.0000" + getCurrentTimeZone();
		handleVersion((SpecificationVersion) null, value);
	}

	@Test
	public void testVersionNew() throws Exception  {
		String value = "19990423101112.0000" + getCurrentTimeZone();
		handleVersion(SpecificationVersion.R02_04_02, value);
	}
	
	@Test
	public void testVersionOld() throws Exception  {
		handleVersion(SpecificationVersion.V01R04_3, "19990423101112");
	}
	
	private void handleVersion(SpecificationVersion version, String expected)	throws ModelToXmlTransformationException {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null, false, version, null, null), calendar);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", expected, result.get("value"));
	}
	
	/**
	 * @sharpen.remove
	 */
	@Test
	public void testGetValueGeneratesDifferentStringsForDifferentTimeZones() throws Exception  {
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		String gmtSixValue = new TsFullDateTimePropertyFormatter().getValue(calendar, createFormatContextWithTimeZone(TimeZone.getTimeZone("GMT-6")));
		String gmtFiveValue = new TsFullDateTimePropertyFormatter().getValue(calendar, createFormatContextWithTimeZone(TimeZone.getTimeZone("GMT-5")));
		assertFalse(StringUtils.equals(gmtSixValue, gmtFiveValue));
	}

	private FormatContextImpl createFormatContextWithTimeZone(TimeZone timeZone) {
		return new FormatContextImpl("name", null, null, false, null, null, timeZone, true);
	}
	
	@Test
	public void testDateFormatPrecedence() throws Exception {
		VersionNumber version = SpecificationVersion.V02R02_AB;
		String dateWithPatternPattern = "test1_mmddyy";
		String overridePattern = "test2_MMDDYY";

		Date dateWithPattern = new DateWithPattern(new Date(), dateWithPatternPattern);
		Date normalDate = new Date();
		
		TsFullDateTimePropertyFormatter formatter = new TsFullDateTimePropertyFormatter();
		
		assertEquals("Should use default format if nothing else provided", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, version));
		assertEquals("Should use old default format if nothing else provided and version is CeRx", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_3));
		assertEquals("Should use old default format if nothing else provided and version is SK CeRx", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should use old 'bad' default format if nothing else provided and version is NFLD", 
				DATE_FORMAT_YYYYMMDDHHMMSSZZZZZ, formatter.determineDateFormat(normalDate, NEWFOUNDLAND_LEGACY_VERSION_HACK));
		
		System.setProperty(
				DATE_FORMAT_OVERRIDE_BASE_PROPERTY_NAME + version.getVersionLiteral(),
				overridePattern);
		
		assertEquals("Should use override format when provided", 
				overridePattern, formatter.determineDateFormat(normalDate, version));
		assertEquals("Should not use override format when provided version is only the base version of provided version", 
				DATE_FORMAT_YYYYMMDDHHMMSS_SSSZZZZZ, formatter.determineDateFormat(normalDate, SpecificationVersion.V02R02));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_3));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSS, formatter.determineDateFormat(normalDate, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should not use override format when provided version does not match", 
				DATE_FORMAT_YYYYMMDDHHMMSSZZZZZ, formatter.determineDateFormat(normalDate, NEWFOUNDLAND_LEGACY_VERSION_HACK));
		
		assertEquals("Should use date with pattern always when provided", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, version));
		assertEquals("Should use date with pattern always when provided even if version is CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, SpecificationVersion.V01R04_3));
		assertEquals("Should use date with pattern always when provided even if version is SK CeRx", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, SpecificationVersion.V01R04_2_SK));
		assertEquals("Should use date with pattern always when provided even if version is NFLD", 
				dateWithPatternPattern, formatter.determineDateFormat(dateWithPattern, NEWFOUNDLAND_LEGACY_VERSION_HACK));
	}
	
	private String getCurrentTimeZone() {
		SimpleDateFormat tzformat = new SimpleDateFormat("Z");
		String currentTimeZone = tzformat.format(new Date());
		return currentTimeZone;
	}
}
