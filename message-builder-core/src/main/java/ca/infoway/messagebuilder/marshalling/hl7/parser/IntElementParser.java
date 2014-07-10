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

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
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
 * CeRx further breaks down the datatype into INT.NONNEG and INT.POS subtypes.
 * 
 */
@DataTypeHandler({"INT.NONNEG", "INT.POS", "INT"})
class IntElementParser extends AbstractSingleElementParser<Integer> {

	@Override
	protected Integer parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);
		return parseNonNullNode(context, (Element) node, xmlToModelResult);
	}

	private Integer parseNonNullNode(ParseContext context, Element element, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		
		Integer result = null;
		
		String unparsedInteger = getAttributeValue(element, "value");
		if (StringUtils.isNotBlank(unparsedInteger)) {
			if (!NumberUtil.isNumber(unparsedInteger)) {
				recordNotAValidNumberError(element, xmlToModelResult);
			} else {
				result = NumberUtil.parseAsInteger(unparsedInteger);
				// using the isNumeric check to catch silly things such as passing in a hexadecimal number (0x1a, for example)
				boolean mustBePositive = StandardDataType.INT_POS.getType().equals(context.getType());
				if (StandardDataType.INT.getType().equals(context.getType()) && unparsedInteger.startsWith("-")) {
					// remove negative sign to not confuse isNumeric() check
					unparsedInteger = unparsedInteger.substring(1);
				}
				if (!NumberUtil.isInteger(unparsedInteger) || !StringUtils.isNumeric(unparsedInteger)) {
					recordInvalidIntegerError(result, element, mustBePositive, xmlToModelResult);
				} else if (mustBePositive && result.intValue() == 0) {
					recordMustBeGreaterThanZeroError(element, xmlToModelResult);
				}
			}
		} else if (element.hasAttribute("value")) {
			recordEmptyValueError(element, xmlToModelResult);
		} else {
			recordMissingValueError(element, xmlToModelResult);
		}
		
 		return result;
	}

	private void recordMissingValueError(Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
			new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
					"The attribute \"value\" must be specified. (" 
					+ XmlDescriber.describeSingleElement(element)
					+ ")", element));
	}

	private void recordEmptyValueError(Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" is specified, but empty. (" 
						+ XmlDescriber.describeSingleElement(element)
						+ ")", element));
	}

	private void recordMustBeGreaterThanZeroError(Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" must be greater than zero for INT.POS. (" 
						+ XmlDescriber.describeSingleElement(element)
						+ ")", element));
	}

//	private void recordNotNegativeError(Element element, XmlToModelResult xmlToModelResult) {
//		xmlToModelResult.addHl7Error(
//				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
//						"The attribute \"value\" must not be negative for INT.NONNEG. (" 
//						+ XmlDescriber.describeSingleElement(element)
//						+ ")", element));
//	}
//
	private void recordInvalidIntegerError(Integer result, Element element, boolean mustBePositive, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" is not a valid integer: it cannot be negative " + (mustBePositive ? "or zero " : "") + "and must be digits only (maximum of 10), with a maximum value of "
				        + Integer.MAX_VALUE + "." + " The value may have been truncated; processing value as "
						+ result
						+" (" 
						+ XmlDescriber.describeSingleElement(element)
						+ ")", element));
	}

	private void recordNotAValidNumberError(Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" does not contain a valid number (" 
						+ XmlDescriber.describeSingleElement(element)
						+ ")", element));
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new INTImpl();
	}
}