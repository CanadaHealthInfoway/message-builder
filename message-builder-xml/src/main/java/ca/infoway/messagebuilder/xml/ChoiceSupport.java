/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * <p>A base class for types that support choices.  
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public abstract class ChoiceSupport {

	/**
	 * <p>Find a specific choice based on some matching strategy defined by the predicate.
	 * 
	 * @param predicate - a class that determines the matching strategy of the choice.
	 * @return the selected choice.
	 */
	public Relationship findChoiceOption(Predicate<Relationship> predicate) {
		return findChoiceOption(predicate, getChoices());
	}
	
	private static Relationship findChoiceOption(Predicate<Relationship> predicate, List<Relationship> choices) {
		Relationship result = null;
		for (Relationship option : choices) {
			if (option.isChoice()) {
				result = option.findChoiceOption(predicate);
			} else if (predicate.apply(option)) {
				result = option;
			}
			
			if (result != null) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * <p>Get the list of choices.
	 * @return the list of choices.
	 */
	public abstract List<Relationship> getChoices();

	/**
	 * <p>A convenience utility to create a predicate that finds a specific choice based
	 * on the name of the XML element.
	 * 
	 * @param relationshipName - the name of the XML element on the incoming message
	 * @return the corresponding choice.
	 */
	public static Predicate<Relationship> choiceOptionNamePredicate(final String relationshipName) {
		return new ChoiceOptionNamePredicateClass(relationshipName); 
	}

	static class ChoiceOptionNamePredicateClass implements Predicate<Relationship> {
		private final String relationshipName;
		public ChoiceOptionNamePredicateClass(String relationshipName) {
			this.relationshipName = relationshipName;
		}
		public boolean apply(Relationship option) {
			return option.getName().equals(relationshipName);
		}		
	}
	
	/**
	 * <p>A convenience utility to create a predicate that finds a specific choice based
	 * on the part type (or part types).
	 * 
	 * @param relationshipTypes - the part types (typically taken from a part type mapping)
	 * @return the corresponding choice.
	 */
	public static Predicate<Relationship> choiceOptionTypePredicate(final String[] relationshipTypes) {
		return new ChoiceOptionTypePredicateClass(relationshipTypes); 
	}
	
	static class ChoiceOptionTypePredicateClass implements Predicate<Relationship> {
		private final String[] relationshipTypes;
		ChoiceOptionTypePredicateClass(String[] relationshipTypes) {
			this.relationshipTypes = relationshipTypes;
		}
		public boolean apply(Relationship option) {
			boolean result = false;
			for (String relationshipType : relationshipTypes) {
				if (StringUtils.equals(option.getType(), relationshipType) 
						|| MessagePartVersionSuffixHelper.matchesDisregardingVersionSuffix(option.getType(), relationshipType)) {
					result = true;
					break;
				}
			}

			return result;
		}		
	}
}
