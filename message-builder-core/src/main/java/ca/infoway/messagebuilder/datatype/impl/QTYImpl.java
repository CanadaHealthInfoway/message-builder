package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Parent of many amount-related HL7 datatypes (such as PQ, TS, REAL, etc.).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying javav datatype
 * @sharpen.ignore - datatype - translated manually 
 */
public class QTYImpl<V> extends ANYImpl<V> implements QTY<V> {

	private static final long serialVersionUID = -5845770716310555119L;

	/**
	 * <p>Constructs an empty QTY.
	 */
	public QTYImpl() {
		this((V) null);
	}

	/**
	 * <p>Constructs a QTY with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public QTYImpl(V defaultValue) {
		this(null, defaultValue, null, StandardDataType.QTY);
	}

	/**
	 * <p>Constructs a QTY with the given null flavor.
	 * 
	 * @param nullFlavor a null flavir
	 */
	public QTYImpl(NullFlavor nullFlavor) {
		this(null, null, nullFlavor, StandardDataType.QTY);
	}
	
	/**
	 * <p>Constructs a QTY using the supplied parameters.
	 * 
	 * @param rawType the underlying java type
	 * @param value the underlying java value
	 * @param nullFlavor a null flavor
	 * @param dataType an HL7 datatype enum
	 */
	public QTYImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(rawType, value, nullFlavor, dataType);
	}

}
