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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.hl7.AnyHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * ANY, ANY.LAB, ANY.CA.IZ, ANY.PATH
 *
 * Each value sent over the wire must correspond to one of the
 * following non-abstract data type flavor specifications defined below:
 *
 * ANY:       all types allowed
 * ANY.LAB:   CD.LAB, ST, PQ.LAB, IVL<PQ.x>, INT.NONNEG, INT.POS, TS.FULLDATETIME, URG<PQ,x>
 * ANY.CA.IZ: ST, PN.BASIC, INT.POS, BL
 * ANY.PATH:  ST, PQ, ED.DOCORREF or CD.LAB
 *
 */
@DataTypeHandler({"ANY", "ANY.LAB", "ANY.CA.IZ", "ANY.PATH"})
public class AnyElementParser extends AbstractSingleElementParser<Object> {

	@SuppressWarnings("unchecked")
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ANYImpl();
	}

	@Override
	protected Object parseNonNullNode(ParseContext context, Node node, BareANY hl7Result, Type returnType, XmlToModelResult xmlToModelResult)
			throws XmlToModelTransformationException {
		Object result = null;
		String parentType = context == null ? null : context.getType();
		String specializationType = obtainSpecializationType(parentType, node, xmlToModelResult);
		if (StringUtils.isNotBlank(specializationType)) {
			ElementParser elementParser = ParserRegistry.getInstance().get(specializationType);
			if (elementParser == null || !AnyHelper.isValidTypeForAny(parentType, specializationType)) {
				xmlToModelResult.addHl7Error(Hl7Error.createInvalidTypeError(specializationType, parentType, (Element) node));
			} else {
				BareANY parsedValue = elementParser.parse(
						ParserContextImpl.create(
							specializationType,
							getReturnType(context),
							context.getVersion(),
							context.getDateTimeZone(),
							context.getDateTimeTimeZone(),
							context.getConformance()),
						Arrays.asList(node), xmlToModelResult);
				result = parsedValue.getBareValue();

				// Yes, this is a side effect of calling this method. If we don't do this then the actual type of the ANY.LAB (i.e. PQ.LAB) is lost.
				hl7Result.setDataType(parsedValue.getDataType());
			}
		} else {
			xmlToModelResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(SPECIALIZATION_TYPE, (Element) node));
		}
		return result;
	}

	/**
	 * The specialization type attribute is used to check against valid ANY types. This has a bit of "magic"
	 * involved, as the CHI specializationType notation (eg. URG_PQ) just happens to match up to our
	 * StandardDataType enum names.
	 *
	 * @param parentType
	 * @param node
	 * @param xmlToModelResult
	 * @return the converted specializationType
	 */
	private String obtainSpecializationType(String parentType, Node node, XmlToModelResult xmlToModelResult) {
		String rawSpecializationType = getAttributeValue(node, SPECIALIZATION_TYPE);
		if (StringUtils.isBlank(rawSpecializationType)) {
			// some cases don't need "specializationType". Treat xsi:type as specializationType (internally)
			// e.g. URG_PQ, ST
			rawSpecializationType = getXsiType(node);
		}

		String result = rawSpecializationType;

		if (StringUtils.isNotBlank(rawSpecializationType) && !AnyHelper.isValidTypeForAny(parentType, rawSpecializationType)) {
			String unqualify = Hl7DataTypeName.unqualify(rawSpecializationType);
			String validType = getValidType(unqualify, parentType);
			if (validType != null) {
				result = validType;
			}
		}
		return result;
	}

	private String getValidType(String hl7Type, String parentType) {
		String result = null;
		StandardDataType dataType = EnumPattern.valueOf(StandardDataType.class, hl7Type);
		if (dataType != null) {
			if (AnyHelper.isValidTypeForAny(parentType, dataType.getType())) {
				result = dataType.getType();
			}
		}
		return result;
	}

}
