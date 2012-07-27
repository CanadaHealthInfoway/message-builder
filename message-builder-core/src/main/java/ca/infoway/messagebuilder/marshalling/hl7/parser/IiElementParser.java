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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
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
	
	private static final String II = "II";
	private static final String II_TOKEN = "II.TOKEN";
	private static final String II_BUS = "II.BUS";
	private static final String II_PUBLIC = "II.PUBLIC";
	private static final String II_OID = "II.OID";
	private static final String II_VER = "II.VER";
	private static final String II_BUS_AND_VER = "II.BUS_AND_VER";
	private static final String II_BUSVER = "II.BUSVER";
	private static final String II_PUBLICVER = "II.PUBLICVER";
	
	private static final Set<String> concreteIiTypes = new HashSet<String>();
	static {
		concreteIiTypes.add(II_TOKEN);
		concreteIiTypes.add(II_BUS);
		concreteIiTypes.add(II_PUBLIC);
		concreteIiTypes.add(II_OID);
		concreteIiTypes.add(II_VER);
		concreteIiTypes.add(II_BUSVER);
		concreteIiTypes.add(II_PUBLICVER);
	}
	
	private static final int EXTENSION_MAX_LENGTH = 20;
	private static final int ROOT_MAX_LENGTH = 200;
	private static final int ROOT_MAX_LENGTH_CERX = 100;

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IIImpl();
	}

	@Override
	protected Identifier parseNonNullNode(ParseContext context, Node node, BareANY result, Type returnType, XmlToModelResult xmlToModelResult)
			throws XmlToModelTransformationException {
		
		Element element = (Element) node;
		VersionNumber version = (context == null ? null : context.getVersion());
		
		String root = getMandatoryAttributeValue(element, "root", xmlToModelResult);
		String extension = getAttributeValue(element, "extension");
		String versionAttribute = null;
		
		String type = getType(context, element, xmlToModelResult);
		
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
		if (isMR2009(context.getVersion())) {
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
		if (!isII_PUBLICVER && isMR2009(context.getVersion())) {
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
			if (!isUuid(root)) {
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

	private boolean isMR2009(VersionNumber version) {
		return SpecificationVersion.isVersion(version, Hl7BaseVersion.MR2009);
	}

	private String getType(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		String type = context.getType();
		if (isSpecializationTypeAllowed(context, type)) {
			String specializationType = getAttributeValue(element, SPECIALIZATION_TYPE);
			if (II_BUS_AND_VER.equals(type)) {
				type = validateAbstractIiBusAndVer(element, xmlToModelResult, specializationType);
			} else if (II.equals(type)) {
				type = validateAbstractIi(element, xmlToModelResult, type, specializationType);
			}
		}
		return type;
	}

	private String validateAbstractIi(Element element, XmlToModelResult xmlToModelResult, String type, String specializationType) {
		if (specializationType == null) {
			// leave type as II and log error
			xmlToModelResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(SPECIALIZATION_TYPE, element));
		} else if (!concreteIiTypes.contains(specializationType)) {
			// leave type as II and log error
			xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Specialization type " + specializationType + " does not match any of the expected concrete II types. (" + XmlDescriber.describeSingleElement(element) + ")",
						element)
			);
		} else {
			type = specializationType;
		}
		return type;
	}

	private String validateAbstractIiBusAndVer(Element element,	XmlToModelResult xmlToModelResult, String specializationType) {
		String type = specializationType;
		if (!II_BUS.equals(specializationType) && !II_VER.equals(specializationType)) {
			// see if we can get a hint at the intended type by checking for the "use" attribute 
			String use = getAttributeValue(element, "use");
			type = ("VER".equals(use) ? II_VER : II_BUS); // II.BUS allows oids and uuids, so default to it as a last resort
			xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Specialization type must be II.BUS or II.VER; " + type + " will be assumed. Invalid specialization type " + specializationType + " (" + XmlDescriber.describeSingleElement(element) + ")",
						element)
			);
		}
		return type;
	}

	private boolean isSpecializationTypeAllowed(ParseContext context, String type) {
		// CeRx doesn't make use of ST for II; for other releases II is abstract and requires ST, but AB does not follow this requirement
		return !SpecificationVersion.isVersion(context.getVersion(), Hl7BaseVersion.CERX)
				&& !(SpecificationVersion.isExactVersion(SpecificationVersion.V02R02_AB, context.getVersion()) && II.equals(type));
	}

	private void validateAttributeEquals(String type, Element element, XmlToModelResult xmlToModelResult, String attributeName, String attributeValue) {
		if (!element.hasAttribute(attributeName)) {
			xmlToModelResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, 
					MessageFormat.format(
							"Data type " + type + " requires the attribute {0}=\"{1}\" ({2})",
							attributeName, XmlStringEscape.escape(attributeValue), 
							XmlDescriber.describeSingleElement(element)),
					element));
		} else if (!StringUtils.equals(element.getAttribute(attributeName), attributeValue)) {
			xmlToModelResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, 
					MessageFormat.format(
							"Data type " + type + " expected the attribute {0}=\"{1}\" ({2})",
							attributeName, XmlStringEscape.escape(attributeValue), 
							XmlDescriber.describeSingleElement(element)),
					element));
		}
	}


	private void validateRootAsUuid(Element element, String root, XmlToModelResult xmlToModelResult, VersionNumber version) {
		if (StringUtils.isNotBlank(root)) {
			if (!isUuid(root)) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "root '" + root + "' should be a UUID. ("
						+ XmlDescriber.describeSingleElement(element) +")", element));
			}
			validateRootLength(element, root, xmlToModelResult, version);
		}
	}

	private void validateRootLength(Element element, String root, XmlToModelResult xmlToModelResult, VersionNumber version) {
		int maxLength = SpecificationVersion.isVersion(version, Hl7BaseVersion.CERX) ? ROOT_MAX_LENGTH_CERX : ROOT_MAX_LENGTH;
		if (StringUtils.length(root) > maxLength) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "root '" + root + "' exceeds maximum allowed length of " + maxLength + ". ("
					+ XmlDescriber.describeSingleElement(element) +")", element));
		}
	}

	private void validateExtensionLength(Element element, String extension,	XmlToModelResult xmlToModelResult) {
		if (StringUtils.length(extension) > EXTENSION_MAX_LENGTH) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "extension '" + extension + "' exceeds maximum allowed length of " + EXTENSION_MAX_LENGTH + ". ("
					+ XmlDescriber.describeSingleElement(element) +")", element));
		}
	}

	private boolean isUuid(String root) {
		try {
			UUID.fromString(root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void validateRootAsOid(String root, Element element, XmlToModelResult xmlToModelResult, VersionNumber version) {
		if (StringUtils.isNotBlank(root)) {
			if (!isOid(root)) {
				xmlToModelResult.addHl7Error(
						new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
								"The oid, \"" + root + "\" does not appear to be a valid oid", element));
			}
			validateRootLength(element, root, xmlToModelResult, version);
		}
	}

	boolean isOid(String root) {
		if (StringUtils.isBlank(root) || !root.contains(".")) {
			return false;
		} else {
			boolean oid = true;
			while (root.contains(".")) {
				String prefix = StringUtils.substringBefore(root, ".");
				oid &= (StringUtils.isNotBlank(prefix) && StringUtils.isNumeric(prefix)); 
				root = StringUtils.substringAfter(root, ".");
			}
			
			if (StringUtils.isBlank(root)) {
				oid = false;
			} else {
				oid &= StringUtils.isNumeric(root);
			}
			
			return oid;
		}
	}


}
