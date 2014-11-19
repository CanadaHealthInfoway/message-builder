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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.VersionNumber;
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
	private final boolean isR2;
	private final boolean isCda;
	

	public Hl7MessageSource(VersionNumber version, Document document, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, MessageDefinitionService service) {
		this.document = document;
		this.isR2 = service.isR2(version);
		this.isCda = service.isCda(version);
		
		String messageIdFromDocument = getMessageIdFromDocument();
		Set<String> templateIdsFromDocument = getTemplateIdsFromDocument();
		
		this.result = new XmlToModelResult();
		this.context = new ConversionContext(service, version, dateTimeZone, dateTimeTimeZone, messageIdFromDocument, templateIdsFromDocument, result);
		if (this.context.getInteraction() != null){
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
		return createPartSourceForSpecificType(relationship, currentElement, null);
	}
	
	public Hl7PartSource createPartSourceForSpecificType(Relationship relationship, Element currentElement, String type) {
		String resolvedType = (type == null ? this.context.resolveType(relationship, NodeUtil.getLocalOrTagName(currentElement)) : type);
		return new Hl7PartSource(this, resolvedType, currentElement, relationship.getType());
	}

	public ConversionContext getConversionContext(){
		return this.context;
	}
	
	public Interaction getInteraction() {
		return this.context.getInteraction();
	}

	public MessageTypeKey getMessageTypeKey() {
		return new MessageTypeKey(getVersion(), getInteraction().getName());
	}

	private String getMessageIdFromDocument() {
		return NodeUtil.getLocalOrTagName(this.document.getDocumentElement());
	}

	private Set<String> getTemplateIdsFromDocument() {
		Set<String> result = new HashSet<String>();
		List<Element> childNodes = NodeUtil.toElementList(this.document.getDocumentElement());
		for (Element element : childNodes) {
			if (StringUtils.equals(element.getNodeName(), "templateId")) {
				if (element.hasAttribute("root")) {
					result.add(element.getAttribute("root"));
				}
			}
		}
		return result;
	}

	public Relationship getRelationship(String name) {
		return this.messagePart.getRelationship(name, null, getInteraction());
	}

	public List<Relationship> getAllRelationships() {
		return this.messagePart.getRelationships();
	}

	public String getMessagePartName() {
		return this.messagePart.getName();
	}

	public boolean isR2() {
		return this.isR2;
	}

	public boolean isCda() {
		return this.isCda;
	}

}
