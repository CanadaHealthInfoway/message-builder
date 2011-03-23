package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype CE. Backed by a Code.
 * 
 * <p>Coded data that consists of a coded value and, optionally, coded value(s) from other coding systems that 
 * identify the same concept. Used when alternative codes may exist.
 * 
 * <p>Note: The use of this data type has been reviewed and the recommendation is to use CD instead. Namely 
 * because the only difference between CD and CE was the use of the qualifier property, which is no longer 
 * being used for this release. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying Code
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class CEImpl extends CDImpl implements CE {
	
	private static final long serialVersionUID = 4717993197097911922L;

	/**
	 * <p>Constructs an empty CE.
	 */
	public CEImpl() {
		this((Code) null);
	}

	/**
	 * <p>Constructs a CE with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public CEImpl(Code defaultValue) {
		super(defaultValue, null, StandardDataType.CE);
	}

	/**
	 * <p>Constructs a CE with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public CEImpl(NullFlavor nullFlavor) {
		super(null, nullFlavor, StandardDataType.CE);
	}
	
	/**
	 * <p>Constructs a CE using the supplied parameters.
	 * 
	 * @param value a value
	 * @param nullFlavor a  null flavor
	 * @param dataType an HL7 datatype
	 */
	public CEImpl(Code value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(value, nullFlavor, dataType);
	}
	
}
