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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.CdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
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
			CD_VALIDATION_UTILS.validateCodedType(codeAsCd, codeAsString, isCWE(context), isCNE(context), isTranslation, context.getType(), context.getVersion(), (Element) node, null, xmlToModelResult);
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
	
	protected void populateOriginalText(BareANY dataType, ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		if (hasOriginalText(element)) {
        	((CD) dataType).setOriginalText(getOriginalText(element));
        }
    }

    protected abstract Code parseNonNullCodeNode(ParseContext context, String codeAttributeName, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult);
}
