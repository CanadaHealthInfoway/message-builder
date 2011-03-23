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
