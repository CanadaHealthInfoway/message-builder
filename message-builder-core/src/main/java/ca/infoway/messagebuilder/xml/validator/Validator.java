package ca.infoway.messagebuilder.xml.validator;

import org.w3c.dom.Document;

import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.visitor.MessageWalker;

public class Validator {

	private final MessageWalker messageWalker;
	private final String version;

	public Validator(MessageDefinitionService service, Document message, String version) {
		this.version = version;
		this.messageWalker = new MessageWalker(service, message, version);
	}

	public MessageValidatorResult validate() {
		ValidatingVisitor visitor = new ValidatingVisitor(this.version);
		this.messageWalker.accept(visitor);
		return visitor.getResult();
	}

}
