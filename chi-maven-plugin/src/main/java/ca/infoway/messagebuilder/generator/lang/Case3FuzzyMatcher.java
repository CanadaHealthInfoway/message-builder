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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.util.MatchType.MINOR_DIFFERENCE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.NamedType;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.util.MatchType;
import ca.infoway.messagebuilder.generator.util.NameMatcher;
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
				} else if (type.isRootType() || otherType.isRootType()) {
					// skip it
					this.log.log(LogLevel.DEBUG, "Types prohibited from fuzzy merge: one/both are root types: " + type.getName() + " " + otherType.getName());
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
	
	private boolean isSameSetOfSpecializations(SimplifiableType type, SimplifiableType otherType) {
		if (type.getRelationships().isEmpty() || otherType.getRelationships().isEmpty()) {
			return false;
		} else {
			Set<String> childTypes = getTranslatedChildTypes(type);
			Set<String> otherChildTypes = getTranslatedChildTypes(otherType);
			
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
		int matchingAssociations = checkRelationships(type, otherType, matchTypes, MatchType.ADDED);
		checkRelationships(otherType, type, matchTypes, MatchType.REMOVED);
		
		// TM  - to improve quality of merge candidates, to match must first have sufficient overlap, THEN
		//    1) must have at least one association in common
		// OR 2) must share a root type name that *isn't* Component# or Subject# (where # is a number, or blank)
		
		return this.fuzziness.isSufficientOverlap(matchTypes) && (matchingAssociations > 0 || isRootTypeNameMatch(type.getName(), otherType.getName()));
	}
	
	private boolean isRootTypeNameMatch(String name1, String name2) {
		name1 = StringUtils.substringAfterLast(name1, ".");
		name2 = StringUtils.substringAfterLast(name2, ".");
		
		if (StringUtils.isBlank(name1) || StringUtils.isBlank(name2)) {
			return false;
		}
		
		String rootName1 = name1.replaceAll("\\d*$", "");
		String rootName2 = name2.replaceAll("\\d*$", "");
		// unfortunately, HL7v3/CDA models use Component and Subject generically, so we should almost never allow these types to merge
		return rootName1.equals(rootName2) && !"Component".equals(rootName1) && !"Subject".equals(rootName1);
	}
	
	private String describe(NamedType type, Named relationship) {
		return type.getTypeName().getName() + "." + (relationship == null ? "?" : relationship.getName());
	}
	
	private int checkRelationships(SimplifiableType type, SimplifiableType otherType, List<MatchType> matchTypes, MatchType missingMatchType) {
		int countMatchingAssociations = 0;
		for (SimplifiableRelationship relationship : type.getRelationships()) {
			MatchType matchType = MatchType.EXACT;
			SimplifiableRelationship otherRelationship = otherType.getRelationshipByFingerprint(relationship.getFingerprint(type.getTypeName()));
			
			if (otherRelationship != null) {
				if (!StringUtils.equals(relationship.getName(), otherRelationship.getName())) {
					this.log.log(LogLevel.DEBUG, "Relationship " + describe(type, relationship) + 
							" and " + describe(otherType, otherRelationship) + " looks like a renamed relationship");
					matchTypes.add(matchType = MatchType.RENAMED);
				} else if (relationship.isTemplateParameterPresent() && otherRelationship.isTemplateParameterPresent()) {
					matchTypes.add(matchType = MatchType.EXACT);
				} else {
					matchTypes.add(matchType =
						this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship()));
				}
				if (relationship.isAssociation() && FuzzQuotient.EXACT_OR_MINOR_OR_RENAMED_PREDICATE.evaluate(matchType)) {
					countMatchingAssociations++;
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
		return countMatchingAssociations;
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
