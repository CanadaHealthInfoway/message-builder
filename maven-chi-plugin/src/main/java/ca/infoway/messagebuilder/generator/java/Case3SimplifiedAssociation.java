package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.Relationship;

class Case3SimplifiedAssociation extends Association {

	private final List<BaseRelationship> mergedRelationships;
	private final Association exemplar;

	public Case3SimplifiedAssociation(Association exemplar, List<BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getAssociationType(), exemplar.getTemplateVariable());
		this.exemplar = exemplar;
		this.mergedRelationships = mergedRelationships;
	}

	@Override
	public List<Relationship> getAllRelationships() {
		List<Relationship> result = new ArrayList<Relationship>();
		result.addAll(super.getAllRelationships());
		for (BaseRelationship relationship : this.mergedRelationships) {
			result.addAll(relationship.getAllRelationships());
		}
		return result;
	}

	Association getExemplar() {
		return this.exemplar;
	}
}
