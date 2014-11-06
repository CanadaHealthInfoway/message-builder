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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;

@DataTypeHandler("IVL<TS>")
class IvlTsR2PropertyFormatter implements PropertyFormatter { 

	private static IvlR2PropertyFormatter<Date> actualFormatter = new IvlR2PropertyFormatter<Date>() {
		protected Object convertValueIfNecessary(Date date) {
			return date == null ? null : new MbDate(date);
		}
	};

	public String format(FormatContext formatContext, BareANY dataType) {
		return format(formatContext, dataType, 0);
	}

	public String format(FormatContext formatContext, BareANY value, int indentLevel) {
		Object bareValue = value.getBareValue();
		Interval<Date> innerDateInterval = null;
		if (bareValue != null && bareValue instanceof DateInterval) {
			innerDateInterval = ((DateInterval) bareValue).getInterval();
		}
		BareANY newValue = new IVLImpl<TS, Interval<Date>>(Interval.class, innerDateInterval, value.getNullFlavor(), value.getDataType());
		return actualFormatter.format(formatContext, newValue, indentLevel);
	}

}
