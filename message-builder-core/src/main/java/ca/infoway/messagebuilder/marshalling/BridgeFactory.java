package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.xml.Interaction;

interface BridgeFactory {
	public PartBridge createInteractionBridge(InteractionBean tealBean);
	public Interaction getInteraction(InteractionBean tealBean);
}
