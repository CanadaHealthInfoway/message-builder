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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_BUS;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_BUSVER;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_OID;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_PUBLIC;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_PUBLICVER;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_TOKEN;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.II_VER;
import static ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils.concreteIiTypes;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * II - Installer Identifier
 * 
 * Parses an II element into a II object. The element looks like this:
 * 
 * <element-name root="data1" extension="data2" />
 * 
 * CeRx standards claim that both attributes are required, although extension 
 * is sometimes unused.
 * 
 * The HL7 standard defines the assigningAuthorityName attribute, but that
 * has been left out of the CeRx implementation.
 * 
 * According to CeRx: Root has a limit of 100 characters, extension of 20 
 * characters. These limits are not currently enforced by this class. 
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-II
 */
@DataTypeHandler("II")
class IiElementParser extends AbstractSingleElementParser<Identifier> {
	
	private static final IiValidationUtils iiValidationUtils = new IiValidationUtils();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IIImpl();
	}

	@Override
	protected Identifier parseNonNullNode(ParseContext context, Node node, BareANY result, Type returnType, XmlToModelResult xmlToModelResult) {
		
		Element element = (Element) node;
		VersionNumber version = (context == null ? null : context.getVersion());
		
		String root = getMandatoryAttributeValue(element, "root", xmlToModelResult);
		String extension = getAttributeValue(element, "extension");
		String versionAttribute = null;
		
		String type = handleSpecializationType(context, element, xmlToModelResult);
		
		// type might have resolved to something different if this II.x is abstract (II, II_BUS_AND_VER), so set it again before performing validations
		setDataType(type, result);

		if (II.equals(type)) {
			// should only occur for CeRx and AB, but could happen if a relationship of type II is not specified via specializationType 
			validateII(xmlToModelResult, element, version, root, extension,	type);
		} else if (II_TOKEN.equals(type)) {
			validateII_TOKEN(xmlToModelResult, element, root, type, version);
		} else if (II_BUS.equals(type)) {
			validateII_BUS(xmlToModelResult, element, root, extension, type, version);
		} else if (II_OID.equals(type)) {
			validateII_OID(context, xmlToModelResult, element, root, type, version);
		} else if (II_PUBLIC.equals(type)) {
			validateII_PUBLIC(context, xmlToModelResult, element, root, extension, type, version, false);
		} else if (II_VER.equals(type)) {
			validateII_VER(xmlToModelResult, element, root, type, version);
		} else if (II_BUSVER.equals(type)) {
			versionAttribute = validateII_BUSVER(xmlToModelResult, element, root, extension, type, version);
		} else if (II_PUBLICVER.equals(type)) {
			versionAttribute = validateII_PUBLICVER(context, xmlToModelResult, element, root, extension, type, version);
		}
		validateUnallowedAttributes(type, element, xmlToModelResult, "assigningAuthorityName");
		return new Identifier(root, extension, versionAttribute);
	}

	private void validateII(XmlToModelResult xmlToModelResult, Element element, VersionNumber version, String root, String extension, String type) {
		validateRootAndExtensionAsOidOrUuid(xmlToModelResult, element, root, extension,	type, version);
		validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		validateUnallowedAttributes(type, element, xmlToModelResult, "use");
	}

	private String validateII_PUBLICVER(ParseContext context, XmlToModelResult xmlToModelResult, Element element, String root, String extension, String type, VersionNumber version) {
		validateII_PUBLIC(context, xmlToModelResult, element, root, extension, type, version, true);
		return getMandatoryAttributeValue(element, "version", xmlToModelResult);
	}

	private String validateII_BUSVER(XmlToModelResult xmlToModelResult, Element element, String root, String extension, String type, VersionNumber version) {
		validateII_BUS(xmlToModelResult, element, root, extension, type, version);
		return getMandatoryAttributeValue(element, "version", xmlToModelResult);
	}

	private void validateII_VER(XmlToModelResult xmlToModelResult, Element element, String root, String type, VersionNumber version) {
		validateRootAsUuid(element, root, xmlToModelResult, version);
		validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
		validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		validateAttributeEquals(type, element, xmlToModelResult, "use", "VER");
	}

	private void validateII_TOKEN(XmlToModelResult xmlToModelResult, Element element, String root, String type, VersionNumber version) {
		validateRootAsUuid(element, root, xmlToModelResult, version);
		validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
		validateUnallowedAttributes(type, element, xmlToModelResult, "use");
		validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
	}

	private void validateII_OID(ParseContext context, XmlToModelResult xmlToModelResult, Element element, String root, String type, VersionNumber version) {
		validateRootAsOid(root, element, xmlToModelResult, version);
		validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
		validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		if (!iiValidationUtils.isCerxOrMr2007(context.getVersion())) {
			validateAttributeEquals(type, element, xmlToModelResult, "use", "BUS");
		} else {
			validateUnallowedAttributes(type, element, xmlToModelResult, "use");
		}
	}

	private void validateII_PUBLIC(ParseContext context, XmlToModelResult xmlToModelResult, Element element, String root, String extension, String type, VersionNumber version, boolean isII_PUBLICVER) {
		validateRootAsOid(root, element, xmlToModelResult, version);
		validateExtensionForOid(xmlToModelResult, element, extension);
		validateAttributeEquals(type, element, xmlToModelResult, "displayable", "true");
		// Redmine 11293 - TM - must have use=BUS, but not for MR2007 (use is not permitted in this case)
		if (!isII_PUBLICVER && !iiValidationUtils.isCerxOrMr2007(context.getVersion())) {
			validateAttributeEquals(type, element, xmlToModelResult, "use", "BUS");
		} else {
			validateUnallowedAttributes(type, element, xmlToModelResult, "use");
		}
	}

	private void validateII_BUS(XmlToModelResult xmlToModelResult, Element element, String root, String extension, String type, VersionNumber version) {
		validateRootAndExtensionAsOidOrUuid(xmlToModelResult, element, root, extension,	type, version);
		validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		validateAttributeEquals(type, element, xmlToModelResult, "use", "BUS");
	}

	private void validateRootAndExtensionAsOidOrUuid(XmlToModelResult xmlToModelResult,	Element element, String root, String extension, String type, VersionNumber version) {
		// if root has not been provided don't bother further validating root or extension
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isUuid(root)) {
				validateRootAsOid(root, element, xmlToModelResult, version);
				validateExtensionForOid(xmlToModelResult, element, extension);
			} else {
				validateRootAsUuid(element, root, xmlToModelResult, version);
				validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
			}
		}
	}

	private void validateExtensionForOid(XmlToModelResult xmlToModelResult,	Element element, String extension) {
		// extension is mandatory in this case
		getMandatoryAttributeValue(element, "extension", xmlToModelResult);
		validateExtensionLength(element, extension, xmlToModelResult);
	}

	private String handleSpecializationType(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		VersionNumber version = context.getVersion();
		String typeFromContext = context.getType(); 
		String specializationType = getSpecializationType(element);
		
    	if (iiValidationUtils.isSpecializationTypeRequired(version, typeFromContext)) {
    		boolean validSpecializationType = isSpecializationTypeProvided(specializationType);
    		if (iiValidationUtils.isII(typeFromContext)) {
    			validSpecializationType &= concreteIiTypes.contains(specializationType);
    		} else if (iiValidationUtils.isIiBusAndVer(typeFromContext)) {
    			validSpecializationType &= iiValidationUtils.isIiBusOrIiVer(specializationType);
    		}
    		// only override type if new type is valid
    		if (validSpecializationType) {
    			typeFromContext = specializationType;
    		} else {
    			if (iiValidationUtils.isIiBusAndVer(typeFromContext)) {
        			String use = getAttributeValue(element, "use");
        			typeFromContext = ("VER".equals(use) ? II_VER : II_BUS); // II.BUS allows oids and uuids, so default to it as a last resort
        			recordError(iiValidationUtils.getInvalidSpecializationTypeForBusAndVerErrorMessage(specializationType, typeFromContext), element, xmlToModelResult);
    			} else {
    				recordError(iiValidationUtils.getInvalidOrMissingSpecializationTypeErrorMessage(specializationType), element, xmlToModelResult);
    			}
    		}
    	} else if (isSpecializationTypeProvided(specializationType)) {
			recordError(iiValidationUtils.getShouldNotProvideSpecializationTypeErrorMessage(typeFromContext), element, xmlToModelResult);
    	}
		return typeFromContext;
	}

	private boolean isSpecializationTypeProvided(String specializationType) {
		return specializationType != null;
	}

	private void validateAttributeEquals(String type, Element element, XmlToModelResult xmlToModelResult, String attributeName, String attributeValue) {
		if (!element.hasAttribute(attributeName)) {
			recordError(iiValidationUtils.getMissingAttributeErrorMessage(type, attributeName, attributeValue), element, xmlToModelResult);
		} else if (!StringUtils.equals(element.getAttribute(attributeName), attributeValue)) {
			recordError(iiValidationUtils.getIncorrectAttributeValueErrorMessage(type, attributeName, attributeValue), element, xmlToModelResult);
		}
	}

	private void validateRootAsUuid(Element element, String root, XmlToModelResult xmlToModelResult, VersionNumber version) {
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isUuid(root)) {
				recordError(iiValidationUtils.getRootMustBeUuidErrorMessage(root), element, xmlToModelResult);
			}
			validateRootLength(element, root, xmlToModelResult, version);
		}
	}

	private void validateRootLength(Element element, String root, XmlToModelResult xmlToModelResult, VersionNumber version) {
		if (iiValidationUtils.isRootLengthInvalid(root, version)) {
			recordError(iiValidationUtils.getInvalidRootLengthErrorMessage(root, version), element, xmlToModelResult);
		}
	}

	private void validateExtensionLength(Element element, String extension,	XmlToModelResult xmlToModelResult) {
		if (iiValidationUtils.isExtensionLengthInvalid(extension)) {
			recordError(iiValidationUtils.getInvalidExtensionLengthErrorMessage(extension), element, xmlToModelResult);
		}
	}

	private void validateRootAsOid(String root, Element element, XmlToModelResult xmlToModelResult, VersionNumber version) {
		if (StringUtils.isNotBlank(root)) {
			if (!iiValidationUtils.isOid(root)) {
				recordError(iiValidationUtils.getRootMustBeAnOidErrorMessage(root), element, xmlToModelResult);
			}
			validateRootLength(element, root, xmlToModelResult, version);
		}
	}

	private void recordError(String message, Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
			new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR,
					message + " (" + XmlDescriber.describeSingleElement(element) + ")",
					element)
		);
	}

}
