/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling;

import java.util.TimeZone;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.VersionNumber;
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

	public Hl7MessageSource(VersionNumber version, Document document, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, MessageDefinitionService service) {
		this.document = document;
		this.context = new ConversionContext(service, version, dateTimeZone, dateTimeTimeZone, getMessageIdFromDocument());
		this.result = new XmlToModelResult();
		if (this.context.getInteraction() == null){
			result.addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.UNSUPPORTED_INTERACTION,
							"The interaction " + getMessageTypeKey() + " is not supported",
							document == null ? null : document.getDocumentElement()
							));
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

	public VersionNumber getVersion() {
		return this.context.getVersion();
	}
	
	public TimeZone getDateTimeZone() {
		return this.context.getDateTimeZone();
	}

	public TimeZone getDateTimeTimeZone() {
		return this.context.getDateTimeTimeZone();
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
