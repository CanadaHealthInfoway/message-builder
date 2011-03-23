package ca.infoway.messagebuilder.generator.dotnet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

/**
 * <p>Convert from package name format to namespace format.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class NamespaceHelper {

	static String toNamespace(String namespace) {
		String[] parts = StringUtils.split(namespace, ".");
		for (int i = 0, length = parts == null ? 0 : parts.length; i < length; i++) {
			parts[i] = WordUtils.capitalize(parts[i]);
		}
		return StringUtils.join(parts, ".");
	}

}
