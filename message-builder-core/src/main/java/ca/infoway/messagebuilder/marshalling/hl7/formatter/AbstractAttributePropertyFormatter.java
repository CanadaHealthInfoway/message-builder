package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

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
	String formatNonNullValue(FormatContext context, V value, int indentLevel) throws ModelToXmlTransformationException {
    	validateContext(context);
    	StringBuilder builder = new StringBuilder();
    	if (isInvalidValue(context, value)) {
    		builder.append(createWarning(indentLevel, createWarningText(context, value)));
    	}
        builder.append(createElement(context, getAttributeNameValuePairs(context, value), indentLevel, true, true));
        return builder.toString();
    }

    protected String createWarningText(FormatContext context, V value) {
		return "Value " + value + " is not valid";
	}

	boolean isInvalidValue(FormatContext context, V value) {
		return false;
	}

	Map<String, String> getAttributeNameValuePairs(FormatContext context, V value) throws ModelToXmlTransformationException {
		throw new IllegalStateException("getAttributeNameValuePairs(FormatContext,T) is not implemented");
    }
}
