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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;


interface FieldDefinition {
	
	boolean isWritable();
	String getFieldName();
	String getCapitalizedPropertyName();
	/** 
	 * <p>Get the field type.  The field type is used in internal field defintion. 
	 */
	String getFieldType();
	String getFieldImplementationType();
	/** 
	 * <p>Get the property type.  The property type is used in the public getter and setter. 
	 */
	String getPropertyType();
	/** 
	 * <p>Get the collection coded property element type.  The collection coded property element type is used in the body of the public getter and setter. 
	 */
	String getCollectionOfCodedPropertyElementType();
	
	String[] getXmlPathName();
	GetterBodyStyle getGetterBodyStyle();
	SetterBodyStyle getSetterBodyStyle();
	GetterBodyStyle getDerivedChoiceHasBodyStyle();
	String getInitializationArguments();
	/** 
	 * <p>Get the implementation type of individual field elements.  
	 * 
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the implementation type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.
	 */
	String getFieldElementImplementationType();
	
	/**
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.	*/
	String getFieldElementType();
	
	/** 
	 * <p>Get the implementation type of individual field elements.  
	 * 
	 * <p>If the field is a collapsed relationship, then the field type is a list, and 
	 * this type is the implementation type of elements in the list.  If the field
	 * is not a collapsed relationship, the the field type and the field element type are
	 * the same thing.
	 */
	String getPropertyElementImplementationType();
	
	boolean isDerivedChoice();

	boolean isInitializedAtConstructionTime();
	
	void initializeContext(ClassNameManager manager, BaseRelationshipNameResolver resolver);
	void resetContext();
	
	BaseRelationship getBaseRelationship();
	ProgrammingLanguage getProgrammingLanguage();
	
}
