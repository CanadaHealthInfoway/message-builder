package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

class AssociationFieldDefinition implements FieldDefinition {

	private final Association association;
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	private final ProgrammingLanguage language;

	AssociationFieldDefinition(Association association, ProgrammingLanguage language) {
		this.association = association;
		this.language = language;
	}
	
	private TypeDecorator getTypeDecorator() {
		if (this.association.isCardinalityMultiple()) {
			return TypeDecorator.LIST;
		} else {
			return TypeDecorator.NULL;
		}
	}
	
	public String getCapitalizedPropertyName() {
		return WordUtils.capitalize(getFieldName());
	}

	public String getFieldName() {
		return WordUtils.uncapitalize(getResolver().getName(this.association));
	}

	public String getFieldElementImplementationType() {
		return ""; // not used
	}

	public String getFieldElementType() {
		return ""; // not used
	}

	public String getFieldImplementationType() {
		return getTypeDecorator().decorateImplType(getBaseType(), getBaseType(), this.language);
	}

	public String getFieldType() {
		return getTypeDecorator().decorateType(getBaseType(), this.language);
	}

	private String getBaseType() {
		if (this.association.isTemplateType()) {
			return this.association.getTemplateVariable().getType();
		} else {
			String name = getManager().getRepresentationOfType(this.association.getAssociationType());
			name += this.association.getTypeParameters();
			return name;
		}
	}

	public GetterBodyStyle getGetterBodyStyle() {
		return GetterBodyStyle.DEFAULT;
	}

	public String getInitializationArguments() {
		return "";
	}

	public String getPropertyType() {
		return getFieldType();
	}

	public SetterBodyStyle getSetterBodyStyle() {
		return SetterBodyStyle.DEFAULT;
	}

	public String[] getXmlPathName() {
		return this.association.getAllXmlMappings();
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
		return this.association.isWriteable();
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
		return this.association.isCardinalityMultiple();
	}

	public String getPropertyElementImplementationType() {
		return ""; // not used
	}

	public String getCollectionOfCodedPropertyElementType() {
		return ""; // not used
	}

	public boolean isDerivedChoice() {
		return false;
	}

	public GetterBodyStyle getDerivedChoiceHasBodyStyle() {
		return null;
	}

	public BaseRelationship getBaseRelationship() {
		return this.association;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return this.language;
	}

}
