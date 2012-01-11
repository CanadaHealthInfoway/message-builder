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

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePartResolver;

@RunWith(JMock.class)
public class Mif2InteractionDefinitionTest {
	
	private Mockery jmock = new Mockery();
	private MessagePartResolver resolver = this.jmock.mock(MessagePartResolver.class);
	
	@Test
	public void shouldExtractInteraction() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(resolver).getPackageLocationRootType("MCCI_MT002300CA"); will(returnValue("MCCI_MT002300CA.Message"));
			one(resolver).getPackageLocationRootType("MFMI_MT700726CA"); will(returnValue("MFMI_MT700726CA.ControlActEvent"));
			one(resolver).getPackageLocationRootType("PRPA_MT101102CA"); will(returnValue("PRPA_MT101102CA.IdentifiedEntity"));
		}});
		
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(getClass(), "PRPA_IN101205CA - Person Revise Event Accept.mif"));
		Interaction interaction = new Mif2InteractionDefinition(document, null, null).extract(this.resolver);
		assertEquals("name", "PRPA_IN101205CA", interaction.getName());
		assertEquals("businessName", "Person Revise Event Accept", interaction.getBusinessName());
		assertEquals("super type", "MCCI_MT002300CA.Message", interaction.getSuperTypeName());
		assertEquals("arguments", 1, interaction.getArguments().size());
		assertEquals("argument name", "MFMI_MT700726CA.ControlActEvent", interaction.getArguments().get(0).getName());
	}

}
