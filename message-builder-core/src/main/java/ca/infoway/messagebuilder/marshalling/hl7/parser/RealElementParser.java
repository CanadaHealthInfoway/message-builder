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
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.RealConfFormat;
import ca.infoway.messagebuilder.marshalling.hl7.RealCoordFormat;
import ca.infoway.messagebuilder.marshalling.hl7.RealFormat;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * REAL - BigDecimal
 * 
 * Parses an REAL element into a BigDecimal. The element looks like this:
 * 
 * <element-name value="0.1234" />
 * 
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-REAL
 * 
 * CHI further breaks down the datatype into REAL.CONF and REAL.COORD subtypes.
 * 
 */
@DataTypeHandler({"REAL.CONF", "REAL.COORD"})
class RealElementParser extends AbstractSingleElementParser<BigDecimal>{

	@Override
	protected BigDecimal parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);
		BigDecimal result = null;

		String unparsedReal = getAttributeValue(node, "value");
		validateDecimal(unparsedReal, context.getType(), xmlToModelResult, (Element) node);
		if (unparsedReal != null) {
			try {
				result = new BigDecimal(unparsedReal);
			} catch (NumberFormatException e) {
				recordInvalidNumberError(context, node, xmlToModelResult, unparsedReal);
			}
		}
		return result;
	}

	private void validateDecimal(String value, String type, XmlToModelResult result, Element element) {
		if (NumberUtil.isNumber(value)) {
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
			RealFormat format = getFormat(type);
			if (StandardDataType.REAL_CONF.getType().equals(type) && !valueIsBetweenZeroAndOneInclusive(integerPart, decimalPart)) {
				recordValueMustBeBetweenZeroAndOneError(value, type, result, element);
			}
			// TM - decided to remove check on overall length; we check before and after decimal lengths, which should be sufficient
			if (StringUtils.length(integerPart) > format.getMaxIntegerPartLength()) {
				recordTooManyCharactersBeforeDecimalError(value, type, result, element, format);
			}
			if (StringUtils.length(decimalPart) > format.getMaxDecimalPartLength()) {
				recordTooManyDigitsAfterDecimalError(value, type, result, element, format);
			}
		} else if (StringUtils.isBlank(value)) {
			recordValueMustBeSpecifiedError(result, element);
		}
	}

	private void recordValueMustBeSpecifiedError(XmlToModelResult result, Element element) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value must be specified", element));
	}

	private boolean valueIsBetweenZeroAndOneInclusive(String integerPart, String decimalPart) {
		// integer part must be a single zeros or empty; otherwise integer must be 1 and decimal must be all zeros or empty
		// TM - if this doesn't translate to .NET, then this can be replaced with a simple StringBuilder in a loop
		String repeatedZerosInteger = new String(new char[integerPart.length()]).replace("\0", "0");
		String repeatedZerosDecimal = new String(new char[decimalPart.length()]).replace("\0", "0");
		boolean integerPartAllZerosOrEmpty = repeatedZerosInteger.equals(integerPart) || "".equals(integerPart);
		boolean integerIsOneAndDecimalAllZerosOrEmpty = "1".equals(integerPart) && (repeatedZerosDecimal.equals(decimalPart));
		return integerPartAllZerosOrEmpty || integerIsOneAndDecimalAllZerosOrEmpty;
	}

	private void recordValueMustBeBetweenZeroAndOneError(String value, String type, XmlToModelResult result, Element element) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
				+ value + " of type " + type + " must be between 0 and 1 (inclusive).", element));
	}
	
	private void recordTooManyDigitsAfterDecimalError(String value, String type, XmlToModelResult result, Element element, RealFormat format) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
				+ value + " of type " + type 
				+ " should have no more than " + format.getMaxDecimalPartLength() 
				+ " digits after the decimal", element));
	}

	private void recordTooManyCharactersBeforeDecimalError(String value, String type, XmlToModelResult result, Element element, RealFormat format) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
				+ value + " of type " + type 
				+ " should have no more than " + format.getMaxIntegerPartLength() 
				+ " characters before the decimal", element));
	}

	private void recordInvalidNumberError(ParseContext context, Node node, XmlToModelResult xmlToModelResult, String unparsedReal) {
		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value \"" + unparsedReal + "\" of type " + context.getType() + " is not a valid number", (Element) node));
	}
	
	private RealFormat getFormat(String type) {
		return StandardDataType.REAL_CONF.getType().equals(type) ? (RealFormat) new RealConfFormat() : (RealFormat) new RealCoordFormat();
	}
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new REALImpl();
	}
}
