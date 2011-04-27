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

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * A utility class used for gauging the degree that two type names match. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class NameMatcher {

	/**
	 * Compares two type names to see how close a match they are.
	 * 
	 * @param type first type to match
	 * @param otherType second type to match
	 * @return the degree of matching
	 */
	public MatchType matchNames(NamedType type, NamedType otherType) {
		if (StringUtils.isNotBlank(type.getBusinessName()) && StringUtils.isNotBlank(otherType.getBusinessName())) {
			return matchBusinessNames(type, otherType);
		} else if (StringUtils.isNotBlank(type.getBusinessName()) || StringUtils.isNotBlank(otherType.getBusinessName())) {
			return matchesTypeNames(type, otherType) == MatchType.MAJOR_DIFFERENCE
				? MatchType.MAJOR_DIFFERENCE
				: MatchType.MINOR_DIFFERENCE;
		} else {
			return matchesTypeNames(type, otherType);
		}
	}

	private MatchType matchBusinessNames(NamedType type, NamedType otherType) {
		if (StringUtils.equals(type.getBusinessName(), otherType.getBusinessName())) {
			return MatchType.EXACT;
		} else if (MatchType.EXACT == matchesTypeNames(type, otherType)) {
			return MatchType.MINOR_DIFFERENCE;
		} else {
			return MatchType.MAJOR_DIFFERENCE;
		}
	}

	private MatchType matchesTypeNames(NamedType type, NamedType otherType) {
		TypeName name = type.getTypeName();
		TypeName otherName = otherType.getTypeName();
		return matchesTypeNames(name, otherName);
	}

	private MatchType matchesTypeNames(TypeName name, TypeName otherName) {
		if (StringUtils.equals(name.getUnqualifiedName(), otherName.getUnqualifiedName())) {
			return MatchType.EXACT;
		} else if (StringUtils.equals(removeSuffix(name.getUnqualifiedName()), removeSuffix(otherName.getUnqualifiedName()))) {
			return MatchType.MINOR_DIFFERENCE;
		} else {
			return MatchType.MAJOR_DIFFERENCE;
		}
	}

	private String removeSuffix(String name) {
		while (name.length() > 0) {
			if (StringUtils.isNumeric(name.substring(name.length()-1))) {
				name = StringUtils.left(name, name.length()-1);
			} else {
				break;
			}
		}
		return name;
	}
}
