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
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.XmlNodeListIterable;

abstract class UrgElementParser<T extends QTY<V>, V> extends AbstractSingleElementParser<UncertainRange<V>> {

	@Override
	protected UncertainRange<V> parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) {
		// URGs are almost identical in function to IVLs; use IVL parser
		BareANY bareAny = getIvlParser().parse(convertContext(context), Arrays.asList(node), xmlToModelResult);
		
		@SuppressWarnings("unchecked")
		Interval<V> parsedInterval = (Interval<V>) bareAny.getBareValue();
		
		Boolean lowInclusive = getInclusiveValue("low", context, node, xmlToModelResult);
		Boolean highInclusive = getInclusiveValue("high", context, node, xmlToModelResult);
		UncertainRange<V> urg = convertIntervalToUncertainRange(parsedInterval, lowInclusive, highInclusive);
		return urg;
	}
	
	private Boolean getInclusiveValue(String elementName, ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		Boolean result = null;
		NodeList childNodes = node.getChildNodes();
        for (Node child : new XmlNodeListIterable(childNodes)) {
			if (elementName.equalsIgnoreCase(child.getNodeName())) {
				String inclusive = getAttributeValue(child, "inclusive");
				if (inclusive != null) {
					result = new Boolean(inclusive);
				}
				
				if (inclusive != null && !"true".equalsIgnoreCase(inclusive) && !"false".equalsIgnoreCase(inclusive)) {
					xmlToModelResult.addHl7Error(
						new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "The 'inclusive' attribute for URG." + elementName + " must be 'true' or 'false'", (Element) node)
					);
				} else if (inclusive != null && !context.getType().startsWith("URG<PQ.")) {
					xmlToModelResult.addHl7Error(
							new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "The 'inclusive' attribute for URG." + elementName + " is not allowed for types of " + context.getType(), (Element) node)
						);
				}
				break;
			}
		}
		return result;
	}

	private ParseContext convertContext(ParseContext context) {
		String newType = "IVL<" + Hl7DataTypeName.getParameterizedType(context.getType()) + ">";
		return ParseContextImpl.createWithConstraints(newType, context);
	}

	private UncertainRange<V> convertIntervalToUncertainRange(Interval<V> parsedInterval, Boolean lowInclusive, Boolean highInclusive) {
		UncertainRange<V> urg = null;
		if (parsedInterval != null) {
			urg = new UncertainRange<V>(parsedInterval, lowInclusive, highInclusive);
		}
		return urg;
	}

	protected abstract ElementParser getIvlParser();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new URGImpl<T, V>();
	}
}
