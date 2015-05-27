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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.util.text.Indenter;

/**
 * AD - Address (R2)
 *
 * Represents an Address object as an element:
 *
 * &lt;addr use='WP'&gt;
 *    &lt;houseNumber&gt;1050&lt;/houseNumber&gt;
 *    &lt;direction&gt;W&lt;/direction&gt;
 *    &lt;streetName&gt;Wishard Blvd&lt;/streetName&gt;,
 *    &lt;additionalLocator&gt;RG 5th floor&lt;/additionalLocator&gt;,
 *    &lt;city&gt;Indianapolis&lt;/city&gt;, &lt;state&gt;IN&lt;/state&gt;
 *    &lt;postalCode&gt;46240&lt;/postalCode&gt;
 * &lt;/addr&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 */
@DataTypeHandler("AD")
class AdR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<PostalAddress> {
	
	private final TsR2PropertyFormatter tsFormatter = new TsR2PropertyFormatter();
	
	@Override
	protected
    String formatNonNullValue(FormatContext context, PostalAddress postalAddress, int indentLevel) {

		Map<String, String> attributeMap = new HashMap<String, String>();
		
		String useAttribute = getUseAttribute(context.getType(), postalAddress, context.getVersion().getBaseVersion());
		if (StringUtils.isNotBlank(useAttribute)) {
			attributeMap.put("use", useAttribute);
		}
		
		Boolean isNotOrdered = postalAddress.getIsNotOrdered();
		if (isNotOrdered != null) {
			attributeMap.put("isNotOrdered", isNotOrdered.toString().toLowerCase()); //lowercase for .NET
		}
        
        StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, attributeMap, indentLevel, false, true));
		
		for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
			appendPostalAddressPart(buffer, postalAddressPart, indentLevel + 1);
		}
		
		Map<Date, SetOperator> useablePeriods = postalAddress.getUseablePeriods();
		for (Date date : useablePeriods.keySet()) {
			SetOperator operator = useablePeriods.get(date);
			appendUseablePeriod(buffer, date, operator, indentLevel + 1, context);
		}
		
		buffer.append(createElementClosure(context, indentLevel, true));
		
        return buffer.toString();
    }

    private void appendUseablePeriod(StringBuffer buffer, Date date, SetOperator operator, int indentLevel, FormatContext outerContext) {
    	FormatContext context = new FormatContextImpl("SXCM<TS>", "useablePeriod", outerContext);
    	MbDate mbDate = (date == null ? null : new MbDate(date));
    	TS_R2 tsAny = new TS_R2Impl(mbDate, operator);
		buffer.append(this.tsFormatter.format(context, tsAny, indentLevel));
	}

	private void appendPostalAddressPart(StringBuffer buffer, PostalAddressPart postalAddressPart, int indentLevel) {
        boolean hasPartType = postalAddressPart.getType() != null;
        boolean hasValue = postalAddressPart.getValue() != null && postalAddressPart.getValue().length() > 0;
        
		String tagName = (hasPartType ? postalAddressPart.getType().getValue() : "");
		
        if (hasPartType) {
			if (!hasValue) {
				buffer.append(createElement(tagName, null, indentLevel, true, true));
        	} else {
        		buffer.append(createElement(tagName, getCodeAttributes(postalAddressPart.getCode()), indentLevel, false, false));
        	}
        }

        if (hasValue) {
	    	if (!hasPartType) {
	    		Indenter.indentBuffer(buffer, indentLevel);
	    	}
	        String xmlEscapedValue = XmlStringEscape.escape(postalAddressPart.getValue());
	        if (xmlEscapedValue != null) {
	        	buffer.append(xmlEscapedValue);
	        }
        }
        
        if (hasPartType && hasValue) {
        	buffer.append(createElementClosure(tagName, 0, true));
        } else {
	        buffer.append(LINE_SEPARATOR);
        }
    }

    private Map<String, String> getCodeAttributes(Code code) {
    	// TM: schema indicates that each address part type has a "partType" attribute with the enum code for the part type; no examples ever do this; leaving out for now
		return null;
	}

	private String getUseAttribute(String dataType, PostalAddress value, Hl7BaseVersion baseVersion) {
        String uses = "";
        for (PostalAddressUse postalAddressUse : value.getUses()) {
        	// for R2, all PostalAddressUses are allowed according to the schema
            uses += uses.length() == 0 ? "" : " ";
            uses += postalAddressUse.getCodeValue();
        }
        return uses;
    }
    
}
