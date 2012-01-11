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

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

@RunWith(JMock.class)
public class FieldDefinitionGeneratorTest {

	private Mockery jmock = new Mockery();
	private FieldDefinition fieldDefinition;
	private FieldDefinitionGenerator propertyDefinition;
	private StringWriter writer = new StringWriter();
	private FieldDefinitionGenerator javaPropertyDefinition;
	
	@Before
	public void setUp() throws Exception {
		this.fieldDefinition = this.jmock.mock(FieldDefinition.class);
		this.propertyDefinition = new FieldDefinitionGenerator(this.fieldDefinition);
		this.javaPropertyDefinition = new FieldDefinitionGenerator(this.fieldDefinition);
		
	}

	private void expectTypicalAttribute(final ProgrammingLanguage language) {
		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).getXmlPathName(); will(returnValue(new String[] {"name/value", "myName/value"}));
			allowing(fieldDefinition).getFieldName(); will(returnValue("myName"));
			allowing(fieldDefinition).getFieldImplementationType(); will(returnValue("STImpl"));
			allowing(fieldDefinition).getFieldType(); will(returnValue("ST"));
			allowing(fieldDefinition).getGetterBodyStyle(); will(returnValue(GetterBodyStyle.ATTRIBUTE));
			allowing(fieldDefinition).getSetterBodyStyle(); will(returnValue(SetterBodyStyle.ATTRIBUTE));
			allowing(fieldDefinition).getCapitalizedPropertyName(); will(returnValue("MyName"));
			allowing(fieldDefinition).getInitializationArguments(); will(returnValue(""));
			allowing(fieldDefinition).getPropertyType(); will(returnValue("String"));
			allowing(fieldDefinition).getFieldElementImplementationType(); will(returnValue("STImpl.class"));
			allowing(fieldDefinition).isInitializedAtConstructionTime(); will(returnValue(true));
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue("String"));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(null));
			allowing(fieldDefinition).getProgrammingLanguage(); will(returnValue(language));
			allowing(fieldDefinition).getBaseRelationship(); will(returnValue(null));
		}});
	}
	
	private void expectTypicalAssociation(final ProgrammingLanguage language) {
		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).getXmlPathName(); will(returnValue(new String[] {"patient"}));
			allowing(fieldDefinition).getFieldName(); will(returnValue("patient"));
			allowing(fieldDefinition).getFieldImplementationType(); will(returnValue("Author_1Bean"));
			allowing(fieldDefinition).getFieldType(); will(returnValue("Author_1Bean"));
			allowing(fieldDefinition).getGetterBodyStyle(); will(returnValue(GetterBodyStyle.DEFAULT));
			allowing(fieldDefinition).getSetterBodyStyle(); will(returnValue(SetterBodyStyle.DEFAULT));
			allowing(fieldDefinition).getCapitalizedPropertyName(); will(returnValue("Patient"));
			allowing(fieldDefinition).getInitializationArguments(); will(returnValue(""));
			allowing(fieldDefinition).getPropertyType(); will(returnValue("Author_1Bean"));
			allowing(fieldDefinition).getFieldElementImplementationType(); will(returnValue(""));
			allowing(fieldDefinition).isInitializedAtConstructionTime(); will(returnValue(false));
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue(""));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(null));
			allowing(fieldDefinition).getProgrammingLanguage(); will(returnValue(language));
			allowing(fieldDefinition).getBaseRelationship(); will(returnValue(null));
		}});
	}
	
	@Test
	public void shouldCreateConstructorDefinition() throws Exception {
		expectTypicalAttribute(ProgrammingLanguage.C_SHARP);
		this.propertyDefinition.createConstructorInitialization(1, writer);
		String output = this.writer.toString();
		assertTrue("results", output.contains("this.myName = new STImpl();"));
	}
	
	@Test
	public void shouldCreateFieldDefinition() throws Exception {
		expectTypicalAttribute(ProgrammingLanguage.C_SHARP);
		this.propertyDefinition.createFieldDeclaration(1, writer);
		String output = this.writer.toString();
		assertTrue("results", output.contains("private ST myName;"));
	}
	
	@Test
	public void shouldCreateAssociationDefinitionForCsharp() throws Exception {
		expectTypicalAssociation(ProgrammingLanguage.C_SHARP);
		this.propertyDefinition.createFieldDeclaration(1, writer);
		String output = this.writer.toString();
		assertTrue("results", output.contains("private Author_1Bean patient;"));
	}
	
	@Test
	public void shouldCreateFieldDefinitionForJava() throws Exception {
		expectTypicalAttribute(ProgrammingLanguage.JAVA);
		this.javaPropertyDefinition.createFieldDeclaration(1, writer);
		String output = this.writer.toString();
		assertTrue("results", output.contains("private ST myName = new STImpl();"));
	}
	
	@Test
	public void shouldCreateAssociationFieldDefinitionForJava() throws Exception {
		expectTypicalAssociation(ProgrammingLanguage.JAVA);
		this.javaPropertyDefinition.createFieldDeclaration(1, writer);
		String output = this.writer.toString();
		assertTrue("results", output.contains("private Author_1Bean patient;"));
	}
}
