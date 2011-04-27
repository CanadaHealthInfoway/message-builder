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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * INT - Integer
 * 
 * Parses an INT element into a Integer. The element looks like this:
 * 
 * <element-name value="123" />
 * 
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 * 
 * CeRx further breaks down the datatype into INT.NONNEG and INT.POS subtypes, but those are
 * irrelevant on the parsing side. We don't check for non-negative or positive constraints.
 */
@DataTypeHandler({"INT.NONNEG", "INT.POS", "INT"})
class IntElementParser extends AbstractSingleElementParser<Integer> {

	@Override
	protected Integer parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);
		return parseNonNullNode((Element) node, expectedReturnType, xmlToJavaResult);
	}

	protected Integer parseNonNullNode(Element element, Type expectedReturnType, XmlToModelResult xmlToJavaResult) throws XmlToModelTransformationException {
		
		Integer result = null;
		
		String unparsedInteger = getAttributeValue(element, "value");
		if (StringUtils.isNotBlank(unparsedInteger)) {
			if (!NumberUtil.isNumber(unparsedInteger)) {
				xmlToJavaResult.addHl7Error(
						new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
								"The attribute \"value\" does not contain a valid number (" 
								+ XmlDescriber.describeSingleElement(element)
								+ ")", element));
			} else {
				result = NumberUtil.parseAsInteger(unparsedInteger);
				if (!NumberUtil.isInteger(unparsedInteger)) {
					xmlToJavaResult.addHl7Error(
							new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
									"The attribute \"value\" is not a valid integer, it will be truncated to "
									+ result
									+" (" 
									+ XmlDescriber.describeSingleElement(element)
									+ ")", element));
				}
			}
		} else if (element.hasAttribute("value")) {
			xmlToJavaResult.addHl7Error(
					new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
							"The attribute \"value\" is specified, but empty. (" 
							+ XmlDescriber.describeSingleElement(element)
							+ ")", element));
		}
		
 		return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new INTImpl();
	}
}