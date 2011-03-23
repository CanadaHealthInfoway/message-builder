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

		if (code1 != null && code1.isAssignableFrom(code2)) {
			return relationship1.getDomainType();
		} else if (code2 != null && code2.isAssignableFrom(code1)) {
			return relationship2.getDomainType();
		} else {
			// TODO - TM - could also try walking up each code's hierarchy looking for a compatible domain type
			//           - this only affects one group of types in MR2009, so I'll leave this as an enhancement
			return null;
		}
	}

	public static boolean hasDomainType(Relationship relationship, String domainType) {
		return relationship != null && StringUtils.equals(relationship.getDomainType(), domainType);
	}
}
