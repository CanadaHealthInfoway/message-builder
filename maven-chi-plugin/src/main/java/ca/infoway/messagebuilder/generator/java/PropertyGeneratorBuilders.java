package ca.infoway.messagebuilder.generator.java;

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
	
}
