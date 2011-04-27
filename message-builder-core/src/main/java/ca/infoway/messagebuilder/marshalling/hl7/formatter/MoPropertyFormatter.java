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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

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
	
    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Money money) throws ModelToXmlTransformationException {
        Map<String, String> result = new HashMap<String, String>();
        if (money != null) {
            BigDecimal value = money.getAmount();
            if (value != null) {
                result.put("value", value.toString());
            }

            Currency currency = money.getCurrency();
            if (currency != null) {
                result.put("currency", currency.getCodeValue());
            }
        }
        return result;
    }
}
