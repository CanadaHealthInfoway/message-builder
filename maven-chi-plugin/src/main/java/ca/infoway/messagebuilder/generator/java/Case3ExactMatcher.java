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

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3ExactMatcher extends Case3Matcher {
	
	private final Case3MergeResult mergeResult;
	private Matcher matcher;
	private final LogUI log;
	
	Case3ExactMatcher(LogUI log, SimplifiableTypeProvider definitions, ClusterProvider clusterProvider, Case3MergeResult mergeResult) {
		super(log, definitions, clusterProvider);
		this.log = log;
		this.mergeResult = mergeResult;
		this.matcher = new Matcher(this.mergeResult);
	}

	boolean performMatching(SimplifiableType type, List<SimplifiableType> types) {
		boolean somethingMatched = false;
		for (SimplifiableType otherType : types) {
			if (type.getTypeName().equals(otherType.getTypeName())) {
				// skip it
			} else if (this.mergeResult.isKnownMatch(type, otherType)) {
				// Skip it.  We already know about it
			} else if (matchType(type, otherType) == MatchType.EXACT) {
				if (this.mergeResult.recordMatch(type, otherType)) {
					somethingMatched = true;
					this.log.log(LogLevel.DEBUG, "(exact) linking: " + type.getTypeName() + " to " + otherType.getTypeName());
					this.log.log(LogLevel.DEBUG, "all types in merge: " + this.definitions.getType(type.getTypeName().getName()).getMergedWithTypes());
				}
			}
		}
		return somethingMatched;
	}
	private MatchType matchType(SimplifiableType type, SimplifiableType otherType) {
		MatchType result = type.getRelationships().size() == otherType.getRelationships().size() ?
				MatchType.EXACT : MatchType.MAJOR_DIFFERENCE;
		if (this.mergeResult.isUnmergeable(type, otherType)) {
			result = MatchType.REPRESENTS_DIFFERENT_CHOICES;
		} else if (result == MatchType.EXACT && type.getMessagePart().isAbstract()) {
			result = matchesAbstractType(type, otherType);
		}
		
		if (result == MatchType.EXACT) {
			result = new NameMatcher().matchNames(type, otherType);
		}
		
		if (result == MatchType.EXACT) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				result = matchRelationship(otherType, relationship);
				
				if (result != MatchType.EXACT) {
					break;
				}
			}
		}
		return result;
	}
	
	private MatchType matchesAbstractType(SimplifiableType type, SimplifiableType otherType) {
		boolean match = type.getChildTypes().size() == otherType.getChildTypes().size();
		if (match) {
			Set<TypeName> convertedTypes = convertTypes(type.getChildTypes());
			Set<TypeName> otherConvertedTypes = convertTypes(otherType.getChildTypes());
			match = convertedTypes.containsAll(otherConvertedTypes) &&
					otherConvertedTypes.containsAll(convertedTypes);
		}
		return match ? MatchType.EXACT : MatchType.MAJOR_DIFFERENCE;
	}
	
	private Set<TypeName> convertTypes(Set<TypeName> typeNames) {
		Set<TypeName> result = new HashSet<TypeName>();
		for (TypeName typeName : typeNames) {
			MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(typeName);
			if (descriptor == null) {
				result.add(typeName);
			} else {
				result.add(descriptor.getNewName());
			}
		}
		return result;
	}

	protected MatchType matchRelationship(Type otherType, BaseRelationship relationship) {
		BaseRelationship otherRelationship = otherType.getRelationship(relationship.getName());
		if (otherRelationship == null) {
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship());
		}
	}

	protected MatchType matchRelationship(SimplifiableType otherType, SimplifiableRelationship relationship) {
		SimplifiableRelationship otherRelationship = otherType.getRelationship(relationship.getName());
		if (otherRelationship == null) {
			return MatchType.MAJOR_DIFFERENCE;
		} else {
			return this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship());
		}
	}
	
	public String getDescription() {
		return "Looking for exact matches between types";
	}
}
