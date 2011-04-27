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

import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

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

	@Override
    String formatNonNullValue(FormatContext context, PostalAddress postalAddress, int indentLevel) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, getUseAttributeMap(postalAddress), indentLevel, false, false));
		for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
		    appendPostalAddressPart(buffer, postalAddressPart);
		}
		buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
    }

    private void appendPostalAddressPart(StringBuffer buffer, PostalAddressPart postalAddressPart) {
        String openTag = "";
        String closeTag = "";

        if (postalAddressPart.getType() != null) {
            openTag = "<" + postalAddressPart.getType().getValue() + ">";
            closeTag = "</" + postalAddressPart.getType().getValue() + ">";
        }

        buffer.append(openTag);
        String xmlEscapedValue = XmlStringEscape.escape(postalAddressPart.getValue());
        if (xmlEscapedValue != null) {
        	buffer.append(xmlEscapedValue);
        }
        buffer.append(closeTag);
    }

    private Map<String, String> getUseAttributeMap(PostalAddress value) {
        String uses = "";
        for (PostalAddressUse postalAddressUse : value.getUses()) {
            uses += uses.length() == 0 ? "" : " ";
            uses += postalAddressUse.getCodeValue();
        }
        Map<String, String> result = new HashMap<String, String>();

        if (uses.length() > 0) {
            result.put("use", uses);
        }
        return result;
    }
}
