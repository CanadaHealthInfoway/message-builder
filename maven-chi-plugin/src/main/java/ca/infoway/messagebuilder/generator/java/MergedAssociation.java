package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

public class MergedAssociation extends Association implements WrapperRelationship {

	private static final long serialVersionUID = 3765276875077194477L;
	
	private final Type type;
	private final TypeName typeName;
	private final Association association;
	
	protected MergedAssociation(Association association, Type type) {
		super(association.getRelationship(), type);
		this.association = association;
		this.type = type;
		this.typeName = this.type.getName();
	}

	@Override
	public Type getAssociationType() {
		return this.type;
	}

	@Override
	public String getType() {
		return this.typeName.toString();
	}

	public Association getOriginalAssociation() {
		return this.association;
	}
	@Override
	String getOriginalType() {
		return this.association.getOriginalType();
	}

	public BaseRelationship unwrap(TypeName name) {
		Association relationship = this.getOriginalAssociation();
		if (relationship instanceof WrapperRelationship) {
			return ((WrapperRelationship) relationship).unwrap(name);
		} else {
			return relationship;
		}
	}
}
