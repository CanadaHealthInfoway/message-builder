package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class MapByPartTypeAnnotationDecoratorTest {

	@Test
	public void shouldGenerateNothingWhenNotInlinedForJava() {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		BaseRelationship association = new Association(relationship, new Type(new TypeName(relationship.getType())));
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(association, ProgrammingLanguage.JAVA);
		assertEquals("", decorator.render());
	}
	
	@Test
	public void shouldGenerateMappingsForInlinedAssociationForJava() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ABCD_MT123490CA.Patient", Cardinality.create("1"));
		
		Association highestAssociation = new Association(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = new Association(relationship2, new Type(new TypeName(relationship2.getType())));
		Association lowestAssociation = new Association(relationship3, new Type(new TypeName(relationship3.getType())));
		
		Association inlinedAssociation1 = new InlinedAssociation(lowestAssociation, middleAssociation);
		Association inlinedAssociation2 = new InlinedAssociation(inlinedAssociation1, highestAssociation);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(inlinedAssociation2, ProgrammingLanguage.JAVA);
		assertEquals(	"@Hl7MapByPartTypes({@Hl7MapByPartType(name=\"theType\",type=\"ABCD_MT123456CA.SubjectOf2\")," +
						"@Hl7MapByPartType(name=\"theType/theSubType\",type=\"ABCD_MT123478CA.Component4\")," +
						"@Hl7MapByPartType(name=\"theType/theSubType/theSubSubType\",type=\"ABCD_MT123490CA.Patient\")})"
					, decorator.render());
	}
	
	@Test
	public void shouldGenerateMappingsForInlinedAssociationForJavaWithReversedInlining() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ABCD_MT123490CA.Patient", Cardinality.create("1"));
		
		Association highestAssociation = new Association(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = new Association(relationship2, new Type(new TypeName(relationship2.getType())));
		Association lowestAssociation = new Association(relationship3, new Type(new TypeName(relationship3.getType())));
		
		Association inlinedAssociation2 = new InlinedAssociation(middleAssociation, highestAssociation);
		Association inlinedAssociation1 = new InlinedAssociation(lowestAssociation, inlinedAssociation2);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(inlinedAssociation1, ProgrammingLanguage.JAVA);
		assertEquals(	"@Hl7MapByPartTypes({@Hl7MapByPartType(name=\"theType\",type=\"ABCD_MT123456CA.SubjectOf2\")," +
						"@Hl7MapByPartType(name=\"theType/theSubType\",type=\"ABCD_MT123478CA.Component4\")," +
						"@Hl7MapByPartType(name=\"theType/theSubType/theSubSubType\",type=\"ABCD_MT123490CA.Patient\")})" 
					, decorator.render());
	}
	
	@Test
	public void shouldGenerateMappingsForInlinedAttributeForJava() {
		Relationship relationship1 = new Relationship("theType", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		Relationship relationship2 = new Relationship("theSubType", "ABCD_MT123478CA.Component4", Cardinality.create("1"));
		Relationship relationship3 = new Relationship("theSubSubType", "ST", Cardinality.create("1"));
		
		Association highestAssociation = new Association(relationship1, new Type(new TypeName(relationship1.getType())));
		Association middleAssociation = new Association(relationship2, new Type(new TypeName(relationship2.getType())));
		Attribute lowestAttribute = new Attribute(relationship3, new TypeConverter().convertToType(relationship3));
		
		Association inlinedAssociation = new InlinedAssociation(middleAssociation, highestAssociation);
		BaseRelationship inlinedAttribute = new InlinedAttribute(lowestAttribute, inlinedAssociation);
		
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(inlinedAttribute, ProgrammingLanguage.JAVA);
		assertEquals(	"@Hl7MapByPartTypes({@Hl7MapByPartType(name=\"theType\",type=\"ABCD_MT123456CA.SubjectOf2\")," +
						"@Hl7MapByPartType(name=\"theType/theSubType\",type=\"ABCD_MT123478CA.Component4\")})"
					, decorator.render());
	}
	
	@Test
	public void shouldGenerateNothingWhenNotInlinedForCsharp() {
		Relationship relationship = new Relationship("relName", "ABCD_MT123456CA.SubjectOf2", Cardinality.create("1"));
		BaseRelationship association = new Association(relationship, new Type(new TypeName(relationship.getType())));
		MapByPartTypeAnnotationDecorator decorator = new MapByPartTypeAnnotationDecorator(association, ProgrammingLanguage.C_SHARP);
		assertEquals("", decorator.render());
	}
	
}
