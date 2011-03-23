package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.DateUtil;

public class TsFullDatePropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);

		// a null value for TS elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsDate() throws Exception  {
		// used as expected: a date object is passed in
		Date calendar = DateUtil.getDate(1999, 3, 23, 10, 11, 12, 0);
		Map<String, String> result = new TsFullDatePropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), calendar);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "19990423", result.get("value"));
	}
}
