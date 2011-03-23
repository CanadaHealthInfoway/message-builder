package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 datatype INT. Backed by an Integer.
 * 
 * <p>Covers:
 * 
 * <p>INT.POS: This is used to convey an integer number that is greater than or equal to "1".
 * 
 * <p>INT.NONNEG: This is used to convey an integer number that is greater than or equal to "0".
 * 	
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class INTImpl extends QTYImpl<Integer> implements INT {

	private static final long serialVersionUID = -4882987994046782038L;
	
	/**
	 * <p>Constructs an empty INT.
	 */
	public INTImpl() {
		this((Integer) null);
	}
	
	/**
	 * <p>Constructs an INT with the given initial value.
	 * 
	 * @param defaultValue an initial value
	 */
	public INTImpl(Integer defaultValue) {
		super(Integer.class, defaultValue, null, StandardDataType.INT);
	}

	/**
	 * <p>Constructs an INT with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public INTImpl(NullFlavor nullFlavor) {
		super(Integer.class, null, nullFlavor, StandardDataType.INT);
	}
	
}
