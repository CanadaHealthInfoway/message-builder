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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class SimpleCodedTypeXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToCS() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" />");
		SimpleCodedTypeXmlFormatter formatter = new SimpleCodedTypeXmlFormatter(new FormatterConfiguration());
		
		CS cs = formatter.format(new FormatterContextImpl(StandardDataType.CS, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cs", cs);
		Assert.assertEquals("M", cs.getValue().getCodeValue());
		Assert.assertTrue(cs.getValue() instanceof AdministrativeGender);
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " />");
		SimpleCodedTypeXmlFormatter formatter = new SimpleCodedTypeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.CS, AdministrativeGender.class), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueNotAValidCode() throws Exception {
		
		CodeResolverRegistry.register(new TrivialCodeResolver() {
			@Override
			public <T extends Code> T lookup(Class<? extends T> interfaceType, String codeValue, String codeSystemOid) {
				return null;
			}
		});
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"ABCDEFGHinvalid\"/>");
		SimpleCodedTypeXmlFormatter formatter = new SimpleCodedTypeXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.CS, AdministrativeGender.class), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidCodeIfConfigurationIsPermissive() throws Exception {
		
		CodeResolverRegistry.register(new TrivialCodeResolver() {
			@Override
			public <T extends Code> T lookup(Class<? extends T> interfaceType, String codeValue, String codeSystemOid) {
				return null;
			}
		});
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"ABCDEFGHinvalid\"/>");
		SimpleCodedTypeXmlFormatter formatter = new SimpleCodedTypeXmlFormatter(new FormatterConfiguration(true));
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.CS, AdministrativeGender.class);
		CS cs = formatter.format(formatContext, document.getDocumentElement());

		assertNull("cs", cs);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Could not find code [ABCDEFGHinvalid]", formatContext.getErrors().get(0).getMessage());
	}
	
}
