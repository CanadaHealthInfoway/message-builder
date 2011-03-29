package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * Currently this is a copy of the CS test, since the class is identical
 * to the CS class. This will likely change in the future.
 */
public class CdPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new CdPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), null);
		assertEquals("map size", 0, result.size());
	}

	@Test
	public void testGetAttributeNameValuePairs() throws Exception {
		// used as expected: an enumerated object is passed in
		Map<String, String> result = new CdPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl("name", null, null), CeRxDomainTestValues.CENTIMETRE);
		assertEquals("map size", 1, result.size());
		
		assertTrue("key as expected", result.containsKey("code"));
		assertEquals("value as expected", "cm", result.get("code"));
	}
	
	@Test
	public void testHandlingOfTrivialCodes() throws Exception {
		String result = new CdPropertyFormatter().format(getContext("name"), new CDImpl(NullFlavor.NO_INFORMATION));
		
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testHandlingOfSimpleCodes() throws Exception {
		String result = new CdPropertyFormatter().format(getContext("name"), new CDImpl(CeRxDomainTestValues.CENTIMETRE));
		
		assertEquals("result", "<name code=\"cm\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CDImpl cd = new CDImpl(NullFlavor.NO_INFORMATION);
		cd.setOriginalText("some original text");
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		assertEquals("result", "<name nullFlavor=\"NI\"><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testOriginalText() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.setOriginalText("some original text");
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		assertEquals("result", "<name><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndOptional() throws Exception {
		CDImpl cd = new CDImpl(null);
		String result = new CdPropertyFormatter().format(new FormatContextImpl("name", null, ConformanceLevel.OPTIONAL), cd);
		assertEquals("result", "", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndMandatory() throws Exception {
		CDImpl cd = new CDImpl(null);
		String result = new CdPropertyFormatter().format(new FormatContextImpl("name", null, ConformanceLevel.MANDATORY), cd);
		String lineBreak = System.getProperty("line.separator");
		assertEquals("result", "<!-- WARNING: name is a mandatory field, but no value is specified -->" + lineBreak + "<name/>", StringUtils.trim(result));
	}
	
	@Test
	public void testSingleTranslation() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.getTranslations().add(new CDImpl(MockEnum.FRED));
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		assertEquals("result", "<name><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\"/></name>", StringUtils.trim(result));
	}

	@Test
	public void testMultipleTranslations() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.getTranslations().add(new CDImpl(MockEnum.FRED));
		cd.getTranslations().add(new CDImpl(MockEnum.BARNEY));
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		assertEquals("result", "<name><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BARNEY\" codeSystem=\"1.2.3.4.5\"/></name>", StringUtils.trim(result));
	}
}
