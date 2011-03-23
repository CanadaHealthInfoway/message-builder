package ca.infoway.messagebuilder.generator.regen;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.xml.Documentation;

public class DocumentationDeltaCalculator extends NameBasedDeltaCalculator {

	@Override
	protected Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship,	BaseRelationship newRelationship) {
		Delta result = null;

		Documentation oldDoc = oldRelationship.getDocumentation();
		Documentation newDoc = newRelationship.getDocumentation();
		
		if (oldDoc!=null && !oldDoc.equals(newDoc)) {
			result = new DocumentationDelta(oldRelationship, newRelationship);
		}
		
		return result;
	}


}
