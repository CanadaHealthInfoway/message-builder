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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractAttributePropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * MO - Money (R2)
 *
 * Represents an MO object as an element:
 *
 * &lt;amt value="10" currency="CAD"/&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-MO
 */
@DataTypeHandler({"MO", "SXCM<MO>"})
class MoR2PropertyFormatter extends AbstractAttributePropertyFormatter<Money> {
	
    private final SxcmR2PropertyFormatterHelper sxcmHelper = new SxcmR2PropertyFormatterHelper();

    @Override
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Money money, BareANY bareAny) {
    	
    	validate(money, context);    	
    	
        Map<String, String> attributes = new HashMap<String, String>();
        
        BigDecimal value = money.getAmount();
        if (value != null) {
            attributes.put("value", value.toString());
        }

        Currency currency = money.getCurrency();
        if (currency != null) {
            attributes.put("currency", currency.getCodeValue());
        }
        
    	this.sxcmHelper.handleOperator(attributes, context, (ANYMetaData) bareAny);
        
        return attributes;
    }

	private void validate(Money money, FormatContext context) {

		// nothing much to validate for R2 version of datatype
		
		ModelToXmlResult modelToXmlResult = context.getModelToXmlResult();
		String propertyPath = context.getPropertyPath(); 

		BigDecimal amount = money.getAmount();
		if (amount != null) {
			String value = amount.toString();
			String integerPart = value.contains(".") ? StringUtils.substringBefore(value, ".") : value;
			String decimalPart = value.contains(".") ? StringUtils.substringAfter(value, ".") : "";
			
			if (!StringUtils.isNumeric(integerPart) || !StringUtils.isNumeric(decimalPart)) {
				recordMustContainDigitsOnlyError(value, propertyPath, modelToXmlResult);
			}
		}
		
	}

	private void recordMustContainDigitsOnlyError(String value, String propertyPath, ModelToXmlResult result) {
		result.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						"Value \"" + value + "\" can only contain digits.",
						propertyPath
						));
	}
	
}
