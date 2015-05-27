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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IvlTsConstraintsHandler;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

@DataTypeHandler("IVLTSCDAR1")
class IvlTsCdaPropertyFormatter implements PropertyFormatter {
	
	private IvlTsPropertyFormatter r1Formatter = new IvlTsPropertyFormatter();
	private final IvlTsConstraintsHandler constraintsHandler = new IvlTsConstraintsHandler();

	public String format(FormatContext formatContext, BareANY dataType) {
		return format(formatContext, dataType, 0);
	}

	public String format(FormatContext context, BareANY dataType, int indentLevel) {
		if (dataType == null) {
			return "";
		}
		
		handleConstraints(context.getConstraints(), context.getModelToXmlResult(), context.getPropertyPath(), (DateInterval) dataType.getBareValue());
		FormatContext newContext = convertContext(context);
		BareANY newDataType = convertDataType(dataType);
		return this.r1Formatter.format(newContext, newDataType, indentLevel);
	}

	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		DateInterval ivlTsR2 = (bareValue instanceof DateInterval ? (DateInterval) bareValue : null);
		Interval<Date> ivlTsR1 = (ivlTsR2 == null ? null : convertIvlTs(ivlTsR2));
		
		BareANY result = new IVLImpl<QTY<Date>, Interval<Date>>();
		result.setDataType(dataType.getDataType());
		result.setBareValue(ivlTsR1);
		result.setNullFlavor(dataType.getNullFlavor());
		return result;
	}

	private void handleConstraints(ConstrainedDatatype constraints, final Hl7Errors errors, final String propertyPath, DateInterval dateInterval) {
		ErrorLogger logger = new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, propertyPath));
			}
		};
		
		this.constraintsHandler.handleConstraints(constraints, dateInterval, logger);
	}

	private Interval<Date> convertIvlTs(DateInterval ivlTsR2) {
		return ivlTsR2 == null ? null : ivlTsR2.getInterval();
	}

	private FormatContext convertContext(FormatContext formatContext) {
		return new FormatContextImpl("IVL<TS>", formatContext);
	}
	
}
