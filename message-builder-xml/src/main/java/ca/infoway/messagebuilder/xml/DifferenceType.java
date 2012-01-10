/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

public enum DifferenceType {
	
	INTERACTION_SUPER_TYPE_NAME,
	ARGUMENT_TEMPLATE_PARAMETER_NAME,
	ARGUMENT_TRAVERSAL_NAME,
	PACKAGE_LOCATION_ROOT_TYPE,
	MESSAGE_PART_ABSTRACT,
	RELATIONSHIP_RENAMED,
	CHOICE_RELATIONSHIP_TYPE,
	RELATIONSHIP_ONLY_ONE_HAS_DOMAIN_TYPE,
	RELATIONSHIP_DOMAIN_TYPES_INCOMPATIBLE,
	RELATIONSHIP_ONE_OR_BOTH_DOMAIN_TYPES_NOT_IN_SYSTEM,
	RELATIONSHIP_TEMPLATE_PARAMETER_NAME,
	COMPONENT_ONLY_IN_ONE_VERSION, 
	ASSOCIATION_TYPE, 
	ATTRIBUTE_TYPE, 
	DUPLICATE_ASSOCIATION_TYPE, 
	DUPLICATE_RELATIONSHIP_NAME
	;
	
}
