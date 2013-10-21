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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
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
		String type = context.getType();
        ModelToXmlResult errors = context.getModelToXmlResult();
        
        String quantityAsString = physicalQuantity.getQuantity() == null ? null : physicalQuantity.getQuantity().toPlainString();
		this.pqValidationUtils.validateValue(quantityAsString, context.getVersion(), type, null, context.getPropertyPath(), errors);
        
		String unitsAsString = (physicalQuantity.getUnit() == null ? null : physicalQuantity.getUnit().getCodeValue());
		this.pqValidationUtils.validateUnits(type, unitsAsString, null, context.getPropertyPath(), errors);
		
		if (bareANY != null) { 
			String originalText = ((ANYImpl<?>) bareANY).getOriginalText();
			this.pqValidationUtils.validateOriginalText(type, originalText, null, context.getPropertyPath(), errors);
		}
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
			String originalText = ((ANYImpl<?>) hl7Value).getOriginalText();
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

    private String formatQuantity(BigDecimal quantity) {
    	// Redmine 1570 - don't change value even if incorrect; just call toString on it
        return quantity.toPlainString(); 
    }
}
