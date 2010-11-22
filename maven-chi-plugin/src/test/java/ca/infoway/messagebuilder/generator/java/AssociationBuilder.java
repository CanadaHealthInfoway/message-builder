/**
 * 
 */
package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class AssociationBuilder {

	private String name;
	private Cardinality cardinality;
	private Type type;
	private String businessName;
	
	public Association buildStandard() {
		Relationship relationship = new Relationship();
		relationship.setName(this.name);
		relationship.setCardinality(cardinality);
		if (this.type!=null && this.type.getTypeName()!=null) {
			relationship.setType(this.type.getTypeName().getName());
		}
		if (businessName!=null) {
			Documentation documentation = new Documentation();
			documentation.setBusinessName(businessName);
			relationship.setDocumentation(documentation);
		}
		return Association.createStandardAssociation(relationship, this.type);
	}
	
	public AssociationBuilder setName(String name) {
		this.name = name;
		return this;
	}


	public AssociationBuilder setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality;
		return this;
	}

	public AssociationBuilder setType(Type type) {
		this.type = type;
		return this;
	}

	public AssociationBuilder setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}

}