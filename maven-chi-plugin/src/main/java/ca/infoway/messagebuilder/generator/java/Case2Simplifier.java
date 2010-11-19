package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.TypeName;

public class Case2Simplifier extends InlineableSimplifier {

	class Reference {
		private final BaseRelationship relationship;
		private final Type type;

		public Reference(Type type, BaseRelationship relationship) {
			this.type = type;
			this.relationship = relationship;
		}
		public BaseRelationship getRelationship() {
			return this.relationship;
		}
		public Type getType() {
			return this.type;
		}
	}

	class SimplifiableReference {
		private final SimplifiableRelationship relationship;
		private final SimplifiableType type;
		
		public SimplifiableReference(SimplifiableType type, SimplifiableRelationship relationship) {
			this.type = type;
			this.relationship = relationship;
		}
		public SimplifiableRelationship getRelationship() {
			return this.relationship;
		}
		public SimplifiableType getType() {
			return this.type;
		}
	}
	
	private Set<TypeName> nonInlineableTypes = Collections.synchronizedSet(new HashSet<TypeName>());
	private final Case1Simplifier case1Simplifier;
	private final SimplifiableDefinitions definitions;
	
	public Case2Simplifier(LogUI log, TypeAnalysisResult result, SimplifiableDefinitions definitions) {
		super(log, result, definitions);
		this.definitions = definitions;
		this.case1Simplifier = new Case1Simplifier(log, result, definitions);
	}

	@Override
	public void execute() {
		analyze();
		super.execute();
	}
	
	private void analyze() {
		for (ComplexTypePackage complexTypePackage : this.result.getAllPackages()) {
			for (Type type : new ArrayList<Type>(complexTypePackage.getTypes().values())) {
				if (type.getRelationships().size() >= 7) {
					this.nonInlineableTypes.add(type.getTypeName());
				}
			}
		}
	}

	@Override
	protected void inline(ComplexTypePackage complexTypePackage, Type inlineableType) {
//		List<Reference> references = getAllReferencesToType(getPotentialReferrers(complexTypePackage, inlineableType), inlineableType);
//		for (Reference reference : references) {
//			inlineReference(inlineableType, reference);
//		}
//		if (!containedInChoice(inlineableType)) {
//			this.log.log(DEBUG, "Simplification case 2: removing type " + inlineableType.getTypeName());
//			this.result.removeType(inlineableType);
//		}
	}

//	private void inlineReference(Type inlineableType, Reference reference) {
//		this.log.log(DEBUG, "Simplification case 2: Type " + inlineableType.getTypeName() + " is being rolled up into " + reference.getType().getTypeName());
//		if (ObjectUtils.equals(inlineableType.getTypeName(), reference.getType().getTypeName())) {
//			this.log.log(LogLevel.WARN, "warning - trying to inline type to itself:  " + inlineableType.getTypeName());
//		} else {
//			BaseRelationship oldRelationship = reference.getRelationship();
//			
//			for (BaseRelationship relationship : inlineableType.getRelationships()) {
//				// bug 13644 - only create an inlined relationship if the reference type actually makes use of the relationship
//				if (typeUsesRelationship(reference.getType(), oldRelationship, relationship)) {
//					reference.getType().getRelationships().add(createInlinedRelationship(
//							inlineableType.getTypeName(), relationship, oldRelationship));
//				}
//			}
//			reference.getType().getRelationships().remove(oldRelationship);
//		}
//	}

	@Override
	protected boolean isInlineable(ComplexTypePackage complexTypePackage, Type inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (inlineableType.isAbstract()) {
			result = false;
		} else if (!isUsedExactlyOnce(complexTypePackage, inlineableType) && !isTemporary(inlineableType)) {
			// if used more than once do not inline - we don't want to denormalize unnecessarily; 
			// temporary (merged) types are an exception, and will not fall under this case
			result = false;
		} else {
			List<Reference> references = getAllReferencesToType(
					getPotentialReferrers(complexTypePackage, inlineableType), inlineableType);
			result = validateReferences(complexTypePackage, inlineableType, references);
		}
		
		return result;
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (inlineableType.getMessagePart().isAbstract()) {
			result = false;
		} else if (!isUsedExactlyOnce(complexTypePackage, inlineableType)) {
			// if used more than once do not inline - we don't want to denormalize unnecessarily; 
			result = false;
		} else {
			List<SimplifiableReference> references = getAllSimplifiableReferencesToType(
					getPotentialReferrers(complexTypePackage, inlineableType), inlineableType);
			result = validateReferences(complexTypePackage, inlineableType, references);
		}
		
		return result;
	}
	
	private Collection<Type> getPotentialReferrers(ComplexTypePackage complexTypePackage, Type inlineableType) {
		return this.result.getAllMessageTypes();
	}
	private Collection<SimplifiableType> getPotentialReferrers(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		return this.definitions.getAllTypes();
	}

	private boolean validateReferences(ComplexTypePackage complexTypePackage, Type inlineableType, List<Reference> references) {
		boolean result = !references.isEmpty();
		for (Reference reference : references) {
			result &= validateReference(complexTypePackage, inlineableType, reference);
		}
		return result;
	}

	private boolean validateReferences(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType, List<SimplifiableReference> references) {
		boolean result = !references.isEmpty();
		for (SimplifiableReference reference : references) {
			result &= validateReference(complexTypePackage, inlineableType, reference);
		}
		return result;
	}
	
	private List<Reference> getAllReferencesToType(Collection<Type> values, Type inlineableType) {
		List<Reference> result = new ArrayList<Reference>();
		for (Type type : values) {
			for (BaseRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					result.add(new Reference(type, relationship));
				}
			}
		}
		return result;
	}

	private List<SimplifiableReference> getAllSimplifiableReferencesToType(Collection<SimplifiableType> values, SimplifiableType inlineableType) {
		List<SimplifiableReference> result = new ArrayList<SimplifiableReference>();
		for (SimplifiableType type : values) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					result.add(new SimplifiableReference(type, relationship));
				}
			}
		}
		return result;
	}
	
	private boolean validateReference(ComplexTypePackage complexTypePackage, Type inlineableType, Reference reference) {
		boolean result = true;
		
		if (reference.getRelationship().isCardinalityMultiple()) {
			result = false;
		} else if (this.nonInlineableTypes.contains(reference.getType().getTypeName())) {
			result = false;
		} else if (ObjectUtils.equals(inlineableType.getTypeName(), reference.getType().getTypeName())) {
			return false;
		} else if (this.case1Simplifier.isInlineable(complexTypePackage, reference.getType())) {
			return false;
		} else if (EXACTLY_ONE.equals(reference.getRelationship().getCardinality())) {
			result = true;
		} else {
			// must have at least one mandatory property in order to avoid ambiguity with collapsed relationships (parent is nullflavor vs parent has child and all child relationships are nullflavor)
			result = hasAtLeastOneMandatoryProperty(inlineableType);
		}
		
		return result && !reference.getRelationship().getConformanceLevel().equals(ConformanceLevel.POPULATED);
	}

	private boolean validateReference(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType, SimplifiableReference reference) {
		boolean result = true;
		
		if (reference.getRelationship().getRelationship().getCardinality().isMultiple()) {
			result = false;
		} else if (this.nonInlineableTypes.contains(reference.getType().getMessagePart().getName())) {
			result = false;
		} else if (ObjectUtils.equals(inlineableType.getName(), reference.getType().getName())) {
			return false;
		} else if (this.case1Simplifier.isInlineable(complexTypePackage, reference.getType())) {
			return false;
		} else if (EXACTLY_ONE.equals(reference.getRelationship().getRelationship().getCardinality())) {
			result = true;
		} else {
			// must have at least one mandatory property in order to avoid ambiguity with collapsed relationships (parent is nullflavor vs parent has child and all child relationships are nullflavor)
			result = hasAtLeastOneMandatoryProperty(inlineableType);
		}
		
		return result && !reference.getRelationship().getRelationship().getConformance().equals(ConformanceLevel.POPULATED);
	}
	
	private boolean hasAtLeastOneMandatoryProperty(Type inlineableType) {
		boolean result = false;
		for (BaseRelationship relationship : inlineableType.getRelationships()) {
			if (relationship.getCardinality().getMin() == 1) {
				result = true;
				break;
			}
		}
		return result;
	}

	private boolean hasAtLeastOneMandatoryProperty(SimplifiableType inlineableType) {
		boolean result = false;
		for (SimplifiableRelationship relationship : inlineableType.getRelationships()) {
			if (relationship.getRelationship().getCardinality().getMin() == 1) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private boolean isUsedExactlyOnce(ComplexTypePackage complexTypePackage,
			Type inlineableType) {
		int count = 0;
		for (Type type : complexTypePackage.getTypes().values()) {
			for (BaseRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					count++;
				}
			}
		}
		return count == 1;
	}
	private boolean isUsedExactlyOnce(SimplifiablePackage complexTypePackage,
			SimplifiableType inlineableType) {
		int count = 0;
		for (SimplifiableType type : complexTypePackage.getTypes()) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					count++;
				}
			}
		}
		return count == 1;
	}
}
