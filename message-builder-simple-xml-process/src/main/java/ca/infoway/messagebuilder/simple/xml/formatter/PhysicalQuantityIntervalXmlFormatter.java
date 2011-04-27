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

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class PhysicalQuantityIntervalXmlFormatter extends AbstractSimpleXmlFormatter {

	protected PhysicalQuantityIntervalXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public IVL<PQ,Interval<PhysicalQuantity>> format(FormatContext formatContext, Element element) throws FormatterException {
		
		IVL<PQ,Interval<PhysicalQuantity>> result = null;
		
		Element fromElement = getSingleElement(element, "from");
		Element toElement = getSingleElement(element, "to");
		
		// TODO: BCH: consider the handling of nullFlavor parts, here?
		
		if (fromElement != null && toElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			PQ to = parseQuantity(formatContext, toElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createLowHigh(from.getValue(), to.getValue()));
		} else if (fromElement != null) {
			PQ from = parseQuantity(formatContext, fromElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createLow(from.getValue()));
		} else if (toElement != null) {
			PQ to = parseQuantity(formatContext, toElement);
			result = new IVLImpl<PQ, Interval<PhysicalQuantity>>(IntervalFactory.createHigh(to.getValue()));
		} else {
			processError(formatContext, "Invalid interval format", element);
		}
		return result;
	}

	private PQ parseQuantity(FormatContext formatContext, Element duration) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(new FormatterConfiguration(true));
		return formatter.format(new FormatterContextImpl(StandardDataType.PQ, null), duration);
	}
}
