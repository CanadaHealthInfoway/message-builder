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

import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;

/**
  * Represents an object as a single-level element with only attributes, comme ca:
  *
  * &lt;element-name attribute1="value1" /&gt;
  *
  * Concrete subclasses handle the formatting of attributes.
  */
public abstract class AbstractAttributePropertyFormatter<V> extends AbstractNullFlavorPropertyFormatter<V> {
	
	protected static final String EMPTY_STRING = "";

    @Override
    String formatNonNullDataType(FormatContext context, BareANY bareAny, int indentLevel) {
    	V value = extractBareValue(bareAny);
        return createElement(context, getAttributeNameValuePairs(context, value, bareAny), indentLevel, true, true);
    }

    @Override
	String formatNonNullValue(FormatContext context, V value, int indentLevel) {
		throw new UnsupportedOperationException("Different formatNonNullValue handler used for AbstractAttributePropertyFormatter");
	}
	
	abstract Map<String, String> getAttributeNameValuePairs(FormatContext context, V value, BareANY bareAny);

}
