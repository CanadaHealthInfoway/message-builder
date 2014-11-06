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

package ca.infoway.messagebuilder.xml.delta;

/**
 * All the Constraint types.
 */
public enum ConstraintChangeType {
	ADD,
	ADD_CHOICE,
	ADD_INTERACTION,
	ANNOTATION, 
	CHANGE_BUSINESS_NAME, 
	CHANGE_CARDINALITY, 
	CHANGE_CONFORMANCE,
	CHANGE_DEFAULT_VALUE,
	CHANGE_DATATYPE,
	CHANGE_FIXED,
	CHANGE_LENGTH,
	CHANGE_UPDATEMODE_VALUES,
	CHANGE_UPDATEMODE_DEFAULT,
	CHANGE_VOCABULARY_BINDING,
	CHANGE_VOCABULARY_STRENGTH,
	CLONE, 
	REMOVE, 
	REMOVE_CHOICE, 
	SUBSTITUTE_CMET, 
	CHANGE_ASSOCIATION_TYPE, 
	CHANGE_CHOICE_RELATIONSHIP_NAME, 
	CHANGE_IMMUTABILITY,
	CHANGE_TEMPLATE_PARAMETER,
	CHANGE_SORT_ORDER,
	CHANGE_ASSOCIATION_SORT_ORDER,
	
	ADD_VOCABULARY_PART,
	ADD_CONCEPT, 
	CLONE_VOCABULARY_PART,
	RETIRE_CONCEPT, 
	ADD_CONTEXT_BINDING,
	
	SCHEMATRON,
	
	UNSUPPORTED;
	
	public String getKey() {
		return name();
	}
}
