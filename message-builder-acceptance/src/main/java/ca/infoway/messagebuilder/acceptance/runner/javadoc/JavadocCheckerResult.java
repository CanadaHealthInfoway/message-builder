/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
