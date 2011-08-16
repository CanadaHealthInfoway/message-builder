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

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * INT.NONNEG - Integer (Non-negative)
 *
 * Represents a INT.NONNEG object as an element:
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
 * The INT.NONNEG variant defined by CeRx cannot contain negative values. CeRx also defines
 * a maximum length of 10, which is not enforced by this class.
 */
@DataTypeHandler("INT.NONNEG")
class IntNonNegPropertyFormatter extends AbstractValueNullFlavorPropertyFormatter<Integer> {

	@Override
    protected String getValue(Integer integer, FormatContext context) throws ModelToXmlTransformationException {
       	return integer.toString();
    }
    
    @Override
    boolean isInvalidValue(FormatContext context, Integer integer) {
    	return integer==null || integer.intValue() < 0;
    }

	@Override
	protected String createWarningText(FormatContext context, Integer t) {
		return "Value " + t + " should be non-negative.";
	}
}
