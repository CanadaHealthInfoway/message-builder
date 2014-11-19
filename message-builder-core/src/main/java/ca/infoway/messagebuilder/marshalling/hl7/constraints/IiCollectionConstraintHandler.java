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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-16 20:53:38 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6878 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.constraints;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class IiCollectionConstraintHandler {

	public class ConstraintResult {
		private final Identifier identifer;
		private final boolean foundMatch;
		private final boolean isTemplateId;

		public ConstraintResult(boolean foundMatch, boolean isTemplateId, Identifier identifer) {
			this.foundMatch = foundMatch;
			this.isTemplateId = isTemplateId;
			this.identifer = identifer;
		}
		public Identifier getIdentifer() {return identifer;}
		public boolean isFoundMatch() {return foundMatch;}
		public boolean isTemplateId() {return isTemplateId;}
	}
	
	public ConstraintResult checkConstraints(String type, ConstrainedDatatype constraints, Collection<BareANY> collection) {
		// pull out root/extension fixed constraints
		// check for a match within collection
		// if no match, add to collection (last?)
		if (constraints != null && collection != null) {
			if ("II".equals(type)) {
				String fixedRootValue = null;
				Relationship rootRelationship = constraints.getRelationship("root");
				if (rootRelationship != null) {
					fixedRootValue = rootRelationship.getFixedValue();
				}
				
				String fixedExtensionValue = null;
				Relationship extensionRelationship = constraints.getRelationship("extension");
				if (extensionRelationship != null) {
					fixedExtensionValue = extensionRelationship.getFixedValue();
				}

				boolean hasFixedConstraint = fixedRootValue != null || fixedExtensionValue != null;
				if (hasFixedConstraint) {
					Identifier matchingIdentifier = null;
					for (BareANY item : collection) {
						Object value = item.getBareValue();
						if (value instanceof Identifier) {
							Identifier id = (Identifier) value;
							if (fixedRootValue == null || fixedRootValue.equals(id.getRoot())) {
								if (fixedExtensionValue == null || fixedExtensionValue.equals(id.getExtension())) {
									matchingIdentifier = id;
									break;
								}
							}
						}
					}
					
					boolean foundMatch = (matchingIdentifier != null);
					boolean isTemplateId = (constraints.getName() == null ? false : constraints.getName().endsWith(".templateId"));
					Identifier identifer = (foundMatch ? matchingIdentifier : new Identifier(fixedRootValue, fixedExtensionValue));
					
					return new ConstraintResult(foundMatch, isTemplateId, identifer);
				}
			}
		}
		return null;
	}
	
}
