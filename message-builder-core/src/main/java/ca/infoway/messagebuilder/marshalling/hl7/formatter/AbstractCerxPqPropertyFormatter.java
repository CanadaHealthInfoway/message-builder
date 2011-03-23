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
