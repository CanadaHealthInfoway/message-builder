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
 * Last modified: $LastChangedDate: 2013-09-06 10:36:09 -0400 (Fri, 06 Sep 2013) $
 * Revision:      $LastChangedRevision: 7861 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.TS_R2;
import ca.infoway.messagebuilder.datatype.impl.TS_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

/**
 * Represents a TEL String as an element:
 *
 * &lt;element-name use="H WP" value="mailto://me@me.com"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 *
 */
@DataTypeHandler("TEL")
public class TelR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<TelecommunicationAddress> {

//	private static final TelValidationUtils TEL_VALIDATION_UTILS = new TelValidationUtils();
	
	@Override
	protected String formatNonNullValue(FormatContext context, TelecommunicationAddress value, int indentLevel) {
		
		// any validation that can be done for R2??
		// scheme/address cannot be null
		
		boolean hasUseablePeriods = !value.getUseablePeriods().isEmpty();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, getAttributesMap(value, context.getVersion()), indentLevel, !hasUseablePeriods, true));
		if (hasUseablePeriods) {
			appendUseablePeriods(value, buffer, indentLevel + 1, context);
			buffer.append(createElementClosure(context, indentLevel, true));
		}
		return buffer.toString();
	}
	
	private Map<String, String> getAttributesMap(TelecommunicationAddress address, VersionNumber version) {
		Map<String, String> attributes = new HashMap<String, String>();
		
		// address value
		attributes.put("value", address.toString());
		
		// address uses
        if (!address.getAddressUses().isEmpty()) {
    		StringBuffer useValue = new StringBuffer();
            boolean isFirst = true;
            for (TelecommunicationAddressUse addressUse : address.getAddressUses()) {
                if (!isFirst) {
                    useValue.append(XmlRenderingUtils.SPACE);
                }
                useValue.append(addressUse.getCodeValue());
                isFirst = false;
            }
            attributes.put("use", useValue.toString());
        }

        return attributes;
	}

	
    private void appendUseablePeriods(TelecommunicationAddress value, StringBuffer buffer, int indentLevel, FormatContext context) {
    	FormatContextImpl tsFormatContext = new FormatContextImpl("SXCM<TS>", context);
    	Map<Date, SetOperator> useablePeriods = value.getUseablePeriods();
    	for (Date period : useablePeriods.keySet()) {
    		MbDate mbDate = new MbDate(period);
			TS_R2 ts = new TS_R2Impl(mbDate, useablePeriods.get(period));
			Map<String, String> attributes = new TsR2PropertyFormatter().getAttributeNameValuePairs(tsFormatContext, mbDate, ts);
			buffer.append(createElement("useablePeriod", attributes, indentLevel, true, true));
		}
	}

}
