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
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class CsR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testNullFlavor() throws Exception {
		String result = new CsR2PropertyFormatter().format(getContext("name", "CS"), new CS_R2Impl(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testValidFull() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		
		String result = new CsR2PropertyFormatter().format(getContext("name", "CS"), new CS_R2Impl(codedType));
		
		assertTrue(this.result.isValid());
		
		assertEquals("result", "<name code=\"cm\"/>", StringUtils.trim(result));
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		
		EncapsulatedData originalText = new EncapsulatedData();
		originalText.setTextContent("original text not allowed for CS");
		codedType.setOriginalText(originalText);
		
		CS_R2 cs = new CS_R2Impl(codedType);
		cs.setNullFlavor(NullFlavor.NO_INFORMATION);
		
		String result = new CsR2PropertyFormatter().format(getContext("name", "CS"), cs);
		
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertTrue(this.result.getHl7Errors().get(0).getMessage().contains("originalText"));
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testEverythingSpecified() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.setSimpleValue("simpleValue");
		codedType.setOperator(SetOperator.CONVEX_HULL);
		codedType.setValue(BigDecimal.ONE);
		codedType.getTranslation().add(new CodedTypeR2<Code>());
		codedType.getQualifier().add(new CodeRole());
		
		EncapsulatedData originalText = new EncapsulatedData();
		originalText.setTextContent("original text not allowed for CS");
		codedType.setOriginalText(originalText);
		
		CS_R2 cs = new CS_R2Impl(codedType);
		
		String result = new CsR2PropertyFormatter().format(getContext("name", "CS"), cs);
		
		assertFalse(this.result.isValid());
		assertEquals(9, this.result.getHl7Errors().size());
		assertEquals("result", "<name code=\"cm\"/>", StringUtils.trim(result));
	}

}
