package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

public interface ClassNameManager {
	
	public String getRepresentationOfClassName(String className);
	public String getRepresentationOfTypeName(TypeName typeName);
}
