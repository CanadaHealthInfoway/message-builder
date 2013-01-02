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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

/**
 * MO - Money
 *
 * Represents an MO object as an element:
 *
 * &lt;amt value="10" currency="CAD"/&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler("MO")
class MoPropertyFormatter extends AbstractAttributePropertyFormatter<Money> {
	
	private static final int MAX_DIGITS_BEFORE_DECIMAL = 11;
	private static final int MAX_DIGITS_AFTER_DECIMAL = 2;

    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Money money, BareANY bareAny) {
    	
    	validate(money, context);    	
    	
        Map<String, String> result = new HashMap<String, String>();
        
        BigDecimal value = money.getAmount();
        if (value != null) {
            result.put("value", value.toString());
        }

        Currency currency = money.getCurrency();
        if (currency != null) {
            result.put("currency", currency.getCodeValue());
        }
        
        return result;
    }

	private void validate(Money money, FormatContext context) {

		ModelToXmlResult modelToXmlResult = context.getModelToXmlResult();
		String propertyPath = context.getPropertyPath(); 

		BigDecimal amount = money.getAmount();
		if (amount == null) {
			recordMissingValueError(propertyPath, modelToXmlResult);
		} else {
			String value = amount.toString();
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
			if (StringUtils.length(integerPart) > MAX_DIGITS_BEFORE_DECIMAL) {
				recordTooManyDigitsBeforeDecimalError(value, propertyPath, modelToXmlResult);
			}
			if (StringUtils.length(decimalPart) > MAX_DIGITS_AFTER_DECIMAL) {
				recordTooManyDigitsAfterDecimalError(value, propertyPath, modelToXmlResult);
			}
			if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
				recordMustContainDigitsOnlyError(value, propertyPath, modelToXmlResult);
			}
		}
		
		Currency currency = money.getCurrency();
		if (currency == null) {
			recordMissingCurrencyError(propertyPath, modelToXmlResult); 
		} else if (!Currency.CANADIAN_DOLLAR.getCodeValue().equals(currency.getCodeValue())) {
			recordCurrencyMustBeCadError(propertyPath, modelToXmlResult); 
		}
		
	}

	private void recordTooManyDigitsAfterDecimalError(String value, String propertyPath, ModelToXmlResult result) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
						+ value + " of type MO.CAD" 
						+ " should have no more than " + MAX_DIGITS_AFTER_DECIMAL 
						+ " digits after the decimal",
						propertyPath));
	}

	private void recordTooManyDigitsBeforeDecimalError(String value, String propertyPath, ModelToXmlResult result) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, "Value " 
						+ value + " of type MO.CAD" 
						+ " should have no more than " + MAX_DIGITS_BEFORE_DECIMAL 
						+ " digits before the decimal",
						propertyPath));
	}

	private void recordMustContainDigitsOnlyError(String value, String propertyPath, ModelToXmlResult result) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Value \"" + value + "\" can only contain digits, with a maximum of " + MAX_DIGITS_BEFORE_DECIMAL +
						" before the decimal and " + MAX_DIGITS_AFTER_DECIMAL + " after the decimal.",
						propertyPath
						));
	}
	
	private void recordCurrencyMustBeCadError(String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"currency\" has been provided, but it must be CAD.",
						propertyPath));
	}

	private void recordMissingCurrencyError(String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"currency\" is mandatory and must be specified.",
						propertyPath));
	}
	
	private void recordMissingValueError(String propertyPath, ModelToXmlResult modelToXmlResult) {
		modelToXmlResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"The attribute \"value\" is mandatory and must be specified.",
						propertyPath));
	}
	
}
