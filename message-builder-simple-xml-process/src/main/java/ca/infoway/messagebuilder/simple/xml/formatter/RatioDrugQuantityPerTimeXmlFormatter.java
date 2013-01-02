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
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.simple.xml.FormatContext;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;

public class RatioDrugQuantityPerTimeXmlFormatter extends AbstractSimpleXmlFormatter {

	protected RatioDrugQuantityPerTimeXmlFormatter(FormatterConfiguration configuration) {
		super(configuration);
	}

	public RTO<PhysicalQuantity, PhysicalQuantity> format(FormatContext formatContext, Element element) throws FormatterException {
		
		RTO<PhysicalQuantity, PhysicalQuantity> result = null;
		
		Element drugQuantityElement = getSingleElement(element, "drugQuantity");
		Element timeElement = getSingleElement(element, "time");
		
		if (drugQuantityElement != null && timeElement != null) {
			PhysicalQuantity drugQuantity = parseQuantity(formatContext, drugQuantityElement, StandardDataType.PQ_DRUG);
			PhysicalQuantity time = parseQuantity(formatContext, timeElement, StandardDataType.PQ_TIME);
			// a later process will validate that the two quantities are appropriate
			Ratio<PhysicalQuantity, PhysicalQuantity> ratio = new Ratio<PhysicalQuantity, PhysicalQuantity>(drugQuantity, time);
			result = new RTOImpl<PhysicalQuantity, PhysicalQuantity>(ratio);
		} else {
			processError(formatContext, "Invalid ratio format. Both drugQuantity and time are required.", element);
		}
		return result;
	}

	private PhysicalQuantity parseQuantity(FormatContext formatContext, Element duration, StandardDataType datatype) throws FormatterException {
		PhysicalQuantityXmlFormatter formatter = new PhysicalQuantityXmlFormatter(this.configuration);
		return formatter.format(new FormatterContextImpl(datatype, null), duration).getValue();
	}
}
