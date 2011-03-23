package ca.infoway.messagebuilder.comparator;

import java.io.File;

import ca.infoway.messagebuilder.comparator.BeanAnalyzer.ErrorType;

public class BeanAnalysisError {

	private final String errorMessage;
	private final File file;
	private final ErrorType errorType;

	public BeanAnalysisError(File file, ErrorType errorType, String errorMessage) {
		this.file = file;
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public File getFile() {
		return file;
	}
	
	public String getResult() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.file.getName() + ": ");
		stringBuilder.append(this.errorMessage);
		return stringBuilder.toString();
	}
}
