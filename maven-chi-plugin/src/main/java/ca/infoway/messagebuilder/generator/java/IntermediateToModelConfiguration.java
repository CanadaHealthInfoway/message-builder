package ca.infoway.messagebuilder.generator.java;

import java.io.File;

import ca.infoway.messagebuilder.generator.NamingPolicy;

public class IntermediateToModelConfiguration {

	protected final File sourceFolder;
	protected final String basePackageName;
	private final File reportDirectory;
	private final NamingPolicy namingPolicy;
	
	public IntermediateToModelConfiguration(File sourceFolder,
			String basePackageName, File reportDirectory, NamingPolicy namingPolicy) {
		this.sourceFolder = sourceFolder;
		this.basePackageName = basePackageName;
		this.reportDirectory = reportDirectory;
		this.namingPolicy = namingPolicy == null ? NamingPolicy.getDefaultPolicy() : namingPolicy;
	}
	public File getSourceFolder() {
		return sourceFolder;
	}
	public String getBasePackageName() {
		return basePackageName;
	}
	public File getReportDirectory() {
		return reportDirectory;
	}
	public NamingPolicy getNamingPolicy() {
		return namingPolicy;
	}
}
