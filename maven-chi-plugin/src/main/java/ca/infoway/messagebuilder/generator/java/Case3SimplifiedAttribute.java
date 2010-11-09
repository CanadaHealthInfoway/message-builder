package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.Relationship;

class Case3SimplifiedAttribute extends Attribute {

	private final List<BaseRelationship> mergedRelationships;
	private final Attribute exemplar;

	public Case3SimplifiedAttribute(Attribute exemplar, List<BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getDataType(), exemplar.isIndicator());
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

	Attribute getExemplar() {
		return this.exemplar;
	}
}
