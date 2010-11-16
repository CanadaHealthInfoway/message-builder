package ca.infoway.messagebuilder.j5goodies;

import java.lang.annotation.Annotation;

import org.apache.commons.lang.StringUtils;

/**
 * <p>Provides some standard class finder predicates.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class Predicates {

	/**
	 * <p>Construct a predicate that finds all classes in a particular package.
	 * 
	 * @param expectedPackageName - the package
	 * @return - the predicate
	 */
	public static ClassPredicate packageNamePredicate(final String expectedPackageName) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(String packageName, String className) {
				return StringUtils.equals(expectedPackageName, packageName);
			}
		};
	}
	/**
	 * <p>Construct a predicate that finds all classes with a particular annotation.
	 * 
	 * @param annotation - the annotation
	 * @return - the predicate
	 */
	public static ClassPredicate hasAnnotationPredicate(final Class<? extends Annotation> annotation) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				return c != null && c.isAnnotationPresent(annotation);
			}
		};
	}
	
	/**
	 * <p>Construct a predicate that finds all classes of a particular type.
	 * 
	 * @param type - the type
	 * @return - the predicate
	 */
	public static ClassPredicate isInstanceofPredicate(final Class<?> type) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				return c != null && type != null && type.isAssignableFrom(c);
			}
		};
	}

	/**
	 * <p>Construct a predicate that finds all classes of a particular type.
	 * 
	 * @param type - the type
	 * @param isInterface - true if the predicate should only return interfaces; 
	 *      false if the predicate should never return interfaces
	 * @return - the predicate
	 */
	public static ClassPredicate isInstanceofPredicate(final Class<?> type, final boolean isInterface) {
		return new AbstractClassPredicate() {
			@Override
			public boolean isSelected(Class<?> c) {
				return c != null && type != null && type.isAssignableFrom(c) && (!isInterface || c.isInterface());
			}
		};
	}
	
}

