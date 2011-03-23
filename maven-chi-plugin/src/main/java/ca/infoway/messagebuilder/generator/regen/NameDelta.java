package ca.infoway.messagebuilder.generator.regen;

import static java.lang.String.format;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;

public class NameDelta extends Delta {

	public NameDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		super(oldRelationship, newRelationship);
	}

	@Override
	public void apply(RelationshipsMergerContext context) {
		System.out.println(toString(context.getMergedType()) + format(",%s, %s", this.oldRelationship.getName(), this.newRelationship.getName()));
	}

}
