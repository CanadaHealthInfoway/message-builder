/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.j5goodies.CamelCaseUtil;

public class TemplateVariableNameUtil {

	public static String transform(String templateParameterName) {
		String[] words = StringUtils.split(CamelCaseUtil.convertToWords(templateParameterName));
		if (words.length == 1 && words[0].length() <= 3) {
			return words[0].toUpperCase();
		} else {
			StringBuilder builder = new StringBuilder();
			for (String word : words) {
				builder.append(word.substring(0,1).toUpperCase());
			}
			return builder.toString();
		}
	}
}
