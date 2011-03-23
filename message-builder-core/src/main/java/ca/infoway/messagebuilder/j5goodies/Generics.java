package ca.infoway.messagebuilder.j5goodies;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * <p>This class provides some utilities for dealing with Generics in the bean
 * definitions of collections.
 * 
 * @author BC Holmes
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class Generics {
	
	/**
	 * <p>Determine the return type of a collection property.  For example, consider the
	 * following getter:
	 * 
	 * <pre>
	 * public List&lt;String&gt; getNames() {
	 *    ...
	 * }
	 * </pre>
	 * 
	 * <p>In this case, the getElementType method will return "String".
	 * 
	 * @param descriptor - the property descriptor of the generic property
	 * @return - the Type of the parameterized return type
	 */
	public static Type getParameterType(PropertyDescriptor descriptor) {
		return getParameterType(descriptor.getReadMethod().getGenericReturnType());
	}

	/**
	 * <p>Get the type of a particular parameterized type.
	 * 
	 * @param type - the generic return type
	 * @return - the Type of the parameterized return type
	 */
	public static Type getParameterType(Type type) {
		if (type instanceof ParameterizedType) {
			Type[] parameters = ((ParameterizedType) type).getActualTypeArguments();
			if (parameters != null && parameters.length == 1) {
				return parameters[0];
			} else {
				throw new IllegalArgumentException("Parameterized type has more than one parameter type " + type);
			}
		} else {
			throw new IllegalArgumentException("Expected parameterized type : " + type);
		}
	}

	/**
	 * <p>This method is used to determine if the type is a Parameterized Type that 
	 * implements the Collection interface (typically a List or a Set).  Note that Maps
	 * do not implement the Collection interface.
	 * 
	 * @param type - the generic return type
	 * @return - true if the type is a collection type that is parameterized
	 */
	@SuppressWarnings("unchecked")
	public static boolean isCollectionParameterizedType(Type type) {
		if (!(type instanceof ParameterizedType)) {
			return false;
		} else if (((ParameterizedType) type).getRawType() instanceof Class) {
			return Collection.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType());
		} else {
			return false;
		}
	}
}

