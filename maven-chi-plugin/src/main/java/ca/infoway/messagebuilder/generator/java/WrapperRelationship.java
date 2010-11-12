package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.TypeName;

interface WrapperRelationship {
	BaseRelationship unwrap(TypeName name);
}
