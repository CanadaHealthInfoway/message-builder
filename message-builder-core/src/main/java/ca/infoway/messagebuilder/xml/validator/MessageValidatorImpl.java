package ca.infoway.messagebuilder.xml.validator;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

public class MessageValidatorImpl implements MessageValidator {
	
	private final MessageDefinitionService service;

	public MessageValidatorImpl() {
		this(new MessageDefinitionServiceFactory().create());
	}
	
	public MessageValidatorImpl(MessageDefinitionService service) {
		this.service = service;
	}

	public MessageValidatorResult validate(Document message, String version) {
		return new Validator(service, message, version).validate();
	}
}
