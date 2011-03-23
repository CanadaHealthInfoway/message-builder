package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;


/**
 * PQ - Physical Quantity
 *
 * Represents a Physical Quantity object as an element:
 *
 * &lt;element-name value="123.33" unit="mg"/&gt;
 *
 * This is the default HL7 implementation of the formatter without any wacky CeRx additions.
 *
 * 
 */
@DataTypeHandler("PQ")
public class PqPropertyFormatter extends AbstractPqPropertyFormatter {
}
