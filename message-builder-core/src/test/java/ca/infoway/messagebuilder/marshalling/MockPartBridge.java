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

package ca.infoway.messagebuilder.marshalling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.Realm;

class MockPartBridge implements PartBridge {

	private boolean isEmpty;
	private String typeName;
	private NullFlavor nullFlavor;
	private List<Realm> realmCode;
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getPropertyName() {
		return "aPropertyName2";
	}

	public List<BaseRelationshipBridge> getRelationshipBridges() {
		return Collections.<BaseRelationshipBridge>emptyList();
	}

	public String getTypeName() {
		return this.typeName;
	}

	public boolean isCollapsed() {
		return false;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public NullFlavor getNullFlavor() {
		return this.nullFlavor;
	}

	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}
	
	public boolean hasNullFlavor() {
		return this.nullFlavor != null;
	}

	public boolean isNullPart() {
		return false;
	}
	
	public void addRealmCode(Realm realmCode) {
		this.realmCode = new ArrayList<Realm>();
		this.realmCode.add(realmCode);
	}
	
	public List<Realm> getRealmCode() {
		return this.realmCode;
	}
}
