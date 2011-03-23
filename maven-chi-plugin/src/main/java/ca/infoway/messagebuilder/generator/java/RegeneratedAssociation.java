package ca.infoway.messagebuilder.generator.java;

public interface RegeneratedAssociation extends RegeneratedRelationship {

	public Association getOriginalRelationship();
	public Association getNewRelationship();
	
}
