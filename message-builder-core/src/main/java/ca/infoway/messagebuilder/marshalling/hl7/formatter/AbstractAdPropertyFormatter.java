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
import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.AdValidationUtils;

/**
 * AD - Address
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
public abstract class AbstractAdPropertyFormatter extends AbstractNullFlavorPropertyFormatter<PostalAddress> {

	protected static final AdValidationUtils AD_VALIDATION_UTILS = new AdValidationUtils();
	
	@Override
	protected
    String formatNonNullValue(FormatContext context, PostalAddress postalAddress, int indentLevel) {
        StringBuffer buffer = new StringBuffer();
        Map<String, String> useAttributeMap = getUseAttributeMap(context.getType(), postalAddress, context.getVersion().getBaseVersion());
		buffer.append(createElement(context, useAttributeMap, indentLevel, false, false));
		for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
			if (AD_VALIDATION_UTILS.isAllowableAddressPart(postalAddressPart.getType(), context.getType())) {
				appendPostalAddressPart(buffer, postalAddressPart);
			}
		}
		buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
    }

    private void appendPostalAddressPart(StringBuffer buffer, PostalAddressPart postalAddressPart) {
        String openTag = "";
        String closeTag = "";

        boolean isDelimiter = isDelimiter(postalAddressPart);
        if (postalAddressPart.getType() != null) {
			if (isDelimiter) {
        		openTag = "<" + postalAddressPart.getType().getValue() + "/>";
        	} else {
        		openTag = "<" + postalAddressPart.getType().getValue() + formatCode(postalAddressPart.getCode()) + ">";
        		closeTag = "</" + postalAddressPart.getType().getValue() + ">";
        	}
        }

        buffer.append(openTag);
        if (!isDelimiter) {
	        String xmlEscapedValue = XmlStringEscape.escape(postalAddressPart.getValue());
	        if (xmlEscapedValue != null) {
	        	buffer.append(xmlEscapedValue);
	        }
        }
        buffer.append(closeTag);
    }

	private boolean isDelimiter(PostalAddressPart postalAddressPart) {
		boolean result = false;
		if (postalAddressPart != null && postalAddressPart.getType() != null) {
			result = PostalAddressPartType.DELIMITER.getCodeValue().equals(postalAddressPart.getType().getCodeValue());
		}
		return result;
	}

    private String formatCode(Code code) {
		if (code == null || StringUtils.isEmpty(code.getCodeValue())) {
			return StringUtils.EMPTY;
		}
		String codeValue = XmlStringEscape.escape(code.getCodeValue());
		String codeSystem = XmlStringEscape.escape(code.getCodeSystem());
		return " code=\"" + codeValue + "\"" + (StringUtils.isBlank(code.getCodeSystem()) ? "" : " codeSystem=\"" + codeSystem + "\"");
	}

	private Map<String, String> getUseAttributeMap(String dataType, PostalAddress value, Hl7BaseVersion baseVersion) {
        String uses = "";
        for (PostalAddressUse postalAddressUse : value.getUses()) {
        	if (AD_VALIDATION_UTILS.isAllowableUse(dataType, postalAddressUse, baseVersion)) {
	            uses += uses.length() == 0 ? "" : " ";
	            uses += postalAddressUse.getCodeValue();
        	}
        }
        Map<String, String> result = new HashMap<String, String>();

        if (uses.length() > 0) {
            result.put("use", uses.trim());
        }
        return result;
    }
}
