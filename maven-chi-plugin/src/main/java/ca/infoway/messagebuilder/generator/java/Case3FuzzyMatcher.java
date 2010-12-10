package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.MatchType.EXACT;
import static ca.infoway.messagebuilder.generator.java.MatchType.MINOR_DIFFERENCE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3FuzzyMatcher extends Case3Matcher {

	
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
			SimplifiableRelationship otherRelationship = otherType.getRelationshipByFingerprint(relationship.getFingerprint());
			
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
			} else if (otherType.getRelationship(relationship.getName()) != null) {
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
