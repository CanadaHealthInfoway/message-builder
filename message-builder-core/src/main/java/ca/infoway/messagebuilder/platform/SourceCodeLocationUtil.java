package ca.infoway.messagebuilder.platform;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @sharpen.ignore platform
 */
public class SourceCodeLocationUtil {

	public static final String SOURCE_DIRECTORY = new File("./src/main/java").getAbsolutePath();
	
	public static List<File> getAllSourceFiles(String javaPackage) {
		File sourceFolder = new File(SOURCE_DIRECTORY + "/" + javaPackage.replace('.', File.separatorChar));
		return Arrays.asList(FileUtil.getFilesInDirectoryBySuffix(sourceFolder.getAbsolutePath(), ".java"));
	}
	
}
