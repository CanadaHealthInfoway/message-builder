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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PostalAddressXmlParser extends AbstractSimpleXmlParser<AD, PostalAddress> implements SimpleXmlParser<AD> {

	PostalAddressXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, PostalAddress postalAddress) throws ParserException {
		for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
		    appendPostalAddressPart(builder, postalAddressPart);
		}
	}
	
    private void appendPostalAddressPart(StringBuilder builder, PostalAddressPart postalAddressPart) {
        PostalAddressPartType partType = postalAddressPart.getType();
        String partTypeStr = "";
        if (partType != null) {
        	partTypeStr = " type=\"" + partType.getCodeValue() + "\"";
        }
		String openTag = "<addressPart" + partTypeStr + ">";
        String closeTag = "</addressPart>";

        builder.append(openTag);
        String xmlEscapedValue = XmlStringEscape.escape(postalAddressPart.getValue());
        if (xmlEscapedValue != null) {
        	builder.append(xmlEscapedValue);
        }
        builder.append(closeTag);
    }

//	private String mapPartType(PostalAddressPartType partType) { 
//		String mappedPartType = partType.getValue();
//		switch (partType) {
//		case STATE:
//			mappedPartType = "provice";
//			break;
//		}
//		if (PostalAddressPartType.STATE.equals(partType)) {
//			return "province";
//		}
//		return mappedPartType;
//	}

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, PostalAddress value) {
        String uses = "";
        for (PostalAddressUse postalAddressUse : value.getUses()) {
            uses += uses.length() == 0 ? "" : " ";
            uses += postalAddressUse.getCodeValue();
        }
        Map<String, String> result = new LinkedHashMap<String, String>();

        if (uses.length() > 0) {
            result.put("use", uses);
        }
        return result;
    }

	@Override
	protected boolean closeStartElement(AD dataTypeInstance) {
		return false;
	}
	

}
