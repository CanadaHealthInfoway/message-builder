package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;

import ca.infoway.messagebuilder.xml.TypeName;

public class MergedAssociation extends Association {

	private static final long serialVersionUID = 3765276875077194477L;
	
	private final Type type;
	private final TypeName typeName;
	private final Association association;
	
	protected MergedAssociation(Association association, Type type) {
		super(association.getRelationship(), type, Collections.<Choice>emptyList());
		this.association = association;
		this.type = type;
		this.typeName = this.type.getTypeName();
	}

	@Override
	public String getName() {
		return this.association.getName();
	}

	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.association.getXmlMappingHelper();
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
}
