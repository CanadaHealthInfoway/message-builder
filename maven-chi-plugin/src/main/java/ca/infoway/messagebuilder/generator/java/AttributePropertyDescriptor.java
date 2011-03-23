package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.DataType;

public interface AttributePropertyDescriptor extends RelationshipPropertyDescriptor {

	public boolean isCollectionAttribute();
	public String getDomainType();
	public DataType getDataType();
	public boolean isInlined();

}
