package ca.infoway.messagebuilder.simple.xml;

public class FormatterException extends MarshallingException {

	private static final long serialVersionUID = 8785762377007290974L;

	public FormatterException() {
		super();
	}

	public FormatterException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormatterException(String message) {
		super(message);
	}

	public FormatterException(Throwable cause) {
		super(cause);
	}
}
