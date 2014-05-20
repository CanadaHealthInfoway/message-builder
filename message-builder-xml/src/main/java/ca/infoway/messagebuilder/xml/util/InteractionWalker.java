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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

public class InteractionWalker {

	private final MessageSet messageSet;

	public InteractionWalker(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public void walkInteraction(String interactionId, InteractionVisitor visitor) {
		Interaction interaction = getInteraction(interactionId);
		walkInteraction(interaction, visitor);
	}
	
	public void walkInteraction(Interaction interaction, InteractionVisitor visitor) {
		Deque<String> xpathStack = new ArrayDeque<String>();
		walkInteraction(interaction, xpathStack, visitor);
	}
	
	private void walkInteraction(Interaction interaction, Deque<String> xpathStack, InteractionVisitor visitor) {
		xpathStack.push(interaction.getName());
		
		visitor.visitInteraction(interaction, getXpath(xpathStack));
		
		MessagePart messagePart = getMessagePart(interaction.getSuperTypeName());
		walkMessagePart(messagePart, xpathStack, interaction, visitor, new HashSet<String>());
		
		xpathStack.pop();
	}
	
	private String getXpath(Deque<String> xpathStack) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> descendingIterator = xpathStack.descendingIterator();
		while (descendingIterator.hasNext()) {
			sb.append("/").append(descendingIterator.next());
		}
		return sb.toString();
	}

	private void walkMessagePart(MessagePart messagePart, Deque<String> xpathStack, Interaction interaction, InteractionVisitor visitor, HashSet<String> visitedMessageParts) {

		if (visitedMessageParts.contains(messagePart.getName())) {
			return;
		} else {
			visitedMessageParts.add(messagePart.getName());
		}
		
		visitor.visitMessagePart(messagePart, getXpath(xpathStack));
		
		for (Relationship relationship : messagePart.getRelationships()) {
			
			xpathStack.push(relationship.getName());
			
			visitor.visitRelationship(relationship, getXpath(xpathStack));
			
			if (relationship.isTemplateRelationship()) {
				String templateParameterName = relationship.getTemplateParameterName();
				Argument argument = interaction.getArgumentByTemplateParameterName(templateParameterName);
				
				// the actual xpath name at this point is the template traversal name
				xpathStack.pop();
				xpathStack.push(argument.getTraversalName());
				
				visitor.visitArgument(argument, getXpath(xpathStack));
				
				handleRelationshipMessagePart(argument.getName(), argument.getChoices(), xpathStack, interaction, visitor, visitedMessageParts);
				
			} else if (relationship.isAssociation()) {
				handleRelationshipMessagePart(relationship.getType(), relationship.getChoices(), xpathStack, interaction, visitor, visitedMessageParts);
			}
			
			xpathStack.pop();
		} 
	}

	private void handleRelationshipMessagePart(String relationshipTypeName,	List<Relationship> choices, Deque<String> xpathStack, Interaction interaction, InteractionVisitor visitor, HashSet<String> visitedMessageParts) {
		MessagePart relationshipMessagePart = getMessagePart(relationshipTypeName);
		walkMessagePart(relationshipMessagePart, xpathStack, interaction, visitor, visitedMessageParts);
		
		String currentPath = xpathStack.pop();
		
		// choice names replace the current relationship name (or current choice name, if this is a nested choice)
		for (Relationship choiceRelationship : choices) {
			if (!visitedMessageParts.contains(choiceRelationship.getType())) {
				xpathStack.push(choiceRelationship.getName());
				visitor.visitRelationship(choiceRelationship, getXpath(xpathStack));
				handleRelationshipMessagePart(choiceRelationship.getType(), choiceRelationship.getChoices(), xpathStack, interaction, visitor, visitedMessageParts);
				xpathStack.pop();
			}
		}
		
		xpathStack.push(currentPath);
	}

	private Interaction getInteraction(String type) {
		return this.messageSet.getInteractions().get(type);
	}

	private MessagePart getMessagePart(String type) {
		return this.messageSet.getMessagePart(type);
	}
	
}
