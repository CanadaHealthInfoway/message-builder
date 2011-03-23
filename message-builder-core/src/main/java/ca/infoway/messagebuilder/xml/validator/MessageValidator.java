package ca.infoway.messagebuilder.xml.validator;

import org.w3c.dom.Document;

public interface MessageValidator {

	public MessageValidatorResult validate(Document document, String version);

}
