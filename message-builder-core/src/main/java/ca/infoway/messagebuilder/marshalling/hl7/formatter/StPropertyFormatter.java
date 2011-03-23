package ca.infoway.messagebuilder.marshalling.hl7.formatter;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * ST - String
 *
 * Represents an ST object as an element:
 *
 * &lt;element-name&gt;This is some text&lt;/element-name&gt;
 *
 * HL7 defines other attributes, but notes that they are optional since
 * the values are self-evident (representation="TXT" mediaType="text/plain").
 * The CeRx documentation makes no mention of these attributes.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ST
 *
 * TODO: this should be abstracted if more single-level elements with text nodes are needed.
 */
@DataTypeHandler("ST")
class StPropertyFormatter extends AbstractNullFlavorPropertyFormatter<String> {

	@Override
	String formatNonNullValue(FormatContext context, String value, int indentLevel) throws ModelToXmlTransformationException {
		throw new UnsupportedOperationException("Different formatNonNull handler used for ST");
	}

	@Override
	String formatNonNullDataType(FormatContext context, BareANY dataType, int indentLevel)	throws ModelToXmlTransformationException {
        StringBuffer buffer = new StringBuffer();
    	Map<String, String> attributes = new HashMap<String, String>();
    	if (dataType instanceof ST && "ST.LANG".equals(context.getType())) {
    		ST st = (ST) dataType;
    		String language = st.getLanguage();
			attributes.put("language", StringUtils.isBlank(language) ? "en-CA" : language);
    	}
        buffer.append(createElement(context, attributes, indentLevel, false, false));
        Object bareValue = dataType.getBareValue();
		buffer.append(XmlStringEscape.escape(bareValue == null ? "" : bareValue.toString()));
        buffer.append(createElementClosure(context, 0, true));
        return buffer.toString();
	}
	
}
