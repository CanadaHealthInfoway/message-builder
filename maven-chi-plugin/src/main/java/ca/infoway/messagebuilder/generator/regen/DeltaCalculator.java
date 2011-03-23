package ca.infoway.messagebuilder.generator.regen;

import java.util.Set;

import ca.infoway.messagebuilder.generator.java.Type;


public interface DeltaCalculator {

	public Set<Delta> calculate(RelationshipsMergerContext context, Type oldType, Type newType);

}
