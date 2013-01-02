/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ProjectFilesProvider implements FilesProvider {

	private static final String[] FILE_EXTENSIONS = new String[]{"java"};
	private final List<String> projectNames;
	private final boolean includeOnlyMainSource;

	public ProjectFilesProvider(List<String> projectNames) {
		this(projectNames, true);
	}
	
	public ProjectFilesProvider(List<String> projectNames, boolean includeOnlyMainSource) {
		this.projectNames = projectNames;
		this.includeOnlyMainSource = includeOnlyMainSource;
	}
	
	@SuppressWarnings("unchecked")
	public List<File> getFiles() {
		ArrayList<File> results = new ArrayList<File>();
		
		for (String currentProjectRootName : this.projectNames) {
			File currentProjectRootFile = createProjectRootFile(currentProjectRootName);
			System.out.println("project root " +(currentProjectRootFile.exists() ? "exists: " : "not found: ") + currentProjectRootFile.getAbsolutePath());
			if (currentProjectRootFile.exists()) {
				Collection<File> files = FileUtils.listFiles(currentProjectRootFile, FILE_EXTENSIONS, true);
				results.addAll(files);
			}
		}
		
		return results;
	}

	private File createProjectRootFile(String currentProjectRootName) {
		return new File("../" + currentProjectRootName + "/src/" + (includeOnlyMainSource ? "main/java/" : ""));
	}

	public List<String> getProjectNames() {
		return this.projectNames;
	}

}
