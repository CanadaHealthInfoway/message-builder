package ca.infoway.messagebuilder.generator.java;

import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class RegeneratedAttributeImpl extends Attribute implements RegeneratedAttribute {

	private static final long serialVersionUID = 8781705244037367813L;
	
	private final Attribute originalAttribute;
	private final Attribute newAttribute;
	private PropertyGeneratorBuilder builder;
	
	RegeneratedAttributeImpl(Attribute originalAttribute, Attribute newAttribute) {
		super(originalAttribute.getRelationship(), originalAttribute.getDataType());
		this.originalAttribute = originalAttribute;
		this.newAttribute = newAttribute;
		this.builder = new PropertyGeneratorBuilder(ProgrammingLanguage.JAVA);
	}

	public Attribute getNewRelationship() {
		return this.newAttribute;
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
