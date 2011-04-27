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

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.platform.NumberFormatter;

/**
 * CeRx specifies that the quantity is formatted as 99999999.99 with no leading or
 * trailing zeros.
 */
public abstract class AbstractCerxPqPropertyFormatter extends AbstractPqPropertyFormatter {

    private static final int MAXIMUM_INTEGER_DIGITS = 11;
    private static final int MAXIMUM_FRACTION_DIGITS = 2;
    private static final int MAXIMUM_LENGTH = MAXIMUM_FRACTION_DIGITS + MAXIMUM_INTEGER_DIGITS + 1;

    @Override
    protected boolean isValidPhysicalQuantity(PhysicalQuantity physicalQuantity) throws ModelToXmlTransformationException {
    	// now we have all values be valid; bad values are rounded by NumberFormat, and a warning message is sent back
        return true;
    }
    
    @Override
    boolean isInvalidValue(FormatContext context, PhysicalQuantity physicalQuantity) {
    	if (physicalQuantity.getQuantity() == null) {
    		return false;
    	} else {
    		return (physicalQuantity.getQuantity().scale() > MAXIMUM_FRACTION_DIGITS) ||
				((physicalQuantity.getQuantity().precision() - physicalQuantity.getQuantity().scale()) > MAXIMUM_INTEGER_DIGITS);
    	}
    }
    
    @Override
    protected String createWarningText(FormatContext context, PhysicalQuantity physicalQuantity) {
    	String warningText = "";
        if (physicalQuantity.getQuantity().scale() > MAXIMUM_FRACTION_DIGITS) {
        	warningText += "PhysicalQuantity can contain a maximum of " + MAXIMUM_FRACTION_DIGITS + " decimal places. Decimal value has been rounded off. ";
        } 
        if ((physicalQuantity.getQuantity().precision() - physicalQuantity.getQuantity().scale()) > MAXIMUM_INTEGER_DIGITS) {
        	warningText += "PhysicalQuantity can contain a maximum of " + MAXIMUM_INTEGER_DIGITS + " integer places. Leading digits have been truncated.";
        }
        return org.apache.commons.lang.StringUtils.isEmpty(warningText) ? super.createWarningText(context, physicalQuantity) : warningText;
    }
    
    @Override
    protected String formatQuantity(BigDecimal quantity) {
        // NumberFormat quietly rounds. This is unfortunate for us. Check before we get to the format step.
    	// UPDATE: we are allowing this behaviour to occur, and sending back a warning message rather than
    	//         aborting via exception.
        return new NumberFormatter().format(quantity, MAXIMUM_LENGTH, MAXIMUM_FRACTION_DIGITS, false); 
    }
}
