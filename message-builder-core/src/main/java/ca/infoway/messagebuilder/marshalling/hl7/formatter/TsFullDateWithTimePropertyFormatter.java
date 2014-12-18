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
 * Last modified: $LastChangedDate: 2012-07-16 19:39:52 -0400 (Mon, 16 Jul 2012) $
 * Revision:      $LastChangedRevision: 5975 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats.ABSTRACT_TS_IGNORE_SPECIALIZATION_TYPE_ERROR_PROPERTY_NAME;

import java.text.MessageFormat;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * TS.FULLDATEWITHTIME - Abstract TS - must be one of TS.FULLDATE or TS.FULLDATETIME
 *
 * Represents a TS.FULLDATETIME/TS.DATETIME object as an element:
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TS.FULLDATEWITHTIME"})
public class TsFullDateWithTimePropertyFormatter extends AbstractPropertyFormatter {

	private static final PropertyFormatter fullDateFormatter = new TsFullDatePropertyFormatter(); 
	private static final PropertyFormatter fullDateTimeFormatter = new TsFullDateTimePropertyFormatter(); 
	
	@Override
	public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
		StandardDataType specializationType = hl7Value.getDataType();
		
		boolean valueOmitted = hl7Value.hasNullFlavor() && hl7Value.getBareValue() == null;

		validateSpecializationType(specializationType, valueOmitted, context);
		
		PropertyFormatter formatter = fullDateTimeFormatter;
		String formatterSpecializationType = StandardDataType.TS_FULLDATETIME.getType();
		if (StandardDataType.TS_FULLDATE == specializationType) {
			formatter = fullDateFormatter;
			formatterSpecializationType = StandardDataType.TS_FULLDATE.getType();
		}
		
		return formatter.format(new FormatContextImpl(formatterSpecializationType, true, context), hl7Value, indentLevel);
	}

	private void validateSpecializationType(StandardDataType specializationType, boolean valueOmitted, FormatContext context) {
		if (specializationType == StandardDataType.TS || specializationType == null) {
			if (Boolean.valueOf(System.getProperty(ABSTRACT_TS_IGNORE_SPECIALIZATION_TYPE_ERROR_PROPERTY_NAME))) {
				// user has specified that this validation error should be suppressed
			} else if (valueOmitted) {
				// RM16399 - there are some cases where it is valid to omit a specialization type (such as when not providing a TS value)
				// do nothing; other potential errors will be caught by the default concrete TS formatter 
			} else {
				context.getModelToXmlResult().addHl7Error(
						new Hl7Error(
								Hl7ErrorCode.DATA_TYPE_ERROR, 
								MessageFormat.format("No specializationType provided. Value should be one of TS.FULLDATE / TS.FULLDATETIME / TS.FULLDATEPARTTIME. TS.FULLDATETIME will be assumed.", specializationType.getType()),
								context.getPropertyPath()
						)
				);
			}
		} else if (specializationType != StandardDataType.TS_FULLDATE && 
				   specializationType != StandardDataType.TS_FULLDATETIME &&
				   specializationType != StandardDataType.TS_FULLDATEPARTTIME) {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("Invalid specializationType: {0}. Value should be one of TS.FULLDATE / TS.FULLDATETIME / TS.FULLDATEPARTTIME. TS.FULLDATETIME will be assumed.", specializationType.getType()),
							context.getPropertyPath()
					)
			);
		}
	}
	
}
