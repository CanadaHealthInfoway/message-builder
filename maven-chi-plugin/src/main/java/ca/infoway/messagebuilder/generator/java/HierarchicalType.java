package ca.infoway.messagebuilder.generator.java;

import java.util.Set;

import ca.infoway.messagebuilder.xml.TypeName;

interface HierarchicalType {
	public Set<TypeName> getChildTypes();
}
