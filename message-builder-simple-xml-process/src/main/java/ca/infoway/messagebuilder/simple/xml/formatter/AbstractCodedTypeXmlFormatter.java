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

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.parser.FullCodeWrapper;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public abstract class AbstractCodedTypeXmlFormatter extends AbstractSimpleXmlFormatter {
	
	private final TypeSupplier<CD> cdSupplier;

	protected AbstractCodedTypeXmlFormatter(FormatterConfiguration configuration, TypeSupplier<CD> cdSupplier) {
		super(configuration);
		this.cdSupplier = cdSupplier;
	}
	
	public CD format(FormatContext formatContext, Element value) throws FormatterException {
		CD cd = null;
		
		cd = populateCode(formatContext, value, cd);
		cd = populateOriginalText(formatContext, value, cd);
		
		return cd;
	}

	@SuppressWarnings("unchecked")
	private CD populateCode(FormatContext formatContext, Element value, CD cd) throws FormatterException {
		Class<Code> codeClass = (Class<Code>) formatContext.getExpectedReturnType();
		Code code = parseCode(formatContext, codeClass, value);
		if (code != null) {
			cd = this.cdSupplier.get();
			cd.setValue(code);
		}
		return cd;
	}
	
	CD populateOriginalText(FormatContext formatContext, Element value, CD cd) throws FormatterException {
		if (hasOriginalText(value)) {
        	if (formatContext.matchesType(StandardDataType.CD) || formatContext.matchesType(StandardDataType.CV)) {
    			if (cd == null) {
    				cd = cdSupplier.get();
    			}
    			cd.setOriginalText(getOriginalText(value));
        	} else {
        		processError(formatContext, "Original text only allowed on CD and CV types", value);
        	}
		}
		return cd;
	}
	
    protected Code parseCode(FormatContext formatContext, Class<? extends Code> codeType, Element value) throws FormatterException {
		String code = getCodeValue(value);
		String codeSystem = value.getAttribute("codeSystem");
        		
		Code result = getCode(formatContext, codeType, code, codeSystem);
		
        // if a code is specified and there is no matching enum value for it,
		// something is seriously wrong
        if (StringUtils.isNotBlank(code) && result == null) {
        	processError(formatContext, "Could not find code [" + code + "]", value);
        }
        
		if (result == null && !StringUtils.isBlank(codeSystem)) {
			result = FullCodeWrapper.wrap(codeType, null, codeSystem);
		}
		
    	return result;
    }

	static String getCodeValue(Element value) {
		return value.getAttribute("code");
	}

	private Code getCode(FormatContext formatContext, Class<? extends Code> returnType, String codeValue, String codeSystem) {
		Code result = null;
		if (StringUtils.isNotBlank(codeValue)) {
			CodeResolver resolver = CodeResolverRegistry.getResolver(returnType);
			result = resolver.lookup(returnType, codeValue, codeSystem);
		}
		return result;
	}

	final boolean hasOriginalText(Element element) {
		return StringUtils.isNotBlank(getOriginalText(element));
	}

	String getOriginalText(Element element) {
		NodeList nodeList = element.getElementsByTagName("originalText");
		if (nodeList.getLength() >= 1 && nodeList.item(0).getParentNode() == element) {
			return nodeList.item(0).getTextContent();
		}
		return null;
	}

}
