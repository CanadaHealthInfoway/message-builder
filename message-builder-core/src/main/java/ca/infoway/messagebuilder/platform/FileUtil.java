package ca.infoway.messagebuilder.platform;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.FileFilterUtils;

/**
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore platform
 */
public class FileUtil {
	
	public static File[] getFilesInDirectoryBySuffix(String directory, String suffix) {
		return new File(directory).listFiles((FilenameFilter) FileFilterUtils.suffixFileFilter(suffix));
	}

}
