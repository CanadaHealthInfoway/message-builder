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

import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_EMAIL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_PHONE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_URI;
import static java.lang.String.format;

import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;
import ca.infoway.messagebuilder.util.telephone.Telephone;
import ca.infoway.messagebuilder.util.telephone.TelephoneParser;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

public class TelecomAddressXmlParser extends AbstractSimpleXmlParser<TEL, TelecommunicationAddress> implements SimpleXmlParser<TEL> {
	
	TelecomAddressXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, TelecommunicationAddress value) {
		if (TEL_EMAIL.equals(dataType)) {
			renderUses(builder, value);
			renderEmail(builder, value);
		} else if (TEL_PHONE.equals(dataType)) {
			renderUses(builder, value);
			renderPhone(builder, value);
		}
    }
	
	private void renderPhone(StringBuilder builder, TelecommunicationAddress value) {
		TelephoneParser parser = new TelephoneParser();
		Telephone telephone = parser.createTelephone(value.getAddress());
		if (telephone!=null) {
			renderTelephone(builder, telephone);
		}
	}

	private void renderTelephone(StringBuilder builder, Telephone telephone) {
		renderTelephoneNumberPart(builder, "areaCode", telephone.getAreaCode());
		renderTelephoneNumberPart(builder, "phoneNumber", telephone.getPhoneNumber().getTelephoneNumber());
		renderTelephoneNumberPart(builder, "extension", telephone.getExtension());
	}

	private void renderTelephoneNumberPart(StringBuilder builder, String elementName, String value) {
		builder.append(format("<%s>%s</%1$s>", elementName, value));
	}

	private void renderEmail(StringBuilder builder, TelecommunicationAddress value) {
		builder.append(XmlRenderingUtils.createStartElement("mailto", 0, false, false));
		builder.append(XmlStringEscape.escape(value.getAddress()));
		builder.append(XmlRenderingUtils.createEndElement("mailto", 0, false));
	}

	private void renderUses(StringBuilder builder, TelecommunicationAddress value) {
		for (TelecommunicationAddressUse use : value.getAddressUses()) {
			builder.append(XmlRenderingUtils.createStartElement("use", 0, false, false));
			builder.append(XmlStringEscape.escape(use.getCodeValue()));
			builder.append(XmlRenderingUtils.createEndElement("use", 0, false));
		}
	}

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, TelecommunicationAddress value) {
		Map<String, String> pairs = new LinkedHashMap<String, String>();
		
		if (TEL_URI.equals(dataType)) {
			pairs.put("value", format("%s://%s", value.getUrlScheme().getCodeValue(), value.getAddress()));
		} else if (TEL_PHONE.equals(dataType)) {
			if (value.getUrlScheme()!=null) {
				pairs.put("type", value.getUrlScheme().getCodeValue().toUpperCase());
			}
		} else {
			pairs = super.toNameValuePairs(dataType, value);
		}
		
		return pairs;
	}

	@Override
	protected boolean closeStartElement(TEL dataTypeInstance) {
		return StandardDataType.TEL_URI.equals(dataTypeInstance.getDataType());
	}

}
