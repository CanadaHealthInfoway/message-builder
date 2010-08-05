package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.MarshallingTestCase;

public class IiPropertyFormatterTest extends MarshallingTestCase {

	@Test
    public void testGetAttributeNameValuePairsAllFilledIn() throws Exception {
        Identifier ii = new Identifier("rootString", "extensionString");
        Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), ii, null);
        assertEquals("map size", 2, result.size());
        
        assertKeyValuePairInMap(result, "root", "rootString");
        assertKeyValuePairInMap(result, "extension", "extensionString");
    }

	@Test
    public void testGetAttributeNameValuePairsAllFilledInWithTypeId() throws Exception {
    	Identifier ii = new Identifier("rootString", "extensionString");
    	Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), ii, null);
    	assertEquals("map size", 2, result.size());
    	
    	assertKeyValuePairInMap(result, "root", "rootString");
    	assertKeyValuePairInMap(result, "extension", "extensionString");
    }
    
	@Test
    public void testGetAttributeNameValuePairsRootNotFilled() throws Exception {
        Identifier ii = new Identifier((String) null, "extension");
        String format = new IiPropertyFormatter().format(new FormatContextImpl("name", null, null), new IIImpl(ii));
        assertTrue("result: " + format, format.contains("<!-- WARNING:"));
    }

	@Test
    public void testGetAttributeNameValuePairsExtensionNotFilled() throws Exception {
        Identifier ii = new Identifier("rootString", null);
        Map<String, String> result = new IiPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), ii, null);
        assertEquals("map size", 1, result.size());
        
        assertKeyValuePairInMap(result, "root", "rootString");
        assertKeyNotInMap(result, "extension");
    }

    private void assertKeyValuePairInMap(Map<String, String> map, String key, String value) {
        assertTrue("key " + key + " as expected", map.containsKey(key));
        assertEquals("value for key " + key + " as expected", value, map.get(key));
    }

    private void assertKeyNotInMap(Map<String, String> map, String key) {
        assertTrue("key " + key + " as expected", !map.containsKey(key));
    }
}
