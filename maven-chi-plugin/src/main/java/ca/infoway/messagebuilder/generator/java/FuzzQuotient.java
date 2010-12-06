package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.xml.TypeName;

enum FuzzQuotient implements Fuzziness {
	LEVEL_00, LEVEL_0, LEVEL_1;

	public boolean isWorthChecking(SimplifiableType type, SimplifiableType otherType) {
		switch (this) {
		case LEVEL_00:
			return matchesTypePrefix(type, otherType) && matchesUnqualifiedName(type, otherType);
		case LEVEL_0:
			return matchesTypePrefix(type, otherType);
		default:
			return true;
		}
	}

	private boolean matchesUnqualifiedName(SimplifiableType type,
			SimplifiableType otherType) {
		TypeName name = new TypeName(type.getName());
		TypeName otherName = new TypeName(otherType.getName());
		return StringUtils.equals(name.getUnqualifiedName(), otherName.getUnqualifiedName());
	}

	private boolean matchesTypePrefix(SimplifiableType type, SimplifiableType otherType) {
		return StringUtils.equals(getTypePrefix(type), getTypePrefix(otherType));
	}

	private String getTypePrefix(SimplifiableType type) {
		return StringUtils.substringBefore(type.getName(), "_");
	}
	@Override
	public String toString() {
		return DescribableUtil.getDefaultDescription(name());
	}
}
