package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.ClassUtils;

public abstract class Hl7TypeCodeGenerator extends JavaCodeGenerator {

	protected boolean isInSamePackage(String className) {
		return getPackageName().equals(ClassUtils.getPackageName(className));
	}

	protected abstract String getPackageName();
	public boolean shouldBeFullyQualified(String className) {
		return conflictsWithTypeName(className);
	}

	protected abstract boolean conflictsWithTypeName(String className);
}
