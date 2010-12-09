package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.java.NamedType;
import ca.infoway.messagebuilder.xml.TypeName;

public class NamedTypeImpl implements NamedType {

	private TypeName typeName;

	public NamedTypeImpl(String type) {
		this.typeName = new TypeName(type);
	}
	
	public String getBusinessName() {
		return null;
	}

	public TypeName getTypeName() {
		return this.typeName;
	}
}

