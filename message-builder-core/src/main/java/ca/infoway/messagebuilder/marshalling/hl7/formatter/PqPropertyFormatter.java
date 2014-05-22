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

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.ANYMetaData;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.lang.XmlStringEscape;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.PqValidationUtils;
import ca.infoway.messagebuilder.util.xml.XmlRenderingUtils;

/**
 * PQ - Physical Quantity
 *
 * Represents a Physical Quantity object as an element:
 *
 * &lt;element-name value="123.33" unit="mg"/&gt;
 * 
 */
@DataTypeHandler("PQ")
public class PqPropertyFormatter extends AbstractAttributePropertyFormatter<PhysicalQuantity> {
	
	public static final String ATTRIBUTE_UNIT = "unit";
	public static final String ATTRIBUTE_VALUE = "value";
	
	private final PqValidationUtils pqValidationUtils = new PqValidationUtils();

    @Override
    Map<String, String> getAttributeNameValuePairs(FormatContext context, PhysicalQuantity physicalQuantity, BareANY bareANY) {
    	
        validatePhysicalQuantity(context, physicalQuantity, bareANY);
		
        return createPhysicalQuantityAttributes(physicalQuantity, bareANY);
    }

	private void validatePhysicalQuantity(FormatContext context, PhysicalQuantity physicalQuantity, BareANY bareANY) {
		
		// does not validate originalText here as this section is bypassed when value is a NullFlavor
		
		String type = context.getType();
        ModelToXmlResult errors = context.getModelToXmlResult();
        
        boolean hasNullFlavor = (bareANY == null || bareANY.getNullFlavor() != null);
        
        String quantityAsString = physicalQuantity.getQuantity() == null ? null : physicalQuantity.getQuantity().toPlainString();
		this.pqValidationUtils.validateValue(quantityAsString, context.getVersion(), type, hasNullFlavor, null, context.getPropertyPath(), errors);
        
		String unitsAsString = (physicalQuantity.getUnit() == null ? null : physicalQuantity.getUnit().getCodeValue());
		this.pqValidationUtils.validateUnits(type, unitsAsString, null, context.getPropertyPath(), errors);
		
	}

	private Map<String, String> createPhysicalQuantityAttributes(PhysicalQuantity physicalQuantity, BareANY bareANY) {
		Map<String, String> result = new HashMap<String, String>();
        if (physicalQuantity.getQuantity() == null) {
            result.put(NULL_FLAVOR_ATTRIBUTE_NAME, NULL_FLAVOR_NO_INFORMATION);
        } else {
        	result.put(ATTRIBUTE_VALUE, formatQuantity(physicalQuantity.getQuantity()));
        } 
        
        // if unit is null, then this is considered an "each"
        if (physicalQuantity.getUnit() != null) {
            result.put(ATTRIBUTE_UNIT, physicalQuantity.getUnit().getCodeValue());
        }

		return result;
	}
	
	@Override
	public String format(FormatContext context, BareANY hl7Value, int indentLevel) {
		String result = super.format(context, hl7Value, indentLevel);
		
		if (hl7Value != null) {
			String originalText = ((ANYMetaData) hl7Value).getOriginalText();
			boolean hasNullFlavor = hl7Value.hasNullFlavor();
			boolean hasAnyValues = hasAnyValues(hl7Value);
			this.pqValidationUtils.validateOriginalText(context.getType(), originalText, hasAnyValues, hasNullFlavor, context.getVersion(), null, context.getPropertyPath(), context.getModelToXmlResult());
			
			// complete hack for BC
			if (SpecificationVersion.isExactVersion(context.getVersion(), SpecificationVersion.V02R04_BC)) {
				if (hasNullFlavor && hasAnyValues(hl7Value)) {
					// dump the result and rebuild, adding in NF
	    			Map<String, String> attributeNameValuePairs = getAttributeNameValuePairs(context, (PhysicalQuantity) hl7Value.getBareValue(), hl7Value);
	    			attributeNameValuePairs.putAll(createNullFlavorAttributes(hl7Value.getNullFlavor()));
					result = createElement(context, attributeNameValuePairs, indentLevel, true, true);
				}
			}
			
			if (StringUtils.isNotBlank(originalText)) {
				String otElement = createElement("originalText", null, indentLevel + 1, false, false);
				otElement += XmlStringEscape.escape(originalText);
				otElement += XmlRenderingUtils.createEndElement("originalText", 0, true);
				// pulling off the end "/>" is not the most elegant solution, but superclass would need significant refactoring otherwise
				result = result.substring(0, result.indexOf("/>")) + ">" + LINE_SEPARATOR 
						+ otElement 
						+ XmlRenderingUtils.createEndElement(context.getElementName(), indentLevel, true);
			}
		}

		return result;
	}

    private boolean hasAnyValues(BareANY hl7Value) {
    	boolean result = false;
    	if (hl7Value != null && hl7Value.getBareValue() != null && hl7Value.getBareValue() instanceof PhysicalQuantity) {
    		PhysicalQuantity pq = (PhysicalQuantity) hl7Value.getBareValue();
    		result = (pq.getQuantity() != null || pq.getUnit() != null);
    	}
		return result;
	}

	private String formatQuantity(BigDecimal quantity) {
    	// Redmine 1570 - don't change value even if incorrect; just call toString on it
        return quantity.toPlainString(); 
    }
}
