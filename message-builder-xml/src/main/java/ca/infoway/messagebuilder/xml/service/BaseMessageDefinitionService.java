package ca.infoway.messagebuilder.xml.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;

import ca.infoway.messagebuilder.platform.ResourceLoader;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>A base class for the message defintion service.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - xml.service - translated manually
 */
public abstract class BaseMessageDefinitionService implements MessageDefinitionService {
	
	protected List<MessageSet> messageSets;

	/**
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	public Interaction getInteraction(String version, String type) {
		Interaction result = null;
		for (MessageSet messageSet : getMessageSets()) {
			if (messageSet.getVersion().equals(version)) {
				result = messageSet.getInteractions().get(type);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * <p>Get the list of message sets.
	 * @return - the message sets
	 */
	protected List<MessageSet> getMessageSets() {
		if (!initialized()) {
			initialize();
		}
		return this.messageSets;
	}

	private boolean initialized() {
		return this.messageSets != null;
	}

	private synchronized void initialize() {
		if (!initialized()) {
			List<MessageSet> list = new ArrayList<MessageSet>();
			MessageSetMarshaller marshaller = new MessageSetMarshaller();
			for (String name : getNames()) {
				InputStream input = ResourceLoader.getResource(getClass(), name);
				try {
					list.add(marshaller.unmarshall(input));
				} catch (Exception e) {
					throw new RuntimeException("Could not read " + name, e);
				} finally {
					IOUtils.closeQuietly(input);
				}
			}
			this.messageSets = Collections.unmodifiableList(list);
		}
	}

	/**
	 * <p>Get the names.
	 * @return - the names
	 * 
	 * @sharpen.protected.internal
	 */
	protected abstract List<String> getNames();

	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	public MessagePart getMessagePart(String version, String type) {
		MessagePart result = null;
		for (MessageSet messageSet : getMessageSets()) {
			if (messageSet.getVersion().equals(version)) {
				result = messageSet.getMessagePart(type);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * <p>Get all interactions across all versions.
	 * @param includeDuplicateInteractionsWithChangedBusinessNames 
	 * 	- a flag indicating whether or not to include duplicates
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(boolean includeDuplicateInteractionsWithChangedBusinessNames) {
		TreeMap<String, Interaction> map = new TreeMap<String, Interaction>();
		for (MessageSet messageSet : getMessageSets()) {
			if (includeDuplicateInteractionsWithChangedBusinessNames) {
				Collection<Interaction> interactions = messageSet.getInteractions().values();
				for (Interaction interaction : interactions) {
					String key = interaction.getName() + interaction.getBusinessName();
					map.put(key, interaction);
				}
			} else {
				map.putAll(messageSet.getInteractions());
			}
		}
		return new ArrayList<Interaction>(map.values());
	}

	/**
	 * <p>Get all interactions for a particular version of the specification.
	 * @param version - the version
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(String version) {
		TreeMap<String, Interaction> map = new TreeMap<String, Interaction>();
		for (MessageSet messageSet : getMessageSets()) {
			if (messageSet.getVersion().equals(version)) {
				map.putAll(messageSet.getInteractions());
			}
		}
		return new ArrayList<Interaction>(map.values());
	}

	/**
	 * <p>Get the supported versions.
	 * @return - the supported versions
	 */
	public Set<String> getSupportedVersions() {
		Set<String> versions = new TreeSet<String>();
		for (MessageSet messageSet : getMessageSets()) {
			String version = messageSet.getVersion();
			versions.add(version);
		}
		return versions;
	}
	
	/**
	 * <p>Get all the versions known by this service.
	 * @param type - the interaction type name
	 * @return the versions
	 */
	public Set<String> getSupportedVersionsForInteraction(String type) {
		Set<String> versions = new TreeSet<String>();
		Set<String> allSupportedVersions = getSupportedVersions();
		for (String version : allSupportedVersions) {
			if (getInteraction(version, type) != null) {
				versions.add(version);
			}
		}
		return versions;
	}
	
	/**
	 * <p>Get all the message parts for a particular interaction and version.
	 * @param interaction - the interaction
	 * @param version - the version
	 * @return - the message parts
	 */
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction, String version) {
		Map<String, MessagePart> allParts = new TreeMap<String, MessagePart>(); 
		if (interaction != null) {
			addMessagePartsFromSupertype(allParts, interaction.getSuperTypeName(), version);
			addMessagePartsFromArguments(allParts, interaction.getArguments(), version);
		}
		return allParts;
	}
	
	/**
	 * <p>Get all the root message parts for all message sets.
	 * @return - the message parts
	 */	
	public List<MessagePart> getAllRootMessageParts() {
		List<MessagePart> allRootParts = new ArrayList<MessagePart>();
		for (MessageSet messageSet : getMessageSets()) {
			for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
				for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
					if (packageLocation.getRootType().equals(messagePart.getName())) {
						allRootParts.add(messagePart);
					}
				}
			}
		}
		return allRootParts;
	}
	
	/**
	 * <p>Get all the message parts that a particular root message part references.
	 * @param messagePart - the messagePart
	 * @param version - the version
	 * @return - the message parts
	 */		
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, String version) {
		Map<String, MessagePart> allParts = new TreeMap<String, MessagePart>(); 
		addMessagePartsFromSupertype(allParts, messagePart.getName(), version);
		return allParts;
	}	

	protected void addMessagePartsFromSupertype(Map<String, MessagePart> allParts, String superTypeName, String version) {
		MessagePart messagePart = this.getMessagePart(version, superTypeName);
		if (!allParts.containsKey(superTypeName)) {
			allParts.put(superTypeName, messagePart);
			if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
				addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds(), version);
			}
			addMessagePartsFromRelationships(allParts, messagePart.getRelationships(), version);
		}
	}

	private void addMessagePartsFromArguments(Map<String, MessagePart> allParts, List<Argument> arguments, String version) {
		if (arguments != null) {
			for (Argument argument : arguments) {
				MessagePart messagePart = this.getMessagePart(version, argument.getName());
				if (!allParts.containsKey(messagePart.getName())) {
					allParts.put(messagePart.getName(), messagePart);
					
					if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
						addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds(), version);
					}
					addMessagePartsFromRelationships(allParts, messagePart.getRelationships(), version);
					addMessagePartsFromArguments(allParts, argument.getArguments(), version);
				}
			}
		}
	}
	
	private void addMessagePartsFromRelationships(Map<String, MessagePart> allParts, List<Relationship> relationships, String version) {
		for (Relationship relationship : relationships) {
			String type = relationship.getType();
			if (type != null) {
				MessagePart messagePart = this.getMessagePart(version, type);
				if (messagePart != null) {
					if (!allParts.containsKey(messagePart.getName())) {
						allParts.put(messagePart.getName(), messagePart);
						if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
							addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds(), version);
						}
						addMessagePartsFromRelationships(allParts, messagePart.getRelationships(), version);
					}
				}
			}
			if (relationship.isChoice()) {
				addMessagePartsFromRelationships(allParts, relationship.getChoices(), version);
			}
		}
	}

	private void addMessagePartsFromSpecializationChilds(Map<String, MessagePart> allParts, List<String> specializationChilds, String version) {
		
		for (String specializationChildName : specializationChilds) {
			if (specializationChildName != null) {
				MessagePart messagePart = this.getMessagePart(version, specializationChildName);
				if (messagePart != null && messagePart.getName() != null) {
					if (!allParts.containsKey(messagePart.getName())) {
						allParts.put(messagePart.getName(), messagePart);
						if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
							addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds(), version);
						}
						addMessagePartsFromRelationships(allParts, messagePart.getRelationships(), version);
					}
				}
			}
		}
	}

}

