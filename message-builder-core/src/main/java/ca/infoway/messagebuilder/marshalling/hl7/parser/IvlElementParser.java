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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode.DATA_TYPE_ERROR;
import static ca.infoway.messagebuilder.xml.ConformanceLevel.POPULATED;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.IvlValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.XmlDescriber;

/**
 * IVL - Interval
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
 * <value value='2' />  // TM - this format does not seem to be valid for MR2009, MR2007, or CeRx; it appears that MB does try to support it, however
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-IVL
 */
abstract class IvlElementParser<T> extends AbstractSingleElementParser<Interval<T>> {

	private IvlValidationUtils ivlValidationUtils = new IvlValidationUtils();
	
	@Override
	@SuppressWarnings("unchecked")
	protected Interval<T> parseNonNullNode(ParseContext context, Node node, BareANY parseResult, Type expectedReturnType, XmlToModelResult xmlToModelResult) {

		// go back and revert TS.FULLDATEWITHTIME validation check? (is there anything to revert?)
		context = handleSpecializationType(context, node, xmlToModelResult);
		
		Interval<T> result = null;
		
		Element low = (Element) getNamedChildNode(node, "low");
		Element high = (Element) getNamedChildNode(node, "high");
		Element center = (Element) getNamedChildNode(node, "center");
		Element width = (Element) getNamedChildNode(node, "width");

		validateCorrectElementsProvided(low != null, high != null, center != null, width != null, (Element) node, context, xmlToModelResult);
		
		BareANY lowAny = low == null ? null : createType(context, low, xmlToModelResult);
		Object lowType = lowAny == null ? null : lowAny.getBareValue();
		
		BareANY highAny = high == null ? null : createType(context, high, xmlToModelResult);
		Object highType = highAny == null ? null : highAny.getBareValue();
		
		BareANY centerAny = center == null ? null : createType(context, center, xmlToModelResult);
		Object centerType = centerAny == null ? null : centerAny.getBareValue();
		
		BareDiff widthType = width == null ? null : createDiffType(context, width, xmlToModelResult);

		doOtherValidations(lowAny, highAny, centerAny, widthType, (Element) node, context, xmlToModelResult);
		
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
				// try to parse a "simple" interval; this does not seem a valid approach for MR2009, MR2007, or CeRx (perhaps allowed within the XSDs?)
				Object type = createType(context, (Element) node, xmlToModelResult).getBareValue();
				if (type==null) {
		        	xmlToModelResult.addHl7Error(
		        			new Hl7Error(
		        					Hl7ErrorCode.SYNTAX_ERROR, 
		        					"\"Simple interval node: " + XmlDescriber.describePath(node) + " does not allow a null value\"",
		        					(Element) node));
				} else {
					result = IntervalFactory.<T>createSimple((T) type);
				}
			}
		}
		
		return result;
	}

	
	private ParseContext handleSpecializationType(ParseContext context, Node node, XmlToModelResult xmlToModelResult) {
		String type = context.getType();
		String specializationType = getAttributeValue(node, SPECIALIZATION_TYPE);
		List<String> errors = new ArrayList<String>();
		
		String newType = this.ivlValidationUtils.validateSpecializationType(type, specializationType, errors);
		recordAnyErrors(errors, (Element) node, xmlToModelResult);

		if (!StringUtils.equals(type, newType)) {
			// replace the context with one using the specialization type
			context = ParserContextImpl.create(newType, context);
		}
		
		return context;
	}

	private void validateCorrectElementsProvided(boolean lowProvided, boolean highProvided, boolean centerProvided, boolean widthProvided, Element element, ParseContext context, XmlToModelResult xmlToModelResult) {
		VersionNumber version = context.getVersion();
		String type = context.getType();

		List<String> errors = ivlValidationUtils.validateCorrectElementsProvided(type, version, lowProvided, highProvided, centerProvided, widthProvided);

		recordAnyErrors(errors, element, xmlToModelResult);
	}

	private void doOtherValidations(BareANY lowAny, BareANY highAny, BareANY centerAny, BareDiff widthType, Element element, ParseContext context, XmlToModelResult xmlToModelResult) {
		String type = context.getType();
		NullFlavor lowNullFlavor = (lowAny == null ? null : lowAny.getNullFlavor());
		NullFlavor centerNullFlavor = (centerAny == null ? null : centerAny.getNullFlavor());
		NullFlavor highNullFlavor = (highAny == null ? null : highAny.getNullFlavor());
		NullFlavor widthNullFlavor = (widthType == null ? null : widthType.getNullFlavor());
		UnitsOfMeasureCaseSensitive widthTimeUnits = ((widthType != null && widthType instanceof DateDiff) ? ((DateDiff) widthType).getUnit() : null);
		
		List<String> errors = this.ivlValidationUtils.doOtherValidations(type, lowNullFlavor, centerNullFlavor, highNullFlavor, widthNullFlavor, widthTimeUnits);
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
		return GenericDataTypeFactory.create(typeName);
	}

	private BareANY createType(ParseContext context, Element element, XmlToModelResult parseResult) {
		String type = getParameterizedType(context);
		ElementParser parser = ParserRegistry.getInstance().get(type);

		if (parser != null) {
			return parser.parse(ParserContextImpl.create(
					type,
					null,
					context.getVersion(),
					context.getDateTimeZone(),
					context.getDateTimeTimeZone(),
					POPULATED),
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

	@SuppressWarnings("unchecked")
	BareDiff createDiffType(ParseContext context, Element width, XmlToModelResult xmlToModelResult) {
		if (isTimestampType(context)) {
			return createDateDiff(context, width, xmlToModelResult);
		} else {
			BareANY bareAny = createType(context, width, xmlToModelResult);
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
				StandardDataType diffType = StandardDataType.PQ_TIME;
				ElementParser parser = ParserRegistry.getInstance().get(diffType);

				if (parser != null) {
					ParseContext subContext = ParserContextImpl.create(
							diffType.getType(),
							PhysicalQuantity.class,
							context.getVersion(),
							context.getDateTimeZone(),
							context.getDateTimeTimeZone(),
							POPULATED);
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
