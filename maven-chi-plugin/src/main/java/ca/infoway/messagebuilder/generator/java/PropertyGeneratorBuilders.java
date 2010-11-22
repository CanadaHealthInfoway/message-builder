package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class PropertyGeneratorBuilders {
	
	public static PropertyGeneratorBuilder newAttributeBuilder(ProgrammingLanguage language, Attribute attribute) {
		
		PropertyGeneratorBuilder builder = new PropertyGeneratorBuilder(language);
		builder.setFieldDefinition(new AttributeFieldDefinitionImpl(attribute, language));
		
		return builder;
	}

	public static PropertyGeneratorBuilder newAssociationBuilder(ProgrammingLanguage language, Association association) {
		PropertyGeneratorBuilder builder = new PropertyGeneratorBuilder(language);
		
		builder.setFieldDefinition(new AssociationFieldDefinition(association, language));
		
		return builder;
	}
	
	public static PropertyGeneratorBuilder newDerivedChoiceBuilder(ProgrammingLanguage language, Association choiceAssociation, Choice choice) {
		PropertyGeneratorBuilder builder = new PropertyGeneratorBuilder(language);
		
		builder.setFieldDefinition(new DerivedChoiceFieldDefinition(choiceAssociation, choice, language));
		
		return builder;
	}
	
	public static PropertyGeneratorBuilder newAssociationBusinessNameChangedBuilder(RegeneratedAssociation association) {
		PropertyGeneratorBuilder builder = newAssociationBuilder(ProgrammingLanguage.JAVA, association.getOriginalRelationship());

		return builder;
	}
	
	public static PropertyGeneratorBuilder newAttributeBusinessNameChangedBuilder(RegeneratedAttribute attribute) {
		PropertyGeneratorBuilder builder = newAttributeBuilder(ProgrammingLanguage.JAVA, attribute.getOriginalRelationship());
		
		return builder;
	}

	public static PropertyGeneratorBuilder newAssociationCardinalityChangedFromMultipleToSingleBuilder(RegeneratedAssociation association) {
		PropertyGeneratorBuilder builder = newAssociationBuilder(ProgrammingLanguage.JAVA, association.getOriginalRelationship());

		return builder;
	}
	
	public static PropertyGeneratorBuilder newAssociationCardinalityChangedFromSingleToMultipleBuilder(RegeneratedAssociation association) {
		PropertyGeneratorBuilder builder = newAssociationBuilder(ProgrammingLanguage.JAVA, association.getNewRelationship());

		return builder;
	}

	public static PropertyGeneratorBuilder newAttributeTypeChangedFromListOrSetToSimpleBuilder(RegeneratedAttribute attribute) {
		PropertyGeneratorBuilder builder = newAttributeBuilder(JAVA, attribute.getOriginalRelationship());

		return builder;
	}

	public static PropertyGeneratorBuilder newAttributeTypeChangedFromSimpleToListOrSetBuilder(RegeneratedAttribute attribute) {
		PropertyGeneratorBuilder builder = newAttributeBuilder(JAVA, attribute.getNewRelationship());

		return builder;
	}
	
}
