package ca.infoway.messagebuilder.generator;

import java.io.File;

import org.apache.commons.lang.StringUtils;

public class FileDirectoryUtil {
	
	public static void createDirectoriesIfNeeded(File outputFile) {
		String directoryPath = StringUtils.substringBeforeLast(outputFile.getAbsolutePath(), File.separator);
		if (!StringUtils.equals(directoryPath, outputFile.getAbsolutePath())) {
			File directoryFile = new File(directoryPath);
			if (!directoryFile.exists() && !directoryFile.mkdirs()) {
				throw new IllegalStateException("Could not create directories necessary to write file: " + outputFile.getAbsolutePath());
			}
		}
	}
}
