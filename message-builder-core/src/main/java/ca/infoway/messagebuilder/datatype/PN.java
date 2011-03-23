package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.PersonName;

/**
 * <p>HL7 PN datatype. backed by the Java datatype PersonName.
 * 
 * <p>Covers:
 * 
 * <p>PN.BASIC: Used to express person names for general identification and communication purposes.
 * 
 * <p>PN.SIMPLE: Used to express person names without name parts.
 * 
 * <p>PN.FULL: Used to express person names within a registry where full qualification is needed. 
 * 
 * <p>PN.SEARCH: This type is used to convey name information for searching purposes. All matches are considered to be "starts with" for each specified property. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public interface PN extends EN<PersonName> {

}
