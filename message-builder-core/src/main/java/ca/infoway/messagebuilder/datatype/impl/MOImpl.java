package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 Datatype MO (MO.CAD). Backed by java datatype Money.
 * 
 * <p>Used to convery monetary values in Canadian currency.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class MOImpl extends QTYImpl<Money> implements MO {

	private static final long serialVersionUID = -2175517396842067356L;

	/**
	 * <p>Constructs an empty MO.
	 */
	public MOImpl() {
		this((Money) null);
	}

	/**
	 * <p>Constructs an MO with the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public MOImpl(Money defaultValue) {
		super(Money.class, defaultValue, null, StandardDataType.MO);
	}

	/**
	 * <p>Constructs an MO with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public MOImpl(NullFlavor nullFlavor) {
		super(Money.class, null, nullFlavor, StandardDataType.MO);
	}
	
}
