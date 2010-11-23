package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3SimplifiedAssociation extends Association {

	private final Association exemplar;
	private final Map<TypeName, BaseRelationship> mergedRelationships;

	public Case3SimplifiedAssociation(Association exemplar, Map<TypeName,BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getAssociationType(), 
				exemplar.getTemplateVariable(), Collections.<Choice>emptyList());
		this.exemplar = exemplar;
		this.mergedRelationships = mergedRelationships;
	}

	@Override
	public List<Relationship> getAllRelationships() {
		Set<Relationship> result = new LinkedHashSet<Relationship>();
		result.addAll(super.getAllRelationships());
		for (BaseRelationship relationship : this.mergedRelationships.values()) {
			result.addAll(relationship.getAllRelationships());
		}
		return new ArrayList<Relationship>(result);
	}

	Association getExemplar() {
		return this.exemplar;
	}
	
	@Override
	public List<Choice> getAllChoiceTypes() {
		return this.exemplar.getAllChoiceTypes();
	}
	@Override
	public Type getAssociationType() {
		return this.exemplar.getAssociationType();
	}
	@Override
	public String getName() {
		return this.exemplar.getName();
	}
	@Override
	public String getXmlMapping() {
		return this.exemplar.getXmlMapping();
	}
}
