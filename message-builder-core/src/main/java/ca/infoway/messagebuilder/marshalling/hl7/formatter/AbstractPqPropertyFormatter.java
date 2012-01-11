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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;

/**
 * PQ - Physical Quantity
 *
 * Represents a PhysicalQuantity object as an element:
 *
 * &lt;element-name value="123.33" unit="validUnit"/&gt;
 *
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 *
 * &lt;element-name nullFlavor="something" /&gt;
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ
 *
 * Concreate subclasses of this class will likely limit the valid values for unit.
 *
 * CeRx specifies that the quantity is formatted as 99999999.99 with no leading or
 * trailing zeros.
 */
public abstract class AbstractPqPropertyFormatter extends AbstractAttributePropertyFormatter<PhysicalQuantity> {
	
	public static final String ATTRIBUTE_UNIT = "unit";
	public static final String ATTRIBUTE_VALUE = "value";

	@Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, PhysicalQuantity physicalQuantity) throws ModelToXmlTransformationException {

        Map<String, String> result = new HashMap<String, String>();

        if (physicalQuantity == null) {
            result.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);

        } else if (physicalQuantity.getQuantity() == null && physicalQuantity.getUnit() == null) {
            result.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);

        } else if (physicalQuantity.getQuantity() == null) {
            throw new ModelToXmlTransformationException("PhysicalQuantity must define quantity");

        } else if (isValidPhysicalQuantity(physicalQuantity)) {
            result.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
            if (physicalQuantity.getUnit() != null) {
                // if unit is null, then this is an "each"
                result.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
            }
        }

        return result;
    }

    protected boolean isValidPhysicalQuantity(PhysicalQuantity physicalQuantity) throws ModelToXmlTransformationException {
        return true;
    }

    protected String formatQuantity(BigDecimal quantity) {
        return quantity.toString();
    }
}
