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
 * Last modified: $LastChangedDate: 2014-01-09 11:56:23 -0500 (Thu, 09 Jan 2014) $
 * Revision:      $LastChangedRevision: 8280 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * TS (R2) - Timestamp
 *
 * Represents a TS object as an element:
 *
 * &lt;element-name value="yyyyMMddHHmmss"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TS
 */
@DataTypeHandler({"TSCDAR1", "SXCMTSCDAR1"})
public class TsCdaPropertyFormatter implements PropertyFormatter {

	private final TsFullDateTimePropertyFormatter tsFormatter = new TsFullDateTimePropertyFormatter();
	
	public String format(FormatContext formatContext, BareANY dataType) {
		return format(formatContext, dataType, 0);
	}

	public String format(FormatContext formatContext, BareANY dataType, int indentLevel) {
		if (dataType == null) {
			return "";
		}
		return this.tsFormatter.format(convertContext(formatContext), convertDataType(dataType), indentLevel);
	}

	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		MbDate mbDate = (bareValue instanceof MbDate ? (MbDate) bareValue : null);
		Date date = (mbDate == null ? null : mbDate.getValue());
		
		ANYImpl<Date> result = new TSImpl();
		result.setDataType(dataType.getDataType());
		result.setNullFlavor(dataType.getNullFlavor());
		result.setBareValue(date);
		result.setOperator(((ANYMetaData) dataType).getOperator());
		return result;
	}

	private FormatContext convertContext(FormatContext formatContext) {
		return new FormatContextImpl("TS", formatContext);
	}
	
}
