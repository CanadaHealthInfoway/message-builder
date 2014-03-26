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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.xml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

public class MessageSetUtils {

	private final MessageSet messageSet;

	public MessageSetUtils(MessageSet messageSet) {
		this.messageSet = messageSet;
	}
	
	public Interaction getInteraction(String type) {
		return this.messageSet.getInteractions().get(type);
	}

	public MessagePart getMessagePart(String type) {
		return this.messageSet.getMessagePart(type);
	}
	
	public Collection<MessagePart> getAllMessageParts() {
		return this.messageSet.getAllMessageParts();
	}
	
	public List<Interaction> getAllInteractions() {
		TreeMap<String, Interaction> map = new TreeMap<String, Interaction>(this.messageSet.getInteractions());
		return new ArrayList<Interaction>(map.values());
	}

	public List<MessagePart> getAllRootMessageParts() {
		List<MessagePart> allRootParts = new ArrayList<MessagePart>();
		for (PackageLocation packageLocation : this.messageSet.getPackageLocations().values()) {
			MessagePart rootMessagePart = this.getMessagePart(packageLocation.getRootType());
			if (rootMessagePart != null) {
				allRootParts.add(rootMessagePart);
			}
		}
		return allRootParts;
	}
	
	public Map<String, MessagePart> getAllMessageParts(Interaction interaction) {
		Map<String, MessagePart> allParts = new TreeMap<String, MessagePart>(); 
		if (interaction != null) {
			// supertype
			addMessagePartsFromType(allParts, interaction.getSuperTypeName());
			addMessagePartsFromArguments(allParts, interaction.getArguments());
		}
		return allParts;
	}
	
	public Map<String, MessagePart> getAllRelatedMessageParts(MessagePart messagePart) {
		return getAllRelatedMessageParts(messagePart.getName());
	}

	public Map<String, MessagePart> getAllRelatedMessageParts(String messagePart) {
		Map<String, MessagePart> allParts = new TreeMap<String, MessagePart>(); 
		addMessagePartsFromType(allParts, messagePart);
		return allParts;
	}

	private void addMessagePartsFromType(Map<String, MessagePart> allParts, String superTypeName) {
		MessagePart messagePart = this.getMessagePart(superTypeName);
		if (!allParts.containsKey(superTypeName)) {
			allParts.put(superTypeName, messagePart);
			if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
				addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds());
			}
			addMessagePartsFromRelationships(allParts, messagePart.getRelationships());
		}
	}

	private void addMessagePartsFromArguments(Map<String, MessagePart> allParts, List<Argument> arguments) {
		if (arguments != null) {
			for (Argument argument : arguments) {
				MessagePart messagePart = this.getMessagePart(argument.getName());
				if (!allParts.containsKey(messagePart.getName())) {
					allParts.put(messagePart.getName(), messagePart);
					
					if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
						addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds());
					}
					addMessagePartsFromRelationships(allParts, messagePart.getRelationships());
					addMessagePartsFromArguments(allParts, argument.getArguments());
				}
			}
		}
	}
	
	private void addMessagePartsFromRelationships(Map<String, MessagePart> allParts, List<Relationship> relationships) {
		for (Relationship relationship : relationships) {
			String type = relationship.getType();
			if (type != null) {
				MessagePart messagePart = this.getMessagePart(type);
				if (messagePart != null) {
					if (!allParts.containsKey(messagePart.getName())) {
						allParts.put(messagePart.getName(), messagePart);
						if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
							addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds());
						}
						addMessagePartsFromRelationships(allParts, messagePart.getRelationships());
					}
				}
			}
			if (relationship.isChoice()) {
				addMessagePartsFromRelationships(allParts, relationship.getChoices());
			}
		}
	}

	private void addMessagePartsFromSpecializationChilds(Map<String, MessagePart> allParts, List<SpecializationChild> specializationChilds) {
		for (SpecializationChild specializationChild : specializationChilds) {
			if (specializationChild != null && specializationChild.getName() != null) {
				MessagePart messagePart = this.getMessagePart(specializationChild.getName());
				if (messagePart != null && messagePart.getName() != null) {
					if (!allParts.containsKey(messagePart.getName())) {
						allParts.put(messagePart.getName(), messagePart);
						if (messagePart.isAbstract() && !messagePart.getSpecializationChilds().isEmpty()) {
							addMessagePartsFromSpecializationChilds(allParts, messagePart.getSpecializationChilds());
						}
						addMessagePartsFromRelationships(allParts, messagePart.getRelationships());
					}
				}
			}
		}
	}
}
