/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.multiplemessageset.ExcisionEvaluator;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

class PostSimplificationEvaluator implements ExcisionEvaluator {

	private final SimplifiableDefinitions definitions;
	private final LogUI log;

	public PostSimplificationEvaluator(SimplifiableDefinitions definitions, LogUI log) {
		this.definitions = definitions;
		this.log = log;
	}
	
	
	/**
	 * <p>There are no post-simplification situations that 
	 * cause us to directly remove interactions
	 */
	public boolean shouldRemove(Interaction interaction) {
		return false;
	}

	public boolean shouldRemove(MessagePart messagePart) {
		if (containsNoInterestingDifferences(messagePart)) {
			return false;
		} else { 
			return containsDifferencesThatHasNotBeenRectified(messagePart);
		}
	}

	boolean containsDifferencesThatHasNotBeenRectified(MessagePart messagePart) {
		boolean result = false;
		for (Relationship relationship : messagePart.getRelationships()) {
			result |= hasTypeThatDidNotMerge(relationship, DifferenceType.ASSOCIATION_TYPE);
			result |= hasChoiceThatDidNotMerge(relationship.getChoices());
			if (result) {
				break;
			}
		}
		return result;
	}

	private boolean hasChoiceThatDidNotMerge(List<Relationship> choices) {
		boolean result = false;
		for (Relationship relationship : choices) {
			result |= hasTypeThatDidNotMerge(relationship, DifferenceType.CHOICE_RELATIONSHIP_TYPE);
			result |= hasChoiceThatDidNotMerge(relationship.getChoices());
			if (result) {
				break;
			}
		}
		return result;
	}


	private boolean hasTypeThatDidNotMerge(Relationship relationship, DifferenceType differenceType) {
		boolean result = false;
		Set<String> mergeTypes = getRequiredMergeTypes(relationship, differenceType);
		if (!mergeTypes.isEmpty()) {
			result |= hasTypeThatDidNotMerge(mergeTypes);
		}
		return result;
	}


	private boolean hasTypeThatDidNotMerge(Set<String> mergeTypes) {
		SimplifiableType type = this.definitions.getType((String) CollectionUtils.get(mergeTypes, 0));
		Set<String> someSet = new HashSet<String>();
		someSet.add(type.getName());
		for (SimplifiableType merge : type.getMergedWithTypes()) {
			someSet.add(merge.getName());
		}
		for (String temp : mergeTypes) {
			if (!someSet.contains(temp)) {
				this.log.log(LogLevel.INFO, "Type " + temp + " does not appear to have successfully merged.");
			}
		}
		boolean result = someSet.containsAll(mergeTypes);
		if (result) {
			this.log.log(LogLevel.INFO, "The following items successfully merged: "+ mergeTypes);
		} else {
			this.log.log(LogLevel.INFO, "The following items should be merged, but did not: "+ mergeTypes);
		}
		return !result;
	}

	private Set<String> getRequiredMergeTypes(Relationship relationship, DifferenceType differenceType) {
		Set<String> result = new HashSet<String>();
		if (DifferenceHelper.hasDifferenceOfType(relationship, differenceType)) {
			Difference difference = DifferenceHelper.getDifferenceByType(relationship, differenceType);
			for (DifferenceValue value : difference.getDifferences()) {
				result.add(value.getValue());
			}
		}
		return result;
	}

	boolean containsNoInterestingDifferences(MessagePart messagePart) {
		return hasNoInterestingDifferences(messagePart.getRelationships());
	}

	private boolean hasNoInterestingDifferences(List<Relationship> relationships) {
		boolean result = true;
		for (Relationship relationship : relationships) {
			result &= hasNoProblematicDifferences(relationship);
			if (result) {
				result &= hasNoInterestingDifferences(relationship.getChoices());
			}
			if (!result) {
				break;
			}
		}
		return result;
	}

	private boolean hasNoProblematicDifferences(HasDifferences differences) {
		boolean result = true;
		for (Difference difference : differences.getDifferences()) {
			result &= (difference.getMatchConfidence() == null);
			if (!result) {
				break;
			}
		}
		return result;
	}

	/**
	 * <p>There are no post-simplification situations that 
	 * cause us to directly remove package locations
	 */
	public boolean shouldRemove(PackageLocation packageLocation) {
		return false;
	}
}
