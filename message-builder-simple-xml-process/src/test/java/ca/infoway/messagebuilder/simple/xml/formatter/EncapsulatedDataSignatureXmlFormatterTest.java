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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class EncapsulatedDataSignatureXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToSignature() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">this is a signature</value>");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		ED<String> st = formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
		assertNotNull("st", st);
		assertEquals("this is a signature", st.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfSignatureIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + " />");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfSignatureIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidSignatureIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "/>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null);
		ED<String> st = formatter.format(formatContext, document.getDocumentElement());
		assertNull("st", st);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("No signature value provided", formatContext.getErrors().get(0).getMessage());
	}
}
