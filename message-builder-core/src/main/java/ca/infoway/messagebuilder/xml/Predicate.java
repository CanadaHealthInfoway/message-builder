package ca.infoway.messagebuilder.xml;

/**
 * <p>A generic interface for determining whether or not a condition applies.  
 * This interface is typically used while iterating over a number of items in a 
 * collection, to choose one particular option.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @param <T> - the type of item to analyze
 */
public interface Predicate<T> {
	/**
	 * <p>Apply the predicate criteria.
	 * 
	 * @param t - the item to analyze
	 * @return true if the predicate matches; false otherwise
	 */
	boolean apply(T t);
}
