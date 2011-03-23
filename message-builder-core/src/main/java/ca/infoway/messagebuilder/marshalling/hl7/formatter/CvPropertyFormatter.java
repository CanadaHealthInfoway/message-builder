package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;


/**
 * CV - Coded Value
 *
 * Formats a enum into a CV element. The element looks like this:
 *
 * &lt;element-name code="RECENT" /&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CV
 *
 * CeRx states that attribute codeSystem is mandatory if code is specified. However,
 * none of the sample messages do this and the HL7 definition of the message domains
 * do not specify what the codeSystem is for different domains.
 *
 * There's also an originalText attribute that must be included if code is specified.
 * Again, the HL7 domain definitions are of little help with that.
 *
 * Finally: there are two types of attributes that that use this datatype.
 *
 * CNE (coded no extensibility): code attribute is mandatory.
 * CWE (coded with extensibility): code attribute is required (that is, must be supported
 * but not mandatory. originalText may be specified if code is not entered.
 *
 * Currently this class does nothing with codeSystem or originalText. Therefore it is
 * identical to the CS class.
 */
@DataTypeHandler("CV")
class CvPropertyFormatter extends AbstractCodePropertyFormatter {

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
}
