package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

class NameMatcher {

	MatchType matchNames(NamedType type, NamedType otherType) {
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
