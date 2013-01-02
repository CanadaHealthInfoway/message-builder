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

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class RatioMoneyPerUnitXmlFormatter extends AbstractSimpleXmlFormatter {

	protected RatioMoneyPerUnitXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public RTO<Money, PhysicalQuantity> format(FormatContext formatContext, Element element) throws FormatterException {
		RTO<Money, PhysicalQuantity> result = null;
		
		Element moneyElement = getSingleElement(element, "money");
		Element unitElement = getSingleElement(element, "unit");
		
		if (moneyElement != null && unitElement != null) {
			Money money = parseMoney(formatContext, moneyElement);
			PhysicalQuantity unit = parseQuantity(formatContext, unitElement);
			// a later process will validate that the two quantities are appropriate
			Ratio<Money, PhysicalQuantity> ratio = new Ratio<Money, PhysicalQuantity>(money, unit);
			result = new RTOImpl<Money, PhysicalQuantity>(ratio);
		} else {
			processError(formatContext, "Invalid ratio format. Both money and unit are required.", element);
		}
		return result;
	}

	private PhysicalQuantity parseQuantity(FormatContext formatContext, Element quantityElement) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ_BASIC, null), quantityElement).getValue();
	}
	
	private Money parseMoney(FormatContext formatContext, Element moneyElement) throws FormatterException {
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(StandardDataType.MO_CAD, null), moneyElement).getValue();
	}
}
