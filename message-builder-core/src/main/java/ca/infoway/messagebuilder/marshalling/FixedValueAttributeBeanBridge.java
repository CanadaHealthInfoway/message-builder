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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.xml.Relationship;


class FixedValueAttributeBeanBridge implements AttributeBridge {

	private final BareANY any;
	private final Object value;
	private final Relationship relationship;

	FixedValueAttributeBeanBridge(Relationship relationship, BareANY any) {
		this.relationship = relationship;
		this.any = any;
		this.value = any!=null ? any.getBareValue() : null;  
	}

	FixedValueAttributeBeanBridge(Relationship relationship, Object value) {
		this.relationship = relationship;
		if (value instanceof BareANY) {
			this.any = (BareANY) value;
			this.value = any.getBareValue();
		} else {
			this.value = value;
			this.any = null;
		}
	}
	
	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return false;
	}

	public BareANY getHl7Value() {
		return any;
	}
	
	public String getPropertyName() {
		return "fixed";
	}

	public boolean isAssociation() {
		return false;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public BareANY getHl7Value(int index) {
		throw new UnsupportedOperationException();
	}
}
