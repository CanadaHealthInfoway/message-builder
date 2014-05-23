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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.BareANYImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;
import ca.infoway.messagebuilder.marshalling.hl7.PqValidationUtils;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;

/**
 * PQ - Physical Quantity
 * 
 * Parses a PQ element into a PhysicalQuantity. The element looks like this:
 * 
 * <element-name value="123.33" unit="unit"/>
 *
 * If a value is null, value is replaced by a null flavor. So the element would look
 * like this:
 * 
 * <element-name nullFlavor="something" />
 * 
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ
 * 
 * CeRx specifies that the quantity is formatted as 99999999.99 with no leading or
 * trailing zeros. This class ignores that particular restriction.  (for MR2007 and MR2009, for most cases this becomes 11.2)
 * 
 */
@DataTypeHandler("PQ")
class PqElementParser extends AbstractSingleElementParser<PhysicalQuantity> {

	private PqValidationUtils pqValidationUtils = new PqValidationUtils();
	
	@Override
	protected PhysicalQuantity parseNonNullNode(ParseContext context, Node node, BareANY result, Type expectedReturnType, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
		Element element = (Element) node;
		
		boolean hasNullFlavor = hasValidNullFlavorAttribute(context, node, xmlToModelResult);
		
		BigDecimal value = this.pqValidationUtils.validateValue(element.getAttribute("value"), context.getVersion(), context.getType(), hasNullFlavor, element, null, xmlToModelResult);
		
		UnitsOfMeasureCaseSensitive unit = this.pqValidationUtils.validateUnits(context.getType(), element.getAttribute("unit"), element, null, xmlToModelResult);

		PhysicalQuantity physicalQuantity = (value != null || unit != null) ? new PhysicalQuantity(value, unit) : null;
		
        // this is not the usual way of doing things; this is to make validation easier
        ((BareANYImpl) result).setBareValue(physicalQuantity);
		
		return physicalQuantity;
	}
	
	@Override
	public BareANY parse(ParseContext context, Node node, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
    	BareANY result = createDataTypeInstance(context != null ? getType(context) : null);
        
    	// RM20416 - some PQ specifications allow for NF to coexist with other properties
        if (hasValidNullFlavorAttribute(context, node, xmlToModelResult)) {
            NullFlavor nullFlavor = parseNullNode(context, node, xmlToModelResult);
            result.setNullFlavor(nullFlavor);
        }
        PhysicalQuantity value = parseNonNullNode(context, node, result, getReturnType(context), xmlToModelResult);
        if (value != null && (value.getQuantity() != null || value.getUnit() != null)) {
        	((BareANYImpl) result).setBareValue(value);
        }
		
		Element element = (Element) node;

		// validation of OT done a bit later below
		String originalText = getOriginalText(element);
		if (hasOriginalText(element)) {
			((PQ) result).setOriginalText(originalText);
		}
		
		boolean hasValues = hasAnyValues(element);
		boolean hasNullFlavor = hasValidNullFlavorAttribute(context, node, xmlToModelResult);
		this.pqValidationUtils.validateOriginalText(context.getType(), originalText, hasValues, hasNullFlavor, context.getVersion(), element, null, xmlToModelResult);
		
		return result;
	}
	
	private boolean hasAnyValues(Element element) {
		return (element.hasAttribute("value") || element.hasAttribute("unit"));
	}

	@Override
	protected BareANY doCreateDataTypeInstance(String typeName) {
		return new PQImpl();
	}
}