package ca.infoway.messagebuilder.generator.java;

public interface RegeneratedRelationship {

	public BaseRelationship getNewRelationship();
	
	public PropertyGeneratorBuilder getBuilder();
	public void setBuilder(PropertyGeneratorBuilder builder);
	
}
