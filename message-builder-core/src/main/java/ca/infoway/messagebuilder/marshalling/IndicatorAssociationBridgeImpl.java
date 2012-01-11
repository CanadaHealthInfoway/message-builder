/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.xml.Relationship;

class IndicatorAssociationBridgeImpl implements AssociationBridge {
	
	private final Relationship relationship;
	private final List<PartBridge> parts;
	private final BeanProperty beanProperty;

	public IndicatorAssociationBridgeImpl(Relationship relationship, PartBridge bridge, BeanProperty beanProperty) {
		this.relationship = relationship;
		this.beanProperty = beanProperty;
		this.parts = Arrays.asList(bridge);
	}

	public Collection<PartBridge> getAssociationValues() {
		return isEmpty() ? Collections.<PartBridge>emptyList() : this.parts;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return true;
	}

	public boolean isEmpty() {
		// null flavor does *not* read as empty
		return Boolean.FALSE.equals(this.beanProperty == null ? null : this.beanProperty.get());
	}

	public String getPropertyName() {
		return null;
	}
}
