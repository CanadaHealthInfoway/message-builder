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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Hl7TypeName;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;
import ca.infoway.messagebuilder.xml.util.MessageSetUtils;


public class MessageSetValidator {

	private enum ErrorLevel {
		ERROR, WARNING, INFO
	}

	private enum ErrorType {
		TYPE_NOT_FOUND, INVALID_CARDINALITY, CHECK_WILDCARD_CARDINALITY, INVALID_CONFORMANCE, VERIFY_CONFORMANCE, UNSUPPORTED_DATATYPE, DATATYPE_REQUIRES_COLLECTION_WRAPPER,
		DOMAIN_SHOULD_NOT_BE_PROVIDED, DOMAIN_MUST_BE_PROVIDED, POSSIBLY_INCORRECT_DOMAIN_NAME, DOMAIN_TYPE_NOT_IN_MB, ORPHANED_MESSAGE_PARTS, INTERACTION_ARGUMENTS_MISMATCH, 
		MUST_HAVE_AT_LEAST_2_CHOICES
	}
	
	public class MessageSetValidatorError {
		public final ErrorLevel errorLevel;
		public final ErrorType errorType;
		public final String messagePart;
		public final String relationship;
		public final String description;
		public final String value;
		
		public MessageSetValidatorError(ErrorLevel errorLevel, ErrorType errorType, String messagePart, String relationship, String description) {
			this(errorLevel, errorType, messagePart, relationship, description, null);
		}
		
		public MessageSetValidatorError(ErrorLevel errorLevel, ErrorType errorType, String messagePart, String relationship, String description, String value) {
			this.errorLevel = errorLevel;
			this.errorType = errorType;
			this.messagePart = messagePart;
			this.relationship = relationship;
			this.description = description;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return this.errorLevel + ": " + this.errorType +"\n" +
					this.messagePart + (relationship == null ? "": "." + this.relationship) + "\n" +
					this.description + (value == null ? "" : " (" + value + ")");
		}
	}
	
	private class MessageSetValidatorErrorComparator implements Comparator<MessageSetValidatorError> {
		@Override
		public int compare(MessageSetValidatorError o1, MessageSetValidatorError o2) {
			return new CompareToBuilder()
			.append(o1.errorLevel, o2.errorLevel)
			.append(o1.errorType, o2.errorType)
			.append(o1.messagePart, o2.messagePart)
			.append(o1.relationship, o2.relationship)
			.toComparison();
		}
	}
	
	protected final MessageSet messageSet;
	private MessageSetUtils messageSetUtils;
	private Map<String, MessagePart> messagePartsByName;
	private MessageSetValidatorErrorComparator comparator = new MessageSetValidatorErrorComparator();

	public MessageSetValidator(MessageSet messageSet) {
		this.messageSet = messageSet;
		this.messageSetUtils = new MessageSetUtils(messageSet);
		this.messagePartsByName = new HashMap<String, MessagePart>();
		for (MessagePart messagePart : this.messageSetUtils.getAllMessageParts()) {
			this.messagePartsByName.put(messagePart.getName(), messagePart);
		}
	}
	
	public List<MessageSetValidatorError> validate() {
		return validate(ErrorLevel.WARNING);
	}
	
	public List<MessageSetValidatorError> validate(ErrorLevel logLevelMinimumToReport) {
		
		List<MessageSetValidatorError> results = new ArrayList<MessageSetValidatorError>();
		
		if (!this.messageSet.isCda()) {
			// Don't do this for CDA message sets - they contain cycles, so the recursion never stops
			for (Interaction interaction : this.messageSetUtils.getAllInteractions()) {
				validateInteraction(interaction, results);
			}
		}
		
		for (MessagePart messagePart : this.messageSetUtils.getAllMessageParts()) {
			validateMessagePart(messagePart, results);
		}
		
		checkForOrphanedParts(results);
		
		Collections.sort(results, this.comparator);
		
		Iterator<MessageSetValidatorError> iterator = results.iterator();
		while (iterator.hasNext()) {
			MessageSetValidatorError errorLog = iterator.next();
			if (errorLog.errorLevel == ErrorLevel.WARNING && logLevelMinimumToReport == ErrorLevel.ERROR) {
				iterator.remove();
			} else if (errorLog.errorLevel == ErrorLevel.INFO && logLevelMinimumToReport != ErrorLevel.INFO) {
				iterator.remove();
			}
		}
		
		return results;
	}

	private void validateInteraction(Interaction interaction, List<MessageSetValidatorError> results) {
		// look for mismatching arguments
		checkArgumentsMatch(interaction.getSuperTypeName(), interaction.getArguments(), results, interaction.getName());
		checkArgumentsCount(interaction.getSuperTypeName(), interaction.getArguments(), results, interaction.getName());
	}
	
	private void checkArgumentsCount(String messagePartName, List<Argument> arguments, List<MessageSetValidatorError> results, String interactionName) {
		int numArgs = arguments.size();
		int numTemplates = countTemplates(messagePartName);
		
		if (numArgs != numTemplates) {
			logError(results, ErrorType.INTERACTION_ARGUMENTS_MISMATCH, interactionName, messagePartName, "Number of arguments did not match up to number of template parameters", "Arguments specified: " + numArgs + " Template relationships found: " + numTemplates);
		}
		
		for (Argument argument : arguments) {
			if (!argument.getArguments().isEmpty()) {
				checkArgumentsCount(argument.getName(), argument.getArguments(), results, interactionName);
			}
		}
	}

	private int countTemplates(String messagePartName) {
		Set<String> partsAlreadyChecked = new HashSet<String>();
		return countTemplates(messagePartName, partsAlreadyChecked);
	}
	
	private int countTemplates(String messagePartName, Set<String> partsAlreadyChecked) {
		if (partsAlreadyChecked.contains(messagePartName)) {
			return 0;
		}
		partsAlreadyChecked.add(messagePartName);
		int count = 0;
		MessagePart messagePart = this.messageSetUtils.getMessagePart(messagePartName);
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAssociation()) {
				if (relationship.isTemplateRelationship()) {
					count++;
				} else {
					count += countTemplates(relationship.getType(), partsAlreadyChecked);
				}
			}
		}
		return count;
	}

	private void checkArgumentsMatch(String containingPart, List<Argument> arguments, List<MessageSetValidatorError> results, String interactionName) {
		// for each argument, need to find a corresponding template relationship nested within the supertype or the argument supertype
		MessagePart messagePart = this.messageSetUtils.getMessagePart(containingPart);
		for (Argument argument : arguments) {
			if (!findTemplateRelationship(argument, messagePart)) {
				logError(results, ErrorType.INTERACTION_ARGUMENTS_MISMATCH, interactionName, argument.getTemplateParameterName(), "Argument parameter not found within containing type", containingPart);
			}
			checkArgumentsMatch(argument.getName(), argument.getArguments(), results, interactionName);
		}
	}
	
	private boolean findTemplateRelationship(Argument argument, MessagePart containingMessagePart) {
		for (Relationship relationship : containingMessagePart.getRelationships()) {
			if (relationship.isAssociation()) {
				if (relationship.isTemplateRelationship() && relationship.getTemplateParameterName().equals(argument.getTemplateParameterName())) {
					return true;
				} else if (!relationship.isTemplateRelationship()) {
					MessagePart nestedMessagePart = this.messageSetUtils.getMessagePart(relationship.getType());
					if (findTemplateRelationship(argument, nestedMessagePart)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void validateMessagePart(MessagePart messagePart, List<MessageSetValidatorError> results) {
		List<Relationship> relationships = messagePart.getRelationships();
		for (Relationship relationship : relationships) {
			validateRelationship(relationship, results);
		}

		// check abstract version specializationChilds
		List<SpecializationChild> specializationChilds = messagePart.getSpecializationChilds();
		for (SpecializationChild specializationChild : specializationChilds) {
			String name = specializationChild.getName();
			if (this.messageSetUtils.getMessagePart(name) == null) {
				logError(results, ErrorType.TYPE_NOT_FOUND, messagePart.getName(), null, "could not locate specialization child type", "Missing type: " + name);
			}
		}
	}

	private void validateRelationship(Relationship relationship, List<MessageSetValidatorError> results) {
		
		validateCardinalityAndConformance(relationship, results);
		
		if (relationship.isAttribute()) {
			validateAttribute(relationship, results);
		}
		
		if (relationship.isAssociation()) {
			validateAssociation(relationship, results);
		}
		
	}

	private void validateCardinalityAndConformance(Relationship relationship, List<MessageSetValidatorError> results) {
		String relName = relationship.getName();
		String parentType = relationship.getParentType();

		// check cardinality
		Integer min = relationship.getCardinality().getMin();
		Integer max = relationship.getCardinality().getMax();
		String cardinality = relationship.getCardinality().toString();
		
		if (min > max || min < 0 || max < 0 || max == 0) {
			logError(results, ErrorType.INVALID_CARDINALITY, parentType, relName, "invalid cardinality detected", "cardinality: " + cardinality);
		} else if (cardinality.contains("*")) {
			logInfo(results, ErrorType.CHECK_WILDCARD_CARDINALITY, parentType, relName, "while valid, use of wildcards for cardinality should be avoided", "cardinality: " + cardinality);
		}
		
		// check conformance
		//ConformanceLevel conformance = relationship.getConformance();
		if ((ConformanceLevelUtil.isMandatory(relationship) && min == 0) || (ConformanceLevelUtil.isPopulated(relationship) && min == 0)) {
			logError(results, ErrorType.INVALID_CONFORMANCE, parentType, relName, "Mandatory and Populated relationships must have minimum cardinality > 0", "cardinality: " + cardinality);
		}
		if (ConformanceLevelUtil.isOptional(relationship) && min > 0) {
			logError(results, ErrorType.INVALID_CONFORMANCE, parentType, relName, "Optional relationships must have minimum cardinality = 0", "cardinality: " + cardinality);
		} else if (ConformanceLevelUtil.isRequired(relationship) && min > 0) {
			// MB allows for REQUIRED and min > 0, but treats it as POPULATED
			logInfo(results, ErrorType.VERIFY_CONFORMANCE, parentType, relName, "Required generally has minimum cardinality = 0, but Message Builder allows this case and treats it as Populated", "cardinality: " + cardinality);
		}
	}

	private void validateAttribute(Relationship relationship, List<MessageSetValidatorError> results) {
		String relName = relationship.getName();
		String parentType = relationship.getParentType();
		Integer max = relationship.getCardinality().getMax();
		
		// check datatype - must be collection type if multiple attribute
		boolean validType = isTypeValid(relationship.getType());
		if (!validType) {
			logError(results, ErrorType.UNSUPPORTED_DATATYPE, parentType, relName, "Unsupported datatype detected", "datatype: " + relationship.getType());
		} else if (max > 1 && !(isCollection(relationship.getType()))) {
			logError(results, ErrorType.DATATYPE_REQUIRES_COLLECTION_WRAPPER, parentType, relName, "Datatype has multiple cardinality and must be wrapped by collection datatype", "datatype: " + relationship.getType());
		}
		
		String domain = relationship.getDomainType();
		if (validType && StringUtils.isNotBlank(domain)) {
			if (isCoded(relationship.getType())) {
				if (isSuspectDomainType(domain)) {
					logWarning(results, ErrorType.POSSIBLY_INCORRECT_DOMAIN_NAME, parentType, relName, "Detected a possibly incorrect or badly named domain type", domain);
				} else {
					String domainClass = "ca.infoway.messagebuilder.domainvalue." + domain;
					try {
						Class.forName(domainClass);
					} catch (Throwable e) {
						// MB has a couple of legacy exceptions (which should perhaps be removed...): "HealthCareProviderRoleType", "OtherIDsRoleCode" 
						logInfo(results, ErrorType.DOMAIN_TYPE_NOT_IN_MB, parentType, relName, "Domain not found in MB and interface will be generated; should verify name is acceptable", domain);
					}
				}
			} else {
				logError(results, ErrorType.DOMAIN_SHOULD_NOT_BE_PROVIDED, parentType, relName, "Domains should only be provided for coded types", "Type: " + relationship.getType() + " - domain: " + domain);
			}
		}
		
		if (!isCda() && validType && isCoded(relationship.getType()) && StringUtils.isBlank(domain)) {
			logError(results, ErrorType.DOMAIN_MUST_BE_PROVIDED, parentType, relName, "Domains must be provided for coded types", "Type: " + relationship.getType());
		}
	}

	private boolean isCda() {
		return this.messageSet.isCda();
	}

	private void validateAssociation(Relationship relationship, List<MessageSetValidatorError> results) {
		String relName = relationship.getName();
		String parentType = relationship.getParentType();

		// check association type exists
		if (!relationship.isTemplateRelationship()) {
			String type = relationship.getType();
			if (this.messageSetUtils.getMessagePart(type) == null) {
				logError(results, ErrorType.TYPE_NOT_FOUND, parentType, relName, "could not locate association type", "Missing type: " + type);
			}
		}
		if (relationship.isChoice()) {
			List<Relationship> choices = relationship.getChoices();
			if (choices.size() <= 1) {
				logError(results, ErrorType.MUST_HAVE_AT_LEAST_2_CHOICES, parentType, relName, "choice relationships must have at least two choices", "Number of choice relationships: " + choices.size());
			}
			for (Relationship choiceRelationship : choices) {
				String type = choiceRelationship.getType();
				if (this.messageSetUtils.getMessagePart(type) == null) {
					logError(results, ErrorType.TYPE_NOT_FOUND, parentType, choiceRelationship.getName(), "could not locate choice type", "Missing type: " + type);
				}
			}
		}
	}

	private boolean isSuspectDomainType(String domain) {
		return (Character.isLowerCase(domain.charAt(0)) && !domain.startsWith("x_")) 
				|| domain.equals(StringUtils.upperCase(domain))
				|| domain.contains(" ");
	}

	protected boolean isTypeValid(String type) {
		boolean result = (StandardDataType.getByTypeName(type) != null);
		if (result && isCollection(type)) {
			// also check the parameter type
			Hl7TypeName typeName = Hl7TypeName.parse(type);
			result = (StandardDataType.getByTypeName(typeName.getParameters().get(0).toString()) != null);
		}
		return result;
	}

	private boolean isCoded(String type) {
		StandardDataType actualType = StandardDataType.getByTypeName(type);
		if (isCollection(type)) {
			Hl7TypeName typeName = Hl7TypeName.parse(type);
			List<Hl7TypeName> parameters = typeName.getParameters();
			if (parameters.size() == 1) {
				Hl7TypeName innerType = parameters.get(0);
				actualType = StandardDataType.getByTypeName(innerType.getRootName());
			}
		}
		return actualType.isCoded();
	}

	protected boolean isCollection(String type) {
		return StandardDataType.isSetOrList(type) || StandardDataType.isCollection(type);
	}

	private void checkForOrphanedParts(List<MessageSetValidatorError> results) {
		Map<String, MessagePart> findAllOrphanedMessageParts = new OrphanedMessagePartFinder(this.messageSet).findAllOrphanedMessageParts();
		
		String packageLocation = null;
		String allParts = "";
		for (String orphanedPart : findAllOrphanedMessageParts.keySet()) {
			int dotIndex = orphanedPart.indexOf('.');
			String newPackageLocation = orphanedPart.substring(0, dotIndex);
			if (packageLocation == null) {
				packageLocation = newPackageLocation;
			}
			if (!packageLocation.equals(newPackageLocation)) {
				// write out warning
				logWarning(results, ErrorType.ORPHANED_MESSAGE_PARTS, packageLocation, null, "Package location (including message parts within) is not referenced by any interaction (directly or indirectly) and will never be used", "Message parts:" + allParts);
				
				packageLocation = newPackageLocation;
				allParts = "";
			}
			allParts += " " + orphanedPart.substring(dotIndex + 1);
		}
		
	}
	
	private void logError(List<MessageSetValidatorError> results, ErrorType errorType, String messagePart, String relationship, String description, String value) {
		logIssue(results, ErrorLevel.ERROR, errorType, messagePart, relationship, description, value);
	}
	
	private void logWarning(List<MessageSetValidatorError> results, ErrorType errorType, String messagePart, String relationship, String description, String value) {
		logIssue(results, ErrorLevel.WARNING, errorType, messagePart, relationship, description, value);
	}
	
	private void logInfo(List<MessageSetValidatorError> results, ErrorType errorType, String messagePart, String relationship, String description, String value) {
		logIssue(results, ErrorLevel.INFO, errorType, messagePart, relationship, description, value);
	}
	
	private void logIssue(List<MessageSetValidatorError> results, ErrorLevel errorLevel, ErrorType errorType, String messagePart, String relationship, String description, String value) {
		results.add(new MessageSetValidatorError(errorLevel, errorType, messagePart, relationship, description, value));
	}
	
}
