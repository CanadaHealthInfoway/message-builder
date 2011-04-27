/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.STImpl;

public class StPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new StPropertyFormatter().format(getContext("name"), null);
		assertTrue("named null format", StringUtils.isBlank(result));
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(getContext("name"), new STImpl("something"));
		assertEquals("something in text node", addLineSeparator("<name>something</name>"), result);
	}

	@Test
	public void testFormatValueNonNullWithLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(new FormatContextImpl("name", "ST.LANG", null), new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"fr-CA\">something</name>"), result);
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		String result = formatter.format(
				getContext("name"), 
				new STImpl("<cats think they're > humans & dogs 99% of the time/>"));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
	}
	
	private String addLineSeparator(String value) {
		return value + LINE_SEPARATOR;
	}
}
