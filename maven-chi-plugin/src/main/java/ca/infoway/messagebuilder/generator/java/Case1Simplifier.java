package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class Case1Simplifier extends InlineableSimplifier {

	public Case1Simplifier(LogUI log, SimplifiableDefinitions definitions) {
		super(log, definitions);
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (getNonFixedRelationships(inlineableType).size() != 1) {
			result = false;
		} else if (isTemplateVariable(getNonFixedRelationships(inlineableType).get(0))) {
			result = false;
		} else if (inlineableType.getMessagePart().isAbstract()) {
			result = false;
		}

		Collection<SimplifiableType> allTypes = complexTypePackage.getTypes();  
		result = result && checkCardinalityCompatibility(inlineableType, allTypes);  // don't use &=
		result = result && checkConformanceCompatibility(inlineableType, allTypes);  // don't use &=
		
		return result;
	}
	
	private boolean isTemplateVariable(SimplifiableRelationship simplifiableRelationship) {
		return simplifiableRelationship.isTemplateParameterPresent();
	}

	private boolean checkConformanceCompatibility(SimplifiableType inlineableType,
			Collection<SimplifiableType> types) {
		boolean result = true;
		outer: for (SimplifiableType type : types) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
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

	private boolean checkCardinalityCompatibility(SimplifiableType inlineableType,
			Collection<SimplifiableType> types) {
		boolean result = true;
		outer: for (SimplifiableType type : types) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
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

	protected List<SimplifiableRelationship> getNonFixedRelationships(SimplifiableType inlineableType) {
		List<SimplifiableRelationship> nonFixedRelationships = new ArrayList<SimplifiableRelationship>();
		List<SimplifiableRelationship> allRelationships = inlineableType.getRelationships();
		for (SimplifiableRelationship baseRelationship : allRelationships) {
			if (!baseRelationship.getRelationship().isFixed()) {
				nonFixedRelationships.add(baseRelationship);
			}
		}
		return nonFixedRelationships;
	}
	
	private boolean isConformanceCapableOfSupportingInlining(SimplifiableType inlineableType, SimplifiableRelationship relationship) {
		return !ConformanceLevel.POPULATED.equals(relationship.getRelationship().getConformance());
	}

	private boolean isCardinalityCapableOfSupportingInlining(SimplifiableType inlineableType,
			SimplifiableRelationship relationship) {
		
		if (EXACTLY_ONE.equals(relationship.getRelationship().getCardinality())) {
			return true;
		} else if (EXACTLY_ONE.equals(getSingleRelationship(inlineableType).getRelationship().getCardinality())) {
			return true;
		} else {
			return false;
		}
	}
	
	private SimplifiableRelationship getSingleRelationship(SimplifiableType inlineableType) {
		return getNonFixedRelationships(inlineableType).get(0);
	}
	
}
