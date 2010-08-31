package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PIVLImpl;
import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTime;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

@DataTypeHandler("GTS.BOUNDEDPIVL")
class GtsBoundedPivlFormatter extends AbstractNullFlavorPropertyFormatter<GeneralTimingSpecification> {

	public final static String GTS_BOUNDED_PIVL = "GTS.BOUNDEDPIVL";

	@Override
	String formatNonNullValue(FormatContext context, GeneralTimingSpecification value, int indentLevel) throws ModelToXmlTransformationException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(createElement(context, createTypeAttributes(), indentLevel, false, true));
		appendValues(buffer, value, indentLevel);		
		buffer.append(createElementClosure(context, indentLevel, true));
		return buffer.toString();
	}

	private Map<String, String> createTypeAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("specializationType", GTS_BOUNDED_PIVL);
		attributes.put("xsi:type", "SXPR_TS");
		return attributes;
	}

	private void appendValues(StringBuffer buffer, GeneralTimingSpecification value, int indentLevel) throws ModelToXmlTransformationException {
		
		Interval<Date> duration = value.getDuration();
		IVL<TS,Interval<Date>> ivlDuration = new IVLImpl<TS,Interval<Date>>(duration);
		
		PeriodicIntervalTime frequency = value.getFrequency();
		buffer.append(new IvlTsPropertyFormatter().format(
				new FormatContextImpl("comp", "IVL<TS.FULLDATE>", ConformanceLevel.MANDATORY, true, null, false), 
				ivlDuration, 
				indentLevel + 1)
			);
		buffer.append(createElement(new FormatContextImpl("comp", "PIVL<TS.DATETIME>", ConformanceLevel.MANDATORY, true, null), frequency, indentLevel + 1));
	}
	
	protected String createElement(FormatContext context, PeriodicIntervalTime value, int indentLevel) throws ModelToXmlTransformationException {
		PivlTsPropertyFormatter formatter = new CustomPivlPropertyFormatter();
    	if (formatter != null) {
    		return formatter.format(context, new PIVLImpl(value), indentLevel);
    	} else {
    		throw new ModelToXmlTransformationException("No formatter found for " + context.getType());
    	}
	}
	
	private static class CustomPivlPropertyFormatter extends PivlTsPropertyFormatter {
		@Override
		protected Map<String, String> getAttributesMap() {
			return toStringMap("operator", "I");
		}
	}	
}
