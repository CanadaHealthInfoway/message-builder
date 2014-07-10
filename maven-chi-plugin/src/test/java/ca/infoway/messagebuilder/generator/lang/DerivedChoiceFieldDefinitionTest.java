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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class DerivedChoiceFieldDefinitionTest {
	
	private Mockery jmock = new Mockery();
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.resolver = this.jmock.mock(BaseRelationshipNameResolver.class);
	}
	
	@Test
	public void shouldProvideData() throws Exception {
		Relationship choiceRelationship = new Relationship("mainChoice", "ABCD_MT123456CA.Component6", Cardinality.create("1"));
		final Type associationType = new Type(new TypeName(choiceRelationship.getType()));
		final Association association = Association.createStandardAssociation(choiceRelationship, associationType);
		final Type choiceType = new Type(new TypeName("ABCD_MT123456CA.Component2"));
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfType(associationType); will(returnValue("MedicalOrder"));
			allowing(manager).getRepresentationOfType(choiceType); will(returnValue("MedicalOrderSpecialization"));
			allowing(resolver).getName(association); will(returnValue("relatedTo"));
		}});
		DerivedChoiceFieldDefinition field = new DerivedChoiceFieldDefinition(association, 
				new Choice("subChoice", choiceType), JAVA);
		field.initializeContext(this.manager, this.resolver);
		
		assertFalse("not writable", field.isWritable());
		assertEquals("field name", "relatedTo", field.getFieldName());
		assertEquals("property name", "RelatedToAsSubChoice", field.getCapitalizedPropertyName());
		assertEquals("type", "MedicalOrderSpecialization", field.getFieldType());
	}
	
}
