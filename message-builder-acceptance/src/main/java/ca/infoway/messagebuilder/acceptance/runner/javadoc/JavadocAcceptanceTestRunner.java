/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
