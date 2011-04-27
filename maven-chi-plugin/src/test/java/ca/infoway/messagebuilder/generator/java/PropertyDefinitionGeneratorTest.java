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
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class PropertyDefinitionGeneratorTest {

	private Mockery jmock = new Mockery();
	private FieldDefinition fieldDefinition;
	private PropertyDefinitionGenerator javaPropertyDefinition;
	private StringWriter writer;
	
	@Before
	public void setUp() throws Exception {
		this.fieldDefinition = this.jmock.mock(FieldDefinition.class);
		this.javaPropertyDefinition = new PropertyDefinitionGenerator(this.fieldDefinition);
		this.writer = new StringWriter();
	}
	
	@Test
	public void shouldCreateWritableJavaProperty() throws Exception {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		final BaseRelationship association = Association.createStandardAssociation(relationship, new Type(new TypeName(relationship.getType())));

		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).isWritable(); will(returnValue(true));
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
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue("String"));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(null));
			allowing(fieldDefinition).getProgrammingLanguage(); will(returnValue(ProgrammingLanguage.JAVA));
			allowing(fieldDefinition).getBaseRelationship(); will(returnValue(association));
		}});
		
		this.javaPropertyDefinition.createPropertyDefinition(1, writer, false);
		
		String output = this.writer.toString();
		assertTrue("getter", output.contains("public String getMyName() {"));
		assertTrue("getter body", output.contains("return this.myName.getValue();"));
	}

	@Test
	public void shouldCreateReadOnlyJavaDerivedChoiceProperty() throws Exception {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		final BaseRelationship association = Association.createStandardAssociation(relationship, new Type(new TypeName(relationship.getType())));

		this.jmock.checking(new Expectations() {{
			allowing(fieldDefinition).isWritable(); will(returnValue(false));
			allowing(fieldDefinition).isDerivedChoice(); will(returnValue(true));
			allowing(fieldDefinition).getXmlPathName(); will(returnValue(null));
			allowing(fieldDefinition).getFieldName(); will(returnValue("choiceField"));
			allowing(fieldDefinition).getFieldImplementationType(); will(returnValue("UnsureWhatThisIsFor"));
			allowing(fieldDefinition).getFieldType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getGetterBodyStyle(); will(returnValue(GetterBodyStyle.DERIVED_CHOICE));
			allowing(fieldDefinition).getSetterBodyStyle(); will(returnValue(null));
			allowing(fieldDefinition).getCapitalizedPropertyName(); will(returnValue("ChoiceFieldAsSubChoiceField"));
			allowing(fieldDefinition).getInitializationArguments(); will(returnValue(""));
			allowing(fieldDefinition).getPropertyType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getFieldElementImplementationType(); will(returnValue("SubChoiceType"));
			allowing(fieldDefinition).getPropertyElementImplementationType(); will(returnValue(""));
			allowing(fieldDefinition).getCollectionOfCodedPropertyElementType(); will(returnValue(""));
			allowing(fieldDefinition).getFieldElementType(); will(returnValue(""));
			allowing(fieldDefinition).getDerivedChoiceHasBodyStyle(); will(returnValue(GetterBodyStyle.DERIVED_CHOICE_HAS));
			allowing(fieldDefinition).getProgrammingLanguage(); will(returnValue(ProgrammingLanguage.JAVA));
			allowing(fieldDefinition).getBaseRelationship(); will(returnValue(association));
		}});
		
		this.javaPropertyDefinition.createPropertyDefinition(1, writer, false);
		
		String output = this.writer.toString();
		assertTrue("getter", output.contains("public SubChoiceType getChoiceFieldAsSubChoiceField() {"));
		assertTrue("getter body", output.contains("return this.choiceField instanceof SubChoiceType ? (SubChoiceType) this.choiceField : null;"));
		assertTrue("has", output.contains("public boolean hasChoiceFieldAsSubChoiceField() {"));
		assertTrue("has body", output.contains("return (this.choiceField instanceof SubChoiceType);"));
	}
	
}
