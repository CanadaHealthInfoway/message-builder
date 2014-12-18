/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.xml.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.io.IOUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.platform.ResourceLoader;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.SchematronContext;
import ca.infoway.messagebuilder.xml.util.MessageSetUtils;

/**
 * <p>A base class for the message defintion service.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - xml.service - translated manually
 */
public abstract class BaseMessageDefinitionService implements MessageDefinitionService {
	
	protected List<MessageSet> messageSets;

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
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	public Interaction getInteraction(VersionNumber version, String type) {
		return getInteraction(version == null ? null : version.getVersionLiteral(), type);
	}

	/**
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	private Interaction getInteraction(String version, String type) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return null;
		}
		return new MessageSetUtils(messageSet).getInteraction(type);
	}
	
	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	public MessagePart getMessagePart(VersionNumber version, String type) {
		return getMessagePart(version == null ? null : version.getVersionLiteral(), type);
	}
	
	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	private MessagePart getMessagePart(String version, String type) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return null;
		}
		return new MessageSetUtils(messageSet).getMessagePart(type);
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
	public List<Interaction> getAllInteractions(VersionNumber version) {
		return getAllInteractions(version == null ? null : version.getVersionLiteral());
	}

	/**
	 * <p>Get all message parts for a particular version of the specification.
	 * @param version - the version
	 * @return the message parts
	 */
	public Collection<MessagePart> getAllMessageParts(VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return new ArrayList<MessagePart>();
		}
		return new MessageSetUtils(messageSet).getAllMessageParts();
	}

	/**
	 * <p>Get all interactions for a particular version of the specification.
	 * @param version - the version
	 * @return the interactions
	 */
	private List<Interaction> getAllInteractions(String version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return new ArrayList<Interaction>();
		}
		return new MessageSetUtils(messageSet).getAllInteractions();
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
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction, VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return null;
		}
		return new MessageSetUtils(messageSet).getAllMessageParts(interaction);
	}
	
	/**
	 * <p>Get all the root message parts for all message sets.
	 * @return - the message parts
	 */	
	public List<MessagePart> getAllRootMessageParts() {
		List<MessagePart> allRootParts = new ArrayList<MessagePart>();
		for (MessageSet messageSet : getMessageSets()) {
			allRootParts.addAll(new MessageSetUtils(messageSet).getAllRootMessageParts());
		}
		return allRootParts;
	}
	
	/**
	 * <p>Get all the root message parts for a specific message set.
	 * @param version
	 * @return - the message parts
	 */
	public List<MessagePart> getAllRootMessageParts(VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return new ArrayList<MessagePart>();
		}
		return new MessageSetUtils(messageSet).getAllRootMessageParts();
	}
	
	/**
	 * <p>Get all the message parts that a particular root message part references.
	 * @param messagePart - the messagePart
	 * @param version - the version
	 * @return - the message parts
	 */		
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet == null) {
			return new HashMap<String, MessagePart>();
		}
		return new MessageSetUtils(messageSet).getAllRelatedMessageParts(messagePart);
	}

	/**
	 * Determine if the message set for the given version has been generated for R2 data types.
	 */
	public boolean isR2(VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		return messageSet == null ? false : messageSet.isGeneratedAsR2();
	}

	/**
	 * Determine if the message set for the given version defines CDA documents.
	 */
	public boolean isCda(VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		return messageSet == null ? false : messageSet.isCda();
	}

	public ConstrainedDatatype getConstraints(VersionNumber version, String constrainedType) {
		if (constrainedType != null) {
			MessageSet messageSet = findMessageSet(version);
			if (messageSet != null) {
				return messageSet.getConstrainedDatatype(constrainedType);
			}
		}
		return null;
	}
	
	public List<SchematronContext> getAllSchematronContexts(VersionNumber version) {
		MessageSet messageSet = findMessageSet(version);
		if (messageSet != null) {
			return messageSet.getSchematronContexts();
		}
		return Collections.emptyList();
	}

	public List<PackageLocation> getAllPackageLocations(VersionNumber version) {
		List<PackageLocation> packageLocations = new ArrayList<PackageLocation>();
		MessageSet messageSet = findMessageSet(version);
		if (messageSet != null) {
			packageLocations.addAll(messageSet.getPackageLocations().values());
		}
		return packageLocations;
	}
	
	private MessageSet findMessageSet(VersionNumber version) {
		return findMessageSet(version == null ? null : version.getVersionLiteral());
	}
	
	private MessageSet findMessageSet(String version) {
		MessageSet result = null;
		for (MessageSet messageSet : getMessageSets()) {
			if (messageSet.getVersion().equals(version)) {
				result = messageSet;
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

}

