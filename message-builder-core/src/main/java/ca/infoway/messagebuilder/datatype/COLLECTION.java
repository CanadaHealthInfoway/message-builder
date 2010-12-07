package ca.infoway.messagebuilder.datatype;

import java.util.Collection;

/**
 * <p>HL7 Datatype COLLECTION. Backed by a Collection.
 * 
 * <p>The super-interface for LIST and SET.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the hl7 type
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface COLLECTION<T extends Collection<?>, V> extends ANY<T> {

	/**
	 * <p>Returns the underlying collection.
	 * 
	 * @return the underlying collection
	 */
	Collection<V> rawCollection();
	
	/**
	 * <p>Returns the element type.
	 * 
	 * @return the element type
	 */
	Class<?> getElementType();
}
