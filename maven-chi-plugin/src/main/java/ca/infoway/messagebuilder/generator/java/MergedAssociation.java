package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
	public String getXmlMapping() {
		return this.association.getXmlMapping();
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
	
	@Override
	public Set<Object> getImportTypes() {
		Set<Object> result = super.getImportTypes();
		if (this.type != null) {
			if (this.type.getLanguageSpecificName() != null) {
				result.add(this.type.getLanguageSpecificName().getFullyQualifiedName());
			} else {
				result.add(this.type.getTypeName());
			}
		}
		if (isCardinalityMultiple()) {
			result.add(List.class.getName());
			result.add(ArrayList.class.getName());
		}
		if (isChoice() && !isCardinalityMultiple()) {
			addLeafChoices(this.getRelationship().getChoices(), result);
		}
		return result;
	}
	
	
}
