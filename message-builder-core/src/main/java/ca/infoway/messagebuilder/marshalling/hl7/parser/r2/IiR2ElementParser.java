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

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.IiValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
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
class IiR2ElementParser extends AbstractSingleElementParser<Identifier> {
	
	private static final IiValidationUtils iiValidationUtils = new IiValidationUtils();
	private final IiConstraintsHandler constraintsHandler = new IiConstraintsHandler();
	
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
		
		Identifier identifier = new Identifier(root, extension);
		identifier.setAssigningAuthorityName(assigningAuthorityName);
		identifier.setDisplayable(displayable);
		
		handleConstraints(context, result, element, identifier);
		
		return identifier;
	}

	private void handleConstraints(ParseContext context, final Hl7Errors errors, final Element element, Identifier identifier) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, element));
			}
		};
		
		this.constraintsHandler.handleConstraints(context.getConstraints(), identifier, logger);
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
