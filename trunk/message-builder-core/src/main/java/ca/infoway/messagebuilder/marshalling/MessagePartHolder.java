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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

class MessagePartHolder {

	private class RelationshipComparator implements Comparator<Relationship> {
		public int compare(Relationship o1, Relationship o2) {
			// apply sort: attributes/choices/associations/templates (?? confirm with Mario), then alphabetically within each section
			return new CompareToBuilder()
						.append(o1.isAttribute(), o2.isAttribute())
						.append(o1.isChoice(), o2.isChoice())
						.append(!o1.isTemplateRelationship(), !o2.isTemplateRelationship())
						.append(o1.getName(), o2.getName())
						.toComparison()
						;
		}
	}

	private final MessagePart messagePart;
	private final List<Relationship> allRelationships;
	private Comparator<Relationship> relationshipComparator = new RelationshipComparator();

	MessagePartHolder(MessageDefinitionService service, VersionNumber version, String superTypeName) {
		this(service, version, superTypeName, Arrays.asList(new TypeName(superTypeName)));
	}
	
	MessagePartHolder(MessageDefinitionService service, VersionNumber version, String typeName, List<TypeName> typeHierarchy) {
		this.messagePart = service.getMessagePart(version, typeName);
		this.allRelationships = mergeRelationships(service, version, typeHierarchy);
		// FIXME - TM - relationships should be sorted in a particular order; hold off on this until discuss with Mario
		//            - also, numerous transformation tests will fail once this change is made 
		//Collections.sort(this.allRelationships, this.relationshipComparator);
	}
	
	// tests only
	MessagePartHolder(MessagePart partForTestOnly) {
		this.messagePart = partForTestOnly;
		this.allRelationships = partForTestOnly.getRelationships();
	}

	private List<Relationship> mergeRelationships(MessageDefinitionService service,
			VersionNumber version, List<TypeName> typeHierarchy) {
		List<Relationship> mergedRelationships = new ArrayList<Relationship>(); 
		for (TypeName type : typeHierarchy) {
			MessagePart part = service.getMessagePart(version, type.getName());
			if (part != null) {
				mergedRelationships.addAll(part.getRelationships());
			}
		}
		return mergedRelationships;
	}

	String getName() {
		return this.messagePart.getName();
	}

	List<Relationship> getRelationships() {
		return this.allRelationships;
	}
	
}
