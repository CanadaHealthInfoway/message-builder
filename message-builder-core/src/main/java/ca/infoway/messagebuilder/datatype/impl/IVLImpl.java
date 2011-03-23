package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype IVL. Backed by the java datatype Interval.
 * 
 * <p>This data type is used when a continuous range needs to be expressed.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype of the interval
 * @param <V> the Interval java type, or a subclass
 * @sharpen.ignore - datatype - translated manually 
 */
public class IVLImpl<T extends QTY<?>, V extends Interval<?>> extends ANYImpl<V> implements IVL<T, V> {

	private static final long serialVersionUID = -5984093680112937602L;
	
	private final boolean highClosed;
	private final boolean lowClosed;
	
	/**
	 * <p>Constructs an empty IVL.
	 */
	public IVLImpl() {
		this(false, false, null);
	}

	/**
	 * <p>Constructs an IVL with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public IVLImpl(V defaultValue) {
		this(false, false, defaultValue);
	}

	/**
	 * <p>Constructs an IVL using the supplied parameters.
	 * 
	 * @param lowClosed whether low bound is closed
	 * @param highClosed whether high bound is closed
	 */
	public IVLImpl(boolean lowClosed, boolean highClosed) {
		this(lowClosed, highClosed, null);
	}

	/**
	 * <p>Constructs an IVL using the supplied parameters.
	 * 
	 * @param lowClosed whether low bound is closed
	 * @param highClosed whether high bound is closed
	 * @param defaultValue an initial value
	 */
	public IVLImpl(boolean lowClosed, boolean highClosed, V defaultValue) {
		this(Interval.class, defaultValue, null, StandardDataType.IVL);
	}
	
	/**
	 * <p>Constructs an IVL using the supplied parameters.
	 * 
	 * @param rawType the underlying java type
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType the HL7 datatype
	 */
	public IVLImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		this(rawType, value, nullFlavor, dataType, false, false);
	}

	/**
	 * <p>Constructs an IVL using the supplied parameters.
	 * 
	 * @param rawType the underlying java type
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType the HL7 datatype
	 * @param lowClosed whether low bound is closed
	 * @param highClosed whether high bound is closed
	 */
	public IVLImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType, boolean lowClosed, boolean highClosed) {
		super(rawType, value, nullFlavor, dataType);
		this.lowClosed = lowClosed;
		this.highClosed = highClosed;
	}

	/**
	 * <p>Determines whether the high bound is closed.
	 * 
	 * @return whether the high bound is closed
	 */
	public boolean isHighClosed() {
		return this.highClosed;
	}

	/**
	 * <p>Determines whether the low bound is closed.
	 * 
	 * @return whether the low bound is closed
	 */
	public boolean isLowClosed() {
		return this.lowClosed;
	}
	
}
