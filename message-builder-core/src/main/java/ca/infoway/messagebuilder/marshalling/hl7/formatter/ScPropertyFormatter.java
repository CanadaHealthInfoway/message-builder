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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.CodedStringValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * SC - Coded String (CS was already taken for coded simple)
 *
 * Represents an SC object as an element. There is also an optional code attribute.
 *
 * &lt;element-name&gt;Assistant to the Regional Manager&lt;/element-name&gt;
 * &lt;element-name code="RM" codeSystem="XX"&gt;Regional Manager&lt;/element-name&gt;
 *
 * HL7 defines other optional attributes such as code system version and description.
 *
 * This class is a mix of StPropertyFormatter and CvPropertyFormatter.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SC
 */
@DataTypeHandler("SC")
class ScPropertyFormatter extends AbstractNullFlavorPropertyFormatter<CodedString<? extends Code>> {

	private CodedStringValidationUtils codedStringValidationUtils = new CodedStringValidationUtils();
	
	@Override
	protected
	String formatNonNullValue(FormatContext context, CodedString<? extends Code> value, int indentLevel) {
		
		boolean codeProvided = value.getCode() == null ? false : StringUtils.isNotBlank(value.getCode().getCodeValue());
		boolean codeSystemProvided = value.getCode() == null ? false : StringUtils.isNotBlank(value.getCode().getCodeSystem());
		this.codedStringValidationUtils.validateCodedString(value, codeProvided, codeSystemProvided, null, context.getPropertyPath(), context.getModelToXmlResult());
		
        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, getAttributeNameValuePairs(value), indentLevel, false, false));
        buffer.append(XmlStringEscape.escape(value.getValue()));
        buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
	}
    
    private Map<String, String> getAttributeNameValuePairs(CodedString<? extends Code> value) {
        Map<String, String> result = new HashMap<String, String>();
        Code code = value.getCode();
        if (code != null) {
            String codeValue = code.getCodeValue();
            if (codeValue == null) {
                codeValue = code.toString();
            }
            result.put("code", codeValue);

            String codeSystem = code.getCodeSystem();
            if(StringUtils.isNotEmpty(codeSystem)) {
                result.put("codeSystem", codeSystem);
            }
            
            if(StringUtils.isNotEmpty(value.getDisplayName())) {
            	result.put("displayName", value.getDisplayName());
            }
            if(StringUtils.isNotEmpty(value.getCodeSystemName())) {
                result.put("codeSystemName", value.getCodeSystemName());
            }
            if(StringUtils.isNotEmpty(value.getCodeSystemVersion())) {
                result.put("codeSystemVersion", value.getCodeSystemVersion());
            }
        }
        return result;
    }

}
