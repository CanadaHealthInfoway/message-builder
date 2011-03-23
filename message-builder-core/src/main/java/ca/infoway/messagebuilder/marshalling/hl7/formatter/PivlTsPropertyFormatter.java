package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.DateDiff;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

@DataTypeHandler("PIVL<TS>")
class PivlTsPropertyFormatter extends AbstractPivlPropertyFormatter {

	protected String format(DateDiff period) throws ModelToXmlTransformationException {
		Map<String, String> attributes = getAttributes(period);
		return attributes.get(PqPropertyFormatter.ATTRIBUTE_VALUE);
	}

	protected String getUnits(DateDiff period) throws ModelToXmlTransformationException {
		Map<String, String> attributes = getAttributes(period);
		return attributes.get(PqPropertyFormatter.ATTRIBUTE_UNIT);
	}

	private Map<String, String> getAttributes(DateDiff period) throws ModelToXmlTransformationException {
		PhysicalQuantity quantity = period.getValueAsPhysicalQuantity();
		return new PqPropertyFormatter().getAttributeNameValuePairs((FormatContext) null, quantity);
	}
}
