package ca.infoway.messagebuilder.platform;

import java.util.Map;

/**
 * @sharpen.ignore platform
 */
public class GenericClassUtil {

	public static Object instantiate(Class<?> partClass, Map<String, Class<?>> map) 
			throws InstantiationException, IllegalAccessException {
		return partClass.newInstance();
	}

}
