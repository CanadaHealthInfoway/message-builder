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

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.impl.SXCM_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.controlact.ActClass;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class SxcmCdR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testNullFlavor() throws Exception {
		String result = new SxcmCdR2PropertyFormatter().format(getContext("name", "SXCM<CD>"), new SXCM_R2Impl<CodedTypeR2<Code>>(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testValidFull() throws Exception {
		CodedTypeR2<Code> translation1 = new CodedTypeR2<Code>();
		translation1.setCode(CeRxDomainTestValues.KILOGRAM);
		
		CodedTypeR2<Code> translation2 = new CodedTypeR2<Code>();
		translation2.setCode(CeRxDomainTestValues.FLUID_OUNCE);
		
		CodedTypeR2<Code> name1 = new CodedTypeR2<Code>();
		name1.setCode(CeRxDomainTestValues.CENTIMETRE);
		
		CodedTypeR2<Code> name2 = new CodedTypeR2<Code>();
		name2.setCode(AdministrativeGender.MALE);

		CodedTypeR2<Code> value1 = new CodedTypeR2<Code>();
		value1.setCode(ActStatus.NORMAL);
		
		CodedTypeR2<Code> value2 = new CodedTypeR2<Code>();
		value2.setCode(ActClass.ACT);

		CodeRole codeRole1 = new CodeRole(name1, value1, true);
		CodeRole codeRole2 = new CodeRole(name2, value2, true);

		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.setOperator(SetOperator.INTERSECT);
		codedType.getQualifier().add(codeRole1);
		codedType.getQualifier().add(codeRole2);
		codedType.getTranslation().add(translation1);	
		codedType.getTranslation().add(translation2);	
		
		EncapsulatedData originalText = new EncapsulatedData();
		originalText.setTextContent("some original text");
		codedType.setOriginalText(originalText);

		String result = new SxcmCdR2PropertyFormatter().format(getContext("name", "SXCM<CD>"), new SXCM_R2Impl<CodedTypeR2<Code>>(codedType));
		
		assertTrue(this.result.isValid());
		
		assertXml("result", 
				"<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\" operator=\"A\">" +
				"<originalText>some original text</originalText>" +
				"<qualifier inverted=\"true\"><name code=\"cm\" codeSystem=\"1.2.3.4\"/><value code=\"normal\" codeSystem=\"2.16.840.1.113883.5.14\"/></qualifier>" +
				"<qualifier inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><value code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/></qualifier>" +
				"<translation code=\"kg\" codeSystem=\"1.2.3.4\"/>" +
				"<translation code=\"[foz_br]\" codeSystem=\"1.2.3.4\"/>" +
				"</name>", 
				StringUtils.trim(result), true);
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		
		EncapsulatedData originalText = new EncapsulatedData();
		originalText.setTextContent("original text allowed for CD");
		codedType.setOriginalText(originalText);

		SXCM_R2<CodedTypeR2<Code>> sxcmCd = new SXCM_R2Impl<CodedTypeR2<Code>>(codedType);
		sxcmCd.setNullFlavor(NullFlavor.NO_INFORMATION);
		
		String result = new SxcmCdR2PropertyFormatter().format(getContext("name", "SXCM<CD>"), sxcmCd);
		
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"><originalText>original text allowed for CD</originalText></name>", StringUtils.trim(result), true);
	}

	@Test
	public void testEverythingSpecified() throws Exception {
		CodedTypeR2<Code> translation1 = new CodedTypeR2<Code>();
		translation1.setCode(CeRxDomainTestValues.KILOGRAM);
		
		CodedTypeR2<Code> translation2 = new CodedTypeR2<Code>();
		translation2.setCode(CeRxDomainTestValues.FLUID_OUNCE);
		
		CodedTypeR2<Code> name1 = new CodedTypeR2<Code>();
		name1.setCode(CeRxDomainTestValues.CENTIMETRE);
		
		CodedTypeR2<Code> name2 = new CodedTypeR2<Code>();
		name2.setCode(AdministrativeGender.MALE);

		CodedTypeR2<Code> value1 = new CodedTypeR2<Code>();
		value1.setCode(ActStatus.NORMAL);
		
		CodedTypeR2<Code> value2 = new CodedTypeR2<Code>();
		value2.setCode(ActClass.ACT);

		CodeRole codeRole1 = new CodeRole(name1, value1, true);
		CodeRole codeRole2 = new CodeRole(name2, value2, true);

		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.setSimpleValue("simpleValue");
		codedType.setOperator(SetOperator.CONVEX_HULL);
		codedType.setValue(BigDecimal.ONE);
		codedType.setOperator(SetOperator.INTERSECT);
		codedType.getQualifier().add(codeRole1);
		codedType.getQualifier().add(codeRole2);
		codedType.getTranslation().add(translation1);	
		codedType.getTranslation().add(translation2);	
		
		EncapsulatedData originalText = new EncapsulatedData();
		originalText.setTextContent("some original text");
		codedType.setOriginalText(originalText);

		SXCM_R2<CodedTypeR2<Code>> sxcm_cd = new SXCM_R2Impl<CodedTypeR2<Code>>(codedType);
		
		String result = new SxcmCdR2PropertyFormatter().format(getContext("name", "SXCM<CD>"), sxcm_cd);
		
		assertFalse(this.result.isValid());
		assertEquals(2, this.result.getHl7Errors().size());
		assertXml("result", 
				"<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\" operator=\"A\">" +
				"<originalText>some original text</originalText>" +
				"<qualifier inverted=\"true\"><name code=\"cm\" codeSystem=\"1.2.3.4\"/><value code=\"normal\" codeSystem=\"2.16.840.1.113883.5.14\"/></qualifier>" +
				"<qualifier inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\"/><value code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/></qualifier>" +
				"<translation code=\"kg\" codeSystem=\"1.2.3.4\"/>" +
				"<translation code=\"[foz_br]\" codeSystem=\"1.2.3.4\"/>" +
				"</name>", 
				StringUtils.trim(result), true);
	}

}
