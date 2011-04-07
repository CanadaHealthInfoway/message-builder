package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class TsFullDateTimePropertyFormatterTest {

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
		assertEquals("value as expected", "19990423101112.0000-0400", result.get("value"));
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
				new FormatContextImpl("name", null, null, false, SpecificationVersion.R02_04_02), 
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
				new FormatContextImpl("name", null, null, false, SpecificationVersion.R02_04_02), 
				new TSImpl(calendar)
		);
		String result = resultXml.substring("<name value=\"".length(), resultXml.indexOf("\"/>"));
				
		assertEquals("value length as expected", "yyyyMMddHHmmss.SSS0ZZZZZ".length(), result.length());
		assertTrue("value as expected", result.startsWith("19990423101112.000"));
	}
	
	@Test
	public void testVersionDefault() throws Exception  {
		handleVersion(null, "19990423101112.0000-0400");
	}

	@Test
	public void testVersionNew() throws Exception  {
		handleVersion(SpecificationVersion.R02_04_02, "19990423101112.0000-0400");
	}
	
	@Test
	public void testVersionOld() throws Exception  {
		handleVersion(SpecificationVersion.V01R04_3, "19990423101112");
	}
	
	private void handleVersion(SpecificationVersion r020402, String expected)	throws ModelToXmlTransformationException {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDateTimePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null, false, r020402), calendar);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", expected, result.get("value"));
	}
}
