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

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.POPULATED;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

@DataTypeHandler("IVL")
abstract class IvlElementParser<T> extends AbstractIvlElementParser<T> {

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return GenericDataTypeFactory.create(typeName);
	}
	
	@Override
	protected BareANY createType(ParseContext context, Element element, XmlToModelResult parseResult) 
			throws ParseException, XmlToModelTransformationException {
		String type = getParameterizedType(context);
		ElementParser parser = ParserRegistry.getInstance().get(type);
		
		if (parser != null) {
			return parser.parse(ParserContextImpl.create(type, null, context.getVersion(), MANDATORY), 
					Arrays.asList((Node) element), parseResult);
		} else {
			parseResult.addHl7Error(new Hl7Error(
					Hl7ErrorCode.DATA_TYPE_ERROR, 
					MessageFormat.format("Cannot find a parser for type {0}", type),
					element));
			return null;
		}
	}

	private String getParameterizedType(ParseContext context) {
		return Hl7DataTypeName.getParameterizedType(context.getType());
	}

	@Override
	BareDiff createDiffType(ParseContext context, Element width,
			XmlToModelResult xmlToJavaResult) throws ParseException,
			XmlToModelTransformationException {
		
		if (isTimestampType(context)) {
			return createDateDiff(context, width, xmlToJavaResult);
		} else {
			return super.createDiffType(context, width, xmlToJavaResult);
		}
	}

	private Diff<Date> createDateDiff(ParseContext context, Element width, XmlToModelResult xmlToJavaResult) {

		Diff<Date> result = null;
        if (getAttributeValue(width, NullFlavorHelper.NULL_FLAVOR_ATTRIBUTE_NAME) != null) {
            result = parseNullWidthNode(width);
        } else {
		
			StandardDataType type = StandardDataType.getByTypeName(context);
			try {
				StandardDataType diffType = getWidthType(type);
				ElementParser parser = ParserRegistry.getInstance().get(diffType);
	
				if (parser != null) {
					ParseContext subContext = ParserContextImpl.create(
							diffType.getType(), PhysicalQuantity.class, 
							context.getVersion(), POPULATED);
					PhysicalQuantity quantity = (PhysicalQuantity) parser.parse(
							subContext, Arrays.asList((Node) width), xmlToJavaResult).getBareValue();
					
					if (quantity != null && quantity.getQuantity() != null && quantity.getUnit() != null) {
						result = new DateDiff(quantity);
					}
				} else {
					xmlToJavaResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, 
							"Cannot find a parser for " + diffType.getType(), width));
				}
				
			} catch (XmlToModelTransformationException e) {
				xmlToJavaResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, e.getMessage(), width));
			}
        }
        return result;
    }

	private StandardDataType getWidthType(StandardDataType type) {
		try {
			return StandardDataType.getWidthType(type);
		} catch (IllegalArgumentException e) {
			return StandardDataType.PQ_TIME;
		}
	}
    
    private Diff<Date> parseNullWidthNode(Element width) {
        String nullFlavor = width.getAttribute(NullFlavorHelper.NULL_FLAVOR_ATTRIBUTE_NAME);
        return new DateDiff(CodeResolverRegistry.lookup(NullFlavor.class, nullFlavor));
    }

	private boolean isTimestampType(ParseContext context) {
		String type = getParameterizedType(context);
		return "TS".equals(Hl7DataTypeName.unqualify(type));
	}

}
