package ca.infoway.messagebuilder.marshalling;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.MessageTypeKey;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class Hl7MessageSource implements Hl7Source {
	
	private final ConversionContext context;
	private final Document document;
	private final XmlToModelResult result; 
	private MessagePart messagePart;

	public Hl7MessageSource(String version, Document document, MessageDefinitionService service) {
		this.document = document;
		this.context = new ConversionContext(service, version, getMessageIdFromDocument());
		this.result = new XmlToModelResult();
		if (this.context.getInteraction() == null){
			result.addHl7Error(new Hl7Error(Hl7ErrorCode.UNSUPPORTED_INTERACTION,
					"The interaction " + getMessageTypeKey() + " is not supported"));
		} else {
			this.messagePart = initMessagePart();
		}
	}

	public MessageDefinitionService getService() {
		return this.context.getService();
	}

	private MessagePart initMessagePart() {
		MessagePart messagePart = getService().getMessagePart(getVersion(), getType());
		if (messagePart == null) {
			throw new MarshallingException("No message part " + getType() + " for version " + getVersion());
		} else {
			return messagePart;
		}
	}
	
	public Element getCurrentElement() {
		return this.document.getDocumentElement();
	}

	public String getVersion() {
		return this.context.getVersion();
	}

	public String getType() {
		return this.context.getInteraction().getSuperTypeName();
	}

	public XmlToModelResult getResult() {
		return this.result;
	}
	
	public Hl7PartSource createPartSource(Relationship relationship, Element currentElement) {
		String type = this.context.resolveType(relationship, NodeUtil.getLocalOrTagName(currentElement));
		return new Hl7PartSource(this, type, currentElement, relationship.getType());
	}
	
	public ConversionContext getConversionContext(){
		return this.context;
	}
	
	public Interaction getInteraction() {
		return this.context.getInteraction();
	}

	public MessageTypeKey getMessageTypeKey() {
		return new MessageTypeKey(getVersion(), getMessageIdFromDocument());
	}

	private String getMessageIdFromDocument() {
		return NodeUtil.getLocalOrTagName(this.document.getDocumentElement());
	}

	public Relationship getRelationship(String name) {
		return this.messagePart.getRelationship(name, getInteraction());
	}

	public String getMessagePartName() {
		return this.messagePart.getName();
	}
}
