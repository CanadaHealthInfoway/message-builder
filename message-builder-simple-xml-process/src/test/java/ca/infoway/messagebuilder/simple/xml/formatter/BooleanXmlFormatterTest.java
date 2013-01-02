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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class BooleanXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToBoolean() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">true</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		BL bool = formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
		assertNotNull("boolean", bool);
		assertEquals(Boolean.TRUE, bool.getValue());
	}

	// duplicated in anticipation of behaviour changing for different BL representations
	@Test
	public void shouldTransformXmlToBooleanIfMixedCase() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">FaLsE</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		BL bool = formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
		assertNotNull("boolean", bool);
		assertEquals(Boolean.FALSE, bool.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNotABoolean() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">123.4</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidBooleanIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.BL, null);
		BL bool = formatter.format(formatContext, document.getDocumentElement());
		assertNull("boolean", bool);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid value provided for boolean", formatContext.getErrors().get(0).getMessage());
	}
}
