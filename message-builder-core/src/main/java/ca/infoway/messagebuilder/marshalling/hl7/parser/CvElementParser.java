/**
 * Copyright 2011 Canada Health Infoway, Inc.
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


import static ca.infoway.messagebuilder.datatype.StandardDataType.CD;
import static ca.infoway.messagebuilder.datatype.StandardDataType.CV;
import static ca.infoway.messagebuilder.util.xml.XmlDescriber.describeSingleElement;

import java.lang.reflect.Type;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

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
@DataTypeHandler({"CV", "CD", "CE"})
class CvElementParser extends AbstractCodeTypeElementParser {

	private static final int MAX_TRANSLATIONS_ALLOWED = 10;
	private static final String CODE_SYSTEM_ATTRIBUTE_NAME = "codeSystem";

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new CVImpl();
	}
	
    @SuppressWarnings("unchecked")
	@Override
    protected Code parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {

    	Element element = (Element) node;
    	
    	performStandardValidations(context, element, xmlToModelResult);
    	
    	if (isCWE(context)) {
    		if (!element.hasAttribute("code") && !hasOriginalText(element)) {
    			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    					MessageFormat.format(
    						"Either \"code\" or \"originalText\" property must be provided ({0}).", 
    						describeSingleElement(element)),
    					element));
    		}
    	} else if (isCNE(context)) {
    		if (hasOriginalText(element) && !hasValidNullFlavorAttribute(context, element, xmlToModelResult)) {
    			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    					MessageFormat.format(
    						"\"OriginalText\" is not allowed for non-null CNE values. ({0}).", 
    						describeSingleElement(element)),
    					element));
    		}
    	}

    	Class<? extends Code> codeType = getReturnTypeAsCodeType(expectedReturnType);
    	
    	Code code = getCorrespondingCode(context, element, codeType, xmlToModelResult);
    	addTranslations(context, element, (CD) result, expectedReturnType, xmlToModelResult);

        return code;
    }

	private void performStandardValidations(ParseContext context, Element element, XmlToModelResult result) {
		validateUnallowedAttributes(context.getType(), element, result, "codeSystemName");
    	validateUnallowedAttributes(context.getType(), element, result, "codeSystemVersion");
    	validateUnallowedAttributes(context.getType(), element, result, "displayName");
    	
    	if (CV.getType().equals(context.getType())) {
    		validateUnallowedChildNode(context.getType(), element, result, "translation");
    		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
    	} else if (CD.getType().equals(context.getType())) {
    		validateUnallowedChildNode(context.getType(), element, result, "qualifier");
    	}
	}
    
    @Override
    protected NullFlavor parseNullNode(ParseContext context, Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	NullFlavor nullFlavor = super.parseNullNode(context, node, xmlToModelResult);
    	
    	if (!hasOriginalText((Element) node) && isOtherNullFlavor(nullFlavor) && isCNE(context)) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    				MessageFormat.format("Data type \"{0}\" with coding strength of \"{1}\" " +
    						"must include <originalText> if nullFlavor is \"OTH\" ({2})",
    						context.getType(), context.getCodingStrength(),
    						XmlDescriber.describeSingleElement((Element)node)),
    						(Element) node));
    	}
    	
        return nullFlavor;
    }

	private boolean isOtherNullFlavor(NullFlavor nullFlavor) {
		return ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER == nullFlavor;
	}

    private boolean isInterface(Class<? extends Code> codeType) {
        return codeType.isInterface();
    }

    private Code getCorrespondingCode(ParseContext context, Element element, 
    		Class<? extends Code> codeType, XmlToModelResult xmlToModelResult) 
    		throws XmlToModelTransformationException {
    	
        String code = isMandatory(context) && isCNE(context)
        		? getMandatoryAttributeValue(element, "code", xmlToModelResult) 
        		: getAttributeValue(element, "code");
		String codeSystem = (isMandatory(context) && isCNE(context)) || StringUtils.isNotBlank(code)
        		? getMandatoryAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME, xmlToModelResult) 
				: getAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME);
        		
		Code result = getCode(codeType, code, codeSystem);

        // if a code is specified and there is no matching enum value for it,
		// something is seriously wrong
        if (StringUtils.isNotBlank(code) && result == null) {
        	xmlToModelResult.addHl7Error(createHl7Error(element, codeType, code));
        }

        // the following code will preserve the codeSystem even if the actual code can not be found
        if (result == null && !StringUtils.isEmpty(codeSystem) && isInterface(codeType)) {
			result = FullCodeWrapper.wrap(codeType, null, codeSystem);
		}
		
    	return result;
    }

	private Code getCode(Type expectedReturnType, String codeValue, String codeSystem) {
		Class<? extends Code> returnType = getReturnTypeAsCodeType(expectedReturnType);
		CodeResolver resolver = CodeResolverRegistry.getResolver(returnType);
		return resolver.<Code>lookup(returnType, codeValue, codeSystem);
	}
    
	private boolean isCNE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CNE;
	}
	
	private boolean isCWE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CWE;
	}

	private boolean isMandatory(ParseContext context) {
		return context.getConformance() == ConformanceLevel.MANDATORY;
	}

	private void addTranslations(ParseContext context, Element element, CD result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		NodeList translations = element.getElementsByTagName("translation");
		int translationCount = 0;
		for (int i = 0, length=translations.getLength(); i < length; i++) {
			Element translationElement = (Element) translations.item(i);
			// only want direct child node translations
			if (translationElement.getParentNode().isSameNode(element)) {
				translationCount++;
				validateTranslation(context, (Element) translationElement, xmlToModelResult);
		        Code translation = extractCodeFromTranslation(translationElement, expectedReturnType, xmlToModelResult);
				if (translation != null) {
					CD hl7Translation = new CVImpl();
					hl7Translation.setValue(translation);
					hl7Translation.setDataType(result.getDataType());
					result.getTranslations().add(hl7Translation);
				}
			}
		}
		if (translationCount > MAX_TRANSLATIONS_ALLOWED) {
    		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
    				MessageFormat.format("A maximum of {0} translations are allowed for any given code.",
    						MAX_TRANSLATIONS_ALLOWED),
    						element));
		}
	}

	private Code extractCodeFromTranslation(Element element, Type expectedReturnType,
			XmlToModelResult xmlToModelResult) {
		String code = getMandatoryAttributeValue(element, "code", xmlToModelResult); 
		String codeSystem = getMandatoryAttributeValue(element, CODE_SYSTEM_ATTRIBUTE_NAME, xmlToModelResult); 
		
		Class<? extends Code> codeType = getReturnTypeAsCodeType(expectedReturnType);

		Code translation = getCode(codeType, code, codeSystem);

		// if a code is specified and there is no matching enum value for it, something is seriously wrong
		if (StringUtils.isNotBlank(code) && translation == null) {
			xmlToModelResult.addHl7Error(createHl7Error((Node) element, codeType, code));
		}
		return translation;
	}

	private void validateTranslation(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		performStandardValidations(context, element, xmlToModelResult);
    	validateUnallowedAttributes(context.getType(), element, xmlToModelResult, "nullFlavor");
    	validateUnallowedChildNode(context.getType(), element, xmlToModelResult, "originalText");
    	validateUnallowedChildNode(context.getType(), element, xmlToModelResult, "translation");
	}

}
