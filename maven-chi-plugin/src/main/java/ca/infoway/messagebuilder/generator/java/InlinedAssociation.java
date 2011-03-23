package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.xml.Cardinality;


public class InlinedAssociation extends Association {

	private final Association inlinedRelationship;
	private final BaseRelationship elidedRelationship;

	public InlinedAssociation(Association inlinedRelationship, BaseRelationship elidedRelationship) {
		super(inlinedRelationship.getRelationship(), inlinedRelationship.getAssociationType());
		this.inlinedRelationship = inlinedRelationship;
		this.elidedRelationship = elidedRelationship;
	}

	@Override
	public String getName() {
		return this.elidedRelationship.getName() + WordUtils.capitalize(this.inlinedRelationship.getName());
	}
	
	@Override
	public String getXmlMapping() {
		return this.elidedRelationship.getXmlMapping() + "/" + this.inlinedRelationship.getXmlMapping();
	}

	@Override
	public Cardinality getCardinality() {
		Cardinality cardinality = super.getCardinality();
		if (new Cardinality(1,1).equals(cardinality)) {
			return this.elidedRelationship.getCardinality();
		} else {
			return cardinality;
		}
	}
	
	@Override
	public TemplateVariable getTemplateVariable() {
		return this.inlinedRelationship.getTemplateVariable();
	}
	
	@Override
	public String getType() {
		return this.inlinedRelationship.getType();
	}

	Association getInlinedRelationship() {
		return this.inlinedRelationship;
	}

	BaseRelationship getElidedRelationship() {
		return this.elidedRelationship;
	}

}
