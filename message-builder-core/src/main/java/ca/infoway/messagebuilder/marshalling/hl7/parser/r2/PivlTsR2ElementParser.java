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
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PIVL_R2Impl;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.CalendarCycle;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;

@DataTypeHandler("PIVL<TS>")
class PivlTsR2ElementParser extends AbstractSingleElementParser<PeriodicIntervalTimeR2> {

	private IvlTsR2ElementParser ivlTsParser = new IvlTsR2ElementParser();
	private PqR2ElementParser pqParser = new PqR2ElementParser();
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PIVL_R2Impl();
	}
	
	@Override
	protected PeriodicIntervalTimeR2 parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element periodElement = (Element) getNamedChildNode(node, "period");
		PhysicalQuantity period = createPeriodType(context, periodElement, xmlToModelResult);
		
		Element phaseElement = (Element) getNamedChildNode(node, "phase");
		Interval<Date> phase = createPhaseType(context, phaseElement, xmlToModelResult);
		
		CalendarCycle alignment = obtainAlignment(context, (Element) node, xmlToModelResult);
		
		boolean institutionSpecified = obtainInstitutionSpecified(context, (Element) node, xmlToModelResult);
		
		return new PeriodicIntervalTimeR2(phase, period, alignment, institutionSpecified, null, null);
	}

	protected PhysicalQuantity createPeriodType(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		if (element == null) {
			return null;
		}
		ParseContext pqContext = ParseContextImpl.create("PQ", context);
		BareANY pqAny = this.pqParser.parse(pqContext, element, xmlToModelResult);
		return (PhysicalQuantity) pqAny.getBareValue();
	}

	protected Interval<Date> createPhaseType(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		if (element == null) {
			return null;
		}
		ParseContext ivlTsContext = ParseContextImpl.create("IVL<TS>", context);
		BareANY periodAny = this.ivlTsParser.parse(ivlTsContext, Arrays.asList((Node) element), xmlToModelResult);
		DateInterval dateInterval = (DateInterval) periodAny.getBareValue();
		return dateInterval == null ? null : dateInterval.getInterval();
	}

	private CalendarCycle obtainAlignment(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		CalendarCycle alignment = null;
		if (element.hasAttribute("alignment")) {
			String alignmentString = element.getAttribute("alignment");
			for (CalendarCycle calendarCycle : EnumPattern.values(CalendarCycle.class)) {
				if (StringUtils.equals(calendarCycle.getCalendarCycleCode(), alignmentString)) {
					alignment = calendarCycle;
					break;
				}
			}
			if (alignment == null) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Alignment attribute is not a valid CalendarCycle value. Value found: \"" + alignmentString + "\"", element));
			}
		}
		return alignment;
	}

	private boolean obtainInstitutionSpecified(ParseContext context, Element element, XmlToModelResult xmlToModelResult) {
		boolean institutionSpecified = false;
		if (element.hasAttribute("institutionSpecified")) {
			String institutionSpecifiedString = element.getAttribute("institutionSpecified");
			institutionSpecified = Boolean.parseBoolean(institutionSpecifiedString);
			if (!institutionSpecified && !"false".equalsIgnoreCase(institutionSpecifiedString)) {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "If institutionSpecified attribute is provided, it must be \"true\" or \"false\". Value found: \"" + institutionSpecifiedString + "\"", element));
			}
		}
		return institutionSpecified;
	}

}
