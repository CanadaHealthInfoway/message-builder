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
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class CdValidationUtils {

	private static final int MAX_TRANSLATIONS = 10;
	private static final int MAX_CODE_LENGTH = 200;
	private static final int MAX_CODE_LENGTH_CERX_MR2007 = 20;
	private static final int MAX_CODE_SYSTEM_LENGTH = 100;
	private static final int MAX_ORIGINAL_TEXT_LENGTH = 150;

	public void validateCodedType(CD codeWrapper, boolean isCwe, boolean isCne, boolean isTranslation, String type, Hl7BaseVersion baseVersion, Element element, Hl7Errors errors) {
	
		Code code = codeWrapper.getValue();
		List<CD> translations = codeWrapper.getTranslations();
		
		boolean hasCode = (code != null && code.getCodeValue() != null);
		boolean hasNonBlankCode = (hasCode && StringUtils.isNotBlank(code.getCodeValue()));
		boolean hasNullFlavor = codeWrapper.getNullFlavor() != null;
		
		if (StandardDataType.CS.getType().equals(type)) {
			validateCs(codeWrapper, code, translations, baseVersion, element, errors);
		} else {
			// CD/CE/CV
			validateCodeLength(code, baseVersion, element, errors, isTranslation);
			validateValueLength("codeSystem", code == null ? null : code.getCodeSystem(), MAX_CODE_SYSTEM_LENGTH, element, errors, isTranslation);
			validateValueLength("originalText", codeWrapper.getOriginalText(), MAX_ORIGINAL_TEXT_LENGTH, element, errors, isTranslation);
			
			if (hasNullFlavor && hasCode) {
				createError("Code cannot be provided along with a nullFlavor.", element, errors, isTranslation);
			}
			
			if (!isTranslation && (!StandardDataType.CD_LAB.getType().equals(type) || hasNullFlavor)) {
				validateUnallowedValue("displayName", codeWrapper.getDisplayName(), element, errors, isTranslation);
			}
			
			if (!isTranslation) {
				validateTranslations(translations, type, isCwe, isCne, hasNullFlavor, baseVersion, element, errors);
			}
			
			// codes can be one of CWE or CNE (unsure if they can be *neither*)
			if (isCwe && !hasNullFlavor) {
				// cwe = 1 of code/originalText must be non-null; code present = codeSystem mandatory
				if (!hasNonBlankCode && StringUtils.isBlank(codeWrapper.getOriginalText())) {
					createError("For codes with codingStrength of CWE, one of code or originalText must be provided.", element, errors, isTranslation);
				}
				if (hasCode && StringUtils.isBlank(code.getCodeSystem())) {
					createError("For codes with codingStrength of CWE, the codeSystem property must be provided when the code property is included.", element, errors, isTranslation);
				}
			} else if (isCne) {
				// cne = code and codeSystem mandatory if non-null; if NF=OTH then originalText mandatory and no other properties allowed
				if (hasNullFlavor) {
					if (NullFlavor.OTHER.getCodeValue().equals(codeWrapper.getNullFlavor().getCodeValue())) {
						if (StringUtils.isBlank(codeWrapper.getOriginalText())) {
							createError("For codes with codingStrength of CNE, originalText is mandatory when NullFlavor is 'OTH'.", element, errors, isTranslation);
						}
						if (hasAnyPropertiesProvided(codeWrapper)) {
							createError("For codes with codingStrength of CNE, originalText is the only property allowed when NullFlavor is 'OTH'.", element, errors, isTranslation);
						}
					}
				} else if (!hasNonBlankCode || StringUtils.isBlank(code.getCodeSystem())) {
					createError("For codes with codingStrength of CNE, code and codeSystem properties must be provided.", element, errors, isTranslation);
				}
			} else {
				// not entirely clear on what should be validated here; code is mandatory, but is code system as well?
				if (!hasNullFlavor || isTranslation) {
					if (!hasNonBlankCode || StringUtils.isBlank(code.getCodeSystem())) {
						createError("Code and codeSystem properties must be provided.", element, errors, isTranslation);
					}
				}
			}
		}
	}

	private boolean hasAnyPropertiesProvided(CD codeWrapper) {
		Code code = codeWrapper.getValue();
		boolean hasCode = (code != null && code.getCodeValue() != null);
		boolean hasCodeSystem = (code != null && code.getCodeSystem() != null);
		boolean hasDisplayName = codeWrapper.getDisplayName() != null;
		boolean hasTranslations = !codeWrapper.getTranslations().isEmpty();
		return hasCode || hasCodeSystem || hasDisplayName || hasTranslations;
	}

	private void validateCs(CD codeWrapper, Code code, List<CD> translations, Hl7BaseVersion baseVersion, Element element, Hl7Errors errors) {
		boolean hasCode = (code != null && code.getCodeValue() != null);
		boolean hasNonBlankCode = (hasCode && StringUtils.isNotBlank(code.getCodeValue()));
		boolean hasNullFlavor = codeWrapper.getNullFlavor() != null;
		
		// code mandatory, max length 200 (mr2009)/20 (mr2007 and cerx)
		if (!hasNullFlavor && !hasNonBlankCode) {
			createError("Code is mandatory for CS types.", element, errors, false);
		} else if (hasNullFlavor && hasCode) {
			createError("Code cannot be provided along with a nullFlavor.", element, errors, false);
		}
		validateCodeLength(code, baseVersion, element, errors, false);
		// skip validating codeSystem (codes can be created with a codeSystem even if one wasn't provided, unfortunately)
		// validateUnallowedValue("codeSystem", code == null ? null : code.getCodeSystem(), element, errors);
		validateUnallowedValue("originalText", codeWrapper.getOriginalText(), element, errors, false);
		validateUnallowedValue("displayName", codeWrapper.getDisplayName(), element, errors, false);
		validateUnallowedValue("translation", translations.isEmpty() ? null : "", element, errors, false);
	}

	private void validateCodeLength(Code code, Hl7BaseVersion baseVersion, Element element, Hl7Errors errors, boolean isTranslation) {
		validateValueLength("code", code == null ? null : code.getCodeValue(), isCeRx(baseVersion) || isMr2007(baseVersion) ? MAX_CODE_LENGTH_CERX_MR2007 : MAX_CODE_LENGTH, element, errors, isTranslation);
	}

	private void validateTranslations(List<CD> translations, String type, boolean isCwe, boolean isCne, boolean hasNullFlavor, Hl7BaseVersion baseVersion, Element element, Hl7Errors errors) {
		if (hasNullFlavor && !translations.isEmpty() && !StandardDataType.CV.getType().equals(type)) {
			createError("Translations are not allowed when a NullFlavor is specified", element, errors, false);
		} 
			
		if (StandardDataType.CV.getType().equals(type)) {
			validateUnallowedValue("translation", translations.isEmpty() ? null : "", element, errors, false);
		} else {
			// translation max 10; same type as root; no nesting; no NF
			if (translations.size() > MAX_TRANSLATIONS) {
				createError("A maximum of " + MAX_TRANSLATIONS + " translations are allowed.", element, errors, false);
			}
			for (CD translationCodeWrapper : translations) {
				if (!translationCodeWrapper.getTranslations().isEmpty()) {
					createError("Translation may not contain other translations.", element, errors, true);
				}
				if (translationCodeWrapper.getNullFlavor() != null) {
					createError("Translation may not contain a NullFlavor.", element, errors, true);
				}
				if (translationCodeWrapper.getOriginalText() != null) {
					createError("Translation may not contain originalText.", element, errors, true);
				}
				if (translationCodeWrapper.getDisplayName() != null) {
					createError("Translation may not contain displayName.", element, errors, true);
				}
				// validate CD
				boolean isTranslation = true;
				validateCodedType(translationCodeWrapper, false, false, isTranslation, type, baseVersion, element, errors);
			}
		}
	}

	private void validateUnallowedValue(String propertyName, String value, Element element, Hl7Errors errors, boolean isTranslation) {
		if (value != null) {
			createError("CD should not include the '" + propertyName + "' property.", element, errors, isTranslation);
		}
	}

	private void validateValueLength(String propertyName, String value, int maxLength, Element element, Hl7Errors errors, boolean isTranslation) {
		if (value != null && value.length() > maxLength) {
			createError("Code type property '" + propertyName + "' is limited to a maximum length of " + maxLength + " (length found: " + value.length() + ")", element, errors, isTranslation);
		}
	}

	private boolean isCeRx(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.CERX;
	}

	private boolean isMr2007(Hl7BaseVersion baseVersion) {
		return baseVersion == Hl7BaseVersion.MR2007 || baseVersion == Hl7BaseVersion.MR2007_V02R01;
	}

	private void createError(String errorMessage, Element element, Hl7Errors errors, boolean isTranslation) {
		errorMessage = (isTranslation ? "(translation level) " : "") + errorMessage;
		errors.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						errorMessage + 
						(element == null ? "" : (" (" + XmlDescriber.describeSingleElement(element) + ")")), 
						element));
	}

}
