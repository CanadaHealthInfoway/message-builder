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

import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class StPropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		FormatContext context = getContext("name");
		String result = new StPropertyFormatter().format(context, null);
		assertTrue("named null format", StringUtils.isBlank(result));
		assertNoErrors(context);
	}

	private void assertNoErrors(FormatContext context) {
		assertTrue("no errors", context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContext context = getContext("name");
		String result = formatter.format(context, new STImpl("something"));
		assertEquals("something in text node", addLineSeparator("<name>something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithLanguageNotAllowed() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		String result = formatter.format(context, new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name>something</name>"), removeErrorComments(result));
		assertEquals("error from language not allowed", 1, context.getModelToXmlResult().getHl7Errors().size());
	}

	@Test
	public void testFormatValueNonNullWithLanguageFr() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContext context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST.LANG", null, null);
		String result = formatter.format(context, new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"fr-CA\">something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithLanguageEn() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST.LANG", null, null);
		String result = formatter.format(context, new STImpl("something", "en-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"en-CA\">something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithIncorrectLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST.LANG", null, null);
		String result = formatter.format(context, new STImpl("something", "it-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"en-CA\">something</name>"), removeErrorComments(result));
		assertEquals("error from incorrect language", 1, context.getModelToXmlResult().getHl7Errors().size());
	}

	@Test
	public void testFormatValueNonNullWithBlankLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST.LANG", null, null);
		String result = formatter.format(context, new STImpl("something", ""));
		assertEquals("something in text node", addLineSeparator("<name language=\"en-CA\">something</name>"), removeErrorComments(result));
		assertEquals("error from blank language", 1, context.getModelToXmlResult().getHl7Errors().size());
	}

	@Test
	public void testFormatValueNonNullWithNullLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST.LANG", null, null);
		String result = formatter.format(context, new STImpl("something", null));
		assertEquals("something in text node", addLineSeparator("<name language=\"en-CA\">something</name>"), removeErrorComments(result));
		assertEquals("error from null language", 1, context.getModelToXmlResult().getHl7Errors().size());
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AbstractPropertyFormatter formatter = new StPropertyFormatter();
		
		FormatContext context = getContext("name");
		String result = formatter.format(
				context, 
				new STImpl("<cats think they're > humans & dogs 99% of the time/>"));
		assertEquals("something in text node", "<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
		assertNoErrors(context);
	}

}
