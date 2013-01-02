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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * BL - Boolean
 *
 * Formats a Boolean into a BL element. The element looks like this:
 *
 * &lt;element-name value="true"/&gt;		&lt;!-- or value="false" --&gt;
 *
 * If a Boolean is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-BL
 */
@DataTypeHandler("BL")
class BlPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Boolean> {

	@Override
	protected String getValue(Boolean booleanValue, FormatContext context, BareANY bareAny) {
		return booleanValue.booleanValue() ? "true" : "false"; 
	}
}
