package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;
import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
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
					this.nonInlineableTypes.add(type.getName());
				}
			}
		}
	}

	@Override
	protected void inline(ComplexTypePackage complexTypePackage, Type inlineableType) {
		List<Reference> references = getAllReferencesToType(getPotentialReferrers(complexTypePackage, inlineableType), inlineableType);
		for (Reference reference : references) {
			inlineReference(inlineableType, reference);
		}
		if (!containedInChoice(inlineableType)) {
			this.log.log(DEBUG, "Simplification case 2: removing type " + inlineableType.getName());
			this.result.removeType(inlineableType);
		}
	}

	private void inlineReference(Type inlineableType, Reference reference) {
		this.log.log(DEBUG, "Simplification case 2: Type " + inlineableType.getName() + " is being rolled up into " + reference.getType().getName());
		if (ObjectUtils.equals(inlineableType.getName(), reference.getType().getName())) {
			this.log.log(LogLevel.WARN, "warning - trying to inline type to itself:  " + inlineableType.getName());
		} else {
			BaseRelationship oldRelationship = reference.getRelationship();
			
			for (BaseRelationship relationship : inlineableType.getRelationships()) {
				// bug 13644 - only create an inlined relationship if the reference type actually makes use of the relationship
				if (typeUsesRelationship(reference.getType(), oldRelationship, relationship)) {
					reference.getType().getRelationships().add(createInlinedRelationship(
							inlineableType.getName(), relationship, oldRelationship));
				}
			}
			reference.getType().getRelationships().remove(oldRelationship);
		}
	}

	// **********************************
	// (START) bug 13644 - only create an inlined relationship if the reference type actually makes use of the relationship
	
	private boolean typeUsesRelationship(Type referenceType, BaseRelationship referenceRelationship, BaseRelationship inliningRelationship) {
		if (!relationshipIsComplex(referenceRelationship)) {
			return true;
		}
		
		// if the reference type is a merged type and the reference relationship is inlined then the checking here
		// can become *very* complicated. In this case just allow without checking for now. Currently affects only 1 merged type in MR2009.
		// AssignedEntity_2Bean: [POIZ_MT030060CA.AssignedEntity, POIZ_MT030050CA.AssignedEntity, POIZ_MT060150CA.AssignedEntity]
		if (!referenceType.getMergedTypes().isEmpty() && !(referenceRelationship instanceof MergedAssociation)) {
			this.log.log(INFO, "Simplification case 2: SKIPPING check (and allowing match) for: " + (referenceType.getName() instanceof TemporaryTypeName ? referenceType.getMergedTypes() : referenceType.getName()) 
					+ "." + referenceRelationship.getName() + " when inlining " + inliningRelationship.getName());
			return true;
		}
		
		Collection<TypeName> typeNames = referenceType.getMergedTypes().isEmpty() ? Arrays.asList(referenceType.getName()) : referenceType.getMergedTypes();
		
		for (TypeName typeName : typeNames) {
			
			Type typeToCheck = getType(typeName);
			// pull out reference relationship from here
			BaseRelationship innerRelationship = typeToCheck.getRelationship(referenceRelationship.getName());
			
			if (innerRelationship != null) {
				BaseRelationship actualReferenceRelationship = getRelationshipToAssess(innerRelationship);
				Type actualTypeToAssess = getType(actualReferenceRelationship.getType());
				
				for (BaseRelationship relationship : actualTypeToAssess.getRelationships()) {
					// second check is for inlined inliningRelationships - is this sufficent (or even necessary)?
					if (StringUtils.equals(relationship.getXmlMapping(), inliningRelationship.getXmlMapping()) ||
							StringUtils.startsWith(inliningRelationship.getXmlMapping(), relationship.getXmlMapping() + "/")) {
						this.log.log(DEBUG, "Simplification case 2: Inlined match found for: " + (referenceType.getName() instanceof TemporaryTypeName ? referenceType.getMergedTypes() : referenceType.getName()) 
								+ "." + referenceRelationship.getName() + " when inlining " + inliningRelationship.getName());
						return true;
					}
				}
			}
		}
		
		this.log.log(INFO, "Simplification case 2: NO match found for: " + (referenceType.getName() instanceof TemporaryTypeName ? referenceType.getMergedTypes() : referenceType.getName()) 
				+ "." + referenceRelationship.getName() + " when inlining " + inliningRelationship.getName());
		return false;
	}

	private BaseRelationship getRelationshipToAssess(BaseRelationship referenceRelationship) {
		if (referenceRelationship instanceof InlinedAssociation) {
			return getRelationshipToAssess(((InlinedAssociation)referenceRelationship).getInlinedRelationship());
		} else if (referenceRelationship instanceof InlinedAttribute) {
			return getRelationshipToAssess(((InlinedAttribute)referenceRelationship).getInlinedRelationship());
		} else if (referenceRelationship instanceof MergedAssociation) {
			return ((MergedAssociation) referenceRelationship).getOriginalAssociation();
		} else {
			return referenceRelationship;
		}
	}

	private boolean relationshipIsComplex(BaseRelationship referenceRelationship) {
		return (referenceRelationship instanceof InlinedAssociation) ||
			   (referenceRelationship instanceof InlinedAttribute) ||
			   (referenceRelationship instanceof MergedAssociation);
	}

	private Type getType(String typeName) {
		return getType(typeName.startsWith("merged") ? TemporaryTypeName.createNameAsIs(typeName) : new TypeName(typeName));
	}
	
	private Type getType(TypeName typeName) {
		Type result = this.result.getTypeByName(typeName);
		if (result == null) {
			result = (Type) this.result.getRemovedTypes().get(typeName);
		}
		return result;
	}
	
	// (END) bug 13644 - only create an inlined relationship if the reference type actually makes use of the relationship
	// **************************************
	
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

	private Collection<Type> getPotentialReferrers(ComplexTypePackage complexTypePackage, Type inlineableType) {
		return this.result.getAllMessageTypes();
	}

	private boolean validateReferences(ComplexTypePackage complexTypePackage, Type inlineableType, List<Reference> references) {
		boolean result = !references.isEmpty();
		for (Reference reference : references) {
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

	private boolean validateReference(ComplexTypePackage complexTypePackage, Type inlineableType, Reference reference) {
		boolean result = true;
		
		if (reference.getRelationship().isCardinalityMultiple()) {
			result = false;
		} else if (this.nonInlineableTypes.contains(reference.getType().getName())) {
			result = false;
		} else if (ObjectUtils.equals(inlineableType.getName(), reference.getType().getName())) {
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
}
