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

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;


public class DefinitionToResultConverterTest {

	private class TrivialLogger implements OutputUI {
		public void log(LogLevel level, String message) {
			System.out.println(message);
		}
	}

	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	private DefinitionToResultConverter converter = new DefinitionToResultConverter(this.definitions, "ca.infoway.test", JAVA, new TrivialLogger(), NamingPolicy.getDefaultPolicy());
	private TypeConverter typeConverter = new TypeConverter();
	
	@Test
	public void shouldConvertSimpleCase() throws Exception {

		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		simplifiableType.getRelationships().add(
				new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = (Type) CollectionUtils.get(result.getAllMessageTypes(), 0);
		assertEquals("name", new TypeName("ABCD_MT123456CA.Tom"), type.getTypeName());
		
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("atribute", type.getRelationships().get(0) instanceof Attribute);
		
		assertEquals("class name", "ca.infoway.test.abcd_mt123456ca.TomBean", type.getLanguageSpecificName().getFullyQualifiedName());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 2, result.getAllMessageTypes().size());

		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithInlinedAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		innerSimplifiableType.setInlined(true);
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
		
		BaseRelationship relationship = type.getRelationships().get(0);
		assertTrue("inlined", relationship instanceof InlinedAttribute);
		assertEquals("name", "personName", relationship.getName());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMultiplyInlinedAssociation() throws Exception {
		SimplifiableType innerSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Tom"), true);
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("name", "ST", Cardinality.create("1")), this.typeConverter.convertToType("ST", null)));
		innerSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("age", "INT", Cardinality.create("1")), this.typeConverter.convertToType("INT", null)));
		innerSimplifiableType.setInlined(true);
		SimplifiableType middleSimplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Person"), true);
		middleSimplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("tom", "ABCD_MT123456CA.Tom", Cardinality.create("1")), innerSimplifiableType));
		middleSimplifiableType.setInlined(true);
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1-10")), middleSimplifiableType));
		this.definitions.addType(middleSimplifiableType);
		this.definitions.addType(innerSimplifiableType);
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		assertEquals("number of types", 1, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 2, type.getRelationships().size());

		for (BaseRelationship relationship : type.getRelationships()) {
			assertTrue("inlined", relationship instanceof InlinedAttribute);
			assertTrue("name", new HashSet<String>(Arrays.asList("personTomName", "personTomAge")).contains(relationship.getName()));
			assertTrue("multiple cardinality", relationship.getCardinality().isMultiple());
		}
	}
	
	@Test
	public void shouldConvertSimpleCaseWithTemplateAssociation() throws Exception {
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient"), true);
		Relationship relationship = new Relationship("role", null, Cardinality.create("1"));
		relationship.setTemplateParameterName("RegisteredRole");
		simplifiableType.getRelationships().add(new SimplifiableRelationship(relationship, new TemplateVariable("RR")));
		this.definitions.addType(simplifiableType);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient"));
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("association", type.getRelationships().get(0) instanceof Association);
		assertTrue("template association", ((Association) type.getRelationships().get(0)).isTemplateType());
		assertEquals("variable name", "RR", ((Association) type.getRelationships().get(0)).getType());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMergedTypes() throws Exception {
		Relationship relationship1 = new Relationship("role", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false, "common");
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(relationship1, this.typeConverter.convertToType("ST", null)));
		
		Relationship relationship2 = new Relationship("name", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false, "common");
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(relationship2, this.typeConverter.convertToType("ST", null)));
		
		TypeName mergedTypeName = TemporaryTypeName.create("merged");
		
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType1.setMergedTypeName(mergedTypeName);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);
		simplifiableType2.setMergedTypeName(mergedTypeName);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(mergedTypeName);
		assertNotNull("type", type);
		assertEquals("number of relationships", 2, type.getRelationships().size());
		assertEquals("category", "common", type.getCategory());
		assertTrue("attribute", type.getRelationships().get(0) instanceof Attribute);
		assertTrue("attribute", type.getRelationships().get(1) instanceof Attribute);
		
		assertEquals("class name", "ca.infoway.test.common.merged.Patient2Bean", type.getLanguageSpecificName().getFullyQualifiedName());
	}

	@Test
	public void shouldNotMergedTypeIfAllButOneTypeInlinedAway() throws Exception {
		Relationship relationship1 = new Relationship("role", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false, "common");
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(relationship1, this.typeConverter.convertToType("ST", null)));
		
		Relationship relationship2 = new Relationship("name", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false, "common");
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(relationship2, this.typeConverter.convertToType("ST", null)));
		simplifiableType2.setInlined(true);
		
		TypeName mergedTypeName = TemporaryTypeName.create("merged");
		
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType1.setMergedTypeName(mergedTypeName);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);
		simplifiableType2.setMergedTypeName(mergedTypeName);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type1 = result.getTypeByName(mergedTypeName);
		assertNull("type", type1);
		Type type2 = result.getTypeByName(simplifiableType1.getTypeName());
		assertNotNull("type", type2);
		Type type3 = result.getTypeByName(simplifiableType2.getTypeName());
		assertNull("type", type3);

		assertEquals("number of relationships", 1, type2.getRelationships().size());
	}

	@Test
	public void shouldConvertSimpleCaseWithMergedAndInlinedTypes() throws Exception {
		
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.setInlined(true);
		
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false);
		simplifiableType2.setInlined(true);
		
		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 0, result.getAllMessageTypes().size());
	}	
	
	@Test
	public void shouldDisallowInliningWhenParentAndChildTypesAreMerged() throws Exception {
		
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false);

		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Child1"), false);

		SimplifiableType simplifiableType4 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Child2"), false);
		simplifiableType4.setInlined(true);

		Relationship parentRelationship1 = new Relationship("child", "ABCD_MT123456CA.Child1", Cardinality.create("1"));
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(parentRelationship1, simplifiableType3));		
		
		Relationship parentRelationship2 = new Relationship("child", "ABCD_MT123456CA.Child2", Cardinality.create("1"));
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(parentRelationship2, simplifiableType4));		

		Relationship childRelationship1 = new Relationship("childName", "ST", Cardinality.create("1"));
		simplifiableType3.getRelationships().add(new SimplifiableRelationship(childRelationship1, this.typeConverter.convertToType("ST", null)));		
		
		Relationship childRelationship2 = new Relationship("childAge", "INT.POS", Cardinality.create("1"));
		simplifiableType4.getRelationships().add(new SimplifiableRelationship(childRelationship2, this.typeConverter.convertToType("INT.POS", null)));		

		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);

		TemporaryTypeName name2 = TemporaryTypeName.create("merged");
		simplifiableType3.setMergedTypeName(name2);
		simplifiableType3.getMergedWithTypes().add(simplifiableType3);
		simplifiableType3.getMergedWithTypes().add(simplifiableType4);
		
		simplifiableType4.setMergedTypeName(name2);
		simplifiableType4.getMergedWithTypes().add(simplifiableType3);
		simplifiableType4.getMergedWithTypes().add(simplifiableType4);

		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		this.definitions.addType(simplifiableType4);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 2, result.getAllMessageTypes().size());
		assertNotNull("type exists", result.getNamedType(name));
		assertNotNull("type exists", result.getNamedType(name2));
		assertNotNull("relationship", result.getNamedType(name).getRelationship("child"));
		assertNull("relationship", result.getNamedType(name).getRelationship("childName"));
		assertNull("relationship", result.getNamedType(name).getRelationship("childAge"));
	}	
	
	@Test
	public void shouldConvertSimpleCaseWithMergedWithTrivialInlinedCase() throws Exception {
		
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.setInlined(true);
		
		MessagePart messagePart = new MessagePart("ABCD_MT123456CA.Patient2");
		messagePart.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.Patient3"));
		messagePart.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.Patient4"));
		SimplifiableType simplifiableType2 = new SimplifiableType(messagePart, false);
		
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient3"), false);
		simplifiableType3.getInterfaceTypes().add("ABCD_MT123456CA.Patient2");

		SimplifiableType simplifiableType4 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient4"), false);
		simplifiableType4.getInterfaceTypes().add("ABCD_MT123456CA.Patient2");

		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		this.definitions.addType(simplifiableType4);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 3, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient3"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient4"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.Patient2"));
		assertNotNull("type", type);
		assertEquals("interfaces", 2, type.getChildTypes().size());
	}	
	
	@Test
	public void shouldConvertInlinedAndMergedCaseWithMultipleCardinality() throws Exception {

		MessagePart messagePart1 = new MessagePart("ABCD_MT123456CA.MergedInterfaceType1");
		messagePart1.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.ChildType1"));
		messagePart1.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.ChildType2"));
		SimplifiableType simplifiableType1 = new SimplifiableType(messagePart1, false);
		
		MessagePart messagePart2 = new MessagePart("ABCD_MT123456CA.MergedInterfaceType2");
		messagePart2.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.ChildType1"));
		messagePart2.getSpecializationChilds().add(new SpecializationChild("ABCD_MT123456CA.ChildType2"));
		SimplifiableType simplifiableType2 = new SimplifiableType(messagePart2, false);
		
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.ChildType1"), false);
		simplifiableType3.getInterfaceTypes().add("ABCD_MT123456CA.MergedInterfaceType1");

		SimplifiableType simplifiableType4 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.ChildType2"), false);
		simplifiableType4.getInterfaceTypes().add("ABCD_MT123456CA.MergedInterfaceType1");

		TemporaryTypeName name = TemporaryTypeName.create("merged");
		simplifiableType1.setMergedTypeName(name);
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		
		simplifiableType2.setMergedTypeName(name);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);
		
		Relationship relationship = new Relationship("relatedPerson", "ABCD_MT123456CA.MergedInterfaceType1", Cardinality.create("1"));
		SimplifiableType simplifiableType = new SimplifiableType(new MessagePart("ABCD_MT123456CA.InlinedType"), false);
		simplifiableType.getRelationships().add(new SimplifiableRelationship(relationship, simplifiableType1));
		simplifiableType.setInlined(true);

		Relationship relationship0 = new Relationship("relatedPersons", "ABCD_MT123456CA.InlinedType", Cardinality.create("0-20"));
		SimplifiableType simplifiableType0 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.TopMostType"), false);
		simplifiableType0.getRelationships().add(new SimplifiableRelationship(relationship0, simplifiableType));

		this.definitions.addType(simplifiableType0);
		this.definitions.addType(simplifiableType);
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		this.definitions.addType(simplifiableType4);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 4, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(new TypeName("ABCD_MT123456CA.ChildType1"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.ChildType2"));
		assertNotNull("type", type);
		assertFalse("interface", type.getInterfaceTypes().isEmpty());
		
		type = result.getTypeByName(name);
		assertNotNull("type", type);
		assertEquals("interfaces", 2, type.getChildTypes().size());
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.InlinedType"));
		assertNull("type", type);

		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.TopMostType"));
		assertNotNull("type", type);
		assertEquals("relationships", 1, type.getRelationships().size());
		assertTrue("cardinality", type.getRelationships().get(0).getCardinality().isMultiple());
	}
	
	@Test
	public void shouldConvertInlinedAndMergedCaseWithMultipleCardinalityForBug() throws Exception {

		Relationship cvRelationship3a = new Relationship("code", "CV", Cardinality.create("1"));
		Relationship cvRelationship3b = new Relationship("code", "CV", Cardinality.create("1"));
		
		SimplifiableType simplifiableType3a = new SimplifiableType(new MessagePart("COCT_MT470002CA.ActDefinition"), false);
		simplifiableType3a.getRelationships().add(new SimplifiableRelationship(cvRelationship3a, new TypeConverter().convertToType(cvRelationship3a)));
		simplifiableType3a.setInlined(true);

		SimplifiableType simplifiableType3b = new SimplifiableType(new MessagePart("COCT_MT470012CA.ActDefinition"), false);
		simplifiableType3b.getRelationships().add(new SimplifiableRelationship(cvRelationship3b, new TypeConverter().convertToType(cvRelationship3b)));
		simplifiableType3b.setInlined(true);

		TemporaryTypeName name3 = TemporaryTypeName.create("merged");
		simplifiableType3a.setMergedTypeName(name3);
		simplifiableType3a.getMergedWithTypes().add(simplifiableType3a);
		simplifiableType3a.getMergedWithTypes().add(simplifiableType3b);
		
		simplifiableType3b.setMergedTypeName(name3);
		simplifiableType3b.getMergedWithTypes().add(simplifiableType3a);
		simplifiableType3b.getMergedWithTypes().add(simplifiableType3b);

		// >>>>>>>>>>>>>>>
		
		SimplifiableType simplifiableType2a = new SimplifiableType(new MessagePart("COCT_MT470002CA.Subject3"), false);
		simplifiableType2a.getRelationships().add(new SimplifiableRelationship(new Relationship("actDefinition", "COCT_MT470002CA.ActDefinition", Cardinality.create("1")), simplifiableType3a));
		simplifiableType2a.setInlined(true);
		
		SimplifiableType simplifiableType2b = new SimplifiableType(new MessagePart("COCT_MT470012CA.Subject3"), false);
		simplifiableType2b.getRelationships().add(new SimplifiableRelationship(new Relationship("actDefinition", "COCT_MT470012CA.ActDefinition", Cardinality.create("1")), simplifiableType3b));
		simplifiableType2b.setInlined(true);
		
		TemporaryTypeName name2 = TemporaryTypeName.create("merged");
		simplifiableType2a.setMergedTypeName(name2);
		simplifiableType2a.getMergedWithTypes().add(simplifiableType2a);
		simplifiableType2a.getMergedWithTypes().add(simplifiableType2b);
		
		simplifiableType2b.setMergedTypeName(name2);
		simplifiableType2b.getMergedWithTypes().add(simplifiableType2a);
		simplifiableType2b.getMergedWithTypes().add(simplifiableType2b);

		// >>>>>>>>>>>>>>>
		
		SimplifiableType simplifiableType1a = new SimplifiableType(new MessagePart("COCT_MT470002CA.InformDefinition"), false);
		simplifiableType1a.getRelationships().add(new SimplifiableRelationship(new Relationship("subject", "COCT_MT470002CA.Subject3", Cardinality.create("1-10")), simplifiableType2a));
		
		SimplifiableType simplifiableType1b = new SimplifiableType(new MessagePart("COCT_MT470012CA.InformDefinition"), false);
		simplifiableType1b.getRelationships().add(new SimplifiableRelationship(new Relationship("subject", "COCT_MT470012CA.Subject3", Cardinality.create("1-10")), simplifiableType2b));

		TemporaryTypeName name1 = TemporaryTypeName.create("merged");
		simplifiableType1a.setMergedTypeName(name1);
		simplifiableType1a.getMergedWithTypes().add(simplifiableType1a);
		simplifiableType1a.getMergedWithTypes().add(simplifiableType1b);
		
		simplifiableType1b.setMergedTypeName(name1);
		simplifiableType1b.getMergedWithTypes().add(simplifiableType1a);
		simplifiableType1b.getMergedWithTypes().add(simplifiableType1b);

		this.definitions.addType(simplifiableType1a);
		this.definitions.addType(simplifiableType1b);
		this.definitions.addType(simplifiableType2a);
		this.definitions.addType(simplifiableType2b);
		this.definitions.addType(simplifiableType3a);
		this.definitions.addType(simplifiableType3b);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertEquals("count", 1, result.getAllMessageTypes().size());
		
		Type type = result.getTypeByName(name1);
		assertNotNull("type", type);
		assertTrue("interface", type.getInterfaceTypes().isEmpty());
		assertTrue("cardinality", type.getRelationships().get(0).getCardinality().isMultiple());
	}
	
	@Test
	public void shouldConvertSimpleCaseWithMergedAssociations() throws Exception {
		Relationship relationship1 = new Relationship("role", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient1"), false);
		simplifiableType1.getRelationships().add(new SimplifiableRelationship(relationship1, this.typeConverter.convertToType("ST", null)));
		
		Relationship relationship2 = new Relationship("name", "ST", Cardinality.create("1"));
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Patient2"), false);
		simplifiableType2.getRelationships().add(new SimplifiableRelationship(relationship2, this.typeConverter.convertToType("ST", null)));
		
		TypeName mergedTypeName = TemporaryTypeName.create("merged");
		
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		simplifiableType1.setMergedTypeName(mergedTypeName);
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);
		simplifiableType2.setMergedTypeName(mergedTypeName);

		Relationship relationship3 = new Relationship("patient1", "ABCD_MT123456CA.Patient1", Cardinality.create("1"));
		SimplifiableType simplifiableType3 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.SomeOtherType"), false);
		simplifiableType3.getRelationships().add(new SimplifiableRelationship(relationship3, simplifiableType1));
		
		this.definitions.addType(simplifiableType1);
		this.definitions.addType(simplifiableType2);
		this.definitions.addType(simplifiableType3);
		
		TypeAnalysisResult result = this.converter.convert();
		
		assertNotNull("result", result);
		
		Type type = result.getTypeByName(mergedTypeName);
		assertNotNull("type", type);
		assertEquals("number of relationships", 2, type.getRelationships().size());
		assertTrue("attribute", type.getRelationships().get(0) instanceof Attribute);
		assertTrue("attribute", type.getRelationships().get(1) instanceof Attribute);
		
		type = result.getTypeByName(new TypeName("ABCD_MT123456CA.SomeOtherType"));
		assertNotNull("type", type);
		assertEquals("number of relationships", 1, type.getRelationships().size());
		assertTrue("association", type.getRelationships().get(0) instanceof MergedAssociation);
		assertEquals("association type", mergedTypeName.getName(), type.getRelationships().get(0).getType());
	}
	
	// an inlined attribute should collate according to the outer/elided association
	@Test
	public void shouldHandleMergedRenamedAssociations() throws Exception {
		Type mergedType = new Type(TemporaryTypeName.create("merged"));
		
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.Person"));
		
		type1.getRelationships().add(new InlinedAttribute(
				new Attribute(new Relationship("name", "PN", Cardinality.create("1")),
						this.typeConverter.convertToType("PN", null)),
				new Association(
						new Relationship("identifiedParty", "ABCD_MT123456CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.IndentifiedParty")),
						Collections.<Choice>emptyList())));
		
		Type type2 = new Type(new TypeName("ABCD_MT987654CA.Person"));
		
		mergedType.getMergedTypes().add(type1);
		mergedType.getMergedTypes().add(type2);
		
		this.converter.types.put(type1.getTypeName().getName(), type1);
		this.converter.types.put(type2.getTypeName().getName(), type2);

		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT123456CA.IndentifiedParty"), false));
		
		MergedTypeCollator collator = this.converter.createCollator(mergedType);
		
		Collection<Fingerprint> names = collator.relationshipNames();
		assertEquals("size", 1, names.size());
		assertEquals("type", "ABCD_MT123456CA.IndentifiedParty/name", 
				((Fingerprint) CollectionUtils.get(names, 0)).toString());
	}
	@Test
	public void shouldHandleForciblyMergedTypes() throws Exception {
		Type mergedType = new Type(TemporaryTypeName.create("merged"));
		Type type1 = new Type(new TypeName("ABCD_MT123456CA.Person"));
		type1.getRelationships().add(
				new Association(
						new Relationship("identifiedParty", "ABCD_MT123456CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.IndentifiedParty")),
						Collections.<Choice>emptyList()));
		
		Type type2 = new Type(new TypeName("ABCD_MT987654CA.Person"));
		type2.getRelationships().add(
				new Association(
						new Relationship("identifiedParty", "ABCD_MT987654CA.IndentifiedParty",
						Cardinality.create("1")), new Type(new TypeName("ABCD_MT987654CA.IndentifiedParty")),
						Collections.<Choice>emptyList()));
		
		mergedType.getMergedTypes().add(type1);
		mergedType.getMergedTypes().add(type2);
		
		this.converter.types.put(type1.getTypeName().getName(), type1);
		this.converter.types.put(type2.getTypeName().getName(), type2);
		this.converter.types.put(mergedType.getTypeName().getName(), mergedType);

		SimplifiableType simplifiableType1 = new SimplifiableType(new MessagePart("ABCD_MT123456CA.Person"), false);
		SimplifiableType simplifiableType2 = new SimplifiableType(new MessagePart("ABCD_MT987654CA.Person"), false);
		this.definitions.addType(simplifiableType1);
		simplifiableType1.setMergedTypeName(mergedType.getTypeName());
		simplifiableType1.getMergedWithTypes().add(simplifiableType1);
		simplifiableType1.getMergedWithTypes().add(simplifiableType2);
		this.definitions.addType(simplifiableType2);
		simplifiableType2.setMergedTypeName(mergedType.getTypeName());
		simplifiableType2.getMergedWithTypes().add(simplifiableType1);
		simplifiableType2.getMergedWithTypes().add(simplifiableType2);
		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT123456CA.IndentifiedParty"), false));
		this.definitions.addType(new SimplifiableType(new MessagePart("ABCD_MT987654CA.IndentifiedParty"), false));
		
		this.converter.createRelationshipsForAllMergedTypes();
		
		assertFalse("relationships", mergedType.getRelationships().isEmpty());
		assertEquals("relationship count", 2, mergedType.getRelationships().size());
		assertTrue("1 requires thingie", mergedType.getRelationships().get(0).requiresMapByPartTypeAnnotation());
		assertTrue("2 requires thingie", mergedType.getRelationships().get(1).requiresMapByPartTypeAnnotation());
	}
}
