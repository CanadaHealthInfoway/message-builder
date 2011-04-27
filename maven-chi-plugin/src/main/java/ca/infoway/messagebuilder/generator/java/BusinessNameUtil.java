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

package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.StringUtils.contains;
import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.WordUtils.capitalize;

import org.apache.commons.lang.StringUtils;

public class BusinessNameUtil {

	/**
	 * <p> Takes the businessName String, removes special characters, and 
	 * whitespace--returning a CamelCase business name</p>
	 * 
	 * @param businessName
	 * @return CamelCase business name or null if businessName is empty or null
	 */
	public static String cleanUpBusinessName(String businessName) {
		if (StringUtils.isNotEmpty(businessName)) {
			String tempString = businessName;
			if (contains(tempString, ':')) {
				tempString = substringAfterLast(tempString, ":");
			}
			if (!StringUtils.isAlphaSpace(tempString)) {
				tempString = StringUtils.replace(tempString, "?", " ");
				tempString = StringUtils.replace(tempString, "-", " ");
				tempString = StringUtils.replace(tempString, ",", " ");
				tempString = StringUtils.replace(tempString, ".", " ");
				tempString = StringUtils.replace(tempString, "+", " ");
				tempString = StringUtils.replace(tempString, "(", " ");
				tempString = StringUtils.replace(tempString, ")", " ");
				tempString = StringUtils.replace(tempString, "/", " ");
				tempString = StringUtils.replace(tempString, "*", " ");
				tempString = StringUtils.replace(tempString, "'", " ");
				tempString = StringUtils.replace(tempString, "%", " ");
				tempString = StringUtils.replace(tempString, "\\u00A0", " ");
				tempString = StringUtils.replace(tempString, "\\u2007", " ");
				tempString = StringUtils.replace(tempString, "\\u202F", " ");
			}
			
			// assumes trimming will take place when converting to camel case
			tempString = toCamelCase(tempString);
			
			return tempString;
		} else {
			return null;
		}
	}

	/**
	 * <p> Takes a string and returns a CamelCase name with no whitespace</p>
	 * 
	 * @param string
	 * @return CamelCase name or null if string is empty or null
	 */	
	public static String toCamelCase(String string) {
		if (StringUtils.isNotEmpty(string)) {
			// remove unicode non-breaking spaces
			string = string.replaceAll("[\\u00A0\\u2007\\u202F]+", " ");
			string = capitalize(string);
			string = deleteWhitespace(string);
			return string;
		} else {
			return null;
		}
	}
}