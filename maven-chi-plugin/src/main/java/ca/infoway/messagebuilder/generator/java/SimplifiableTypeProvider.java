package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;

interface SimplifiableTypeProvider {
	Collection<SimplifiableType> getAllTypes();
	SimplifiableType getType(String name);
}