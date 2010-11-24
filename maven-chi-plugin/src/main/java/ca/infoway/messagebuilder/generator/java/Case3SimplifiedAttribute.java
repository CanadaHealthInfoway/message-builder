package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3SimplifiedAttribute extends Attribute {

	private final Attribute exemplar;
	private final Map<TypeName, BaseRelationship> mergedRelationships;

	public Case3SimplifiedAttribute(Attribute exemplar, Map<TypeName,BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getDataType(), exemplar.isIndicator());
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

	Attribute getExemplar() {
		return this.exemplar;
	}
	
	@Override
	public String getName() {
		return this.exemplar.getName();
	}
	
	@Override
	public String[] getAllXmlMappings() {
		return this.exemplar.getAllXmlMappings();
	}
}
