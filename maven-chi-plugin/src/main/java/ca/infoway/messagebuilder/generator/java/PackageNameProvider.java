package ca.infoway.messagebuilder.generator.java;

public interface PackageNameProvider {
	public String getPackageName(String name);
	public String getMessageClassPackageName();
	public String getCommonClassPackageName();
}
