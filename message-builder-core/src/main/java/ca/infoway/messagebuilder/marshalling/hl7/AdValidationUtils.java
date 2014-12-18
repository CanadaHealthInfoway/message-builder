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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.SpecificationVersion.isExactVersion;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class AdValidationUtils {

	private static final int MAX_DELIMITED_LINES = 4;
	private static final int MAX_PART_LENGTH = 80;
	private static final int MAX_USES = 3;

    private final static List<String> ALLOWABLE_ADDRESS_USES = new ArrayList<String>();

    static {
        ALLOWABLE_ADDRESS_USES.add("H");
        ALLOWABLE_ADDRESS_USES.add("PHYS");
        ALLOWABLE_ADDRESS_USES.add("PST");
        ALLOWABLE_ADDRESS_USES.add("TMP");
        ALLOWABLE_ADDRESS_USES.add("WP");
        ALLOWABLE_ADDRESS_USES.add("CONF");
        ALLOWABLE_ADDRESS_USES.add("DIR");
    }

	public void validatePostalAddress(PostalAddress postalAddress, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
    	validatePostalAddressUses(postalAddress, type, version, element, propertyPath, errors);
    	validatePostalAddressParts(postalAddress, type, version, element, propertyPath, errors);
	}

	private void validatePostalAddressParts(PostalAddress postalAddress, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		int countBlankParts = 0;
    	boolean isBasic = StandardDataType.AD_BASIC.getType().equals(type);
    	boolean isSearch = StandardDataType.AD_SEARCH.getType().equals(type);
    	boolean isFull = StandardDataType.AD_FULL.getType().equals(type);
    	
    	for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
			int partLength = StringUtils.length(postalAddressPart.getValue());
			if (partLength > MAX_PART_LENGTH) {
				// value max length of 80
    			createError("Address part types have a maximum allowed length of " + MAX_PART_LENGTH + " (length found: " + partLength + ")", element, propertyPath, errors);
			}

			// error if part type not allowed
	    	PostalAddressPartType partType = postalAddressPart.getType();
			if (partType == null) {
				countBlankParts++;
				// no part type : only allowed for BASIC (max 4, plus max 4 delimiter)
	    		if (!isBasic) {
	    			createError("Text without an address part only allowed for AD.BASIC", element, propertyPath, errors);
	    		}
			} else if (partType == PostalAddressPartType.DELIMITER) {
	    		if (!isBasic) {
	    			createError("Part type " + partType.getValue() + " is only allowed for AD.BASIC", element, propertyPath, errors);
	    		}
	    	} else if (isFull) {
	    		if (!PostalAddressPartType.isFullAddressPartType(partType)) {
	    			createError("Part type " + partType.getValue() + " is not allowed for AD.FULL", element, propertyPath, errors);
	    		}
			} else if (!PostalAddressPartType.isBasicAddressPartType(partType)) {
    			createError("Part type " + partType.getValue() + " is not allowed for AD.BASIC or AD.SEARCH", element, propertyPath, errors);
			}
	    	
			// code/codesystem are only for state/country
			if (postalAddressPart.getCode() != null) {
				if (partType != PostalAddressPartType.STATE && partType != PostalAddressPartType.COUNTRY) {
	    			createError("Part type " + partType.getValue() + " is not allowed to specify code or codeSystem", element, propertyPath, errors);
				}
			}
			
		}

    	if (isBasic && countBlankParts > MAX_DELIMITED_LINES) {
			createError("AD.BASIC is only allowed a maximum of " + MAX_DELIMITED_LINES + " delimiter-separated address lines (address lines without an address part type)", element, propertyPath, errors);
    	}
    	
    	if (isSearch && CollectionUtils.isEmpty(postalAddress.getParts())) {
			createError("AD.SEARCH must specify at least one part type", element, propertyPath, errors);
    	}
    	
    	// city/state/postalCode/country mandatory for AD.FULL
    	// new change for R02.05 (pre-adopted by R02.04.03 AB) onwards - these fields are now only *required*, not mandatory
    	if (isFull && !isExactVersion(SpecificationVersion.R02_04_03_AB, version)) {
    		validatePartTypeProvided(PostalAddressPartType.CITY, postalAddress.getParts(), element, propertyPath, errors);
    		validatePartTypeProvided(PostalAddressPartType.STATE, postalAddress.getParts(), element, propertyPath, errors);
    		validatePartTypeProvided(PostalAddressPartType.POSTAL_CODE, postalAddress.getParts(), element, propertyPath, errors);
    		validatePartTypeProvided(PostalAddressPartType.COUNTRY, postalAddress.getParts(), element, propertyPath, errors);
    	}
	}

	private void validatePartTypeProvided(PostalAddressPartType partType, List<PostalAddressPart> parts, Element element, String propertyPath, Hl7Errors errors) {
		boolean found = false;
		for (PostalAddressPart postalAddressPart : parts) {
			if (postalAddressPart.getType() == partType) {
				found = true;
				break;
			}
		}
		if (!found) {
			createError("Part type '" + partType + "' is mandatory for AD.FULL", element, propertyPath, errors);
		}
	}

	private void validatePostalAddressUses(PostalAddress postalAddress, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		int numUses = postalAddress.getUses().size();
    	boolean isSearch = StandardDataType.AD_SEARCH.getType().equals(type);
		if (isSearch && numUses > 0) {
    		// error if > 0 and SEARCH
			createError("PostalAddressUses are not allowed for AD.SEARCH", element, propertyPath, errors);
    	} else {
			if (numUses > MAX_USES) {
				// error if more than 3 uses
				createError("A maximum of 3 PostalAddressUses are allowed (number found: " + numUses + ")", element, propertyPath, errors);
			}
		}
    	
		if (!isSearch) {
			for (PostalAddressUse postalAddressUse : postalAddress.getUses()) {
				if (!isAllowableUse(type, postalAddressUse, version.getBaseVersion())) {
	   				createError("PostalAddressUse is not valid: " + (postalAddressUse == null ? "null" : postalAddressUse.getCodeValue()), element, propertyPath, errors);
				}
			}
		}
	}

	public boolean isAllowableAddressPart(PostalAddressPartType partType, String type) {
    	boolean isBasic = StandardDataType.AD_BASIC.getType().equals(type);
    	boolean isFull = StandardDataType.AD_FULL.getType().equals(type);

    	boolean result = true; 
    	
		if (partType == null) {
			// no part type : only allowed for BASIC (max 4, plus max 4 delimiter)
    		if (!isBasic) {
    			result = false;
    		}
		} else if (partType == PostalAddressPartType.DELIMITER) {
    		if (!isBasic) {
    			result = false;
    		}
    	} else if (isFull) {
    		if (!PostalAddressPartType.isFullAddressPartType(partType)) {
    			result = false;
    		}
		} else if (!PostalAddressPartType.isBasicAddressPartType(partType)) {
			result = false;
		}
		
		return result;
	}
	
	public boolean isAllowableUse(String dataType, PostalAddressUse use, Hl7BaseVersion baseVersion) {
		return !StandardDataType.AD_SEARCH.getType().equals(dataType)
				&& use != null && use.getCodeValue() != null 
				&& ALLOWABLE_ADDRESS_USES.contains(use.getCodeValue())
				// error if CONF/DIR and CeRx
				&& !(isCeRx(baseVersion) && isConfOrDir(use));
	}

	private boolean isCeRx(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.CERX;
	}

	private boolean isConfOrDir(PostalAddressUse use) {
		return X_BasicPostalAddressUse.CONFIDENTIAL.getCodeValue().equals(use.getCodeValue())
				|| X_BasicPostalAddressUse.DIRECT.getCodeValue().equals(use.getCodeValue());
	}

	private void createError(String errorMessage, Element element, String propertyPath, Hl7Errors errors) {
		Hl7Error error = null;
		if (element != null) {
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage + 	" (" + XmlDescriber.describeSingleElement(element) + ")", 
					element);		
		} else { // assuming this has a property path
			error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					errorMessage, 
					propertyPath);		
		}
		
		errors.addHl7Error(error);
	}

}
