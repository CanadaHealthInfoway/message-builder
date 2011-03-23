package ca.infoway.messagebuilder.platform;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

/**
 * @sharpen.ignore platform
 */
public class ClassUtil {

	public static boolean isAbstract(Class<?> javaClass) {
		return Modifier.isAbstract(javaClass.getModifiers());
	}

	@SuppressWarnings("unchecked")
	public static Object newInstance(Class type) {
		try {
			return type.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException("Unable to instantiate " + type);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Unable to instantiate " + type);
		}
	}
	
	public static boolean isGeneric(Class<?> partClass) {
		TypeVariable<?>[] parameters = partClass.getTypeParameters();
		return parameters != null && parameters.length > 0;
	}
}
