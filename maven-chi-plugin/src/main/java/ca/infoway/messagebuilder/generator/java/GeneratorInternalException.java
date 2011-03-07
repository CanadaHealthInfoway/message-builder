package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.GeneratorException;

public class GeneratorInternalException extends GeneratorException {

	private static final long serialVersionUID = 9210627705944036606L;

	public GeneratorInternalException() {
	}

	public GeneratorInternalException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneratorInternalException(String message) {
		super(message);
	}

	public GeneratorInternalException(Throwable cause) {
		super(cause);
	}
}
