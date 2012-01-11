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

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

/**
 * ED.SIGNATURE - Encapsulated Data (Signature)
 *
 * Represents a String as an element:
 *
 * &lt;element-name mediaType="text/xml"&gt;
 *   &lt;signature xmlns="http://www.w3.org/2000/09/xmldsig#"&gt;signatureString&lt;/signature&gt;
 * &lt;/element-name&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-ED
 *
 * This appears to be correct, although all of the examples name the outer element as "text".
 *
 * CeRx notes that this is an evolving standard.
 */
@DataTypeHandler("ED.SIGNATURE")
class EdSignaturePropertyFormatter extends AbstractNullFlavorPropertyFormatter<String> {

    private static final Map<String, String> TOP_LEVEL_ATTRIBUTES;
    
    private static final Map<String, String> SIGNATURE_ATTRIBUTES;

    static {
    	TOP_LEVEL_ATTRIBUTES = new HashMap<String, String>();
        TOP_LEVEL_ATTRIBUTES.put("mediaType", "text/xml");
        
        SIGNATURE_ATTRIBUTES = new HashMap<String, String>();
        SIGNATURE_ATTRIBUTES.put("xmlns", "http://www.w3.org/2000/09/xmldsig#");
    }

    @Override
    String formatNonNullValue(FormatContext context, String signature, int indentLevel) throws ModelToXmlTransformationException {
    	validateContext(context);

        StringBuffer buffer = new StringBuffer();
        buffer.append(createElement(context, TOP_LEVEL_ATTRIBUTES, indentLevel, false, true));

        buffer.append(createElement("signature", SIGNATURE_ATTRIBUTES, indentLevel + 1, false, false));

        if (signature != null) {
            buffer.append(signature);
        }
        buffer.append(XmlRenderingUtils.createEndElement("signature", 0, true));

        buffer.append(createElementClosure(context, indentLevel, true));
        return buffer.toString();
    }
}
