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

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class CdValidationUtils {

	private static final int MAX_TRANSLATIONS = 10;
	private static final int MAX_CODE_LENGTH = 200;
	public static final int MAX_CODE_LENGTH_CERX_MR2007 = 20;
	private static final int MAX_CODE_SYSTEM_LENGTH = 100;
	private static final int MAX_ORIGINAL_TEXT_LENGTH = 150;

	public void validateCodedType(CD codeWrapper, String codeAsString, boolean isCwe, boolean isCne, boolean isTranslation, String type, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {

		Hl7BaseVersion baseVersion = version == null ? Hl7BaseVersion.MR2009 : version.getBaseVersion();
		
		// validations use codeAsString instead of codeWrapper.getValue().getCodeValue() in case the code specified wasn't found by a lookup
		//    - this ensures we validate exactly what was passed in, and redundant errors aren't recorded (in most cases, at least)
		
		Code code = codeWrapper.getValue();
		String codeSystem = (code == null ? null : code.getCodeSystem());
		List<CD> translations = codeWrapper.getTranslations();
		
		boolean hasCode = (codeAsString != null);
		boolean hasNonBlankCode = (StringUtils.isNotBlank(codeAsString));
		boolean hasNullFlavor = codeWrapper.getNullFlavor() != null;
		
		if (StandardDataType.CS.getType().equals(type)) {
			validateCs(codeWrapper, codeAsString, translations, baseVersion, element, propertyPath, errors);
		} else {
			// CD/CE/CV
			validateCodeLength(codeAsString, baseVersion, element, propertyPath, errors, isTranslation);
			validateValueLength("codeSystem", code == null ? null : codeSystem, MAX_CODE_SYSTEM_LENGTH, element, propertyPath, errors, isTranslation);
			validateValueLength("originalText", codeWrapper.getOriginalText(), MAX_ORIGINAL_TEXT_LENGTH, element, propertyPath, errors, isTranslation);
			
			if (hasNullFlavor && hasCode) {
				createError("Code cannot be provided along with a nullFlavor.", element, propertyPath, errors, isTranslation);
			}
			
			if (!isTranslation) {
				// displayName is only allowed for CD.LAB, and for CV (but only if BC); in both of these cases, this is disallowed if nullFlavor
				if (isCdLab(type) || (isBC(version) && isCv(type))) {
					if (hasNullFlavor) {
						validateUnallowedValue(StandardDataType.getByTypeName(type), "displayName", codeWrapper.getDisplayName(), element, propertyPath, errors, isTranslation, "when a nullFlavor");
					}
				} else {
					validateUnallowedValue(StandardDataType.getByTypeName(type), "displayName", codeWrapper.getDisplayName(), element, propertyPath, errors, isTranslation, null);
				}
			}
			
			if (!isTranslation) {
				validateTranslations(translations, type, isCwe, isCne, hasNullFlavor, version, element, propertyPath, errors);
			}
			
			// codes can be one of CWE or CNE (unsure if they can be *neither*)
			if (isCwe && !hasNullFlavor) {
				// cwe = 1 of code/originalText must be non-null; code present = codeSystem mandatory
				if (!hasNonBlankCode && StringUtils.isBlank(codeWrapper.getOriginalText())) {
					createError("For codes with codingStrength of CWE, one of code or originalText must be provided.", element, propertyPath, errors, isTranslation);
				}
				if (hasCode && StringUtils.isBlank(codeSystem)) {
					createError("For codes with codingStrength of CWE, the codeSystem property must be provided when the code property is included.", element, propertyPath, errors, isTranslation);
				}
			} else if (isCne) {
				// cne = code and codeSystem mandatory if non-null; if NF=OTH then originalText mandatory and no other properties allowed
				if (hasNullFlavor) {
					if (NullFlavor.OTHER.getCodeValue().equals(codeWrapper.getNullFlavor().getCodeValue())) {
						if (StringUtils.isBlank(codeWrapper.getOriginalText())) {
							createError("For codes with codingStrength of CNE, originalText is mandatory when NullFlavor is 'OTH'.", element, propertyPath, errors, isTranslation);
						}
						if (hasAnyPropertiesProvided(codeWrapper, codeAsString)) {
							createError("For codes with codingStrength of CNE, originalText is the only property allowed when NullFlavor is 'OTH'.", element, propertyPath, errors, isTranslation);
						}
					}
				} else if (!hasNonBlankCode || StringUtils.isBlank(codeSystem)) {
					createError("For codes with codingStrength of CNE, code and codeSystem properties must be provided.", element, propertyPath, errors, isTranslation);
				}
			} else {
				// not entirely clear on what should be validated here; code is mandatory, but is code system as well?
				if (!hasNullFlavor || isTranslation) {
					if (!hasNonBlankCode || StringUtils.isBlank(codeSystem)) {
						createError("Code and codeSystem properties must be provided.", element, propertyPath, errors, isTranslation);
					}
				}
			}
		}
	}

	private boolean isCdLab(String type) {
		return StandardDataType.CD_LAB.getType().equals(type);
	}

	private boolean isCv(String type) {
		return StandardDataType.CV.getType().equals(type);
	}

	private boolean isBC(VersionNumber version) {
		return SpecificationVersion.isExactVersion(version, SpecificationVersion.V02R04_BC);
	}

	private boolean hasAnyPropertiesProvided(CD codeWrapper, String codeAsString) {
		Code code = codeWrapper.getValue();
		boolean hasCode = (codeAsString != null);
		boolean hasCodeSystem = (code != null && code.getCodeSystem() != null);
		boolean hasDisplayName = codeWrapper.getDisplayName() != null;
		boolean hasTranslations = !codeWrapper.getTranslations().isEmpty();
		return hasCode || hasCodeSystem || hasDisplayName || hasTranslations;
	}

	private void validateCs(CD codeWrapper, String codeAsString, List<CD> translations, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors) {
		boolean hasCode = (codeAsString != null);
		boolean hasNonBlankCode = (StringUtils.isNotBlank(codeAsString));
		boolean hasNullFlavor = codeWrapper.getNullFlavor() != null;
		
		// code mandatory, max length 200 (mr2009)/20 (mr2007 and cerx)
		if (!hasNullFlavor && !hasNonBlankCode) {
			createError("Code is mandatory for CS types.", element, propertyPath, errors, false);
		} else if (hasNullFlavor && hasCode) {
			createError("Code cannot be provided along with a nullFlavor.", element, propertyPath, errors, false);
		}
		validateCodeLength(codeAsString, baseVersion, element, propertyPath, errors, false);
		// skip validating codeSystem (codes can be created with a codeSystem even if one wasn't provided, unfortunately)
		// validateUnallowedValue("codeSystem", code == null ? null : code.getCodeSystem(), element, errors);
		validateUnallowedValue(StandardDataType.CS, "originalText", codeWrapper.getOriginalText(), element, propertyPath, errors, false, null);
		validateUnallowedValue(StandardDataType.CS, "displayName", codeWrapper.getDisplayName(), element, propertyPath, errors, false, null);
		validateUnallowedValue(StandardDataType.CS, "translation", translations.isEmpty() ? null : "", element, propertyPath, errors, false, null);
	}

	private void validateCodeLength(String codeAsString, Hl7BaseVersion baseVersion, Element element, String propertyPath, Hl7Errors errors, boolean isTranslation) {
		validateValueLength("code", codeAsString, isCeRx(baseVersion) || isMr2007(baseVersion) ? MAX_CODE_LENGTH_CERX_MR2007 : MAX_CODE_LENGTH, element, propertyPath, errors, isTranslation);
	}

	private void validateTranslations(List<CD> translations, String type, boolean isCwe, boolean isCne, boolean hasNullFlavor, VersionNumber version, Element element, String propertyPath, Hl7Errors errors) {
		if (hasNullFlavor && !translations.isEmpty() && !StandardDataType.CV.getType().equals(type)) {
			createError("Translations are not allowed when a NullFlavor is specified", element, propertyPath, errors, false);
		} 
			
		if (StandardDataType.CV.getType().equals(type)) {
			validateUnallowedValue(StandardDataType.CV, "translation", translations.isEmpty() ? null : "", element, propertyPath, errors, false, null);
		} else {
			// translation max 10; same type as root; no nesting; no NF
			if (translations.size() > MAX_TRANSLATIONS) {
				createError("A maximum of " + MAX_TRANSLATIONS + " translations are allowed.", element, propertyPath, errors, false);
			}
			for (CD translationCodeWrapper : translations) {
				if (!translationCodeWrapper.getTranslations().isEmpty()) {
					createError("Translation may not contain other translations.", element, propertyPath, errors, true);
				}
				if (translationCodeWrapper.getNullFlavor() != null) {
					createError("Translation may not contain a NullFlavor.", element, propertyPath, errors, true);
				}
				if (translationCodeWrapper.getOriginalText() != null) {
					createError("Translation may not contain originalText.", element, propertyPath, errors, true);
				}
				if (translationCodeWrapper.getDisplayName() != null) {
					createError("Translation may not contain displayName.", element, propertyPath, errors, true);
				}
				// validate CD
				boolean isTranslation = true;
				// this could still result in seeing some redundant error messages if the translation code was invalid; decided this is ok for a little-used feature
				String codeAsString = translationCodeWrapper.getValue() == null ? null : translationCodeWrapper.getValue().getCodeValue();
				validateCodedType(translationCodeWrapper, codeAsString, false, false, isTranslation, type, version, element, propertyPath, errors);
			}
		}
	}

	private void validateUnallowedValue(StandardDataType type, String propertyName, String value, Element element, String propertyPath, Hl7Errors errors, boolean isTranslation, String detailMessage) {
		if (value != null) {
			String errorMessage = (type == null ? "Type" : type.getName()) + " should not include the '" + propertyName + "' property";
			if (StringUtils.isNotBlank(detailMessage)) {
				errorMessage += " (" + detailMessage + ")";
			}
			createError(errorMessage, element, propertyPath, errors, isTranslation);
		}
	}

	private void validateValueLength(String propertyName, String value, int maxLength, Element element, String propertyPath, Hl7Errors errors, boolean isTranslation) {
		if (value != null && value.length() > maxLength) {
			createError("Code type property '" + propertyName + "' is limited to a maximum length of " + maxLength + " (length found: " + value.length() + ")", element, propertyPath, errors, isTranslation);
		}
	}

	private boolean isCeRx(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.CERX;
	}

	private boolean isMr2007(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.MR2007;
	}

	private void createError(String errorMessage, Element element, String propertyPath, Hl7Errors errors, boolean isTranslation) {
		errorMessage = (isTranslation ? "(translation level) " : "") + errorMessage;
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
