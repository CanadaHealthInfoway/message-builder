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

package ca.infoway.messagebuilder.simple.xml.formatter;

import java.math.BigDecimal;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Currency;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class MoneyXmlFormatter extends AbstractSimpleXmlFormatter {
	
	protected MoneyXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public MO format(FormatContext formatContext, Element value) throws FormatterException {
		MO result = null;
		String amountString = value.getAttribute("value");
		String currencyCode = value.getAttribute("currency");
		
		Currency currency = CodeResolverRegistry.lookup(Currency.class, currencyCode);
		if (currency == null) {
			processError(formatContext, "Currency not found", value);
		} else {
			try {
				BigDecimal amount = new BigDecimal(amountString);
				result = new MOImpl(new Money(amount, currency));
			} catch(NumberFormatException e) {
				processError(formatContext, "Currency amount is not a number", value);
			}
		}
		
		return result;
	}
}
