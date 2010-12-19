package ca.infoway.messagebuilder.xml.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;

/**
 * <p>A service for looking up defintions of components of a message.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - xml.service - translated manually
 */
public interface MessageDefinitionService {

	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	public MessagePart getMessagePart(String version, String type);
	/**
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	public Interaction getInteraction(String version, String type);
	/**
	 * <p>Get all interactions across all versions.
	 * @param includeDuplicateInteractionsWithChangedBusinessNames 
	 * 	- a flag indicating whether or not to include duplicates
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(boolean includeDuplicateInteractionsWithChangedBusinessNames);
	/**
	 * <p>Get all interactions for a particular version of the specification.
	 * @param version - the version
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(String version);
	/**
	 * <p>Get all the versions known by this service.
	 * @return the versions
	 */
	public Set<String> getSupportedVersions();
	/**
	 * <p>Get all the versions for a particular interaction.
	 * @param type - the type name of the interaction
	 * @return the versions
	 */
	public Set<String> getSupportedVersionsForInteraction(String type);
	/**
	 * <p>Get all the message parts for a particular interaction and version.
	 * @param interaction - the interaction
	 * @param version - the version
	 * @return - the message parts
	 */
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction, String version);
	/**
	 * <p>Get all the message parts that a particular root message part references.
	 * @param messagePart - the messagePart
	 * @param version - the version
	 * @return - the message parts
	 */			
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, String version);
	/**
	 * <p>Get all the root message parts for all message sets.
	 * @return - the message parts
	 */	
	public List<MessagePart> getAllRootMessageParts();
	/**
	 * <p>Get all the root message parts for a specific message set.
	 * @param version
	 * @return - the message parts
	 */
	List<MessagePart> getAllRootMessageParts(String version);
	
}