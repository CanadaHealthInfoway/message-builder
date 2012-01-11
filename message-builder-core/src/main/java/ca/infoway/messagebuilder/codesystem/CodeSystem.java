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

package ca.infoway.messagebuilder.codesystem;

import ca.infoway.messagebuilder.Oid;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum CodeSystem. Groups a number of common Oids.
 */
public class CodeSystem extends EnumPattern implements Oid {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * <p>The high-level OID for Canada.
	 * 
	 * <p>Note that "124" is the ISO 3166-1 3-digit numeric code for Canada.
	 */
	public static final CodeSystem CANADA = new CodeSystem("CANADA", "2.16.124");
	public static final CodeSystem HEALTH_CANADA = new CodeSystem("HEALTH_CANADA", "2.16.124.101.1.277");
	public static final CodeSystem PROVINCE_OF_ONTARIO = new CodeSystem("PROVINCE_OF_ONTARIO", "2.16.124.8");
	public static final CodeSystem ONTARIO_PROVINCIAL_GOVERNMENT = new CodeSystem("ONTARIO_PROVINCIAL_GOVERNMENT", "2.16.124.8.101");
	public static final CodeSystem GOVERNMENT_OF_CANADA = new CodeSystem("GOVERNMENT_OF_CANADA", "2.16.124.101");
	public static final CodeSystem SMART_SYSTEMS_FOR_HEALTH_AGENCY = new CodeSystem("SMART_SYSTEMS_FOR_HEALTH_AGENCY", "2.16.124.113588");
	public static final CodeSystem INTELLIWARE = new CodeSystem("INTELLIWARE", "2.16.124.113620");
	public static final CodeSystem INTELLIWARE_APPLICATIONS = new CodeSystem("INTELLIWARE_APPLICATIONS", "2.16.124.113620.1");
	public static final CodeSystem INTELLIWARE_APPLICATIONS_PANACEA = new CodeSystem("INTELLIWARE_APPLICATIONS_PANACEA", "2.16.124.113620.1.1");
	public static final CodeSystem INTELLIWARE_APPLICATIONS_TEAL = new CodeSystem("INTELLIWARE_APPLICATIONS_TEAL", "2.16.124.113620.1.2");
	/**
	 * Health Canada Natural Product Number (NPN).
	 */
	public static final CodeSystem NATURAL_PRODUCT_NUMBER = new CodeSystem("NATURAL_PRODUCT_NUMBER", "2.16.840.1.113883.5.1107");	
	/**
	 * Online Product Identification Number Index of Nova Scotia (OPINIONs).
	 */
	public static final CodeSystem OPINIONS = new CodeSystem("OPINIONS", "2.16.840.1.113883.5.1102");
	public static final CodeSystem ISO_3166_1_ALPHA_2 = new CodeSystem("ISO_3166_1_ALPHA_2", "1.0.3166.1.2.2");
	public static final CodeSystem ISO_3166_1_ALPHA_3 = new CodeSystem("ISO_3166_1_ALPHA_3", "1.0.3166.1.2.3");
	
	public static final CodeSystem SNOMED = new CodeSystem("SNOMED", "2.16.840.1.113883.6.96");
	public static final CodeSystem DRUG_IDENTIFICATION_NUMBER = new CodeSystem("DRUG_IDENTIFICATION_NUMBER", "2.16.840.1.113883.5.1105");
	/**
	 * Logical Observation Identifier Names and Codes (LOINC).
	 */
	public static final CodeSystem LOINC = new CodeSystem("LOINC", "2.16.840.1.113883.6.1");
	
	/**
	 * ICD10.
	 */
	public static final CodeSystem ICD10 = new CodeSystem("ICD10", "2.16.840.1.113883.6.3");
	
	/**
	 * <p>Newfoundland's health number is the Medical Care Plan (MCP).
	 */
	public static final CodeSystem 	MEDICAL_CARE_PLAN = new CodeSystem("MEDICAL_CARE_PLAN", "2.16.840.1.113883.4.52");
	public static final CodeSystem ECID = new CodeSystem("ECID", "2.16.840.1.113883.1.133");
	public static final CodeSystem CANADIAN_CLASSIFICATION_OF_INTERVENTIONS = new CodeSystem("CANADIAN_CLASSIFICATION_OF_INTERVENTIONS", "2.16.840.1.113883.6.95");
	
	/**
	 * The unique License Number number assigned by the College of Physicians and Surgeons of Ontario (CPSO), 
	 * Canada to identify each individual physician and surgeon.
	 */
	public static final CodeSystem CPSO_LISENSE_NUMBER = new CodeSystem("CPSO_LISENSE_NUMBER", "2.16.840.1.113883.4.347");
	
	/**
	 * This is the Oid used for ActReason code systems in the referrals
	 * application.
	 */
	public static final CodeSystem REFERRALS_ACT_REASON = new CodeSystem("REFERRALS_ACT_REASON", "2.16.124.8.101.99.1.1.39");
	/**
	 * This is the Oid used for HL7TriggerEventCode code systems in the referrals
	 * application.
	 */
	public static final CodeSystem REFERRALS_TRIGGER_EVENT_CODE = new CodeSystem("REFERRALS_TRIGGER_EVENT_CODE", "2.16.124.8.101.99.1.1.40");
	public static final CodeSystem REFERRALS_OHIP_BILLING_NUMBER = new CodeSystem("REFERRALS_OHIP_BILLING_NUMBER", "2.16.124.8.101.99.1.1.42");
	public static final CodeSystem REFERRALS_OHIP_CARD_NUMBER = new CodeSystem("REFERRALS_OHIP_CARD_NUMBER", "2.16.124.8.101.99.1.2.1.7");

	// ------------------- Standard Vocabulary Domains -----------------------
	
	public static final CodeSystem VOCABULARY_ACKNOWLEDGEMENT_CONDITION = new CodeSystem("VOCABULARY_ACKNOWLEDGEMENT_CONDITION", "2.16.840.1.113883.5.1050");
	public static final CodeSystem VOCABULARY_ACKNOWLEDGEMENT_DETAIL_CODE = new CodeSystem("VOCABULARY_ACKNOWLEDGEMENT_DETAIL_CODE", "2.16.840.1.113883.5.1100");
	public static final CodeSystem VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE = new CodeSystem("VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE", "2.16.840.1.113883.5.1082");
	public static final CodeSystem VOCABULARY_ACKNOWLEDGEMENT_TYPE = new CodeSystem("VOCABULARY_ACKNOWLEDGEMENT_TYPE", "2.16.840.1.113883.5.18");
	public static final CodeSystem VOCABULARY_ACT_CLASS = new CodeSystem("VOCABULARY_ACT_CLASS", "2.16.840.1.113883.5.6");
	public static final CodeSystem VOCABULARY_ACT_CODE = new CodeSystem("VOCABULARY_ACT_CODE", "2.16.840.1.113883.5.4");
	public static final CodeSystem VOCABULARY_ACT_MOOD = new CodeSystem("VOCABULARY_ACT_MOOD", "2.16.840.1.113883.5.1001");
	public static final CodeSystem VOCABULARY_ACT_PRIORITY = new CodeSystem("VOCABULARY_ACT_PRIORITY", "2.16.840.1.113883.5.7");
	public static final CodeSystem VOCABULARY_ACT_REASON = new CodeSystem("VOCABULARY_ACT_REASON", "2.16.840.1.113883.5.8");
	public static final CodeSystem VOCABULARY_ACT_RELATIONSHIP_SUBSET = new CodeSystem("VOCABULARY_ACT_RELATIONSHIP_SUBSET", "2.16.840.1.113883.19.5.2");
	public static final CodeSystem VOCABULARY_ACT_SITE = new CodeSystem("VOCABULARY_ACT_SITE", "2.16.840.1.113883.5.1052");
	public static final CodeSystem VOCABULARY_ACT_STATUS = new CodeSystem("VOCABULARY_ACT_STATUS", "2.16.840.1.113883.5.14");
	public static final CodeSystem VOCABULARY_ACT_UNCERTAINTY = new CodeSystem("VOCABULARY_ACT_UNCERTAINTY", "2.16.840.1.113883.5.1053");
	public static final CodeSystem VOCABULARY_ADMINISTRABLE_DRUG_FORM = new CodeSystem("VOCABULARY_ADMINISTRABLE_DRUG_FORM", "2.16.840.1.113883.19.5.3");
	public static final CodeSystem VOCABULARY_ADMINISTRATIVE_GENDER = new CodeSystem("VOCABULARY_ADMINISTRATIVE_GENDER", "2.16.840.1.113883.5.1");
	public static final CodeSystem VOCABULARY_ADDRESS_PART_TYPE = new CodeSystem("VOCABULARY_ADDRESS_PART_TYPE", "2.16.840.1.113883.5.16");
	public static final CodeSystem VOCABULARY_ALLERGY_TEST_VALUE = new CodeSystem("VOCABULARY_ALLERGY_TEST_VALUE", "2.16.840.1.113883.5.1063");
	public static final CodeSystem VOCABULARY_BODY_SITE = new CodeSystem("VOCABULARY_BODY_SITE", "2.16.840.1.113883.12.163");
	public static final CodeSystem VOCABULARY_CONFIDENTIALITY = new CodeSystem("VOCABULARY_CONFIDENTIALITY", "2.16.840.1.113883.5.25");
	public static final CodeSystem VOCABULARY_DOCUMENT_MEDIA_TYPES = new CodeSystem("VOCABULARY_DOCUMENT_MEDIA_TYPES", "2.16.840.1.113883.5.79");
	public static final CodeSystem VOCABULARY_ENTITY_CODE = new CodeSystem("VOCABULARY_ENTITY_CODE", "2.16.840.1.113883.5.1060");
	public static final CodeSystem VOCABULARY_ENTITY_NAME_USE = new CodeSystem("VOCABULARY_ENTITY_NAME_USE", "2.16.840.1.113883.5.45");
	public static final CodeSystem VOCABULARY_HL7_STANDARD_VERSION_CODE = new CodeSystem("VOCABULARY_HL7_STANDARD_VERSION_CODE", "2.16.840.1.113883.5.1092"); 
	public static final CodeSystem VOCABULARY_HUMAN_LANGUAGE = new CodeSystem("VOCABULARY_HUMAN_LANGUAGE", "2.16.840.1.113883.6.84"); 
	public static final CodeSystem VOCABULARY_MESSAGE_WAITING_PRIORITY = new CodeSystem("VOCABULARY_MESSAGE_WAITING_PRIORITY", "2.16.840.1.113883.5.1083");
	public static final CodeSystem VOCABULARY_NULL_FLAVOR = new CodeSystem("VOCABULARY_NULL_FLAVOR", "2.16.840.1.113883.5.1008");
	public static final CodeSystem VOCABULARY_OBSERVATION_VALUE = new CodeSystem("VOCABULARY_OBSERVATION_VALUE", "2.16.840.1.113883.5.1063");
	public static final CodeSystem VOCABULARY_OTHER_IDENTIFIER_ROLE_TYPE = new CodeSystem("VOCABULARY_OTHER_IDENTIFIER_ROLE_TYPE", "2.16.840.1.113883.2.20.5.2");
	public static final CodeSystem VOCABULARY_PARTICIPATION_SIGNATURE = new CodeSystem("VOCABULARY_PARTICIPATION_SIGNATURE", "2.16.840.1.113883.5.89");
	public static final CodeSystem VOCABULARY_PARTICIPATION_TYPE = new CodeSystem("VOCABULARY_PARTICIPATION_TYPE", "2.16.840.1.113883.5.90");
	public static final CodeSystem VOCABULARY_POSTAL_ADDRESS_USE = new CodeSystem("VOCABULARY_POSTAL_ADDRESS_USE", "2.16.840.1.113883.5.1012");
	public static final CodeSystem VOCABULARY_PROCESSING_MODE = new CodeSystem("VOCABULARY_PROCESSING_MODE", "2.16.840.1.113883.5.1064");
	public static final CodeSystem VOCABULARY_QUERY_REQUEST_LIMIT = new CodeSystem("VOCABULARY_QUERY_REQUEST_LIMIT", "2.16.840.1.113883.5.1112");
	public static final CodeSystem VOCABULARY_QUERY_PARAMETER_VALUE = new CodeSystem("VOCABULARY_QUERY_PARAMETER_VALUE", "2.16.840.1.113883.5.1096");
	public static final CodeSystem VOCABULARY_QUERY_RESPONSE = new CodeSystem("VOCABULARY_QUERY_RESPONSE", "2.16.840.1.113883.5.1067");
	public static final CodeSystem VOCABULARY_RESPONSE_MODE = new CodeSystem("VOCABULARY_RESPONSE_MODE", "2.16.840.1.113883.19.5.1"); 
	public static final CodeSystem VOCABULARY_ROLE_CLASS = new CodeSystem("VOCABULARY_ROLE_CLASS", "2.16.840.1.113883.5.110");
	public static final CodeSystem VOCABULARY_ROLE_CODE = new CodeSystem("VOCABULARY_ROLE_CODE", "2.16.840.1.113883.5.111");
	public static final CodeSystem VOCABULARY_ROLE_STATUS = new CodeSystem("VOCABULARY_ROLE_STATUS", "2.16.840.1.113883.5.1068");
	public static final CodeSystem VOCABULARY_ROUTE_OF_ADMINISTRATION = new CodeSystem("VOCABULARY_ROUTE_OF_ADMINISTRATION", "2.16.840.1.113883.5.112");
	public static final CodeSystem VOCABULARY_SEVERITY_OBSERVATION = new CodeSystem("VOCABULARY_SEVERITY_OBSERVATION", "2.16.840.1.113883.5.1063");
	public static final CodeSystem VOCABULARY_SUBSTITUTION_CONDITION = new CodeSystem("VOCABULARY_SUBSTITUTION_CONDITION", "2.16.840.1.113883.5.1071");
	public static final CodeSystem VOCABULARY_TELECOMMUNICATION_ADDRESS_USE = new CodeSystem("VOCABULARY_TELECOMMUNICATION_ADDRESS_USE", "2.16.840.1.113883.5.1011");
	public static final CodeSystem VOCABULARY_TRIGGER_EVENT_ID = new CodeSystem("VOCABULARY_TRIGGER_EVENT_ID", "2.16.840.1.113883.1.18");
	public static final CodeSystem VOCABULARY_UNIFORM_UNIT_OF_MEASURE = new CodeSystem("VOCABULARY_UNIFORM_UNIT_OF_MEASURE", "2.16.840.1.113883.5.141");
	public static final CodeSystem VOCABULARY_URL_SCHEME = new CodeSystem("VOCABULARY_URL_SCHEME", "2.16.840.1.113883.5.143");
    
	public static final CodeSystem SC_TEMP = new CodeSystem("SC_TEMP", "2.16.840.1.113883.2.20.5.2");
	
	// ------------------- Newfoundland Defined Code Systems -----------------------
	public static final CodeSystem TOPIC_PRIORITY = new CodeSystem("TOPIC_PRIORITY", "2.16.840.1.113883.3.133.10.30.101.14");
	public static final CodeSystem SUBSCRIPTION_STATUS = new CodeSystem("SUBSCRIPTION_STATUS", "2.16.840.1.113883.3.133.10.30.101.15");
	
	private final String root;

	private CodeSystem(String name, String root) {
		super(name);
		this.root = root;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRoot() {
		return this.root;
	}
}
