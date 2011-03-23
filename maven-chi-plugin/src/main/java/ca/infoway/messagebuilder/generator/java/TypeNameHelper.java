package ca.infoway.messagebuilder.generator.java;

import java.util.Map;

import ca.infoway.messagebuilder.xml.TypeName;

public interface TypeNameHelper {
	public Map<TypeName, Type> getTypes();
	public NamedType getNamedType(TypeName name);
	public boolean isAbstract(TypeName name);
}
