/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.generator.Namespaces.MIF2_NAMESPACE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class EntryPointAssemblerTest {
	
	@Test
	public void shouldFindInteractionName() throws Exception {
		Document document = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"PRPA_IN101205CA - Person Revise Event Accept.mif"));
		assertEquals("interaction name", "PRPA_IN101205CA", 
				EntryPointAssembler.getEntryPoint((Element) new XPathHelper().getSingleNode(
				document, "/mif2:interaction/mif2:packageLocation", MIF2_NAMESPACE)));
	}

}
