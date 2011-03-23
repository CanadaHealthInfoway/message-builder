package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.Collection;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class Case1Simplifier extends InlineableSimplifier {

	public Case1Simplifier(LogUI log, TypeAnalysisResult result) {
		super(log, result);
	}

	protected boolean isInlineable(ComplexTypePackage complexTypePackage, Type inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (getNonFixedRelationships(inlineableType).size() != 1) {
			result = false;
		} else if (inlineableType.isAbstract()) {
			result = false;
		}

		Collection<Type> allTypes = isTemporary(inlineableType) ? 
				this.result.getAllMessageTypes() : complexTypePackage.getTypes().values();  
		result = result && checkCardinalityCompatibility(inlineableType, allTypes);  // don't use &=
		result = result && checkConformanceCompatibility(inlineableType, allTypes);  // don't use &=
		
		return result;
	}

	private boolean checkConformanceCompatibility(Type inlineableType, Collection<Type> types) {
		boolean result = true;
		outer: for (Type type : types) {
			for (BaseRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					if (!isConformanceCapableOfSupportingInlining(inlineableType, relationship)) {
						result = false;
						break outer;
					}
				}
			}
		}
		return result;
	}

	private boolean isConformanceCapableOfSupportingInlining(Type inlineableType, BaseRelationship relationship) {
		return !ConformanceLevel.POPULATED.equals(relationship.getConformanceLevel());
	}

	private boolean checkCardinalityCompatibility(Type inlineableType, Collection<Type> types) {
		boolean result = true;
		outer: for (Type type : types) {
			for (BaseRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					if (!isCardinalityCapableOfSupportingInlining(inlineableType, relationship)) {
						result = false;
						break outer;
					}
				}
			}
		}
		return result;
	}

	private boolean isCardinalityCapableOfSupportingInlining(Type inlineableType,
			BaseRelationship relationship) {
		
		if (EXACTLY_ONE.equals(relationship.getCardinality())) {
			return true;
		} else if (EXACTLY_ONE.equals(getSingleRelationship(inlineableType).getCardinality())) {
			return true;
		} else {
			return false;
		}
	}

	protected void inline(ComplexTypePackage complexTypePackage, Type inlineableType) {
		Collection<Type> types = this.result.getAllMessageTypes();
		
		for (Type type : types) {
			for (int i = 0, length = type.getRelationships().size(); i < length; i++) {
				BaseRelationship relationship = type.getRelationships().get(i);
				if (matches(inlineableType, relationship)) {
					
					// bug 13644 - decided *not* to make any changes here
					//           - extremely unlikely that the single relationship being inlined is superfluous
					//             to the type gaining the inlined relationship (due to the characteristics of a Case1 candidate)
					BaseRelationship newRelationship = createInlinedRelationship(
							inlineableType, relationship);
					this.log.log(DEBUG, "Simplification case 1: Type " + inlineableType.getName() 
							+ " is being rolled up into " + type.getName() + "." + relationship.getName());
					
					type.getRelationships().set(i, newRelationship);
				}
			}
		}
		if (!containedInChoice(inlineableType)) {
			this.log.log(DEBUG, "Simplification case 1: removing type " + inlineableType.getName());
			this.result.removeType(inlineableType);
		}
	}

	protected BaseRelationship createInlinedRelationship(Type inlineableType, BaseRelationship elidedRelationship) {
		return createInlinedRelationship(getSingleRelationship(inlineableType), elidedRelationship);
	}

	private BaseRelationship getSingleRelationship(Type inlineableType) {
		return getNonFixedRelationships(inlineableType).get(0);
	}
	
}
