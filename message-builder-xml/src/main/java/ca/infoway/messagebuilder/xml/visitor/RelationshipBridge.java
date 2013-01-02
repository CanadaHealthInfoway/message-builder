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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipBridge {

    private final Relationship relationship;
	private final ElementBridge elementBridge;

	public RelationshipBridge(ElementBridge elementBridge, Relationship relationship) {
		this.elementBridge = elementBridge;
		this.relationship = relationship;
	}

	public boolean isAssociation() {
		return this.relationship.isAssociation();
	}
	public boolean isStructuralAttribute() {
		return this.relationship.isAttribute() && this.relationship.isStructural();
	}

	public List<Element> getElements() {
		return this.elementBridge.getElements(this.relationship);
	}
	
	Element getBase() {
		return this.elementBridge.getBase();
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public Attr getAttribute() {
		return this.elementBridge.getAttribute(this.relationship);
	}
	
	String getXmlName() {
		return this.elementBridge.getXmlName(this.relationship);
	}

	@Override
	public String toString() {
		return "Relationship: " + this.relationship.getName();
	}
	public Set<String> getNames() {
		Set<String> names = new HashSet<String>();
		if (isStructuralAttribute()) {
			names.add(this.relationship.getName());
		} else {
			for (Element element : getElements()) {
				names.add(NodeUtil.getLocalOrTagName(element));
			}
		}
		return names;
	}
}
