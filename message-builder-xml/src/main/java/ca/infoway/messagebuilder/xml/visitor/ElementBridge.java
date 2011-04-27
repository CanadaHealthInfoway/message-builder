/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

class ElementBridge {

	private final Element base;
	private final MessagePart messagePart;
	private final Interaction interaction;

	public ElementBridge(Element element, MessagePart messagePart, Interaction interaction) {
		this.base = element;
		this.messagePart = messagePart;
		this.interaction = interaction;
	}

	public List<Element> getElements(Relationship relationship) {
		List<Element> result = new ArrayList<Element>();
		Set<String> name = getElementNames(relationship);
		
		for (Element element : NodeUtil.toElementList(this.base)) {
			String elementName = NodeUtil.getLocalOrTagName(element);
			if (name.contains(elementName)) {
				result.add(element);
			}
		}
		return result;
	}

	String getXmlName(Relationship relationship) {
		if (relationship.isTemplateRelationship()) {
			Argument argument = this.interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			// HACK: IW/RC: bug 11067: the data in the messageSets is incomplete.  Don't NPE, just carry on.
			return (argument == null) ? null : argument.getTraversalName();
		} else {
			return relationship.getName();
		}
	}
	
	private Set<String> getElementNames(Relationship relationship) {
		Set<String> result = new HashSet<String>();
		if (relationship.isChoice()) {
			for (Relationship choice : relationship.getChoices()) {
				result.addAll(getElementNames(choice));
			}
		} else if (relationship.isTemplateRelationship()) {
			Argument argument = this.interaction.getArgumentByTemplateParameterName(relationship.getTemplateParameterName());
			if (argument != null && argument.isChoice()) {
				result.addAll(getElementNames(argument));
			} else if (argument != null) {
				result.add(argument.getTraversalName());
			}
		} else {
			result.add(relationship.getName());
		}
		return result;
	}

	private Set<String> getElementNames(Argument argument) {
		Set<String> result = new HashSet<String>();
		for (Relationship relationship : argument.getChoices()) {
			result.addAll(getElementNames(relationship));
		}
		return result;
	}

	public List<RelationshipBridge> getRelationships() {
		List<RelationshipBridge> result = new ArrayList<RelationshipBridge>();
		// HACK: DGH: bug 11067: the data in the messageSets is incomplete.  Don't NPE, just carry on.
		if (this.messagePart != null) {
			for (Relationship relationship : this.messagePart.getRelationships()) {
				result.add(new RelationshipBridge(this, relationship));
			}
		}
		return result;
	}
	
	Element getBase() {
		return this.base;
	}

	public Attr getAttribute(Relationship relationship) {
		if (relationship.isAttribute() && relationship.isStructural()) {
			return this.base.getAttributeNode(relationship.getName());
		} else {
			return null;
		}
	}
}
