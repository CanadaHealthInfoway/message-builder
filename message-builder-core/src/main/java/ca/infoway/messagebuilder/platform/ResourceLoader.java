package ca.infoway.messagebuilder.platform;

import java.io.InputStream;

/**
 * @sharpen.ignore platform
 */
public class ResourceLoader {

	public static InputStream getResource(Class<?> class1, String string) {
		return class1.getResourceAsStream(string);
	}

}
