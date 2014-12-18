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

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

/**
 * CV - Coded Value
 * 
 * Parses an CV element into a CV enum field. The element looks like this:
 * 
 * <element-name code="RECENT" />
 * 
 * According to CeRx: code has a limit of 20 characters. This limit is not 
 * currently enforced by this class.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CV
 * 
 * CeRx states that attribute codeSystem is mandatory if code is specified. However,
 * none of the sample messages do this and the HL7 definition of the message domains
 * do not specify what the codeSystem is for different domains.
 * 
 * There's also an originalText attribute that must be included if code is specified. 
 * Again, the HL7 domain definitions are of little help with that.
 * 
 * Finally: there are two types of attributes that that use this datatype.
 * 
 * CNE (coded no extensibility): code attribute is mandatory.
 * CWE (coded with extensibility): code attribute is required (that is, must be supported
 * but not mandatory. originalText may be specified if code is not entered.
 * 
 */
@DataTypeHandler({"CV", "CD", "CE", "CS"})
public class CvElementParser extends AbstractCodeTypeElementParser {

	private CodeLookupUtils codeLookupUtils = new CodeLookupUtils();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		if ("CD".equals(typeName)) {
			return new CDImpl();
		} else if ("CE".equals(typeName)) {
			return new CEImpl();
		} else if ("CS".equals(typeName)) {
			return new CSImpl();
		}
		return new CVImpl();
	}
	
	@Override
	protected Code parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		throw new UnsupportedOperationException("Nothing should be calling this method.");
	}
	
	@Override
    protected Code parseNonNullCodeNode(ParseContext context, String codeAttributeName, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {

    	Element element = (Element) node;
    	
    	performStandardValidations(context, element, xmlToModelResult);
    	
        String code = getAttributeValue(element, codeAttributeName);
		String codeSystem = getAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME);
		Code actualCode = this.codeLookupUtils.getCorrespondingCode(code, codeSystem, expectedReturnType, element, context.getType(), xmlToModelResult);
		
        populateOriginalText(result, context, (Element) node, xmlToModelResult);
    	addTranslations(context, element, (CD) result, xmlToModelResult);
    	addDisplayName(element, (CD) result);

        // this is not the usual way of doing things; this is to make validation easier
        ((BareANYImpl) result).setBareValue(actualCode);
    	
        return actualCode;
    }

	private void performStandardValidations(ParseContext context, Element element, XmlToModelResult result) {
		StandardDataType type = StandardDataType.getByTypeName(context);
		if (type == StandardDataType.CS) {
			validateUnallowedAttributes(type, element, result, CODE_SYSTEM_ATTRIBUTE_NAME);
		}
		validateUnallowedAttributes(type, element, result, "codeSystemName");
    	validateUnallowedAttributes(type, element, result, "codeSystemVersion");
   		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
	}
    
	private void addDisplayName(Element element, CD result) {
		String displayName = getAttributeValue(element, "displayName");
		result.setDisplayName(displayName);
	}

	private void addTranslations(ParseContext context, Element element, CD result, XmlToModelResult xmlToModelResult) {
		NodeList translations = element.getElementsByTagName("translation");
		for (int i = 0, length=translations.getLength(); i < length; i++) {
			Element translationElement = (Element) translations.item(i);
			// only want direct child node translations
			if (translationElement.getParentNode().isSameNode(element)) {
				CD parsedTranslation = (CD) doParse(context, translationElement, xmlToModelResult, true, STANDARD_CODE_ATTRIBUTE_NAME);
				if (parsedTranslation != null) {
					result.getTranslations().add(parsedTranslation);
				}
			}
		}
	}

}
