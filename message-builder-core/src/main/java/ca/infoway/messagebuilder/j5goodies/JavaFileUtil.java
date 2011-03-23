package ca.infoway.messagebuilder.j5goodies;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * <p>A utility to convert a file location (representing a Java source file) into a 
 * class name.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class JavaFileUtil {

	/**
	 * <p>Convert the file name into its corresponding Java class name.
	 * @param root - the file that represents the source tree
	 * @param file - the file that represents the Java source file.
	 * @return - the name of the Java class
	 */
	public static String convertFileNameToJavaClassName(String root, File file) {
		String rootName = root + File.separator;
		if (file.getAbsolutePath().startsWith(rootName)) {
			String fileName = StringUtils.substringAfter(file.getAbsolutePath(), rootName);
			return FilenameUtils.removeExtension(fileName).replace(File.separatorChar, '.');
		} else {
			throw new IllegalArgumentException(rootName 
					+ " doesn't look like the root of " + file.getAbsolutePath());
		}
	}
	
	public static String convertFileNameToJavaClassName(File root, File file) {
		return convertFileNameToJavaClassName(root.getAbsolutePath(), file);
	}
}
