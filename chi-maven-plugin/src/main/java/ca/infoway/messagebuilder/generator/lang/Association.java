/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.lang.FingerprintDuplicateRegistry.causesDuplicateFingerprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class Association extends BaseRelationship {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 8680061980374131773L;
	
	private final TemplateVariable templateVariable;
	private final Type associationType;
	private final List<Choice> choices;

    protected Association(Relationship relationship, Type associationType, List<Choice> allChoiceTypes) {
    	this(relationship, associationType, null, allChoiceTypes);
	}
    protected Association(Relationship relationship, TemplateVariable templateVariable) {
    	this(relationship, null, templateVariable, null);
	}
    protected Association(Relationship relationship, Type associationType, TemplateVariable templateVariable, List<Choice> allChoiceTypes) {
    	super(relationship, null, templateVariable != null ? templateVariable.getType() : relationship.getType());
    	this.templateVariable = templateVariable;
    	this.associationType = associationType;
		this.choices = allChoiceTypes;
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
	public Set<Object> getImportTypes(boolean parentTypeIsMerged, boolean parentTypeIsAbstract) {
		Set<Object> result = super.getImportTypes(parentTypeIsMerged, parentTypeIsAbstract);
		
		Type type = getAssociationType();
		if (type != null) {
			result.add(type.getLanguageSpecificName().getFullyQualifiedName());
		}
		for (Choice choice : EmptyIterable.nullSafeIterable(getAllChoiceTypes())) {
        	if (choice != null) {
        		if (isCardinalityMultiple()) {
        			// currently not straightforward to produce helper methods for multiple cardinality
        		} else if (parentTypeIsMerged) {
        			// currently not straightforward to produce helper methods for choices residing within merged types
        		} else {
    				result.add(getImportClassName(choice));
        		}
        	}
		}
		if (isCardinalityMultiple()) {
			result.add(List.class.getName());
			if (!parentTypeIsAbstract) {
				result.add(ArrayList.class.getName());
			}
		}
		return result;
	}
	private String getImportClassName(Choice choice) {
		if (choice.getType() == null) {
			throw new GeneratorException("Association: " + getType() + "(" + getName() + ") " + choice.getName() + " has no type");
		} else if (choice.getType().getLanguageSpecificName() == null) {
			throw new GeneratorException("Association: " + getType() + "(" + getName() + ") " + choice.getType().getTypeName() + " has no language-specific name");
		} else {
			return choice.getType().getLanguageSpecificName().getFullyQualifiedName();
		}
	}
	public TypeName getPropertyTypeName() {
		if (getAssociationType() == null) {
			return null;
		} else {
			return getAssociationType().getTypeName();
		}
	}

	public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
		return PropertyGeneratorBuilders.newAssociationBuilder(language, this).build(representation, nameResolver);
	}
	
	public List<Choice> getAllChoiceTypes() {
		return this.choices;
	}
	
	public static Association createTemplateAssociation(Relationship relationship, TemplateVariable templateVariable) {
		return new Association(relationship, templateVariable);
	}
	public static Association createStandardAssociation(Relationship relationship, Type type) {
		return createStandardAssociation(relationship, type, Collections.<Choice>emptyList());
	}
	public static Association createStandardAssociation(Relationship relationship, Type type, List<Choice> allChoiceTypes) {
		return new Association(relationship, type, allChoiceTypes);
	}
	
	@Override
	public Fingerprint getFingerprint(TypeName containingType) {
		if (this.relationship.isTemplateRelationship()) {
			return new Fingerprint(RelationshipType.ASSOCIATION, this.relationship.getTemplateParameterName());
		} else {
			String nameForFingerprint = getAssociationTypeNameForFingerprint(containingType, this.associationType, this.relationship.getName());
			return new Fingerprint(RelationshipType.ASSOCIATION, nameForFingerprint);
		}
	}
	
	private String getAssociationTypeNameForFingerprint(TypeName containingType, Type associationType, String relationshipName) {
		String result = null;
		if (associationType.getMergedName() != null) {
			result = associationType.getMergedName().getName();
		} else {
			result = associationType.getTypeName().getName();
		}
		
		if (causesDuplicateFingerprint(containingType.getName(), relationshipName)) {
			result = result + "." + relationshipName;
		}
		
		return result;
	}
}
