/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

class AssociationFieldDefinition implements FieldDefinition {

	private final Association association;
	private ClassNameManager manager;
	private BaseRelationshipNameResolver resolver;
	private final ProgrammingLanguage language;

	AssociationFieldDefinition(Association association, ProgrammingLanguage language) {
		this.association = association;
		this.language = language;
	}
	
	private TypeDecorator getTypeDecorator() {
		if (this.association.isCardinalityMultiple()) {
			return TypeDecorator.LIST;
		} else {
			return TypeDecorator.NULL;
		}
	}
	
	public String getCapitalizedPropertyName() {
		return WordUtils.capitalize(getFieldName());
	}

	public String getFieldName() {
		return WordUtils.uncapitalize(getResolver().getName(this.association));
	}

	public String getFieldElementImplementationType() {
		return ""; // not used
	}

	public String getFieldElementType() {
		return ""; // not used
	}

	public String getFieldImplementationType() {
		return getTypeDecorator().decorateImplType(getBaseType(), getBaseType(), this.language);
	}

	public String getFieldType() {
		return getTypeDecorator().decorateType(getBaseType(), this.language);
	}

	private String getBaseType() {
		if (this.association.isTemplateType()) {
			return this.association.getTemplateVariable().getType();
		} else {
			String name = getManager().getRepresentationOfType(this.association.getAssociationType());
			name += this.association.getTypeParameters();
			return name;
		}
	}

	public GetterBodyStyle getGetterBodyStyle() {
		return GetterBodyStyle.DEFAULT;
	}

	public String getInitializationArguments() {
		return "";
	}

	public String getPropertyType() {
		return getFieldType();
	}

	public SetterBodyStyle getSetterBodyStyle() {
		return SetterBodyStyle.DEFAULT;
	}

	public String[] getXmlPathName() {
		return this.association.getAllXmlMappings();
	}

	public void initializeContext(ClassNameManager manager,
			BaseRelationshipNameResolver resolver) {
		this.manager = manager;
		this.resolver = resolver;
	}
	
	private BaseRelationshipNameResolver getResolver() {
		if (this.resolver == null) {
			throw new IllegalStateException("The context has not been initialized");
		} else {
			return this.resolver;
		}
	}

	public boolean isWritable() {
		return this.association.isWriteable();
	}

	public void resetContext() {
		this.manager = null;
		this.resolver = null;
	}

	private ClassNameManager getManager() {
		if (this.manager == null) {
			throw new IllegalStateException("The context has not been initialized");
		} else {
			return this.manager;
		}
	}

	public boolean isInitializedAtConstructionTime() {
		return this.association.isCardinalityMultiple();
	}

	public String getPropertyElementImplementationType() {
		return ""; // not used
	}

	public String getCollectionOfCodedPropertyElementType() {
		return ""; // not used
	}

	public boolean isDerivedChoice() {
		return false;
	}

	public GetterBodyStyle getDerivedChoiceHasBodyStyle() {
		return null;
	}

	public BaseRelationship getBaseRelationship() {
		return this.association;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return this.language;
	}

}
