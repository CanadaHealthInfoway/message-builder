package ca.infoway.messagebuilder.xml.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;

/**
 * @sharpen.ignore - xml.service - translated manually
 */
class TrivialService implements MessageDefinitionService {

	public Interaction getInteraction(String version, String type) {
		return null;
	}
	public MessagePart getMessagePart(String version, String type) {
		return null;
	}
	public List<Interaction> getAllInteractions(boolean includeDuplicateInteractionsWithChangedBusinessNames) {
		return null;
	}
	public List<Interaction> getAllInteractions(String version) {
		return null;
	}
	public Set<String> getSupportedVersions() {
		return null;
	}
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction,	String v1) {
		return null;
	}
	public Set<String> getSupportedVersionsForInteraction(String type) {
		return null;
	}
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, String version) {
		return null;
	}
	public List<MessagePart> getAllRootMessageParts() {
		return null;
	}
	public List<MessagePart> getAllRootMessageParts(String version) {
		return null;
	}
}
