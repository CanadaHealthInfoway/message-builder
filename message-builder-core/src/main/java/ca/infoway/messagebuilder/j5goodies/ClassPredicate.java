package ca.infoway.messagebuilder.j5goodies;

/**
 * <p>An interface used when scanning jars for "interesting" classes.  We 
 * can decide that a class is interesting based on either the class name (which
 * doesn't require that the class be loaded) or attributes of the class itself (such
 * as annotations or things that can be determined by reflection).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public interface ClassPredicate {
	/**
	 * <p>Determine if the class is interesting, based on package name and class name.
	 * @param packageName - the package name of the class.
	 * @param className - the name of the class.
	 * @return - true if the class is interesting; false otherwise.
	 */
	public boolean isSelected(String packageName, String className);
	/**
	 * <p>Determine if the class is interesting.
	 * @param c - the class.
	 * @return - true if the class is interesting; false otherwise.
	 */
	public boolean isSelected(Class<?> c);
}
