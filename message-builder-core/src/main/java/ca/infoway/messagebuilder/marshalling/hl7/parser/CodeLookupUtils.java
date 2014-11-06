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
 * Last modified: $LastChangedDate: 2013-12-24 13:37:46 -0400 (Tue, 24 Dec 2013) $
 * Revision:      $LastChangedRevision: 8258 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;

import java.lang.reflect.Type;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

public class CodeLookupUtils {

    public Code getCorrespondingCode(String code, String codeSystem, Type expectedReturnType, 
    		Element element, ParseContext context, XmlToModelResult xmlToModelResult) {
    	return getCorrespondingCode(code, codeSystem, expectedReturnType, element, context, xmlToModelResult, false);
    }
    
    public Code getCorrespondingCode(String code, String codeSystem, Type expectedReturnType, 
    		Element element, ParseContext context, XmlToModelResult xmlToModelResult, boolean relaxCodeSystemCheck) {
    	
    	Class<? extends Code> codeType = getReturnTypeAsCodeType(expectedReturnType);
    	
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
    			if (!relaxCodeSystemCheck) {
    				xmlToModelResult.addHl7Error(createMissingCodeSystemError(element, codeType, code));
    			}
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
		Class<Code> returnType = null;
		if (ANY.class.equals(expectedReturnType)) {
			// if the underlying datatype is an ANY, then we don't have enough information to figure out the domaintype; have to assume generic Code
			returnType = Code.class;
			resolver = new TrivialCodeResolver();
		} else {
			returnType = getReturnTypeAsCodeType(expectedReturnType);
			resolver = CodeResolverRegistry.getResolver(returnType);
		}
		return (StringUtils.isBlank(codeSystem) 
				? resolver.<Code>lookup(returnType, codeValue)
				: resolver.<Code>lookup(returnType, codeValue, codeSystem));
	}
    
	@SuppressWarnings("unchecked")
	private Class<Code> getReturnTypeAsCodeType(Type type) {
		if (type instanceof Class) {
			return (Class<Code>) type;
		} else if (Generics.isCollectionParameterizedType(type)) {
			// this case should only happen if the original property was inlined
			return (Class<Code>) Generics.getParameterType(type);
		} else {
			// this used to throw an exception, but now we can often have no domain types for coded types
			return Code.class;
		}
	}
	
	private Hl7Error createInvalidCodeError(Node node, Class<? extends Code> type, String code) {
		String message = "The code, \"" + code + "\", in element <" + NodeUtil.getLocalOrTagName(node) 
			+ "> is not a valid value for domain type \"" 
	    	+ ClassUtils.getShortClassName(type) + "\"";
		return new Hl7Error(Hl7ErrorCode.VALUE_NOT_IN_CODE_SYSTEM, message, (Element) node);
	}

	private Hl7Error createMissingCodeSystemError(Node node, Class<? extends Code> type, String code) {
		return new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "CodeSystem is mandatory when providing a code value", (Element) node);
	}

    private boolean isInterface(Class<? extends Code> codeType) {
        return codeType.isInterface();
    }

}
