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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class PnValidationUtils {

	private static final int MAX_PART_LENGTH = 50;
	private static final int MAX_PART_LENGTH_CERX = 30;
	private static final int MAX_PARTS = 7;

    private final static Map<Hl7BaseVersion, Set<String>> ALLOWABLE_NAME_USES_BY_VERSION = new HashMap<Hl7BaseVersion, Set<String>>();
    private final static Set<String> ALLOWABLE_NAME_PARTS = new HashSet<String>();
    private final static Set<String> ALLOWABLE_NAME_PART_QUALIFIERS = new HashSet<String>();
    private final static Set<String> ALLOWABLE_NAME_USES = new HashSet<String>(); 

    static {
    	Set<String> mr2007Uses = new HashSet<String>(); 
    	Set<String> cerxUses = new HashSet<String>(); 
    	
    	ALLOWABLE_NAME_USES.add("C"); // MR2009 allowable uses
    	ALLOWABLE_NAME_USES.add("L");
    	ALLOWABLE_NAME_USES.add("P");
    	ALLOWABLE_NAME_USES.add("OR");
    	
    	mr2007Uses.add("C");
    	mr2007Uses.add("L");
    	mr2007Uses.add("P");
    	mr2007Uses.add("HC");
    	
    	cerxUses.add("L");
    	cerxUses.add("P");
    	
    	ALLOWABLE_NAME_USES_BY_VERSION.put(Hl7BaseVersion.MR2007, mr2007Uses);
    	ALLOWABLE_NAME_USES_BY_VERSION.put(Hl7BaseVersion.MR2007_V02R01, mr2007Uses);
    	ALLOWABLE_NAME_USES_BY_VERSION.put(Hl7BaseVersion.CERX, cerxUses);
    	
    	ALLOWABLE_NAME_PARTS.add("family");
    	ALLOWABLE_NAME_PARTS.add("given");
    	ALLOWABLE_NAME_PARTS.add("prefix");
    	ALLOWABLE_NAME_PARTS.add("suffix");
    	
    	ALLOWABLE_NAME_PART_QUALIFIERS.add("IN");
    	ALLOWABLE_NAME_PART_QUALIFIERS.add("BR");
    	ALLOWABLE_NAME_PART_QUALIFIERS.add("SP");
    	ALLOWABLE_NAME_PART_QUALIFIERS.add("CL");
    }

	public void validatePersonName(PersonName personName, String type, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors) {
    	validatePersonNameUses(personName, type, baseVersion, element, errors, propertyPath);
    	validatePersonNameParts(personName, type, baseVersion, element, propertyPath, errors);
	}

	private void validatePersonNameParts(PersonName personName, String type, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors) {
    	boolean isBasic = StandardDataType.PN_BASIC.getType().equals(type);
    	boolean isSimple = StandardDataType.PN_SIMPLE.getType().equals(type);
    	boolean isFull = StandardDataType.PN_FULL.getType().equals(type);
    	boolean isSearch = StandardDataType.PN_SEARCH.getType().equals(type);
    	
    	int countBlankParts = 0;
    	boolean isCeRx = isCeRx(baseVersion);
    	
    	int numParts = personName.getParts().size();
		if (numParts > MAX_PARTS) {
			createError("A maximum of " + MAX_PARTS + " name parts are allowed. Found: " + numParts, element, propertyPath, errors);
    	}
    	
    	for (EntityNamePart personNamePart : personName.getParts()) {
			int partLength = StringUtils.length(personNamePart.getValue());
			if ((isCeRx && partLength > MAX_PART_LENGTH_CERX) || partLength > MAX_PART_LENGTH) {
    			createError("Name part types have a maximum allowed length of " + (isCeRx ? MAX_PART_LENGTH_CERX : MAX_PART_LENGTH) + " (length found: " + partLength + ")", element, propertyPath, errors);
			}

			// error if part type not allowed
	    	NamePartType partType = personNamePart.getType();
			if (partType == null) {
				countBlankParts++;
				// no part type : only allowed for SIMPLE or, if CeRx, BASIC (max 1 in both cases)
	    		if (!isSimple && !(isBasic && isCeRx)) {
	    			createError("Names without a part type are not allowed", element, propertyPath, errors);
	    		}
	    	} else if (!ALLOWABLE_NAME_PARTS.contains(partType.getValue())) {
    			createError("Part type " + partType.getValue() + " is not allowed for " + type, element, propertyPath, errors);
			}
			
			String qualifier = personNamePart.getQualifier();
			if (StringUtils.isNotBlank(qualifier)) {
				if (isCeRx || (!isMr2007(baseVersion) && isBasic)) {
					if (!"IN".equals(qualifier)) {
		    			createError("Qualifier '" + qualifier + "' not valid. Only 'IN' is allowed.", element, propertyPath, errors);
					}
				} else if (!ALLOWABLE_NAME_PART_QUALIFIERS.contains(qualifier)) {
	    			createError("Qualifier '" + qualifier + "' not valid.", element, propertyPath, errors);
				}
			}
		}

    	if (isSimple && (countBlankParts > 1 || numParts > 1 || (numParts > 0 && countBlankParts == 0))) {
			createError("For PN.SIMPLE, only one simple name (a name without a part type) is allowed, and no other name parts are allowed.", element, propertyPath, errors);
    	}
    	if ((isBasic && isCeRx) && (countBlankParts > 1 || numParts > 1)) {
			createError("For CeRx PN.BASIC, only a single simple name (a name without a part type) is allowed. Multiple name parts can be provided, but none of them may be simple.", element, propertyPath, errors);
    	}
    	
    	// confirmed with CHI that simple and basic types do not have to provide any name parts 
    	if (numParts == 0 && (isFull || isSearch)) {
			createError("At least one name part must be specified.", element, propertyPath, errors);
    	}
    	
	}

	private void validatePersonNameUses(PersonName personName, String type, Hl7BaseVersion baseVersion, Element element, Hl7Errors errors, String propertyPath) {
    	boolean isSearch = StandardDataType.PN_SEARCH.getType().equals(type);
		int numUses = personName.getUses().size();
		// confirmed with CHI that multiple uses are allowed (specs don't indicate either way)
		if (numUses == 0 && !isSearch) {
			createError("PersonName 'use' property is mandatory.", element, propertyPath, errors);
		}
    	
		for (EntityNameUse personNameUse : personName.getUses()) {
			if (!isAllowableUse(type, personNameUse, baseVersion)) {
   				createError("PersonNameUse is not valid: " + (personNameUse == null ? "null" : personNameUse.getCodeValue()), element, propertyPath, errors);
			}
		}
	}

	public boolean isAllowableUse(String dataType, EntityNameUse personNameUse, Hl7BaseVersion baseVersion) {
		Set<String> allowableUses = ALLOWABLE_NAME_USES_BY_VERSION.get(baseVersion);
		if (allowableUses == null) {
			allowableUses = ALLOWABLE_NAME_USES;
		}
		return allowableUses.contains(personNameUse.getCodeValue());
	}

	private boolean isCeRx(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.CERX;
	}

	private boolean isMr2007(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.MR2007 || baseVersion == Hl7BaseVersion.MR2007_V02R01;
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
