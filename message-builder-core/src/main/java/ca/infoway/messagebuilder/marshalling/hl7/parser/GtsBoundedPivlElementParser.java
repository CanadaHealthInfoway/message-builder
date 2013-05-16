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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.GTSImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Cardinality;

@DataTypeHandler("GTS.BOUNDEDPIVL")
class GtsBoundedPivlElementParser extends AbstractSingleElementParser<GeneralTimingSpecification> {

	@Override
	protected GeneralTimingSpecification parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlResult) {
		return parseNonNullNode(context, (Element) node, expectedReturnType, xmlResult);
	}
	
	protected GeneralTimingSpecification parseNonNullNode(ParseContext context, Element element, Type expectedReturnType, XmlToModelResult xmlResult) {

		GeneralTimingSpecification result = null;
		List<Element> components = findComponents(element, xmlResult);

		if (components.size() == 2) {
			Interval<Date> duration = parseDuration(context, xmlResult, components.get(0));
			PeriodicIntervalTime frequency = parseFrequency(context, xmlResult, components.get(1));

			if (duration != null && frequency != null) {
				result = new GeneralTimingSpecification(duration, frequency);
			} else {
				if (duration == null) {
					xmlResult.addHl7Error(new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR,
							"Could not parse the duration portion of the GTS.BOUNDEDPIVL",
							components.get(0)));
				}
				if (frequency == null) {
					xmlResult.addHl7Error(new Hl7Error(
							Hl7ErrorCode.DATA_TYPE_ERROR,
							"Could not parse the frequency portion of the GTS.BOUNDEDPIVL",
							components.get(1)));
				}
			}
		} else {
			xmlResult.addHl7Error(new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR,
					MessageFormat.format("Expected to find 2 <comp> sub-elements, but found {0}", components.size()),
					element));
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private Interval<Date> parseDuration(ParseContext context, XmlToModelResult xmlResult, Element durationElement) {
		ParseContext subContext = ParserContextImpl.create(
				"IVL<TS.FULLDATE>",
				Interval.class,
				context.getVersion(),
				context.getDateTimeZone(),
				context.getDateTimeTimeZone(),
				MANDATORY,
				Cardinality.create("1"));
		return (Interval<Date>) ParserRegistry.getInstance().get("IVL<TS.FULLDATE>").parse(
					subContext, Arrays.asList((Node) durationElement), xmlResult)
						.getBareValue();
	}

	private PeriodicIntervalTime parseFrequency(ParseContext context, XmlToModelResult xmlToModelResult, Element durationElement) {
		ParseContext subContext = ParserContextImpl.create(
				"PIVL<TS.DATETIME>",
				PeriodicIntervalTime.class,
				context.getVersion(),
				context.getDateTimeZone(),
				context.getDateTimeTimeZone(),
				MANDATORY,
				Cardinality.create("1"));
		return (PeriodicIntervalTime) ParserRegistry.getInstance().get("PIVL<TS.DATETIME>").parse(
					subContext, Arrays.asList((Node) durationElement), xmlToModelResult)
						.getBareValue();
	}

	private List<Element> findComponents(Element element, XmlToModelResult xmlToModelResult) {
		List<Element> result = new ArrayList<Element>();
		NodeList list = element.getChildNodes();
		int length = list == null ? 0 : list.getLength();
		for (int i = 0; i < length; i++) {
			Node node = list.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE) {
				// skip it
			} else if (StringUtils.equals("comp", NodeUtil.getLocalOrTagName((Element) node))) {
				result.add((Element) node);
			} else {
				xmlToModelResult.addHl7Error(
						new Hl7Error(
								Hl7ErrorCode.DATA_TYPE_ERROR,
								MessageFormat.format("Unexpected tag {0} in GTS.BOUNDEDPIVL", XmlDescriber.describeSingleElement((Element) node)),
								(Element) node
						)
				);
			}
		}
		return result;
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new GTSImpl();
	}
}
