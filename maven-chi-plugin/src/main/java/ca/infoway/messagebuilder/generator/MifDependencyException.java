package ca.infoway.messagebuilder.generator;

import ca.infoway.messagebuilder.Named;

/**
 * <p>This exception is thrown when the generator is attempting to 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MifDependencyException extends GeneratorException {

	private static final long serialVersionUID = -1413787022368271721L;

	public MifDependencyException(Named interactionName, String dependentType) {
		super("Type \"" + interactionName.getName() + "\" requires missing dependency: \"" + dependentType + "\"");
	}
}
