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

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.x_BasicPostalAddressUse;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PostalAddressXmlFormatter extends AbstractSimpleXmlFormatter {

	protected PostalAddressXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public AD format(FormatContext formatContext, Element value) throws FormatterException {
		PostalAddress postalAddress = null;
			
		NodeList postalAddressPartNodes = value.getElementsByTagName("addressPart");
		if (postalAddressPartNodes.getLength() == 0) {
			postalAddress = buildPostalAddressFromSimplifiedElements(value);
		} else {
			postalAddress = buildPostalAddressFromPostalAddressParts(postalAddressPartNodes, formatContext, value);
		}
		
		AD result = null;
		if (postalAddress != null) {
			Set<x_BasicPostalAddressUse> postalAddressUses = getPostalAddressUses(value.getAttribute("use"));
			postalAddress.getUses().addAll(postalAddressUses);
			result = new ADImpl(postalAddress);
		}
		
		return result;
	}

	private PostalAddress buildPostalAddressFromPostalAddressParts(NodeList postalAddressNodes, FormatContext formatContext, Element value) throws FormatterException {
		PostalAddress postalAddress = new PostalAddress();
		for (int i = 0, length = postalAddressNodes.getLength(); i < length; i++) {
			Element item = (Element) postalAddressNodes.item(i);
			
			String originalPartType = item.getAttribute("type");
			String partTypeString = StringUtils.upperCase(originalPartType);
			PostalAddressPartType partType = null;
			if (partTypeString != null) {
				// while part type is optional, if a part type code is given we have to be able to find it
				partType = CodeResolverRegistry.lookup(PostalAddressPartType.class, partTypeString);
				if (partType == null) {
					processError(formatContext, "No address part type found for [" + originalPartType + "]", value);
				}
			}

			// part type is optional, so null value is ok
			String textContent = item.getTextContent();
			postalAddress.getParts().add(new PostalAddressPart(partType, textContent));
			
		}
		return postalAddress;
	}

	private PostalAddress buildPostalAddressFromSimplifiedElements(Element value) {
		NodeList addressLineNodes = value.getElementsByTagName("addressLine");
		NodeList cityNodes = value.getElementsByTagName("city");
		NodeList provinceNodes = value.getElementsByTagName("province");
		NodeList postalCodeNodes = value.getElementsByTagName("postalCode");
		NodeList stateNodes = value.getElementsByTagName("state");
		NodeList zipCodeNodes = value.getElementsByTagName("zipCode");
		NodeList countryNodes = value.getElementsByTagName("country");
		
		PostalAddress postalAddress = new PostalAddress();
		addPostalAddressParts(addressLineNodes, postalAddress, PostalAddressPartType.ADDRESS_LINE);
		addPostalAddressParts(cityNodes, postalAddress, PostalAddressPartType.CITY);
		addPostalAddressParts(provinceNodes, postalAddress, PostalAddressPartType.STATE);
		addPostalAddressParts(postalCodeNodes, postalAddress, PostalAddressPartType.POSTAL_CODE);
		addPostalAddressParts(stateNodes, postalAddress, PostalAddressPartType.STATE);
		addPostalAddressParts(zipCodeNodes, postalAddress, PostalAddressPartType.POSTAL_CODE);
		addPostalAddressParts(countryNodes, postalAddress, PostalAddressPartType.COUNTRY);
		
		return postalAddress;
	}

	private void addPostalAddressParts(NodeList nodeList, PostalAddress postalAddress, PostalAddressPartType partType) {
		for (int i = 0, length = nodeList.getLength(); i < length; i++) {
			String partValue = nodeList.item(i).getTextContent();
			postalAddress.getParts().add(new PostalAddressPart(partType, partValue));
		}
	}

	// taken from AdElementParser
    private Set<x_BasicPostalAddressUse> getPostalAddressUses(String nameUseAttribute) {
        Set<x_BasicPostalAddressUse> uses = new LinkedHashSet<x_BasicPostalAddressUse>();
        if (nameUseAttribute != null) {
            StringTokenizer tokenizer = new StringTokenizer(nameUseAttribute);
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                x_BasicPostalAddressUse postalAddressUse = CodeResolverRegistry.lookup(x_BasicPostalAddressUse.class, token);
                if (postalAddressUse == null) {
                	// error if a use is not found
                } else {
                    uses.add(postalAddressUse);
                }
            }
        }
        return uses;
    }
}
