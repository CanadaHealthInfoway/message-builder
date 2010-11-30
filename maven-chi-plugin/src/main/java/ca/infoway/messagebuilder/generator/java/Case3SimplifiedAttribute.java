package ca.infoway.messagebuilder.generator.java;

import java.util.Map;

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
	public String getName() {
		return this.exemplar.getName();
	}
	
	@Override
	XmlMappingHelper getXmlMappingHelper() {
		return this.exemplar.getXmlMappingHelper();
	}
}
