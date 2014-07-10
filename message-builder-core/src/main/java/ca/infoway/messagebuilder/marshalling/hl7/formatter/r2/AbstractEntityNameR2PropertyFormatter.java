/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * This is shared by all subclasses of EntityName.
 * 
 */
public abstract class AbstractEntityNameR2PropertyFormatter<V extends EntityName> extends AbstractNullFlavorPropertyFormatter<V> {

	@Override
	protected
	String formatNonNullValue(FormatContext context, V value, int indentLevel) {
		
		validateName(value, context);
		
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
    
    protected void validateName(V value, FormatContext context) {
    	// leave this up to subclasses to decide if they want to do any validations
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
