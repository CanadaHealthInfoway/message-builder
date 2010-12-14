package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.TypeName;

class Case3SimplifiedAssociation extends Association implements MergedRelationshipSupport {

	private final Association exemplar;
	private XmlMappingHelper helper;
	private boolean requiresExtraAnnotation;

	public Case3SimplifiedAssociation(Association exemplar, Map<TypeName,BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getAssociationType(), 
				exemplar.getTemplateVariable(), Collections.<Choice>emptyList());
		this.exemplar = exemplar;
		this.helper = new XmlMappingHelper(extractHelpers(exemplar, mergedRelationships.values()));
	}

	Case3SimplifiedAssociation(Association exemplar, Collection<BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getAssociationType(), 
				exemplar.getTemplateVariable(), Collections.<Choice>emptyList());
		this.exemplar = exemplar;
		this.helper = new XmlMappingHelper(extractHelpers(exemplar, mergedRelationships));
	}
	
	private List<XmlMappingHelper> extractHelpers(Association exemplar,
			Collection<BaseRelationship> mergedRelationships) {
		List<XmlMappingHelper> helpers = new ArrayList<XmlMappingHelper>();
		helpers.add(exemplar.getXmlMappingHelper());
		for (BaseRelationship relationship : mergedRelationships) {
			helpers.add(relationship.getXmlMappingHelper());
		}
		return helpers;
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
	XmlMappingHelper getXmlMappingHelper() {
		return this.helper;
	}
	public void markMapByPartTypeRequired() {
		this.requiresExtraAnnotation = true;
	}
	@Override
	boolean requiresMapByPartTypeAnnotation() {
		return super.requiresMapByPartTypeAnnotation() || this.requiresExtraAnnotation;
	}
}
