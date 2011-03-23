package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;
public class AssociationAdaptor implements RelationshipPropertyDescriptor {

	private final Association association;
	private final BaseRelationshipNameResolver nameResolver;
	private final ClassNameManager representation;

	public AssociationAdaptor(Association association, BaseRelationshipNameResolver nameResolver, ClassNameManager representation) {
		this.association = association;
		this.nameResolver = nameResolver;
		this.representation = representation;
	}

	public Documentation getDocumentation() {
		return this.association.getDocumentation();
	}

	public String getRelationshipNameCapitalized() {
		return RelationshipNameUtils.getRelationshipNameCapitalized(this.nameResolver, this.association);
	}

	public String getRelationshipNameUncapitalized() {
		return RelationshipNameUtils.getRelationshipNameUncapitalized(this.nameResolver, this.association);
	}

	public String getType() {
		if (this.association.isTemplateType()) {
			return this.association.getTemplateVariable().getType() + this.association.getTypeParameters();
		} else {
			TypeName typeName = this.association.getPropertyTypeName();
			if (typeName != null) {
				return this.representation.getRepresentationOfTypeName(typeName) + this.association.getTypeParameters();
			} else {
				return this.representation.getRepresentationOfClassName(this.association.getType()) + this.association.getTypeParameters();
			}
		}
	}

	public String[] getXmlMappings() {
		return this.association.getAllXmlMappings();
	}

	public boolean isCardinalityMultiple() {
		return this.association.getCardinality() != null && this.association.getCardinality().isMultiple();
	}

}