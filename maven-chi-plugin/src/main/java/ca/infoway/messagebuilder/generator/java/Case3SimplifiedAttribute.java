package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.TypeName;

class Case3SimplifiedAttribute extends Attribute {

	private final Attribute exemplar;
	private final Map<TypeName, BaseRelationship> mergedRelationships;
	private XmlMappingHelper helper;

	public Case3SimplifiedAttribute(Attribute exemplar, Map<TypeName,BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getDataType(), exemplar.isIndicator());
		this.exemplar = exemplar;
		this.mergedRelationships = mergedRelationships;
		this.helper = new XmlMappingHelper(extractHelpers(exemplar, mergedRelationships));
	}

	private List<XmlMappingHelper> extractHelpers(BaseRelationship exemplar,
			Map<TypeName, BaseRelationship> mergedRelationships) {
		List<XmlMappingHelper> helpers = new ArrayList<XmlMappingHelper>();
		helpers.add(exemplar.getXmlMappingHelper());
		for (BaseRelationship relationship : mergedRelationships.values()) {
			helpers.add(relationship.getXmlMappingHelper());
		}
		return helpers;
	}
	
	@Override
	public String getName() {
		return this.exemplar.getName();
	}
	
	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.helper;
	}
}
