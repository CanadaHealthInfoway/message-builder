package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;

import ca.infoway.messagebuilder.xml.TypeName;

public interface TypeProvider {
	public Collection<Type> getAllMessageTypes();
	public Type getTypeByName(TypeName name);
}
