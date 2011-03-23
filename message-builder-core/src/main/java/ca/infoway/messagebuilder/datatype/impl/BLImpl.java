package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 datatype BL. Backed by a Boolean.
 * 
 * <p>BL stands for the values of two-valued logic.
 * 
 * <p>A BL value can be either true or false, or, as any other value, may be NULL.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class BLImpl extends ANYImpl<Boolean> implements BL {

	/**
	 * <p>Constructs an empty BL.
	 */
	public BLImpl() {
		this((Boolean) null);
	}

	/**
	 * <p>Constructs a BL with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public BLImpl(Boolean defaultValue) {
		super(Boolean.class, defaultValue, null, StandardDataType.BL);
	}

	/**
	 * <p>Constructs an BL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public BLImpl(NullFlavor nullFlavor) {
		super(Boolean.class, null, nullFlavor, StandardDataType.BL);
	}

}
