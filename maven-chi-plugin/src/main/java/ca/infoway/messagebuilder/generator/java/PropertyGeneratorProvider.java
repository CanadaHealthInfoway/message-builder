package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public interface PropertyGeneratorProvider {

	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver);
}
