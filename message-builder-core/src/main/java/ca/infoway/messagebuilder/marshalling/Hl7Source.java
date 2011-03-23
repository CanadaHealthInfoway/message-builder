package ca.infoway.messagebuilder.marshalling;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

interface Hl7Source {

	public MessageDefinitionService getService();

	public String getMessagePartName();

	public Element getCurrentElement();

	public String getVersion();

	public String getType();

	public XmlToModelResult getResult();
	
	public Hl7PartSource createPartSource(Relationship relationship, Element currentElement);
	
	public Relationship getRelationship(String name);
	
	public Interaction getInteraction();
	
}