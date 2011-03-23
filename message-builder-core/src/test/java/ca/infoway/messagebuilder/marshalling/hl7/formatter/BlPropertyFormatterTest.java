package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class BlPropertyFormatterTest {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new BlPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);

		// a null value for BL elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanTrue() throws Exception  {
		Map<String, String> result = new BlPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), Boolean.TRUE);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "true", result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsBooleanFalse() throws Exception  {
		Map<String, String> result = new BlPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), Boolean.FALSE);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", "false", result.get("value"));
	}
}
