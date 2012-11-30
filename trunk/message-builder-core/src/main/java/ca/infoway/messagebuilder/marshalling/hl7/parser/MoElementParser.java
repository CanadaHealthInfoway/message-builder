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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.lang.NumberUtil;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * MO - Money
 * 
 * Represents an MO elements into a MO object. The element looks like this:
 * 
 * <amt value="10" currency="CAD"/>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoElementParser extends AbstractSingleElementParser<Money> {

	private static final int MAX_DIGITS_BEFORE_DECIMAL = 11;
	private static final int MAX_DIGITS_AFTER_DECIMAL = 2;

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new MOImpl();
	}
	
	@Override
	protected Money parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);

		String value = getMandatoryAttributeValue(node, "value", xmlToModelResult);
		BigDecimal amount = validateValue(value, context.getType(), xmlToModelResult, (Element) node);
		
        String currencyCode = getMandatoryAttributeValue(node, "currency", xmlToModelResult);
        Currency currency = validateCurrency(currencyCode, node, xmlToModelResult);
        
		return amount == null && currency == null ? null : new Money(amount, currency);
	}

	private BigDecimal validateValue(String value, String type, XmlToModelResult xmlToModelResult, Element element) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		
		if (NumberUtil.isNumber(value)) {
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
			if (StringUtils.length(integerPart) > MAX_DIGITS_BEFORE_DECIMAL) {
				recordTooManyDigitsBeforeDecimalError(value, type, xmlToModelResult, element);
			}
			if (StringUtils.length(decimalPart) > MAX_DIGITS_AFTER_DECIMAL) {
				recordTooManyDigitsAfterDecimalError(value, type, xmlToModelResult, element);
			}
			if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
				recordMustContainDigitsOnlyError(value, xmlToModelResult, element);
			}
		}
		
		BigDecimal result = null;
		try {
			result = new BigDecimal(value);
		} catch (NumberFormatException e) {
			recordInvalidNumberError(value, type, element, xmlToModelResult);
		}
		return result;
	}

	private Currency validateCurrency(String currencyCode, Node node, XmlToModelResult xmlToModelResult) {
		if (StringUtils.isBlank(currencyCode)) {
			return null;
		}
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
		
        if (currency == null) {
            recordUnknownCurrencyError(currencyCode, node, xmlToModelResult);
        } else if (!Currency.CANADIAN_DOLLAR.getCodeValue().equals(currencyCode)) {
    		recordCurrencyMustBeCanadianError(currencyCode, node, xmlToModelResult);
        }
        
		return currency;
	}

	private void recordCurrencyMustBeCanadianError(String currencyCode, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Currency " + currencyCode + "is not allowed. Currency must be set to CAD. (" + XmlDescriber.describeSingleElement((Element) node) + ")",
						(Element) node
						));
	}

	private void recordUnknownCurrencyError(String currencyCode, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Could not decode currency value " + currencyCode + " (" + XmlDescriber.describeSingleElement((Element) node) + ")",
						(Element) node
						));
	}

	private void recordTooManyDigitsAfterDecimalError(String value, String type, XmlToModelResult result, Element element) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
						+ value + " of type " + type 
						+ " should have no more than " + MAX_DIGITS_AFTER_DECIMAL 
						+ " digits after the decimal (" + XmlDescriber.describeSingleElement(element) + ")", 
						element));
	}

	private void recordTooManyDigitsBeforeDecimalError(String value, String type, XmlToModelResult result, Element element) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
						+ value + " of type " + type 
						+ " should have no more than " + MAX_DIGITS_BEFORE_DECIMAL 
						+ " digits before the decimal (" + XmlDescriber.describeSingleElement(element) + ")", 
						element));
	}

	private void recordInvalidNumberError(String value, String type, Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"Value \"" + value + "\" of type " + type + " is not a valid number (" + XmlDescriber.describeSingleElement(element) + ")",
						element));
	}
	
	private void recordMustContainDigitsOnlyError(String value, XmlToModelResult xmlToModelResult, Element element) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Value \"" + value + "\" can only contain digits, with a maximum of " + MAX_DIGITS_BEFORE_DECIMAL +
						" before the decimal and " + MAX_DIGITS_AFTER_DECIMAL + " after the decimal. (" + XmlDescriber.describeSingleElement(element) + ")",
						element
						));
	}

}
