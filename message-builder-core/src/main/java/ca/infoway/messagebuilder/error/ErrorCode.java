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

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public class ErrorCode extends EnumPattern {

	private static final long serialVersionUID = 1L;

	public static final ErrorCode UNSUPPORTED_INTERACTION = new ErrorCode("UNSUPPORTED_INTERACTION");
	public static final ErrorCode UNSUPPORTED_PROCESSING_ID = new ErrorCode("UNSUPPORTED_PROCESSING_ID");
	public static final ErrorCode UNSUPPORTED_VERSION_ID = new ErrorCode("UNSUPPORTED_VERSION_ID");
	public static final ErrorCode UNSUPPORTED_PROCESSING_MODE = new ErrorCode("UNSUPPORTED_PROCESSING_MODE");
	public static final ErrorCode UNSUPPORTED_TYPE_CHANGE = new ErrorCode("UNSUPPORTED_TYPE_CHANGE");
	public static final ErrorCode UNKNOWN_SENDER = new ErrorCode("UNKNOWN_SENDER");
	public static final ErrorCode UNRECOGNIZED_ATTENTION_LINE = new ErrorCode("UNRECOGNIZED_ATTENTION_LINE");
	public static final ErrorCode SYNTAX_ERROR = new ErrorCode("SYNTAX_ERROR");
	public static final ErrorCode MANDATORY_FIELD_NOT_PROVIDED = new ErrorCode("MANDATORY_FIELD_NOT_PROVIDED");
	public static final ErrorCode MANDATORY_ASSOCIATION_NOT_PROVIDED = new ErrorCode("MANDATORY_ASSOCIATION_NOT_PROVIDED");
	public static final ErrorCode REQUIRED_ATTRIBUTE_MISSING = new ErrorCode("REQUIRED_ATTRIBUTE_MISSING");
	public static final ErrorCode DATA_TYPE_ERROR = new ErrorCode("DATA_TYPE_ERROR");
	public static final ErrorCode VALUE_NOT_IN_CODE_SYSTEM = new ErrorCode("VALUE_NOT_IN_CODE_SYSTEM");
	public static final ErrorCode INVALID_CODE_SYSTEM_IN_CNE = new ErrorCode("INVALID_CODE_SYSTEM_IN_CNE");
	public static final ErrorCode NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY = new ErrorCode("NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY");
	public static final ErrorCode NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT = new ErrorCode("NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT");
	public static final ErrorCode NUMBER_OF_ATTRIBUTES_EXCEEDS_LIMIT = new ErrorCode("NUMBER_OF_ATTRIBUTES_EXCEEDS_LIMIT");
	public static final ErrorCode INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR");
	public static final ErrorCode NO_STORAGE_SPACE_FOR_MESSAGE = new ErrorCode("NO_STORAGE_SPACE_FOR_MESSAGE");
	public static final ErrorCode MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE = new ErrorCode("MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE");
	public static final ErrorCode MESSAGE_ROUTING_ERROR_DESTINATION_UNKNOWN = new ErrorCode("MESSAGE_ROUTING_ERROR_DESTINATION_UNKNOWN");
	public static final ErrorCode MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE = new ErrorCode("MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE");
	public static final ErrorCode TL7_SYSTEM_ERROR = new ErrorCode("TL7_SYSTEM_ERROR");
	public static final ErrorCode NOT_AUTHORIZED = new ErrorCode("NOT_AUTHORIZED");
	public static final ErrorCode IGNORED_CONFORMANCE_NOT_ALLOWED_IS_SET = new ErrorCode("IGNORED_CONFORMANCE_NOT_ALLOWED_IS_SET"); 
	public static final ErrorCode NOT_ALLOWED_CONFORMANCE_IS_SET = new ErrorCode("NOT_ALLOWED_CONFORMANCE_IS_SET");
	public static final ErrorCode ONLY_ONE_TYPE_OF_CONTENT_ALLOWED = new ErrorCode("ONLY_ONE_TYPE_OF_CONTENT_ALLOWED");
	public static final ErrorCode CDA_FIXED_CONSTRAINT_PROVIDED = new ErrorCode("CDA_FIXED_CONSTRAINT_PROVIDED");
	public static final ErrorCode CDA_FIXED_CONSTRAINT_MISSING = new ErrorCode("CDA_FIXED_CONSTRAINT_MISSING");
	public static final ErrorCode CDA_MANDATORY_CONSTRAINT_MISSING = new ErrorCode("CDA_MANDATORY_CONSTRAINT_MISSING");
	public static final ErrorCode CDA_PROHIBITED_CONSTRAINT = new ErrorCode("CDA_PROHIBITED_CONSTRAINT");
	public static final ErrorCode CDA_CARDINALITY_CONSTRAINT = new ErrorCode("CDA_CARDINALITY_CONSTRAINT");
	public static final ErrorCode CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING = new ErrorCode("CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING");
	public static final ErrorCode CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH = new ErrorCode("CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH");
	public static final ErrorCode CDA_UNSUPPORTED_CONSTRAINT = new ErrorCode("CDA_UNSUPPORTED_CONSTRAINT");
	public static final ErrorCode CDA_TEMPLATE_CHOSEN = new ErrorCode("CDA_TEMPLATE_CHOSEN");
	public static final ErrorCode COULD_NOT_DETERMINE_CHOICE_OPTION = new ErrorCode("COULD_NOT_DETERMINE_CHOICE_OPTION");
	public static final ErrorCode CDA_NO_ACCEPTABLE_CHOICE_OPTION = new ErrorCode("CDA_NO_ACCEPTABLE_CHOICE_OPTION");
	public static final ErrorCode CDA_MULTIPLE_CHOICE_OPTIONS_FOUND = new ErrorCode("CDA_MULTIPLE_CHOICE_OPTIONS_FOUND");
	public static final ErrorCode UNEXPECTED_NAMESPACE = new ErrorCode("UNEXPECTED_NAMESPACE");
	public static final ErrorCode SCHEMATRON = new ErrorCode("SCHEMATRON");
	public static final ErrorCode CODE_MATCH_ONLY_WHEN_IGNORING_CASE = new ErrorCode("CODE_MATCH_ONLY_WHEN_IGNORING_CASE");	
	
	private ErrorCode(String name) {
		super(name);
	}
	
}