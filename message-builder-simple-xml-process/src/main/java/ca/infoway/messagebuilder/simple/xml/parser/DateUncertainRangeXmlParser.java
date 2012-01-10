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

package ca.infoway.messagebuilder.simple.xml.parser;

import static java.lang.String.format;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class DateUncertainRangeXmlParser extends AbstractSimpleXmlParser<URG<TS, Date>, UncertainRange<Date>> implements SimpleXmlParser<URG<TS, Date>> {
	
	private final DateXmlParser dateParser = new DateXmlParser();

	DateUncertainRangeXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, UncertainRange<Date> value) throws ParserException {
		renderLowIfNecessary(builder, dataType, value);
		renderDurationIfNecessary(builder, dataType, value);
		renderCentreIfNecessary(builder, dataType, value);
		renderHighIfNecessary(builder, dataType, value);
    }

	private void renderHighIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<Date> value) throws ParserException {
		if (Representation.HIGH.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())
		 || Representation.WIDTH_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "to", dataType, value.getHigh());
		}
	}

	private void renderLowIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<Date> value) throws ParserException {
		if (Representation.LOW_WIDTH.equals(value.getRepresentation())
		 || Representation.LOW.equals(value.getRepresentation())
		 || Representation.LOW_CENTER.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "from", dataType, value.getLow());
		}
	}

	private void renderDurationIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<Date> value) {
		if (value.getWidth() != null
		 && (Representation.LOW_WIDTH.equals(value.getRepresentation()) 
		 || Representation.WIDTH_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_WIDTH.equals(value.getRepresentation())
		 || Representation.WIDTH.equals(value.getRepresentation()))) {
			DateDiff diff = (DateDiff) value.getWidth();
			PhysicalQuantity pq = diff.getValueAsPhysicalQuantity();
			builder.append(format("<duration value=\"%s\" unit=\"%s\"/>", pq.getQuantity(), pq.getUnit().getCodeValue()));
		}
	}

	private void renderCentreIfNecessary(StringBuilder builder, StandardDataType dataType, UncertainRange<Date> value) throws ParserException {
		if (Representation.CENTRE.equals(value.getRepresentation()) 
		 || Representation.CENTRE_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_WIDTH.equals(value.getRepresentation())
		 || Representation.LOW_CENTER.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "centre", dataType, value.getCentre());
		}
	}
	
	private void renderPartIfNecessary(StringBuilder builder, String elementName, StandardDataType dataType, Date date) throws ParserException {
		if (date!=null) {
			renderPart(builder, elementName, dataType, date);
		}
	}

	private void renderPart(StringBuilder builder, String elementName, StandardDataType dataType, Date low) throws ParserException {
		builder.append(renderDate(elementName, extractTsDataType(dataType), low));
	}

	private String renderDate(String elementName, StandardDataType dataType, Date date) throws ParserException {
		return this.dateParser.parse(new SimpleXmlParseContextImpl(elementName), createTs(dataType, date));
	}
	
	private TS createTs(StandardDataType dataType, Date date) {
		TSImpl ts = new TSImpl(date);
		ts.setDataType(dataType);
		return ts;
	}
	
	private StandardDataType extractTsDataType(StandardDataType dataType) {
		return StandardDataType.getByTypeName(dataType.getTypeName().getParameters().get(0).getUnparameterizedName());
	}

	@Override
	protected boolean closeStartElement(URG<TS, Date> dataTypeInstance) {
		return false;
	}

}
