package ca.infoway.messagebuilder.marshalling;

public class MarshallingException extends RuntimeException {

	private static final long serialVersionUID = -4687947353744762872L;

	public MarshallingException() {
	}

	public MarshallingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarshallingException(String message) {
		super(message);
	}

	public MarshallingException(Throwable cause) {
		super(cause.toString(), cause);
	}
}
