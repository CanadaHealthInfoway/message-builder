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

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.iterator.EmptyIterable;

/**
 * AD.BASIC - Address (Basic)
 *
 * Represents an Address object as an element:
 *
 * &lt;element-name use="PHYS"&gt;	&lt;!-- "PHYS" is visit, "PST" is postal, "TMP" is temporary, "H" is home, "WP" is workplace. --&gt;
 * 1709 Bloor St W.&lt;delimiter/&gt;
 * Suite 200&lt;delimiter/&gt;
 *   &lt;city&gt;Toronto&lt;/city&gt;
 *   &lt;state code="ON&gt;Ontario&lt;/state&gt;
 *   &lt;postalCode&gt;A1A 1A1&lt;/postalCode&gt;&lt;delimiter/&gt;
 *   &lt;country code="CA"&gt;Canada&lt;/country&gt;
 * &lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 *
 * CeRx limits the length of each part to 60 characters. This limit is not enforced by
 * this class.
 *
 * It is also quite apparent that the use of the delimiters in the address indicates a
 * certain level of dementia.
 */
@DataTypeHandler("AD.BASIC")
class AdBasicPropertyFormatter extends AbstractAdPropertyFormatter {

    @Override
	protected
    final String formatNonNullValue(FormatContext context, PostalAddress postalAddress, int indentLevel) {
    	
    	Hl7BaseVersion baseVersion = context.getVersion().getBaseVersion();
		String dataType = context.getType();
		AD_VALIDATION_UTILS.validatePostalAddress(postalAddress, dataType, context.getVersion(), null, context.getPropertyPath(), context.getModelToXmlResult());
    	
    	PostalAddress basicAddress = new PostalAddress();
    	
    	StringBuilder builder = new StringBuilder();

    	// remove any non-basic address parts
    	for (PostalAddressPart part : EmptyIterable.nullSafeIterable(postalAddress.getParts())) {
   			if (part.getType() == PostalAddressPartType.CITY
					|| part.getType() == PostalAddressPartType.STATE
					|| part.getType() == PostalAddressPartType.COUNTRY
					|| part.getType() == PostalAddressPartType.POSTAL_CODE
					|| part.getType() == PostalAddressPartType.DELIMITER) {
				flush(builder, basicAddress);
				basicAddress.addPostalAddressPart(part);
			} else if (StringUtils.isNotBlank(part.getValue())) {
				if (builder.length() > 0) {
					builder.append(" ");
				}
				builder.append(part.getValue());
			}
		}
    	flush(builder, basicAddress);
    	
    	for (PostalAddressUse use : postalAddress.getUses()) {
    		if (AD_VALIDATION_UTILS.isAllowableUse(dataType, use, baseVersion)) {
    			basicAddress.addUse(use);
    		}
		}
    	
    	return super.formatNonNullValue(context, basicAddress, indentLevel);
    }

	private void flush(StringBuilder builder, PostalAddress basicAddress) {
		if (builder.length() > 0) {
			basicAddress.addPostalAddressPart(new PostalAddressPart(builder.toString()));
			builder.setLength(0);
		}
	}
}
