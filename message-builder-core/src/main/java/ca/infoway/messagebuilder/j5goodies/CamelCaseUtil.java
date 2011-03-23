package ca.infoway.messagebuilder.j5goodies;

/**
 * <p>A utility for working with camel-case strings.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class CamelCaseUtil {

	/**
	 * <p>Take a camel-cased string, and break out the individual words.
	 * @param camelCaseString - the camel case string.
	 * @return - a string of whitespace-separated words.
	 */
	public static String convertToWords(String camelCaseString) {
		char[] chars = camelCaseString == null ? null : camelCaseString.toCharArray();
		
		int length = chars == null ? 0 : chars.length;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (Character.isUpperCase(chars[i])) {
				if (builder.length() > 0) {
					builder.append(' ');
					builder.append(Character.toLowerCase(chars[i]));
				} else {
					builder.append(chars[i]);
				}
			} else if (builder.length() > 0) {
				builder.append(chars[i]);
			} else {
				builder.append(Character.toUpperCase(chars[i]));
			}
		}
		return builder.toString();
	}
}
