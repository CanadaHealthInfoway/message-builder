package ca.infoway.messagebuilder.datatype;

import java.util.Set;

/**
 * <p>HL7 datatype SET. Backed by a java Set.
 * 
 * <p>Used when multiple repetitions are allowed, order is irrelevant and duplicates are prohibited.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the SET 
 * @param <V> the underlying Java datatype held by the underlying Java Set
 */
public interface SET<T extends ANY<V>, V> extends COLLECTION<Set<T>, V> {

	/**
	 * <p>Returns the underlying Java Set containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java Set containing values in the underlying Java datatype
	 */
	Set<V> rawSet();
	
	<U extends V> Set<U> rawSet(Class<U> elementType);
	 
}
