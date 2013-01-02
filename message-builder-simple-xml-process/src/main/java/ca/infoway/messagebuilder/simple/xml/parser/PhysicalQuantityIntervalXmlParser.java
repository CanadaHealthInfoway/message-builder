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

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PhysicalQuantityIntervalXmlParser extends AbstractSimpleXmlParser<IVL<PQ, Interval<PhysicalQuantity>>, Interval<PhysicalQuantity>> implements SimpleXmlParser<IVL<PQ,Interval<PhysicalQuantity>>> {
	
	private final PhysicalQuantityXmlParser physicalQuantityParser = new PhysicalQuantityXmlParser();
	
	PhysicalQuantityIntervalXmlParser() {
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, Interval<PhysicalQuantity> value) throws ParserException {
		renderLowIfNecessary(builder, dataType, value);
		renderHighIfNecessary(builder, dataType, value);
    }

	private void renderHighIfNecessary(StringBuilder builder, StandardDataType dataType, Interval<PhysicalQuantity> value) throws ParserException {
		if (Representation.HIGH.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())
		 || Representation.WIDTH_HIGH.equals(value.getRepresentation())
		 || Representation.CENTRE_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "to", dataType, value.getHigh());
		}
	}

	private void renderLowIfNecessary(StringBuilder builder, StandardDataType dataType, Interval<PhysicalQuantity> value) throws ParserException {
		if (Representation.LOW_WIDTH.equals(value.getRepresentation())
		 || Representation.LOW.equals(value.getRepresentation())
		 || Representation.LOW_CENTER.equals(value.getRepresentation())
		 || Representation.LOW_HIGH.equals(value.getRepresentation())) {
			renderPartIfNecessary(builder, "from", dataType, value.getLow());
		}
	}

	private void renderPartIfNecessary(StringBuilder builder, String elementName, StandardDataType dataType, PhysicalQuantity pq) throws ParserException {
		if (pq!=null) {
			renderPart(builder, elementName, dataType, pq);
		}
	}

	private void renderPart(StringBuilder builder, String elementName, StandardDataType dataType, PhysicalQuantity pq) throws ParserException {
		builder.append(renderPq(elementName, extractTsDataType(dataType), pq));
	}

	private String renderPq(String elementName, StandardDataType tsDateType, PhysicalQuantity pq) throws ParserException {
		return this.physicalQuantityParser.parse(new SimpleXmlParseContextImpl(elementName), new PQImpl(pq));
	}

	private StandardDataType extractTsDataType(StandardDataType dataType) {
		return StandardDataType.getByTypeName(dataType.getTypeName().getParameters().get(0).getUnparameterizedName());
	}

	@Override
	protected boolean closeStartElement(IVL<PQ, Interval<PhysicalQuantity>> dataTypeInstance) {
		return false;
	}

}
