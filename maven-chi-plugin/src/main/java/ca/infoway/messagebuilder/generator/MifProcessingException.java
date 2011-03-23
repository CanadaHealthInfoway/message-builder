package ca.infoway.messagebuilder.generator;

import org.w3c.dom.Element;

public class MifProcessingException extends RuntimeException {

	private static final long serialVersionUID = -4189380226986699943L;

	public MifProcessingException() {
		super();
	}

	public MifProcessingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MifProcessingException(Element element, String message, Throwable cause) {
		super(createErrorMessage(element, message), cause);
	}

	private static String createErrorMessage(Element element, String message) {
		String ownedEntryPoint = new MifXPathHelper().getOwnedEntryPoint(element.getOwnerDocument());
		return "Error processing " + ownedEntryPoint + ": " + message;
	}

	public MifProcessingException(String message) {
		super(message);
	}

	public MifProcessingException(Throwable cause) {
		super(cause);
	}

	public MifProcessingException(Element element, String message) {
		super(createErrorMessage(element, message));
	}
}
