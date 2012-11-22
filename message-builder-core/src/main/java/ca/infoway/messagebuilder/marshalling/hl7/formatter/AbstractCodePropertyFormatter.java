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
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.CdValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Errors;
import ca.infoway.messagebuilder.xml.CodingStrength;

/**
 * CS - Coded Simple
 *
 * Formats a enum into a CS element. The element looks like this:
 *
 * &lt;element-name code="RECENT"/&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * HL7 implies that variations on this type may use a different name than "code" for
 * the attribute. The use in the controlActProcess is given as an example.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
abstract class AbstractCodePropertyFormatter extends AbstractAttributePropertyFormatter<Code> {

	private static final CdValidationUtils CD_VALIDATION_UTILS = new CdValidationUtils();
	
    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) {

    	CD cd = (CD) hl7Value;
    	
    	StringBuilder result = new StringBuilder();
    	if (cd != null) {

    		// don't bother validating if we don't have anything to validate
    		if (cd.hasNullFlavor() || hasValue(cd, context)) {
	    		Hl7Errors errors = context.getModelToXmlResult();
	    		Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
	    		String type = context.getType();
	    		boolean isCne = context.getCodingStrength() == CodingStrength.CNE;
	    		boolean isCwe = context.getCodingStrength() == CodingStrength.CWE;
	    		
	    		CD_VALIDATION_UTILS.validateCodedType(cd, isCwe, isCne, false, type, baseVersion, null, context.getPropertyPath(), errors);
	    		
	    		for (Hl7Error hl7Error : errors.getHl7Errors()) {
	    			System.out.println(hl7Error);
	    		}
    		}
        	
    		Map<String, String> attributes = new HashMap<String, String>();
    		
    		if (cd.hasNullFlavor()) {
    			if (context.getConformanceLevel() == MANDATORY) {
    				logMandatoryError(context);
    			} else {
    				attributes.putAll(createNullFlavorAttributes(hl7Value.getNullFlavor()));
    			}
    		} else if (!hasValue(cd, context)) {
    			if (context.getConformanceLevel() == null || isMandatoryOrPopulated(context)) {
        			if (context.getConformanceLevel() == MANDATORY) {
        				logMandatoryError(context);
        			} else {
        				attributes.putAll(NULL_FLAVOR_ATTRIBUTES);
        			}
    			}
    		}
    		
    		// Codes can have other attributes in map even if has NullFlavor
    		attributes.putAll(getAttributeNameValuePairs(context, cd.getValue(), hl7Value));
    		
    		boolean hasChildContent = hasChildContent(cd, context);
    		if (hasChildContent || (!attributes.isEmpty() || context.getConformanceLevel() == MANDATORY)) {
    			result.append(createElement(context, attributes, indentLevel, !hasChildContent, !hasChildContent));
    			if (hasChildContent) {
    				createChildContent(cd, result);
	    			result.append("</").append(context.getElementName()).append(">");
	    			result.append(LINE_SEPARATOR);
    			}
    		}
    		
    	}
        return result.toString();
    }

	private void logMandatoryError(FormatContext context) {
		String errorMessage = context.getElementName() + " is a mandatory field, but no value is specified";
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, errorMessage, context.getPropertyPath()));
	}

	protected boolean hasChildContent(CD cd, FormatContext context) {
		return hasOriginalText(cd);
	}

	protected void createChildContent(CD cd, StringBuilder result) {
		if (hasOriginalText(cd)) {
			result.append(createElement("originalText", null, 0, false, false));
			result.append(XmlStringEscape.escape(cd.getOriginalText()));
			result.append("</").append("originalText").append(">");
		}
	}
	
    protected boolean hasValue(CD cd, FormatContext context) {
		return cd != null && (cd.getValue() != null || hasChildContent(cd, context));
	}

	private boolean hasOriginalText(CD cd) {
		return !StringUtils.isEmpty(cd.getOriginalText());
	}

    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Code code, BareANY bareAny) {
        Map<String, String> result = new HashMap<String, String>();
        if (code != null) {
            String value = code.getCodeValue();
            if (StringUtils.isNotBlank(value)) {
                result.put("code", value);
            }
        }
        return result;
    }
    
}
