/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
