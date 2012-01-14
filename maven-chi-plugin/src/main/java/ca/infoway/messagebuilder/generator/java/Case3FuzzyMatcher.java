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

import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MINOR_DIFFERENCE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3FuzzyMatcher extends Case3Matcher {

	
	protected final Case3MergeResult mergeResult;
	private final Matcher matcher;
	protected final LogUI log;
	private final Fuzziness fuzziness;

	public Case3FuzzyMatcher(LogUI log, SimplifiableTypeProvider definitions, ClusterProvider clusterProvider, Case3MergeResult result, Fuzziness fuzziness) {
		super(log, definitions, clusterProvider);
		this.log = log;
		this.mergeResult = result;
		this.fuzziness = fuzziness;
		this.matcher = new Matcher(this.mergeResult);
	}

	public boolean performMatching(SimplifiableType type, List<SimplifiableType> types) {
		List<SimplifiableType> matches = new ArrayList<SimplifiableType>();
		if (!isTransitiveTemplateType(type)) {
			for (SimplifiableType otherType : types) {
				if (type.getName().equals(otherType.getName())) {
					// skip it
				} else if (!this.fuzziness.isWorthChecking(type, otherType)) {
					// skip it
				} else if (this.mergeResult.isUnmergeable(type, otherType)) {
					// skip it
				} else if (type.isTemplateType() != otherType.isTemplateType()) {
					// skip it
				} else if (otherType.isTemplateType() && isTransitiveTemplateType(otherType)) {
					// skip it
				} else if (!isExactOrMinor(new NameMatcher().matchNames(type, otherType))) {
					// skip it
				} else if (type.isAbstract() && otherType.isAbstract()) {
					if (isSameSetOfSpecializations(type, otherType)) {
						if (matches.isEmpty()) {
							matches.add(type);
						}
						matches.add(otherType);
					}
				} else if (type.isAbstract() || otherType.isAbstract()) {
					// skip it
				} else if (isOverlappingSetOfRelationships(type, otherType)) {
					if (isMergeable(matches, otherType)) {
						if (matches.isEmpty()) {
							matches.add(type);
						}
						
						matches.add(otherType);
					}
				}
			}
		}
		
		return performFinalMatchChecks(type, matches);
	}

	boolean performFinalMatchChecks(SimplifiableType type,
			List<SimplifiableType> matches) {
		if (!matches.isEmpty() && type.isAbstract()) {
			return recordAllMatches(matches);
		} else if (!matches.isEmpty() && isAllMatchesCompatible(matches)) {
			return recordAllMatches(matches);
		} else {
			return false;
		}
	}
	
	private boolean isSameSetOfSpecializations(SimplifiableType type,
			SimplifiableType otherType) {
		if (!type.getRelationships().isEmpty() || !otherType.getRelationships().isEmpty()) {
			return false;
		} else {
			Set<String> childTypes = getTranslatedChildTypes(type);
			Set<String> otherChildTypes = getTranslatedChildTypes(type);
			
			if (childTypes.size() == otherChildTypes.size() && childTypes.containsAll(otherChildTypes)) {
				return true;
			} else {
				this.log.log(LogLevel.DEBUG, "Child types of " + type.getName() 
						+ " " + childTypes + " and "
						+ otherType.getName() + " " 
						+ otherChildTypes + " do not match");
				return false;
			}
		}
	}

	private Set<String> getTranslatedChildTypes(SimplifiableType type) {
		Set<String> result = new HashSet<String>();
		Set<TypeName> childTypes = type.getChildTypes();
		
		for (TypeName typeName : childTypes) {
			MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(typeName);
			if (descriptor == null) {
				result.add(typeName.getName());
			} else {
				result.add(descriptor.getNewName().getName());
			}
		}
		
		return result;
	}

	private boolean isTransitiveTemplateType(SimplifiableType type) {
		if (!type.isTemplateType()) {
			return false;
		} else {
			boolean result = false;
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (relationship.isTemplateType() && !relationship.isTemplateParameterPresent()) {
					result = true;
					break;
				}
			}
			return result;
		}
	}

	private boolean isTemplateType(SimplifiableType type) {
		return type.isTemplateType();
	}

	private boolean isMergeable(List<SimplifiableType> matches, SimplifiableType otherType) {
		boolean unmergeable = false;
		for (SimplifiableType type : matches) {
			unmergeable |= this.mergeResult.isUnmergeable(type, otherType);
		}
		return !unmergeable;
	}

	private boolean recordAllMatches(List<? extends NamedType> matches) {
		boolean result = false;
		NamedType previous = null;
		for (NamedType match : matches) {
			if (previous != null) {
				if (this.mergeResult.recordMatch(previous.getTypeName(), match.getTypeName())) {
					result = true;
					this.log.log(LogLevel.DEBUG, "(fuzzy) linking: " + previous.getTypeName() + " to " + match.getTypeName());
					this.log.log(LogLevel.DEBUG, "all types in merge: " + this.definitions.getType(previous.getTypeName().getName()).getMergedWithTypes());
				}
			}
			previous = match;
		}
		return result;
	}

	private boolean isAllMatchesCompatible(List<SimplifiableType> matches) {
		matches = createMergeList(matches);
		boolean result = true;
		while (!matches.isEmpty() && result) {
			SimplifiableType exemplar = matches.remove(0);
			for (SimplifiableType type : matches) {
				if (!this.mergeResult.isKnownMatch(exemplar, type)) {
					result &= isOverlappingSetOfRelationships(exemplar, type);
				}
				if (!result) {
					this.log.log(LogLevel.INFO, "Not all matches are compatible in this list: " + matches);
					this.log.log(LogLevel.INFO, "Incompatability found between " + exemplar + " and " + type);
					break;
				}
			}
		}
		return result;
	}
	
	// need to consolidate both the cluster, and everything that 
	// items in the cluster have previously merged with.
	private List<SimplifiableType> createMergeList(List<SimplifiableType> matches) {
		HashMap<TypeName,SimplifiableType> map = new HashMap<TypeName, SimplifiableType>();
		for (SimplifiableType type : matches) {
			map.put(type.getTypeName(), type);
			MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(type.getTypeName());
			if (descriptor != null) {
				for (TypeName existingMerges : descriptor.getMergedTypes()) {
					SimplifiableType otherType = this.definitions.getType(existingMerges.getName());
					if (otherType != null) {
						map.put(existingMerges, otherType);
					} else {
						this.log.log(LogLevel.WARN, "No type found for " + existingMerges);
					}
				}
			}
		}
		
		return new ArrayList<SimplifiableType>(map.values());
	}
	
	private boolean isOverlappingSetOfRelationships(SimplifiableType type, SimplifiableType otherType) {
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		checkRelationships(type, otherType, matchTypes, MatchType.ADDED);
		checkRelationships(otherType, type, matchTypes, MatchType.REMOVED);
		
		return this.fuzziness.isSufficientOverlap(matchTypes);
	}
	
	private String describe(NamedType type, Named relationship) {
		return type.getTypeName().getName() + "." + (relationship == null ? "?" : relationship.getName());
	}
	
	private void checkRelationships(SimplifiableType type, SimplifiableType otherType, List<MatchType> matchTypes, MatchType missingMatchType) {
		for (SimplifiableRelationship relationship : type.getRelationships()) {
			MatchType matchType = MatchType.EXACT;
			SimplifiableRelationship otherRelationship = otherType.getRelationshipByFingerprint(relationship.getFingerprint(type.getTypeName()));
			
			if (otherRelationship != null) {
				if (!StringUtils.equals(relationship.getName(), otherRelationship.getName())) {
					this.log.log(LogLevel.DEBUG, "Relationship " + describe(type, relationship) + 
							" and " + describe(otherType, otherRelationship) + " looks like a renamed relationship");
					matchTypes.add(MatchType.RENAMED);
				} else if (relationship.isTemplateParameterPresent() && otherRelationship.isTemplateParameterPresent()) {
					matchTypes.add(MatchType.EXACT);
				} else {
					matchTypes.add(matchType =
						this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship()));
				}
			} else if (hasNameCollision(otherType, relationship)) {
				matchTypes.add(matchType =MatchType.MAJOR_DIFFERENCE);
			} else if (relationship.isTemplateType() || isTemplateAssociationType(relationship)) {
				matchTypes.add(matchType =MatchType.MAJOR_DIFFERENCE);
			} else {
				// TODO: BCH: Should we search by business name?
				matchTypes.add(matchType = missingMatchType);
			}
			this.log.log(LogLevel.DEBUG, "comparing " + describe(type, relationship) + 
					" with " + describe(otherType, otherRelationship) + " : match type = " 
					+ matchType);
		}
	}

	boolean hasNameCollision(SimplifiableType otherType, SimplifiableRelationship relationship) {
		return otherType.getRelationship(relationship.getName()) != null;
	}
	
	private boolean isTemplateAssociationType(SimplifiableRelationship relationship) {
		return relationship.isAssociation() 
				&& relationship.getType() != null
				&& isTemplateType(relationship.getType());
	}

	private boolean isExactOrMinor(MatchType matchType) {
		return matchType == EXACT || matchType == MINOR_DIFFERENCE;
	}

	public String getDescription() {
		return "Looking for approximate matches between types (" + this.fuzziness + ")";
	}
}
