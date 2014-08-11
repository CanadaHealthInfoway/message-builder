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
 * Last modified: $LastChangedDate: 2013-03-11 18:38:50 -0400 (Mon, 11 Mar 2013) $
 * Revision:      $LastChangedRevision: 6702 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * Parses an TEL element into a String. (R2) The element looks like this:
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
@DataTypeHandler("TEL")
class TelR2ElementParser extends AbstractSingleElementParser<TelecommunicationAddress> {

	private static Map<String, SetOperator> allOperators = new HashMap<String, SetOperator>();
	static {
		List<SetOperator> operatorValues = SetOperator.values(SetOperator.class);
		for (SetOperator setOperator : operatorValues) {
			allOperators.put(setOperator.getCodeValue(), setOperator);
		}
	}
	
//	private static final TelValidationUtils TEL_VALIDATION_UTILS = new TelValidationUtils();
	
	@Override
	protected TelecommunicationAddress parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		TelecommunicationAddress telecomAddress = parseTelecommunicationAddress(node, xmlToModelResult, context.getVersion());
		
		// any validations for R2 to do here?
		
		return telecomAddress;
	}

	private TelecommunicationAddress parseTelecommunicationAddress(Node node, XmlToModelResult xmlToModelResult, VersionNumber version) {
		TelecommunicationAddress result = parseValue(node, xmlToModelResult);

		// handle address uses
		parseAddressUses(node, result);

		// handle useable periods
		parseUseablePeriods(node, xmlToModelResult, result, version);
		
		return result;
	}

	private TelecommunicationAddress parseValue(Node node, XmlToModelResult xmlToModelResult) {
		String value = getAttributeValue(node, "value");
		
		if (StringUtils.isBlank(value)) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "TEL elements must have a value or a nullFlavor.", (Element) node));
		}
		
		// remove the // that appear after the colon if necessary
		// e.g. file://monkey
		value = value == null ? null : value.replaceAll("://", ":");
		
		// anything before the FIRST colon is the URL scheme. Anything after it is the address.
		int colonIndex = value == null ? -1 : value.indexOf(':');
		
		String address = null;
		URLScheme urlScheme = null;
		if (colonIndex == -1) {
			address = value;
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "TEL values must provide a URL scheme (i.e. mailto:)", (Element) node));
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
		
		return result;
	}

	private void parseUseablePeriods(Node node,	XmlToModelResult xmlToModelResult, TelecommunicationAddress result, VersionNumber version) {
		NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode instanceof Element) {
                Element useablePeriodElement = (Element) childNode;
                String name = NodeUtil.getLocalOrTagName(useablePeriodElement);
                if ("useablePeriod".equals(name)) {
                	BareANY tsAny = new TsR2ElementParser().parse(tsContext(version), useablePeriodElement, xmlToModelResult);
                	Date date = (Date) tsAny.getBareValue();
                	result.addUseablePeriod(date, ((ANYMetaData) tsAny).getOperator());
                } else {
                	xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
                			"Unexpected TEL child element: \"" + useablePeriodElement.getNodeName() + "\"", useablePeriodElement));
                }
            }
        }
	}

	private ParseContext tsContext(VersionNumber version) {
		return ParserContextImpl.create(StandardDataType.SXCM_TS.getType(), null, version, null, null, null, null);
	}

	private void parseAddressUses(Node node, TelecommunicationAddress result) {
		String addressUses = getAttributeValue(node, "use");
		if (addressUses != null) {
			StringTokenizer tokenizer = new StringTokenizer(addressUses);
			while (tokenizer.hasMoreElements()) {
				result.addAddressUse(CodeResolverRegistry.lookup(TelecommunicationAddressUse.class, tokenizer.nextToken()));
			}
		}
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new TELImpl();
	}
}