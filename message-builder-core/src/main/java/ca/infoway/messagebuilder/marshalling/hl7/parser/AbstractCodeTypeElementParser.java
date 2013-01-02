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

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.CdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.CodingStrength;

public abstract class AbstractCodeTypeElementParser extends AbstractSingleElementParser<Code> {

	protected static final String STANDARD_CODE_ATTRIBUTE_NAME = "code";
	protected static final String CODE_SYSTEM_ATTRIBUTE_NAME = "codeSystem";

	private static final CdValidationUtils CD_VALIDATION_UTILS = new CdValidationUtils();
	
    @Override
	public BareANY parse(ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
    	boolean isTranslation = false;
    	return doParse(context, node, xmlToModelResult, isTranslation, STANDARD_CODE_ATTRIBUTE_NAME);
    }

	public BareANY doParse(ParseContext context, Node node, XmlToModelResult xmlToModelResult, boolean isTranslation, String codeAttributeName) {
    	BareANY cd = doCreateDataTypeInstance(context.getType());
        
        populateNullFlavor(cd, context, node, xmlToModelResult); 
        populateValue(cd, context, node, xmlToModelResult, codeAttributeName);
       
        if (!isTranslation) {
        	CD codeAsCd = (CD) cd;
        	String codeAsString = getAttributeValue(node, codeAttributeName);
			CD_VALIDATION_UTILS.validateCodedType(codeAsCd, codeAsString, isCWE(context), isCNE(context), isTranslation, context.getType(), context.getVersion().getBaseVersion(), (Element) node, null, xmlToModelResult);
        }
        
        return cd;
    }
	
	private boolean isCNE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CNE;
	}
	
	private boolean isCWE(ParseContext context) {
		return context.getCodingStrength() == CodingStrength.CWE;
	}

	private void populateNullFlavor(BareANY dataType, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		if (hasValidNullFlavorAttribute(context, node, xmlToModelResult)) {
            NullFlavor nullFlavor = parseNullNode(context, node, xmlToModelResult);
            dataType.setNullFlavor(nullFlavor);
        }
	}

	private void populateValue(BareANY dataType, ParseContext context, Node node, XmlToModelResult xmlToModelResult, String codeAttributeName) {
		Code value = parseNonNullCodeNode(context, codeAttributeName, node, dataType, getReturnType(context), xmlToModelResult);
        ((BareANYImpl) dataType).setBareValue(value);
	}
	
	protected void populateOriginalText(BareANY dataType, ParseContext context, Element element, Type returnType, XmlToModelResult xmlToModelResult) {
		if (hasOriginalText(element)) {
        	((CD) dataType).setOriginalText(getOriginalText(element));
        }
    }

	private String getOriginalText(Element element) {
        NodeList children = element.getChildNodes();
        String result = null;
        int length = children == null ? 0 : children.getLength();
        for (int i = 0; i < length; i++) {
            Node node = children.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
            } else if ("originalText".equals(NodeUtil.getLocalOrTagName(node))) {
                result = NodeUtil.getTextValue(node);
            }
        }
        return result;
    }

    protected final boolean hasOriginalText(Element element) {
    	return StringUtils.isNotBlank(getOriginalText(element));
    }

	protected Hl7Error createInvalidCodeError(Node node, Class<? extends Code> type, String code) {
		String message = "The code, \"" + code + "\", in element <" + NodeUtil.getLocalOrTagName(node) 
			+ "> is not a valid value for domain type \"" 
	    	+ ClassUtils.getShortClassName(type) + "\"";
		return new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, message, (Element) node);
	}

	protected Hl7Error createMissingCodeSystemError(Node node, Class<? extends Code> type, String code) {
		return new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "CodeSystem is mandatory when providing a code value", (Element) node);
	}

	@SuppressWarnings("unchecked")
	protected Class<? extends Code> getReturnTypeAsCodeType(Type type) {
		if (type instanceof Class) {
			return (Class<? extends Code>) type;
		} else if (Generics.isCollectionParameterizedType(type)) {
			// this case should only happen if the original property was inlined
			return (Class<? extends Code>) Generics.getParameterType(type);
		} else {
			throw new IllegalArgumentException("Can't determine the domain type of " + type);
		}
	}
	
    protected abstract Code parseNonNullCodeNode(ParseContext context, String codeAttributeName, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult);
}
