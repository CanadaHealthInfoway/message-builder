package ca.infoway.messagebuilder.marshalling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class MockMessageDefinitionService implements MessageDefinitionService {
	
	private Map<String,MessagePart> parts = new HashMap<String,MessagePart>();
	private Map<String,Interaction> interactions = new HashMap<String,Interaction>();
	
	public List<Interaction> getAllInteractions(
			boolean includeDuplicateInteractionsWithChangedBusinessNames) {
		return null;
	}
	public List<Interaction> getAllInteractions(String version) {
		return null;
	}
	public Map<String, MessagePart> getAllMessageParts(
			Interaction interaction, String version) {
		return null;
	}
	public Interaction getInteraction(String version, String type) {
		return this.interactions.get(type);
	}
	public MessagePart getMessagePart(String version, String type) {
		return this.parts.get(type);
	}
	public Set<String> getSupportedVersions() {
		return null;
	}
	public Set<String> getSupportedVersionsForInteraction(String type) {
		return null;
	}
	public void addPart(String type, MessagePart part) {
		this.parts.put(type, part);
	}
	public void addInteraction(String type, Interaction interaction) {
		this.interactions.put(type, interaction);
	}
}