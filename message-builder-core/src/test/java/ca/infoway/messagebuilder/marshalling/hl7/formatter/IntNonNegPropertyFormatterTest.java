package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IntNonNegPropertyFormatterTest extends MarshallingTestCase {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new IntNonNegPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);

		// a null value for INT elements results in a nullFlavor attribute
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("nullFlavor"));
		assertEquals("value as expected", AbstractPropertyFormatter.NULL_FLAVOR_NO_INFORMATION, result.get("nullFlavor"));
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerValid() throws Exception {
		String integerValue = "34";
		Map<String, String> result = new IntNonNegPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new Integer(integerValue));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));
	}

	@Test
	public void testNullCaseMandatory() throws Exception {
		String result = new IntNonNegPropertyFormatter().format(
				new FormatContextImpl("name", "INT", ConformanceLevel.POPULATED), new INTImpl());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testNullCasePopulated() throws Exception {
		String result = new IntNonNegPropertyFormatter().format(
				new FormatContextImpl("name", "INT", ConformanceLevel.POPULATED), new INTImpl());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testNullCaseNotMandatory() throws Exception {
		String result = new IntNonNegPropertyFormatter().format(
				new FormatContextImpl("name", "INT", ConformanceLevel.OPTIONAL), null);
		assertTrue("result", StringUtils.isBlank(result));
	}
	
	@Test
	public void testGetAttributeNameValuePairsIntegerZero() throws Exception {
		String integerValue = "0";
		Map<String, String> result = new IntNonNegPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), new Integer(integerValue));
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("value"));
		assertEquals("value as expected", integerValue, result.get("value"));
	}

	@Test
	public void testGetAttributeNameValuePairsIntegerNegative() throws Exception {
		String integerValue = "-1";
		String string = new IntNonNegPropertyFormatter().format(
				new FormatContextImpl("name", "INT.NONNEG", ConformanceLevel.REQUIRED),
				new INTImpl(new Integer(integerValue)));
		assertTrue("warning: ", string.contains("<!-- WARNING:"));
	}
	
	@Test
	public void testGetAttributeNameValuePairsIntegerZeroNoWarnings() throws Exception {
		String integerValue = "0";
		String string = new IntNonNegPropertyFormatter().format(
				new FormatContextImpl("name", "INT.NONNEG", ConformanceLevel.REQUIRED),
				new INTImpl(new Integer(integerValue)));
		assertFalse("warning: " + string, string.contains("<!-- WARNING:"));
	}
}
