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

package ca.infoway.messagebuilder.xml;

import java.util.List;

/**
 * <p>A utility helper used to compare message part type names while ignoring a version
 * suffix.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MessagePartVersionSuffixHelper {

	private static final String MESSAGE_PART_VERSION_SUFFIX_SEPARATOR = "_";

	/*
	 * Necessary to support messageSet like NEWFOUNDLAND which are made up of message parts from multiple
	 * CHI versions.
	 */
	/**
	 * <p>Compare two message part types, while ignoring the suffix.
	 * @param type = the type name
	 * @param messagePartNames - a list of message part names to compare against
	 * @return true if a match is found; false otherwise
	 */
	public static boolean matchesDisregardingVersionSuffix(String type, List<String> messagePartNames) {
		boolean result = false;
		if (type != null) {
			for (String hl7PartType : messagePartNames) {
				if (matchesDisregardingVersionSuffix(type, hl7PartType)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * <p>Compare two message part type names, while ignoring the suffix.
	 * @param type = the type name
	 * @param hl7PartType - the type to compare against
	 * @return true if a match is found; false otherwise
	 */
	public static boolean matchesDisregardingVersionSuffix(String type, String hl7PartType) {
		return type.startsWith(hl7PartType + MESSAGE_PART_VERSION_SUFFIX_SEPARATOR);
	}

}
