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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("URG<PQ>")
class UrgPqPropertyFormatter extends AbstractNullFlavorPropertyFormatter<UncertainRange<PhysicalQuantity>> {
	
	IvlPqPropertyFormatter formatter = new IvlPqPropertyFormatter();	

	@Override
	protected
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) {
		
		@SuppressWarnings("unchecked")
		UncertainRange<PhysicalQuantity> value = (UncertainRange<PhysicalQuantity>) dataType.getBareValue();
		
    	// convert URG to an IVL and use IVL formatter (loses any inclusive info; we'll pull that out later)
    	Interval<PhysicalQuantity> convertedInterval = IntervalFactory.createFromUncertainRange(value);
    	IVLImpl<PQ, Interval<PhysicalQuantity>> convertedHl7Interval = new IVLImpl<PQ, Interval<PhysicalQuantity>>(convertedInterval);
    	
    	FormatContext ivlContext = new FormatContextImpl(context.getType().replace("URG", "IVL"), context.isSpecializationType(), context);
    	
		String xml = this.formatter.format(ivlContext, convertedHl7Interval, indentLevel);
    	
		xml = changeAnyIvlRemnants(xml);

		xml = addOriginalText(xml, dataType, indentLevel);
		
		// add in inclusive attributes if necessary
		if (value.getLowInclusive() != null) {
			xml = addInclusiveAttribute(xml, "low", value.getLowInclusive());
		}
		if (value.getHighInclusive() != null) {
			xml = addInclusiveAttribute(xml, "high", value.getHighInclusive());
		}
		
        return xml;
	}

	private String addOriginalText(String xml, BareANY dataType, int indentLevel) {
		// TM - RM20416: R2 URG<PQ> now has an explicit OT element (as opposed to being within the inner PQ.LAB)
		String originalText = ((ANYMetaData) dataType).getOriginalText();
		if (StringUtils.isNotBlank(originalText)) {
			String otElement = createElement("originalText", null, indentLevel + 1, false, false);
			otElement += XmlStringEscape.escape(originalText);
			otElement += createElementClosure("originalText", 0, false);
			int indexOf = xml.indexOf(">");
			xml = xml.substring(0, indexOf + 2) + otElement + xml.substring(indexOf + 2);					
		}
		return xml;
	}
	
    @Override
	protected
	String formatNonNullValue(FormatContext context, UncertainRange<PhysicalQuantity> value, int indentLevel) {
    	// unused
		throw new UnsupportedOperationException();
    }

	private String addInclusiveAttribute(String xml, String elementName, Boolean inclusive) {
		String searchString = "<" + elementName + " ";
		int elementIndex = xml.indexOf(searchString);
		if (elementIndex >= 0) {
			String first = xml.substring(0, elementIndex + searchString.length());
			String last = xml.substring(elementIndex + searchString.length());
			xml = first + "inclusive=\"" + inclusive.toString().toLowerCase() + "\" " + last;
		}
		return xml;
	}

	private String changeAnyIvlRemnants(String xml) {
		xml = xml.replace(" specializationType=\"IVL_", " specializationType=\"URG_");
		return xml.replace(" xsi:type=\"IVL_", " xsi:type=\"URG_");
	}
}
