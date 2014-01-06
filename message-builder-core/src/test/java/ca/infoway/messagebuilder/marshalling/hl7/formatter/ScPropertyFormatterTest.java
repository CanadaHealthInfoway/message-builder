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
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.impl.SCImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.domainvalue.basic.UnitsOfMeasureCaseSensitive;

public class ScPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ScPropertyFormatter().format(getContext("name"), null);
		
        assertTrue(this.result.isValid());
		assertTrue("named null format", StringUtils.isBlank(result));
	}
	
	@Test
    public void testFormatValueNullCode() throws Exception {
        ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("something", null); 
        
        String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
        
        assertTrue(this.result.isValid());
        assertEquals("something in text node", addLineSeparator("<name>something</name>"), result);
    }

	@Test
    public void testFormatValueCode() throws Exception {
        ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("something", UnitsOfMeasureCaseSensitive.CENTIMETRE, "aDisplayName", "aCodeSystemName", "aCodeSystemVersion"); 
        
        String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
        
        assertTrue(this.result.isValid());
        assertEquals("something in text node", addLineSeparator("<name code=\"cm\" codeSystem=\"2.16.840.1.113883.5.141\" codeSystemName=\"aCodeSystemName\" codeSystemVersion=\"aCodeSystemVersion\" displayName=\"aDisplayName\">something</name>"), result);
    }

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		ScPropertyFormatter formatter = new ScPropertyFormatter();
        CodedString<Code> codedString = new CodedString<Code>("<cats think they're > humans & dogs 99% of the time/>", null); 
		
		String result = formatter.format(getContext("name"), new SCImpl<Code>(codedString));
		
        assertTrue(this.result.isValid());
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
}
