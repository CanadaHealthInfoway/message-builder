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

package ca.infoway.messagebuilder.simple.xml.parser;

import static java.lang.String.format;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.GTS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class BoundedPeriodicIntervalOfTimeXmlParser extends AbstractSimpleXmlParser<GTS, GeneralTimingSpecification> implements SimpleXmlParser<GTS> {
	
	private final DateIntervalXmlParser dateIntervalXmlParser = new DateIntervalXmlParser();
	private final PhysicalQuantityXmlParser physicalQuantityXmlParser = new PhysicalQuantityXmlParser();

	BoundedPeriodicIntervalOfTimeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, GeneralTimingSpecification value) throws ParserException {
		renderOveralTimePeriod(builder, dataType, value.getDuration());
		renderFrequency(builder, dataType, value.getFrequency());
    }

	private void renderFrequency(StringBuilder builder, StandardDataType dataType, PeriodicIntervalTime frequency) throws ParserException {
		builder.append(format("<frequency numberOfOccurrences=\"%s\">", frequency.getRepetitions()));
		builder.append(this.physicalQuantityXmlParser.parse(new SimpleXmlParseContextImpl("every"), new PQImpl(frequency.getQuantity())));
		builder.append("</frequency>");
	}

	private void renderOveralTimePeriod(StringBuilder builder, StandardDataType dataType, Interval<Date> duration) throws ParserException {
		builder.append(this.dateIntervalXmlParser.parse(
				new SimpleXmlParseContextImpl("overallTimePeriod"), 
				createIvlTs(duration)));
	}

	private IVLImpl<TS, Interval<Date>> createIvlTs(Interval<Date> duration) {
		IVLImpl<TS, Interval<Date>> ivl = new IVLImpl<TS, Interval<Date>>(duration);
		ivl.setDataType(StandardDataType.IVL_FULL_DATE);
		return ivl;
	}

	@Override
	protected boolean closeStartElement(GTS dataTypeInstance) {
		return false;
	}

}
