package ca.infoway.messagebuilder.datatype;

import java.util.List;

/**
 * <p>HL7 datatype LIST. Backed by a java List.
 * 
 * <p>Used when multiple repetitions are allowed and order matters.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the LIST 
 * @param <V> the underlying Java datatype held by the underlying Java List
 * @sharpen.ignore - datatype - translated manually 
 */
public interface LIST<T extends ANY<V>, V> extends COLLECTION<List<T>>  {
	
	/**
	 * <p>Returns the underlying Java List containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java List containing values in the underlying Java datatype
	 */
	List<V> rawList();
	
	<U extends V> List<U> rawList(Class<U> elementType);
}
