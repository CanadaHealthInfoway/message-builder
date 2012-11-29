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

package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActPharmacySupplyType. Identifies types of dispensing events
 */
public class ActPharmacySupplyType extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = -4833727160525452059L;
	
	public static final ActPharmacySupplyType DAILY_FILL = new ActPharmacySupplyType("DAILY_FILL", "DF"); 
	public static final ActPharmacySupplyType EMERGENCY_SUPPLY = new ActPharmacySupplyType("EMERGENCY_SUPPLY", "EM"); 
	public static final ActPharmacySupplyType SCRIPT_OWING = new ActPharmacySupplyType("SCRIPT_OWING", "SO"); 
	public static final ActPharmacySupplyType FIRST_FILL = new ActPharmacySupplyType("FIRST_FILL", "FF"); 
	public static final ActPharmacySupplyType FIRST_FILL_COMPLETE = new ActPharmacySupplyType("FIRST_FILL_COMPLETE", "FFC"); 
	public static final ActPharmacySupplyType FIRST_FILL_COMPLETE_PARTIAL_STRENGTH = new ActPharmacySupplyType("FIRST_FILL_COMPLETE_PARTIAL_STRENGTH", "FFCS"); 
	public static final ActPharmacySupplyType FIRST_FILL_PART_FILL = new ActPharmacySupplyType("FIRST_FILL_PART_FILL", "FFP"); 
	public static final ActPharmacySupplyType FIRST_FILL_PART_FILL_PARTIAL_STRENGTH = new ActPharmacySupplyType("FIRST_FILL_PART_FILL_PARTIAL_STRENGTH", "FFPS"); 
	public static final ActPharmacySupplyType FEE_FOR_SERVICE = new ActPharmacySupplyType("FEE_FOR_SERVICE", "FFS");
	public static final ActPharmacySupplyType FIRST_FILL_PARTIAL_STRENGTH = new ActPharmacySupplyType("FIRST_FILL_PARTIAL_STRENGTH", "TFS"); 
	public static final ActPharmacySupplyType TRIAL_FILL = new ActPharmacySupplyType("TRIAL_FILL", "TF"); 
	public static final ActPharmacySupplyType FLOOR_STOCK = new ActPharmacySupplyType("FLOOR_STOCK", "FS"); 
	public static final ActPharmacySupplyType MANUFACTURER_SAMPLE = new ActPharmacySupplyType("MANUFACTURER_SAMPLE", "MS"); 
	public static final ActPharmacySupplyType REFILL = new ActPharmacySupplyType("REFILL", "RF"); 
	public static final ActPharmacySupplyType REFILL_COMPLETE = new ActPharmacySupplyType("REFILL_COMPLETE", "RFC"); 
	public static final ActPharmacySupplyType REFILL_COMPLETE_PARTIAL_STRENGTH = new ActPharmacySupplyType("REFILL_COMPLETE_PARTIAL_STRENGTH", "RFCS"); 
	public static final ActPharmacySupplyType REFILL_FIRST_FILL_THIS_FACILITY = new ActPharmacySupplyType("REFILL_FIRST_FILL_THIS_FACILITY", "RFF"); 
	public static final ActPharmacySupplyType REFILL_PARTIAL_STRENGTH_FIRST_FILL_THIS_FACILITY = new ActPharmacySupplyType("REFILL_PARTIAL_STRENGTH_FIRST_FILL_THIS_FACILITY", "RFFS"); 
	public static final ActPharmacySupplyType REFILL_PART_FILL = new ActPharmacySupplyType("REFILL_PART_FILL", "RFP"); 
	public static final ActPharmacySupplyType REFILL_PART_FILL_PARTIAL_STRENGTH = new ActPharmacySupplyType("REFILL_PART_FILL_PARTIAL_STRENGTH", "RFPS"); 
	public static final ActPharmacySupplyType REFILL_PARTIAL_STRENGTH = new ActPharmacySupplyType("REFILL_PARTIAL_STRENGTH", "RFS"); 
	public static final ActPharmacySupplyType TRIAL_BALANCE = new ActPharmacySupplyType("TRIAL_BALANCE", "TB"); 
	public static final ActPharmacySupplyType TRIAL_BALANCE_PARTIAL_STRENGTH = new ActPharmacySupplyType("TRIAL_BALANCE_PARTIAL_STRENGTH", "TBS"); 
	public static final ActPharmacySupplyType UNIT_DOSE_EQUIVALENT = new ActPharmacySupplyType("UNIT_DOSE_EQUIVALENT", "UDE"); 
	public static final ActPharmacySupplyType UNIT_DOSE = new ActPharmacySupplyType("UNIT_DOSE", "UD");

	private final String codeValue;

	private ActPharmacySupplyType(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

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
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_CODE.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
