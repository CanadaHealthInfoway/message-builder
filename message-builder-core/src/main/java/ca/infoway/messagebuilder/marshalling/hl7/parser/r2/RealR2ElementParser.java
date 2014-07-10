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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;

/**
 * REAL - BigDecimal (R2)
 * 
 * Parses an REAL element into a BigDecimal. The element looks like this:
 * 
 * <element-name value="0.1234" />
 * 
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-REAL
 * 
 */
@DataTypeHandler("REAL")
class RealR2ElementParser extends AbstractSingleElementParser<BigDecimal>{

	@Override
	protected BigDecimal parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		validateNoChildren(context, node);
		BigDecimal result = null;

		String unparsedReal = getAttributeValue(node, "value");
		validateDecimal(unparsedReal, context.getType(), xmlToModelResult, (Element) node);
		if (unparsedReal != null) {
			try {
				result = new BigDecimal(unparsedReal);
			} catch (NumberFormatException e) {
				recordInvalidNumberError(context, node, xmlToModelResult, unparsedReal);
			}
		}
		return result;
	}

	private void validateDecimal(String value, String type, XmlToModelResult result, Element element) {
		// check that value is a valid decimal?? i.e. value isn't some weird combinations of characters that might lead to a valid BigDecial (such as a hex value)
		if (StringUtils.isBlank(value)) {
			recordValueMustBeSpecifiedError(result, element);
		}
	}

	private void recordValueMustBeSpecifiedError(XmlToModelResult result, Element element) {
		result.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value must be specified", element));
	}

	private void recordInvalidNumberError(ParseContext context, Node node, XmlToModelResult xmlToModelResult, String unparsedReal) {
		xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, "Value \"" + unparsedReal + "\" of type " + context.getType() + " is not a valid number", (Element) node));
	}
	
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new REALImpl();
	}
}
