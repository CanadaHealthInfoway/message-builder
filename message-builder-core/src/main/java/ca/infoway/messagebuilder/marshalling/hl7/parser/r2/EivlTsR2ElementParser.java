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
 * Last modified: $LastChangedDate: 2013-03-11 18:38:50 -0400 (Mon, 11 Mar 2013) $
 * Revision:      $LastChangedRevision: 6702 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;

import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.EIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EventRelatedPeriodicIntervalTime;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.TimingEvent;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserContextImpl;

/**
 * Parses an EIVL<TS> element into a String. (R2)
 * 
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 * 
 */
@DataTypeHandler("EIVL<TS>")
class EivlTsR2ElementParser extends AbstractSingleElementParser<EventRelatedPeriodicIntervalTime> {

	private CeR2ElementParser ceR2ElementParser = new CeR2ElementParser();
	private IvlPqR2ElementParser ivlPqR2ElementParser = new IvlPqR2ElementParser();
	
	@Override
	protected EventRelatedPeriodicIntervalTime parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult result) throws XmlToModelTransformationException {
		EventRelatedPeriodicIntervalTime event = new EventRelatedPeriodicIntervalTime();
		
		handleEvent(node, event, context, result);
		
		handleOffset(node, event, context, result);
		
		if (event.isEmpty()) {
			event = null;
		}
		
		return event;
	}

	@SuppressWarnings("unchecked")
	private void handleOffset(Node node, EventRelatedPeriodicIntervalTime event, ParseContext context, XmlToModelResult result) {
		Node offsetNode = getNamedChildNode(node, "offset");
		if (offsetNode != null) {
			ParseContext newContext = ParserContextImpl.create("IVL<PQ>", context);
			BareANY parsedOffset = this.ivlPqR2ElementParser.parse(newContext, offsetNode, result);
			if (parsedOffset != null) {
				event.setOffset((Interval<PhysicalQuantity>) parsedOffset.getBareValue());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void handleEvent(Node node, EventRelatedPeriodicIntervalTime event,	ParseContext context, XmlToModelResult result) {
		Node eventNode = getNamedChildNode(node, "event");
		if (eventNode != null) {
			ParseContext newContext = ParserContextImpl.create("CE", TimingEvent.class, context);
			BareANY parsedEvent = this.ceR2ElementParser.parse(newContext, eventNode, result);
			if (parsedEvent != null) {
				event.setEvent(((CodedTypeR2<TimingEvent>) parsedEvent.getBareValue()).getCode());
			}
		}
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new EIVLImpl<EventRelatedPeriodicIntervalTime>();
	}
}