package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.xml.Interaction;

class MockBridgeFactory implements BridgeFactory {

	PartBridge partBridge;
	Interaction interaction;
	
	public PartBridge createInteractionBridge(InteractionBean tealBean) {
		return this.partBridge;
	}

	public Interaction getInteraction(InteractionBean tealBean) {
		return this.interaction;
	}
}
