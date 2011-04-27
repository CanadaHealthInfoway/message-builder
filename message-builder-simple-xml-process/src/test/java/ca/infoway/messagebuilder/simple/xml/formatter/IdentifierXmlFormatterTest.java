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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class IdentifierXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToIdentifier() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<id" + ns  + " root=\"1.2.3.4.5\" extension=\"123\" />");
		IdentifierXmlFormatter formatter = new IdentifierXmlFormatter(new FormatterConfiguration());
		
		II ii = formatter.format(new FormatterContextImpl(), document.getDocumentElement());
		assertNotNull("ii", ii);
		Assert.assertEquals("1.2.3.4.5", ii.getValue().getRoot());
		Assert.assertEquals("123", ii.getValue().getExtension());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfRootIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<id" + ns  + " extension=\"123\" />");
		IdentifierXmlFormatter formatter = new IdentifierXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(), document.getDocumentElement());
	}
	@Test
	public void shouldAllowInvalidIdentifierIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<id" + ns  + " extension=\"123\" />");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		IdentifierXmlFormatter formatter = new IdentifierXmlFormatter(configuration);
		
		II ii = formatter.format(new FormatterContextImpl(), document.getDocumentElement());
		assertNull("ii", ii);
	}
}
