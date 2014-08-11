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
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.marshalling;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeResolver;
import ca.infoway.messagebuilder.xml.Relationship;

public class DomainTypeHelper {
	
	private static DomainTypeResolver domainTypeResolver = new DomainTypeResolver();

	public static Class<? extends Code> getReturnType(Relationship relationship, VersionNumber version) {
		return getReturnType(relationship.getDomainType(), version);
	}
	
	public static Class<? extends Code> getReturnType(String domainType, VersionNumber version) {
		Class<? extends Code> type = getReturnType(domainType);
		if (type == Code.class) {
			String sanitizedDomainType = sanitize(domainType);
			Class<? extends Code> codeType = MessageBeanRegistry.getInstance().getCodeType(sanitizedDomainType, version.getVersionLiteral());
			if (codeType != null) {
				type = codeType;
			}
		}
		return type;
	}
	
	@SuppressWarnings("unchecked")
	private static Class<Code> getReturnType(String domainType) {
		String sanitizedDomainType = sanitize(domainType);
		if (ClassUtils.getShortClassName(HealthcareProviderRoleType.class).equalsIgnoreCase(sanitizedDomainType)) {
			sanitizedDomainType = ClassUtils.getShortClassName(HealthcareProviderRoleType.class);
		} else if (ClassUtils.getShortClassName(OtherIDsRoleCode.class).equals(sanitizedDomainType)) {
			sanitizedDomainType = ClassUtils.getShortClassName(OtherIdentifierRoleType.class);
		}
		if (StringUtils.isNotBlank(sanitizedDomainType)) {
			Class<?> result = domainTypeResolver.resolveDomainTypeUniquely(sanitizedDomainType);
			if (result == null) {
				return Code.class;
			}
			// TM - this code may not run properly in .NET
			return (Class<Code>) result;
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
		Class<? extends Code> code1 = getReturnType(relationship1.getDomainType());
		Class<? extends Code> code2 = getReturnType(relationship2.getDomainType());

		String result = null;
		if (code1 != null && code2 != null) {
			if (code1.isAssignableFrom(code2)) {
				result = relationship1.getDomainType();
			} else if (code2.isAssignableFrom(code1)) {
				result = relationship2.getDomainType();
			}
			// TM - could also try walking up each code's hierarchy looking for a compatible domain type
			//    - this only affects one group of types in MR2009, so I'll leave this as an enhancement
		} else if (code1 != code2) {
			System.out.println("WARNING: one of the relationships seems to be missing a domainType");
		}
		return result;
	}

	public static boolean hasDomainType(Relationship relationship, String domainType) {
		return relationship != null && StringUtils.equals(relationship.getDomainType(), domainType);
	}
	
	public static String sanitize(String domainName) {
		if (domainName == null) {
			return null;
		} else {
			StringBuilder builder = new StringBuilder();
			boolean capitalize = false;
			for (char c : domainName.toCharArray()) {
				if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".indexOf(c) >= 0) {
					builder.append(capitalize ? Character.toUpperCase(c) : c);
					capitalize = false;
				} else {
					capitalize = true;
				}
			}
			return builder.toString();
		}
	}
}