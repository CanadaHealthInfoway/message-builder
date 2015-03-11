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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-19 09:34:53 -0500 (Wed, 19 Nov 2014) $
 * Revision:      $LastChangedRevision: 9080 $
 */

package ca.infoway.messagebuilder.error;


/**
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public enum Hl7ErrorCode {
	
	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes

	UNSUPPORTED_INTERACTION,
	UNSUPPORTED_PROCESSING_ID,
	UNSUPPORTED_VERSION_ID,
	UNSUPPORTED_PROCESSING_MODE,
	UNSUPPORTED_TYPE_CHANGE,
	UNKNOWN_SENDER,
	UNRECOGNIZED_ATTENTION_LINE,
	SYNTAX_ERROR,
	MANDATORY_FIELD_NOT_PROVIDED,
	MANDATORY_ASSOCIATION_NOT_PROVIDED,
	REQUIRED_ATTRIBUTE_MISSING,
	DATA_TYPE_ERROR,
	VALUE_NOT_IN_CODE_SYSTEM, 
	INVALID_CODE_SYSTEM_IN_CNE,
	NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY,
	NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT,
	NUMBER_OF_ATTRIBUTES_EXCEEDS_LIMIT,
	INTERNAL_ERROR,
	NO_STORAGE_SPACE_FOR_MESSAGE,
	MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE,
	MESSAGE_ROUTING_ERROR_DESTINATION_UNKNOWN,
	MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE,
	TL7_SYSTEM_ERROR,
	NOT_AUTHORIZED, 
	IGNORED_CONFORMANCE_NOT_ALLOWED_IS_SET, 
	NOT_ALLOWED_CONFORMANCE_IS_SET,
	ONLY_ONE_TYPE_OF_CONTENT_ALLOWED,
	CDA_FIXED_CONSTRAINT_PROVIDED,
	CDA_FIXED_CONSTRAINT_MISSING,
	CDA_MANDATORY_CONSTRAINT_MISSING,
	CDA_PROHIBITED_CONSTRAINT,
	CDA_CARDINALITY_CONSTRAINT,
	CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING,
	CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH, 
	CDA_UNSUPPORTED_CONSTRAINT, 
	CDA_TEMPLATE_CHOSEN, 
	CDA_NO_ACCEPTABLE_CHOICE_OPTION,
	CDA_MULTIPLE_CHOICE_OPTIONS_FOUND,
	UNEXPECTED_NAMESPACE,
	SCHEMATRON,
	CODE_MATCH_ONLY_WHEN_IGNORING_CASE
	;
}
