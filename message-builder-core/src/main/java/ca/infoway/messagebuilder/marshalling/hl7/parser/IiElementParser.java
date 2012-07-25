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

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IIImpl();
	}

	@Override
	protected Identifier parseNonNullNode(ParseContext context, Node node, BareANY result, Type returnType, XmlToModelResult xmlToModelResult)
			throws XmlToModelTransformationException {
		
		Element element = (Element) node;
		
		String root = getMandatoryAttributeValue(element, "root", xmlToModelResult);
		String extension = getAttributeValue(element, "extension");
		String type = getType(context, element, xmlToModelResult);
		
		// type might have resolved to something different if this II.x is abstract (II, II_BUS_AND_VER), so set it again
		setDataType(type, result);
		
		if (StringUtils.isBlank(root)) {
			// skip it... already handled
		} else if (II_TOKEN.equals(type)) {
			validateRootAsUuid(element, root, xmlToModelResult);
			validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
			validateUnallowedAttributes(type, element, xmlToModelResult, "use");
			validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		} else if (II_BUS.equals(type)) {
			if (!isUuid(root)) {
				validateRootAsOid(root, element, xmlToModelResult);
			} else {
				validateRootAsUuid(element, root, xmlToModelResult);
				validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
			}
			validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
			validateAttributeEquals(type, element, xmlToModelResult, "use", "BUS");
		} else if (II_OID.equals(type)) {
			validateRootAsOid(root, element, xmlToModelResult);
			validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
			validateUnallowedAttributes(type, element, xmlToModelResult, "use");
			validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
		} else if (II_PUBLIC.equals(type)) {
			validateRootAsOid(root, element, xmlToModelResult);
			validateAttributeEquals(type, element, xmlToModelResult, "displayable", "true");
			// Redmine 11293 - TM - must have use=BUS, but not for MR2007 (use is not permitted in this case)
			if (isMR2009(context.getVersion())) {
				validateAttributeEquals(type, element, xmlToModelResult, "use", "BUS");
			} else {
				validateUnallowedAttributes(type, element, xmlToModelResult, "use");
			}
		} else if (II_VER.equals(type)) {
			validateRootAsUuid(element, root, xmlToModelResult);
			validateUnallowedAttributes(type, element, xmlToModelResult, "extension");
			validateUnallowedAttributes(type, element, xmlToModelResult, "displayable");
			validateAttributeEquals(type, element, xmlToModelResult, "use", "VER");
		}
		validateUnallowedAttributes(type, element, xmlToModelResult, "assigningAuthorityName");
		return new Identifier(root, extension);
	}

	private boolean isMR2009(VersionNumber version) {
		return SpecificationVersion.isVersion(version, Hl7BaseVersion.MR2009);
	}

	private String getType(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		String type = context.getType();
		if (isSpecializationTypeAllowed(context, type)) {
			if (II_BUS_AND_VER.equals(type) || II.equals(type)) {   //   || II.equals(type)   ???? if plain II, then probably CeRx... (don't do extra validations)
				String specializationType = getAttributeValue(element, SPECIALIZATION_TYPE);
				if (specializationType == null) {
					xmlToModelResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(SPECIALIZATION_TYPE, element));
				} else if (II_BUS_AND_VER.equals(type) && !II_BUS.equals(specializationType) && !II_VER.equals(specializationType)) {
				    xmlToModelResult.addHl7Error(
				    		new Hl7Error(
				    				Hl7ErrorCode.DATA_TYPE_ERROR,
				    				"Specialization type must be II.BUS or II.VER. Invalid specialization type " + specializationType + " (" + XmlDescriber.describeSingleElement(element) + ")",
				    				element)
				    );
				} else {
					type = specializationType;
				}
			}
		}
		return type;
	}

	private boolean isSpecializationTypeAllowed(ParseContext context, String type) {
		return !SpecificationVersion.isVersion(context.getVersion(), Hl7BaseVersion.CERX)
				&& !(SpecificationVersion.isExactVersion(SpecificationVersion.V02R02_AB, context.getVersion()) && II.equals(type));
	}

	private void validateAttributeEquals(String type, Element element,
			XmlToModelResult xmlToModelResult, String attributeName, String attributeValue) {
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


	private void validateRootAsUuid(Element element, String root, XmlToModelResult xmlToModelResult) {
		if (!isUuid(root)) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "root '" + root + "' should be a UUID. ("
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

	private void validateRootAsOid(String root, Element element, XmlToModelResult xmlToModelResult) {
		if (!isOid(root)) {
			xmlToModelResult.addHl7Error(
					new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							"The oid, \"" + root + "\" does not appear to be a valid oid", element));
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
