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
import ca.infoway.messagebuilder.datatype.PQR;
import ca.infoway.messagebuilder.datatype.impl.PQRImpl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedDataR2;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class PqrR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testNullFlavor() throws Exception {
		String result = new PqrR2PropertyFormatter().format(getContext("name", "PQR"), new PQRImpl(NullFlavor.NO_INFORMATION));
		
		assertTrue(this.result.isValid());
		assertEquals("result", "<name nullFlavor=\"NI\"/>", StringUtils.trim(result));
	}

	@Test
	public void testValidFull() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		codedType.setCode(CeRxDomainTestValues.CENTIMETRE);
		codedType.setCodeSystemName("aCodeSystemName");
		codedType.setCodeSystemVersion("aCodeSystemVersion");
		codedType.setDisplayName("aDisplayName");
		codedType.setValue(new BigDecimal("1.234"));
		
		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setTextContent("some original text");
		codedType.setOriginalText(originalText);

		String result = new PqrR2PropertyFormatter().format(getContext("name", "PQR"), new PQRImpl(codedType));
		
		assertTrue(this.result.isValid());
		
		assertXml("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\" value=\"1.234\"><originalText>some original text</originalText></name>", StringUtils.trim(result), true);
	}
	
	@Test
	public void testOriginalTextAndNullFlavor() throws Exception {
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>();
		
		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setTextContent("original text allowed for PQR");
		codedType.setOriginalText(originalText);

		PQR pqr = new PQRImpl(codedType);
		pqr.setNullFlavor(NullFlavor.NO_INFORMATION);
		
		String result = new PqrR2PropertyFormatter().format(getContext("name", "PQR"), pqr);
		
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"NI\"><originalText>original text allowed for PQR</originalText></name>", StringUtils.trim(result), true);
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
		codedType.setValue(new BigDecimal("1.234"));
		
		EncapsulatedDataR2 originalText = new EncapsulatedDataR2();
		originalText.setTextContent("some original text");
		codedType.setOriginalText(originalText);
		
		PQR pqr = new PQRImpl(codedType);
		
		String result = new PqrR2PropertyFormatter().format(getContext("name", "PQR"), pqr);
		
		assertFalse(this.result.isValid());
		assertEquals(4, this.result.getHl7Errors().size());
		assertXml("result", "<name code=\"cm\" codeSystem=\"1.2.3.4\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\" value=\"1.234\"><originalText>some original text</originalText></name>", StringUtils.trim(result), true);
	}

}
