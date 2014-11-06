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
 * Last modified: $LastChangedDate: 2014-02-18 12:27:45 -0500 (Tue, 18 Feb 2014) $
 * Revision:      $LastChangedRevision: 8402 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

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
class IiR2ElementParser extends AbstractSingleElementParser<Identifier> {
	
	private static final IiValidationUtils iiValidationUtils = new IiValidationUtils();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IIImpl();
	}

	@Override
	protected Identifier parseNonNullNode(ParseContext context, Node node, BareANY bareAny, Type returnType, XmlToModelResult result) {
		
		Element element = (Element) node;
		
		String root = getMandatoryAttributeValue(element, "root", result);
		String extension = getAttributeValue(element, "extension");
		String assigningAuthorityName = getAttributeValue(element, "assigningAuthorityName");
		String displayable = getAttributeValue(element, "displayable");
		
		validateII(result, element, root, extension, assigningAuthorityName, displayable);
		
		handleConstraints(context, result, element, root, extension);
		
		Identifier identifier = new Identifier(root, extension);
		identifier.setAssigningAuthorityName(assigningAuthorityName);
		identifier.setDisplayable(displayable);
		
		return identifier;
	}

	private void handleConstraints(ParseContext context, XmlToModelResult result, Element element, String root,	String extension) {
		
		// FIXME - CDA - TM - implementing bare minimum to get choice handling working for now; this will need to be significantly refactored
		
		ConstrainedDatatype constraints = context.getConstraints();

		if (constraints != null) {
			boolean isTemplateId = constraints.getName().endsWith("templateId");
			Hl7ErrorCode errorCode = (isTemplateId ? Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING : Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING);
			boolean fixedConstraintsCorrect = true;
			
			Relationship rootConstraint = constraints.getRelationship("root");
			if (rootConstraint != null && rootConstraint.hasFixedValue() && !StringUtils.equals(root, rootConstraint.getFixedValue())) {
				String msg = MessageFormat.format("Root value constrained to {0} but was {1}", rootConstraint.getFixedValue(), root);
				result.addHl7Error(new Hl7Error(errorCode, Hl7ErrorLevel.WARNING, msg, element));
				fixedConstraintsCorrect = false;
			}
			
			Relationship extensionConstraint = constraints.getRelationship("extension");
			if (extensionConstraint != null && extensionConstraint.hasFixedValue() && !StringUtils.equals(extension, extensionConstraint.getFixedValue())) {
				String msg = MessageFormat.format("Extension value constrained to {0} but was {1}", extensionConstraint.getFixedValue(), extension);
				result.addHl7Error(new Hl7Error(errorCode, Hl7ErrorLevel.WARNING, msg, element));
				fixedConstraintsCorrect = false;
			}
			
			if (isTemplateId && fixedConstraintsCorrect) {
				String msg = MessageFormat.format("Found match for templateId fixed constraint - root: {0} extension: {1}", root, extension);
				result.addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH, Hl7ErrorLevel.INFO, msg, element));
			}
		}
	}

	private void validateII(XmlToModelResult xmlToModelResult, Element element, String root, String extension, String assigningAuthorityName, String displayable) {
		validateRootAsOidOrUuidOrRuid(xmlToModelResult, element, root);
	}

	private void validateRootAsOidOrUuidOrRuid(XmlToModelResult xmlToModelResult, Element element, String root) {
		// if root has not been provided don't bother further validating
		if (StringUtils.isNotBlank(root)) {
			if (!(iiValidationUtils.isOid(root, true) || iiValidationUtils.isUuid(root) || iiValidationUtils.isRuid(root))) {
				recordError(iiValidationUtils.getRootMustBeUuidRuidOidErrorMessage(root), element, xmlToModelResult);
			}
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
