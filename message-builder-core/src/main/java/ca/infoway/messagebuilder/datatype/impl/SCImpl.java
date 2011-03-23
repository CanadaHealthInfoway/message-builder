package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.SC;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CodedString;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 datatype SC (Coded String). Backed by the Java datatype CodedString.
 *
 * <p>An ST that optionally may have a code attached. The text must always be present if a code is present. 
 * The code is often a local code.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type
 * @sharpen.ignore - datatype - translated manually 
 */
public class SCImpl<V extends Code> extends ANYImpl<CodedString<V>> implements SC<V> {

	private static final long serialVersionUID = -70703087861875753L;

	/**
	 * <p>Constructs an empty SC.
	 */
	@SuppressWarnings("unchecked")
	public SCImpl() {
		this((CodedString) null);
	}

	/**
	 * <p>Constructs an SC with the given initial value.
	 * 
	 * @param defaultValue the initial value
	 */
	public SCImpl(CodedString<V> defaultValue) {
		super(CodedString.class, defaultValue, null, StandardDataType.SC);
	}

	/**
	 * <p>Constructs an SC with the given null flavor. 
	 * 
	 * @param nullFlavor a null flavor
	 */
	public SCImpl(NullFlavor nullFlavor) {
		super(CodedString.class, null, nullFlavor, StandardDataType.SC);
	}
	
}
