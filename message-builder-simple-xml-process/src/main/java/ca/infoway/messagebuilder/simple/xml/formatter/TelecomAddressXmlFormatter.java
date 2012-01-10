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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_EMAIL;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_PHONE;
import static ca.infoway.messagebuilder.datatype.StandardDataType.TEL_URI;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.URLScheme;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;


public class TelecomAddressXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected TelecomAddressXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public TEL format(FormatContext formatContext, Element value) throws FormatterException {
		
		// consider breaking into three separate formatters?
		
		TelecommunicationAddress tel = null;
		
		StandardDataType dataType = formatContext.getType();
		if (TEL_EMAIL.equals(dataType)) {
			tel = parseEmail(value.getTextContent(), value, formatContext);
		} else if (TEL_PHONE.equals(dataType)) {
			tel = parsePhone(value.getTextContent(), value, formatContext);
		} else if (TEL_URI.equals(dataType)) {
			tel = parseUri(value.getTextContent(), value, formatContext);
		} else {
			processError(formatContext, "TEL type not supported", value);
		}

		TEL result = null;
		if (tel != null) {
			result = new TELImpl(tel);
		}
		return result;
	}

	private TelecommunicationAddress parseUri(String textContent, Element value, FormatContext formatContext) throws FormatterException {
		TelecommunicationAddress uri = null;
		String uriString = value.getAttribute("value");
		String[] parts = uriString.split("://");
		if (parts.length == 2) {
			URLScheme scheme = CodeResolverRegistry.lookup(URLScheme.class, parts[0].toLowerCase());
			if (scheme == null) {
				processError(formatContext, "unknown URI scheme", value);
			} else {
				uri = new TelecommunicationAddress(scheme, parts[1]);
			}
		} else {
			processError(formatContext, "URI requires both scheme and address", value);
		}
		return uri;
	}

	private TelecommunicationAddress parsePhone(String textContent, Element value, FormatContext formatContext) throws FormatterException {
		TelecommunicationAddress uri = null;
		
		String areaCode = getSingleElementTextValue("areaCode", value);
		String phoneNumber = getSingleElementTextValue("phoneNumber", value);
		String extension = getSingleElementTextValue("extension", value);
		
		String type = value.getAttribute("type");
		URLScheme scheme = CodeResolverRegistry.lookup(URLScheme.class, StringUtils.lowerCase(type));
		
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(areaCode) && StringUtils.isNotBlank(phoneNumber)) {
			String telString = buildPhoneNumber(areaCode, phoneNumber, extension);
			uri = new TelecommunicationAddress(scheme, telString, extractUses(value, formatContext));
		} else {
			processError(formatContext, "TEL requires phone type, area code and phone number", value);
		}
		return uri;
	}

	private String buildPhoneNumber(String areaCode, String phoneNumber, String extension) {
		String extensionSuffix = (StringUtils.isBlank(extension) ? "" : ";ext=" + extension);
		return areaCode + phoneNumber + extensionSuffix;
	}

	private TelecommunicationAddress parseEmail(String textContent, Element value, FormatContext formatContext) throws FormatterException {
		TelecommunicationAddress uri = null;
		
		String address = getSingleElementTextValue("mailto", value);
		
		if (StringUtils.isNotBlank(address)) {
			uri = new TelecommunicationAddress(URLScheme.MAILTO, address, extractUses(value, formatContext));
		} else {
			processError(formatContext, "Email requires mailto address", value);
		}
		return uri;
	}

	private TelecommunicationAddressUse[] extractUses(Element value, FormatContext formatContext) throws FormatterException {
		NodeList useNodes = value.getElementsByTagName("use"); 
		List<TelecommunicationAddressUse> results = new ArrayList<TelecommunicationAddressUse>();
		for (int i=0, length=useNodes.getLength(); i < length; i++) {
			Element useElement = (Element) useNodes.item(i);
			String use = useElement.getTextContent();
			TelecommunicationAddressUse lookup = CodeResolverRegistry.lookup(TelecommunicationAddressUse.class, use);
			if (lookup == null) {
				processError(formatContext, "TelecomAddress usage not found: " + use, value);
			} else {
				results.add(lookup);
			}
		}
		return results.toArray(new TelecommunicationAddressUse[0]);
	}

	private String getSingleElementTextValue(String elementName, Element value) {
		NodeList items = value.getElementsByTagName(elementName);
		return (items.getLength() == 1 ? items.item(0).getTextContent() : null);
	}
}
