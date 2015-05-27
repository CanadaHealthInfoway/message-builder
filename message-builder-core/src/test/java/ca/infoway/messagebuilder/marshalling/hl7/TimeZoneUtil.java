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
 * Last modified: $LastChangedDate: 2015-02-19 12:16:47 -0500 (Thu, 19 Feb 2015) $
 * Revision:      $LastChangedRevision: 9257 $
 */
package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.Date;
import java.util.TimeZone;

/**
 * @sharpen.ignore Used by unit tests for mapping timezones between Java and .NET
 */
public class TimeZoneUtil {

	public static TimeZone getTimeZone(String timeZoneId) {
		return TimeZone.getTimeZone(timeZoneId);
	}
	
	public static int getUTCOffset(String timeZoneId, Date date) {
		return getTimeZone(timeZoneId).getOffset(date.getTime());
	}
}