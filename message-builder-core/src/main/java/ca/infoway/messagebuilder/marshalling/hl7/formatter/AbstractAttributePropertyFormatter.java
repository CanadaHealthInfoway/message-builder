package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;

/**
  * Represents an object as a single-level element with only attributes, comme ca:
  *
  * &lt;element-name attribute1="value1" /&gt;
  *
  * Concrete subclasses handle the formatting of attributes.
  */
public abstract class AbstractAttributePropertyFormatter<V> extends AbstractNullFlavorPropertyFormatter<V> {
	
	protected static final String EMPTY_STRING = "";

    @Override
    String formatNonNullDataType(FormatContext context, BareANY bareAny, int indentLevel) throws ModelToXmlTransformationException {
    	V value = extractBareValue(bareAny);
    	validateContext(context);
    	StringBuilder builder = new StringBuilder();
    	if (isInvalidValue(context, value)) {
    		builder.append(createWarning(indentLevel, createWarningText(context, value)));
    	}
        builder.append(createElement(context, getAttributeNameValuePairs(context, value, bareAny), indentLevel, true, true));
        return builder.toString();
    }

    @Override
	String formatNonNullValue(FormatContext context, V value, int indentLevel) throws ModelToXmlTransformationException {
		throw new UnsupportedOperationException("Different formatNonNullValue handler used for AbstractAttributePropertyFormatter");
	}
	
    protected String createWarningText(FormatContext context, V value) {
		return "Value " + value + " is not valid";
	}

	boolean isInvalidValue(FormatContext context, V value) {
		return false;
	}

	Map<String, String> getAttributeNameValuePairs(FormatContext context, V value, BareANY bareAny) throws ModelToXmlTransformationException {
		return getAttributeNameValuePairs(context, value);
    }

	Map<String, String> getAttributeNameValuePairs(FormatContext context, V value) throws ModelToXmlTransformationException {
		throw new IllegalStateException("getAttributeNameValuePairs(FormatContext,T) is not implemented");
    }
}
