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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PeriodicIntervalOfTimeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected PeriodicIntervalOfTimeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public PIVL format(FormatContext formatContext, Element element) throws FormatterException {
		
		PIVL result = null;
		
		Element timeQuantityElement = getSingleElement(element, "every");
		String numberOfOccurrencesString = element.getAttribute("numberOfOccurrences");
		
		if (timeQuantityElement != null && StringUtils.isNotBlank(numberOfOccurrencesString)) {
			// a later process will validate that the quantity is appropriate
			PQ timeQuantity = parseQuantity(formatContext, timeQuantityElement, StandardDataType.PQ_TIME);
			Integer numberOfOccurrences = parseInteger(formatContext, element, numberOfOccurrencesString);
			PeriodicIntervalTime periodicIntervalTime = PeriodicIntervalTime.createFrequency(numberOfOccurrences, timeQuantity.getValue());
			result = new PIVLImpl(periodicIntervalTime);
		} else {
			processError(formatContext, "Invalid periodic interval format. Both \"every\" quantity and numberOfOccurrences are required.", element);
		}
		return result;
	}

	private Integer parseInteger(FormatContext formatContext, Element value, String numberOfOccurrencesString) throws FormatterException {
		int result = NumberUtils.toInt(numberOfOccurrencesString);
		if (result <= 0) {
			processError(formatContext, "numberOfOccurrences must be a positive integer [" + numberOfOccurrencesString + "]", value);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration, StandardDataType datatype) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), duration);
	}
}
