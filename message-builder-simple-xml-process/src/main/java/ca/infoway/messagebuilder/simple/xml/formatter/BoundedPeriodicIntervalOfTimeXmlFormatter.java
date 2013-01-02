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

import java.util.Date;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class BoundedPeriodicIntervalOfTimeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected BoundedPeriodicIntervalOfTimeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public GTS format(FormatContext formatContext, Element element) throws FormatterException {
		
		GTS result = null;
		
		Element frequencyElement = getSingleElement(element, "overallTimePeriod");
		Element periodicIntervalElement = getSingleElement(element, "frequency");
		
		if (frequencyElement != null && periodicIntervalElement != null) {
			IVL<TS,Interval<Date>> ivl = parseDateInterval(formatContext, frequencyElement, StandardDataType.IVL_FULL_DATE);
			PIVL pivl = parsePeriodicInterval(formatContext, periodicIntervalElement, StandardDataType.PIVL_TS_DATETIME);
			GeneralTimingSpecification boundedPeriodicIntervalTime = new GeneralTimingSpecification(ivl.getValue(), pivl.getValue());
			result = new GTSImpl(boundedPeriodicIntervalTime);
		} else {
			processError(formatContext, "Invalid bounded periodic interval format. Both overallTimePeriod and frequency must be specified", element);
		}
		return result;
	}

	private IVL<TS, Interval<Date>> parseDateInterval(FormatContext formatContext, Element frequencyElement, StandardDataType datatype) throws FormatterException {
		DateIntervalXmlFormatter formatter = new DateIntervalXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), frequencyElement);
	}

	private PIVL parsePeriodicInterval(FormatContext formatContext, Element periodicInterval, StandardDataType datatype) throws FormatterException {
		PeriodicIntervalOfTimeXmlFormatter formatter = new PeriodicIntervalOfTimeXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), periodicInterval);
	}
}
