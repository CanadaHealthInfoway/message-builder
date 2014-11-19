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
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import java.lang.reflect.Type;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.marshalling.hl7.AnyHelper;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;

/**
 * ANY (R2)
 *
 */
@DataTypeHandler("ANY")
public class AnyR2ElementParser extends AbstractSingleElementParser<Object> {

	@SuppressWarnings("rawtypes")
	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new ANYImpl();
	}

	@Override
	public BareANY parse(ParseContext context, Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		// if we have any specialization type (even with a NF), delegate control to a subparser
		// otherwise, let the ANY parser handle this
		String parentType = context == null ? null : context.getType();
		String actualType = obtainActualType(parentType, node, xmlToModelResult);
		boolean newTypeSpecified = StringUtils.isNotBlank(actualType);
		if (newTypeSpecified) {
			BareANY result = createDataTypeInstance(context != null ? getType(context) : null);
            Object value = delegateToConcreteParser(context, node, result, xmlToModelResult);
            ((BareANYImpl) result).setBareValue(value);
            return result;
		} 
		return super.parse(context, node, xmlToModelResult);
	}
	
	@Override
	protected Object parseNonNullNode(ParseContext context, Node node, BareANY hl7Result, Type returnType, XmlToModelResult xmlToModelResult)
			throws XmlToModelTransformationException {
		return delegateToConcreteParser(context, node, hl7Result, xmlToModelResult);
	}

	private Object delegateToConcreteParser(ParseContext context, Node node, BareANY hl7Result, XmlToModelResult xmlToModelResult) {
		Object result = null;
		String parentType = context == null ? null : context.getType();
		String actualType = obtainActualType(parentType, node, xmlToModelResult);
		if (StringUtils.isNotBlank(actualType)) {
			ElementParser elementParser = ParserR2Registry.getInstance().get(actualType);
			if (elementParser == null || !isValidTypeForAny(parentType, actualType)) {
				xmlToModelResult.addHl7Error(Hl7Error.createInvalidTypeError(actualType, parentType, (Element) node));
			} else {
				BareANY parsedValue = elementParser.parse(
						ParseContextImpl.create(
							actualType,
							determineReturnType(actualType, getReturnType(context)),
							context.getVersion(),
							context.getDateTimeZone(),
							context.getDateTimeTimeZone(),
							context.getConformance(), 
							context.getCardinality(),
							context.getConstraints()),
						Arrays.asList(node), 
						xmlToModelResult);
				result = parsedValue.getBareValue();

				// Yes, this is a side effect of calling this method. If we don't do this then the actual type of the ANY could be lost
				hl7Result.setDataType(parsedValue.getDataType());
				hl7Result.setNullFlavor(parsedValue.getNullFlavor());
				
				// preserve all metadata (yes, also not a great side effect); this will have to be adjusted whenever new metadata is added to a data type (extremely infrequently)
				if (hl7Result instanceof ANYMetaData && parsedValue instanceof ANYMetaData) {
					ANYMetaData anyMetaDataResult = (ANYMetaData) hl7Result;
					ANYMetaData anyMetaDataParsed = (ANYMetaData) parsedValue;
					
					anyMetaDataResult.setLanguage(anyMetaDataParsed.getLanguage());
					anyMetaDataResult.setDisplayName(anyMetaDataParsed.getDisplayName());
					anyMetaDataResult.setOriginalText(anyMetaDataParsed.getOriginalText());
					anyMetaDataResult.getTranslations().addAll(anyMetaDataParsed.getTranslations());
					anyMetaDataResult.setCdata(anyMetaDataParsed.isCdata());
					anyMetaDataResult.setOperator(anyMetaDataParsed.getOperator());
					anyMetaDataResult.setUnsorted(anyMetaDataParsed.isUnsorted());
				}
			}
		} else {
			xmlToModelResult.addHl7Error(Hl7Error.createMissingMandatoryAttributeError("xsi:type", (Element) node));
		}
		return result;
	}

	private Type determineReturnType(String actualType, Type returnType) {
		StandardDataType actualTypeTypeAsType = StandardDataType.getByTypeName(actualType);
		if (actualTypeTypeAsType != null && actualTypeTypeAsType.isCoded()) {
			// TM: could expand this to try to obtain the actual domain type using the code and code system (possibly more trouble than its worth)
			//     (this type of "lookup domain type by code system" is not currently supported; would need to watch out for multiple domains using same code system)
			//     Also: MB doesn't track code systems, though it does have an enum of some of the more common ones
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
	 * The xsi:type attribute is used to check against valid ANY types. This has a bit of "magic"
	 * involved, as the CHI specializationType notation (eg. URG_PQ) just happens to match up to our
	 * StandardDataType enum names.
	 *
	 * @param parentType
	 * @param node
	 * @param xmlToModelResult
	 * @return the actual type
	 */
	private String obtainActualType(String parentType, Node node, XmlToModelResult xmlToModelResult) {
		String actualType = null;
		String xsiType = getXsiType(node);

		if (xsiType != null) {
			String innerType = null;
			NodeList childNodes = node.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node child = childNodes.item(0);
				innerType = getXsiType(child);
				if (StringUtils.isNotBlank(innerType)) {
					break;
				}
			}
			
			if (StringUtils.isNotBlank(innerType)) {
				// the "true" type, in this case, is found by combining the outer xsi:type with the inner xsi:type
				int xsiTypeIndex = xsiType.indexOf("_");
				xsiType = (xsiTypeIndex >= 0 ? xsiType.substring(0, xsiTypeIndex) : xsiType);
				actualType = xsiType + "_" + innerType;
			} else {
				actualType = xsiType;
			}
			
			if (StringUtils.isNotBlank(actualType)) {
				actualType = convertSpecializationType(actualType);
			}
		}
		
		return actualType;
	}

}
