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

import java.util.List;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.Realm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.xml.Relationship;

class PartBridgeImpl implements PartBridge {
	
	private final List<BaseRelationshipBridge> relationshipBridges;
	private final String typeName;
	private final boolean collapsed;
	private final String propertyPath;
	private final Object bean;
	private final boolean nullPart;
	
	public PartBridgeImpl(String propertyPath, Object bean, String typeName, List<BaseRelationshipBridge> relationshipBridges, boolean collapsed) {
		this(propertyPath, bean, typeName, relationshipBridges, collapsed, false);
	}
	
	public PartBridgeImpl(String propertyPath, Object bean, String typeName, List<BaseRelationshipBridge> relationshipBridges, boolean collapsed, boolean nullPart) {
		this.propertyPath = propertyPath;
		this.bean = bean;
		this.typeName = typeName;
		this.relationshipBridges = relationshipBridges;
		this.collapsed = collapsed;
		this.nullPart = nullPart;
	}

	public List<BaseRelationshipBridge> getRelationshipBridges() {
		return this.relationshipBridges;
	}

	public String getTypeName() {
		return this.typeName;
	}

	/**
	 * <p>Determine if a part has any content.
	 * 
	 * <p>For the purposes of determining emptiness, we don't consider fixed attributes.
	 * We consider fixed values as not providing real content -- only meta-data.
	 * 
	 * <p>There are some part types that cause especial concern.  For example, the
	 * COCT_MT141007CA.PackagedDevice has only fixed values, and yet it is mandatory.
	 */
	public boolean isEmpty() {
		boolean empty = true;
		for (BaseRelationshipBridge relationship : this.relationshipBridges) {
			Relationship r = relationship.getRelationship();
			if (!relationship.getRelationship().isAttribute() || !r.hasFixedValue()) {
				empty &= relationship.isEmpty();
			}
		}
		// watch out for "indicators", etc.
		if (empty) {
			empty = this.collapsed || this.bean == null || hasNullFlavor();
		}
		return empty;
	}

	public boolean hasNullFlavor() {
		boolean result = false;
		if (this.bean instanceof NullFlavorSupport) {
			NullFlavorSupport nullable = (NullFlavorSupport) this.bean;
			result = nullable.hasNullFlavor();
		}
		return result;
	}
	
	public NullFlavor getNullFlavor() {
		NullFlavor result = null;
		if (this.bean instanceof NullFlavorSupport) {
			NullFlavorSupport nullable = (NullFlavorSupport) this.bean;
			result = nullable.getNullFlavor();
		}
		return result;
	}
	
	public List<Realm> getRealmCode() {
		List<Realm> realm = null;
		if (this.bean instanceof MessagePartBean) {
			MessagePartBean partBean = (MessagePartBean) this.bean;
			realm = partBean.getRealmCode();
		}
		return realm;
	}

	public boolean isCollapsed() {
		return this.collapsed;
	}

	public String getPropertyName() {
		return this.propertyPath;
	}

	public boolean isNullPart() {
		return this.nullPart;
	}
}
