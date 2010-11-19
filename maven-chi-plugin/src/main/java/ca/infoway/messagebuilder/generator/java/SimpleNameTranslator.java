package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.TypeName;

public class SimpleNameTranslator implements NameTranslator {

	private final String basePackageName;
	private NameCoordinator nameCoordinator;
	private Map<TypeName, Type> types;
	private final ProgrammingLanguage language;
	private final TypeNameHelper helper;
	
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper) {
		this.language = language;
		this.basePackageName = basePackageName;
		this.helper = helper;
		this.types = helper.getTypes();
		this.nameCoordinator = new SimpleNameCoordinator(helper);
	}
	public SimpleNameTranslator(ProgrammingLanguage language, String basePackageName, TypeNameHelper helper, NameCoordinator nameCoordinator) {
		this.language = language;
		this.basePackageName = basePackageName;
		this.helper = helper;
		this.types = helper.getTypes();
		this.nameCoordinator = nameCoordinator;
	}
	
	public String getClassNameWithoutPackage(TypeName name) {
		return getPrefix(name) + this.nameCoordinator.getName(name) + getSuffix(name);
	}
	private String getSuffix(TypeName name) {
		if (this.language == ProgrammingLanguage.C_SHARP) {
			return "";
		} else if (this.helper.isAbstract(name)) {
			return "";
		} else {
			return "Bean";
		}
	}
	
	private String getPrefix(TypeName name) {
		if (this.language == JAVA) {
			return "";
		} else if (this.helper.isAbstract(name)) {
			return "I";
		} else {
			return "";
		}
	}

	public LanguageSpecificName getLanguageSpecificName(TypeName name) {
		return new LanguageSpecificName(getPackageName(name), getClassNameWithoutPackage(name));
	}
	
	public String getFullyQualifiedClassName(TypeName name) {
		return getPackageName(name) + "." + getClassNameWithoutPackage(name);
	}

	public String getPackageName(TypeName name) {
		String baseName = this.basePackageName;
		if (name.isInteraction()) {
			return baseName + getCategory(name) + ".interaction";
		} else {
			return baseName + getCategory(name) + "." + name.getRootName().getName().toLowerCase();
		}
	}
	private String getCategory(TypeName name) {
		if (this.types != null && this.types.containsKey(name)) {
			String category = this.types.get(name).getCategory();
			if (StringUtils.isNotBlank(category)) {
				category = "." + category;
			}
			return StringUtils.trimToEmpty(category);
		} else {
			return StringUtils.EMPTY;
		}
	}
}
