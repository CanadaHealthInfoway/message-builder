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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.util.Currency;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class MoneyXmlParser extends AbstractSimpleXmlParser<MO, Money> implements SimpleXmlParser<MO> {
	
	MoneyXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Money value) {
    }

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, Money money) {
		Map<String, String> result = new LinkedHashMap<String, String>();
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

	@Override
	protected boolean closeStartElement(MO dataTypeInstance) {
		return true;
	}

}
