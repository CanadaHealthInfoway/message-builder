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

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class TelValidationUtils {

	private static final int MAX_USES = 3;
	private static final int MAX_VALUE_LENGTH_EMAIL = 50;
	private static final int MAX_VALUE_LENGTH_URI = 255;
	private static final int MAX_VALUE_LENGTH_PHONE_MR2009 = 40;
	private static final int MAX_VALUE_LENGTH_PHONE_MR2007_CERX = 25;

    private final static Set<String> ALLOWABLE_TELECOM_USES = new HashSet<String>();
    
    private final static Map<String, Set<String>> ALLOWABLE_SCHEMES_BY_TYPE = new HashMap<String, Set<String>>();
    
    private final static Set<String> ALLOWABLE_PHONE_SCHEMES = new HashSet<String>();
    private final static Set<String> ALLOWABLE_EMAIL_SCHEMES = new HashSet<String>();
    private final static Set<String> ALLOWABLE_URI_SCHEMES = new HashSet<String>();

    static {
        ALLOWABLE_TELECOM_USES.add("WP");
        ALLOWABLE_TELECOM_USES.add("TMP");
        ALLOWABLE_TELECOM_USES.add("MC");
        ALLOWABLE_TELECOM_USES.add("PG"); // n/a for email
        ALLOWABLE_TELECOM_USES.add("H");
        ALLOWABLE_TELECOM_USES.add("EC");
        ALLOWABLE_TELECOM_USES.add("CONF"); // n/a for MR2007 or CeRx
        ALLOWABLE_TELECOM_USES.add("DIR"); // n/a for CeRx
        
        ALLOWABLE_PHONE_SCHEMES.add("fax");
        ALLOWABLE_PHONE_SCHEMES.add("tel");

        ALLOWABLE_EMAIL_SCHEMES.add("mailto");
        
        ALLOWABLE_URI_SCHEMES.add("file");
        ALLOWABLE_URI_SCHEMES.add("ftp");
        ALLOWABLE_URI_SCHEMES.add("http");
        ALLOWABLE_URI_SCHEMES.add("https");
        ALLOWABLE_URI_SCHEMES.add("mailto");
        ALLOWABLE_URI_SCHEMES.add("nfs");
        
        ALLOWABLE_SCHEMES_BY_TYPE.put("TEL.PHONE", ALLOWABLE_PHONE_SCHEMES);
        ALLOWABLE_SCHEMES_BY_TYPE.put("TEL.EMAIL", ALLOWABLE_EMAIL_SCHEMES);
        ALLOWABLE_SCHEMES_BY_TYPE.put("TEL.URI", ALLOWABLE_URI_SCHEMES);
    }

	public void validateTelecommunicationAddress(TelecommunicationAddress telecomAddress, String type, String specializationType, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		String actualType = determineActualType(telecomAddress, type, specializationType, version, element, propertyPath, errors, true);
    	validateTelecomAddressUses(telecomAddress, actualType, version, element, propertyPath, errors);
    	validateTelecomAddressScheme(telecomAddress, actualType, version.getBaseVersion(), element, propertyPath, errors);
    	validateTelecomAddressValue(telecomAddress, actualType, version, element, propertyPath, errors);
	}

	public String determineActualType(TelecommunicationAddress telecomAddress, String type, String specializationType, VersionNumber version, Element element, String propertyPath, Hl7Errors errors, boolean logErrors) {
		String actualType = type;
		boolean isTelAll = StandardDataType.TEL_ALL.getType().equals(type);
		boolean isTelPhonemail = StandardDataType.TEL_PHONEMAIL.getType().equals(type);
		
		if (isTelAll || isTelPhonemail) {
			if (isCeRxOrNewfoundland(version)) {
				URLScheme urlScheme = telecomAddress.getUrlScheme();
				if ("mailto".equals(urlScheme == null ? null : urlScheme.getCodeValue())) {
					actualType = "TEL.EMAIL";
				} else {
					actualType = "TEL.PHONE";
				}
			} else {
				if (StringUtils.isBlank(specializationType)) {
					if (logErrors) {
						String errorMessage = MessageFormat.format(
								"No specialization type provided. Specialization type of TEL.PHONE/TEL.EMAIL{0} must be specified for abstract data type {1}. Assuming TEL.PHONE",
								isTelAll ? "/TEL.URI" : "", type);
						createError(errorMessage, element, propertyPath, errors);
					}
					actualType = "TEL.PHONE";
				} else if (!StandardDataType.TEL_PHONE.getType().equals(specializationType) && 
						   !StandardDataType.TEL_EMAIL.getType().equals(specializationType) && 
						   !(StandardDataType.TEL_URI.getType().equals(specializationType) && isTelAll)) {
					if (logErrors) {
						String errorMessage = MessageFormat.format(
								"Invalid specialization type provided. Specialization type of TEL.PHONE/TEL.EMAIL{0} must be specified for abstract data type {1}. Assuming TEL.PHONE",
								isTelAll ? "/TEL.URI" : "", type);
						createError(errorMessage, element, propertyPath, errors);
					}
					actualType = "TEL.PHONE";
				} else {
					actualType = specializationType;
				}
			}
		}
		return actualType;
	}

	private void validateTelecomAddressValue(TelecommunicationAddress telecomAddress, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		Hl7BaseVersion baseVersion = version.getBaseVersion();
		String address = telecomAddress.getAddress();
		int schemePlusAddressLength = telecomAddress.toString().length();

		if (StringUtils.isBlank(address)) {
			createError("TelecomAddress must have a value for the actual address", element, propertyPath, errors);
		} else if (StandardDataType.TEL_EMAIL.getType().equals(type) && schemePlusAddressLength > MAX_VALUE_LENGTH_EMAIL) {
			createMaxLengthError(schemePlusAddressLength, MAX_VALUE_LENGTH_EMAIL, type, baseVersion, element, propertyPath, errors);
		} else if (StandardDataType.TEL_URI.getType().equals(type) && schemePlusAddressLength > MAX_VALUE_LENGTH_URI) {
			createMaxLengthError(schemePlusAddressLength, MAX_VALUE_LENGTH_URI, type, baseVersion, element, propertyPath, errors);
		} else if (StandardDataType.TEL_PHONE.getType().equals(type)) {
			if (isMr2007(baseVersion) || isCeRxOrNewfoundland(version)) {
				if (schemePlusAddressLength > MAX_VALUE_LENGTH_PHONE_MR2007_CERX) {
					createMaxLengthError(schemePlusAddressLength, MAX_VALUE_LENGTH_PHONE_MR2007_CERX, type, baseVersion, element, propertyPath, errors);
				}
			} else {
				if (schemePlusAddressLength > MAX_VALUE_LENGTH_PHONE_MR2009) {
					createMaxLengthError(schemePlusAddressLength, MAX_VALUE_LENGTH_PHONE_MR2009, type, baseVersion, element, propertyPath, errors);
				}
			}
		}
	}

	private void createMaxLengthError(int addressLength, int maxLength,	String type, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors) {
		createError(type + " value (scheme + address) limited to a length of " + maxLength + " for " + baseVersion + " (length was " + addressLength + ")", element, propertyPath, errors);
	}

	private void validateTelecomAddressScheme(TelecommunicationAddress telecomAddress, String type, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors) {
    	URLScheme urlScheme = telecomAddress.getUrlScheme();
		String urlSchemeValue = (urlScheme == null ? null : urlScheme.getCodeValue().toLowerCase());
    	
    	if (urlScheme == null) {
			createError("TelecomAddress must have a valid URL scheme (e.g. 'http://')", element, propertyPath, errors);
    	} else if (StandardDataType.TEL.getType().equals(type)) {
    		// any known scheme should be ok here
    		Collection<Set<String>> values = ALLOWABLE_SCHEMES_BY_TYPE.values();
    		for (Set<String> set : values) {
				if (set.contains(urlSchemeValue)) {
					return; // we're good here
				}
			}
			createError("TelecomAddressScheme " + urlScheme.getCodeValue() + " is not valid for " + type, element, propertyPath, errors);
    	} else {
    		Set<String> allowableSchemes = ALLOWABLE_SCHEMES_BY_TYPE.get(type);
    		if (allowableSchemes == null || !allowableSchemes.contains(urlSchemeValue)) {
    			createError("TelecomAddressScheme " + urlScheme.getCodeValue() + " is not valid for " + type, element, propertyPath, errors);
    		}
    	}
	}

	private void validateTelecomAddressUses(TelecommunicationAddress telecomAddress, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		int numUses = telecomAddress.getAddressUses().size();
    	boolean isUri = StandardDataType.TEL_URI.getType().equals(type);
		if (isUri && numUses > 0) {
    		// error if > 0 and URI
			createError("TelecomAddressUses are not allowed for TEL.URI", element, propertyPath, errors);
    	} else {
			if (numUses > MAX_USES) {
				// error if more than 3 uses
				createError("A maximum of 3 TelecomAddressUses are allowed (number found: " + numUses + ")", element, propertyPath, errors);
			}
		}
    	
		if (!isUri) {
			for (TelecommunicationAddressUse telecomAddressUse : telecomAddress.getAddressUses()) {
				if (!isAllowableUse(type, telecomAddressUse, version)) {
	   				createError("TelecomAddressUse is not valid: " + (telecomAddressUse == null ? "null" : telecomAddressUse.getCodeValue()), element, propertyPath, errors);
				}
			}
		}
	}

	public boolean isAllowableUse(String dataType, TelecommunicationAddressUse telecomAddressUse, VersionNumber version) {
		Hl7BaseVersion baseVersion = version.getBaseVersion();
		return !StandardDataType.TEL_URI.getType().equals(dataType)
				&& telecomAddressUse != null && telecomAddressUse.getCodeValue() != null 
				&& ALLOWABLE_TELECOM_USES.contains(telecomAddressUse.getCodeValue() != null ? telecomAddressUse.getCodeValue().toUpperCase() : null)
				&& !(StandardDataType.TEL_EMAIL.getType().equals(dataType) && isPgConfDir(telecomAddressUse))
				&& !(isMr2007(baseVersion) && isConf(telecomAddressUse))
				&& !(isCeRxOrNewfoundland(version) && isConfOrDir(telecomAddressUse));
	}

	private boolean isMr2007(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.MR2007;
	}

	private boolean isCeRxOrNewfoundland(VersionNumber version) {
		return version.getBaseVersion() == Hl7BaseVersion.CERX || "NEWFOUNDLAND".equals(version.getVersionLiteral());
	}

	private boolean isConfOrDir(TelecommunicationAddressUse telecomAddressUse) {
		return isConf(telecomAddressUse)
				|| ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.DIRECT.getCodeValue().equals(telecomAddressUse.getCodeValue());
	}
	
	private boolean isConf(TelecommunicationAddressUse telecomAddressUse) {
		return ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.CONFIDENTIAL.getCodeValue().equals(telecomAddressUse.getCodeValue());
	}

	private boolean isPgConfDir(TelecommunicationAddressUse telecomAddressUse) {
		return ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse.PAGER.getCodeValue().equals(telecomAddressUse.getCodeValue())
				|| isConfOrDir(telecomAddressUse);
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
