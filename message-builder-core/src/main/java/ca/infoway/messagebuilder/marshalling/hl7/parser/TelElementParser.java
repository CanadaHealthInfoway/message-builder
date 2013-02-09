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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.StringTokenizer;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.TelValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Parses an TEL element into a String. The element looks like this:
 * 
 * <element-name value="mailto://ilikemonkeys@itstrue.com" />
 * 
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 * 
 * The value attribute is a bit of a pain, since it contains two pieces of information,
 * the URLScheme and the actual address.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 * 
 */
@DataTypeHandler({"TEL.URI", "TEL.PHONEMAIL", "TEL.ALL", "TEL"})
class TelElementParser extends AbstractSingleElementParser<TelecommunicationAddress> {

	private static final TelValidationUtils TEL_VALIDATION_UTILS = new TelValidationUtils();
	
	@Override
	protected TelecommunicationAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);
		String specializationType = getAttributeValue(node, SPECIALIZATION_TYPE);
		TelecommunicationAddress telecomAddress = parseTelecommunicationAddress(node, xmlToModelResult);
		
		String type = context.getType();
		TEL_VALIDATION_UTILS.validateTelecommunicationAddress(telecomAddress, type, specializationType, context.getVersion(), (Element) node, null, xmlToModelResult);
		
		return telecomAddress;
	}

	private TelecommunicationAddress parseTelecommunicationAddress(Node node, XmlToModelResult xmlToModelResult) {
		String value = getAttributeValue(node, "value");
		
		// remove the // that appear after the colon if necessary
		// e.g. file://monkey
		value = value == null ? null : value.replaceAll("://", ":");
		
		// anything before the FIRST colon is the URL scheme. Anything after it is the address.
		int colonIndex = value == null ? -1 : value.indexOf(':');
		
		String address = null;
		URLScheme urlScheme = null;
		if (colonIndex == -1) {
			address = value;
		} else {
			address = value.substring(colonIndex + 1);
			String urlSchemeString = value.substring(0, colonIndex);
			urlScheme = CodeResolverRegistry.lookup(URLScheme.class, urlSchemeString);
			if (urlScheme == null) {
				String message = "Unrecognized URL scheme '" + urlSchemeString + "' in element " +  XmlDescriber.describePath(node);
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, (Element) node));
			}
		}
			
		TelecommunicationAddress result = new TelecommunicationAddress();
		result.setAddress(address);
		result.setUrlScheme(urlScheme);

		// handle address uses
		String addressUses = getAttributeValue(node, "use");
		if (addressUses != null) {
			StringTokenizer tokenizer = new StringTokenizer(addressUses);
			while (tokenizer.hasMoreElements()) {
				result.addAddressUse(CodeResolverRegistry.lookup(TelecommunicationAddressUse.class, tokenizer.nextToken()));
			}
		}

		return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TELImpl();
	}
}