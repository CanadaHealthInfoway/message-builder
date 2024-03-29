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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;
import ca.infoway.messagebuilder.xml.util.XmlWarningRenderer;

public abstract class AbstractPropertyFormatter implements PropertyFormatter {

	protected static final String SPECIALIZATION_TYPE = "specializationType";
	protected static final String XSI_TYPE = "xsi:type";

	private static final XmlWarningRenderer warningRenderer = new XmlWarningRenderer();
	
    static final Map<String, String> EMPTY_ATTRIBUTE_MAP = new HashMap<String, String>(); 

    public static final String NULL_FLAVOR_ATTRIBUTE_NAME = "nullFlavor";
    public static final String NULL_FLAVOR_NO_INFORMATION = NullFlavor.NO_INFORMATION.getCodeValue();
    protected static final Map<String, String> NULL_FLAVOR_ATTRIBUTES = new HashMap<String, String>();
    static {
        NULL_FLAVOR_ATTRIBUTES.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);
    }
    
	protected String createWarning(int indentLevel, String text, String logLevel) {
		return warningRenderer.createWarning(indentLevel, text, logLevel);
	}

    public String format(FormatContext formatContext, BareANY dataType) {
        return format(formatContext, dataType, 0);
    }
    public abstract String format(FormatContext formatContext, BareANY dataType, int indentLevel);

    protected String createElement(FormatContext context, Map<String, String> attributes, int indentLevel, boolean close, boolean lineBreak) {
    	// RM18070 - include (if required) ST/XT attributes for PQ.LAB as well (which can contain meta data even with a NF)
    	if (!isNullFlavor(attributes) || isCodedType(context) || isPqLab(context)) {
    		if (attributes == null) {
    			attributes = new HashMap<String, String>();
    		}
    		Map<String, String> extraAttributes = createSpecializationTypeAttibutesIfNecessary(context);
    		// bug 13884 - csharp throws exception if put duplicate key in map; this was occurring when using putAll() instead of below code
    		for (String key : extraAttributes.keySet()) {
    			// TM - decided to not overwrite already existing attributes (as these would have been explicitly set)
    			if (!attributes.containsKey(key) || StringUtils.isBlank(attributes.get(key))) {
    				//attributes.remove(key);
    				attributes.put(key, extraAttributes.get(key));
    			}
			}
    	}
    	return createElement(context.getElementName(), attributes, indentLevel, close, lineBreak); 
    }
    
	private boolean isPqLab(FormatContext context) {
		if (context != null && context.getType() != null) {
			return StandardDataType.PQ_LAB.getType().equals(context.getType());
		}
		return false;
	}

	private boolean isCodedType(FormatContext context) {
		if (context != null && context.getType() != null) {
			StandardDataType dataType = StandardDataType.getByTypeName(context);
			if (dataType != null) {
				return dataType.isCoded();
			}
		}
		return false;
	}

	protected String createElement(String name, Map<String, String> attributes, int indentLevel, boolean close, boolean lineBreak) {
		return XmlRenderingUtils.createStartElement(name, attributes, indentLevel, close, lineBreak);
	}
	protected String createElementClosure(FormatContext context, int indentLevel, boolean lineBreak) {
    	return createElementClosure(context.getElementName(), indentLevel, lineBreak); 
    }
	protected String createElementClosure(String name, int indentLevel, boolean lineBreak) {
    	return XmlRenderingUtils.createEndElement(name, indentLevel, lineBreak); 
    }
	
	protected Map<String, String> createSpecializationTypeAttibutesIfNecessary(FormatContext context) {
		Map<String, String> attributes = new HashMap<String, String>();
		if (context.isSpecializationType()) {
    		String typeAsString = context.getType();
			addSpecializationType(attributes, typeAsString);
    	}
		return attributes;
	}

	protected void addSpecializationType(Map<String, String> attributes, String typeAsString) {
		StandardDataType type = StandardDataType.getByTypeName(typeAsString);
		
		String xsiType = xmlify(type.getTypeName().getUnspecializedName());
		String specializationType = xmlify(type.getType());
		
		attributes.put(XSI_TYPE, xsiType);
		if (!StringUtils.equals(xsiType, specializationType)) {
			attributes.put(SPECIALIZATION_TYPE, specializationType);
		}
	}
	
	protected boolean isNullFlavor(Map<String, String> attributes) {
		return attributes != null && attributes.containsKey(NULL_FLAVOR_ATTRIBUTE_NAME);
	}		
	
	public String xmlify(String type) {
		String typeForXml = type.replaceAll("\\>", "");
		typeForXml = typeForXml.replaceAll("\\<", "_");
		typeForXml = typeForXml.replaceAll("\\,", "_");
		return typeForXml;
	}

}
