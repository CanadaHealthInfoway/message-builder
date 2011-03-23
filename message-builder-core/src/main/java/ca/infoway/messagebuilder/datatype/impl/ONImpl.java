package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.ON;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;

/**
 * <p>Hl7 Datatype ON. backed by java datatype OrganizationName.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class ONImpl extends ENImpl<OrganizationName> implements ON {

	private static final long serialVersionUID = -2602097698910945042L;

	/**
	 * <p>Constructs an empty ON. 
	 */
	public ONImpl() {
		this((OrganizationName) null);
	}

	/**
	 * <p>Constructs an ON with the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public ONImpl(OrganizationName defaultValue) {
		super(OrganizationName.class, defaultValue, null, StandardDataType.ON);
	}
	
}
