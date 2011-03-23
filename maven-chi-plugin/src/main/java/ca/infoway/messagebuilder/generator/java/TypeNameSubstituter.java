package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>During the process of simplification (and especially Case 3 simplification), 
 * we can hit cases where a type is substituted for another type.  This interface
 * describes the API to determine what the substituted type name is.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface TypeNameSubstituter {
	public TypeName substitute(TypeName typeName);
}
