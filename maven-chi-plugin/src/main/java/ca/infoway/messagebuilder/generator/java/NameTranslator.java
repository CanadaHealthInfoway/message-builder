package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>A name translator has the responsiblity for converting between 
 * HL7 type names and Java class names.
 * 
 * @author administrator
 */
public interface NameTranslator {
	public String getFullyQualifiedClassName(TypeName name);
	public String getPackageName(TypeName name);
	public String getClassNameWithoutPackage(TypeName name);
}
