package ca.infoway.messagebuilder.generator.java;

import java.util.Arrays;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class TypeAndRelationshipBuilder {

	public static Association createAssociation(String name, Cardinality cardinality, Type type) {
		return createAssociation(name, cardinality, type, null);
	}

	public static Association createAssociation(String name, Cardinality cardinality, Type type, ConformanceLevel conformanceLevel) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setType(type.getName().getName());
		relationship.setCardinality(cardinality);
		relationship.setConformance(conformanceLevel);
		return new Association(relationship, type);
	}

	public static Association createMergedAssociation(String name, Cardinality cardinality, Type originalType, Type mergedType, ConformanceLevel conformanceLevel) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setType(originalType.getName().getName());
		relationship.setCardinality(cardinality);
		relationship.setConformance(conformanceLevel);
		Association association = new Association(relationship, originalType);
		return new MergedAssociation(association, mergedType);
	}

	public static Attribute createAttribute(String name, Cardinality cardinality, String hl7Type) {
		return createAttribute(name, cardinality, hl7Type, null);
	}

	public static Attribute createAttribute(String name, Cardinality cardinality, String hl7Type, String domainType) {
		return createAttribute(name, cardinality, hl7Type, domainType, null);
	}

	public static Attribute createAttributeWithFixedValue(String name, Cardinality cardinality, String hl7Type, String fixedValue) {
		return createAttribute(name, cardinality, hl7Type, null, fixedValue);
	}
	
	public static Attribute createAttribute(String name, Cardinality cardinality, String hl7Type, String domainType, String fixedValue) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setType(hl7Type);
		relationship.setDomainType(domainType);
		relationship.setFixedValue(fixedValue);
		DataType dataType = new TypeConverter().convertToType(relationship);
		if (cardinality != null) {
			relationship.setCardinality(cardinality);
		} else if (dataType.isTypeCollection()) {
			relationship.setCardinality(new Cardinality(0,Integer.MAX_VALUE));
		} else {
			relationship.setCardinality(new Cardinality(1,1));
		}
		relationship.setDocumentation(new Documentation());
		return new Attribute(relationship, dataType);
	}

	public static Type createType(TypeAnalysisResult result, String name, BaseRelationship... relationships) {
		return createType(result, name, false, relationships);
	}

	public static Type createRootType(TypeAnalysisResult result, String name, BaseRelationship... relationships) {
		return createType(result, name, true, relationships);
	}

	public static Type createType(TypeAnalysisResult result, String name, boolean isRoot,
			BaseRelationship... relationships) {
		TypeName typeName = createTypeName(name);
		return createType(result, typeName, isRoot, relationships);
	}

	private static TypeName createTypeName(String name) {
		if (name.contains(".")) {
			return new TypeName(name);
		} else {
			return new TypeName("ABCD_MT123456CA." + name);
		}
	}

	public static Type createType(TypeAnalysisResult result, TypeName typeName,
			boolean isRoot, BaseRelationship... relationships) {
		Type type = new Type(typeName, isRoot);
		type.getRelationships().addAll(Arrays.asList(relationships));
		
		if (result != null) {
			result.addType(type);
		}
		return type;
	}

	public static InlinedAttribute createInlinedAttribute(Attribute inlinedRelationship,
			BaseRelationship elidedRelationship) {
		return new InlinedAttribute(inlinedRelationship, elidedRelationship);
	}

	public static BaseRelationship createTemplateAssociation(String name, String templateVariable) {
		Relationship relationship = new Relationship();
		relationship.setName(name);
		relationship.setCardinality(Cardinality.create("0-1"));
		relationship.setConformance(ConformanceLevel.REQUIRED);
		return Association.createTemplateAssociation(relationship, new TemplateVariable(templateVariable), 0);
	}

}
