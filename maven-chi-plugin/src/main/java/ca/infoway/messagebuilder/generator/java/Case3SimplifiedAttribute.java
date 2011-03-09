package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;

class Case3SimplifiedAttribute extends Attribute implements MergedRelationshipSupport {

	private final Attribute exemplar;
	private final Map<TypeName, BaseRelationship> mergedRelationships;
	private XmlMappingHelper helper;
	private boolean requiresExtraAnnotation;
	private Documentation mergedDocumentation;

	public Case3SimplifiedAttribute(Attribute exemplar, Map<TypeName,BaseRelationship> mergedRelationships) {
		super(exemplar.getRelationship(), exemplar.getDataType(), exemplar.isIndicator());
		this.exemplar = exemplar;
		this.mergedRelationships = mergedRelationships;
		this.helper = new XmlMappingHelper(extractHelpers(exemplar, mergedRelationships));
		this.mergedDocumentation = new MergedDocumentation(mergedRelationships.values());
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
	
	@Override
	public DataType getDataType() {
		boolean isList = false;
		boolean isSet = false;
		for (BaseRelationship baseRelationship : this.mergedRelationships.values()) {
			isSet |= StandardDataType.isSet(baseRelationship.getRelationship().getType());
			isList |= StandardDataType.isList(baseRelationship.getRelationship().getType());
		}
		return isList && isSet ? createCollectionDataType() : super.getDataType();
	}

	private DataType createCollectionDataType() {
		String type = this.exemplar.getRelationship().getType();
		type = "COLLECTION<" + StringUtils.substringAfter(type, "<");
		String domainType = this.exemplar.getDomainType();
		return new TypeConverter().convertToType(type, domainType);
	}

	public void markMapByPartTypeRequired() {
		this.requiresExtraAnnotation = true;
	}
	@Override
	boolean requiresMapByPartTypeAnnotation() {
		return super.requiresMapByPartTypeAnnotation() || this.requiresExtraAnnotation;
	}
	
	@Override
	public Cardinality getCardinality() {
		return this.exemplar.getCardinality();
	}
	
	@Override
	public Documentation getDocumentation() {
		return this.mergedDocumentation;
	}
}
