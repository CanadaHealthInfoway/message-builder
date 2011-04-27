/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;



/**
 * INT.POS - Integer (Positive)
 *
 * Represents a INT.POS object as an element:
 *
 * &lt;element-name value="1234"&gt;&lt;/element-name&gt;
 *
 * If an object is null, value is replaced by a nullFlavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-INT
 *
 * The INT.POS variant defined by CeRx can only contain positive values. CeRx also defines
 * a maximum length of 10, which is not enforced by this class.
 */
@DataTypeHandler("INT.POS")
class IntPosPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

    @Override
    protected String getValue(Integer integer, VersionNumber version) throws ModelToXmlTransformationException {
        if (integer==null || integer.intValue() <= 0) {
            // it would be nice to name the element that we're constructing here, but right now it's not worth passing
            // the name down through a three-method call stack.
            throw new ModelToXmlTransformationException("Integer value must be positive: " + integer.toString());
        }
        return integer.toString();
    }
}
