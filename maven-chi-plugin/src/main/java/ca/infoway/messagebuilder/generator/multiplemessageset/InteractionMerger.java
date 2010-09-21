package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Interaction;

public class InteractionMerger {

	private final OutputUI outputUI;

	InteractionMerger(OutputUI outputUI) {
		this.outputUI = outputUI;
	}

	public Interaction merge(Interaction primaryInteraction, Interaction secondaryInteraction) {
		return primaryInteraction;
	}

}
