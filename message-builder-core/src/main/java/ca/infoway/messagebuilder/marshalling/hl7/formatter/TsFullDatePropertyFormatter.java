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

import java.text.MessageFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.ArrayUtils;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.TsDateFormats;
import ca.infoway.messagebuilder.platform.DateFormatUtil;

/**
 * TS.FULLDATE - Timestamp (fully-specified date only)
 *
 * Represents a TS.FULLDATE object as an element:
 *
 * &lt;element-name value="yyyyMMdd"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TS.FULLDATE", "TS.DATE"})
public class TsFullDatePropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Date> {

    private static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    @Override
    protected String getValue(Date date, FormatContext context, BareANY bareAny) {
		TimeZone timeZone = context != null && context.getDateTimeZone() != null ? context.getDateTimeZone() : TimeZone.getDefault();
		String datePattern = determineDatePattern(date);
		validateDatePattern(datePattern, context);
		return DateFormatUtil.format(date, datePattern, timeZone);
    }
    
	private String determineDatePattern(Date date) {
		String datePattern = getPatternFromDateWithPattern(date);
		if (datePattern == null) {
			datePattern = DATE_FORMAT_YYYYMMDD;
		}
		return datePattern;
	}

	private void validateDatePattern(String datePattern, FormatContext context) {
		StandardDataType standardDataType = StandardDataType.getByTypeName(context);
		VersionNumber version = (context == null ? null : context.getVersion());
		String[] allowedDateFormats = TsDateFormats.getAllDateFormats(standardDataType, version);
		if (!ArrayUtils.contains(allowedDateFormats, datePattern)) {
			Hl7Error hl7Error = new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("Invalid date format {0} supplied for value of type {1}", datePattern, context == null ? "TS" : context.getType()));
			context.getModelToXmlResult().addHl7Error(hl7Error);
		}
	}

	private String getPatternFromDateWithPattern(Date date) {
		if (date instanceof ca.infoway.messagebuilder.datatype.lang.DateWithPattern) {
			return ((ca.infoway.messagebuilder.datatype.lang.DateWithPattern)date).getDatePattern();
		}
		return null;
	}
	
}
