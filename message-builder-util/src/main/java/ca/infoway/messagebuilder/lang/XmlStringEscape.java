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

package ca.infoway.messagebuilder.lang;


public class XmlStringEscape {

    public static String escape(String str) {
    	StringBuilder builder = new StringBuilder();
    	
        int len = str == null ? 0 : str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            String entityName = entityName(c);
            if (entityName == null) {
                if (c > 0x7F) {
                    builder.append("&#");
                    int ascii = c;
                    builder.append(ascii);
                    builder.append(';');
                } else {
                    builder.append(c);
                }
            } else {
                builder.append('&');
                builder.append(entityName);
                builder.append(';');
            }
        }
        return builder.toString();
    }

	private static String entityName(char c) {
		switch (c) {
		case '\'':
			return "apos";
		case '&':
			return "amp";
		case '<':
			return "lt";
		case '>':
			return "gt";
		case '"':
			return "quot";
		default:
			return null;
		}
	}
	
	
}
