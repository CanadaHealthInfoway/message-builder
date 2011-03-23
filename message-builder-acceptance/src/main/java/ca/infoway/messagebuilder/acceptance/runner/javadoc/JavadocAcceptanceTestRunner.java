package ca.infoway.messagebuilder.acceptance.runner.javadoc;

import java.util.ArrayList;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;

public class JavadocAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private final JavadocChecker checker;

	private final FilesProvider filesToCheck;

	private final String name;
	
	public JavadocAcceptanceTestRunner(String name, FilesProvider filesToCheck) {
		this(name, new JavadocChecker(), filesToCheck);
	}
	
	JavadocAcceptanceTestRunner(String name, JavadocChecker checker, FilesProvider filesToCheck) {
		this.name = name;
		this.checker = checker;
		this.filesToCheck = filesToCheck;
	}

	public void run(AcceptanceTestResultCallback resultCallback) {
		JavadocCheckerResult result = this.checker.process(filesToCheck.getFiles());
		
		resultCallback.done(
				this.name, 
				result.getTotalCandidateFiles() - result.getFilesMissingJavadoc().size(),
				result.getTotalCandidateFiles(),
				new ArrayList<String>(result.getAllMessages()));
	}

	public FilesProvider getFilesToCheck() {
		return this.filesToCheck;
	}

}
