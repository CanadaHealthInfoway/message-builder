package ca.infoway.messagebuilder.generator.java;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class XsdNameTranslator implements NameTranslator {

	private final String basePackageName;
	private NameCoordinator nameCoordinator;
	private Map<TypeName, Type> types;
	
	public XsdNameTranslator(String basePackageName, TypeNameHelper helper) {
		this.basePackageName = basePackageName;
		this.types = helper.getTypes();
		this.nameCoordinator = new SimpleNameCoordinator(helper);
	}
	public XsdNameTranslator(String basePackageName, NameCoordinator nameCoordinator) {
		this.basePackageName = basePackageName;
		this.nameCoordinator = nameCoordinator;
	}
	
	public String getClassNameWithoutPackage(TypeName name) {
		return this.nameCoordinator.getName(name);
	}

	public String getFullyQualifiedClassName(TypeName name) {
		return getPackageName(name) + "." + this.nameCoordinator.getName(name);
	}

	public String getPackageName(TypeName name) {
		String baseName = this.basePackageName;
		if (this.types != null && this.types.containsKey(name)) {
			String category = this.types.get(name).getCategory();
			if (StringUtils.isNotBlank(category)) {
				baseName += "." + category;
			}
		}
		return baseName;
	}
}
