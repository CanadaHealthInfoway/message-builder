package ca.infoway.messagebuilder.marshalling.hl7;

import ca.infoway.messagebuilder.marshalling.MarshallingException;

public class XmlToModelTransformationException extends MarshallingException {

	private static final long serialVersionUID = 5389887615873887903L;

	public XmlToModelTransformationException(String message) {
		super(message);
	}

	public XmlToModelTransformationException(Throwable cause) {
		super(cause.toString(), cause);
	}

	public XmlToModelTransformationException(String message, Throwable cause) {
		super(message, cause);
	}
}
