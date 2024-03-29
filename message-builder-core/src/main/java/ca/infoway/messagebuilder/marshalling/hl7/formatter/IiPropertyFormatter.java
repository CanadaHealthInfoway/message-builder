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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.II;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUS;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_BUSVER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_OID;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLIC;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_PUBLICVER;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_TOKEN;
import static ca.infoway.messagebuilder.datatype.StandardDataType.II_VER;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.concreteIiTypes;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiConstraintsHandler;
import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * II - Installer Identifier
 * 
 * II has two attributes: root, extension
 *
 * CeRx standards claim that both attributes are required, although extension 
 * is sometimes unused. 
 * 
 * The HL7 standard also defines the assigningAuthorityName attribute, but that
 * has been left out of the CeRx implementation.
 * 
 * According to CeRx: Root has a limit of 100 characters, extension of 20 
 * characters. These limits are not currently enforced by this class. 
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
 */
@DataTypeHandler("II")
class IiPropertyFormatter extends AbstractAttributePropertyFormatter<Identifier> {

	private static final IiValidationUtils iiValidationUtils = new IiValidationUtils();
	private final IiConstraintsHandler constraintsHandler = new IiConstraintsHandler();
	
    @Override
	protected
    Map<String,String> getAttributeNameValuePairs(FormatContext context, Identifier ii, BareANY bareAny) {
    	
        VersionNumber version = context.getVersion();

        Map<String, String> result = new HashMap<String, String>();
        
    	String typeFromContext = context.getType();
    	typeFromContext = handleSpecializationType(bareAny, context, result);
        
    	validate(ii, typeFromContext, version, context);
    	
    	addStandardAttributes(ii, result);
    	addExtraAttributes(typeFromContext, version, result);
        
        return result;
    }

	private String handleSpecializationType(BareANY bareAny, FormatContext context, Map<String, String> result) {
		String typeFromContext = context.getType();
		String typeFromField = bareAny.getDataType() == null ? null : bareAny.getDataType().getType();
    	if (iiValidationUtils.isSpecializationTypeRequired(context.getVersion(), typeFromContext, context.isCda())) {
    		boolean validSpecializationType = isSpecializationTypeProvided(typeFromContext, typeFromField);
    		if (iiValidationUtils.isII(typeFromContext)) {
    			validSpecializationType &= concreteIiTypes.contains(typeFromField);
    		} else if (iiValidationUtils.isIiBusAndVer(typeFromContext)) {
    			validSpecializationType &= iiValidationUtils.isIiBusOrIiVer(typeFromField);
    		}
    		// only override type if new type is valid
    		if (validSpecializationType) {
    			typeFromContext = typeFromField;
    			addSpecializationTypeAttributesBasedOnVersion(result, typeFromContext, context.getVersion());
    		} else {
    			if (iiValidationUtils.isIiBusAndVer(typeFromContext)) {
        			addSpecializationTypeAttributesBasedOnVersion(result, IiValidationUtils.II_BUS, context.getVersion());
        			typeFromContext = IiValidationUtils.II_BUS;
        			recordError(iiValidationUtils.getInvalidSpecializationTypeForBusAndVerErrorMessage(typeFromField, typeFromContext), context);
    			} else {
    				recordError(iiValidationUtils.getInvalidOrMissingSpecializationTypeErrorMessage(typeFromField), context);
    			}
    		}
    	} else if (isSpecializationTypeProvided(typeFromContext, typeFromField)) {
			recordError(iiValidationUtils.getShouldNotProvideSpecializationTypeErrorMessage(typeFromContext), context);
    	}
		return typeFromContext;
	}

	
	private boolean isSpecializationTypeProvided(String typeFromContext, String typeFromField) {
		// we can only infer a specializationType was provided if the field type is no longer its default value (II, in this case) and is not identical to the context type
		return typeFromField != null && !iiValidationUtils.isII(typeFromField) && !StringUtils.equals(typeFromContext, typeFromField);
	}
	
	private void addSpecializationTypeAttributesBasedOnVersion(Map<String, String> attributes, String typeAsString, VersionNumber version) {
		addSpecializationType(attributes, typeAsString);

		// exception for specification versions that reject II elements containing the specializationType
		// attribute itself, but still require the xsi:type and use attributes
		if (SpecificationVersion.isExactVersion(SpecificationVersion.V01R04_1_AB, version)) {
			attributes.remove(SPECIALIZATION_TYPE);
		}
	}

	private void validate(Identifier ii, String type, VersionNumber version, FormatContext context) {
    	validateMandatoryAttribute("root", ii.getRoot(), type, context);
		if (II.getType().equals(type)) {
        	validateRootAndExtensionAsOidOrUuid(ii.getRoot(), ii.getExtension(), II, version, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        } else if (II_PUBLIC.getType().equals(type)) {
        	validateRootAsOid(ii.getRoot(), version, II_PUBLIC, context);
        	validateExtensionForOid(ii.getExtension(), type, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        } else if (II_BUS.getType().equals(type)) {
        	validateRootAndExtensionAsOidOrUuid(ii.getRoot(), ii.getExtension(), II_BUS, version, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        } else if (II_VER.getType().equals(type)) {
        	validateRootAsUuid(ii.getRoot(), version, II_VER, context);
        	validateUnallowedAttribute("extension", ii.getExtension(), type, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        } else if (II_BUSVER.getType().equals(type)) {
        	validateRootAndExtensionAsOidOrUuid(ii.getRoot(), ii.getExtension(), II_BUSVER, version, context);
        	validateMandatoryAttribute("version", ii.getVersion(), type, context);
        } else if (II_PUBLICVER.getType().equals(type)) {
        	validateRootAsOid(ii.getRoot(), version, II_PUBLICVER, context);
        	validateExtensionForOid(ii.getExtension(), type, context);
        	validateMandatoryAttribute("version", ii.getVersion(), type, context);
        } else if (II_OID.getType().equals(type)) {
        	validateRootAsOid(ii.getRoot(), version, II_OID, context);
        	validateUnallowedAttribute("extension", ii.getExtension(), type, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        } else if (II_TOKEN.getType().equals(type)) {
        	validateRootAsUuid(ii.getRoot(), version, II_TOKEN, context);
        	validateUnallowedAttribute("extension", ii.getExtension(), type, context);
        	validateUnallowedAttribute("version", ii.getVersion(), type, context);
        }
		handleConstraints(ii, context);
	}

	private void handleConstraints(Identifier identifier, final FormatContext context) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				Hl7Errors errors = context.getModelToXmlResult();
				String propertyPath = context.getPropertyPath();
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
		
		this.constraintsHandler.handleConstraints(context.getConstraints(), identifier, logger, isSingleCardinality(context.getCardinality()));
	}

	private boolean isSingleCardinality(Cardinality cardinality) {
		return cardinality == null ? true : cardinality.isSingle();
	}

	private void validateMandatoryAttribute(String attributeName, String attributeValue, String type, FormatContext context) {
		if (StringUtils.isBlank(attributeValue)) {
			recordError("Attribute \"" + attributeName + "\" must be specified for " + type, context);
		}
	}

	private void validateUnallowedAttribute(String attributeName, String attributeValue, String type, FormatContext context) {
		if (StringUtils.isNotBlank(attributeValue)) {
			recordError("Attribute \"" + attributeName + "\" is not allowed for " + type, context);
		}
	}
	
	private void validateRootAsUuid(String root, VersionNumber version, StandardDataType type, FormatContext context) {
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isUuid(root)) {
				recordError(iiValidationUtils.getRootMustBeUuidErrorMessage(root), context);
			}
			validateRootLength(root, version, type, context);
		}
	}

	private void validateRootLength(String root, VersionNumber version, StandardDataType type, FormatContext context) {
		if (iiValidationUtils.isRootLengthInvalid(root, type, version)) {
			recordError(iiValidationUtils.getInvalidRootLengthErrorMessage(root, type, version), context);
		}
	}

	private void validateRootAsOid(String root, VersionNumber version, StandardDataType type, FormatContext context) {
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isOid(root)) {
				recordError(iiValidationUtils.getRootMustBeAnOidErrorMessage(root), context);
			}
			validateRootLength(root, version, type, context);
		}
	}
	
	private void validateExtensionForOid(String extension, String type, FormatContext context) {
		// extension is mandatory in this case
    	validateMandatoryAttribute("extension", extension, type, context);
		validateExtensionLength(extension, context);
	}

	private void validateExtensionLength(String extension, FormatContext context) {
		if (iiValidationUtils.isExtensionLengthInvalid(extension)) {
			recordError(iiValidationUtils.getInvalidExtensionLengthErrorMessage(extension), context);
		}
	}

	private void validateRootAndExtensionAsOidOrUuid(String root, String extension, StandardDataType type, VersionNumber version, FormatContext context) {
		// if root has not been provided don't bother further validating root or extension
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isUuid(root)) {
				validateRootAsOid(root, version, type, context);
				if (!context.isCda()) {
					validateExtensionForOid(extension, type.getName(), context);
				}
			} else {
				validateRootAsUuid(root, version, type, context);
				validateUnallowedAttribute("extension", extension, type.getName(), context);
			}
		}
	}

	private void addStandardAttributes(Identifier ii, Map<String, String> result) {
		result.put("root", ii.getRoot() == null ? StringUtils.EMPTY : ii.getRoot());

    	if (StringUtils.isNotBlank(ii.getExtension())) {
    		result.put("extension", ii.getExtension());
    	}
    	
    	if (StringUtils.isNotBlank(ii.getVersion())) {
    		result.put("version", ii.getVersion());
    	}
	}

	private void addExtraAttributes(String type, VersionNumber version, Map<String, String> result) {
		if (II_PUBLIC.getType().equals(type)) {
			if (!iiValidationUtils.isCerxOrMr2007(version, II_PUBLIC)) {
				result.put("use", "BUS");
            }
            result.put("displayable", "true");
        } else if (II_BUS.getType().equals(type)) {
			result.put("use", "BUS");
        } else if (II_VER.getType().equals(type)) {
            result.put("use", "VER");
        } else if (II_BUSVER.getType().equals(type)) {
            result.put("use", "BUS");
        } else if (II_PUBLICVER.getType().equals(type)) {
            result.put("displayable", "true");
        } else if (II_OID.getType().equals(type)) {
			if (!iiValidationUtils.isCerxOrMr2007(version, II_OID)) {
				result.put("use", "BUS");
            }
        }
	}

	private void recordError(String message, FormatContext context) {
		String propertyPath = context.getPropertyPath();
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, propertyPath));
	}

}
