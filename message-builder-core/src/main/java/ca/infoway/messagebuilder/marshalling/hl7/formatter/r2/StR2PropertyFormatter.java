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
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * ST - String (R2 datatype variant)
 *
 * Represents an ST object as an element:
 *
 * &lt;element-name&gt;This is some text&lt;/element-name&gt;
 *
 * HL7 defines other attributes, but notes that they are optional since
 * the values are self-evident (representation="TXT" mediaType="text/plain").
 * The CeRx documentation makes no mention of these attributes.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ST
 *
 * this should be abstracted if more single-level elements with text nodes are needed.
 */
@DataTypeHandler("ST")
class StR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<String> {

	@Override
	protected String formatNonNullValue(FormatContext context, String value, int indentLevel) {
		throw new UnsupportedOperationException("Different formatNonNull handler used for ST");
	}

	@Override
	protected String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
        StringBuffer buffer = new StringBuffer();
        
    	Map<String, String> attributes = new HashMap<String, String>();
    	attributes.put("representation", "TXT");
    	attributes.put("mediaType", "text/plain");
    	
		String language = getLanguage(dataType);
    	boolean hasLang = (language != null);
    	validate(buffer, indentLevel, context, hasLang, dataType);
		if (hasLang && StringUtils.isNotBlank(language)) {
			// no details on how to validate language
			attributes.put("language", language);
    	}
        buffer.append(createElement(context, attributes, indentLevel, false, false));
		buffer.append(createText(dataType));
        buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
	}

	private String createText(BareANY dataType) {
        String textValue = getStringValue(dataType);
        
        String results = null;
        if (dataType instanceof ANYMetaData && ((ANYMetaData) dataType).isCdata()) {
        	// RM18719 - do not escape text, but wrap with a CDATA block
        	results = "<![CDATA[" + textValue + "]]>";
        } else {
        	results = XmlStringEscape.escape(textValue);
        }
		return results;
	}

	private String getStringValue(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
        return bareValue == null ? "" : bareValue.toString();
	}

	private String getLanguage(BareANY dataType) {
		 // could be an ANY; need to be careful extracting metadata 
		return ((ANYMetaData) dataType).getLanguage();
	}

	private void validate(StringBuffer buffer, int indentLevel, FormatContext context, boolean hasLang, BareANY dataType) {
		// ST has min length of 1 according to schema, and cannot have both a NF and text
		// no details on what language strings are allowed
		
		ModelToXmlResult result = context.getModelToXmlResult();
		
		if (dataType.hasNullFlavor()) {
			if (dataType.getBareValue() != null) {
				Hl7Error hl7Error = new Hl7Error(
	    				Hl7ErrorCode.DATA_TYPE_ERROR, 
	    				"ST cannot have both a nullFlavour and a text value.",
	    				context.getPropertyPath());
				result.addHl7Error(hl7Error);
			}
		} else if (StringUtils.isBlank(getStringValue(dataType))) {
			Hl7Error hl7Error = new Hl7Error(
    				Hl7ErrorCode.DATA_TYPE_ERROR, 
    				"ST text value must be provided.",
    				context.getPropertyPath());
			result.addHl7Error(hl7Error);
		}
		if (hasLang && StringUtils.isBlank(getLanguage(dataType))) {
			Hl7Error hl7Error = new Hl7Error(
    				Hl7ErrorCode.DATA_TYPE_ERROR, 
    				"ST language attribute, if provided, can not be blank.",
    				context.getPropertyPath());
			result.addHl7Error(hl7Error);
		}
		
	}
	
}
