package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;

public interface TypeDeltaApplicator {

	boolean canApply(BaseRelationship originalRelationship, BaseRelationship newRelationship);
	void apply(RelationshipsMergerContext context, BaseRelationship originalRelationship, BaseRelationship newRelationship);

}
