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

import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class RealXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToRealIfREAL() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123.45</value>");
		RealXmlFormatter formatter = new RealXmlFormatter(new FormatterConfiguration());
		
		REAL real = formatter.format(new FormatterContextImpl(StandardDataType.REAL, null), document.getDocumentElement());
		assertNotNull("real", real);
		assertEquals("-123.45", real.getValue().toPlainString());
	}

	@Test
	public void shouldTransformXmlToRealIfREAL_COORD() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123.45</value>");
		RealXmlFormatter formatter = new RealXmlFormatter(new FormatterConfiguration());
		
		REAL real = formatter.format(new FormatterContextImpl(StandardDataType.REAL_COORD, null), document.getDocumentElement());
		assertNotNull("real", real);
		assertEquals("-123.45", real.getValue().toPlainString());
	}

	@Test
	public void shouldTransformXmlToRealIfREAL_CONF() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123.45</value>");
		RealXmlFormatter formatter = new RealXmlFormatter(new FormatterConfiguration());
		
		REAL real = formatter.format(new FormatterContextImpl(StandardDataType.REAL_COORD, null), document.getDocumentElement());
		assertNotNull("real", real);
		assertEquals("-123.45", real.getValue().toPlainString());
	}

	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNumberIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		RealXmlFormatter formatter = new RealXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.REAL, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNotAnNumber() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">123.4zxfred</value>");
		RealXmlFormatter formatter = new RealXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.REAL, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidRealIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">aBadValue</value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		RealXmlFormatter formatter = new RealXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.REAL, null);
		REAL real = formatter.format(formatContext, document.getDocumentElement());
		assertNull("real", real);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Value not a number", formatContext.getErrors().get(0).getMessage());
	}
}
