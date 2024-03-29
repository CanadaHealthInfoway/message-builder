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

package ca.infoway.messagebuilder.xml.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlNamedNodeMapIterable;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.util.NamespaceUtil;

public class MessageWalker {
	
	private final MessageDefinitionService service;
	private final Document message;
	private final VersionNumber version;

	public MessageWalker(MessageDefinitionService service, Document message, VersionNumber version) {
		this.service = service;
		this.message = message;
		this.version = version;
	}

	public void accept(MessageVisitor visitor) {
		Interaction interaction = getInteraction(this.message);
		if (interaction != null) {
			walk(interaction, visitor);
		} else {
			visitor.visitRoot(this.message.getDocumentElement(), null);
		}
	}

	private void walk(Interaction interaction, MessageVisitor visitor) {
		Element documentElement = this.message.getDocumentElement();
		visitor.visitRoot(documentElement, interaction);
		
		MessagePart messagePart = getMessagePart(interaction.getSuperTypeName());
		processAllRelationships(documentElement, interaction, Arrays.asList(messagePart), visitor);
	}

	private void processAllRelationships(Element element, Interaction interaction,
			List<MessagePart> messagePartAndChoiceExtensionParts, MessageVisitor visitor) {
		Set<String> knownItems = new HashSet<String>();
		
		validateElementOrder(messagePartAndChoiceExtensionParts, element, visitor);
		
		for (MessagePart messagePart : messagePartAndChoiceExtensionParts) {
			ElementBridge helper = new ElementBridge(element, messagePart, getInteraction(element.getOwnerDocument()));
			
			for (RelationshipBridge relationship : helper.getRelationships()) {
				knownItems.addAll(relationship.getNames());
				processRelationship(interaction, messagePart, relationship, visitor);
			}
		}
		
		processUnknownStructuralAttributes(new HashSet<String>(knownItems), element, visitor);
		processUnknownChildElements(new HashSet<String>(knownItems), element, visitor);
	}

	private void processUnknownChildElements(Set<String> knownItems, Element element, MessageVisitor visitor) {
		List<Element> children = NodeUtil.toElementList(element);
		for (Element child : children) {
			if (!NamespaceUtil.isHl7Node(child)) { 
				// ignore it
			} else {
				String localOrTagName = NodeUtil.getLocalOrTagName(child);
				if (!knownItems.contains(localOrTagName)) {
					knownItems.add(localOrTagName);
					// this call will intentionally fail fast with an error (since relationship is null)
					visitor.visitNonStructuralAttribute(element, Arrays.asList(child), null);
				}
			}
		}
	}

	private void processUnknownStructuralAttributes(Set<String> knownItems,	Element element, MessageVisitor visitor) {
		NamedNodeMap attrs = element.getAttributes();
		if (attrs != null) {
			for (Node node : new XmlNamedNodeMapIterable(attrs)) {
				Attr item = (Attr) node;
				if (isIgnorable(item)) {
					// skip it
				} else if (!NamespaceUtil.isHl7Node(item)) {
					// skip it
				} else if (!knownItems.contains(item.getName())) {
					knownItems.add(item.getName());
					// this call will intentionally fail fast with an error (since relationship is null)
					visitor.visitStructuralAttribute(element, item, null);
				}
			}
		}
	}

	private boolean isIgnorable(Attr item) {
		return StringUtils.equals("ITSVersion", item.getName()) || isNamespaceIndicator(item);
	}

	private boolean isNamespaceIndicator(Attr item) {
		return item.getName().startsWith("xmlns");
	}

	private void processRelationship(Interaction interaction, MessagePart messagePart,
			RelationshipBridge relationship, MessageVisitor visitor) {
		
		if (relationship.isStructuralAttribute()) {
			Attr attr = relationship.getAttribute();
			visitor.visitStructuralAttribute(
					relationship.getBase(), attr, relationship.getRelationship());
		} else if (relationship.isAssociation()) {
			visitor.visitAssociation(relationship.getBase(), relationship.getXmlName(), 
					relationship.getElements(), relationship.getRelationship());
			processEachRelationshipValue(interaction, relationship, visitor);
		} else {
			visitor.visitNonStructuralAttribute(relationship.getBase(),
					relationship.getElements(), relationship.getRelationship());
		}
	}

	private void processEachRelationshipValue(Interaction interaction, 
		RelationshipBridge relationshipBridge, MessageVisitor visitor) {
		for (Element child : relationshipBridge.getElements()) {
			Relationship relationship = relationshipBridge.getRelationship();
			List<MessagePart> messageParts = getMessageParts(relationship, interaction, NodeUtil.getLocalOrTagName(child));
			if (!messageParts.isEmpty() && !isNull(child)) {
				processAllRelationships(child, interaction, messageParts, visitor);
			}
		}
	}

	private boolean isNull(Element child) {
		return child.hasAttribute("nullFlavor");
	}

	private List<MessagePart> getMessageParts(Relationship relationship, Interaction interaction, String elementName) {
		
		// error if template and choice
		if (relationship.isTemplateRelationship() && relationship.isChoice()) {
			throw new RuntimeException("Do not know how to handle relationship " + relationship.getName() + ": it is both a choice and a template");
		}
		
		List<MessagePart> parts = new ArrayList<MessagePart>();
		
		if (relationship.isTemplateRelationship()) {
			Argument argument = interaction
					.getArgumentByTemplateParameterName(relationship
							.getTemplateParameterName());
			// HACK: IW/RC: bug 11067: the data in the messageSets is
			// incomplete. Don't NPE, just carry on.
			if (argument != null) {
				addChoiceParts(parts, argument.getChoices(), elementName);
				MessagePart messagePart = getMessagePart(argument.getName());
				if (messagePart != null) {
					parts.add(messagePart);
				}
			}
		} else {
			addChoiceParts(parts, relationship.getChoices(), elementName);
			MessagePart messagePart = getMessagePart(relationship.getType());
			if (messagePart != null) {
				parts.add(messagePart);
			}
		}
		
		return parts;
	}

	// TM: RM #16042 - need to also check supertype of choices, as these can also have relationships (and so on, up the chain)
	private boolean addChoiceParts(List<MessagePart> results, List<Relationship> choices, String elementName) {
		for (Relationship relationship : choices) {
			if (relationship.isChoice()) {
				if (addChoiceParts(results, relationship.getChoices(), elementName)) {
					results.add(getMessagePart(relationship.getType()));
					return true;
				}
			} else if (relationship.getName().equals(elementName)) {
				results.add(getMessagePart(relationship.getType()));
				return true;
			}
		}
		return false;
	}

	private Interaction getInteraction(Document message) {
		return this.service.getInteraction(this.version, getInteractionId(message));
	}

	private String getInteractionId(Document message) {
		return NodeUtil.getLocalOrTagName(message.getDocumentElement());
	}

	private MessagePart getMessagePart(String type) {
		return this.service.getMessagePart(this.version, type);
	}

	private void validateElementOrder(List<MessagePart> messagePartAndChoiceExtensionParts, Element element, MessageVisitor visitor) {
		// create list of properly ordered names (skipping those not provided, and skipping those without a relationship match)
		List<String> properlyOrderedProvidedRelationshipNames = createListOfProperlyOrderedNames(element, messagePartAndChoiceExtensionParts, visitor);
		
		// create list of xml names in the order provided (collapsing duplicates)
		// remove/ignore any not in properly ordered names
		List<String> xmlElementNamesInOrderProvided = createListOfXmlNamesInOrderProvided(element, properlyOrderedProvidedRelationshipNames);

		// iterate proper list, look for exact match
		int expectedSize = properlyOrderedProvidedRelationshipNames.size();
		int actualSize = xmlElementNamesInOrderProvided.size();
		boolean errorDetected = false;
		for (int i = 0; i < expectedSize; i++) {
			String expectedName = properlyOrderedProvidedRelationshipNames.get(i);
			String actualName = actualSize > i ? xmlElementNamesInOrderProvided.get(i) : null; 
			if (!StringUtils.equals(expectedName, actualName)) {
				// if not found, break out and log error "beginning with...", then show expected element order
				errorDetected = true;
				String errorMessage = createElementOutOfOrderErrorMessage(properlyOrderedProvidedRelationshipNames, actualName);
				visitor.addError(errorMessage, element);
				break;
			}
		}

		// the two sets of names should be the same length, but just in case...
		if (!errorDetected && actualSize > expectedSize) {
			String errorMessage = createElementOutOfOrderErrorMessage(properlyOrderedProvidedRelationshipNames, xmlElementNamesInOrderProvided.get(expectedSize));
			visitor.addError(errorMessage, element);
		}
	}

	private String createElementOutOfOrderErrorMessage(List<String> orderedNames, String nameInError) {
		String errorLocation = StringUtils.isBlank(nameInError) ? "": " starting around '" + nameInError + "'";
		return "Elements appear to be out of expected order" + errorLocation + ". Expected order to be: " + listNames(orderedNames);
	}

	private String listNames(Collection<String> orderedNames) {
		 Iterator<String> i = orderedNames.iterator();
		 if (!i.hasNext()) {
			 return "[]";
		 }

		 StringBuilder sb = new StringBuilder();
		 sb.append('[');
		 for (;;) {
		     sb.append(i.next());
			 if (!i.hasNext()) {
			     return sb.append(']').toString();
			 }
			 sb.append(", ");
		 }
	}
	 
	 private List<String> createListOfXmlNamesInOrderProvided(Element element,
			List<String> properlyOrderedProvidedRelationshipNames) {
		List<String> xmlElementNamesInOrderProvided = new ArrayList<String>();
		for (Element currentXmlElement : NodeUtil.toElementList(element)) {
			String elementName = NodeUtil.getLocalOrTagName(currentXmlElement);
			if (properlyOrderedProvidedRelationshipNames.contains(elementName)) {
				// remove consecutive dups (ignore garbage/extra in between; they will be caught later)
				if (xmlElementNamesInOrderProvided.isEmpty() || !xmlElementNamesInOrderProvided.get(xmlElementNamesInOrderProvided.size() - 1).equals(elementName)) {
					xmlElementNamesInOrderProvided.add(elementName);
				}
			}
		}
		return xmlElementNamesInOrderProvided;
	}

	private List<String> createListOfProperlyOrderedNames(Element element, List<MessagePart> messagePartAndChoiceExtensionParts, MessageVisitor visitor) {
		List<String> properlyOrderedProvidedRelationshipNames = new ArrayList<String>();
		for (MessagePart messagePart : messagePartAndChoiceExtensionParts) {
			ElementBridge helper = new ElementBridge(element, messagePart, getInteraction(element.getOwnerDocument()));
			for (RelationshipBridge relationshipBridge : helper.getRelationships()) {
				if (!relationshipBridge.isStructuralAttribute()) {
					Set<String> names = relationshipBridge.getNames();
					if (!names.isEmpty()) {
						Iterator<String> iterator = names.iterator();
						if (iterator.hasNext()) { //For .NET translation
							properlyOrderedProvidedRelationshipNames.add(iterator.next());
						}
						if (names.size() > 1) {
							// not expecting this to ever happen, but need to know if it does so we can adjust the code
							visitor.addError("Internal error: found more than one name " + listNames(names), element);
						}
					}
				}
			}
			
		}
		return properlyOrderedProvidedRelationshipNames;
	}

}
