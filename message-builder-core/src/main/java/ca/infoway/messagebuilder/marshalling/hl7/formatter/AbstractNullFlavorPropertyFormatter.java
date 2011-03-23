package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.platform.ListElementUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.util.XmlWarningRenderer;

/**
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * Otherwise this class hands the formatting off to the formatNonNull method.
 */
public abstract class AbstractNullFlavorPropertyFormatter<V> extends AbstractPropertyFormatter {
	
	private XmlWarningRenderer renderer = new XmlWarningRenderer();
	
	protected AbstractNullFlavorPropertyFormatter() {
	}

    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) throws ModelToXmlTransformationException {
    	validateContext(context);

    	String result = "";
    	if (hl7Value!=null) {
    		
    		V value = extractBareValue(hl7Value);
    		
    		if (hl7Value.hasNullFlavor()) {
    			result = createElement(context, createNullFlavorAttributes(hl7Value.getNullFlavor()), indentLevel, true, true);
    			if (context.getConformanceLevel() == MANDATORY) {
    				result = createWarning(context, indentLevel) + result;
    			}
    		} else if (value == null || isEmptyCollection(value)) {
    			if (context.getConformanceLevel() == null || isMandatoryOrPopulated(context)) {
        			if (context.getConformanceLevel() == MANDATORY) {
        				result = createElement(context, EMPTY_ATTRIBUTE_MAP, indentLevel, true, true);
        				result = createWarning(context, indentLevel) + result;
        			} else {
        				result = createElement(context, NULL_FLAVOR_ATTRIBUTES, indentLevel, true, true);
        			}
    			}
    		} else {
    			result = formatNonNullDataType(context, hl7Value, indentLevel);
    		}
    	}
        return result;
    }

	@SuppressWarnings("unchecked")
	protected V extractBareValue(BareANY hl7Value) {
		return (V) hl7Value.getBareValue();
	}

	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel) throws ModelToXmlTransformationException {
		return formatNonNullValue(context, extractBareValue(dataType), indentLevel);
	}

	abstract String formatNonNullValue(FormatContext context, V t, int indentLevel) throws ModelToXmlTransformationException;
	
	protected boolean isEmptyCollection(V value) {
		if (ListElementUtil.isCollection(value)) {
			return ListElementUtil.isEmpty(value);
		}
		return false;
	}

	protected Map<String, String> createNullFlavorAttributes(NullFlavor nullFlavor) {
		HashMap<String, String> attributes = new HashMap<String, String>();
		attributes.put(NULL_FLAVOR_ATTRIBUTE_NAME, nullFlavor.getCodeValue());
		return attributes;
	}

	protected String createWarning(FormatContext context, int indentLevel) {
		return createWarning(indentLevel, context.getElementName() 
							+ " is a mandatory field, but no value is specified");
	}

	protected String createWarning(int indentLevel, String text) {
		return this.renderer.createWarning(indentLevel, text);
	}

    protected boolean isMandatoryOrPopulated(FormatContext context) {
    	ConformanceLevel level = context.getConformanceLevel();
		return level == ConformanceLevel.MANDATORY || level == ConformanceLevel.POPULATED;
	}

	protected Map<String, String> toStringMap(String... string) {
		Map<String, String> result = new HashMap<String, String>();
		int length = string == null ? 0 : string.length;
		for (int i = 0; i < length - 1; i += 2) {
			if (string[i] != null && string[i + 1] != null) {
				result.put(string[i], string[i + 1]);
			}
		}
		return result;
	}
}