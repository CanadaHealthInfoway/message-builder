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

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

/**
 * CS - Coded Simple
 * 
 * Parses an CS element into a CS enum field. The element looks like this:
 * 
 * <element-name code="RECENT"/>
 * 
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 * 
 * CeRx has nothing to say about whether code is mandatory or not.
 * 
 * HL7 implies that variations on this type may use a different name than "code"
 * for the attribute. The use in the controlActProcess is given as an example.
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
@DataTypeHandler("CS")
public class CsElementParser extends AbstractCodeTypeElementParser {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new CSImpl();
	}
	
    @SuppressWarnings("unchecked")
	@Override
    protected Code parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
    	
    	Element element = (Element) node;
        
    	validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "codeSystem");
    	validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "codeSystemName");
    	validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "codeSystemVersion");
    	validateUnallowedAttributes(context.getType(), element, xmlToJavaResult, "displayName");
    	validateUnallowedChildNode(context.getType(), element, xmlToJavaResult, "originalText");
    	validateUnallowedChildNode(context.getType(), element, xmlToJavaResult, "translation");
    	validateUnallowedChildNode(context.getType(), element, xmlToJavaResult, "qualifier");
    	
        Class<? extends Code> returnType = getReturnTypeAsCodeType(expectedReturnType);
        Code result = (Code) parseCodedSimpleValue(getAttributeValue(element, "code"), returnType, element, xmlToJavaResult, null);
        
        return result;
    }

	public Code parseCodedSimpleValue(String code,
			Class<? extends Code> returnType, 
			Element base,
			XmlToModelResult xmlToJavaResult, 
			Attr attr) {
		
		if (StringUtils.isBlank(code)) {
			xmlToJavaResult.addHl7Error(Hl7Error.createEmptyCodeValueError(base, attr));
			return null;
		} else {
			Code result = CodeResolverRegistry.lookup(returnType, code);
	        if (result == null) {
	        	xmlToJavaResult.addHl7Error(createHl7Error(base, returnType, code));
	        }
			return result;
		}
	}

}