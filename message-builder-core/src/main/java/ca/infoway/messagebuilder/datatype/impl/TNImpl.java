package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 datatype TN backed by the javav datatype TrivialName.
 * 
 * <p>A string used for simple names for things (e.g. drug names) and places (e.g. "Canada Health Infoway")
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class TNImpl extends ENImpl<TrivialName> implements TN {

	private static final long serialVersionUID = -3857569397613505550L;

	/**
	 * <p>Constructs an empty TN.
	 */
	public TNImpl() {
		this((TrivialName) null);
	}

	/**
	 * <p>Constructs a TN using the given value.
	 * 
	 * @param defaultValue the initial value.
	 */
	public TNImpl(TrivialName defaultValue) {
		super(TrivialName.class, defaultValue, null, StandardDataType.TN);
	}

	/**
	 * <p>Constructs a TN having the supplied null flavor. 
	 * 
	 * @param nullFlavor a null flavor
	 */
	public TNImpl(NullFlavor nullFlavor) {
		super(TrivialName.class, null, nullFlavor, StandardDataType.TN);
	}
}
