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
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@DataTypeHandler("GTS.BOUNDEDPIVL")
class GtsBoundedPivlFormatter extends AbstractNullFlavorPropertyFormatter<GeneralTimingSpecification> {

	public final static String GTS_BOUNDED_PIVL = "GTS.BOUNDEDPIVL";

	@Override
	String formatNonNullValue(FormatContext context, GeneralTimingSpecification value, int indentLevel) throws ModelToXmlTransformationException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, createTypeAttributes(context), indentLevel, false, true));
		appendValues(buffer, value, indentLevel, context);		
		buffer.append(createElementClosure(context, indentLevel, true));
		return buffer.toString();
	}

	private Map<String, String> createTypeAttributes(FormatContext context) {
		Map<String, String> attributes = new HashMap<String, String>();
		if (requiresSpecializationType(context)) {
			attributes.put("specializationType", GTS_BOUNDED_PIVL);
		}
		attributes.put("xsi:type", "SXPR_TS");
		return attributes;
	}

	private void appendValues(StringBuffer buffer, GeneralTimingSpecification value, int indentLevel, FormatContext context) throws ModelToXmlTransformationException {
		
		Interval<Date> duration = value.getDuration();
		IVL<TS,Interval<Date>> ivlDuration = new IVLImpl<TS,Interval<Date>>(duration);
		
		IvlTsPropertyFormatter formatter = new CustomIvlTsPropertyFormatter(requiresOperatorOnFirstRepetition(context), requiresSpecializationType(context));
		
		PeriodicIntervalTime frequency = value.getFrequency();
		buffer.append(formatter.format(
				new FormatContextImpl(
						context == null ? null : context.getModelToXmlResult(), 
						context == null ? null : context.getPropertyPath(), 
						"comp", 
						"IVL<TS.FULLDATE>", 
						ConformanceLevel.MANDATORY, 
						requiresSpecializationType(context), 
						context == null ? null : context.getVersion(), 
						context == null ? null : context.getDateTimeZone(), 
						null, 
						false), 
				ivlDuration, 
				indentLevel + 1)
			);
		buffer.append(createElement(
				new FormatContextImpl(
						context == null ? null : context.getModelToXmlResult(), 
						context == null ? null : context.getPropertyPath(), 
						"comp", 
						"PIVL<TS.DATETIME>", 
						ConformanceLevel.MANDATORY, 
						requiresSpecializationType(context), 
						context == null ? null : context.getVersion(), 
						null, 
						context == null ? null : context.getDateTimeTimeZone()), 
				frequency, 
				indentLevel + 1));
	}
	
	protected String createElement(FormatContext context, PeriodicIntervalTime value, int indentLevel) throws ModelToXmlTransformationException {
		PivlTsPropertyFormatter formatter = new CustomPivlTsPropertyFormatter(!requiresOperatorOnFirstRepetition(context), requiresSpecializationType(context)); 
   		return formatter.format(context, new PIVLImpl(value), indentLevel);
	}
	
	private boolean requiresSpecializationType(FormatContext formatContext) {
		boolean result = true;
		if (formatContext != null && formatContext.getVersion() != null) {
			result = !SpecificationVersion.isVersion(SpecificationVersion.V01R04_3, formatContext.getVersion());
		}
		return result;
	}
	
	private boolean requiresOperatorOnFirstRepetition(FormatContext formatContext) {
		boolean result = false;
		if (formatContext != null && formatContext.getVersion() != null) {
			result = SpecificationVersion.isVersion(SpecificationVersion.V01R04_3, formatContext.getVersion())
				  || SpecificationVersion.isVersion(SpecificationVersion.V02R01, formatContext.getVersion())
				  || SpecificationVersion.isVersion(SpecificationVersion.V02R02, formatContext.getVersion());
		}
		return result;
	}
	
	private static class CustomPivlTsPropertyFormatter extends PivlTsPropertyFormatter {
		private final boolean requiresOperator;
		private final boolean requiresSpecializationType;

		public CustomPivlTsPropertyFormatter(boolean requiresOperator,	boolean requiresSpecializationType) {
			this.requiresOperator = requiresOperator;
			this.requiresSpecializationType = requiresSpecializationType;
		}

		@Override
		protected Map<String, String> getAttributesMap() {
			return this.requiresOperator ? toStringMap("operator", "I") : super.getAttributesMap();
		}
		
		@Override
		protected String createElement(String name,	Map<String, String> attributes, int indentLevel, boolean close,	boolean lineBreak) {
			if ("comp".equals(name) && !this.requiresSpecializationType && attributes != null) {
				attributes.put("xsi:type", "PIVL_TS");
			}
			return super.createElement(name, attributes, indentLevel, close, lineBreak);
		}
	}
	
	private static class CustomIvlTsPropertyFormatter extends IvlTsPropertyFormatter {
		private final boolean requiresOperator;
		private final boolean requiresSpecializationType;

		public CustomIvlTsPropertyFormatter(boolean requiresOperator, boolean requiresSpecializationType) {
			this.requiresOperator = requiresOperator;
			this.requiresSpecializationType = requiresSpecializationType;
		}

		@Override
		protected String createElement(String name,	Map<String, String> attributes, int indentLevel, boolean close,	boolean lineBreak) {
			if ("comp".equals(name)) {
				if (!isNullFlavor(attributes) && this.requiresOperator) {
					if (attributes == null) {
						attributes = new HashMap<String, String>();
					}
					attributes.put("operator", "I");
				}
				if (!this.requiresSpecializationType && attributes != null) {
					attributes.put("xsi:type", "IVL_TS");
				}
			}
			return super.createElement(name, attributes, indentLevel, close, lineBreak);
		}
	}	
}
