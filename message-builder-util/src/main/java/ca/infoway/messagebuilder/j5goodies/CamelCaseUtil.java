/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
