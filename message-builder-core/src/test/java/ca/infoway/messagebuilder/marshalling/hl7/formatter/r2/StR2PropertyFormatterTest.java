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
 * Last modified: $LastChangedDate: 2014-02-26 12:52:49 -0500 (Wed, 26 Feb 2014) $
 * Revision:      $LastChangedRevision: 8412 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;

public class StR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		FormatContext context = getContext("name");
		String result = new StR2PropertyFormatter().format(context, null);
		assertTrue("named null format", StringUtils.isBlank(result));
		assertNoErrors(context);
	}

	private void assertNoErrors(FormatContext context) {
		assertTrue("no errors", context.getModelToXmlResult().isValid());
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		String result = formatter.format(context, new STImpl("something"));
		assertEquals("something in text node", addLineSeparator("<name mediaType=\"text/plain\" representation=\"TXT\">something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatCdataValueNull() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		STImpl dataType = new STImpl((String) null);
		dataType.setCdata(true);
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name nullFlavor=\"NI\"/>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatCdataValueEmpty() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		STImpl dataType = new STImpl("");
		dataType.setCdata(true);
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name mediaType=\"text/plain\" representation=\"TXT\"><![CDATA[]]></name>"), result);
		assertEquals(1, this.result.getHl7Errors().size());
	}

	@Test
	public void testFormatCdataValueNonNull() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		STImpl dataType = new STImpl("something");
		dataType.setCdata(true);
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name mediaType=\"text/plain\" representation=\"TXT\"><![CDATA[something]]></name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatCdataValueNonNullWithSpecialCharacters() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		STImpl dataType = new STImpl("<cats think they're > humans & dogs 99% of the time/>");
		dataType.setCdata(true);
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name mediaType=\"text/plain\" representation=\"TXT\"><![CDATA[<cats think they're > humans & dogs 99% of the time/>]]></name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithLanguageAllowed() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		String result = formatter.format(context, new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"fr-CA\" mediaType=\"text/plain\" representation=\"TXT\">something</name>"), removeErrorComments(result));
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithLanguageFr() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		String result = formatter.format(context, new STImpl("something", "fr-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"fr-CA\" mediaType=\"text/plain\" representation=\"TXT\">something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithLanguageEn() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		String result = formatter.format(context, new STImpl("something", "en-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"en-CA\" mediaType=\"text/plain\" representation=\"TXT\">something</name>"), result);
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithNonEnglishNonFrenchLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		String result = formatter.format(context, new STImpl("something", "it-CA"));
		assertEquals("something in text node", addLineSeparator("<name language=\"it-CA\" mediaType=\"text/plain\" representation=\"TXT\">something</name>"), removeErrorComments(result));
		assertNoErrors(context);
	}

	@Test
	public void testFormatValueNonNullWithBlankLanguage() throws Exception {
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContextImpl context = new FormatContextImpl(new ModelToXmlResult(), null, "name", "ST", null, null);
		STImpl dataType = new STImpl("something");
		dataType.setLanguage("");
		String result = formatter.format(context, dataType);
		assertEquals("something in text node", addLineSeparator("<name mediaType=\"text/plain\" representation=\"TXT\">something</name>"), removeErrorComments(result));
		assertEquals("error from blank language", 1, context.getModelToXmlResult().getHl7Errors().size());
	}

	@Test
	public void testFormatValueReservedXmlChars() throws Exception{
		AbstractPropertyFormatter formatter = new StR2PropertyFormatter();
		
		FormatContext context = getContext("name");
		String result = formatter.format(
				context, 
				new STImpl("<cats think they're > humans & dogs 99% of the time/>"));
		assertEquals("something in text node", "<name mediaType=\"text/plain\" representation=\"TXT\">&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>".trim(), result.trim());
		assertNoErrors(context);
	}

}
