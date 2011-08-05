/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.util.Date;
import java.util.TimeZone;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
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

    private final static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    @Override
    protected String getValue(Date date, FormatContext context) {
    	TimeZone timeZone = context != null && context.getTimeZone() != null ? context.getTimeZone() : TimeZone.getDefault();
    	return DateFormatUtil.format(date, DATE_FORMAT_YYYYMMDD, timeZone);
    }
}
