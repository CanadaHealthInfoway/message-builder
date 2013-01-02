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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class TypeTest {

	@Test
	public void shouldGetTemplateVariables() throws Exception {
		
		Type type = createTemplateType();
		
		assertTrue("template type", type.isTemplateType());
		assertTrue("template variables: " + type.getTemplateVariables(), type.getTemplateVariables().contains("T"));
	}

	@Test
	public void shouldEnsureThatTemplateVariablesAreInAlphabeticalOrder() throws Exception {
		
		Type type = createTemplateTypeWithTwoTemplateVariables();
		
		assertTrue("template type", type.isTemplateType());
		String previous = null;
		for (String variable : type.getTemplateVariables()) {
			if (previous != null) {
				assertTrue("in order: " + variable, previous.compareTo(variable) <= 0);
			}
			previous = variable;
		}
		assertTrue("template variables PL: " + type.getTemplateVariables(), type.getTemplateVariables().contains("PL"));
		assertTrue("template variables RR: " + type.getTemplateVariables(), type.getTemplateVariables().contains("RR"));
	}
	
	private Type createTemplateTypeWithTwoTemplateVariables() {
		return TypeAndRelationshipBuilder.createType(null, "SomeType", 
				TypeAndRelationshipBuilder.createTemplateAssociation("registeredRole", "RR"),
				TypeAndRelationshipBuilder.createTemplateAssociation("parameterList", "PL"));
	}

	private Type createTemplateType() {
		Type type = new Type(new TypeName("ABCD_MT123456CA.SomeType"));
		Relationship relationship = new Relationship();
		relationship.setName("myName");
		relationship.setTemplateParameterName("MyTemplateParameter");
		type.getRelationships().add(Association.createTemplateAssociation(relationship, new TemplateVariable("T")));
		return type;
	}
	
	@Test
	public void shouldGetTemplateVariablesOfTemplateTypes() throws Exception {
		
		Type type = new Type(new TypeName("ABCD_MT123456CA.ControlActThing"));
		Relationship relationship = new Relationship();
		relationship.setName("controlAct");
		relationship.setType("ABCD_MT123456CA.SomeType");
		type.getRelationships().add(Association.createStandardAssociation(relationship, createTemplateType()));
		
		assertTrue("template type", type.isTemplateType());
		assertTrue("template variables" + type.getTemplateVariables(), type.getTemplateVariables().contains("T"));
	}
	
}
