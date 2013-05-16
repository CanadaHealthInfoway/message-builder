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

import java.lang.reflect.Type;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
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

	@SuppressWarnings("rawtypes")
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
			if (elementParser == null || !isValidTypeForAny(parentType, specializationType)) {
				xmlToModelResult.addHl7Error(Hl7Error.createInvalidTypeError(specializationType, parentType, (Element) node));
			} else {
				BareANY parsedValue = elementParser.parse(
						ParserContextImpl.create(
							specializationType,
							determineReturnType(specializationType, getReturnType(context)),
							context.getVersion(),
							context.getDateTimeZone(),
							context.getDateTimeTimeZone(),
							context.getConformance(), 
							context.getCardinality()),
						Arrays.asList(node), 
						xmlToModelResult);
				result = parsedValue.getBareValue();

				// Yes, this is a side effect of calling this method. If we don't do this then the actual type of the ANY.LAB (i.e. PQ.LAB) is lost.
				hl7Result.setDataType(parsedValue.getDataType());
				
				// preserve all metadata (yes, also not a great side effect); this will have to be adjusted whenever new metadata is added to a data type (extremely infrequently)
				((ANYImpl<?>) hl7Result).setLanguage(((ANYImpl<?>) parsedValue).getLanguage());
				((ANYImpl<?>) hl7Result).setDisplayName(((ANYImpl<?>) parsedValue).getDisplayName());
				((ANYImpl<?>) hl7Result).setOriginalText(((ANYImpl<?>) parsedValue).getOriginalText());
				((ANYImpl<?>) hl7Result).getTranslations().addAll(((ANYImpl<?>) parsedValue).getTranslations());
			}
		} else {
			xmlToModelResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(SPECIALIZATION_TYPE, (Element) node));
		}
		return result;
	}

	private Type determineReturnType(String specializationType, Type returnType) {
		if (StandardDataType.getByTypeName(specializationType).isCoded()) {
			// TODO - TM: expand this to try to obtain the actual domain type using the code and code system (possibly more trouble than its worth)
			//            (this type of "lookup domain type by code system" is not currently supported; would need to watch out for multiple domains using same code system)
			//            Also: MB doesn't track code systems, though it does have an enum of some of the more common ones
			return ANY.class;
		}
		return returnType;
	}

	private boolean isValidTypeForAny(String parentType, String specializationType) {
		if (StringUtils.isBlank(specializationType)) {
			return false;
		}
		
		boolean valid = AnyHelper.isValidTypeForAny(parentType, specializationType);
		if (!valid) {
			// unqualify only the inner types
			String innerUnqualified = Hl7DataTypeName.unqualifyInnerTypes(specializationType);
			valid = AnyHelper.isValidTypeForAny(parentType, innerUnqualified);
		}
		if (!valid) {
			// unqualify both outer and inner types)
			String bothUnqualified = Hl7DataTypeName.unqualify(specializationType);
			valid = AnyHelper.isValidTypeForAny(parentType, bothUnqualified);
		}
		return valid;
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
		String rawSpecializationType = getSpecializationType(node);
		
		if (StringUtils.isBlank(rawSpecializationType)) {
			
			// some cases don't need specialization type. Treat xsi:type as specializationType (internally)
			// e.g. URG_PQ, ST
			String xsiType = getXsiType(node);

			if (xsiType != null) {
				String innerSpecializationType = null;
				NodeList childNodes = node.getChildNodes();
				for (int i = 0; i < childNodes.getLength(); i++) {
					Node child = childNodes.item(0);
					innerSpecializationType = getSpecializationType(child);
					if (StringUtils.isNotBlank(innerSpecializationType)) {
						break;
					}
				}
				
				if (innerSpecializationType != null) {
					// the "true" specialization type, in this case, is found by combining the xsi type with the inner specialization type
					int xsiTypeIndex = xsiType.indexOf("_");
					xsiType = (xsiTypeIndex >= 0 ? xsiType.substring(0, xsiTypeIndex) : xsiType);
					rawSpecializationType = xsiType + "_" + innerSpecializationType;;
				} else {
					rawSpecializationType = xsiType;
				}
			}
			
		}
		
		if (rawSpecializationType != null && rawSpecializationType.contains("_") && rawSpecializationType.indexOf('_') == rawSpecializationType.lastIndexOf('_')) {
			rawSpecializationType = rawSpecializationType.replace("_", "<") + ">";
		}
		return rawSpecializationType;
	}

}
