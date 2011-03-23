package ca.infoway.messagebuilder.generator.java;

import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class RegeneratedInlinedAssociation extends InlinedAssociation implements RegeneratedAssociation {

	private final Association originalAssociation;
	private final Association newAssociation;
	private PropertyGeneratorBuilder builder;
	
	RegeneratedInlinedAssociation(InlinedAssociation originalAssociation, InlinedAssociation newAssociation) {
		super(originalAssociation.getInlinedRelationship(), originalAssociation.getElidedRelationship());
		this.originalAssociation = originalAssociation;
		this.newAssociation = newAssociation;
		this.builder = new PropertyGeneratorBuilder(ProgrammingLanguage.JAVA);
	}

	public Association getOriginalRelationship() {
		return this.originalAssociation;
	}
	
	public Association getNewRelationship() {
		return this.newAssociation;
	}
	
	@Override
	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
		return getBuilder().build(representation, nameResolver);
	}
	
	@Override
	public boolean isWriteable() {
		return true;
	}

	public PropertyGeneratorBuilder getBuilder() {
		return this.builder;
	}

	public void setBuilder(PropertyGeneratorBuilder builder) {
		this.builder = builder;
	}
	
	@Override
	public Set<Object> getImportTypes() {
		return new RegeneratedRelationshipHelper(this).getImportTypes();
	}
	
}
