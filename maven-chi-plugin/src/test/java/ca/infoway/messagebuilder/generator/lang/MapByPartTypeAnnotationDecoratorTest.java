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
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class MapByPartTypeAnnotationDecoratorTest {

	@Test
	public void shouldGenerateNothingWhenNotInlinedForJava() {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		BaseRelationship association = Association.createStandardAssociation(relationship, new Type(new TypeName(relationship.getType())));
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, association, ProgrammingLanguage.JAVA);
		assertEquals("", decorator.render());
	}
	
	@Test @Ignore
	public void shouldGenerateMappingsForInlinedAssociationForJava() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ABCD_MT123490CA.Patient", Cardinality.create("1"));
		
		Association highestAssociation = Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = Association.createStandardAssociation(relationship2, new Type(new TypeName(relationship2.getType())));
		Association lowestAssociation = Association.createStandardAssociation(relationship3, new Type(new TypeName(relationship3.getType())));
		
		Association inlinedAssociation1 = new InlinedAssociation(lowestAssociation, middleAssociation);
		Association inlinedAssociation2 = new InlinedAssociation(inlinedAssociation1, highestAssociation);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, inlinedAssociation2, ProgrammingLanguage.JAVA);
		assertEquals(	"\n@Hl7MapByPartTypes({\n" +
						"    @Hl7MapByPartType(name=\"theType\", type=\"ABCD_MT123456CA.SubjectOf2\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType\", type=\"ABCD_MT123478CA.Component4\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType/theSubSubType\", type=\"ABCD_MT123490CA.Patient\")})"
					, decorator.render());
	}
	
	@Test @Ignore
	public void shouldGenerateMappingsForInlinedAssociationForJavaWithReversedInlining() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ABCD_MT123490CA.Patient", Cardinality.create("1"));
		
		Association highestAssociation = Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = Association.createStandardAssociation(relationship2, new Type(new TypeName(relationship2.getType())));
		Association lowestAssociation = Association.createStandardAssociation(relationship3, new Type(new TypeName(relationship3.getType())));
		
		Association inlinedAssociation2 = new InlinedAssociation(middleAssociation, highestAssociation);
		Association inlinedAssociation1 = new InlinedAssociation(lowestAssociation, inlinedAssociation2);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, inlinedAssociation1, ProgrammingLanguage.JAVA);
		assertEquals(	"\n@Hl7MapByPartTypes({\n" +
						"    @Hl7MapByPartType(name=\"theType\", type=\"ABCD_MT123456CA.SubjectOf2\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType\", type=\"ABCD_MT123478CA.Component4\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType/theSubSubType\", type=\"ABCD_MT123490CA.Patient\")})" 
					, decorator.render());
	}
	
	
	@Test @Ignore
	public void shouldGenerateMappingsForMergedAndInlinedAssociationForJavaAndCSharpWithReversedInlining() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ABCD_MT123490CA.Patient", Cardinality.create("1"));
		
		Association highestAssociation = Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = Association.createStandardAssociation(relationship2, new Type(new TypeName(relationship2.getType())));
		middleAssociation = new MergedAssociation(middleAssociation, new Type(TemporaryTypeName.create("merged")));
		Association lowestAssociation = Association.createStandardAssociation(relationship3, new Type(new TypeName(relationship3.getType())));
		
		lowestAssociation = new MergedAssociation(lowestAssociation, new Type(TemporaryTypeName.create("merged")));
		
		Association inlinedAssociation2 = new InlinedAssociation(middleAssociation, highestAssociation);
		Association inlinedAssociation1 = new InlinedAssociation(lowestAssociation, inlinedAssociation2);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, inlinedAssociation1, ProgrammingLanguage.JAVA);
		assertEquals(	"\n@Hl7MapByPartTypes({\n" +
						"    @Hl7MapByPartType(name=\"theType\", type=\"ABCD_MT123456CA.SubjectOf2\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType\", type=\"ABCD_MT123478CA.Component4\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType/theSubSubType\", type=\"ABCD_MT123490CA.Patient\")})" 
				, decorator.render());
		
		decorator = new MapByPartTypeAnnotationDecorator(0, inlinedAssociation1, ProgrammingLanguage.C_SHARP);
		assertEquals(	
						"\n[Hl7MapByPartType(Name=\"theType\", Type=\"ABCD_MT123456CA.SubjectOf2\")]\n" +
						"[Hl7MapByPartType(Name=\"theType/theSubType\", Type=\"ABCD_MT123478CA.Component4\")]\n" +
						"[Hl7MapByPartType(Name=\"theType/theSubType/theSubSubType\", Type=\"ABCD_MT123490CA.Patient\")]" 
				, decorator.render());
	}
	
	@Test @Ignore
	public void shouldGenerateMappingsForInlinedAttributeForJava() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ST", Cardinality.create("1"));
		
		Association highestAssociation = Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = Association.createStandardAssociation(relationship2, new Type(new TypeName(relationship2.getType())));
		Attribute lowestAttribute = new Attribute(relationship3, new TypeConverter().convertToType(relationship3));
		
		Association inlinedAssociation = new InlinedAssociation(middleAssociation, highestAssociation);
		BaseRelationship inlinedAttribute = new InlinedAttribute(lowestAttribute, inlinedAssociation);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, inlinedAttribute, ProgrammingLanguage.JAVA);
		assertEquals(	"\n@Hl7MapByPartTypes({\n" +
						"    @Hl7MapByPartType(name=\"theType\", type=\"ABCD_MT123456CA.SubjectOf2\"),\n" +
						"    @Hl7MapByPartType(name=\"theType/theSubType\", type=\"ABCD_MT123478CA.Component4\")})"
					, decorator.render());
	}
	
	@Test
	public void shouldGenerateNothingWhenNotInlinedForCsharp() {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		BaseRelationship association = Association.createStandardAssociation(relationship, new Type(new TypeName(relationship.getType())));
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(0, association, ProgrammingLanguage.C_SHARP);
		assertEquals("", decorator.render());
	}
	
	@Test
	public void shouldIndicateThatAdditionalAnnotationIsNotRequiredInTrivialCase() throws Exception {
		Association association = Association.createStandardAssociation(new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.Person")));
		assertFalse("simple case", new MapByPartTypeAnnotationDecorator(0, association, JAVA).requiresMapByPartTypeAnnotation());
	}
	
	@Test
	public void shouldIndicateThatAdditionalAnnotationIsRequiredInTopMostCase() throws Exception {
		Relationship relationship = new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1"));
		relationship.addDifference(new Difference(DifferenceType.RELATIONSHIP_RENAMED,
				true, new DifferenceValue("version1", "person1"), new DifferenceValue("version2", "person")));
		
		Association association = Association.createStandardAssociation(relationship, new Type(new TypeName("ABCD_MT123456CA.Person")));
		assertTrue("basic rename", new MapByPartTypeAnnotationDecorator(0, association, JAVA).requiresMapByPartTypeAnnotation());
	}
	
	@Test
	public void shouldIndicateThatAdditionalAnnotationIsRequiredInInlinedRelationship() throws Exception {
		Relationship relationship = new Relationship("person", "ABCD_MT123456CA.Person", Cardinality.create("1"));
		relationship.addDifference(new Difference(DifferenceType.RELATIONSHIP_RENAMED,
				true, new DifferenceValue("version1", "person1"), new DifferenceValue("version2", "person")));
		Association association = Association.createStandardAssociation(relationship, new Type(new TypeName("ABCD_MT123456CA.Person")));
		Association elidedAssociation = Association.createStandardAssociation(new Relationship("patientPerson", "ABCD_MT123456CA.Patient", Cardinality.create("1")), new Type(new TypeName("ABCD_MT123456CA.Patient")));
		
		InlinedAssociation inlinedAssociation = new InlinedAssociation(association, elidedAssociation);
		assertTrue("basic rename", new MapByPartTypeAnnotationDecorator(0, inlinedAssociation, JAVA).requiresMapByPartTypeAnnotation());
	}
}
