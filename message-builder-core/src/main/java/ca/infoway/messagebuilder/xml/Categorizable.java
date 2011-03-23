package ca.infoway.messagebuilder.xml;

/**
 * <p>An interface that represents types that have categories.  Categories are 
 * used to segment the standard into segments such as "cr" (for Client Registry) or 
 * "lr" (Location Registry).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface Categorizable {
	/**
	 * <p>Get the category.
	 * @return the category.
	 */
	public String getCategory();
}
