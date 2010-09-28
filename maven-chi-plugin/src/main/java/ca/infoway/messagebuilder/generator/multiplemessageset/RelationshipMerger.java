package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipMerger implements Merger<Relationship> {

	private final OutputUI outputUI;

	RelationshipMerger(OutputUI outputUI) {
		this.outputUI = outputUI;
	}

	public Relationship merge(Relationship primary, String primaryVersion, Relationship secondary, String secondaryVersion) {
		// FIXME - TM - to be implemented in a later story 
		return primary != null ? primary : secondary;
	}

}
