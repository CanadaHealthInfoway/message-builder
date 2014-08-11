/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.util.text;

import org.apache.commons.lang.StringUtils;

public class RenderUtils {
	
	public static String removeJavaEscapedCharacters(String string) {
		if (StringUtils.contains(string, '\\')) {
			StringBuffer buffer = new StringBuffer();
			char[] charArray = string.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == '\\') {
					if (i < charArray.length - 1 && charArray[i] == 'u') {
						i += 4; // skip unicode value
					} else {
						i += 3; //skip octal value
					}
				} else {
					buffer.append(charArray[i]);
				}
			}
			return buffer.toString();
		}
		return string;
	}
	
}
