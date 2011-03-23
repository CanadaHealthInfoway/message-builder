package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.time.DateUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.DataTypeImplementationFactory;
import ca.infoway.messagebuilder.datatype.lang.BareDiff;
import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

abstract class IvlPropertyFormatter<T> extends AbstractIvlPropertyFormatter<T> {

    private static final String UNITS_OF_MEASURE_DAY = "d";
	
    protected String getDateDiffUnits(BareDiff diff) {
    	if (diff instanceof DateDiff) {
    		UnitsOfMeasureCaseSensitive unit = ((DateDiff) diff).getUnit();
			return unit!=null ? unit.getCodeValue() : ""; 
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
    
	protected String createTimestampWidthElement(FormatContext context, String name, BareDiff diff, int indentLevel) throws ModelToXmlTransformationException {
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
    
    
    
	@Override
	protected String createWidthElement(FormatContext context, String name, BareDiff diff, int indentLevel) throws ModelToXmlTransformationException {
		if (isTimestamp(context)) {
			return createTimestampWidthElement(context, name, diff, indentLevel);
		} else {
	    	String type = Hl7DataTypeName.getParameterizedType(context.getType());
	    	PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
	    	if (formatter != null) {
	    		return formatter.format(
	    				new FormatContextImpl(name, type, ConformanceLevel.MANDATORY, context.isSpecializationType(), null),
	    				wrapWithHl7DataType(type, diff),
	    				indentLevel);
	    	} else {
	    		throw new ModelToXmlTransformationException("No formatter found for " + type);
	    	}
		}
	}

	private BareANY wrapWithHl7DataType(String hl7DataType, BareDiff diff) throws ModelToXmlTransformationException {
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

	@Override
	protected String createElement(FormatContext context, String name, QTY<T> value, int indentLevel) throws ModelToXmlTransformationException {
    	String type = Hl7DataTypeName.getParameterizedType(context.getType());
    	PropertyFormatter formatter = FormatterRegistry.getInstance().get(type);
    	if (formatter != null) {
    		return formatter.format(
    				new FormatContextImpl(name, type, ConformanceLevel.MANDATORY, context.isSpecializationType(), context.getVersion()), value, indentLevel);
    	} else {
    		throw new ModelToXmlTransformationException("No formatter found for " + type);
    	}
	}
}
