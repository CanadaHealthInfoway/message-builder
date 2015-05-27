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
public class Hl7ErrorCode extends EnumPattern {

	private static final long serialVersionUID = 1L;

	public static final Hl7ErrorCode UNSUPPORTED_INTERACTION = new Hl7ErrorCode("UNSUPPORTED_INTERACTION");
	public static final Hl7ErrorCode UNSUPPORTED_PROCESSING_ID = new Hl7ErrorCode("UNSUPPORTED_PROCESSING_ID");
	public static final Hl7ErrorCode UNSUPPORTED_VERSION_ID = new Hl7ErrorCode("UNSUPPORTED_VERSION_ID");
	public static final Hl7ErrorCode UNSUPPORTED_PROCESSING_MODE = new Hl7ErrorCode("UNSUPPORTED_PROCESSING_MODE");
	public static final Hl7ErrorCode UNSUPPORTED_TYPE_CHANGE = new Hl7ErrorCode("UNSUPPORTED_TYPE_CHANGE");
	public static final Hl7ErrorCode UNKNOWN_SENDER = new Hl7ErrorCode("UNKNOWN_SENDER");
	public static final Hl7ErrorCode UNRECOGNIZED_ATTENTION_LINE = new Hl7ErrorCode("UNRECOGNIZED_ATTENTION_LINE");
	public static final Hl7ErrorCode SYNTAX_ERROR = new Hl7ErrorCode("SYNTAX_ERROR");
	public static final Hl7ErrorCode MANDATORY_FIELD_NOT_PROVIDED = new Hl7ErrorCode("MANDATORY_FIELD_NOT_PROVIDED");
	public static final Hl7ErrorCode MANDATORY_ASSOCIATION_NOT_PROVIDED = new Hl7ErrorCode("MANDATORY_ASSOCIATION_NOT_PROVIDED");
	public static final Hl7ErrorCode REQUIRED_ATTRIBUTE_MISSING = new Hl7ErrorCode("REQUIRED_ATTRIBUTE_MISSING");
	public static final Hl7ErrorCode DATA_TYPE_ERROR = new Hl7ErrorCode("DATA_TYPE_ERROR");
	public static final Hl7ErrorCode VALUE_NOT_IN_CODE_SYSTEM = new Hl7ErrorCode("VALUE_NOT_IN_CODE_SYSTEM");
	public static final Hl7ErrorCode INVALID_CODE_SYSTEM_IN_CNE = new Hl7ErrorCode("INVALID_CODE_SYSTEM_IN_CNE");
	public static final Hl7ErrorCode NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY = new Hl7ErrorCode("NUMBER_OF_ASSOCIATIONS_INCORRECT_FOR_CARDINALITY");
	public static final Hl7ErrorCode NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT = new Hl7ErrorCode("NUMBER_OF_ASSOCIATIONS_EXCEEDS_LIMIT");
	public static final Hl7ErrorCode NUMBER_OF_ATTRIBUTES_EXCEEDS_LIMIT = new Hl7ErrorCode("NUMBER_OF_ATTRIBUTES_EXCEEDS_LIMIT");
	public static final Hl7ErrorCode INTERNAL_ERROR = new Hl7ErrorCode("INTERNAL_ERROR");
	public static final Hl7ErrorCode NO_STORAGE_SPACE_FOR_MESSAGE = new Hl7ErrorCode("NO_STORAGE_SPACE_FOR_MESSAGE");
	public static final Hl7ErrorCode MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE = new Hl7ErrorCode("MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE");
	public static final Hl7ErrorCode MESSAGE_ROUTING_ERROR_DESTINATION_UNKNOWN = new Hl7ErrorCode("MESSAGE_ROUTING_ERROR_DESTINATION_UNKNOWN");
	public static final Hl7ErrorCode MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE = new Hl7ErrorCode("MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE");
	public static final Hl7ErrorCode TL7_SYSTEM_ERROR = new Hl7ErrorCode("TL7_SYSTEM_ERROR");
	public static final Hl7ErrorCode NOT_AUTHORIZED = new Hl7ErrorCode("NOT_AUTHORIZED");
	public static final Hl7ErrorCode IGNORED_CONFORMANCE_NOT_ALLOWED_IS_SET = new Hl7ErrorCode("IGNORED_CONFORMANCE_NOT_ALLOWED_IS_SET"); 
	public static final Hl7ErrorCode NOT_ALLOWED_CONFORMANCE_IS_SET = new Hl7ErrorCode("NOT_ALLOWED_CONFORMANCE_IS_SET");
	public static final Hl7ErrorCode ONLY_ONE_TYPE_OF_CONTENT_ALLOWED = new Hl7ErrorCode("ONLY_ONE_TYPE_OF_CONTENT_ALLOWED");
	public static final Hl7ErrorCode CDA_FIXED_CONSTRAINT_PROVIDED = new Hl7ErrorCode("CDA_FIXED_CONSTRAINT_PROVIDED");
	public static final Hl7ErrorCode CDA_FIXED_CONSTRAINT_MISSING = new Hl7ErrorCode("CDA_FIXED_CONSTRAINT_MISSING");
	public static final Hl7ErrorCode CDA_MANDATORY_CONSTRAINT_MISSING = new Hl7ErrorCode("CDA_MANDATORY_CONSTRAINT_MISSING");
	public static final Hl7ErrorCode CDA_PROHIBITED_CONSTRAINT = new Hl7ErrorCode("CDA_PROHIBITED_CONSTRAINT");
	public static final Hl7ErrorCode CDA_CARDINALITY_CONSTRAINT = new Hl7ErrorCode("CDA_CARDINALITY_CONSTRAINT");
	public static final Hl7ErrorCode CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING = new Hl7ErrorCode("CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING");
	public static final Hl7ErrorCode CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH = new Hl7ErrorCode("CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH");
	public static final Hl7ErrorCode CDA_UNSUPPORTED_CONSTRAINT = new Hl7ErrorCode("CDA_UNSUPPORTED_CONSTRAINT");
	public static final Hl7ErrorCode CDA_TEMPLATE_CHOSEN = new Hl7ErrorCode("CDA_TEMPLATE_CHOSEN");
	public static final Hl7ErrorCode CDA_NO_ACCEPTABLE_CHOICE_OPTION = new Hl7ErrorCode("CDA_NO_ACCEPTABLE_CHOICE_OPTION");
	public static final Hl7ErrorCode CDA_MULTIPLE_CHOICE_OPTIONS_FOUND = new Hl7ErrorCode("CDA_MULTIPLE_CHOICE_OPTIONS_FOUND");
	public static final Hl7ErrorCode UNEXPECTED_NAMESPACE = new Hl7ErrorCode("UNEXPECTED_NAMESPACE");
	public static final Hl7ErrorCode SCHEMATRON = new Hl7ErrorCode("SCHEMATRON");
	public static final Hl7ErrorCode CODE_MATCH_ONLY_WHEN_IGNORING_CASE = new Hl7ErrorCode("CODE_MATCH_ONLY_WHEN_IGNORING_CASE");
	
	private Hl7ErrorCode(String name) {
		super(name);
	}
}
