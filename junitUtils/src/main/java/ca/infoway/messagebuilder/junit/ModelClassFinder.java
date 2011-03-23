package ca.infoway.messagebuilder.junit;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.lang.ClassUtils;

/**
 * 
 * @sharpen.ignore
 */
public class ModelClassFinder {
    public static final File srcDirectory = new File("./src/main/java");

    public static List<File> getAllModelFiles(Class<?>... modelClasses) {
    	List<File> files = new ArrayList<File>();
    	for (Class<?> c : modelClasses) {
    		String packageName = ClassUtils.getPackageName(c);
			files.addAll(getModelFilesInPackage(packageName));
		}
        return files;
    }

    public static List<File> getAllModelFiles(String... packageNames) {
    	List<File> files = new ArrayList<File>();
    	for (String packageName : packageNames) {
			files.addAll(getModelFilesInPackage(packageName));
		}
        return files;
    }

	private static List<File> getModelFilesInPackage(String packageName) {
		File packageDirectory = new File(srcDirectory, packageName.replace('.', File.separatorChar));
        return Arrays.asList(packageDirectory.listFiles((FilenameFilter) FileFilterUtils.suffixFileFilter(".java")));
	}
	
}
