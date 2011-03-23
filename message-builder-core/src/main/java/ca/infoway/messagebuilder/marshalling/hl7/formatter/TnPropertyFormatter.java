package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * TN - TrivialName
 *
 * Represents an TN object as an element:
 *
 * &lt;element-name&gt;This is a trivial name&lt;/element-name&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TN
 */
@DataTypeHandler("TN")
public class TnPropertyFormatter extends AbstractEntityNamePropertyFormatter<TrivialName> {

    @Override
    String formatNonNullValue(FormatContext context, TrivialName value, int indentLevel) {
        StringBuffer buffer = new StringBuffer();
        if (value != null) {
            buffer.append(createElement(context, getUseAttributeMap(value), indentLevel, false, false));
            buffer.append(XmlStringEscape.escape(value.getName()));
            buffer.append(createElementClosure(context, 0, true));
        }
        return buffer.toString();
    }
}
