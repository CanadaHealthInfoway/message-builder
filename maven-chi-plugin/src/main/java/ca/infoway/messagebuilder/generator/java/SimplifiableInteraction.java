package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.Interaction;

class SimplifiableInteraction {

	private final Interaction interaction;

	public SimplifiableInteraction(Interaction interaction) {
		this.interaction = interaction;
	}

	public Interaction getInteraction() {
		return this.interaction;
	}

}
