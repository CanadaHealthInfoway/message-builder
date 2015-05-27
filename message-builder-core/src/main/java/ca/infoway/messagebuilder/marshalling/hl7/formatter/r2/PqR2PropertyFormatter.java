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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.PQRImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.PqValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.AbstractNullFlavorPropertyFormatter;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContext;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;

/**
 * PQ - Physical Quantity (R2)
 *
 * Represents a Physical Quantity object as an element:
 *
 * &lt;element-name value="123.33" unit="mg"/&gt;
 * 
 */
@DataTypeHandler({"PQ", "SXCM<PQ>"})
public class PqR2PropertyFormatter extends AbstractNullFlavorPropertyFormatter<PhysicalQuantity> {
	
	public static final String ATTRIBUTE_UNIT = "unit";
	public static final String ATTRIBUTE_VALUE = "value";
	
	private final PqValidationUtils pqValidationUtils = new PqValidationUtils();
    private final SxcmR2PropertyFormatterHelper sxcmHelper = new SxcmR2PropertyFormatterHelper();
    private final PqrR2PropertyFormatter pqrPropertyFormatter = new PqrR2PropertyFormatter();

	@Override
	protected String formatNonNullDataType(FormatContext context, BareANY hl7Value, int indentLevel) {
		
		PhysicalQuantity pq = extractBareValue(hl7Value);
		
    	StringBuilder result = new StringBuilder();
		Map<String, String> attributes = getAttributeNameValuePairs(context, pq, hl7Value);
		
		boolean hasChildContent = !pq.getTranslation().isEmpty();
		result.append(createElement(context, attributes, indentLevel, !hasChildContent, true));
		if (hasChildContent) {
			createChildContent(pq, context, indentLevel + 1, result);
			result.append(createElementClosure(context, indentLevel, true));
		}
		
        return result.toString();
	}

	private void createChildContent(PhysicalQuantity pq, FormatContext context,	int indentLevel, StringBuilder result) {
		FormatContext newContext = new FormatContextImpl("PQR", "translation", context);
		for (CodedTypeR2<Code> translation : pq.getTranslation()) {
			String formattedTranslation = this.pqrPropertyFormatter.format(newContext, new PQRImpl<Code>(translation), indentLevel);
			result.append(formattedTranslation);
		}
	}

	protected String formatNonNullValue(FormatContext context, PhysicalQuantity pq, int indentLevel) {
		throw new UnsupportedOperationException("Call formatNonNullDataType() instead.");
	}
	
	protected
    Map<String, String> getAttributeNameValuePairs(FormatContext context, PhysicalQuantity physicalQuantity, BareANY bareANY) {
    	
        validatePhysicalQuantity(physicalQuantity, bareANY, context);
		
        return createPhysicalQuantityAttributes(physicalQuantity, bareANY, context);
    }

	private void validatePhysicalQuantity(PhysicalQuantity physicalQuantity, BareANY bareANY, FormatContext context) {
		
		String type = context.getType();
        ModelToXmlResult errors = context.getModelToXmlResult();
        
        // nothing to validate for value, based on R2 schema 
        
		String unitsAsString = (physicalQuantity.getUnit() == null ? null : physicalQuantity.getUnit().getCodeValue());
		this.pqValidationUtils.validateUnits(type, unitsAsString, null, context.getPropertyPath(), errors, true);
		
	}

	private Map<String, String> createPhysicalQuantityAttributes(PhysicalQuantity physicalQuantity, BareANY bareAny, FormatContext context) {
		
		// according to the schema, nullFlavor, value, and unit are all optional (though unit does have a default of "1")
		
		Map<String, String> attributes = new HashMap<String, String>();
		
        if (physicalQuantity.getQuantity() != null) {
        	attributes.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
        } 
        
        // if unit is null, then this is considered an "each"
        if (physicalQuantity.getUnit() != null) {
            attributes.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
        }
        
    	this.sxcmHelper.handleOperator(attributes, context, (ANYMetaData) bareAny);

		return attributes;
	}
	
	private String formatQuantity(BigDecimal quantity) {
    	// Redmine 1570 - don't change value even if incorrect; just call toString on it
        return quantity.toPlainString(); 
    }

}
