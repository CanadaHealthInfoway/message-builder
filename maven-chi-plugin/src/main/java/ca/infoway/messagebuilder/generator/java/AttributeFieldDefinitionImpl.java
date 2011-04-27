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

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

class AttributeFieldDefinitionImpl implements FieldDefinition {

	private final Attribute attribute;
	private final ProgrammingLanguage language;
	
	private BaseRelationshipNameResolver resolver;

	public AttributeFieldDefinitionImpl(Attribute attribute, ProgrammingLanguage language) {
		this.attribute = attribute;
		this.language = language;
	}
	
	public String getCapitalizedPropertyName() {
		return WordUtils.capitalize(getFieldName());
	}

	public String getFieldName() {
		return WordUtils.uncapitalize(getResolver().getName(this.attribute));
	}

	private BaseRelationshipNameResolver getResolver() {
		if (this.resolver == null) {
			throw new IllegalStateException("The context has not been initialized");
		} else {
			return this.resolver;
		}
	}

	public GetterBodyStyle getGetterBodyStyle() {
		GetterBodyStyle getterStyle = GetterBodyStyle.ATTRIBUTE;
		if (!StandardDataType.isSetOrList(getDataType().getShortWrappedName()) 
				&& attribute.isCardinalityMultiple()
				&& !this.attribute.isCollection()) {
			getterStyle = GetterBodyStyle.ASSOCIATION_COLLAPSED_TO_ATTRIBUTE;
		} else {
			if (StandardDataType.isList(getDataType().getShortWrappedName())) {
				if (getDataType().getParameters()[0].isCodedType()) {
					getterStyle = GetterBodyStyle.CODED_ATTRIBUTE_LIST;
				} else {
					getterStyle = GetterBodyStyle.ATTRIBUTE_LIST;
				}
			} else if (StandardDataType.isSet(getDataType().getShortWrappedName())) {
				if (getDataType().getParameters()[0].isCodedType()) {
					getterStyle = GetterBodyStyle.CODED_ATTRIBUTE_SET;
				} else {
					getterStyle = GetterBodyStyle.ATTRIBUTE_SET;
				}
			} else if (StandardDataType.isCollection(getDataType().getShortWrappedName())) {
				getterStyle = GetterBodyStyle.ATTRIBUTE_COLLECTION;
			} else if (getDataType().isCodedType()) {
				getterStyle = GetterBodyStyle.CODED_ATTRIBUTE;
			}
		}
		return getterStyle;
	}

	public String getFieldImplementationType() {
		return getTypeDecorator().decorateImplType(getBaseDefinition(), getBaseImplDefinition(), this.language);
	}
	
	public String getFieldElementImplementationType() {
		return typeof(getBaseImplDefinition());
	}

	public String getFieldElementType() {
		return getBaseDefinition();
	}
	
	private String getBaseImplDefinition() {
		DataType dataType = getDataType();
		return isAnyType(dataType) ? getAnyImplDefinition() :  dataType.getParameterizedImplementationType(this.language);
	}

	private DataType getDataType() {
		return this.attribute.getDataType();
	}

	private String getBaseDefinition() {
		DataType dataType = getDataType();
		return isAnyType(dataType) ? getAnyDefinition() :  dataType.getShortWrappedName(this.language);
	}
	
	private TypeDecorator getTypeDecorator() {
		if (!StandardDataType.isSetOrList(getDataType().getShortWrappedName()) 
				&& this.attribute.isCardinalityMultiple()
				&& !this.attribute.isCollection()) {
			return TypeDecorator.LIST;
		} else {
			return TypeDecorator.NULL;
		}
	}

	public String getFieldType() {
		return getTypeDecorator().decorateType(getBaseDefinition(), this.language);
	}

	public SetterBodyStyle getSetterBodyStyle() {
		return SetterBodyStyle.ATTRIBUTE;
	}

	public String[] getXmlPathName() {
		return this.attribute.getAllXmlMappings();
	}

	public boolean isWritable() {
		return this.attribute.isWriteable();
	}

	public void initializeContext(ClassNameManager manager, BaseRelationshipNameResolver resolver) {
		this.resolver = resolver;
	}

	public void resetContext() {
		this.resolver = null;
	}

	// These are bodgy methods
	private boolean isAnyType(DataType dataType) {
		return "ANY".equals(dataType.getUnparameterizedShortWrappedName());
	}

	private String getAnyImplDefinition() {
		return this.language == ProgrammingLanguage.JAVA ? "ANYImpl<Object>" : "ANYImpl<object>";
	}
	private String getAnyDefinition() {
		return this.language == ProgrammingLanguage.JAVA ? "ANY<Object>" : "ANY<object>";
	}

	/**
	 * <p>Certain data types have initialization parameters:  
	 * 
	 * <ul>
	 * <li>SET and LIST have 
	 */
	public String getInitializationArguments() {
		if (isHl7CollectionType()) {
			DataType[] parameterTypes = getDataType().getParameters();
			if (ArrayUtils.getLength(parameterTypes) == 1) {
				return typeof(parameterTypes[0].getShortWrappedNameImpl());
			} else {
				return "";
			}
		} else if (isIndicatorType()) {
			return "false";
		} else {
			return "";
		}
	}

	private boolean isHl7CollectionType() {
		return getDataType().isTypeCollection();
	}

	private boolean isIndicatorType() {
		return this.attribute.isIndicator();
	}
	
	private String typeof(String type) {
		return this.language == ProgrammingLanguage.C_SHARP 
				? createCsharpTypeofReference(type) 
				: createJavaClassReference(type);
	}

	private String createCsharpTypeofReference(String type) {
		return "typeof(" + type + ")";
	}

	private String createJavaClassReference(String type) {
		if (type.contains("<")) {
			type = StringUtils.substringBefore(type, "<");
		}
		return type + ".class";
	}

	public String getPropertyType() {
		return getTypeDecorator().decorateType(getPropertyElementImplementationType(), this.language);
	}

	public String getCollectionOfCodedPropertyElementType() {
		String elementType = "";
		if (getDataType().isTypeCollection()) {
			DataType elementDataType = getDataType().getParameters()[0];
			if (elementDataType.isCodedType()) {
				elementType = elementDataType.getShortName(this.language);
			}
		} 
		return elementType;
	}

	public boolean isInitializedAtConstructionTime() {
		return true;
	}

	public String getPropertyElementImplementationType() {
		return getDataType().getShortName(this.language);
	}

	public boolean isDerivedChoice() {
		return false;
	}

	public GetterBodyStyle getDerivedChoiceHasBodyStyle() {
		return null;
	}

	public BaseRelationship getBaseRelationship() {
		return this.attribute;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return this.language;
	}

}
