package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationship;

public class DocumentationDelta extends Delta {

	protected DocumentationDelta(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
		super(oldRelationship, newRelationship);
	}

	@Override
	public void apply(RelationshipsMergerContext context) {
		BaseRelationship existingRelationship = context.getMergedType().getRelationship(oldRelationship.getName());
		if (!(existingRelationship instanceof RegeneratedRelationship)) {
			if (this.newRelationship.getDocumentation()!=null) {
				oldRelationship.setDocumentation(this.newRelationship.getDocumentation());
			}
		}		
	}

}
