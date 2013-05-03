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


import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

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
 * Currently this class does nothing with codeSystem or originalText. Therefore it is
 * identical to the CS class.
 */
@DataTypeHandler({"CV", "CD", "CE", "CS"})
public class CvElementParser extends AbstractCodeTypeElementParser {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
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
    	
    	Class<? extends Code> codeType = getReturnTypeAsCodeType(expectedReturnType);
    	
    	Code code = getCorrespondingCode(context, element, codeType, xmlToModelResult, codeAttributeName);
        populateOriginalText(result, context, (Element) node, xmlToModelResult);
    	addTranslations(context, element, (CD) result, xmlToModelResult);
    	addDisplayName(element, (CD) result);

        // this is not the usual way of doing things; this is to make validation easier
        ((BareANYImpl) result).setBareValue(code);
    	
        return code;
    }

	private void performStandardValidations(ParseContext context, Element element, XmlToModelResult result) {
		if (StandardDataType.CS.getType().equals(context.getType())) {
			validateUnallowedAttributes(context.getType(), element, result, CODE_SYSTEM_ATTRIBUTE_NAME);
		}
		validateUnallowedAttributes(context.getType(), element, result, "codeSystemName");
    	validateUnallowedAttributes(context.getType(), element, result, "codeSystemVersion");
   		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
	}
    
    private boolean isInterface(Class<? extends Code> codeType) {
        return codeType.isInterface();
    }

    private Code getCorrespondingCode(ParseContext context, Element element, 
    		Class<? extends Code> codeType, XmlToModelResult xmlToModelResult, String codeAttributeName) {
    	
        String code = getAttributeValue(element, codeAttributeName);
		String codeSystem = getAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME);
        		
    	if (StandardDataType.CS.getType().equals(context.getType())) {
    		if (codeSystem != null) {
    			xmlToModelResult.addHl7Error(
    					new Hl7Error(
    							DATA_TYPE_ERROR, 
    							"CS should not include the 'codeSystem' property. (" + XmlDescriber.describeSingleElement(element) + ")", 
    							element));
    		}
    	} else {
    		if (StringUtils.isNotBlank(code) && StringUtils.isBlank(codeSystem)) {
            	xmlToModelResult.addHl7Error(createMissingCodeSystemError(element, codeType, code));
    		}
    	}
    	
		Code result = getCode(codeType, code, codeSystem);

        // if a code is specified and there is no matching enum value for it,
		// something is seriously wrong
        if (StringUtils.isNotBlank(code) && result == null) {
        	xmlToModelResult.addHl7Error(createInvalidCodeError(element, codeType, code));
        }

        // the following code will preserve the codeSystem even if the actual code can not be found
        if (result == null && !StringUtils.isEmpty(codeSystem) && isInterface(codeType)) {
			result = FullCodeWrapper.wrap(codeType, null, codeSystem);
		}
		
    	return result;
    }

	private Code getCode(Type expectedReturnType, String codeValue, String codeSystem) {
		CodeResolver resolver = null;
		Class<? extends Code> returnType = null;
		if (ANY.class.equals(expectedReturnType)) {
			// if the underlying datatype is an ANY, then we don't have enough information to figure out the domaintype; have to assume generic Code
			returnType = Code.class;
			resolver = new TrivialCodeResolver();
		} else {
			returnType = getReturnTypeAsCodeType(expectedReturnType);
			resolver = CodeResolverRegistry.getResolver(returnType);
		}
		return resolver.<Code>lookup(returnType, codeValue, codeSystem);
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
