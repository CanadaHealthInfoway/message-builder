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
 * Last modified: $LastChangedDate: 2013-09-06 10:36:09 -0400 (Fri, 06 Sep 2013) $
 * Revision:      $LastChangedRevision: 7861 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EventRelatedPeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

/**
 * Event-related periodic interval of time
 */
@DataTypeHandler("EIVL<TS>")
public class EivlTsR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<EventRelatedPeriodicIntervalTime> {

	private final CeR2PropertyFormatter ceR2PropertyFormatter = new CeR2PropertyFormatter();
	private final IvlPqR2PropertyFormatter ivlPqR2PropertyFormatter = new IvlPqR2PropertyFormatter();
	
	@Override
	protected String formatNonNullValue(FormatContext context, EventRelatedPeriodicIntervalTime value, int indentLevel) {
		StringBuffer buffer = new StringBuffer();
		
		if (value != null && !value.isEmpty()) {
			buffer.append(createElement(context, null, indentLevel, false, true));
			buffer.append(handleEvent(value, context, indentLevel + 1));
			buffer.append(handleOffset(value, context, indentLevel + 1));
			buffer.append(createElementClosure(context, indentLevel, true));
		}
		
		return buffer.toString();
	}

	private String handleOffset(EventRelatedPeriodicIntervalTime value, FormatContext context, int indentLevel) {
		String result = "";
		if (value.getOffset() != null) {
			FormatContext newContext = new FormatContextImpl("IVL<PQ>", "offset", context);
			IVL<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>> ivlAny = new IVLImpl<QTY<PhysicalQuantity>, Interval<PhysicalQuantity>>();
			ivlAny.setValue(value.getOffset());
			result = this.ivlPqR2PropertyFormatter.format(newContext, ivlAny, indentLevel);
		}
		return result;
	}

	private String handleEvent(EventRelatedPeriodicIntervalTime value, FormatContext context, int indentLevel) {
		String result = "";
		if (value.getEvent() != null) {
			FormatContext newContext = new FormatContextImpl("CE", "event", context);
			CodedTypeR2<Code> codedType = new CodedTypeR2<Code>(); //Fixup for .NET
			codedType.setCode(value.getEvent());
			codedType.setCodeSystemName("TimingEvent");
			CE_R2<Code> ceAny = new CE_R2Impl<Code>(codedType);
			result = this.ceR2PropertyFormatter.format(newContext, ceAny, indentLevel);
		}
		return result;
	}
	
}
