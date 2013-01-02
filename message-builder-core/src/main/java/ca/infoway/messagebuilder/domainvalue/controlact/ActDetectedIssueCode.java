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

package ca.infoway.messagebuilder.domainvalue.controlact;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActDetectedIssueCode. Identifies types of detected issues for Act class "ALRT"
 */
public class ActDetectedIssueCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = -2117496114393701585L;
	
	public static final ActDetectedIssueCode INSUFFICIENT_AUTHORIZATION = new ActDetectedIssueCode("INSUFFICIENT_AUTHORIZATION", "NAT"); 
	public static final ActDetectedIssueCode VALIDATION_ISSUE = new ActDetectedIssueCode("VALIDATION_ISSUE", "VALIDAT"); 
	public static final ActDetectedIssueCode IDENTIFIER_DOES_NOT_EXIST = new ActDetectedIssueCode("IDENTIFIER_DOES_NOT_EXIST", "KEY204"); // The ID of the patient, order, etc., was not found. Used for transactions other than additions.
	public static final ActDetectedIssueCode IDENTIFIER_ALREADY_EXISTS = new ActDetectedIssueCode("IDENTIFIER_ALREADY_EXISTS", "KEY205"); // The ID of the patient, order, etc., already exists. Used in response to addition transactions (Admit, New Order, etc.).
	/**
	 * The request is missing elements or contains elements which cause it to not meet 
	 * the legal standards for actioning.
	 */
	public static final ActDetectedIssueCode ILLEGAL = new ActDetectedIssueCode("ILLEGAL", "ILLEGAL"); 
	/**
	 * The specified element is mandatory and was not included in the instance.
	 */
	public static final ActDetectedIssueCode MISSING_MANDATORY_ELEMENT = new ActDetectedIssueCode("MISSING_MANDATORY_ELEMENT", "MISSMAND"); 
	public static final ActDetectedIssueCode MISSING_CONDITIONAL_ELEMENT = new ActDetectedIssueCode("MISSING_CONDITIONAL_ELEMENT", "MISSCOND"); 
	public static final ActDetectedIssueCode INVALID_FORMAT = new ActDetectedIssueCode("INVALID_FORMAT", "FORMAT"); 
	public static final ActDetectedIssueCode LENGTH_OUT_OF_RANGE = new ActDetectedIssueCode("LENGTH_OUT_OF_RANGE", "LEN_RANGE"); 
	public static final ActDetectedIssueCode LENGTH_IS_TOO_SHORT = new ActDetectedIssueCode("LENGTH_IS_TOO_SHORT", "LEN_SHORT"); 
	public static final ActDetectedIssueCode LENGTH_IS_TOO_LONG = new ActDetectedIssueCode("LENGTH_IS_TOO_LONG", "LEN_LONG"); 
	public static final ActDetectedIssueCode CODE_IS_NOT_VALID = new ActDetectedIssueCode("CODE_IS_NOT_VALID", "CODE_INVAL"); 
	public static final ActDetectedIssueCode CODE_HAS_BEEN_DEPRECATED = new ActDetectedIssueCode("CODE_HAS_BEEN_DEPRECATED", "CODE_DEPREC"); 
	public static final ActDetectedIssueCode DUPLICATE_VALUES_ARE_NOT_PERMITTED = new ActDetectedIssueCode("DUPLICATE_VALUES_ARE_NOT_PERMITTED", "NODUPS"); 
	public static final ActDetectedIssueCode REPETITIONS_OUT_OF_RANGE = new ActDetectedIssueCode("REPETITIONS_OUT_OF_RANGE", "REP_RANGE"); 
	public static final ActDetectedIssueCode REPETITIONS_BELOW_MINIMUM = new ActDetectedIssueCode("REPETITIONS_BELOW_MINIMUM", "MINOCCURS"); 
	public static final ActDetectedIssueCode REPETITIONS_ABOVE_MAXIMUM = new ActDetectedIssueCode("REPETITIONS_ABOVE_MAXIMUM", "MAXOCCURS");
	public static final ActDetectedIssueCode BUSINESS_CONSTRAINT_VIOLATION = new ActDetectedIssueCode("BUSINESS_CONSTRAINT_VIOLATION", "BUS"); 
	public static final ActDetectedIssueCode FOOD_INTERACTION_ALERT = new ActDetectedIssueCode("FOOD_INTERACTION_ALERT", "FOOD"); 
	public static final ActDetectedIssueCode THERAPEUTIC_PRODUCT_ALERT = new ActDetectedIssueCode("THERAPEUTIC_PRODUCT_ALERT", "TPROD"); 
	public static final ActDetectedIssueCode DRUG_INTERACTION_ALERT = new ActDetectedIssueCode("DRUG_INTERACTION_ALERT", "DRG"); 
	public static final ActDetectedIssueCode NATURAL_HEALTH_PRODUCT_ALERT = new ActDetectedIssueCode("NATURAL_HEALTH_PRODUCT_ALERT", "NHP"); 
	public static final ActDetectedIssueCode NON_PRESCRIPTION_INTERACTION_ALERT = new ActDetectedIssueCode("NON_PRESCRIPTION_INTERACTION_ALERT", "NONRX"); 
	public static final ActDetectedIssueCode OBSERVATION_ALERT = new ActDetectedIssueCode("OBSERVATION_ALERT", "OBSA"); 
	public static final ActDetectedIssueCode AGE_ALERT = new ActDetectedIssueCode("AGE_ALERT", "AGE"); 
	public static final ActDetectedIssueCode HIGH_DOSE_FOR_AGE_ALERT = new ActDetectedIssueCode("HIGH_DOSE_FOR_AGE_ALERT", "DOSEHINDA"); 
	public static final ActDetectedIssueCode LOW_DOSE_FOR_AGE_ALERT = new ActDetectedIssueCode("LOW_DOSE_FOR_AGE_ALERT", "DOSELINDA"); 
	public static final ActDetectedIssueCode CONDITION_ALERT = new ActDetectedIssueCode("CONDITION_ALERT", "COND"); 
	public static final ActDetectedIssueCode HIGH_DOSE_FOR_HEIGHT_SURFACE_AREA_ALERT = new ActDetectedIssueCode("HIGH_DOSE_FOR_HEIGHT_SURFACE_AREA_ALERT", "DOSEHINDSA"); 
	public static final ActDetectedIssueCode LOW_DOSE_FOR_HEIGHT_SURFACE_AREA_ALERT = new ActDetectedIssueCode("LOW_DOSE_FOR_HEIGHT_SURFACE_AREA_ALERT", "DOSELINDSA"); 
	public static final ActDetectedIssueCode HIGH_DOSE_FOR_WEIGHT_ALERT = new ActDetectedIssueCode("HIGH_DOSE_FOR_WEIGHT_ALERT", "DOSEHINDW"); 
	public static final ActDetectedIssueCode LOW_DOSE_FOR_WEIGHT_ALERT = new ActDetectedIssueCode("LOW_DOSE_FOR_WEIGHT_ALERT", "DOSELINDW"); 
	public static final ActDetectedIssueCode LACTATION_ALERT = new ActDetectedIssueCode("LACTATION_ALERT", "LACT"); 
	public static final ActDetectedIssueCode PREGNANCY_ALERT = new ActDetectedIssueCode("PREGNANCY_ALERT", "PREG"); 
	public static final ActDetectedIssueCode GENETIC_ALERT = new ActDetectedIssueCode("GENETIC_ALERT", "GEN"); 
	public static final ActDetectedIssueCode GENDER_ALERT = new ActDetectedIssueCode("GENDER_ALERT", "GEND"); 
	public static final ActDetectedIssueCode LAB_ALERT = new ActDetectedIssueCode("LAB_ALERT", "LAB"); 
	public static final ActDetectedIssueCode REACTION_ALERT = new ActDetectedIssueCode("REACTION_ALERT", "REACT"); 
	public static final ActDetectedIssueCode ALLERGY_ALERT = new ActDetectedIssueCode("ALLERGY_ALERT", "ALGY"); 
	public static final ActDetectedIssueCode INTOLERANCE_ALERT = new ActDetectedIssueCode("INTOLERANCE_ALERT", "INT");
	public static final ActDetectedIssueCode RELATED_REACTION_ALERT = new ActDetectedIssueCode("RELATED_REACTION_ALERT", "RREACT"); 
	public static final ActDetectedIssueCode RELATED_ALLERGY_ALERT = new ActDetectedIssueCode("RELATED_ALLERGY_ALERT", "RALG"); 
	public static final ActDetectedIssueCode RELATED_PRIOR_REACTION_ALERT = new ActDetectedIssueCode("RELATED_PRIOR_REACTION_ALERT", "RAR"); 
	public static final ActDetectedIssueCode RELATED_INTOLERANCE_ALERT = new ActDetectedIssueCode("RELATED_INTOLERANCE_ALERT", "RINT"); 
	public static final ActDetectedIssueCode COMMON_REACTION_ALERT = new ActDetectedIssueCode("COMMON_REACTION_ALERT", "CREACT"); 
	public static final ActDetectedIssueCode ENDLATE = new ActDetectedIssueCode("ENDLATE", "ENDLATE");
	public static final ActDetectedIssueCode STRTLATE = new ActDetectedIssueCode("STRTLATE", "STRTLATE");
	public static final ActDetectedIssueCode COMPLIANCE_ALERT = new ActDetectedIssueCode("COMPLIANCE_ALERT", "COMPLY"); 
	public static final ActDetectedIssueCode DUPLICATE_THERAPY_ALERT = new ActDetectedIssueCode("DUPLICATE_THERAPY_ALERT", "DUPTHPY"); 
	public static final ActDetectedIssueCode DUPLICATE_THERAPEUTIC_ALASS_ALERT = new ActDetectedIssueCode("DUPLICATE_THERAPEUTIC_ALASS_ALERT", "DUPTHPCLS"); 
	public static final ActDetectedIssueCode DUPLICATE_GENERIC_ALERT = new ActDetectedIssueCode("DUPLICATE_GENERIC_ALERT", "DUPTHPGEN"); 
	public static final ActDetectedIssueCode POTENTIAL_FRAUD = new ActDetectedIssueCode("POTENTIAL_FRAUD", "FRAUD"); 
	public static final ActDetectedIssueCode COMMONLY_ABUSED_MISUSED_ALERT = new ActDetectedIssueCode("COMMONLY_ABUSED_MISUSED_ALERT", "ABUSE"); 
	public static final ActDetectedIssueCode POLY_ORDERER_ALERT = new ActDetectedIssueCode("POLY_ORDERER_ALERT", "PLYDOC"); 
	public static final ActDetectedIssueCode POLY_PHARMACY_ALERT = new ActDetectedIssueCode("POLY_PHARMACY_ALERT", "PLYPHRM"); 
	public static final ActDetectedIssueCode DOSAGE_PROBLEM = new ActDetectedIssueCode("DOSAGE_PROBLEM", "DOSE"); 
	public static final ActDetectedIssueCode DOSE_DURATION_ALERT = new ActDetectedIssueCode("DOSE_DURATION_ALERT", "DOSEDUR"); 
	public static final ActDetectedIssueCode DOSE_DURATION_HIGH_ALERT = new ActDetectedIssueCode("DOSE_DURATION_HIGH_ALERT", "DOSEDURH"); 
	public static final ActDetectedIssueCode DOSE_DURATION_HIGH_FOR_INDICATION_ALERT = new ActDetectedIssueCode("DOSE_DURATION_HIGH_FOR_INDICATION_ALERT", "DOSEDURHIND");
	public static final ActDetectedIssueCode DOSE_DURATION_LOW_ALERT = new ActDetectedIssueCode("DOSE_DURATION_LOW_ALERT", "DOSEDURL"); 
	public static final ActDetectedIssueCode DOSE_DURATION_LOW_FOR_INDICATION_ALERT = new ActDetectedIssueCode("DOSE_DURATION_LOW_FOR_INDICATION_ALERT", "DOSEDURLIND"); 
	public static final ActDetectedIssueCode HIGH_DOSE_ALERT = new ActDetectedIssueCode("HIGH_DOSE_ALERT", "DOSEH"); 
	public static final ActDetectedIssueCode HIGH_DOSE_FOR_INDICATION_ALERT = new ActDetectedIssueCode("HIGH_DOSE_FOR_INDICATION_ALERT", "DOSEHIND"); 
	public static final ActDetectedIssueCode DOSE_INTERVAL_ALERT = new ActDetectedIssueCode("DOSE_INTERVAL_ALERT", "DOSEIVL"); 
	public static final ActDetectedIssueCode DOSE_INTERVAL_FOR_INDICATION_ALERT = new ActDetectedIssueCode("DOSE_INTERVAL_FOR_INDICATION_ALERT", "DOSEIVLIND"); 
	public static final ActDetectedIssueCode LOW_DOSE_ALERT = new ActDetectedIssueCode("LOW_DOSE_ALERT", "DOSEL"); 
	public static final ActDetectedIssueCode LOW_DOSE_FOR_INDICATION_ALERT = new ActDetectedIssueCode("LOW_DOSE_FOR_INDICATION_ALERT", "DOSELIND");
	public static final ActDetectedIssueCode DOSAGE_CONDITION_ALERT = new ActDetectedIssueCode("DOSAGE_CONDITION_ALERT", "DOSECOND"); 
	public static final ActDetectedIssueCode REFILL_TOO_LATE_ALERT = new ActDetectedIssueCode("REFILL_TOO_LATE_ALERT", "TOOLATE"); 
	public static final ActDetectedIssueCode REFILL_TOO_SOON_ALERT = new ActDetectedIssueCode("REFILL_TOO_SOON_ALERT", "TOOSOON"); 
	public static final ActDetectedIssueCode PREVINEF = new ActDetectedIssueCode("PREVINEF", "PREVINEF"); 
	public static final ActDetectedIssueCode PATPREF = new ActDetectedIssueCode("PATPREF", "PATPREF"); 
	public static final ActDetectedIssueCode PATPREFALT = new ActDetectedIssueCode("PATPREFALT", "PATPREFALT"); 
	public static final ActDetectedIssueCode FULFIL = new ActDetectedIssueCode("FULFIL", "FULFIL"); 
	public static final ActDetectedIssueCode NO_LONGER_ACTIONABLE = new ActDetectedIssueCode("NO_LONGER_ACTIONABLE", "NOTACTN"); 
	public static final ActDetectedIssueCode NOTEQUIV = new ActDetectedIssueCode("NOTEQUIV", "NOTEQUIV"); 
	public static final ActDetectedIssueCode NOTEQUIVTHER = new ActDetectedIssueCode("NOTEQUIVTHER", "NOTEQUIVTHER"); 
	public static final ActDetectedIssueCode NOTEQUIVGEN = new ActDetectedIssueCode("NOTEQUIVGEN", "NOTEQUIVGEN"); 
	public static final ActDetectedIssueCode TIMING = new ActDetectedIssueCode("TIMING", "TIMING"); 
	public static final ActDetectedIssueCode MINFREQ = new ActDetectedIssueCode("MINFREQ", "MINFREQ"); 
	public static final ActDetectedIssueCode INTERVAL = new ActDetectedIssueCode("INTERVAL", "INTERVAL"); 
	public static final ActDetectedIssueCode ALLDONE = new ActDetectedIssueCode("ALLDONE", "ALLDONE"); 
	public static final ActDetectedIssueCode HELD = new ActDetectedIssueCode("HELD", "HELD");

	private String codeValue;

	private ActDetectedIssueCode(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_CODE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
