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

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * Currently this is a copy of the CS test, since the class is identical
 * to the CS class. This will likely change in the future.
 */
public class CvPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testGetAttributeNameValuePairsNullValue() throws Exception {
		Map<String,String>  result = new CvPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.result, null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, false), null, null);
		assertEquals("map size", 0, result.size());
	}

	@Test
	public void testGetAttributeNameValuePairs() throws Exception {
		// used as expected: an enumerated object is passed in
		Map<String, String> result = new CvPropertyFormatter().getAttributeNameValuePairs(new FormatContextImpl(this.result, null, "name", null, null, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, false), CeRxDomainTestValues.CENTIMETRE, null);
		assertEquals("map size", 2, result.size());
		
		assertTrue("key as expected", result.containsKey("code"));
		assertEquals("value as expected", "cm", result.get("code"));
		
		assertTrue("key as expected", result.containsKey("codeSystem"));
		assertEquals("value as expected", "1.2.3.4", result.get("codeSystem"));
	}
	
	@Test
	public void testHandlingOfTrivialCodes() throws Exception {
		String result = new CvPropertyFormatter().format(getContext("name"), new CVImpl(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testHandlingOfSimpleCodes() throws Exception {
		String result = new CvPropertyFormatter().format(getContext("name"), new CVImpl(CeRxDomainTestValues.CENTIMETRE));
		
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().startsWith("Could not locate a registered domain type to match "));
		
		assertEquals("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testHandlingOfSimpleCodesWithDisplayNameNotForBC() throws Exception {
		CVImpl cvImpl = new CVImpl(CeRxDomainTestValues.CENTIMETRE);
		cvImpl.setDisplayName("testDisplayName");
		
		String result = new CvPropertyFormatter().format(getContext("name", StandardDataType.CV.getType()), cvImpl);
		
		assertEquals(2, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().startsWith("Could not locate a registered domain type to match "));
		assertEquals("CV should not include the 'displayName' property", this.result.getHl7Errors().get(1).getMessage());
		
		assertEquals("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\" displayName=\"testDisplayName\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testHandlingOfSimpleCodesWithDisplayNameForBC() throws Exception {
		CVImpl cvImpl = new CVImpl(CeRxDomainTestValues.CENTIMETRE);
		cvImpl.setDisplayName("testDisplayName");
		
		FormatContext context = getContext("name", StandardDataType.CV.getType(), SpecificationVersion.V02R04_BC);
		String result = new CvPropertyFormatter().format(context, cvImpl);
		
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().startsWith("Could not locate a registered domain type to match "));
		
		assertEquals("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\" displayName=\"testDisplayName\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testHandlingOfSimpleCodesWithDisplayNameForBCWithNullFlavor() throws Exception {
		CVImpl cvImpl = new CVImpl(NullFlavor.NOT_APPLICABLE);
		cvImpl.setDisplayName("testDisplayName");
		
		FormatContext context = getContext("name", StandardDataType.CV.getType(), SpecificationVersion.V02R04_BC);
		String result = new CvPropertyFormatter().format(context, cvImpl);
		
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("CV should not include the 'displayName' property (when a nullFlavor)", this.result.getHl7Errors().get(0).getMessage());
		
		assertEquals("result", "<name displayName=\"testDisplayName\" nullFlavor=\"NA\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CVImpl cv = new CVImpl(NullFlavor.NO_INFORMATION);
		cv.setOriginalText("some original text");
		String result = new CvPropertyFormatter().format(getContext("name"), cv);
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testOriginalText() throws Exception {
		CVImpl cv = new CVImpl(null);
		cv.setOriginalText("some original text");
		String result = new CvPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", "CV", null, null, false, SpecificationVersion.R02_04_03, null, null, CodingStrength.CWE, false), cv);
		assertTrue(this.result.isValid());
		assertEquals("result", "<name><originalText>some original text</originalText></name>", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndOptional() throws Exception {
		CVImpl cv = new CVImpl(null);
		String result = new CvPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", null, ConformanceLevel.OPTIONAL, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, false), cv);
		assertTrue(this.result.isValid());
		assertEquals("result", "", StringUtils.trim(result));
	}

	@Test
	public void testNoValueAndMandatory() throws Exception {
		CVImpl cv = new CVImpl(null);
		String result = new CvPropertyFormatter().format(new FormatContextImpl(this.result, null, "name", null, ConformanceLevel.MANDATORY, null, false, SpecificationVersion.R02_04_02, null, null, CodingStrength.CNE, false), cv);
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals("result", "<name/>", StringUtils.trim(result));
	}
	
}
