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

package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.domainvalue.util.DomainTypeHelper;
import ca.infoway.messagebuilder.xml.TypeName;

class MergedTypeCollator {
	
	private Map<Fingerprint,Map<TypeName,BaseRelationship>> relationship = 
			new LinkedHashMap<Fingerprint,Map<TypeName,BaseRelationship>>();
	
	private Map<Fingerprint,BaseRelationship> exemplars = new HashMap<Fingerprint,BaseRelationship>();
	
	private void assignExemplarIfAppropriate(Fingerprint fingerprint, BaseRelationship relationship) {
		if (!this.exemplars.containsKey(relationship.getName())) {
			this.exemplars.put(fingerprint, relationship);
		} else {
			BaseRelationship exemplar = this.exemplars.get(fingerprint);
			if (exemplar != null && exemplar.hasDomainType()) {
				String compatibleDomainType = DomainTypeHelper.getCompatibleDomainType(exemplar.getRelationship(), relationship.getRelationship());
				if (compatibleDomainType == null) {
					throw new IllegalStateException("Could not find compatible domain type for merging types: " + exemplar.getType() + ", " + relationship.getType());
				} else if (!DomainTypeHelper.hasDomainType(exemplar.getRelationship(), compatibleDomainType)) {
					this.exemplars.put(fingerprint, relationship);
				}
			}
		}
	}


	Collection<Fingerprint> relationshipNames() {
		return this.relationship.keySet();
	}

	BaseRelationship getExemplar(Fingerprint name) {
		return this.exemplars.get(name);
	}

	Map<TypeName,BaseRelationship> getRelationships(Fingerprint fingerprint) {
		return this.relationship.get(fingerprint);
	}


	void addRelationship(TypeName typeName, BaseRelationship relationship) {
		if (!this.relationship.containsKey(relationship.getFingerprint(typeName))) {
			this.relationship.put(relationship.getFingerprint(typeName), new HashMap<TypeName, BaseRelationship>());
		}
		this.relationship.get(relationship.getFingerprint(typeName)).put(typeName, relationship);
		assignExemplarIfAppropriate(relationship.getFingerprint(typeName), relationship);
	}
}
