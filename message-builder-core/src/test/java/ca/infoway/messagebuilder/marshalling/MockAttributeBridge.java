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

class MockAttributeBridge implements AttributeBridge {

	private BareANY hl7Value;
	private Object value;
	private boolean isEmpty;
	Relationship relationship;
	
	public void setHl7Value(BareANY hl7Value) {
		this.hl7Value = hl7Value;
	}

	public BareANY getHl7Value() {
		return this.hl7Value;
	}

	public BareANY getHl7Value(int index) {
		return null;
	}

	public Object getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public String getPropertyName() {
		return null;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public boolean isAssociation() {
		return false;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
