package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.Cardinality;

public class CardinalityDeltaCalculator extends NameBasedDeltaCalculator {

	@Override
	protected Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship,	BaseRelationship newRelationship) {
		Delta result = null;
		
		Cardinality oldCardinality = oldRelationship.getCardinality();
		Cardinality newCardinality = newRelationship.getCardinality();
		if (oldCardinality.isSingle() != newCardinality.isSingle()) {
			result = new CardinalityDelta(oldRelationship, newRelationship);
		}
		
		return result;
	}

}
