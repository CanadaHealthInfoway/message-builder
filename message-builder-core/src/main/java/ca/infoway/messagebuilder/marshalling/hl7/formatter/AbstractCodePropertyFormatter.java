package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.MANDATORY;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

/**
 * CS - Coded Simple
 *
 * Formats a enum into a CS element. The element looks like this:
 *
 * &lt;element-name code="RECENT"/&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * HL7 implies that variations on this type may use a different name than "code" for
 * the attribute. The use in the controlActProcess is given as an example.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
abstract class AbstractCodePropertyFormatter extends AbstractAttributePropertyFormatter<Code> {

    @Override
    public String format(FormatContext context, BareANY hl7Value, int indentLevel) throws ModelToXmlTransformationException {
    	validateContext(context);

    	CD cd = (CD) hl7Value;
    	
    	StringBuilder result = new StringBuilder();
    	if (cd!=null) {

    		Map<String, String> attributes = new HashMap<String, String>();
    		String warning = "";
    		
    		if (cd.hasNullFlavor()) {
    			if (context.getConformanceLevel() == MANDATORY) {
    				warning = createWarning(context, indentLevel);
    			} else {
    				attributes.putAll(createNullFlavorAttributes(hl7Value.getNullFlavor()));
    			}
    		} else if (!hasValue(cd, context)) {
    			if (context.getConformanceLevel() == null || isMandatoryOrPopulated(context)) {
        			if (context.getConformanceLevel() == MANDATORY) {
        				warning = createWarning(context, indentLevel);
        			} else {
        				attributes.putAll(NULL_FLAVOR_ATTRIBUTES);
        			}
    			}
    		} else {
    			attributes.putAll(getAttributeNameValuePairs(context, cd.getValue()));
    		}
    		
    		result.append(warning);
    		
    		boolean hasChildContent = hasChildContent(cd, context);
    		if (hasChildContent || (!attributes.isEmpty() || context.getConformanceLevel() == MANDATORY)) {
    			result.append(createElement(context, attributes, indentLevel, !hasChildContent, !hasChildContent));
    			if (hasChildContent) {
    				createChildContent(cd, result);
	    			result.append("</").append(context.getElementName()).append(">");
	    			result.append(LINE_SEPARATOR);
    			}
    		}
    		
    	}
        return result.toString();
    }

	protected boolean hasChildContent(CD cd, FormatContext context) {
		return hasOriginalText(cd);
	}

	protected void createChildContent(CD cd, StringBuilder result) {
		if (hasOriginalText(cd)) {
			result.append(createElement("originalText", null, 0, false, false));
			result.append(XmlStringEscape.escape(cd.getOriginalText()));
			result.append("</").append("originalText").append(">");
		}
	}
	
    protected boolean hasValue(CD cd, FormatContext context) {
		return cd!=null && (cd.getValue()!=null || hasChildContent(cd, context));
	}

	private boolean hasOriginalText(CD cd) {
		return !StringUtils.isEmpty(cd.getOriginalText());
	}

    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Code code) throws ModelToXmlTransformationException {
        Map<String, String> result = new HashMap<String, String>();
        if (code != null) {
            String value = code.getCodeValue();
            if (StringUtils.isNotBlank(value)) {
                result.put("code", value);
            }
        }
        return result;
    }
    
}
