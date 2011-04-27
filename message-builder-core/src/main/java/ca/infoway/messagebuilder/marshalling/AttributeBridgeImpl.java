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

package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.j5goodies.BeanProperty;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>An implementation of the AttributeBridge interface.  This class
 * provides access to a single HL7 attribute in a part.  
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class AttributeBridgeImpl implements AttributeBridge {

	private final Relationship relationship;
	private final BeanProperty property;

	AttributeBridgeImpl(Relationship relationship, BeanProperty property) {
		this.relationship = relationship;
		this.property = property;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return false;
	}
	
	public Object getValue() {
		return this.property == null ? null : this.property.get();
	}

	public boolean isEmpty() {
		return EmptinessUtil.isEmpty(getValue());
	}

	public BareANY getHl7Value() {
		return this.property == null ? null : new DataTypeFieldHelper(property.getBean(), property.getName()).get(BareANY.class);
	}

	public String getPropertyName() {
		return this.property == null ? "" : this.property.getName();
	}
	public String toString() {
		return this.relationship.toString() + " -> " + describeProperty();
	}

	private String describeProperty() {
		if (this.property == null) {
			return "nothing";
		} else {
			return ClassUtils.getShortClassName(this.property.getBeanType()) + "." + this.property.getName();
		}
	}

	public BareANY getHl7Value(int index) {
		Object list = this.property == null ? null : new DataTypeFieldHelper(property.getBean(), property.getName()).get(Object.class);
		if (this.property.isCollection() && ListElementUtil.count(list) < index) {
			return (BareANY) ListElementUtil.getElement(list, index);
		} else {
			return null;
		}
	}
}
