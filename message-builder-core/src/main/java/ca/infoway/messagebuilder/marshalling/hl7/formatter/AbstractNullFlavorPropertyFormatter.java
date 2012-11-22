/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * Otherwise this class hands the formatting off to the formatNonNull method.
 */
public abstract class AbstractNullFlavorPropertyFormatter<V> extends AbstractPropertyFormatter {
	
	protected AbstractNullFlavorPropertyFormatter() {
	}

    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) {

    	String result = "";
    	if (hl7Value!=null) {
    		
    		V value = extractBareValue(hl7Value);
    		
    		if (hl7Value.hasNullFlavor()) {
    			result = createElement(context, createNullFlavorAttributes(hl7Value.getNullFlavor()), indentLevel, true, true);
    			if (context.getConformanceLevel() == MANDATORY) {
    				createMissingMandatoryWarning(context);
    			}
    		} else if (value == null || isEmptyCollection(value)) {
    			if (context.getConformanceLevel() == null || isMandatoryOrPopulated(context)) {
        			if (context.getConformanceLevel() == MANDATORY) {
        				result = createElement(context, EMPTY_ATTRIBUTE_MAP, indentLevel, true, true);
        				createMissingMandatoryWarning(context);
        			} else {
        				result = createElement(context, NULL_FLAVOR_ATTRIBUTES, indentLevel, true, true);
        			}
    			}
    		} else {
    			result = formatNonNullDataType(context, hl7Value, indentLevel);
    		}
    	}
        return result;
    }

	@SuppressWarnings("unchecked")
	protected V extractBareValue(BareANY hl7Value) {
		return (V) hl7Value.getBareValue();
	}

	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
		return formatNonNullValue(context, extractBareValue(dataType), indentLevel);
	}

	abstract String formatNonNullValue(FormatContext context, V t, int indentLevel);
	
	protected boolean isEmptyCollection(V value) {
		if (ListElementUtil.isCollection(value)) {
			return ListElementUtil.isEmpty(value);
		}
		return false;
	}

	protected Map<String, String> createNullFlavorAttributes(NullFlavor nullFlavor) {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(NULL_FLAVOR_ATTRIBUTE_NAME, nullFlavor.getCodeValue());
		return attributes;
	}

	protected void createMissingMandatoryWarning(FormatContext context) {
		context.getModelToXmlResult().addHl7Error(
			new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, context.getElementName() + " is a mandatory field, but no value is specified", context.getPropertyPath())
		);
	}

    protected boolean isMandatoryOrPopulated(FormatContext context) {
    	ConformanceLevel level = context.getConformanceLevel();
		return level == ConformanceLevel.MANDATORY || level == ConformanceLevel.POPULATED;
	}

	protected Map<String, String> toStringMap(String... string) {
		Map<String, String> result = new HashMap<String, String>();
		int length = string == null ? 0 : string.length;
		for (int i = 0; i < length - 1; i += 2) {
			if (string[i] != null && string[i + 1] != null) {
				result.put(string[i], string[i + 1]);
			}
		}
		return result;
	}
}