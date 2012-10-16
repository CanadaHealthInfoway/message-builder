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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.MockEnum;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * Currently this is a copy of the CS test, since the class is identical
 * to the CS class. This will likely change in the future.
 */
public class CdPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new CdPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.result, null, "name", null, null), null, null);
		assertEquals("map size", 0, result.size());
	}

	@Test
	public void testGetAttributeNameValuePairs() throws Exception {
		// used as expected: an enumerated object is passed in
		Map<String, String> result = new CdPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.result, null, "name", null, null), CeRxDomainTestValues.CENTIMETRE, new CDImpl());
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("code"));
		assertEquals("value as expected", "cm", result.get("code"));
		assertTrue("key as expected", result.containsKey("codeSystem"));
		assertEquals("value as expected", "1.2.3.4", result.get("codeSystem"));
	}
	
	@Test
	public void testHandlingOfTrivialCodes() throws Exception {
		String result = new CdPropertyFormatter().format(getContext("name"), new CDImpl(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testHandlingOfSimpleCodes() throws Exception {
		String result = new CdPropertyFormatter().format(getContext("name"), new CDImpl(CeRxDomainTestValues.CENTIMETRE));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CDImpl cd = new CDImpl(NullFlavor.NO_INFORMATION);
		cd.setOriginalText("some original text");
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testOriginalText() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.setOriginalText("some original text");
		String result = new CdPropertyFormatter().format(getContext("name"), cd);

		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // code/codeSystem mandatory (need a CWE coding strength to allow this run to pass without errors)
		assertEquals("result", "<name><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndOptional() throws Exception {
		CDImpl cd = new CDImpl(null);
		String result = new CdPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", null, ConformanceLevel.OPTIONAL, false, SpecificationVersion.R02_04_03, null, null, CodingStrength.CNE), cd);
		
		assertTrue(this.result.isValid());
		assertEquals("result", "", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndMandatory() throws Exception {
		CDImpl cd = new CDImpl(null);
		String result = new CdPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", null, ConformanceLevel.MANDATORY, false, SpecificationVersion.R02_04_03, null, null, CodingStrength.CNE), cd);
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // "name" mandatory
		assertTrue("error", this.result.getHl7Errors().get(0).getMessage().startsWith("name is a mandatory field, but no value is specified"));
		assertEquals("result", "<name/>", StringUtils.trim(result));
	}
	
	@Test
	public void testNoInternalValuesAndMandatory() throws Exception {
		CDImpl cd = new CDImpl(new Code() {
			public String getCodeValue() {return null;}
			public String getCodeSystem() {return null;}
		});
		String result = new CdPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", null, ConformanceLevel.MANDATORY, false, SpecificationVersion.R02_04_03, null, null, CodingStrength.CNE), cd);
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // code/codeSystem mandatory (need a CWE coding strength to allow this run to pass without errors)
		assertEquals("result", "<name/>", StringUtils.trim(result));
	}
	
	@Test
	public void testSingleTranslation() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.getTranslations().add(new CDImpl(MockEnum.FRED));
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // code/codeSystem mandatory
		assertEquals("result", "<name><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\"/></name>", StringUtils.trim(result));
	}

	@Test
	public void testMultipleTranslations() throws Exception {
		CDImpl cd = new CDImpl(null);
		cd.getTranslations().add(new CDImpl(MockEnum.FRED));
		cd.getTranslations().add(new CDImpl(MockEnum.BARNEY));
		String result = new CdPropertyFormatter().format(getContext("name"), cd);
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size()); // code/codeSystem mandatory
		assertEquals("result", "<name><translation code=\"FRED\" codeSystem=\"1.2.3.4.5\"/><translation code=\"BARNEY\" codeSystem=\"1.2.3.4.5\"/></name>", StringUtils.trim(result));
	}
}
