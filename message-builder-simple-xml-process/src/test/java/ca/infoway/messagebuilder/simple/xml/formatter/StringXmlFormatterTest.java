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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.ST;
import static ca.infoway.messagebuilder.datatype.StandardDataType.ST_LANG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class StringXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToString() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		StringXmlFormatter formatter = new StringXmlFormatter(new FormatterConfiguration());
		
		ST st = formatter.format(new FormatterContextImpl(StandardDataType.ST, null), document.getDocumentElement());
		assertNotNull("st", st);
		assertEquals("a string", st.getValue());
	}
	
	@Test
	public void shouldTransformXmlToStringWithLanguage() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + " language=\"en-CA\">a string</value>");
		StringXmlFormatter formatter = new StringXmlFormatter(new FormatterConfiguration());
		
		ST st = formatter.format(new FormatterContextImpl(ST_LANG, null), document.getDocumentElement());
		assertNotNull("st", st);
		assertEquals("a string", st.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionForStringWithUnsupportedLanguage() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + " language=\"en\">a string</value>");
		StringXmlFormatter formatter = new StringXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(ST_LANG, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfLanguageIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		StringXmlFormatter formatter = new StringXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(ST_LANG, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfLanguageIsIncluded() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + " language=\"en-CA\">a string</value>");
		StringXmlFormatter formatter = new StringXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(ST, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidStringIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		StringXmlFormatter formatter = new StringXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.ST_LANG, null);
		ST st = formatter.format(formatContext, document.getDocumentElement());
		assertNull("st", st);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Language attribute is mandatory", formatContext.getErrors().get(0).getMessage());
	}
}
