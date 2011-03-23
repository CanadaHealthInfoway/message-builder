package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

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
public class PNImpl extends ENImpl<PersonName> implements PN {

	private static final long serialVersionUID = 3129178545240545639L;

	/**
	 * <p>Constructs an empty PN.
	 */
	public PNImpl() {
		this((PersonName) null);
	}

	/**
	 * <p>Constructs a PN with the given value.
	 * 
	 * @param defaultValue an intial value
	 */
	public PNImpl(PersonName defaultValue) {
		super(PersonName.class, defaultValue, null, StandardDataType.PN);
	}

	/**
	 * <p>Constructs a PN with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PNImpl(NullFlavor nullFlavor) {
		super(PersonName.class, null, nullFlavor, StandardDataType.PN);
	}
	
}
