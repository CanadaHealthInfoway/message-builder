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

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.SCImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.CodedStringValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * SC - Coded String (CS was already taken for coded simple)
 * 
 * Parses an SC element into a CodedString. The element looks like this:
 * 
 * <element-name>Assistant to the Regional Manager</element-name>
 * <element-name code="RM">Regional Manager</element-name>
 *
 * HL7 defines other optional attributes such as code system version and description.
 * 
 * Currently this class does nothing with codeSystem.
 * 
 * This class is a mix of StElementParser and CvElementParser.
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SC
 * 
 */
@DataTypeHandler("SC")
class ScElementParser extends AbstractSingleElementParser<CodedString<? extends Code>> {

	private CodeLookupUtils codeLookupUtils = new CodeLookupUtils();
	private CodedStringValidationUtils codedStringValidationUtils = new CodedStringValidationUtils(); 
	
	@Override
	protected CodedString<? extends Code> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		
		String value = null;
		int childNodeCount = node.getChildNodes().getLength();
		
		if (childNodeCount == 0) {
			// this is an empty node, return empty string (null should have a null flavor attribute)
            value = EMPTY_STRING;
			
		} else if (childNodeCount == 1) {
			Node childNode = node.getFirstChild();
			if (childNode.getNodeType() != Node.TEXT_NODE) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Expected SC node to have a text node", (Element) node));
			}
            value = childNode.getNodeValue();
			
		} else {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Expected SC node to have at most one child", (Element) node));
		}
        
		String code = getAttributeValue(node, "code");
		String codeSystem = getAttributeValue(node, "codeSystem");
		
		Code lookedUpCode = null;
		if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(codeSystem)) {
			lookedUpCode = this.codeLookupUtils.getCorrespondingCode(code, codeSystem, expectedReturnType, (Element) node, context.getType(), xmlToModelResult);
		}
		
		String displayName = getAttributeValue(node, "displayName");
		String codeSystemName = getAttributeValue(node, "codeSystemName");
		String codeSystemVersion = getAttributeValue(node, "codeSystemVersion");
		
		// TM - this cast may not work properly within .NET
		CodedString<? extends Code> codedString = new CodedString<Code>(value, lookedUpCode, displayName, codeSystemName, codeSystemVersion);
		
		boolean codeProvided = StringUtils.isNotBlank(code);
		boolean codeSystemProvided = StringUtils.isNotBlank(codeSystem);
		this.codedStringValidationUtils.validateCodedString(codedString, codeProvided, codeSystemProvided, (Element) node, null, xmlToModelResult);
		
		return codedString;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new SCImpl();
	}
}
