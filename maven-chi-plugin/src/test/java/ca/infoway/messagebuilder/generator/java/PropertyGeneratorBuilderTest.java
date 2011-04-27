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

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class PropertyGeneratorBuilderTest {
	
	private Mockery jmock = new Mockery();
	private StringWriter writer;
	private PropertyGeneratorBuilder javaBuilder;
	private PropertyGeneratorBuilder csharpBuilder;
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	private Type type;
	
	@Before
	public void setUp() {
		this.writer = new StringWriter();
		this.javaBuilder = new PropertyGeneratorBuilder(ProgrammingLanguage.JAVA);
		this.csharpBuilder = new PropertyGeneratorBuilder(ProgrammingLanguage.C_SHARP);
		this.manager = this.jmock.mock(ClassNameManager.class);
		this.resolver = this.jmock.mock(BaseRelationshipNameResolver.class);
		this.type = TypeAndRelationshipBuilder.createType(null, "ABCD_MT123456CA.Type");

		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfType(type); will(returnValue("Type"));
			allowing(resolver).getName(with(any(Association.class))); will(returnValue("name"));
		}});
	}
	
	@Test
	public void shouldGeneratePropertyDeclaration() throws Exception {
		final Association association = createAssociation();
		this.javaBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);

		String output = this.writer.toString();
		assertTrue("field declaration", output.contains("private Type name;"));
	}

	@Test
	public void shouldGenerateCsharpPropertyDeclaration() throws Exception {
		final Association association = createAssociation();
		this.csharpBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.C_SHARP));
		PropertyGenerator generator = this.csharpBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		
		String output = this.writer.toString();
		System.out.println(output);
		assertTrue("field declaration", output.contains("private Type name;"));
	}
	
	@Test
	public void shouldGenerateCsharpGetterAndSetter() throws Exception {
		PropertyGenerator generator = this.csharpBuilder
			.setType(new PropertyTypeProviders.Identity("Type")).setName(new PropertyNameProviders.Identity("name"))
			.addGetter().addSetter()
			.build(null, null);
		
		generator.createGettersAndSetters(0, this.writer);
		
		String output = this.writer.toString();
		System.out.println(output);
	}
	
	@Test
	public void shouldGenerateCsharpConstructorInititialization() throws Exception {
		final Association association = createAssociation();
		this.csharpBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.C_SHARP));
		PropertyGenerator generator = this.csharpBuilder
				.setType(new PropertyTypeProviders.Identity("Type")).setName(new PropertyNameProviders.Identity("name")).setInitializer()
				.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		
		String output = this.writer.toString();
		System.out.println(output);
		assertTrue("field declaration", output.contains("private Type name;"));
		
		this.writer = new StringWriter();
		generator.createConstructorInitialization(0, this.writer);

		output = this.writer.toString();
		System.out.println(output);
		assertFalse("constructor initialization", output.contains("this.name = new Type();"));
	}

	private Attribute createAttribute() throws Exception {
		return TypeAndRelationshipBuilder.createAttribute("name", Cardinality.create("1"), "ST");
	}
	
	private Association createAssociation() {
		return TypeAndRelationshipBuilder.createAssociation("name", Cardinality.create("1"), 
				this.type);
	}
	
	private Association createAssociationList() {
		return TypeAndRelationshipBuilder.createAssociation("name", Cardinality.create("0-5"), 
				this.type);
	}
	
	@Test
	public void shouldGeneratePropertyDeclarationUsingTypeDecorator() throws Exception {
		final Association association = createAssociationList();
		this.javaBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);

		String output = this.writer.toString();
		assertTrue("field declaration", output.contains("private List<Type> name = new ArrayList<Type>();"));
	}
	
	@Test
	public void shouldGeneratePropertyDeclarationWithInitializer() throws Exception {
		final Attribute attribute = createAttribute();
		this.javaBuilder.setFieldDefinition(new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);

		String output = this.writer.toString();
		System.out.println(output);
		assertTrue("initializer", output.contains("private ST name = new STImpl();"));
	}

	@Test
	public void shouldGeneratePropertyWithGetter() throws Exception {
		final Association association = createAssociation();
		this.javaBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);

		String output = writer.toString();
		assertTrue("getter", output.contains("public Type getName() {"));
		assertTrue("getter body", output.contains("return this.name;"));
	}

	@Test
	public void shouldGenerateCsharpPropertyWithGetter() throws Exception {
		final Association association = createAssociation();
		this.csharpBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.C_SHARP));
		PropertyGenerator generator = this.csharpBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);
		
		String output = writer.toString();
		assertTrue("property", output.contains("public Type Name {"));
		assertTrue("getter", output.contains("get {"));
		assertTrue("getter body", output.contains("return this.name;"));
	}
	
	@Test
	public void shouldGenerateChoicePropertyWithGetterAndHas() throws Exception {
		final Association choiceAssociation = createAssociation();
		final Type choiceType = new Type(new TypeName("PRPA_123456CA.SubChoiceType"));
		this.javaBuilder.setFieldDefinition(new DerivedChoiceFieldDefinition(choiceAssociation, 
				new Choice("subChoice", choiceType), ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfType(choiceType); will(returnValue("SubChoiceType"));
			allowing(resolver).getName(with(any(Association.class))); will(returnValue("name"));
		}});

		generator.createDerivedChoiceGetterProperties(0, this.writer);

		String output = writer.toString();
		assertTrue("getter", output.contains("public SubChoiceType getNameAsSubChoice() {"));
		assertTrue("getter body", output.contains("return this.name instanceof SubChoiceType ? (SubChoiceType) this.name : null;"));
		assertTrue("has", output.contains("public boolean hasNameAsSubChoice() {"));
		assertTrue("has body", output.contains("return (this.name instanceof SubChoiceType);"));
	}

	@Test
	public void shouldGeneratePropertyWithGetterWithXmlMapping() throws Exception {
		final Association association = createAssociation();
		this.javaBuilder.setFieldDefinition(new AssociationFieldDefinition(association, JAVA));
		this.jmock.checking(new Expectations() {{
			allowing(resolver).getName(association); will(returnValue("name"));
		}});
		
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);

		String output = writer.toString();
		assertTrue("getter", output.contains("@Hl7XmlMapping({\"name\"})"));
		assertTrue("getter", output.contains("public Type getName() {"));
		assertTrue("getter body", output.contains("return this.name;"));
	}
	
	@Test
	public void shouldGenerateCsharpPropertyWithGetterWithXmlMapping() throws Exception {
		final Association association = createAssociation();
		this.csharpBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.C_SHARP));
		
		PropertyGenerator generator = this.csharpBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);
		
		String output = writer.toString();
		assertTrue("mapping", output.contains("[Hl7XmlMappingAttribute(new string[] {\"name\"})]"));
		assertTrue("getter", output.contains("public Type Name {"));
		assertTrue("getter body", output.contains("return this.name;"));
	}
	
	@Test
	public void shouldGeneratePropertyWithGetterWithBodyForAttribute() throws Exception {
		final Attribute attribute = createAttribute();
		this.javaBuilder.setFieldDefinition(new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);

		String output = writer.toString();
		assertTrue("getter", output.contains("public String getName() {"));
		assertTrue("getter body", output.contains("this.name.getValue();"));
	}

	@Test
	public void shouldGeneratePropertyWithSetter() throws Exception {
		final Association association = createAssociation();
		this.javaBuilder.setFieldDefinition(new AssociationFieldDefinition(association, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);

		String output = writer.toString();
		System.out.println(output);
		assertTrue("setter", output.contains("public void setName(Type name) {"));
		assertTrue("setter body", output.contains("this.name = name;"));
	}	
	
	@Test
	public void shouldGeneratePropertyWithSetterWithBodyForAttribute() throws Exception {
		final Attribute attribute = createAttribute();
		this.javaBuilder.setFieldDefinition(new AttributeFieldDefinitionImpl(attribute, ProgrammingLanguage.JAVA));
		PropertyGenerator generator = this.javaBuilder.build(this.manager, this.resolver);
		
		generator.createAttributeDefinition(0, this.writer);
		generator.createGettersAndSetters(0, this.writer);

		String output = writer.toString();
		assertTrue("setter", output.contains("public void setName(String name) {"));
		assertTrue("setter body", output.contains("this.name.setValue(name);"));
	}

	@Test
	public void teststripTemplateParameters() throws Exception {
		assertEquals("simple", "CD", PropertyGeneratorBuilder.stripTemplateParameters("CD"));
		assertEquals("nested", "CD", PropertyGeneratorBuilder.stripTemplateParameters("CD<A<B>>"));
	}
}
