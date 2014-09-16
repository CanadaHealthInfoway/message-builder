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
 * Last modified: $LastChangedDate: 2014-05-22 15:54:32 -0400 (Thu, 22 May 2014) $
 * Revision:      $LastChangedRevision: 8676 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.time.DateUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.DataTypeImplementationFactory;
import ca.infoway.messagebuilder.datatype.impl.QTYImpl;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;
import ca.infoway.messagebuilder.datatype.lang.util.RepresentationUtil;
import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.IvlValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.ModelToXmlTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.PropertyFormatter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

/**
 * IVL - Interval (R2)
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
abstract class IvlR2PropertyFormatter<T> extends AbstractNullFlavorPropertyFormatter<Interval<T>> {

	private IvlValidationUtils ivlValidationUtils = new IvlValidationUtils();
	
    private static final String UNITS_OF_MEASURE_DAY = "d";
	
	protected static final String UNIT = "unit";
	protected static final String WIDTH = "width";
	protected static final String CENTRE = "center";
	protected static final String HIGH = "high";
	protected static final String LOW = "low";
	protected static final String VALUE = "value";

	@Override
	protected
	String formatNonNullValue(FormatContext context, Interval<T> value, int indentLevel) {
		// need to use the alternate format method that has the BareANY object as a parameter
		throw new UnsupportedOperationException();
	}
		
	@Override
	protected
	String formatNonNullDataType(FormatContext context, BareANY bareAny, int indentLevel) {
		
		Interval<T> value = extractBareValue(bareAny);
		
		context = validateInterval(value, bareAny, context);
		
		StringBuffer buffer = new StringBuffer();
		if (value.getRepresentation() == Representation.SIMPLE) {
			QTYImpl<T> qty = new QTYImpl<T>(value.getValue());
			qty.setOperator(value.getOperator());
			buffer.append(createElement(context, context.getElementName(), qty, null, true, indentLevel));
		} else {
			buffer.append(createElement(context, null, indentLevel, false, true));
			appendIntervalBounds(context, value, buffer, indentLevel + 1);
			buffer.append(createElementClosure(context, indentLevel, true));
		}
		return buffer.toString();
	}

	private FormatContext validateInterval(Interval<T> value, BareANY bareAny, FormatContext context) {
		boolean lowProvided = 
				RepresentationUtil.hasLow(value.getRepresentation()) &&
				(value.getLow() != null || value.getLowNullFlavor() != null);
		
		boolean highProvided = 
				RepresentationUtil.hasHigh(value.getRepresentation()) &&
				(value.getHigh() != null || value.getHighNullFlavor() != null);
		
		boolean centerProvided = 
				RepresentationUtil.hasCentre(value.getRepresentation()) &&
				(value.getCentre() != null || value.getCentreNullFlavor() != null);
		
		boolean widthProvided = 
				RepresentationUtil.hasWidth(value.getRepresentation()) &&
				(value.getWidth() != null && (value.getWidth().getValue() != null || value.getWidth().getNullFlavor() != null));
		
		List<String> errors = this.ivlValidationUtils.validateCorrectElementsProvidedForR2(lowProvided, highProvided, centerProvided, widthProvided);
		recordAnyErrors(errors, context);
		
		return context;
	}

	private void recordAnyErrors(List<String> errors, FormatContext context) {
		for (String error : errors) {
			recordError(error, context);
		}
	}

	private void appendIntervalBounds(FormatContext context, Interval<T> value, StringBuffer buffer, int indentLevel) {
		Representation rep = value.getRepresentation();
		
		String low = RepresentationUtil.hasLow(rep) ? createElement(context, LOW, createQTY(value.getLow(), value.getLowNullFlavor()), getInclusiveValue(value, true), false, indentLevel) : null;
		String high = RepresentationUtil.hasHigh(rep) ? createElement(context, HIGH, createQTY(value.getHigh(), value.getHighNullFlavor()), getInclusiveValue(value, false), false, indentLevel) : null;
		String centre = RepresentationUtil.hasCentre(rep) ? createElement(context, CENTRE, createQTY(value.getCentre(), value.getCentreNullFlavor()), null, false, indentLevel) : null;
		String width = RepresentationUtil.hasWidth(rep) ? createWidthElement(context, WIDTH, value.getWidth(), indentLevel) : null;

		switch (rep) {
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
		case LOW_CENTER:
			buffer.append(low);
			buffer.append(centre);
			break;
		case WIDTH_HIGH:
			buffer.append(width);
			buffer.append(high);
			break;
		case CENTRE_WIDTH:
			buffer.append(centre);
			buffer.append(width);
			break;
		case CENTRE_HIGH:
			buffer.append(centre);
			buffer.append(high);
			break;
		default:
		}
	}

	private Boolean getInclusiveValue(Interval<T> value, boolean isLow) {
		if (value == null) {
			return null;
		}
		return isLow ? value.getLowInclusive() : value.getHighInclusive();
	}

	private QTY<T> createQTY(T value, NullFlavor nullFlavor) {
		return new QTYImpl<T>(null, value, nullFlavor, StandardDataType.QTY);
	}

	protected String getDateDiffUnits(BareDiff diff) {
    	if (diff instanceof DateDiff) {
    		UnitsOfMeasureCaseSensitive unit = ((DateDiff) diff).getUnit();
			return unit != null ? unit.getCodeValue() : ""; 
    	} else {
    		return UNITS_OF_MEASURE_DAY;
    	}
    }

    protected String formatDateDiff(BareDiff diff) {
    	if (diff instanceof DateDiff) {
    		PhysicalQuantity quantity = ((DateDiff) diff).getValueAsPhysicalQuantity();
    		return quantity == null ? "" : ObjectUtils.toString(quantity.getQuantity());
    	} else {
            long l = ((Date) diff.getBareValue()).getTime() / DateUtils.MILLIS_PER_DAY;
            return String.valueOf(l);
    	}
    }
    
	protected String createTimestampWidthElement(FormatContext context, String name, BareDiff diff, int indentLevel) {
		if (diff != null) {
			Map<String, String> attributes;
			if (diff instanceof NullFlavorSupport && ((NullFlavorSupport) diff).hasNullFlavor()) {
			    NullFlavorSupport nullable = diff;
                attributes = toStringMap(NULL_FLAVOR_ATTRIBUTE_NAME, nullable.getNullFlavor().getCodeValue());
			} else {
				attributes = toStringMap(VALUE, formatDateDiff(diff), UNIT, getDateDiffUnits(diff));
			} 
			return createElement(name, attributes, indentLevel, true, true);
		}
		return null;
		
	}
    
	protected String createWidthElement(FormatContext context, String name, BareDiff diff, int indentLevel) {
		if (isTimestamp(context)) {
			return createTimestampWidthElement(context, name, diff, indentLevel);
		} else {
	    	String type = Hl7DataTypeName.getParameterizedType(context.getType());
	    	PropertyFormatter formatter = FormatterR2Registry.getInstance().get(type);
	    	if (formatter != null) {
	    		boolean isSpecializationType = false;
				return formatter.format(
	    				new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), name, type, ConformanceLevel.MANDATORY, Cardinality.create("1"), isSpecializationType, context.getVersion(), context.getDateTimeZone(), context.getDateTimeTimeZone(), null),
	    				wrapWithHl7DataType(type, diff),
	    				indentLevel);
	    	} else {
	    		throw new ModelToXmlTransformationException("No formatter found for " + type);
	    	}
		}
	}

	private BareANY wrapWithHl7DataType(String hl7DataType, BareDiff diff) {
		try {
			BareANY hl7Value = (BareANY) DataTypeImplementationFactory.getImplementation(hl7DataType).newInstance();
			if (diff!=null) {
				if (diff.getBareValue()!=null) {
					((BareANYImpl) hl7Value).setBareValue(diff.getBareValue());
				} else {
					hl7Value.setNullFlavor(diff.getNullFlavor());
				}
			}
			return hl7Value;
		} catch (Exception e) {
			throw new ModelToXmlTransformationException("Unable to instantiate HL7 data type: " + hl7DataType, e);
		} 
	}

	private boolean isTimestamp(FormatContext context) {
		return "TS".equals(Hl7DataTypeName.unqualify(Hl7DataTypeName.getParameterizedType(context.getType())));
	}

	protected String createElement(FormatContext context, String name, QTY<T> value, Boolean inclusive, boolean isSxcm, int indentLevel) {
    	String type = Hl7DataTypeName.getParameterizedType(context.getType());
    	if (isSxcm) {
    		type = "SXCM<" + type + ">";
    	}
    	
    	PropertyFormatter formatter = FormatterR2Registry.getInstance().get(type);
    	if (formatter != null) {
    		boolean isSpecializationType = false;
    		String result = formatter.format(
    				new FormatContextImpl(context.getModelToXmlResult(), context.getPropertyPath(), name, type, ConformanceLevel.POPULATED, Cardinality.create("1"), isSpecializationType, context.getVersion(), context.getDateTimeZone(), context.getDateTimeTimeZone(), null), value, indentLevel);
    		if (inclusive != null) {
    			// TM - small hack to add in the inclusive attribute (low/high) (operator, simple only, is already formatted by using the SXCM type)
    			result = result.replaceFirst(" value=", " inclusive=\"" + inclusive.toString() + "\" value=");
    		}
    		return result;
    	} else {
    		throw new ModelToXmlTransformationException("No formatter found for " + type);
    	}
	}
	
	private void recordError(String message, FormatContext context) {
		String propertyPath = context.getPropertyPath();
		context.getModelToXmlResult().addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR, message, propertyPath));
	}

}
