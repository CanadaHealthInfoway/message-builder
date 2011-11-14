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

package ca.infoway.messagebuilder.generator;

import org.apache.commons.lang.StringUtils;

/**
 * <p>When we generate model classes from the message sets, we can use one of three
 * policies toward naming:
 * 
 * <ol>
 * <li>Standard names -- relationships and classes use the names as they appear in the 
 * MIF "name" attributes.  Thus, an attribute called "id" will be generated as a class
 * property called "id".
 * <li>Business names -- when business names exist, we will favour the business name.  
 * Otherwise, we'll fall back to the standard name.
 * <li>Mixed -- We will use a business name policy when we're dealing with class/type 
 * names, and use the standard names when we're dealing with relationships/properties.
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public enum NamingPolicy {
	
	STANDARD_NAMES, BUSINESS_NAMES, MIXED_NAMES;

	public static NamingPolicy getDefaultPolicy() {
		return MIXED_NAMES;
	}

	public static NamingPolicy from(String namingPolicy) {
		if (StringUtils.isBlank(namingPolicy)) {
			return null;
		} else {
			try {
				return NamingPolicy.valueOf(StringUtils.trim(StringUtils.upperCase(namingPolicy)));
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
	}
}
