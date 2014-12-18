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

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.MarshallingException;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
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
	
	ConversionContext(MessageDefinitionService service, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone, String messageId, Set<String> templateIdsFromDocument, Hl7Errors errors) {
		this.service = service;
		this.version = version;
		this.dateTimeTimeZone = dateTimeTimeZone;
		this.dateTimeZone = dateTimeZone;
		this.interaction = determineInteraction(messageId, templateIdsFromDocument, version, service, errors);
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
	
	private Interaction determineInteraction(String messageId, Set<String> templateIdsFromDocument, VersionNumber version, MessageDefinitionService service, Hl7Errors errors) {
		Interaction result = null;
		if (service.isCda(version)) {
			result = obtainCdaInteraction(templateIdsFromDocument, version,	service, errors);
		} else {
			result = obtainHl7v3Interaction(messageId, version, service, errors);
		}
		return result;
	}

	private Interaction obtainHl7v3Interaction(String messageId, VersionNumber version, MessageDefinitionService service, Hl7Errors errors) {
		Interaction result = service.getInteraction(version, messageId);
		if (result == null) {
			String message = MessageFormat.format("The interaction {0} for version {1} could not be found (and is possibly not supported). Please ensure an appropriate version code has been provided.", messageId, version);
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.UNSUPPORTED_INTERACTION, message, (String) null));
		}
		return result;
	}

	private Interaction obtainCdaInteraction(Set<String> templateIdsFromDocument, VersionNumber version, MessageDefinitionService service, Hl7Errors errors) {
		Interaction baseModel = null;
		Interaction firstInteractionMatch = null;
		
		Set<String> parentTemplateIds = new HashSet<String>();
		Map<String, Interaction> candidateInteractions = new HashMap<String, Interaction>();
		for (Interaction matchingInteraction : service.getAllInteractions(version)) {
			String templateId = matchingInteraction.getTemplateId();
			if (templateIdsFromDocument.contains(templateId)) { 
				if (firstInteractionMatch == null) {
					// first matching interaction will not necessarily be the first templateId in the document
					firstInteractionMatch = matchingInteraction;
				}
				candidateInteractions.put(templateId, matchingInteraction);
				String parentTemplateId = matchingInteraction.getParentTemplateId();
				if (parentTemplateId != null) {
					parentTemplateIds.add(parentTemplateId);
				}
			} else if (templateId == null) {
				baseModel = matchingInteraction;
			}
		}

		for (Iterator<Map.Entry<String, Interaction>> iterator = candidateInteractions.entrySet().iterator(); iterator.hasNext(); ) {
			Map.Entry<String, Interaction> entry = iterator.next();
			if (parentTemplateIds.contains(entry.getKey())) {
				iterator.remove();
			}
		}
		 
		return determineSuitableInteraction(candidateInteractions, baseModel, firstInteractionMatch, version, errors);
	}

	private Interaction determineSuitableInteraction(Map<String, Interaction> candidateInteractions, Interaction baseModel, Interaction firstInteractionMatch, VersionNumber version, Hl7Errors errors) {
		Interaction result = null;
		if (candidateInteractions.isEmpty()) {
			// use base model; there will be an error if the base model was not found
			result = baseModel;
			if (baseModel == null) {
				String versionLiteral = version == null ? "(none provided)" : version.getVersionLiteral();
				String message = MessageFormat.format("No document model could be identified based on the supplied templateIds, and no base model could be found. Please ensure an appropriate version code has been provided. (version={0})", versionLiteral, result.getTemplateId(), result.getName());
				errors.addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR, Hl7ErrorLevel.ERROR, message, (String) null));
			}
		} else if (candidateInteractions.size() == 1) {
			// this should be the normal case
			result = candidateInteractions.values().iterator().next();						
		} else {  
			// more than one interaction matched; error, and use "first" matching interaction
			result = firstInteractionMatch;
			String message = MessageFormat.format("Unable to determine the most suitable templateId to use. A suitable templateId has been arbitrarily chosen: {0} ({1})", result.getTemplateId(), result.getName());
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR, Hl7ErrorLevel.WARNING, message, (String) null));
		}
		
		if (result != null) {
			String message = MessageFormat.format("Document being parsed using templateId {0} ({1})", result.getTemplateId(), result.getName());
			errors.addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_TEMPLATE_CHOSEN, Hl7ErrorLevel.INFO, message, (String) null));
		}
		return result;
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
