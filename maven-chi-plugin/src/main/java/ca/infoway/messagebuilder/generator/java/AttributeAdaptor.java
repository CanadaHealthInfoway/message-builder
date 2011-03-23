package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.xml.Documentation;

public class AttributeAdaptor implements AttributePropertyDescriptor {

	private final Attribute attribute;
	private final BaseRelationshipNameResolver nameResolver;
	private final ClassNameManager representation;

	public AttributeAdaptor(Attribute attribute, BaseRelationshipNameResolver nameResolver, ClassNameManager representation) {
		this.attribute = attribute;
		this.nameResolver = nameResolver;
		this.representation = representation;
	}

	public Documentation getDocumentation() {
		return this.attribute.getDocumentation();
	}

	public String getRelationshipNameCapitalized() {
		return RelationshipNameUtils.getRelationshipNameCapitalized(this.nameResolver, this.attribute);
	}

	public String getRelationshipNameUncapitalized() {
		return RelationshipNameUtils.getRelationshipNameUncapitalized(this.nameResolver, this.attribute);
	}

	public String getType() {
		return this.representation.getRepresentationOfClassName(this.attribute.getType()) + this.attribute.getTypeParameters();
	}

	public String[] getXmlMappings() {
		return this.attribute.getAllXmlMappings();
	}

	public boolean isCardinalityMultiple() {
		return this.attribute.getCardinality() != null && this.attribute.getCardinality().isMultiple();
	}

	public boolean isCollectionAttribute() {
		return attribute.isCollection();
	}

	public String getDomainType() {
		return this.attribute.getDomainType();
	}

	public DataType getDataType() {
		return this.attribute.getDataType();
	}

	public boolean isInlined() {
		return attribute instanceof InlinedAttribute;
	}

}
