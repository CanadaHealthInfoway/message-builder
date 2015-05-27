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
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IvlTsConstraintsHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;

@DataTypeHandler("IVL<TS>")
public class IvlTsR2PropertyFormatter implements PropertyFormatter { 

	private final IvlTsConstraintsHandler constraintsHandler = new IvlTsConstraintsHandler();
	
	private static class ActualFormatterClass extends IvlR2PropertyFormatter<MbDate> {
	}

	private static IvlR2PropertyFormatter<MbDate> actualFormatter = new ActualFormatterClass();

	public String format(FormatContext formatContext, BareANY dataType) {
		return format(formatContext, dataType, 0);
	}

	public String format(FormatContext context, BareANY value, int indentLevel) {
		if (value == null) {
			return "";
		}
		Object bareValue = value.getBareValue();
		Interval<Date> innerDateInterval = null;
		Interval<MbDate> innerMbDateInterval = null;
		if (bareValue != null && bareValue instanceof DateInterval) {
			DateInterval dateInterval = (DateInterval) bareValue;
			handleConstraints(context, context.getModelToXmlResult(), context.getPropertyPath(), dateInterval);
			innerDateInterval = dateInterval.getInterval();
			innerMbDateInterval = IntervalFactory.createMbDateInterval(innerDateInterval);
		}
		BareANY newValue = new IVLImpl<TS, Interval<MbDate>>(Interval.class, innerMbDateInterval, value.getNullFlavor(), value.getDataType());
		return actualFormatter.format(context, newValue, indentLevel);
	}

	private void handleConstraints(FormatContext context, final Hl7Errors errors, final String propertyPath, DateInterval dateInterval) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
		
		this.constraintsHandler.handleConstraints(context.getConstraints(), dateInterval, logger);
	}

}
