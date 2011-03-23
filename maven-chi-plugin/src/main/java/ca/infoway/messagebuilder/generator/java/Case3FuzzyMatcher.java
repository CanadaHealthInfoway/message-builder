package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.MatchType.ADDED;
import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MAJOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.MINOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.REMOVED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

public class Case3FuzzyMatcher extends Case3Matcher {

	private static final Predicate DIFFERENCE_PREDICATE = PredicateUtils.equalPredicate(MAJOR_DIFFERENCE);
	private static final Predicate REMOVED_PREDICATE = PredicateUtils.equalPredicate(REMOVED);
	private static final Predicate ADDED_PREDICATE = PredicateUtils.equalPredicate(ADDED);
	private static final Predicate EXACT_PREDICATE = PredicateUtils.equalPredicate(EXACT);
	
	private final TypeProvider provider;
	private final Case3MergeResult mergeResult;
	private final Matcher matcher;
	private final LogUI log;

	public Case3FuzzyMatcher(LogUI log, TypeProvider provider, Case3MergeResult result) {
		this.log = log;
		this.provider = provider;
		this.mergeResult = result;
		this.matcher = new Matcher(this.mergeResult);
	}

	public boolean performMatching(Type type) {
		List<Type> matches = new ArrayList<Type>();
		if (!type.isAbstract() && !type.isTemplateType()) {
			for (Type otherType : this.provider.getAllMessageTypes()) {
				if (type.getName().equals(otherType.getName())) {
					// skip it
				} else if (this.mergeResult.isUnmergeable(type, otherType)) {
					// skip it
				} else if (otherType.isTemplateType()) {
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
		
		if (!matches.isEmpty() && isAllMatchesCompatible(matches) && !isAlreadyRecorded(type, matches)) {
			recordAllMatches(matches);
			return true;
		} else {
			return false;
		}
	}

	private boolean isMergeable(List<Type> matches, Type otherType) {
		boolean unmergeable = false;
		for (Type type : matches) {
			unmergeable |= this.mergeResult.isUnmergeable(type, otherType);
		}
		return !unmergeable;
	}

	private boolean isAlreadyRecorded(Type type, List<Type> matches) {
		MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(type.getName());
		if (descriptor == null || matches.isEmpty()) {
			return false;
		} else {
			boolean result = true;
			for (Type match : matches) {
				if (!descriptor.getMergedTypes().contains(match.getName())) {
					result = false;
					break;
				}
			}
			return result;
		}
	}

	private void recordAllMatches(List<Type> matches) {
		Type previous = null;
		for (Type match : matches) {
			if (previous != null) {
				this.mergeResult.recordMatch(previous, match);
				this.log.log(LogLevel.DEBUG, "linking: " + previous.getName() + " to " + match.getName());
			}
			previous = match;
		}
	}

	private boolean isAllMatchesCompatible(List<Type> matches) {
		matches = createMergeList(matches);
		boolean result = true;
		while (!matches.isEmpty() && result) {
			Type exemplar = matches.remove(0);
			for (Type type : matches) {
				result &= isOverlappingSetOfRelationships(exemplar, type);
				if (!result) {
					break;
				}
			}
		}
		return result;
	}

	// need to consolidate both the cluster, and everything that 
	// items in the cluster have previously merged with.
	private List<Type> createMergeList(List<Type> matches) {
		HashMap<TypeName,Type> map = new HashMap<TypeName, Type>();
		for (Type type : matches) {
			map.put(type.getName(), type);
			MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(type.getName());
			if (descriptor != null) {
				for (TypeName existingMerges : descriptor.getMergedTypes()) {
					Type otherType = this.provider.getTypeByName(existingMerges);
					if (otherType != null) {
						map.put(existingMerges, otherType);
					} else {
						this.log.log(LogLevel.WARN, "No type found for " + existingMerges);
					}
				}
			}
		}
		
		return new ArrayList<Type>(map.values());
	}

	private boolean isOverlappingSetOfRelationships(Type type, Type otherType) {
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		checkRelationships(type, otherType, matchTypes, MatchType.ADDED);
		checkRelationships(otherType, type, matchTypes, MatchType.REMOVED);
		
		return isSufficientOverlap(matchTypes);
	}

	private boolean isSufficientOverlap(List<MatchType> matchTypes) {
		int numExact = CollectionUtils.countMatches(matchTypes, EXACT_PREDICATE);
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
	
	private String describe(Type type, BaseRelationship relationship) {
		return type.getName().getName() + "." + (relationship == null ? "?" : relationship.getName());
	}
	
	private void checkRelationships(Type type, Type otherType, List<MatchType> matchTypes, MatchType missingMatchType) {
		for (BaseRelationship relationship : type.getRelationships()) {
			MatchType matchType = MatchType.EXACT;
			BaseRelationship otherRelationship = otherType.getRelationship(relationship.getName());
			if (otherRelationship != null) {
				matchTypes.add(matchType =
						this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship()));
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

	private boolean isTemplateAssociationType(BaseRelationship relationship) {
		return relationship.getRelationshipType() == RelationshipType.ASSOCIATION 
				&& ((Association) relationship).getAssociationType() != null
				&& ((Association) relationship).getAssociationType().isTemplateType();
	}

	private boolean isExactOrMinor(MatchType matchType) {
		return matchType == EXACT || matchType == MINOR_DIFFERENCE;
	}

	public String getDescription() {
		return "Looking for approximate matches between types";
	}
}
