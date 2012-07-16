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
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * PIVL - Periodic Interval of Time
 *
 * An interval of time that recurs periodically. Periodic intervals have two
 * properties, phase and period. The phase specifies the "interval prototype"
 * that is repeated every period.
 *
 *
 * &lt;effectiveTime xsi:type='PIVL_TS'&gt;
 *   &lt;phase&gt;
 *      &lt;low value='198709'/&gt;
 *      &lt;high value='198710'/&gt;
 *   &lt;/phase&gt;
 *   &lt;period value='1' unit='a'/&gt;
 * &lt;/effectiveTime&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PIVL
 */
abstract class AbstractPivlPropertyFormatter extends AbstractNullFlavorPropertyFormatter<PeriodicIntervalTime> {

	private static final String FREQUENCY = "frequency";
	private static final String UNIT = "unit";
	private static final String VALUE = "value";
	private static final String PERIOD = "period";
	private static final String PHASE = "phase";

	@Override
	String formatNonNullValue(FormatContext context, PeriodicIntervalTime value, int indentLevel)
			throws ModelToXmlTransformationException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, getAttributesMap(), indentLevel, false, true));
		appendIntervalBounds(value, buffer, indentLevel + 1, context);
		buffer.append(createElementClosure(context, indentLevel, true));
		return buffer.toString();
	}

	protected Map<String, String> getAttributesMap() {
		return null;
	}

	private void appendIntervalBounds(PeriodicIntervalTime value, StringBuffer buffer, int indentLevel, FormatContext context)
			throws ModelToXmlTransformationException {
		String period = createElement(PERIOD, value.getPeriod(), indentLevel);
		String phase = createElement(context.getModelToXmlResult(), context.getPropertyPath(), PHASE, value.getPhase(), indentLevel);

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
			boolean isSask = SpecificationVersion.isVersion(SpecificationVersion.V01R04_2_SK, context != null ? context.getVersion() : null);
			if (isSask) {
				if (value instanceof PeriodicIntervalTimeSk) {
					buffer.append(createElementSk(FREQUENCY, value.getRepetitions(), ((PeriodicIntervalTimeSk) value).getQuantitySk(), indentLevel, context));
				}
			} else {
				buffer.append(createElement(FREQUENCY, value.getRepetitions(), value.getQuantity(), indentLevel, context));
			}

			break;
		default:
			// removed "break" to correct c# translation
		}
	}

	private String createElementSk(String name, Integer repetitions, Interval<PhysicalQuantity> quantity, int indentLevel, FormatContext context)
			throws ModelToXmlTransformationException {
		if (repetitions != null && quantity != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(createElement(name, null, indentLevel, false, true));
			appendSk(buffer, repetitions, quantity, indentLevel + 1, context);
			buffer.append(XmlRenderingUtils.createEndElement(name, indentLevel, true));
			return buffer.toString();
		}
		return null;
	}

	private void appendSk(StringBuffer buffer, Integer repetitions, Interval<PhysicalQuantity> quantity, int indentLevel, FormatContext context)
			throws ModelToXmlTransformationException {
		String type = "INT.NONNEG";
		String ivlPqType = "IVL<PQ>";

		PropertyFormatter intFormatter = FormatterRegistry.getInstance().get(type);
		PropertyFormatter ivlPqFormatter = FormatterRegistry.getInstance().get(ivlPqType);
		
		if (intFormatter != null && ivlPqFormatter != null) {
			buffer.append(intFormatter.format(
					new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "numerator", type, ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null), new INTImpl(repetitions), indentLevel));
			IVLImpl<PQ, Interval<PhysicalQuantity>> ivlImpl = new IVLImpl<PQ, Interval<PhysicalQuantity>>(quantity);
			buffer.append(ivlPqFormatter.format(
					new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "denominator", ivlPqType, ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null), ivlImpl, indentLevel));
		} else {
			throw new ModelToXmlTransformationException("No formatter found for " + (type == null ? type : ivlPqType));
		}
}
	
	
	private String createElement(String name, Integer repetitions, PhysicalQuantity quantity, int indentLevel, FormatContext context) 
			throws ModelToXmlTransformationException {
		if (repetitions != null && quantity != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(createElement(name, null, indentLevel, false, true));
			append(buffer, repetitions, quantity, indentLevel + 1, context);
			buffer.append(XmlRenderingUtils.createEndElement(name, indentLevel, true));
			return buffer.toString();
		}
		return null;
	}

	private void append(StringBuffer buffer, Integer repetitions, PhysicalQuantity quantity, int indentLevel, FormatContext context)
			throws ModelToXmlTransformationException {
		String type = "INT.NONNEG";
    	PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
    	if (formatter != null) {
    		buffer.append(formatter.format(
    				new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "numerator", type, ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null), new INTImpl(repetitions), indentLevel));
    		Map<String, String> attributes = toStringMap(VALUE, format(new DateDiff(quantity)), UNIT, getUnits(new DateDiff(quantity)));
    		buffer.append(createElement(new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), "denominator", "PQ.TIME", ConformanceLevel.MANDATORY, context.isSpecializationType(), null, null, null), attributes, indentLevel, true, true));
    	} else {
    		throw new ModelToXmlTransformationException("No formatter found for " + type);
    	}
	}

	private String createElement(String name, DateDiff period, int indentLevel) throws ModelToXmlTransformationException {
		if (period != null) {
			Map<String, String> attributes = toStringMap(VALUE, format(period), UNIT, getUnits(period));
			return createElement(name, attributes, indentLevel, true, true);
		}
		return null;
	}

	private String createElement(ModelToXmlResult result, String propertyPath, String name, Interval<Date> phase, int indentLevel)
			throws ModelToXmlTransformationException {
		if (phase != null) {
			return new IvlTsPropertyFormatter().format(
					new FormatContextImpl(result, propertyPath, name, "IVL<TS.FULLDATE>", null),
					new IVLImpl<TS, Interval<Date>>(phase), 
					indentLevel);
		}
		return null;
	}

	protected abstract String format(DateDiff diff) throws ModelToXmlTransformationException;

	protected abstract String getUnits(DateDiff diff) throws ModelToXmlTransformationException;
}
