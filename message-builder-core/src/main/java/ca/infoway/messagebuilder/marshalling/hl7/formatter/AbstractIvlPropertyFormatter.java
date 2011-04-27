/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.QTYImpl;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Representation;

/**
 * IVL - Interval
 *
 * Represents an Interval object as an element:
 *
 * &lt;value&gt;
 *   &lt;low value='2'/&gt;
 *   &lt;high value='4'/&gt;
 * &lt;/value&gt;
 *
 * or:
 *
 * &lt;value&gt;
 *   &lt;width unit="d" value="15"/&gt;
 * &lt;/value&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would
 * look like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-IVL
 */
public abstract class AbstractIvlPropertyFormatter<T> extends AbstractNullFlavorPropertyFormatter<Interval<T>> {
	
	protected static final String UNIT = "unit";
	protected static final String WIDTH = "width";
	protected static final String CENTRE = "center";
	protected static final String HIGH = "high";
	protected static final String LOW = "low";
	protected static final String VALUE = "value";

	@Override
	String formatNonNullValue(FormatContext context, Interval<T> value, int indentLevel) throws ModelToXmlTransformationException {
		StringBuffer buffer = new StringBuffer();
		if (value.getRepresentation() == Representation.SIMPLE) {
			buffer.append(createElement(context, context.getElementName(), new QTYImpl<T>(value.getValue()), indentLevel));
		} else {
			buffer.append(createElement(context, null, indentLevel, false, true));
			appendIntervalBounds(context, value, buffer, indentLevel + 1);
			buffer.append(createElementClosure(context, indentLevel, true));
		}
		return buffer.toString();
	}

	private void appendIntervalBounds(FormatContext context, Interval<T> value, StringBuffer buffer, int indentLevel)
			throws ModelToXmlTransformationException {
		String low = createElement(context, LOW, new QTYImpl<T>(value.getLow()), indentLevel);
		String high = createElement(context, HIGH, new QTYImpl<T>(value.getHigh()), indentLevel);
		String centre = createElement(context, CENTRE, new QTYImpl<T>(value.getCentre()), indentLevel);
		String width = createWidthElement(context, WIDTH, value.getWidth(), indentLevel);

		switch (value.getRepresentation()) {
		case LOW_HIGH:
			buffer.append(low);
			buffer.append(high);
			break;
		case CENTRE:
			buffer.append(centre);
			break;
		case HIGH:
			buffer.append(high);
			break;
		case LOW:
			buffer.append(low);
			break;
		case WIDTH:
			buffer.append(width);
			break;
		case LOW_WIDTH:
			buffer.append(low);
			buffer.append(width);
			break;
		case WIDTH_HIGH:
			buffer.append(width);
			buffer.append(high);
			break;
		case CENTRE_WIDTH:
			buffer.append(centre);
			buffer.append(width);
			break;
		default:
		}
	}

	protected abstract String createWidthElement(FormatContext context, String name, BareDiff diff, int indentLevel) throws ModelToXmlTransformationException;
	protected abstract String createElement(FormatContext context, String name, QTY<T> value, int indentLevel) throws ModelToXmlTransformationException;
}
