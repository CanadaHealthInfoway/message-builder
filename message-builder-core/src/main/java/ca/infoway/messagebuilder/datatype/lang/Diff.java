package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Used to hold a difference value of a given type.  
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the javav type the diff value represents
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class Diff<T> implements BareDiff {

	private final T value;

	/**
	 * <p>Constructs a diff using the supplied parameter.
	 * 
	 * @param value the difference value
	 */
	public Diff(T value) {
		this.value = value;
	}

	/**
	 * <p>Returns the diff value.
	 * 
	 * @return the diff value
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * <p>Returns the diff's null flavor.
	 * 
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		throw null;
	}

	/**
	 * <p>Determines if the diff has null flavor.
	 * 
	 * @return whether the diff has a null flavor set. 
	 */
	public boolean hasNullFlavor() {
		return false;
	}

	/**
	 * <p>Sets a nullflavor on this diff.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public void setNullFlavor(NullFlavor nullFlavor) {
	}

	public Object getBareValue() {
		return getValue();
	}
}
