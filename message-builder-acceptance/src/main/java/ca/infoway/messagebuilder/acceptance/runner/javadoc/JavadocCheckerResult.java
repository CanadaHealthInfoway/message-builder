package ca.infoway.messagebuilder.acceptance.runner.javadoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JavadocCheckerResult {

	private final int totalCandidateFiles;
	private final Map<String, List<String>> filesMissingJavadoc;

	/**
	 * @param totalCandidateFiles The total number of files requiring javadocs.
	 * @param filesMissingJavadoc The files that required a javadocs but didn't have them all.
	 */
	public JavadocCheckerResult(int totalCandidateFiles, Map<String, List<String>> filesMissingJavadoc) {
		this.totalCandidateFiles = totalCandidateFiles;
		this.filesMissingJavadoc = filesMissingJavadoc;
	}

	public int getTotalCandidateFiles() {
		return this.totalCandidateFiles;
	}

	public Map<String, List<String>> getFilesMissingJavadoc() {
		return this.filesMissingJavadoc;
	}
	
	public List<String> getAllMessages() {
		List<String> results = new ArrayList<String>();
		int numMsgs = 0;
		for (List<String> msgs : this.filesMissingJavadoc.values()) {
			results.addAll(msgs);
			numMsgs += msgs.size();
		}
		if (numMsgs > 0) {
			results.add(0, "Total number of javadoc errors: " + numMsgs);
		}
		return results;
	}

}
