package ca.infoway.messagebuilder.generator.java;

public interface RegeneratedAttribute extends RegeneratedRelationship {

	public Attribute getOriginalRelationship();
	public Attribute getNewRelationship();
	
}
