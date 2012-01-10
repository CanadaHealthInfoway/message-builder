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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class DateIntervalXmlParser extends AbstractSimpleXmlParser<IVL<TS,Interval<Date>>, Interval<Date>> implements SimpleXmlParser<IVL<TS,Interval<Date>>> {
	
	private final Log log = LogFactory.getLog(getClass());
	
	private final DateXmlParser dateParser = new DateXmlParser();
	
	DateIntervalXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Interval<Date> value) throws ParserException {
		renderLowIfNecessary(builder, dataType, value);
		renderDurationIfNecessary(builder, dataType, value);
		renderHighIfNecessary(builder, dataType, value);
    }

	private void renderHighIfNecessary(StringBuilder builder, StandardDataType dataType, Interval<Date> value) throws ParserException {
		if (Representation.HIGH.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())
		 || Representation.WIDTH_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "to", dataType, value.getHigh());
		}
	}

	private void renderLowIfNecessary(StringBuilder builder, StandardDataType dataType, Interval<Date> value) throws ParserException {
		if (Representation.LOW_WIDTH.equals(value.getRepresentation())
		 || Representation.LOW.equals(value.getRepresentation())
		 || Representation.LOW_CENTER.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "from", dataType, value.getLow());
		}
	}

	private void renderDurationIfNecessary(StringBuilder builder, StandardDataType dataType, Interval<Date> value) {
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

	private void renderPartIfNecessary(StringBuilder builder, String elementName, StandardDataType dataType, Date date) throws ParserException {
		if (date!=null) {
			renderPart(builder, elementName, dataType, date);
		}
	}

	private void renderPart(StringBuilder builder, String elementName, StandardDataType dataType, Date date) throws ParserException {
		builder.append(renderDate(elementName, dataType, date));
	}

	private String renderDate(String elementName, StandardDataType dataType, Date date) throws ParserException {
		return this.dateParser.parse(new SimpleXmlParseContextImpl(elementName), createTs(extractTsDataType(dataType), date));
	}

	private TS createTs(StandardDataType dataType, Date date) {
		TSImpl ts = new TSImpl(date);
		ts.setDataType(dataType);
		return ts;
	}

	private StandardDataType extractTsDataType(StandardDataType dataType) {
		try {
			return StandardDataType.getByTypeName(dataType.getTypeName().getParameters().get(0).getUnparameterizedName());	
		} catch (Exception e) {
			this.log.error("Unable to extract TS type from " + dataType + ". Defaulting to " + StandardDataType.TS_FULLDATETIME, e);
			return StandardDataType.TS_FULLDATETIME;
		}
	}

	@Override
	protected boolean closeStartElement(IVL<TS,Interval<Date>> dataTypeInstance) {
		return false;
	}

}
