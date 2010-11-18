package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3ExactMatcher extends Case3Matcher {
	
	private TypeProvider typeProvider;
	private final Case3MergeResult mergeResult;
	private Matcher matcher;
	private final LogUI log;
	private final SimplifiableTypeProvider definitions;
	
	Case3ExactMatcher(LogUI log, TypeProvider typeProvider, SimplifiableTypeProvider definitions, Case3MergeResult mergeResult) {
		this.log = log;
		this.typeProvider = typeProvider;
		this.definitions = definitions;
		this.mergeResult = mergeResult;
		this.matcher = new Matcher(this.mergeResult);
	}

	boolean performMatching(SimplifiableType type) {
		boolean somethingMatched = false;
		for (SimplifiableType otherType : getAllSimplifiableTypes()) {
			if (type.getTypeName().equals(otherType.getTypeName())) {
				break;
			} else if (this.mergeResult.isKnownMatch(type, otherType)) {
				// Skip it.  We already know about it
			} else if (matchType(type, otherType) == MatchType.EXACT) {
				somethingMatched |= this.mergeResult.recordMatch(type, otherType);
			}
		}
		return somethingMatched;
	}
	boolean performMatching(Type type) {
		boolean somethingMatched = false;
		for (Type otherType : getAllMessageTypes()) {
			if (type.getTypeName().equals(otherType.getTypeName())) {
				break;
			} else if (this.mergeResult.isKnownMatch(type, otherType)) {
				// Skip it.  We already know about it
			} else if (matchType(type, otherType) == MatchType.EXACT) {
				somethingMatched |= this.mergeResult.recordMatch(type, otherType);
			}
		}
		return somethingMatched;
	}

	private List<Type> getAllMessageTypes() {
		ArrayList<Type> list = new ArrayList<Type>(this.typeProvider.getAllMessageTypes());
		Collections.reverse(list);
		return list;
	}
	private List<SimplifiableType> getAllSimplifiableTypes() {
		ArrayList<SimplifiableType> list = new ArrayList<SimplifiableType>(this.definitions.getAllTypes());
		Collections.reverse(list);
		return list;
	}
	private MatchType matchType(Type type, Type otherType) {
		MatchType result = type.getRelationships().size() == otherType.getRelationships().size() ?
				MatchType.EXACT : MatchType.MAJOR_DIFFERENCE;
		if (this.mergeResult.isUnmergeable(type, otherType)) {
			result = MatchType.REPRESENTS_DIFFERENT_CHOICES;
		} else if (result == MatchType.EXACT && type.isAbstract()) {
			result = matchesAbstractType(type, otherType);
		}
		
		if (result == MatchType.EXACT) {
			result = new NameMatcher().matchNames(type, otherType);
		}
		
		if (result == MatchType.EXACT) {
			for (BaseRelationship relationship : type.getRelationships()) {
				result = matchRelationship(otherType, relationship);
				
				if (result != MatchType.EXACT) {
					break;
				}
			}
		}
		return result;
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
	
	private MatchType matchesAbstractType(HierarchicalType type, HierarchicalType otherType) {
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
