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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-16 20:18:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6877 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class HxitCeR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testNullFlavor() throws Exception {
		String result = new HxitCeR2PropertyFormatter().format(getContext("name", "HXIT<CE>"), new CE_R2Impl(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testValidFull() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				new DateWithPattern(DateUtil.getDate(2006, 11, 25), "yyyyMMdd"),
				new DateWithPattern(DateUtil.getDate(2007, 0, 2), "yyyyMMdd"));

		CodedTypeR2<Code> translation1 = new CodedTypeR2<Code>();
		translation1.setCode(CeRxDomainTestValues.KILOGRAM);
		
		CodedTypeR2<Code> translation2 = new CodedTypeR2<Code>();
		translation2.setCode(CeRxDomainTestValues.FLUID_OUNCE);
		
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.getTranslation().add(translation1);	
		codedType.getTranslation().add(translation2);	
		codedType.setValidTime(interval);
		
		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setContent("some original text");
		codedType.setOriginalText(originalText);
		
		String result = new HxitCeR2PropertyFormatter().format(getContext("name", "HXIT<CE>"), new CE_R2Impl(codedType));
		
		assertTrue(this.result.isValid());
		
		assertXml("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\">" +
				"<originalText>some original text</originalText>" +
				"<translation code=\"kg\" codeSystem=\"1.2.3.4\"/>" +
				"<translation code=\"[foz_br]\" codeSystem=\"1.2.3.4\"/>" +
				"<validTime><low value=\"20061225\"/><high value=\"20070102\"/></validTime>" +
				"</name>", StringUtils.trim(result), true);
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();

		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setContent("original text allowed for CE");
		codedType.setOriginalText(originalText);
		
		CE_R2 ce = new CE_R2Impl(codedType);
		ce.setNullFlavor(NullFlavor.NO_INFORMATION);
		
		String result = new HxitCeR2PropertyFormatter().format(getContext("name", "HXIT<CE>"), ce);
		
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"><originalText>original text allowed for CE</originalText></name>", StringUtils.trim(result), true);
	}

	@Test
	public void testEverythingSpecified() throws Exception {
		Interval<Date> interval = IntervalFactory.<Date>createLowHigh(
				new DateWithPattern(DateUtil.getDate(2006, 11, 25), "yyyyMMdd"),
				new DateWithPattern(DateUtil.getDate(2007, 0, 2), "yyyyMMdd"));

		CodedTypeR2<Code> translation1 = new CodedTypeR2<Code>();
		translation1.setCode(CeRxDomainTestValues.KILOGRAM);
		
		CodedTypeR2<Code> translation2 = new CodedTypeR2<Code>();
		translation2.setCode(CeRxDomainTestValues.FLUID_OUNCE);
		
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.setSimpleValue("simpleValue");
		codedType.setOperator(SetOperator.CONVEX_HULL);
		codedType.setValue(BigDecimal.ONE);
		codedType.getTranslation().add(translation1);	
		codedType.getTranslation().add(translation2);	
		codedType.getQualifier().add(new CodeRole());
		codedType.setValidTime(interval);
		
		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setContent("some original text");
		codedType.setOriginalText(originalText);
		
		CE_R2 ce = new CE_R2Impl(codedType);
		
		String result = new HxitCeR2PropertyFormatter().format(getContext("name", "HXIT<CE>"), ce);
		
		assertFalse(this.result.isValid());
		assertEquals(4, this.result.getHl7Errors().size());
		assertXml("result", 
				"<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\">" +
				"<originalText>some original text</originalText>" +
				"<translation code=\"kg\" codeSystem=\"1.2.3.4\"/>" +
				"<translation code=\"[foz_br]\" codeSystem=\"1.2.3.4\"/>" +
				"<validTime><low value=\"20061225\"/><high value=\"20070102\"/></validTime>" +
				"</name>", 
				StringUtils.trim(result), true);
	}

}
