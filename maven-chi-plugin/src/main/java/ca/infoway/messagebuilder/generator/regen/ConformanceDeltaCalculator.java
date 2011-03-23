package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class ConformanceDeltaCalculator extends NameBasedDeltaCalculator {

	@Override
	protected Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship,	BaseRelationship newRelationship) {
		Delta result = null;

		ConformanceLevel oldConformanceLevel = oldRelationship.getConformanceLevel();
		ConformanceLevel newConformanceLevel = newRelationship.getConformanceLevel();

		if (oldConformanceLevel != newConformanceLevel) {
			result = new ConformanceDelta(oldRelationship, newRelationship);
		}
		
		return result;
	}


}
