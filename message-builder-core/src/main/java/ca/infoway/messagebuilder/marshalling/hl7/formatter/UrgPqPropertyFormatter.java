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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("URG<PQ>")
class UrgPqPropertyFormatter extends AbstractNullFlavorPropertyFormatter<UncertainRange<PhysicalQuantity>> {
	
	IvlPqPropertyFormatter formatter = new IvlPqPropertyFormatter();	

    @Override
	String formatNonNullValue(FormatContext context, UncertainRange<PhysicalQuantity> value, int indentLevel) throws ModelToXmlTransformationException {

    	// convert URG to an IVL and use IVL formatter (loses any inclusive info; we'll pull that out later)
    	Interval<PhysicalQuantity> convertedInterval = IntervalFactory.createFromUncertainRange(value);
    	IVLImpl<PQ, Interval<PhysicalQuantity>> convertedHl7Interval = new IVLImpl<PQ, Interval<PhysicalQuantity>>(convertedInterval);
    	
    	FormatContext ivlContext = new FormatContextImpl(context.getType().replaceFirst("URG", "IVL"), context);
    	
		String xml = this.formatter.format(ivlContext, convertedHl7Interval, indentLevel);
    	
		xml = changeAnyIvlRemnants(xml);

		// add in inclusive attributes if necessary
		if (value.getLowInclusive() != null) {
			xml = addInclusiveAttribute(xml, "low", value.getLowInclusive());
		}
		if (value.getHighInclusive() != null) {
			xml = addInclusiveAttribute(xml, "high", value.getHighInclusive());
		}
		
        return xml;
    }

	private String addInclusiveAttribute(String xml, String elementName, boolean inclusive) {
		String searchString = "<" + elementName + " ";
		int elementIndex = xml.indexOf(searchString);
		if (elementIndex >= 0) {
			String first = xml.substring(0, elementIndex + searchString.length());
			String last = xml.substring(elementIndex + searchString.length());
			xml = first + "inclusive=\"" + inclusive + "\" " + last;
		}
		return xml;
	}

	private String changeAnyIvlRemnants(String xml) {
		xml = xml.replace(" specializationType=\"IVL_", " specializationType=\"URG_");
		return xml.replace(" xsi:type=\"IVL_", " xsi:type=\"URG_");
	}
}
