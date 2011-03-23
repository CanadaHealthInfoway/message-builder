package ca.infoway.messagebuilder.simple.xml;

public class MarshallingException extends Exception {

	private static final long serialVersionUID = -8830318658835070071L;
	
	public MarshallingException() {
	}

	public MarshallingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarshallingException(String message) {
		super(message);
	}

	public MarshallingException(Throwable cause) {
		super(cause);
	}
}
