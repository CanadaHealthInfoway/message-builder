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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

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
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * MO - Money (R2)
 * 
 * Represents an MO elements into a MO object. The element looks like this:
 * 
 * <amt value="10" currency="CAD"/>
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoR2ElementParser extends AbstractSingleElementParser<Money> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new MOImpl();
	}
	
	@Override
	protected Money parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);

		String value = getAttributeValue(node, "value");
		BigDecimal amount = validateValue(value, context.getType(), xmlToModelResult, (Element) node);
		
        String currencyCode = getAttributeValue(node, "currency");
        Currency currency = validateCurrency(currencyCode, node, xmlToModelResult);
        
		return amount == null && currency == null ? null : new Money(amount, currency);
	}

	private BigDecimal validateValue(String value, String type, XmlToModelResult xmlToModelResult, Element element) {
		if (StringUtils.isBlank(value)) {
			if (element.hasAttribute("value")) {
				recordInvalidNumberError(value, type, element, xmlToModelResult);
			}
			return null;
		}
		
		if (NumberUtil.isNumber(value)) {
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
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
		// TM - the MB enum for currency is very limited
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
		
        if (currency == null) {
            recordUnknownCurrencyError(currencyCode, node, xmlToModelResult);
        }
        
		return currency;
	}

	private void recordUnknownCurrencyError(String currencyCode, Node node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Could not decode currency value " + currencyCode + " (" + XmlDescriber.describeSingleElement((Element) node) + ")",
						(Element) node
						));
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
						"Value \"" + value + "\" can only contain digits. (" + XmlDescriber.describeSingleElement(element) + ")",
						element
						));
	}

}
