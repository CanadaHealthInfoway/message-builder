package ca.infoway.messagebuilder.generator.regen;

import static java.lang.String.format;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.Type;

public abstract class Delta {

	protected final BaseRelationship oldRelationship;
	protected final BaseRelationship newRelationship;

	protected Delta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		this.oldRelationship = oldRelationship;
		this.newRelationship = newRelationship;
	}

	protected String toString(Type type) {
		return format("%s, %s, %s", 
				getClass().getSimpleName(),
				type.getName(),
				this.oldRelationship.getName());
	}
	
	public abstract void apply(RelationshipsMergerContext context);

	protected final void replaceRelationship(Type mergedType, BaseRelationship targetRelationship, BaseRelationship mergedRelationship) {
		int index = mergedType.getRelationships().indexOf(targetRelationship);
		mergedType.getRelationships().remove(index);
		mergedType.getRelationships().add(index, mergedRelationship);
	}
	
}
