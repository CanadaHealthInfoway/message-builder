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
 * Last modified: $LastChangedDate: 2013-05-16 19:07:23 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6875 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static ca.infoway.messagebuilder.error.Hl7ErrorCode.DATA_TYPE_ERROR;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.POPULATED;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.IvlValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.AbstractSingleElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.NullFlavorHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContext;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParseContextImpl;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;
import ca.infoway.messagebuilder.xml.Cardinality;

/**
 * IVL - Interval (R2)
 * 
 * Parses an IVL element into a Interval. The element looks like this:
 * 
 * <value>
 *   <low value='2'/>
 *   <high value='4'/>
 * </value>
 *
 * or:
 * 
 * <value>
 *   <width unit="d" value="15"/>
 * </value>
 * 
 * or (confusingly):
 *
 * <value value='2' />  // "simple" interval
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-IVL
 */
abstract class IvlR2ElementParser<T> extends AbstractSingleElementParser<Interval<T>> {

	private IvlValidationUtils ivlValidationUtils;
	private final boolean isUncertainRange;
	
	public IvlR2ElementParser() {
		this(false);
	}
	
	public IvlR2ElementParser(boolean isUncertainRange) {
		this.isUncertainRange = isUncertainRange;
		this.ivlValidationUtils = new IvlValidationUtils(this.isUncertainRange);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected Interval<T> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {

		Interval<T> result = null;
		
		Element low = (Element) getNamedChildNode(node, "low");
		Element high = (Element) getNamedChildNode(node, "high");
		Element center = (Element) getNamedChildNode(node, "center");
		Element width = (Element) getNamedChildNode(node, "width");

		validateCorrectElementsProvided(low != null, high != null, center != null, width != null, (Element) node, context, xmlToModelResult);
		
		BareANY lowAny = low == null ? null : createType(context, low, xmlToModelResult, false);
		Object lowType = extractValue(lowAny);
		Boolean lowInclusive = extractInclusive(context, low, xmlToModelResult);
		
		BareANY highAny = high == null ? null : createType(context, high, xmlToModelResult, false);
		Object highType = extractValue(highAny);
		Boolean highInclusive = extractInclusive(context, high, xmlToModelResult);
		
		BareANY centerAny = center == null ? null : createType(context, center, xmlToModelResult, false);
		Object centerType = extractValue(centerAny);
		
		BareDiff widthType = width == null ? null : createDiffType(context, width, xmlToModelResult);

		if (lowAny != null && highAny != null) {
			result = IntervalFactory.<T>createLowHigh((T) lowType, (T) highType, lowAny.getNullFlavor(), highAny.getNullFlavor());
		} else if (lowAny != null && widthType != null) {
			result = IntervalFactory.<T>createLowWidth((T)lowType, (Diff<T>) widthType, lowAny.getNullFlavor());
		} else if (highAny != null && widthType != null) {
			result = IntervalFactory.<T>createWidthHigh((Diff<T>) widthType, (T) highType, highAny.getNullFlavor());
		} else if (centerAny != null && widthType != null) {
			result = IntervalFactory.<T>createCentreWidth((T) centerType, (Diff<T>) widthType, centerAny.getNullFlavor());
		} else if (centerAny != null && lowAny != null) {
			result = IntervalFactory.<T>createLowCentre((T) lowType, (T) centerType, lowAny.getNullFlavor(), centerAny.getNullFlavor());
		} else if (centerAny != null && highAny != null) {
			result = IntervalFactory.<T>createCentreHigh((T) centerType, (T) highType, centerAny.getNullFlavor(), highAny.getNullFlavor());
		} else if (lowAny != null) {
			result = IntervalFactory.<T>createLow((T) lowType, lowAny.getNullFlavor());
		} else if (highAny != null) {
			result = IntervalFactory.<T>createHigh((T) highType, highAny.getNullFlavor());
		} else if (centerAny != null) {
			result = IntervalFactory.<T>createCentre((T) centerType, centerAny.getNullFlavor());
		} else if (widthType != null) {
			result = IntervalFactory.<T>createWidth((Diff<T>)widthType);
		} else {
			if (low == null && high == null && center == null && width == null) {
				// only treat this as a "simple" interval if no other interval elements were provided (even if they were in error)
				// try to parse a "simple" interval
				BareANY simpleAny = createType(context, (Element) node, xmlToModelResult, true);
				Object type = extractValue(simpleAny);
				if (type == null) {
		        	xmlToModelResult.addHl7Error(
		        			new Hl7Error(
		        					Hl7ErrorCode.SYNTAX_ERROR, 
		        					"\"Simple interval node: " + XmlDescriber.describePath(node) + " does not allow a null value\"",
		        					(Element) node));
				} else {
					result = IntervalFactory.<T>createSimple((T) type, ((ANYMetaData) simpleAny).getOperator());
				}
			}
		}
		if (result != null) {
			result.setLowInclusive(lowInclusive);
			result.setHighInclusive(highInclusive);
		}
		
		return result;
	}

	// subclasses may want to override this functionality
	protected Object extractValue(BareANY any) {
		return any == null ? null : any.getBareValue();
	}

	private Boolean extractInclusive(ParseContext context, Element element,	XmlToModelResult xmlToModelResult) {
		Boolean inclusive = null;
		if (element != null) {
			String inclusiveString = getAttributeValue(element, "inclusive");
			inclusive = inclusiveString == null ? true : Boolean.valueOf(inclusiveString);
		}
		return inclusive;
	}

	private void validateCorrectElementsProvided(boolean lowProvided, boolean highProvided, boolean centerProvided, boolean widthProvided, Element element, ParseContext context, XmlToModelResult xmlToModelResult) {
		List<String> errors = ivlValidationUtils.validateCorrectElementsProvidedForR2(lowProvided, highProvided, centerProvided, widthProvided);
		recordAnyErrors(errors, element, xmlToModelResult);
	}

	private void recordAnyErrors(List<String> errors, Element element, XmlToModelResult xmlToModelResult) {
		for (String error : errors) {
			recordError(error, element, xmlToModelResult);
		}
	}

	private void recordError(String message, Element element, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(
				new Hl7Error(
						Hl7ErrorCode.DATA_TYPE_ERROR,
						message + " (" + XmlDescriber.describeSingleElement(element) + ")",
						element));
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new IVLImpl<QTY<T>, Interval<T>>();
	}

	private BareANY createType(ParseContext context, Element element, XmlToModelResult parseResult, boolean isSxcm) {
		String type = getParameterizedType(context);
		if (isSxcm) {
			type = "SXCM<" + type + ">";
		}
		ElementParser parser = ParserR2Registry.getInstance().get(type);

		if (parser != null) {
			ParseContext newContext = ParseContextImpl.createWithConstraints(
					type,
					context);
			BareANY parsedValue = parser.parse(newContext,	Arrays.asList((Node) element), parseResult);
			return parsedValue;
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

	@SuppressWarnings("unchecked")
	BareDiff createDiffType(ParseContext context, Element width, XmlToModelResult xmlToModelResult) {
		if (isTimestampType(context)) {
			return createDateDiff(context, width, xmlToModelResult);
		} else {
			BareANY bareAny = createType(context, width, xmlToModelResult, false);
			if (bareAny.hasNullFlavor()) {
				return new Diff<T>(bareAny.getNullFlavor());
			} else {
				return new Diff<T>((T) bareAny.getBareValue());
			}
		}
	}

	private Diff<Date> createDateDiff(ParseContext context, Element width, XmlToModelResult xmlToModelResult) {

		Diff<Date> result = null;
        if (getAttributeValue(width, NullFlavorHelper.NULL_FLAVOR_ATTRIBUTE_NAME) != null) {
            result = parseNullWidthNode(width);
        } else {

			try {
				StandardDataType diffType = StandardDataType.PQ;
				ElementParser parser = ParserR2Registry.getInstance().get(diffType);

				if (parser != null) {
					ParseContext subContext = ParseContextImpl.create(
							diffType.getType(),
							PhysicalQuantity.class,
							POPULATED, 
							Cardinality.create("1"),
							context);
					PhysicalQuantity quantity = (PhysicalQuantity) parser.parse(
							subContext, Arrays.asList((Node) width), xmlToModelResult).getBareValue();

					// though in some PQ cases units can be null, this situation does not seem to make sense for PQ.TIME
					if (quantity != null && quantity.getQuantity() != null && quantity.getUnit() != null) {
						result = new DateDiff(quantity);
					}
				} else {
					xmlToModelResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR,
							"Cannot find a parser for " + diffType.getType(), width));
				}

			} catch (XmlToModelTransformationException e) {
				xmlToModelResult.addHl7Error(new Hl7Error(DATA_TYPE_ERROR, e.getMessage(), width));
			}
        }
        return result;
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
