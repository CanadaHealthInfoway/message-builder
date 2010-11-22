package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

public interface ClassNameManager {
	public String getRepresentationOfClassName(String className);
	@Deprecated
	public String getRepresentationOfTypeName(TypeName typeName);
	public String getRepresentationOfType(Type type);
}
