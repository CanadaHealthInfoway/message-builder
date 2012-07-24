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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.xml.Relationship;

public class DomainTypeHelper {

	@SuppressWarnings("unchecked")
	public static Class<? extends Code> getReturnType(Relationship relationship) {
		String domainType = relationship.getDomainType();
		if (ClassUtils.getShortClassName(HealthcareProviderRoleType.class).equalsIgnoreCase(domainType)) {
			domainType = ClassUtils.getShortClassName(HealthcareProviderRoleType.class);
		} else if (ClassUtils.getShortClassName(OtherIDsRoleCode.class).equals(domainType)) {
			domainType = ClassUtils.getShortClassName(OtherIdentifierRoleType.class);
		}
		if (StringUtils.isNotBlank(domainType)) {
			try {
				return (Class<? extends Code>) Class.forName(ClassUtils.getPackageName(ActCode.class) + "." + domainType);
			} catch (ClassNotFoundException e) {
				return Code.class;
			}
		} else {
			return null;
		}
	}

	/**
	 * Returns a boolean indicating if the two relationships have compatible domain types. 
	 * 
	 * @param relationship1 the first relationship to compare
	 * @param relationship2 the second relationship to compare
	 * @return the string value of a compatible domain type, or null if not compatible or not a domain type
	 * 
	 */
	public static boolean isCompatibleDomainType(Relationship relationship1, Relationship relationship2) {
		return getCompatibleDomainType(relationship1, relationship2) != null;
	}

	/**
	 * Returns the more general of the two domain types, or null if no type is compatible or one of the relations does not have a domain type.
	 * 
	 * @param relationship1 the first relationship to compare
	 * @param relationship2 the second relationship to compare
	 * @return the string value of a compatible domain type, or null if not compatible or not a domain type
	 * 
	 */
	public static String getCompatibleDomainType(Relationship relationship1, Relationship relationship2) {
		// null will be returned for relationships that do not have a domain type
		Class<? extends Code> code1 = getReturnType(relationship1);
		Class<? extends Code> code2 = getReturnType(relationship2);

		String result = null;
		if (code1 != null && code2 != null) {
			if (code1.isAssignableFrom(code2)) {
				result = relationship1.getDomainType();
			} else if (code2.isAssignableFrom(code1)) {
				result = relationship2.getDomainType();
			}
			// TODO - TM - could also try walking up each code's hierarchy looking for a compatible domain type
			//           - this only affects one group of types in MR2009, so I'll leave this as an enhancement
		} else if (code1 != code2) {
			System.out.println("WARNING: one of the relationships seems to be missing a domainType");
		}
		return result;
	}

	public static boolean hasDomainType(Relationship relationship, String domainType) {
		return relationship != null && StringUtils.equals(relationship.getDomainType(), domainType);
	}
}
