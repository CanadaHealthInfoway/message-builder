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

package ca.infoway.messagebuilder.simple.xml.parser;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.simple.xml.ParserException;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

public class PhysicalQuantityXmlParser extends AbstractSimpleXmlParser<PQ, PhysicalQuantity> implements SimpleXmlParser<PQ> {

    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";
	
	PhysicalQuantityXmlParser() {
		super();
	}

	@Override
	protected void doRenderNonNullValue(StringBuilder builder, SimpleXmlParseContext context, StandardDataType dataType, PhysicalQuantity value) throws ParserException {
	}

	@Override
	protected Map<String, String> toNameValuePairs(StandardDataType dataType, PhysicalQuantity physicalQuantity, SimpleXmlParseContext context) {
		Map<String, String> result = new LinkedHashMap<String, String>();
        if (physicalQuantity.getQuantity() != null) {
            result.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
            if (physicalQuantity.getUnit() != null) {
                result.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
            }
        }
        return result;
    }

    private String formatQuantity(BigDecimal quantity) {
        return quantity.toString();
    }

	@Override
	protected boolean closeStartElement(PQ dataTypeInstance) {
		return true;
	}
	
}
