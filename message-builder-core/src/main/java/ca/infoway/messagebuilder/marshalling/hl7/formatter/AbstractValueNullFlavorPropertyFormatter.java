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


/**
 * Formats some nullable object into element:
 *
 * &lt;element-name value="value" /&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * This class uses the "no information" null flavor for nulls it gets.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
public abstract class AbstractValueNullFlavorPropertyFormatter<V> extends AbstractAttributePropertyFormatter<V> {

	@Override
	Map<String, String> getAttributeNameValuePairs(FormatContext context, V t) throws ModelToXmlTransformationException {
        Map<String, String> result = new HashMap<String, String>();
        if (t != null) {
            result.put("value", getValue(t, context));
            addOtherAttributesIfNecessary(t, result);
        } else {
            result.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);
        }
        return result;
    }

    protected abstract String getValue(V v, FormatContext context) throws ModelToXmlTransformationException;

    protected void addOtherAttributesIfNecessary(V v, Map<String, String> attributes) throws ModelToXmlTransformationException {
        // no-op in superclass
    }
}
