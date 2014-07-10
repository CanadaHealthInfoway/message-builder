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

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractValueNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * INT (R2)
 *
 * Represents a INT object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 */
@DataTypeHandler("INT")
class IntR2PropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

	@Override
    protected String getValue(Integer integer, FormatContext context, BareANY bareAny) {
        return integer.toString();
    }
	
}
