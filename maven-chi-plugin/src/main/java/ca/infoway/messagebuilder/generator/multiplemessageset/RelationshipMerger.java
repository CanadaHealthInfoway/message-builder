package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipMerger implements Merger<Relationship> {

	private final MergeContext context;

	RelationshipMerger(MergeContext context) {
		this.context = context;
	}

	public Relationship merge(Relationship primary, Relationship secondary) {
		// FIXME - TM - to be implemented in a later story 
		return primary != null ? primary : secondary;
	}

}
