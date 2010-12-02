package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.LogUI;

public class Case0Simplifier extends InlineableSimplifier {

	public Case0Simplifier(LogUI log, SimplifiableDefinitions definitions) {
		super(log, definitions);
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage simplifiablePackage,	SimplifiableType inlineableType) {
		boolean result = true;
		
		if (inlineableType.isRootType()) {
			result = false;
		} else if (!getNonFixedRelationships(inlineableType).isEmpty()) {
			result = false;
		} else if (inlineableType.isAbstract()) {
			result = false;
		}

		return result;
	}

	@Override
	protected void inline(SimplifiableType type) {
		super.inline(type);
		type.setIndicator(true);
	}	
	
}
