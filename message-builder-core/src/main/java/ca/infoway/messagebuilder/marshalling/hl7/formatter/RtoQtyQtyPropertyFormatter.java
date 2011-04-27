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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * RTO<QTY,QTY> - Ratio (quantity, quantity)
 * 
 * Represents a Ratio of quantities as an element:
 * 
 * <unitQuantity>
 *    <numerator value="1.0" xsi:type="QTY"/>
 *    <denominator value="64.0" xsi:type="QTY"/>
 * </unitQuantity>
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
 */
@DataTypeHandler("RTO<QTY,QTY>")
public class RtoQtyQtyPropertyFormatter extends AbstractRtoPropertyFormatter<BigDecimal, BigDecimal> {

    @Override
    protected Map<String, String> getDenominatorAttributeMap(BigDecimal value) {
        return getAttributeMap(value);
    }
    @Override
    protected Map<String, String> getNumeratorAttributeMap(BigDecimal value) {
        return getAttributeMap(value);
    }

    private Map<String, String> getAttributeMap(BigDecimal value) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("value", value.toString());
        result.put("xsi:type", "QTY");
        return result;
    }
}
