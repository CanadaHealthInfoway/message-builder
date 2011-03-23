package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype for addresses. Backed by the java datatype PostalAddress.
 * 
 * <p>Covers:
 * 
 * <p>AD.BASIC:  Used to communicate addresses for simple display, mailing and contact purposes.  
 *            The data type is not generally suitable for registries.
 * <p>AD.FULL:   Used to communicate fully validatable addresses. Usually appropriate only for registry-type situations.
 * <p>AD.SEARCH: This type is used to convey high level address information for searching purposes. All matches are 
 *            considered to be "starts with" for each specified property.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class ADImpl extends ANYImpl<PostalAddress> implements AD {

	private static final long serialVersionUID = 8235191514425680358L;

	/**
	 * <p>Constructs an empty AD.
	 */
	public ADImpl() {
		this((PostalAddress) null);
	}

	/**
	 * <p>Constructs an AD given the supplied address.
	 * 
	 * @param address the postal address
	 */
	public ADImpl(PostalAddress address) {
		super(PostalAddress.class, address, null, StandardDataType.AD);
	}

	/**
	 * <p>Constructs an AD with the supplied null flavor.
	 * 
	 * @param nullFlavor the null flavor to assign the address
	 */
	public ADImpl(NullFlavor nullFlavor) {
		super(PostalAddress.class, null, nullFlavor, StandardDataType.AD);
	}
	
}
