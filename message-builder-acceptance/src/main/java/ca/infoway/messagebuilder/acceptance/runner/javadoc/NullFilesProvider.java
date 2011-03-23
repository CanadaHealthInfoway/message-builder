package ca.infoway.messagebuilder.acceptance.runner.javadoc;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class NullFilesProvider implements FilesProvider {

	public List<File> getFiles() { 
		System.out.println(new File(".").getAbsolutePath());
		return Collections.emptyList();
	}

}
