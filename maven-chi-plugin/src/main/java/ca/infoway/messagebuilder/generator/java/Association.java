package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class Association extends BaseRelationship {

	private static final long serialVersionUID = 8680061980374131773L;
	
	private final TemplateVariable templateVariable;
	private final Type associationType;

    protected Association(Relationship relationship, Type associationType) {
    	this(relationship, associationType, null);
	}
    protected Association(Relationship relationship, TemplateVariable templateVariable) {
    	this(relationship, null, templateVariable);
	}
    protected Association(Relationship relationship, Type associationType, TemplateVariable templateVariable) {
    	super(relationship, null, templateVariable != null ? templateVariable.getType() : relationship.getType());
    	this.templateVariable = templateVariable;
    	this.associationType = associationType;
    }
	@Override
	public String getTypeParameters() {
		if (getAssociationType() != null && getAssociationType().isTemplateType()) {
			StringBuilder builder = new StringBuilder();
			builder.append("<");
    		for (String variable : getAssociationType().getTemplateVariables()) {
    			if (builder.length() > 1) {
    				builder.append(",");
    			}
    			builder.append(variable);
			}
    		builder.append(">");
    		return builder.toString();
    	} else {
    		return super.getTypeParameters();
    	}
	}

	@Override
    public RelationshipType getRelationshipType() {
        return RelationshipType.ASSOCIATION;
    }

    private boolean isAbstractType() {
		return this.associationType != null && this.associationType.isAbstract();
	}

	public TemplateVariable getTemplateVariable() {
		return this.templateVariable;
	}
	
	@Override
	public boolean isTemplateType() {
		return this.relationship.isTemplateRelationship();
	}

	public Type getAssociationType() {
		return this.associationType;
	}
	
	@Override
	public Set<Object> getImportTypes() {
		Set<Object> result = super.getImportTypes();
		if (this.associationType != null) {
			result.add(this.associationType.getName());
		}
		if (isCardinalityMultiple()) {
			result.add(List.class.getName());
			result.add(ArrayList.class.getName());
		}
		if (isChoice() && !isCardinalityMultiple()) {
			addLeafChoices(this.getRelationship().getChoices(), result);
		}
		return result;
	}
	
	private void addLeafChoices(List<Relationship> choices, Set<Object> result) {
		for (Relationship relationship : choices) {
			if (relationship.isChoice()) {
				addLeafChoices(relationship.getChoices(), result);
			} else {
				result.add(new TypeName(relationship.getType()));
			}
		}
	}
	
	public TypeName getPropertyTypeName() {
		if (getAssociationType() == null) {
			return null;
		} else {
			return getAssociationType().getName();
		}
	}

	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
		return PropertyGeneratorBuilders.newAssociationBuilder(language, this).build(representation, nameResolver);
	}
	
	public static Association createTemplateAssociation(Relationship relationship, TemplateVariable templateVariable, int sortKey) {
		return new Association(relationship, templateVariable);
	}
	public static Association createStandardAssociation(Relationship relationship, Type type, int sortKey) {
		return new Association(relationship, type);
	}
	
}
