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
 * Last modified: $LastChangedDate: 2014-05-22 15:54:32 -0400 (Thu, 22 May 2014) $
 * Revision:      $LastChangedRevision: 8676 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.PqValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractAttributePropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;

/**
 * PQ - Physical Quantity (R2)
 *
 * Represents a Physical Quantity object as an element:
 *
 * &lt;element-name value="123.33" unit="mg"/&gt;
 * 
 */
@DataTypeHandler("PQ")
public class PqR2PropertyFormatter extends AbstractAttributePropertyFormatter<PhysicalQuantity> {
	
	// translations property specified in schema but not supported here, as per comments from Andrew/Wendy
	
	public static final String ATTRIBUTE_UNIT = "unit";
	public static final String ATTRIBUTE_VALUE = "value";
	
	private final PqValidationUtils pqValidationUtils = new PqValidationUtils();

    @Override
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, PhysicalQuantity physicalQuantity, BareANY bareANY) {
    	
        validatePhysicalQuantity(context, physicalQuantity, bareANY);
		
        return createPhysicalQuantityAttributes(physicalQuantity, bareANY);
    }

	private void validatePhysicalQuantity(FormatContext context, PhysicalQuantity physicalQuantity, BareANY bareANY) {
		
		String type = context.getType();
        ModelToXmlResult errors = context.getModelToXmlResult();
        
        // nothing to validate for value, based on R2 schema 
        
		String unitsAsString = (physicalQuantity.getUnit() == null ? null : physicalQuantity.getUnit().getCodeValue());
		this.pqValidationUtils.validateUnits(type, unitsAsString, null, context.getPropertyPath(), errors, true);
		
	}

	private Map<String, String> createPhysicalQuantityAttributes(PhysicalQuantity physicalQuantity, BareANY bareANY) {
		
		// according to the schema, nullFlavor, value, and unit are all optional (though unit does have a default of "1")
		
		Map<String, String> result = new HashMap<String, String>();
		
        if (physicalQuantity.getQuantity() != null) {
        	result.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
        } 
        
        // if unit is null, then this is considered an "each"
        if (physicalQuantity.getUnit() != null) {
            result.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
        }

		return result;
	}
	
	private String formatQuantity(BigDecimal quantity) {
    	// Redmine 1570 - don't change value even if incorrect; just call toString on it
        return quantity.toPlainString(); 
    }
}
