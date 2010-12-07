/**
 * 
 */
package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public class AttributeBuilder {
	private String name;
	private String documentation;
	private String fixedValue;
	private ConformanceLevel conformanceLevel;
	private DataType dataType;
	private String businessName;

	public AttributeBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public AttributeBuilder setDocumentation(String documentation) {
		this.documentation = documentation;
		return this;
	}

	public Attribute build() {
		Relationship relationship = new Relationship();
		relationship.setName(this.name);
		if (this.documentation!=null) {
			relationship.setDocumentation(new Documentation(new Annotation(this.documentation)));
		}
		if (this.fixedValue!=null) {
			relationship.setFixedValue(this.fixedValue);
		}
		if (this.conformanceLevel!=null) {
			relationship.setConformance(this.conformanceLevel);
		}
		if (this.businessName!=null) {
			if (relationship.getDocumentation()==null) {
				relationship.setDocumentation(new Documentation());
			}
			relationship.getDocumentation().setBusinessName(businessName);
		}
		Attribute attribute = new Attribute(relationship, dataType);
		return attribute;
	}

	public AttributeBuilder setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
		return this;
	}

	public AttributeBuilder setConformance(ConformanceLevel conformanceLevel) {
		this.conformanceLevel = conformanceLevel;
		return this;
	}

	public AttributeBuilder setDataType(String type) {
		this.dataType = new TypeConverter().convertToType(type, null);
		return this;
	}

	public AttributeBuilder setBusinessName(String businessName) {
		this.businessName = businessName;
		return this;
	}
	
}