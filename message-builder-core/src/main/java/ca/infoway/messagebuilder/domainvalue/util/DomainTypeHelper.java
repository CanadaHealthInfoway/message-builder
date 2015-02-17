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

package ca.infoway.messagebuilder.domainvalue.util;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.domainvalue.OtherIdentifierRoleType;
import ca.infoway.messagebuilder.xml.Relationship;

public class DomainTypeHelper {
	
	public static Class<? extends Code> getReturnType(Relationship relationship, VersionNumber version, CodeTypeHandler codeTypeHandler) {
		return getReturnType(relationship.getDomainType(), version, codeTypeHandler);
	}
	
	public static Class<? extends Code> getReturnType(String domainType, VersionNumber version, CodeTypeHandler codeTypeHandler) {
		return getReturnType(domainType, version.getVersionLiteral(), codeTypeHandler);
	}
	
	public static Class<? extends Code> getReturnType(String domainType, String version, CodeTypeHandler codeTypeHandler) {
		String sanitizedDomainType = sanitize(domainType);
		Class<? extends Code> type = getReturnType(domainType);
		if (type == null) {
			// try to obtain the domain interface from the appropriate generated API
			type = codeTypeHandler.getCodeType(sanitizedDomainType, version); 
		}
		return type;
	}
	
	@SuppressWarnings("unchecked")
	private static Class<Code> getReturnType(String sanitizedDomainType) {
		// these might be legacy problems with the NFLD API (not released; for testing only)
		if (ClassUtils.getShortClassName(HealthcareProviderRoleType.class).equalsIgnoreCase(sanitizedDomainType)) {
			sanitizedDomainType = ClassUtils.getShortClassName(HealthcareProviderRoleType.class);
		} else if (ClassUtils.getShortClassName(OtherIDsRoleCode.class).equals(sanitizedDomainType)) {
			sanitizedDomainType = ClassUtils.getShortClassName(OtherIdentifierRoleType.class);
		}
		if (StringUtils.isNotBlank(sanitizedDomainType)) {
			try {
				return (Class<Code>) Class.forName("ca.infoway.messagebuilder.domainvalue." + sanitizedDomainType);
			} catch (ClassNotFoundException e) {
				// this is an expected result
			}
		}
		return null;
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
			// the following code was causing more noise than signal; should be logged properly if later deemed necessary to report
//			if (StringUtils.isBlank(relationship1.getDomainType())) {
//				System.out.println("WARNING: relationship seems to be missing a domainType (" + relationship1.getParentType() + "." + relationship1.getName() + ")");
//			}
//			if (StringUtils.isBlank(relationship2.getDomainType())) {
//				System.out.println("WARNING: relationship seems to be missing a domainType (" + relationship2.getParentType() + "." + relationship2.getName() + ")");
//			}
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
