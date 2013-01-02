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
 * Last modified: $LastChangedDate: 2012-01-10 21:44:14 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3332 $
 */
package ca.infoway.messagebuilder.generator.util;

import org.codehaus.plexus.util.StringUtils;

class DomainTypeUtil {

	static DomainType findCommonAncestor(DomainType type1, DomainType type2) {
		DomainType result = null;

		result = findCommonParent(type1, type2);
		
		if (result == null) {
			for (DomainType parent1 : type1.getParentDomainTypes()) {
				result = findCommonAncestor(parent1, type2);
				if (result != null) {
					break;
				}
			}
		}
		if (result == null) {
			for (DomainType parent2 : type2.getParentDomainTypes()) {
				result = findCommonAncestor(type1, parent2);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	private static DomainType findCommonParent(DomainType type1,
			DomainType type2) {
		DomainType result = null;
		outer: for (DomainType parent1 : type1.getParentDomainTypes()) {
			for (DomainType parent2 : type2.getParentDomainTypes()) {
				if (StringUtils.equals(parent1.getName(), parent2.getName())) {
					result = parent1;
					break outer;
				}
			}
		}
		return result;
	}
}
