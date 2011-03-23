package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import ca.infoway.messagebuilder.marshalling.hl7.DataTypeHandler;



/**
 * CS - Coded Simple
 *
 * Formats a enum into a CS element. The element looks like this:
 *
 * &lt;element-name code="RECENT"/&gt;
 *
 * According to CeRx: code has a limit of 20 characters. This limit is not
 * currently enforced by this class.
 *
 * HL7 implies that variations on this type may use a different name than "code" for
 * the attribute. The use in the controlActProcess is given as an example.
 *
 * http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-CS
 */
@DataTypeHandler("CS")
class CsPropertyFormatter extends AbstractCodePropertyFormatter {
}
