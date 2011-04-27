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

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public abstract class WhitespaceUtil {

	public static String normalizeWhitespace(String xml) {
		StringBuilder builder = new StringBuilder();
		boolean text = true;
		for (StringTokenizer tokenizer = new StringTokenizer(xml, "<>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			
			if ("<".equals(token)) {
				text = false;
				builder.append(token);
			} else if (">".equals(token)) {
				text = true;
				builder.append(token);
			} else if (!text || StringUtils.isNotBlank(token)) {
				builder.append(token);
			}
		}
		return builder.toString().trim();
	}
}
