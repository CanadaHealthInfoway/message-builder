package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.Interval;

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
public interface IVL<T extends QTY<?>, V extends Interval<?>> extends ANY<V> {

	/**
	 * <p>Determines whether the low bound is closed.
	 * 
	 * @return whether the low bound is closed
	 */
	public boolean isLowClosed();
	
	/**
	 * <p>Determines whether the high bound is closed.
	 * 
	 * @return whether the high bound is closed
	 */
	public boolean isHighClosed();
	
}
