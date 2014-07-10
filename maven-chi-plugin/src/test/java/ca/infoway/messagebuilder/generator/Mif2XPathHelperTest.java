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

package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.util.Namespaces;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class Mif2XPathHelperTest {
	
	private BaseMifXPathHelper fixture;
	
	@Before
	public void setUp() throws Exception {
		fixture = new Mif2XPathHelper();
	}
	
	@Test
	public void shouldDetectDomainTypeSpecifiedUsingValueSet() throws Exception {
		Document mif = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"MCCI_MT002100CA - Request Transport Wrapper.mif"));
		
		Element element = (Element) new XPathHelper().getSingleNode(mif, "//mif2:attribute[@name='responseModeCode']", Namespaces.MIF2_NAMESPACE);
		assertNotNull("mode code", element);
		
		String domainType = Mif2XPathHelper.getDomainType(element);
		
		assertNotNull("element", domainType);
		assertEquals("ResponseMode", domainType);
	}

	@Test
	public void shouldDetectTemplateRelationship() throws Exception {
		Document mif = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"MCCI_MT002100CA - Request Transport Wrapper.mif"));
		
		Element element = (Element) new XPathHelper().getSingleNode(mif, "//mif2:traversableConnection[@name='controlActEvent']", Namespaces.MIF2_NAMESPACE);
		assertNotNull("target connection", element);
		
		Element templateParameter = fixture.getTemplateParameter(element);
		
		assertNotNull("element", templateParameter);
	}

	@Test
	public void shouldFindGraphicRepresentationClasses() throws Exception {
		Document mif = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"MCCI_MT002100CA - Request Transport Wrapper.mif"));
		
		List<Element> classes = Mif2XPathHelper.getGraphicRepresentationClasses(mif);
		assertEquals(13, classes.size());
	}
	
	@Test
	public void shouldReadInteractionTitle() throws Exception {
		Document mif = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"COMT_IN200000CA - Clinical summary-profile query response.mif"));
		
		assertEquals("Cross-domain Query Query Response List", new Mif2XPathHelper().getTitle(mif.getDocumentElement()));
	}
	
}
