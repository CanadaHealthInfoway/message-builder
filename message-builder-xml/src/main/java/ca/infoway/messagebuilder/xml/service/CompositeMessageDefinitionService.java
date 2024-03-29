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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.SchematronContext;

/**
 * <p>A message definition service that combines the results of other message defintion 
 * services.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - xml.service - translated manually
 */
public class CompositeMessageDefinitionService implements MessageDefinitionService {

	final List<MessageDefinitionService> services;

	/**
	 * <p>Standard constructor.
	 * @param services - the constituent services whose results are being consolidated.
	 */
	public CompositeMessageDefinitionService(List<MessageDefinitionService> services) {
		this.services = services;
	}

	/**
	 * <p>Initialize the service. Pre-initializing the service during system
	 *  start-up can improve the performance of the first user call to do real work. 
	 */
	public void initialize() {
		if (services != null) {
			for (MessageDefinitionService service : services) {
				service.initialize();
			}
		}
	}
	
	/**
	 * <p>Get an interaction by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the interaction
	 */
	public Interaction getInteraction(VersionNumber version, String type) {
		Interaction result = null;
		for (MessageDefinitionService service : this.services) {
			Interaction temp = service.getInteraction(version, type);
			if (temp != null) {
				result = temp;
				break;
			}
		}
		return result;
	}

	/**
	 * <p>Get a message part by name and version.
	 * @param version - the version
	 * @param type - the type name
	 * @return the message part
	 */
	public MessagePart getMessagePart(VersionNumber version, String type) {
		MessagePart result = null;
		for (MessageDefinitionService service : this.services) {
			MessagePart temp = service.getMessagePart(version, type);
			if (temp != null) {
				result = temp;
				break;
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
		Map<String, Interaction> interactionsMap = new TreeMap<String, Interaction>(); // sort by key 
		for (MessageDefinitionService service : this.services) {
			List<Interaction> allInteractions = service.getAllInteractions(includeDuplicateInteractionsWithChangedBusinessNames);
			for (Interaction interaction : allInteractions) {
				String key = interaction.getName();
				if (includeDuplicateInteractionsWithChangedBusinessNames) {
					key += interaction.getBusinessName();
				}
				interactionsMap.put(key, interaction);
			}
		}
		return new ArrayList<Interaction>(interactionsMap.values());
	}

	/**
	 * <p>Get all interactions for a particular version of the specification.
	 * @param version - the version
	 * @return the interactions
	 */
	public List<Interaction> getAllInteractions(VersionNumber version) {
		Map<String, Interaction> interactionsMap = new TreeMap<String, Interaction>(); // sort by key 
		for (MessageDefinitionService service : this.services) {
			List<Interaction> allInteractions = service.getAllInteractions(version);
			for (Interaction interaction : allInteractions) {
				interactionsMap.put(interaction.getName(), interaction);
			}
		}
		return new ArrayList<Interaction>(interactionsMap.values());
	}
	
	/**
	 * <p>Get all the versions known by this service.
	 * @return the versions
	 */
	public Set<String> getSupportedVersions() {
		Set<String> versions = new TreeSet<String>();
		for (MessageDefinitionService service : this.services) {
			versions.addAll(service.getSupportedVersions());
		}
		return versions;
	}

	/**
	 * <p>Get all the versions for a particular interaction.
	 * @param type - the type name of the interaction
	 * @return the versions
	 */
	public Set<String> getSupportedVersionsForInteraction(String type) {
		Set<String> versions = new TreeSet<String>();
		for (MessageDefinitionService service : this.services) {
			Set<String> supportedVersions = service.getSupportedVersionsForInteraction(type);
			versions.addAll(supportedVersions);
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
		if (interaction != null) {
			for (MessageDefinitionService service : this.services) {
				Interaction foundInteraction = service.getInteraction(version, interaction.getName());
				if (foundInteraction != null) {
					return service.getAllMessageParts(interaction, version);
				}
			}
		}
		return new HashMap<String, MessagePart>();
	}
	
	public Collection<MessagePart> getAllMessageParts(VersionNumber version) {
		for (MessageDefinitionService service : this.services) {
			Collection<MessagePart> allMessageParts = service.getAllMessageParts(version);
			if (allMessageParts != null && !allMessageParts.isEmpty()) {
				return allMessageParts;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * <p>Get all the message parts that a particular root message part references.  Currently this method is unimplemented.
	 * @param messagePart - the messagePart
	 * @param version - the version
	 * @return - the message parts
	 */			
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart, VersionNumber version) {
		throw new UnsupportedOperationException();
	}
	/**
	 * <p>Get all the root message parts for all message sets.  Currently this method is unimplemented.
	 * @return - the message parts
	 */	
	public List<MessagePart> getAllRootMessageParts() {
		throw new UnsupportedOperationException();
	}

	public List<MessagePart> getAllRootMessageParts(VersionNumber version) {
		throw new UnsupportedOperationException();
	}

	public boolean isR2(VersionNumber version) {
		for (MessageDefinitionService service : this.services) {
			if (service.isR2(version)) {
				return true;
			}
		}
		return false;
	}

	public boolean isCda(VersionNumber version) {
		for (MessageDefinitionService service : this.services) {
			if (service.isCda(version)) {
				return true;
			}
		}
		return false;
	}

	public ConstrainedDatatype getConstraints(VersionNumber version, String constrainedType) {
		for (MessageDefinitionService service : this.services) {
			ConstrainedDatatype constraints = service.getConstraints(version, constrainedType);
			if (constraints != null) {
				return constraints;
			}
		}
		return null;
	}

	public List<SchematronContext> getAllSchematronContexts(VersionNumber version) {
		for (MessageDefinitionService service : this.services) {
			List<SchematronContext> contexts = service.getAllSchematronContexts(version);
			if (contexts != null) {
				return contexts;
			}
		}
		return null;
	}

	public List<PackageLocation> getAllPackageLocations(VersionNumber version) {
		for (MessageDefinitionService service : this.services) {
			List<PackageLocation> locations = service.getAllPackageLocations(version);
			if (locations != null) {
				return locations;
			}
		}
		return null;
	}
	
}
