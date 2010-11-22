package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

class DerivedChoiceFieldDefinition implements FieldDefinition {

	private final Association choiceAssociation;
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	private final ProgrammingLanguage language;
	private final Choice choice;

	DerivedChoiceFieldDefinition(Association choiceAssociation, Choice choice, ProgrammingLanguage language) {
		this.choiceAssociation = choiceAssociation;
		this.choice = choice;
		this.language = language;
	}
	
	private TypeDecorator getTypeDecorator() {
		if (this.choiceAssociation.isCardinalityMultiple()) {
			return TypeDecorator.LIST;
		} else {
			return TypeDecorator.NULL;
		}
	}
	
	public String getCapitalizedPropertyName() {
		String baseName = WordUtils.capitalize(getFieldName());
		String derivedChoiceName = WordUtils.capitalize(this.choice.getName());
		return baseName + "As" + derivedChoiceName;
	}

	public String getFieldName() {
		return WordUtils.uncapitalize(getResolver().getName(this.choiceAssociation));
	}

	public String getFieldElementImplementationType() {
		return getPropertyType();
	}

	public String getFieldElementType() {
		return getPropertyType();
	}

	public String getFieldImplementationType() {
		return getTypeDecorator().decorateImplType(getBaseType(), getBaseType(), this.language);
	}

	public String getFieldType() {
		return getTypeDecorator().decorateType(getBaseType(), this.language);
	}

	private String getBaseType() {
		return getManager().getRepresentationOfTypeName(this.choice.getType().getTypeName());
	}

	public GetterBodyStyle getGetterBodyStyle() {
		return GetterBodyStyle.DERIVED_CHOICE;
	}

	public GetterBodyStyle getDerivedChoiceHasBodyStyle() {
		return GetterBodyStyle.DERIVED_CHOICE_HAS;
	}

	public SetterBodyStyle getSetterBodyStyle() {
		return null;
	}

	public String getInitializationArguments() {
		return "";
	}

	public String getPropertyType() {
		return getFieldType();
	}

	public String[] getXmlPathName() {
		return this.choiceAssociation.getAllXmlMappings();
	}

	public void initializeContext(ClassNameManager manager,
			BaseRelationshipNameResolver resolver) {
		this.manager = manager;
		this.resolver = resolver;
	}
	
	private BaseRelationshipNameResolver getResolver() {
		if (this.resolver == null) {
			throw new IllegalStateException("The context has not been initialized");
		} else {
			return this.resolver;
		}
	}

	public boolean isWritable() {
		return false;
	}

	public void resetContext() {
		this.manager = null;
		this.resolver = null;
	}

	private ClassNameManager getManager() {
		if (this.manager == null) {
			throw new IllegalStateException("The context has not been initialized");
		} else {
			return this.manager;
		}
	}

	public boolean isInitializedAtConstructionTime() {
		return this.choiceAssociation.isCardinalityMultiple();
	}

	public String getPropertyElementImplementationType() {
		return ""; // not used
	}

	public String getCollectionOfCodedPropertyElementType() {
		return ""; // not used
	}

	public boolean isDerivedChoice() {
		return true;
	}

	public BaseRelationship getBaseRelationship() {
		return this.choiceAssociation;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return this.language;
	}

}
