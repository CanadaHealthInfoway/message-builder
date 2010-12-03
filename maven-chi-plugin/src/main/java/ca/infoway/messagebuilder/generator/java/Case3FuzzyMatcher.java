package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.MatchType.ADDED;
import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MAJOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.MINOR_DIFFERENCE;
import static ca.infoway.messagebuilder.generator.java.MatchType.REMOVED;
import static ca.infoway.messagebuilder.generator.java.MatchType.RENAMED;

import java.util.ArrayList;
import java.util.Arrays;
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

	List<String> respondTo1 = Arrays.asList("MCCI_MT000100CA.RespondTo","MCCI_MT000200CA.RespondTo","MCCI_MT000300CA.RespondTo");
	List<String> respondTo2 = Arrays.asList("MCCI_MT002100CA.RespondTo","MCCI_MT002200CA.RespondTo","MCCI_MT002300CA.RespondTo","MCCI_MT102001CA.RespondTo");
	
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
		if (!type.getMessagePart().isAbstract() && !isTransitiveTemplateType(type)) {
			for (SimplifiableType otherType : getAllSimplifiableTypes()) {
				boolean debug = false;
				if (isInteresting(type, otherType)) {
					debug = true;
					System.out.println("Comparing " + type.getName() + " to " + otherType.getName());
				}
				
				if (type.getName().equals(otherType.getName())) {
					break;
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
				} else if (isOverlappingSetOfRelationships(type, otherType, debug)) {
					if (isMergeable(matches, otherType)) {
						if (matches.isEmpty()) {
							matches.add(type);
						}
						System.out.println("Matched " + type.getName() + " to " + otherType.getName());
						matches.add(otherType);
					}
				}
			}
		}
		
		if (!matches.isEmpty() && isAllMatchesCompatible(matches, type.getName().startsWith("MCCI_"))) {
			return recordAllMatches(matches);
		} else {
			return false;
		}
	}
	
	private boolean isInteresting(SimplifiableType type, SimplifiableType otherType) {
		return type.getName().startsWith("MCCI_") && otherType.getName().startsWith("MCCI_")
			&& ((type.getName().contains(".RespondTo") && otherType.getName().contains(".RespondTo")) ||
				(type.getName().contains(".Agent") && otherType.getName().contains(".Agent")) ||
				(type.getName().contains(".Device") && otherType.getName().contains(".Device")) ||
				(type.getName().contains(".LocatedEntity") && otherType.getName().contains(".LocatedEntity")) ||
				(type.getName().contains(".Place") && otherType.getName().contains(".Place")) ||
				(type.getName().contains(".Organization") && (otherType.getName().contains(".Organization")))
				);
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
		this.log.log(LogLevel.INFO, "linking start");
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
		this.log.log(LogLevel.INFO, "linking end");
		return result;
	}

	private boolean isAllMatchesCompatible(List<SimplifiableType> matches, boolean debug) {
		if (debug) {
			this.log.log(LogLevel.INFO, "matches before expansion: " + matches);
		}
		matches = createMergeList(matches);
		if (debug) {
			this.log.log(LogLevel.INFO, "matches after expansion: " + matches);
		}
		boolean result = true;
		while (!matches.isEmpty() && result) {
			SimplifiableType exemplar = matches.remove(0);
			for (SimplifiableType type : matches) {
				result &= isOverlappingSetOfRelationships(exemplar, type, debug);
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
		return isOverlappingSetOfRelationships(type, otherType, false);
	}
	
	private boolean isOverlappingSetOfRelationships(SimplifiableType type, SimplifiableType otherType, boolean debug) {
		if (debug) {
			this.log.log(LogLevel.INFO, ">>>>>>>>> Checking for overlapping set of " + type.getName() + " to " + otherType.getName());
		}
		List<MatchType> matchTypes = new ArrayList<MatchType>();
		checkRelationships(type, otherType, matchTypes, MatchType.ADDED, debug);
		checkRelationships(otherType, type, matchTypes, MatchType.REMOVED, debug);
		
		boolean result = isSufficientOverlap(matchTypes, debug);
		if (debug) {
			this.log.log(LogLevel.INFO, ">>>>>>>>> Finished checking: sufficient overlap = " + result);
		}
		return result;
	}
	
	private boolean isSufficientOverlap(List<MatchType> matchTypes, boolean debug) {
		int numExact = CollectionUtils.countMatches(matchTypes, EXACT_OR_MINOR_OR_RENAMED_PREDICATE);
		int numAdded = CollectionUtils.countMatches(matchTypes, ADDED_PREDICATE);
		int numRemoved = CollectionUtils.countMatches(matchTypes, REMOVED_PREDICATE);
		int numMajorDifferences = CollectionUtils.countMatches(matchTypes, DIFFERENCE_PREDICATE);

		if (debug) {
			this.log.log(LogLevel.INFO, "exact: " + numExact + " added: " + numAdded + " removed: " + numRemoved + " majordiffs: " + numMajorDifferences);
		}
		
		// must have at least 1 exact match, and no differences
		// current approach is then no more than 2 different properties, or no more than 25% of properties different 
		
		int numTotal = numExact + numAdded + numRemoved;
		int numDifferent = numAdded + numRemoved;
		return numExact > 0 
			&& numMajorDifferences == 0 
			&& (numDifferent <= 5 
			|| (numExact * 1.0 / numTotal >= 0.75));
		
	}
	
	private String describe(NamedType type, Named relationship) {
		return type.getTypeName().getName() + "." + (relationship == null ? "?" : relationship.getName());
	}
	
	private void checkRelationships(SimplifiableType type, SimplifiableType otherType, List<MatchType> matchTypes, MatchType missingMatchType, boolean debug) {
		for (SimplifiableRelationship relationship : type.getRelationships()) {
			MatchType matchType = MatchType.EXACT;
			SimplifiableRelationship otherRelationship = otherType.getRelationship(relationship.getRelationship().getName());
			if (otherRelationship != null) {
				if (relationship.isTemplateParameterPresent() && otherRelationship.isTemplateParameterPresent()) {
					matchTypes.add(MatchType.EXACT);
				} else {
					matchTypes.add(matchType =
						this.matcher.matchesType(relationship.getRelationship(), otherRelationship.getRelationship(), debug));
				}
			} else if (relationship.isTemplateType() || isTemplateAssociationType(relationship)) {
				if (debug) {
					this.log.log(LogLevel.INFO, "Found major difference - relationship is template type: " + relationship.getName());
				}
				matchTypes.add(matchType = MatchType.MAJOR_DIFFERENCE);
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
