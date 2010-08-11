package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

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
@DataTypeHandler({"CD", "CE"})
class CdPropertyFormatter extends AbstractCodePropertyFormatter {

    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, Code code) throws ModelToXmlTransformationException {
        Map<String, String> result = super.getAttributeNameValuePairs(context, code);
        if (code != null) {
            if (StringUtils.isNotBlank(code.getCodeSystem())) {
                result.put("codeSystem", code.getCodeSystem());
            }
        }
        return result;
    }
    
    @Override
    protected boolean hasChildContent(CD cd, FormatContext context) {
    	return hasTranslations(cd) || super.hasChildContent(cd, context);
    }

	private boolean hasTranslations(CD cd) {
		return !cd.getTranslations().isEmpty();
	}
    
    @Override
    protected void createChildContent(CD cd, StringBuilder result) {
    	super.createChildContent(cd, result);
    	if (hasTranslations(cd)) {
    		for (CD translation : cd.getTranslations()) {
    			Map<String, String> attributes = new HashMap<String, String>();
    			attributes.put("code", translation.getValue().getCodeValue());
    			attributes.put("codeSystem", translation.getValue().getCodeSystem());
    			result.append(createElement("translation", attributes, 0, true, false));
			}
    	}
    }
    
}
