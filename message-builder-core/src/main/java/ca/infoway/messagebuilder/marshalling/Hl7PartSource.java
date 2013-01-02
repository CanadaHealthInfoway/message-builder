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

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class Hl7PartSource implements Hl7Source {
	
	private final Element currentElement;
	private final String hl7Type;
	private final Hl7MessageSource hl7InteractionSource;
	private final MessagePart messagePart;
	private final MessagePart originalMessagePart;

	public Hl7PartSource(Hl7MessageSource hl7InteractionSource, String hl7Type, Element currentElement, String originalHl7Type) {
		this.hl7InteractionSource = hl7InteractionSource;
		this.hl7Type = hl7Type;
		this.currentElement = currentElement;
		this.messagePart = initMessagePart(hl7Type);
		this.originalMessagePart = originalHl7Type == null ? this.messagePart : initMessagePart(originalHl7Type);
	}

	public MessageDefinitionService getService() {
		return this.hl7InteractionSource.getService();
	}

	private MessagePart initMessagePart(String type) {
		MessagePart result = getService().getMessagePart(getVersion(), type);
		if (result == null) {
			throw new MarshallingException("No message part " + type + " for version " + getVersion());
		} else {
			return result;
		}
	}
	
	public Element getCurrentElement() {
		return this.currentElement;
	}

	public VersionNumber getVersion() {
		return this.hl7InteractionSource.getVersion();
	}

	public TimeZone getDateTimeZone() {
		return this.hl7InteractionSource.getDateTimeZone();
	}
	
	public TimeZone getDateTimeTimeZone() {
		return this.hl7InteractionSource.getDateTimeTimeZone();
	}
	
	public String getType() {
		return this.hl7Type;
	}

	public XmlToModelResult getResult() {
		return this.hl7InteractionSource.getResult();
	}
	
	public Hl7PartSource createPartSource(Relationship relationship, Element currentElement) {
		return new Hl7PartSource(this.hl7InteractionSource,	resolveType(relationship, currentElement), currentElement, resolveTopmostType(relationship, currentElement));
	}

	private String resolveType(Relationship relationship, Element currentElement) {
		return this.hl7InteractionSource.getConversionContext().resolveType(relationship, NodeUtil.getLocalOrTagName(currentElement));
	}

	private String resolveTopmostType(Relationship relationship, Element currentElement) {
		return this.hl7InteractionSource.getConversionContext().resolveTopmostType(relationship, NodeUtil.getLocalOrTagName(currentElement));
	}

	public Relationship getRelationship(String name) {
		Relationship result = this.messagePart.getRelationship(name, this.hl7InteractionSource.getInteraction());
		if (result == null && !StringUtils.equals(this.messagePart.getName(), this.originalMessagePart.getName())) {
			result = getNestedRelationship(this.originalMessagePart, name);
		}
		return result;
	}

	private Relationship getNestedRelationship(MessagePart part, String name) {
		Relationship relationship = part.getRelationship(name, this.hl7InteractionSource.getInteraction());
		if (relationship == null) {
			for (String childType : part.getSpecializationChilds()) {
				if (typeIsAssignable(childType)) {
					MessagePart childPart = getService().getMessagePart(getVersion(), childType);
					relationship = getNestedRelationship(childPart, name);
					if (relationship != null) {
						break;
					}
				}
			}
		}
		return relationship;
	}

	/** 
	 * Is our type an implementation of the given child type?
	 * 
	 * @param childType
	 * @return whether our type is an implementation of the given child type
	 */
	private boolean typeIsAssignable(String childType) {
		boolean result = false;
		MessagePart childPart = getService().getMessagePart(getVersion(), childType);
		if (!childPart.isAbstract()) {
			result = StringUtils.equals(getType(), childPart.getName());
		} else {
			for (String specializationChild : childPart.getSpecializationChilds()) {
				if (typeIsAssignable(specializationChild)) {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}

	public String getMessagePartName() {
		return this.messagePart.getName();
	}

	public Interaction getInteraction() {
		return this.hl7InteractionSource.getConversionContext().getInteraction();
	}
}
