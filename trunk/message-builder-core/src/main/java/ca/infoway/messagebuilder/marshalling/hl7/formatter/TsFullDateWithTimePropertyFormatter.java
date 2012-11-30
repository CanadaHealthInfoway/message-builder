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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-07-16 19:39:52 -0400 (Mon, 16 Jul 2012) $
 * Revision:      $LastChangedRevision: 5975 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.text.MessageFormat;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;

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

		validateSpecializationType(specializationType, context);
		
		PropertyFormatter formatter = fullDateTimeFormatter;
		String formatterSpecializationType = StandardDataType.TS_FULLDATETIME.getType();
		if (StandardDataType.TS_FULLDATE == specializationType) {
			formatter = fullDateFormatter;
			formatterSpecializationType = StandardDataType.TS_FULLDATE.getType();
		}
		
		return formatter.format(
				new FormatContextImpl(
						context.getModelToXmlResult(), 
						context.getPropertyPath(), 
						context.getElementName(), 
						formatterSpecializationType, 
						context.getConformanceLevel(), 
						true, 
						context.getVersion(), 
						context.getDateTimeZone(), 
						context.getDateTimeTimeZone(), null), 
				hl7Value, 
				indentLevel);
	}

	private void validateSpecializationType(StandardDataType specializationType, FormatContext context) {
		if (specializationType == StandardDataType.TS) {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("No specializationType provided. Value should be TS.FULLDATE or TS.FULLDATETIME. TS.FULLDATETIME will be assumed.", specializationType.getType()),
							context.getPropertyPath()
					)
			);
		} else if (specializationType != StandardDataType.TS_FULLDATE && specializationType != StandardDataType.TS_FULLDATETIME) {
			context.getModelToXmlResult().addHl7Error(
					new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR, 
							MessageFormat.format("Invalid specializationType: {0}. Value should be TS.FULLDATE or TS.FULLDATETIME. TS.FULLDATETIME will be assumed.", specializationType.getType()),
							context.getPropertyPath()
					)
			);
		}
	}
	
}
