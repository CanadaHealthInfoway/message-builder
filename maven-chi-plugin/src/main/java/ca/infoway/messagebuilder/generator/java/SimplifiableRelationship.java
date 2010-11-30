package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.xml.Relationship;

class SimplifiableRelationship implements Named {

	private final Relationship relationship;
	private DataType dataType;
	private SimplifiableType type;
	private TemplateVariable variable;

	public SimplifiableRelationship(Relationship relationship, DataType dataType) {
		this.relationship = relationship;
		this.dataType = dataType;
	}

	public SimplifiableRelationship(Relationship relationship, SimplifiableType type) {
		this.relationship = relationship;
		this.type = type;
	}
	public SimplifiableRelationship(Relationship relationship, TemplateVariable variable) {
		this.relationship = relationship;
		this.variable = variable;
	}
	
	public Relationship getRelationship() {
		return this.relationship;
	}

	public DataType getDataType() {
		return this.dataType;
	}

	public SimplifiableType getType() {
		return this.type;
	}

	public TemplateVariable getVariable() {
		return this.variable;
	}

	public String getName() {
		return this.relationship.getName();
	}

	public boolean isAssociation() {
		return this.relationship.isAssociation();
	}
	public boolean isTemplateType() {
		return this.relationship.isTemplateRelationship();
	}
	public boolean isTemplateParameterPresent() {
		return this.variable != null;
	}
}
