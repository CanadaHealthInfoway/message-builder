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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("PIVLTSCDAR1")
class PivlTsCdaPropertyFormatter implements PropertyFormatter {

	private PivlTsPropertyFormatter r1Formatter = new PivlTsPropertyFormatter();
	
	public String format(FormatContext formatContext, BareANY dataType) {
		return format(formatContext, dataType, 0);
	}

	public String format(FormatContext formatContext, BareANY dataType, int indentLevel) {
		if (dataType == null) {
			return "";
		}
		FormatContext newFormatContext = convertContext(formatContext);
		BareANY newDataType = convertDataType(dataType);
		return this.r1Formatter.format(newFormatContext, newDataType, indentLevel);
	}

	private BareANY convertDataType(BareANY dataType) {
		Object bareValue = dataType.getBareValue();
		PeriodicIntervalTimeR2 pivlR2 = (bareValue instanceof PeriodicIntervalTimeR2 ? (PeriodicIntervalTimeR2) bareValue : null);
		PeriodicIntervalTime pivlR1 = (pivlR2 == null ? null : convertPivl(pivlR2));
		
		BareANY result = new PIVLImpl();
		result.setDataType(dataType.getDataType());
		result.setBareValue(pivlR1);
		result.setNullFlavor(dataType.getNullFlavor());
		return result;
	}

	private PeriodicIntervalTime convertPivl(PeriodicIntervalTimeR2 pivlR2) {
		return PeriodicIntervalTime.createFromPivlR2(pivlR2);
	}

	private FormatContext convertContext(FormatContext formatContext) {
		return new FormatContextImpl("PIVL<TS>", formatContext);
	}
	
}
