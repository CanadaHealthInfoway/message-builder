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

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;

public class PnPropertyFormatterTest extends FormatterTestCase {
	
	@Test
	public void testFormatValueNull() throws Exception {
		String result = new PnPropertyFormatter().format(getContext("name"), new PNImpl());
        assertEquals("named null format", "<name nullFlavor=\"NI\"/>", result.trim());
	}
	
	@Test
    public void testFormatValueNonNull() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("Steve Shaw"));
        
        String result = formatter.format(getContext("name"), new PNImpl(personName));
        assertEquals("something in text node", "<name>Steve Shaw</name>", result.trim());
    }

	@Test
    public void testFormatValueNonNullMultipleNameParts() throws Exception {
        PnPropertyFormatter formatter = new PnPropertyFormatter();
        
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("prefix", PersonNamePartType.PREFIX, "IN"));
        personName.addNamePart(new EntityNamePart("given", PersonNamePartType.GIVEN));
        personName.addNamePart(new EntityNamePart("family", PersonNamePartType.FAMILY));
        personName.addNamePart(new EntityNamePart("suffix", PersonNamePartType.SUFFIX, "IN"));
        
        String result = formatter.format(getContext("name"), new PNImpl(personName));
        assertEquals("well formed name", "<name><prefix qualifier=\"IN\">prefix</prefix><given>given</given><family>family</family><suffix qualifier=\"IN\">suffix</suffix></name>", result.trim());
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
        PnPropertyFormatter formatter = new PnPropertyFormatter();
		
        PersonName personName = new PersonName();
        personName.addNamePart(new EntityNamePart("<cats think they're > humans & dogs 99% of the time/>"));

        String result = formatter.format(getContext("name"), new PNImpl(personName));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
}
