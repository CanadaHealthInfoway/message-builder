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
import java.util.List;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.transport.HL7StandardVersionCode;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.xml.Relationship;

class TopLevelBeanBridgeWrapper implements PartBridge {

	public class FixedValueIfNotProvidedAttributeBeanBridge extends FixedValueAttributeBeanBridge {

		private final AttributeBridge relationshipBridge;

		public FixedValueIfNotProvidedAttributeBeanBridge(
				AttributeBridge relationshipBridge, BareANY any) {
			super(relationshipBridge.getRelationship(), any);
			this.relationshipBridge = relationshipBridge;
		}
		@Override
		public BareANY getHl7Value() {
			BareANY any = this.relationshipBridge.getHl7Value();
			if (any == null || any.getBareValue() == null) {
				return super.getHl7Value();
			} else {
				return any;
			}
		}
	}

	private final PartBridge bridge;
	private final String interactionId;
	private final VersionNumber version;
	private final IiValidationUtils iiValidationUtils = new IiValidationUtils();

	public TopLevelBeanBridgeWrapper(PartBridge bridge, String interactionId, VersionNumber version) {
		this.bridge = bridge;
		this.interactionId = interactionId;
		this.version = version;
	}
	
	public List<BaseRelationshipBridge> getRelationshipBridges() {
		List<BaseRelationshipBridge> result = new ArrayList<BaseRelationshipBridge>();
		for (BaseRelationshipBridge relationshipBridge : this.bridge.getRelationshipBridges()) {
			Relationship r = relationshipBridge.getRelationship();
			if ("versionCode".equals(relationshipBridge.getRelationship().getName())
					&& !r.hasFixedValue()) {
				result.add(new FixedValueIfNotProvidedAttributeBeanBridge((AttributeBridge) relationshipBridge, 
						new CSImpl(HL7StandardVersionCode.V3_2007_05)));
			} else if ("interactionId".equals(relationshipBridge.getRelationship().getName())) {
				IIImpl iiImpl = new IIImpl(new Identifier("2.16.840.1.113883.1.6", this.interactionId));
				if (iiValidationUtils.isSpecializationTypeRequired(version, relationshipBridge.getRelationship().getType(), false)) {
					// we must set a concrete specialization type when defined as abstract
					iiImpl.setDataType(StandardDataType.II_PUBLIC);
				}
				result.add(new FixedValueIfNotProvidedAttributeBeanBridge((AttributeBridge) relationshipBridge, 
						iiImpl));
			} else {
				result.add(relationshipBridge);
			}
		}
		return result;
	}

	public String getTypeName() {
		return this.interactionId;
	}

	public boolean isEmpty() {
		return this.bridge.isEmpty();
	}

	public String getPropertyName() {
		return this.bridge.getPropertyName();
	}

	public boolean isCollapsed() {
		return false;
	}

	public NullFlavor getNullFlavor() {
		return null;
	}

	public boolean hasNullFlavor() {
		return false;
	}

	public boolean isNullPart() {
		return false;
	}
}
