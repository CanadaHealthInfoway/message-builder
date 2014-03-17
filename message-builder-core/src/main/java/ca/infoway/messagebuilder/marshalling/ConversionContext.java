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

import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class ConversionContext {
	private final MessageDefinitionService service;
	private final VersionNumber version;
	private final Interaction interaction;
	private final TimeZone dateTimeTimeZone;
	private final TimeZone dateTimeZone;
	
	ConversionContext(MessageDefinitionService service,
			VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, String messageId) {
		this.service = service;
		this.version = version;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.dateTimeZone = dateTimeZone;
		this.interaction = service.getInteraction(version, messageId);
	}

	public MessageDefinitionService getService() {
		return this.service;
	}

	public VersionNumber getVersion() {
		return this.version;
	}

	public TimeZone getDateTimeTimeZone() {
		return dateTimeTimeZone;
	}
	
	public TimeZone getDateTimeZone() {
		return dateTimeZone;
	}

	public MessagePart getMessagePart(String type) {
		return this.service.getMessagePart(this.version, type);
	} 

	public MessagePart getMessagePartOfRelationship(Relationship relationship) {
		return this.service.getMessagePart(this.version, relationship.getType());
	} 
	
	public Interaction getInteraction() {
		return this.interaction;
	}
	
	public String resolveType(Relationship relationship, String selectedElementName){
		String resolvedType;
		if (relationship.isTemplateRelationship()){
			resolvedType = resolveTemplateType(relationship.getTemplateParameterName(), selectedElementName, false);
		} else if (relationship.isChoice()) {
			resolvedType = resolveChoiceType(relationship, selectedElementName);
		} else {
			resolvedType = relationship.getType();
		}
		return resolvedType;
	}

	public String resolveTopmostType(Relationship relationship, String selectedElementName){
		String resolvedType;
		if (relationship.isTemplateRelationship()){
			resolvedType = resolveTemplateType(relationship.getTemplateParameterName(), selectedElementName, true);
		} else {
			resolvedType = relationship.getType();
		}
		return resolvedType;
	}

	private String resolveTemplateType(String templateName, String elementName, boolean topmostOnly) {
		RelationshipFormat format = resolveTemplateType(getInteraction().getArguments(), templateName);
		if (format == null) {
			throw new MarshallingException("Could not resolve Hl7 template information for template " + templateName);
		} else if (!topmostOnly && format.getArgument().isChoice()) {
			Relationship option = format.getArgument().findChoiceOption(Argument.choiceOptionNamePredicate(elementName));
			if (option == null) {
				throw new MarshallingException("Could not resolve Hl7 template choice information for template " + templateName + " and element name " + elementName);
			} else {
				return option.getType();
			}
		} else {
			return format.getType();
		}
	}

	RelationshipFormat resolveTemplateType(Relationship relationship) {
		RelationshipFormat result = resolveTemplateType(getInteraction().getArguments(), relationship.getTemplateParameterName());
		if (result == null) {
			throw new MarshallingException("Could not resolve Hl7 type for template " + relationship.getTemplateParameterName());
		} else {
			return result;
		}
	}
	
	String resolveChoiceType(Relationship relationship, String selectedElementName) {
		return relationship.findChoiceOption(Relationship.choiceOptionNamePredicate(selectedElementName)).getType();
	}
	
	
	private RelationshipFormat resolveTemplateType(List<Argument> arguments, String templateName){
		RelationshipFormat templateFormatInfo = null;
		for (Argument argument : arguments) {
			if (StringUtils.equals(argument.getTemplateParameterName(), templateName)) {
				templateFormatInfo = new RelationshipFormat(argument.getTraversalName(), argument.getName(), argument);
			} else if (argument.getName() != null && argument.getName().endsWith("." + templateName)) {
				// BCH: this looks suspicious.  Investigate later...
				templateFormatInfo = new RelationshipFormat(argument.getTraversalName(), argument.getName(), argument);
			} else {
				templateFormatInfo = resolveTemplateType(argument.getArguments(), templateName);
			}
			if (templateFormatInfo != null) {
				break;
			}
		}
		return templateFormatInfo;
	}
}
