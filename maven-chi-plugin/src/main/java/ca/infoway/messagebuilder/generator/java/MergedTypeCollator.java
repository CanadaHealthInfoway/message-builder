package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
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
		if (!this.relationship.containsKey(relationship.getFingerprint())) {
			this.relationship.put(relationship.getFingerprint(), new HashMap<TypeName, BaseRelationship>());
		}
		this.relationship.get(relationship.getFingerprint()).put(typeName, relationship);
		assignExemplarIfAppropriate(relationship.getFingerprint(), relationship);
	}
}
