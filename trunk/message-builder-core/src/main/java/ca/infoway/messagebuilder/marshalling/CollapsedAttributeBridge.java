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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;

class CollapsedAttributeBridge implements AttributeBridge {

	private final Relationship relationship;
	private BareANY any;
	private Object value;
	private final String propertyName;

	public CollapsedAttributeBridge(String propertyName, Relationship relationship, Object value) {
		this.propertyName = propertyName;
		this.relationship = relationship;
		
		if (value instanceof BareANY) {
			this.any = (BareANY) value;
			this.value = this.any.getBareValue();
		} else {
			this.value = value;
			this.any = null;
		}
	}

	public BareANY getHl7Value() {
		return this.any;
	}

	public BareANY getHl7Value(int index) {
		throw new UnsupportedOperationException();
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return this.value == null;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return false;
	}
}
