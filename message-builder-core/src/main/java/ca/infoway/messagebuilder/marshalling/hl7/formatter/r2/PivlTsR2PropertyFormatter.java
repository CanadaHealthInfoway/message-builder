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

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

@DataTypeHandler("PIVL<TS>")
public class PivlTsR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<PeriodicIntervalTimeR2> {

	private static final String PHASE = "phase";
	private static final String PERIOD = "period";
	private static final String ALIGNMENT = "alignment";
	private static final String INSTITUTION_SPECIFIED = "institutionSpecified";

	private IvlTsR2PropertyFormatter ivlTsFormatter = new IvlTsR2PropertyFormatter();
	private PqR2PropertyFormatter pqFormatter = new PqR2PropertyFormatter();
	
	@Override
	protected
	String formatNonNullValue(FormatContext context, PeriodicIntervalTimeR2 value, int indentLevel) {
		// create alignment and institutionSpecified attributes
		Map<String, String> attributesMap = getAttributesMap(value);
		
		// create phase (IVL<TS>
		String phase = value.getPhase() != null ? createPhase(value, context, indentLevel + 1) : "";
		
		// create period (PQ)
		String period = value.getPeriod() != null ? createPeriod(value, context, indentLevel + 1) : "";
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, attributesMap, indentLevel, false, true));
		buffer.append(phase);
		buffer.append(period);
		buffer.append(createElementClosure(context, indentLevel, true));
		return buffer.toString();
	}

	protected Map<String, String> getAttributesMap(PeriodicIntervalTimeR2 value) {
		Map<String, String> attributesMap = new HashMap<String, String>();
		if (value.getAlignment() != null) {
			attributesMap.put(ALIGNMENT, value.getAlignment().getCalendarCycleCode());
		}
		if (value.getInstitutionSpecified() != null) {
			attributesMap.put(INSTITUTION_SPECIFIED, value.getInstitutionSpecified().toString().toLowerCase());
		}
		return attributesMap;
	}
	
	private String createPhase(PeriodicIntervalTimeR2 value, FormatContext context, int indentLevel) {
		Interval<Date> phase = value.getPhase();
		IVL_TS phaseWrapper = new IVL_TSImpl(phase == null ? null : new DateInterval(phase));
		FormatContext phaseContext = new FormatContextImpl("IVL<TS>", PHASE, context); 
		return this.ivlTsFormatter.format(phaseContext, phaseWrapper, indentLevel);
	}

	private String createPeriod(PeriodicIntervalTimeR2 value, FormatContext context, int indentLevel) {
		PhysicalQuantity period = value.getPeriod();
		FormatContext periodContext = new FormatContextImpl("PQ", PERIOD, context); 
		PQ periodWrapper = new PQImpl(period);
		return this.pqFormatter.format(periodContext, periodWrapper, indentLevel);
	}

}
