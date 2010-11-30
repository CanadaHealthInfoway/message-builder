package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.MatchType.ADDED;
import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MAJOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.MINOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.REMOVED;
import static ca.infoway.messagebuilder.generator.java.MatchType.RENAMED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3FuzzyMatcher extends Case3Matcher {

	private static final Predicate DIFFERENCE_PREDICATE = PredicateUtils.equalPredicate(MAJOR_DIFFERENCE);
	private static final Predicate REMOVED_PREDICATE = PredicateUtils.equalPredicate(REMOVED);
	private static final Predicate ADDED_PREDICATE = PredicateUtils.equalPredicate(ADDED);
	private static final Predicate EXACT_OR_MINOR_OR_RENAMED_PREDICATE = PredicateUtils.orPredicate(
			PredicateUtils.orPredicate(
				PredicateUtils.equalPredicate(EXACT),
				PredicateUtils.equalPredicate(RENAMED)),
			PredicateUtils.equalPredicate(MatchType.MINOR_DIFFERENCE));
	
	private final Case3MergeResult mergeResult;
	private final Matcher matcher;
	private final LogUI log;
	private final Fuzziness fuzziness;

	public Case3FuzzyMatcher(LogUI log, SimplifiableTypeProvider definitions, Case3MergeResult result, Fuzziness fuzziness) {
		super(definitions);
		this.log = log;
		this.mergeResult = result;
		this.fuzziness = fuzziness;
		this.matcher = new Matcher(this.mergeResult);
	}

	public boolean performMatching(SimplifiableType type) {
		List<SimplifiableType> matches = new ArrayList<SimplifiableType>();
		if (!type.getMessagePart().isAbstract() && !isTemplateType(type)) {
			for (SimplifiableType otherType : getAllSimplifiableTypes()) {
				if (type.getName().equals(otherType.getName())) {
					break;
				} else if (!this.fuzziness.isWorthChecking(type, otherType)) {
					// skip it
				} else if (this.mergeResult.isUnmergeable(type, otherType)) {
					// skip it
				} else if (isTemplateType(otherType)) {
					// skip it
				} else if (!isExactOrMinor(new NameMatcher().matchNames(type, otherType))) {
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
		
		if (!matches.isEmpty() && isAllMatchesCompatible(matches)) {
			return recordAllMatches(matches);
		} else {
			return false;
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
					result |= true;
					this.log.log(LogLevel.INFO, "linking: " + previous.getTypeName() + " to " + match.getTypeName());
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
				result &= isOverlappingSetOfRelationships(exemplar, type);
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
		
		return isSufficientOverlap(matchTypes);
	}
	
	private boolean isSufficientOverlap(List<MatchType> matchTypes) {
		int numExact = CollectionUtils.countMatches(matchTypes, EXACT_OR_MINOR_OR_RENAMED_PREDICATE);
		int numAdded = CollectionUtils.countMatches(matchTypes, ADDED_PREDICATE);
		int numRemoved = CollectionUtils.countMatches(matchTypes, REMOVED_PREDICATE);
		int numMajorDifferences = CollectionUtils.countMatches(matchTypes, DIFFERENCE_PREDICATE);
		
		// must have at least 1 exact match, and no differences
		// current approach is then no more than 2 different properties, or no more than 25% of properties different 
		
		int numTotal = numExact + numAdded + numRemoved;
		int numDifferent = numAdded + numRemoved;
		return numExact > 0 
			&& numMajorDifferences == 0 
			&& (numDifferent <= 2 
			|| (numExact * 1.0 / numTotal >= 0.75));
		
	}
	
	private String describe(NamedType type, Named relationship) {
		return type.getTypeName().getName() + "." + (relationship == null ? "?" : relationship.getName());
	}
	
	private void checkRelationships(SimplifiableType type, SimplifiableType otherType, List<MatchType> matchTypes, MatchType missingMatchType) {
		for (SimplifiableRelationship relationship : type.getRelationships()) {
			MatchType matchType = MatchType.EXACT;
			SimplifiableRelationship otherRelationship = otherType.getRelationship(relationship.getRelationship().getName());
			if (otherRelationship != null) {
				matchTypes.add(matchType =
					this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship()));
			} else if (relationship.isTemplateType() || isTemplateAssociationType(relationship)) {
				matchTypes.add(matchType =MatchType.MAJOR_DIFFERENCE);
			} else if (relationship.isAssociation() && !relationship.isTemplateType() 
					&& isRenamedRelationship(type, relationship, otherType)) {
				matchTypes.add(MatchType.RENAMED);
			} else {
				// TODO: BCH: Should we search by business name?
				matchTypes.add(matchType = missingMatchType);
			}
			this.log.log(LogLevel.DEBUG, "comparing " + describe(type, relationship) + 
					" with " + describe(otherType, otherRelationship) + " : match type = " 
					+ matchType);
		}
	}
	
	private boolean isRenamedRelationship(SimplifiableType type, SimplifiableRelationship relationship,
			SimplifiableType otherType) {
		boolean result = false;
		for (SimplifiableRelationship otherRelationship : otherType.getRelationships()) {
			boolean print = false;
//			System.out.println("---> " + otherRelationship.getName() + " with " + relationship.getName());
			
			if (type.getName().contains("MCCI_") && otherType.getName().contains("MCCI_") && otherRelationship.isAssociation()) {
				print = true;
				System.out.println("Comparing " + describe(type, relationship) + " and " + describe(otherType, otherRelationship));
			}
			
			if (!otherRelationship.isAssociation()) {
				// skip it
			} else if (otherRelationship.isTemplateType()) {
				// skip it
			} else if (StringUtils.equals(relationship.getRelationship().getType(), otherRelationship.getRelationship().getType())) {
				this.log.log(LogLevel.INFO, 
						"Identified a renamed relationship: " 
						+ describe(type, relationship) 
						+ " and " + describe(otherType, otherRelationship));
				result = true;
				break;
			} else if (isSameMergeType(otherRelationship.getType(), relationship.getType())) {
				this.log.log(LogLevel.INFO, 
						"Identified a renamed relationship between merged types: " 
						+ describe(type, relationship) + 
						" and " + describe(otherType, otherRelationship));
				result = true;
				break;
			} else if (print) {
				System.out.println("No match "  + describe(type, relationship) 
						+ " and " +  describe(otherType, otherRelationship));
				System.out.println("Type      : "  + type.getMergedTypeName());
				System.out.println("Other type: "  + otherType.getMergedTypeName());
			}
		}
		return result;
	}

	private boolean isSameMergeType(SimplifiableType type, SimplifiableType otherType) {
		return this.mergeResult.isKnownMatch(type, otherType);
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
