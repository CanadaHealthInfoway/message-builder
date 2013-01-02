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

import static ca.infoway.messagebuilder.datatype.StandardDataType.TN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class TrivialNameXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToTrivialName() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a name</value>");
		TrivialNameXmlFormatter formatter = new TrivialNameXmlFormatter(new FormatterConfiguration());
		
		TN tn = formatter.format(new FormatterContextImpl(StandardDataType.TN, null), document.getDocumentElement());
		assertNotNull("tn", tn);
		assertEquals("a name", tn.getValue().getName());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNameIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		TrivialNameXmlFormatter formatter = new TrivialNameXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(TN, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowMissingNameIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		TrivialNameXmlFormatter formatter = new TrivialNameXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.TN, null);
		TN st = formatter.format(formatContext, document.getDocumentElement());
		assertNull("tn", st);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("No trivial name provided", formatContext.getErrors().get(0).getMessage());
	}
}
