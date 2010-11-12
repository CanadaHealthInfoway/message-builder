package ca.infoway.messagebuilder.generator.java;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.xml.TypeName;

class MergedTypeCollator {
	
	private Map<String,Map<TypeName,BaseRelationship>> relationships = 
			new LinkedHashMap<String,Map<TypeName,BaseRelationship>>();
	private Map<String,BaseRelationship> exemplars = new HashMap<String,BaseRelationship>();
	
	
	public void addRelationship(TypeName name, BaseRelationship relationship) {
		if (!this.relationships.containsKey(relationship.getName())) {
			this.relationships.put(relationship.getName(), new HashMap<TypeName, BaseRelationship>());
		}
		this.relationships.get(relationship.getName()).put(name, relationship);
		assignExemplarIfAppropriate(relationship);
	}


	private void assignExemplarIfAppropriate(BaseRelationship relationship) {
		if (!this.exemplars.containsKey(relationship.getName())) {
			this.exemplars.put(relationship.getName(), relationship);
		} else {
			BaseRelationship exemplar = this.exemplars.get(relationship.getName());
			if (exemplar != null && exemplar.hasDomainType()) {
				String compatibleDomainType = DomainTypeHelper.getCompatibleDomainType(exemplar.getRelationship(), relationship.getRelationship());
				if (compatibleDomainType == null) {
					throw new IllegalStateException("Could not find compatible domain type for merging types: " + exemplar.getType() + ", " + relationship.getType());
				} else if (!DomainTypeHelper.hasDomainType(exemplar.getRelationship(), compatibleDomainType)) {
					this.exemplars.put(relationship.getName(), relationship);
				}
			}
		}
	}


	public Collection<String> relationshipNames() {
		return this.relationships.keySet();
	}


	public BaseRelationship getExemplar(String name) {
		return this.exemplars.get(name);
	}


	public Map<TypeName,BaseRelationship> getRelationships(String name) {
		return this.relationships.get(name);
	}
}
