package ca.infoway.messagebuilder.generator;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePartResolver;

interface InteractionDefinition {
	public Interaction extract(MessagePartResolver resolver) throws GeneratorException;
}
