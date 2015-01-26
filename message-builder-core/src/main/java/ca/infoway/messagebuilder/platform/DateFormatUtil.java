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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.platform;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * @sharpen.ignore platform
 */
public class DateFormatUtil {
	public static boolean isMatchingPattern(String str, String pattern) {
		// this was a performance change made on the .NET side; it isn't really necessary on the Java side, but will improve performance somewhat
		if (StringUtils.length(str) != StringUtils.length(pattern)) {
			return false;
		}
		
		ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        parser.setLenient(false);
        pos.setIndex(0);
        
        Date date = parser.parse(str, pos);
        if (date != null && pos.getIndex() == str.length() && pattern.length() == str.length()) {
        	return true;
        } else {
        	return false;
        }
	}

	public static Date parse(String dateString, String pattern, TimeZone timeZone) {
		ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat parser = new SimpleDateFormat(pattern);
        parser.setTimeZone(timeZone);
        parser.setLenient(false);
        pos.setIndex(0);
        
        return parser.parse(dateString, pos);
	}

	public static String format(Date date, String datePattern) {
		return format(date, datePattern, TimeZone.getDefault());
	}
	
	public static String format(Date date, String datePattern, TimeZone timeZone) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern, Locale.getDefault());
		simpleDateFormat.setTimeZone(timeZone);
		return simpleDateFormat.format(date);
	}

}
