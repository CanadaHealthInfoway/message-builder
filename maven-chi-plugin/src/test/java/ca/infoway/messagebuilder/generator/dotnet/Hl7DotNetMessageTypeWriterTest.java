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

package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;
import java.io.Writer;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.Association;
import ca.infoway.messagebuilder.generator.lang.Attribute;
import ca.infoway.messagebuilder.generator.lang.InteractionType;
import ca.infoway.messagebuilder.generator.lang.LanguageSpecificName;
import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.generator.lang.Type;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class Hl7DotNetMessageTypeWriterTest {
	
	private Mockery jmock = new Mockery();
	private Hl7DotNetMessageTypeWriter writer;
	private NameTranslator translator;
	private TypeName typeName;
	private StringWriter stringWriter;
	private Type type;
	private DependencyManager manager;
	
	@Before
	public void setUp() throws Exception {
		this.typeName = new TypeName("ABCD_MT123456CA.BatteryRequest");
		this.type = new Type(this.typeName);
		this.type.setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Fred", "BatteryRequest"));
		final String associationTypeName = "ABCD_MT123456CA.Component3";
		this.type.getRelationships().add(new Attribute(new Relationship("id", "II.BUS", Cardinality.create("1")), new TypeConverter().convertToType("II.BUS", null)));
		this.type.getRelationships().add(new Attribute(new Relationship("details", "ANY", Cardinality.create("1")), new TypeConverter().convertToType("ANY", null)));
		final Association association = Association.createStandardAssociation(new Relationship("component", associationTypeName, Cardinality.create("1")), new Type(new TypeName(associationTypeName)));
		association.getAssociationType().setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Fred", "Component3"));
		this.type.getRelationships().add(association);
		
		Relationship myChoice = new Relationship("myChoice", "ABCD_MT123456CA.MyChoice", Cardinality.create("1"));
		myChoice.getChoices().add(new Relationship("option1", "ABCD_MT123456CA.Option1", Cardinality.create("1")));
		myChoice.getChoices().add(new Relationship("option1", "ABCD_MT123456CA.Option2", Cardinality.create("1")));
		final Association choiceAssociation = Association.createStandardAssociation(myChoice, new Type(new TypeName("ABCD_MT123456CA.MyChoice")));
		choiceAssociation.getAssociationType().setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Fred", "MyChoice"));
		this.type.getRelationships().add(choiceAssociation);
		this.translator = this.jmock.mock(NameTranslator.class);
		this.manager = this.jmock.mock(DependencyManager.class);

		this.jmock.checking(new Expectations() {{
			allowing(manager).generate(with(any(Writer.class)), with(any(Integer.class))); 
			allowing(translator).getPackageName(typeName); will(returnValue("Ca.Infoway.Messagebuilder.Fred"));
			allowing(translator).getClassNameWithoutPackage(typeName); will(returnValue("BatteryRequest"));
			allowing(manager).getRepresentationOfClassName(Identifier.class.getName()); will(returnValue("Identifier"));
			allowing(manager).getRepresentationOfClassName(ANY.class.getName()); will(returnValue("ANY"));
			allowing(manager).getRepresentationOfClassName("System.object"); will(returnValue("object"));
			allowing(manager).getRepresentationOfClassName(".IMyChoice"); will(returnValue("IMyChoice"));
			allowing(manager).getRepresentationOfClassName(".IMyOtherChoice"); will(returnValue("IMyOtherChoice"));
			allowing(manager).getRepresentationOfType(choiceAssociation.getAssociationType()); will(returnValue("IMyChoice"));
			allowing(manager).getRepresentationOfType(association.getAssociationType()); will(returnValue("Requestor"));
		}});
		this.writer = new Hl7DotNetMessageTypeWriter(this.type, translator, this.manager, NamingPolicy.getDefaultPolicy());
		this.stringWriter = new StringWriter();
	}

	@Test
	public void shouldProduceClassDeclaration() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("public class BatteryRequest : MessagePart", output);
	}

	@Test
	public void shouldWriteConstructor() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("public BatteryRequest()", output);
		assertContains("this.id = new IIImpl();", output);
		assertContains("this.details = new ANYImpl<object>();", output);
	}
	
	@Test
	public void shouldWritePartTypeMapping() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("[Hl7PartTypeMappingAttribute(new string[] {\"ABCD_MT123456CA.BatteryRequest\"})]", output);
	}
	
	@Test
	public void shouldWriteNamespace() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("namespace Ca.Infoway.Messagebuilder.Fred", output);
	}
	
	@Test
	public void shouldWriteInteraction() throws Exception {
		final TypeName interactionName = new TypeName("ABCD_IN123456CA.BetterBatterQuery");
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(interactionName); will(returnValue("Ca.Infoway.Messagebuilder.Interaction"));
			allowing(translator).getClassNameWithoutPackage(interactionName); will(returnValue("BetterBatterQuery"));
		}});
		InteractionType interactionType = new InteractionType(interactionName);
		interactionType.setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Interaction", "BetterBatterQuery"));
		interactionType.setParentType(new Type(this.typeName));
		interactionType.getParentType().setLanguageSpecificName(new LanguageSpecificName("Ca.Infoway.Messagebuilder.Interaction", "BatteryRequest"));
		
		new Hl7DotNetMessageTypeWriter(interactionType, translator, this.manager, NamingPolicy.getDefaultPolicy()).write(this.stringWriter);
		String output = this.stringWriter.toString();
		assertContains("class BetterBatterQuery : BatteryRequest, IInteraction ", output);
	}
	
	@Test
	public void shouldWriteInterfaces() throws Exception {
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.MyChoice"));
		type1.setLanguageSpecificName(new LanguageSpecificName("", "IMyChoice"));
		this.type.getInterfaceTypes().add(type1);
		Type type2 = new Type(new TypeName("ABCD_MT123456CA.MyOtherChoice"));
		type2.setLanguageSpecificName(new LanguageSpecificName("", "IMyOtherChoice"));
		this.type.getInterfaceTypes().add(type2);
		
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains(", IMyOtherChoice", output);
		assertContains(", IMyChoice", output);
	}
	
	@Test
	public void shouldWriteInterfaceDefinition() throws Exception {
		this.type.setAbstract(true);
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.MyChoice"));
		type1.setLanguageSpecificName(new LanguageSpecificName("", "IMyChoice"));
		this.type.getInterfaceTypes().add(type1);
		
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains(": IMyChoice", output);
	}
	
	@Test
	public void shouldWriteAssociationDefinition() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
		assertContains("private Requestor component;", output);
	}
	
	@Test
	public void shouldWriteAssociationGetter() throws Exception {
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
System.out.println(output);		
		assertContains("return this.component;", output);
	}
	
	@Test
	public void shouldWriteAbstractAssociation() throws Exception {
		this.type.setAbstract(true);
		this.writer.write(this.stringWriter);
		String output = stringWriter.toString();
System.out.println(output);
		assertContains("get;", output);
	}
	
	private static void assertContains(String expectedSubstring, String actual) {
		assertTrue(expectedSubstring, actual.contains(expectedSubstring));
	}
}
