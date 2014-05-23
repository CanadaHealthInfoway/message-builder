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
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 * @sharpen.ignore - java-only utility 
 */
public class InteractionWalker {

	private class RelationshipMessagePartPair {
		private final String relationship;
		private final String messagePart;
		public RelationshipMessagePartPair(String relationship, String messagePart) {
			this.relationship = relationship;
			this.messagePart = messagePart;
		}
		public String getRelationship() {
			return relationship;
		}
		public String getMessagePart() {
			return messagePart;
		}
	}
	
	private final Log log = LogFactory.getLog(InteractionWalker.class);

	private final MessageSet messageSet;

	public InteractionWalker(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public void walkInteraction(String interactionId, InteractionVisitor visitor) {
		Interaction interaction = getInteraction(interactionId);
		walkInteraction(interaction, visitor);
	}
	
	public void walkInteraction(Interaction interaction, InteractionVisitor visitor) {
		Deque<RelationshipMessagePartPair> xpathStack = new ArrayDeque<RelationshipMessagePartPair>();
		walkInteraction(interaction, xpathStack, visitor);
	}
	
	private void walkInteraction(Interaction interaction, Deque<RelationshipMessagePartPair> xpathStack, InteractionVisitor visitor) {
		xpathStack.push(new RelationshipMessagePartPair(interaction.getName(), interaction.getName()));
		
		visitor.visitInteraction(interaction, getXpath(xpathStack));
		
		MessagePart messagePart = getMessagePart(interaction.getSuperTypeName());
		walkMessagePart(messagePart, xpathStack, interaction, visitor);
		
		xpathStack.pop();
	}
	
	private String getXpath(Deque<RelationshipMessagePartPair> xpathStack) {
		StringBuilder sb = new StringBuilder();
		Iterator<RelationshipMessagePartPair> descendingIterator = xpathStack.descendingIterator();
		while (descendingIterator.hasNext()) {
			sb.append("/").append(descendingIterator.next().getRelationship());
		}
		return sb.toString();
	}

	private void walkMessagePart(MessagePart messagePart, Deque<RelationshipMessagePartPair> xpathStack, Interaction interaction, InteractionVisitor visitor) {

		if (recursiveLoopDetected(xpathStack, messagePart.getName())) {
			this.log.warn("Skipping recursive message part: " + messagePart.getName());
			return;
		}
		
		visitor.visitMessagePart(messagePart, getXpath(xpathStack));
		
		for (Relationship relationship : messagePart.getRelationships()) {
			
			xpathStack.push(new RelationshipMessagePartPair(relationship.getName(), relationship.getParentType()));
			
			visitor.visitRelationship(relationship, getXpath(xpathStack));
			
			if (relationship.isTemplateRelationship()) {
				String templateParameterName = relationship.getTemplateParameterName();
				Argument argument = interaction.getArgumentByTemplateParameterName(templateParameterName);
				
				// the actual xpath name at this point is the template traversal name
				xpathStack.pop();
				xpathStack.push(new RelationshipMessagePartPair(argument.getTraversalName(), relationship.getParentType()));
				
				visitor.visitArgument(argument, getXpath(xpathStack));
				
				handleRelationshipMessagePart(argument.getName(), argument.getChoices(), relationship.getParentType(), xpathStack, interaction, visitor);
				
			} else if (relationship.isAssociation()) {
				handleRelationshipMessagePart(relationship.getType(), relationship.getChoices(), relationship.getParentType(), xpathStack, interaction, visitor);
			}
			
			xpathStack.pop();
		} 
	}

	private void handleRelationshipMessagePart(String relationshipTypeName,	List<Relationship> choices, String parentType, Deque<RelationshipMessagePartPair> xpathStack, Interaction interaction, InteractionVisitor visitor) {
		MessagePart relationshipMessagePart = getMessagePart(relationshipTypeName);
		walkMessagePart(relationshipMessagePart, xpathStack, interaction, visitor);
		
		RelationshipMessagePartPair currentPath = xpathStack.pop();
		
		// choice names replace the current relationship name (or current choice name, if this is a nested choice)
		for (Relationship choiceRelationship : choices) {
			if (recursiveLoopDetected(xpathStack, choiceRelationship.getType())) {
				this.log.error("Skipping recursive message part: " + choiceRelationship.getType());
			} else {
				xpathStack.push(new RelationshipMessagePartPair(choiceRelationship.getName(), parentType));
				visitor.visitRelationship(choiceRelationship, getXpath(xpathStack));
				handleRelationshipMessagePart(choiceRelationship.getType(), choiceRelationship.getChoices(), parentType, xpathStack, interaction, visitor);
				xpathStack.pop();
			}
		}
		
		xpathStack.push(currentPath);
	}
	
	private boolean recursiveLoopDetected(Deque<RelationshipMessagePartPair> xpathStack, String typeToCheck) {
		for (RelationshipMessagePartPair relationshipMessagePartPair : xpathStack) {
			if (typeToCheck.equals(relationshipMessagePartPair.getMessagePart())) {
				return true;
			}
		}
		return false;
	}

	private Interaction getInteraction(String type) {
		return this.messageSet.getInteractions().get(type);
	}

	private MessagePart getMessagePart(String type) {
		return this.messageSet.getMessagePart(type);
	}
	
}
