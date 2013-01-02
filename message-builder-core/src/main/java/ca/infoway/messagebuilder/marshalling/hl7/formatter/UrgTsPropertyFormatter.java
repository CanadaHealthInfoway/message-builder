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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-05-15 20:03:59 -0400 (Tue, 15 May 2012) $
 * Revision:      $LastChangedRevision: 5886 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;

@DataTypeHandler("URG<TS>")
class UrgTsPropertyFormatter extends AbstractNullFlavorPropertyFormatter<UncertainRange<Date>> {
	
	IvlTsPropertyFormatter formatter = new IvlTsPropertyFormatter();	

    @Override
	String formatNonNullValue(FormatContext context, UncertainRange<Date> value, int indentLevel) {

    	// convert URG to an IVL and use IVL formatter
    	Interval<Date> convertedInterval = IntervalFactory.createFromUncertainRange(value);
    	IVLImpl<TS, Interval<Date>> convertedHl7Interval = new IVLImpl<TS, Interval<Date>>(convertedInterval);
    	
    	FormatContext ivlContext = new FormatContextImpl(context.getType().replaceFirst("URG", "IVL"), context);
    	
		String xml = this.formatter.format(ivlContext, convertedHl7Interval, indentLevel);

		xml = changeAnyIvlRemnants(xml);
		
		// inclusive attributes not allowed for URG<TS>
		if (value.getLowInclusive() != null || value.getHighInclusive() != null) {
			context.getModelToXmlResult().addHl7Error(
				new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "High/Low inclusive fields should not be set; these attributes are not allowed for " + context.getType() + " types", context.getPropertyPath())
			);
		}
		
        return xml;
    }

	private String changeAnyIvlRemnants(String xml) {
		xml = xml.replace(" specializationType=\"IVL_", " specializationType=\"URG_");
		return xml.replace(" xsi:type=\"IVL_", " xsi:type=\"URG_");
	}

}
