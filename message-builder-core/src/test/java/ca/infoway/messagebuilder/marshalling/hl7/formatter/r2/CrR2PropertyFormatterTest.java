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
 * Last modified: $LastChangedDate: 2012-08-20 19:01:34 -0400 (Mon, 20 Aug 2012) $
 * Revision:      $LastChangedRevision: 6032 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.CRImpl;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public class CrR2PropertyFormatterTest extends FormatterTestCase {

	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void testNullCase() throws Exception {
		String result = new CrR2PropertyFormatter().format(getContext("name", "CR"), new CRImpl(NullFlavor.MASKED));
		assertTrue(this.result.isValid());
		assertXml("result", "<name nullFlavor=\"MSK\"/>", result);
	}
	
	@Test
	public void testEmpty() throws Exception {
		String result = new CrR2PropertyFormatter().format(getContext("codeRole", "CR"), new CRImpl());
		assertTrue(this.result.isValid());
		assertXml("result", "<codeRole nullFlavor=\"NI\"/>", result);
	}
	
	
	@Test
	public void testValid() throws Exception {
		CodedTypeR2<Code> name = new CodedTypeR2<Code>();
		name.setCode(AdministrativeGender.MALE);
		CodedTypeR2<Code> value = new CodedTypeR2<Code>();
		value.setCode(ActStatus.COMPLETED);
		
		CodeRole codeRole = new CodeRole(name, value, true);
		
		String result = new CrR2PropertyFormatter().format(getContext("codeRole", "CR"), new CRImpl(codeRole));
		assertTrue(this.result.isValid());
		assertXml("result", "<codeRole inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" displayName=\"Male\"/><value code=\"completed\" codeSystem=\"2.16.840.1.113883.5.14\" displayName=\"Completed\"/></codeRole>", result);
	}
	
	@Test
	public void testInvalidMissingValue() throws Exception {
		CodedTypeR2<Code> name = new CodedTypeR2<Code>();
		name.setCode(AdministrativeGender.MALE);
		
		CodeRole codeRole = new CodeRole(name, null, true);
		
		String result = new CrR2PropertyFormatter().format(getContext("codeRole", "CR"), new CRImpl(codeRole));
		assertFalse(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertXml("result", "<codeRole inverted=\"true\"><name code=\"M\" codeSystem=\"2.16.840.1.113883.5.1\" displayName=\"Male\"/></codeRole>", result);
	}
	
}
