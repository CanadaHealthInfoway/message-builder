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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeSk;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@DataTypeHandler("PIVL<TS>")
class PivlTsPropertyFormatter extends AbstractNullFlavorPropertyFormatter<PeriodicIntervalTime> {

	private static final String FREQUENCY = "frequency";
	private static final String UNIT = "unit";
	private static final String VALUE = "value";
	private static final String PERIOD = "period";
	private static final String PHASE = "phase";

	private PropertyFormatter intNonNegPropertyFormatter = new IntNonNegPropertyFormatter();
	private PropertyFormatter ivlPqPropertyFormatter = new IvlPqPropertyFormatter();
	
	@Override
	String formatNonNullValue(FormatContext context, PeriodicIntervalTime value, int indentLevel) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, getAttributesMap(), indentLevel, false, true));
		appendIntervalBounds(value, buffer, indentLevel + 1, context);
		buffer.append(createElementClosure(context, indentLevel, true));
		return buffer.toString();
	}

	// leave this as-is in case subclasses need to provide extra attributes (such as GTS.BOUNDEDPIVL)
	protected Map<String, String> getAttributesMap() {
		return null;
	}
	
	private void appendIntervalBounds(PeriodicIntervalTime value, StringBuffer buffer, int indentLevel, FormatContext context) {
		String period = createPeriodElement(value.getPeriod(), indentLevel, context);
		String phase = createPhaseElement(value.getPhase(), context.getPropertyPath(), indentLevel, context.getModelToXmlResult());

		switch (value.getRepresentation()) {
		case PERIOD:
			buffer.append(period);
			break;
		case PHASE:
			buffer.append(phase);
			break;
		case PERIOD_PHASE:
			buffer.append(period);
			buffer.append(phase);
			break;
		case FREQUENCY:
			// Change for Saskatchewan
			boolean isSask = SpecificationVersion.isExactVersion(SpecificationVersion.V01R04_2_SK, context != null ? context.getVersion() : null);
			if (isSask && value instanceof PeriodicIntervalTimeSk) {
				buffer.append(createFrequencyElementForSk(FREQUENCY, value.getRepetitions(), ((PeriodicIntervalTimeSk) value).getQuantitySk(), indentLevel, context));
			} else {
				buffer.append(createFrequencyElement(value.getRepetitions(), value.getQuantity(), indentLevel, context));
			}

			break;
		default:
			// removed "break" to correct c# translation
		}
	}

	private String createFrequencyElementForSk(String name, Integer repetitions, Interval<PhysicalQuantity> quantity, int indentLevel, FormatContext context) {
		String result = "";
		if (repetitions != null && quantity != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(createElement(name, null, indentLevel, false, true));
			appendSk(buffer, repetitions, quantity, indentLevel + 1, context);
			buffer.append(XmlRenderingUtils.createEndElement(name, indentLevel, true));
			result = buffer.toString();
		} else {
			createMissingFrequencyFieldsError(context);
		}
		return result;
	}

	private void appendSk(StringBuffer buffer, Integer repetitions, Interval<PhysicalQuantity> quantity, int indentLevel, FormatContext context) {
		INTImpl intImpl = new INTImpl(repetitions);
		FormatContextImpl formatContext = new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "numerator", "INT.NONNEG", ConformanceLevel.MANDATORY, context.isSpecializationType(), context.getVersion(), null, null);
		buffer.append(
				this.intNonNegPropertyFormatter.format(formatContext, intImpl, indentLevel)
			);
		
		IVLImpl<PQ, Interval<PhysicalQuantity>> ivlImpl = new IVLImpl<PQ, Interval<PhysicalQuantity>>(quantity);
		formatContext = new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "denominator", "IVL<PQ.BASIC>", ConformanceLevel.MANDATORY, context.isSpecializationType(), context.getVersion(), null, null);
		buffer.append(
				this.ivlPqPropertyFormatter.format(formatContext, ivlImpl, indentLevel)
			);
	}
	
	/**
	 * This is the code that will be called for all current (CeRx, MR2007, MR2009) pan-Canadian standard usage of PIVL (PIVL<TS.DATETIME> to be exact) 
	 * 
	 * @param repetitions
	 * @param quantity
	 * @param indentLevel
	 * @param context
	 * @return
	 */
	private String createFrequencyElement(Integer repetitions, PhysicalQuantity quantity, int indentLevel, FormatContext context) {
		String result = "";
		if (repetitions != null && quantity != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(createElement(FREQUENCY, null, indentLevel, false, true));
			formatFrequency(buffer, repetitions, quantity, indentLevel + 1, context);
			buffer.append(XmlRenderingUtils.createEndElement(FREQUENCY, indentLevel, true));
			result = buffer.toString();
		} else {
			createMissingFrequencyFieldsError(context);
		}
		return result;
	}

	private void createMissingFrequencyFieldsError(FormatContext context) {
		context.getModelToXmlResult().addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR, 
						"Both repetitions and quantity must be non-null for values of type PIVL<TS.DATETIME>")
		);
	}

	private void formatFrequency(StringBuffer buffer, Integer repetitions, PhysicalQuantity quantity, int indentLevel, FormatContext context) {
		FormatContext formatContext = new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "numerator", "INT.NONNEG", ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null);
		buffer.append(
				this.intNonNegPropertyFormatter.format(formatContext, new INTImpl(repetitions), indentLevel)
			);
		
		Map<String, String> tempAttributes = getAttributes(new DateDiff(quantity), context);
		String value = tempAttributes.get(PqPropertyFormatter.ATTRIBUTE_VALUE);
		String units = tempAttributes.get(PqPropertyFormatter.ATTRIBUTE_UNIT);
		Map<String, String> attributes = toStringMap(VALUE, value, UNIT, units);
		
		context = new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "denominator", "PQ.TIME", ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null);
		buffer.append(
				createElement(context, attributes, indentLevel, true, true)
			);
	}

	private String createPeriodElement(DateDiff period, int indentLevel, FormatContext context)  {
		if (period != null) {
			
			Map<String, String> tempAttributes = getAttributes(period, context);
			String value = tempAttributes.get(PqPropertyFormatter.ATTRIBUTE_VALUE);
			String units = tempAttributes.get(PqPropertyFormatter.ATTRIBUTE_UNIT);
			
			Map<String, String> attributes = toStringMap(VALUE, value, UNIT, units);
			
			return createElement(PERIOD, attributes, indentLevel, true, true);
		}
		return "";
	}

	private String createPhaseElement(Interval<Date> phase, String propertyPath, int indentLevel, ModelToXmlResult result) {
		if (phase != null) {
			return new IvlTsPropertyFormatter().format(
					new FormatContextImpl(result, propertyPath, PHASE, "IVL<TS.FULLDATE>", null),
					new IVLImpl<TS, Interval<Date>>(phase), 
					indentLevel);
		}
		return "";
	}

	private Map<String, String> getAttributes(DateDiff period, FormatContext context) {
		PhysicalQuantity quantity = period.getValueAsPhysicalQuantity();
		FormatContext newContext = new FormatContextImpl("PQ.TIME", context);
		// getAttributeNameValuePairs is never called with a null value; directly calling it from here is a bit of a cheat, so ensure no null passed in
		return quantity == null ? new HashMap<String, String>() : new PqPropertyFormatter().getAttributeNameValuePairs(newContext, quantity, null);
	}

}
