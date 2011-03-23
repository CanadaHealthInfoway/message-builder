package ca.infoway.messagebuilder.marshalling;

public class RenderingException extends MarshallingException {

	private static final long serialVersionUID = 1300553061611883012L;

	public RenderingException() {
		super();
	}

	public RenderingException(String message, Throwable cause) {
		super(message, cause);
	}

	public RenderingException(String message) {
		super(message);
	}

	public RenderingException(Throwable cause) {
		super(cause);
	}
}
