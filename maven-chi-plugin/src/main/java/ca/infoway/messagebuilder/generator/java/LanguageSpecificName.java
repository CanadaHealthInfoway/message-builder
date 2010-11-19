package ca.infoway.messagebuilder.generator.java;

public class LanguageSpecificName {

	private String className;
	private String packageName;
	
	public LanguageSpecificName(String packageName, String className) {
		this.packageName = packageName;
		this.className = className;
	}
	
	public String getUnqualifiedClassName() {
		return this.className;
	}

	public String getPackageName() {
		return this.packageName;
	}
	
	public String getFullyQualifiedName() {
		return this.packageName + "." + this.className;
	}
}
