package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.MarshallingException;

public class ModelToXmlTransformationException extends MarshallingException {

	private static final long serialVersionUID = -7643354300516851891L;

	public ModelToXmlTransformationException(String message) {
		super(message);
	}

	public ModelToXmlTransformationException(Throwable cause) {
		super(cause.toString(), cause);
	}

	public ModelToXmlTransformationException(String message, Throwable cause) {
		super(message, cause);
	}
}
