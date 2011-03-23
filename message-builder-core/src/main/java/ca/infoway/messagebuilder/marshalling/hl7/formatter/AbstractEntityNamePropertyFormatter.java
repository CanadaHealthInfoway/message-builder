package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.EntityNameUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;

/**
 * This is shared by all subclasses of EntityName.
 * 
 */
public abstract class AbstractEntityNamePropertyFormatter<V extends EntityName> extends AbstractNullFlavorPropertyFormatter<V> {

	@Override
	String formatNonNullValue(FormatContext context, V value, int indentLevel) {
        StringBuffer buffer = new StringBuffer();
        if (value != null) {
            buffer.append(createElement(context, getUseAttributeMap(value), indentLevel, false, false));
            for (EntityNamePart namePart : value.getParts()) {
                appendNamePart(buffer, namePart);
            }
            buffer.append(createElementClosure(context, 0, true));
        }
        return buffer.toString();
    }
    
    private void appendNamePart(StringBuffer buffer, EntityNamePart namePart) {
        String openTag = "";
        String closeTag = "";
        
        if (namePart.getType() != null) {
            openTag = "<" + namePart.getType().getValue() + addQualifier(namePart) + ">";
            closeTag = "</" + namePart.getType().getValue() + ">";
        }

        buffer.append(openTag);
        buffer.append(XmlStringEscape.escape(namePart.getValue()));
        buffer.append(closeTag);
    }
    
    private String addQualifier(EntityNamePart namePart) {
		return StringUtils.isNotBlank(namePart.getQualifier()) ? " qualifier=\"" + namePart.getQualifier() + "\"" : "";
	}

	protected Map<String, String> getUseAttributeMap(V value) {
        String uses = "";
        for (EntityNameUse entityNameUse : value.getUses()) {
            uses += uses.length() == 0 ? "" : " ";
            uses += entityNameUse.getCodeValue();
        }
        Map<String, String> result = new HashMap<String, String>();
        
        if (uses.length() > 0) {
            result.put("use", uses);
        }
        return result;
    }
}
