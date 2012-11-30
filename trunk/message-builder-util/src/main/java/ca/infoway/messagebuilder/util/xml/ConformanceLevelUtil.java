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
 * Author:        $LastChangedBy: spd $
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */

package ca.infoway.messagebuilder.util.xml;

public class ConformanceLevelUtil {
	public static final String ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED = "Association is ignored and can not be used: ({0})";
	public static final String ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED = "Association is ignored and will not be used: ({0})";
	public static final String ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED = "Attribute is ignored and can not be used: ({0})";
	public static final String ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED = "Attribute is ignored and will not be used: ({0})";
	public static final String ASSOCIATION_IS_NOT_ALLOWED = "Association is not allowed: ({0})";
	public static final String ATTRIBUTE_IS_NOT_ALLOWED = "Attribute is not allowed: ({0})";
	public static final String IGNORED_AS_NOT_ALLOWED = "ignored.as.not.allowed";
	
	public static boolean isIgnoredNotAllowed() {
		return Boolean.TRUE.toString().equalsIgnoreCase(System.getProperty(IGNORED_AS_NOT_ALLOWED));
	}
}
