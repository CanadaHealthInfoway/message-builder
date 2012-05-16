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

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;

/**
 * RTO&lt;PQ, PQ&gt; - Ratio (physical quantity, physical quantity)
 *
 * Represents a Ratio of physical quantities as an element:
 *
 * &lt;unitQuanity&gt;
 *    &lt;numerator value="1.0" xsi:type="PQ"/&gt;
 *    &lt;denominator value="64.0" xsi:type="/&gt;
 * &lt;/unitQuanity&gt;
 */
 //http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-RTO
@DataTypeHandler("RTO<PQ,PQ>")
public class RtoPqPqPropertyFormatter extends AbstractRtoPropertyFormatter<PhysicalQuantity, PhysicalQuantity> {

    @Override
    protected Map<String, String> getDenominatorAttributeMap(PhysicalQuantity value) {
        return getAttributeMap(value);
    }
    @Override
    protected Map<String, String> getNumeratorAttributeMap(PhysicalQuantity value) {
        return getAttributeMap(value);
    }

    private Map<String, String> getAttributeMap(PhysicalQuantity value) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("value", value.getQuantity().toString());
        // TM - Redmine 11455 - need to account for units being null
        if (value.getUnit() != null) {
        	result.put("unit", value.getUnit().getCodeValue());
        }
        result.put("xsi:type", "PQ");
        return result;
    }
}
