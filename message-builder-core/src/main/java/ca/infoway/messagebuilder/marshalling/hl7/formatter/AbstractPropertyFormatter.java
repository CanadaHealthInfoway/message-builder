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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

public abstract class AbstractPropertyFormatter implements PropertyFormatter {

    static final Map<String, String> EMPTY_ATTRIBUTE_MAP = new HashMap<String, String>(); 

    static final String NULL_FLAVOR_ATTRIBUTE_NAME = "nullFlavor";
    static final String NULL_FLAVOR_NO_INFORMATION = "NI";
    static final Map<String, String> NULL_FLAVOR_ATTRIBUTES = new HashMap<String, String>();
    static {
        NULL_FLAVOR_ATTRIBUTES.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);
    }
    
    public String format(FormatContext formatContext, BareANY dataType) throws ModelToXmlTransformationException {
        return format(formatContext, dataType, 0);
    }
    public abstract String format(FormatContext formatContext, BareANY dataType, int indentLevel) throws ModelToXmlTransformationException;

    protected String createElement(FormatContext context, Map<String, String> attributes, int indentLevel, boolean close, boolean lineBreak) {
    	if (!isNullFlavor(attributes)) {
    		if (attributes == null) {
    			attributes = new HashMap<String, String>();
    		}
    		Map<String, String> extraAttributes = createSpecializationTypeAttibutesIfNecessary(context);
    		// bug 13884 - csharp throws exception if put duplicate key in map; this was occurring when using putAll() instead of below code
    		for (String key : extraAttributes.keySet()) {
				attributes.remove(key);
				attributes.put(key, extraAttributes.get(key));
			}
    	}
    	return createElement(context.getElementName(), attributes, indentLevel, close, lineBreak); 
    }
    
	protected String createElement(String name, Map<String, String> attributes, int indentLevel, boolean close, boolean lineBreak) {
		return XmlRenderingUtils.createStartElement(name, attributes, indentLevel, close, lineBreak);
	}
	protected String createElementClosure(FormatContext context, int indentLevel, boolean lineBreak) {
    	return XmlRenderingUtils.createEndElement(context.getElementName(), indentLevel, lineBreak); 
    }
	protected void validateContext(FormatContext context) {
	}
	
	protected Map<String, String> createSpecializationTypeAttibutesIfNecessary(FormatContext context) {
		Map<String, String> attributes = new HashMap<String, String>();
		if (context.isSpecializationType()) {
    		StandardDataType type = StandardDataType.getByTypeName(context.getType());
			attributes.put("xsi:type", xmlify(type.getTypeName().getUnspecializedName()));
    		attributes.put("specializationType", xmlify(type.getType()));
    	}
		return attributes;
	}
	
	protected boolean isNullFlavor(Map<String, String> attributes) {
		return attributes != null && attributes.containsKey(NULL_FLAVOR_ATTRIBUTE_NAME);
	}		
	
	public String xmlify(String type) {
		String typeForXml = type.replaceAll("\\>", "");
		typeForXml = typeForXml.replaceAll("\\<", "_");
		return typeForXml;
	}

}
