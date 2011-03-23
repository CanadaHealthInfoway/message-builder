package ca.infoway.messagebuilder.simple.xml;

public class ParserException extends MarshallingException {

	private static final long serialVersionUID = 8785762377007290974L;

	public ParserException() {
		super();
	}

	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(Throwable cause) {
		super(cause);
	}
}
