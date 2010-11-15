package ca.infoway.messagebuilder.j5goodies;

/**
 * @sharpen.ignore j5goodies - Translated manually 
 */
abstract class AbstractClassPredicate implements ClassPredicate {
	public boolean isSelected(String packageName, String className) {
		return true;
	}
	public boolean isSelected(Class<?> c) {
		return true;
	}
}
