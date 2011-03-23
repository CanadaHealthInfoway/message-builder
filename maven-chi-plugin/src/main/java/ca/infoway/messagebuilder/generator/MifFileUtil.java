package ca.infoway.messagebuilder.generator;

import static java.util.Arrays.asList;
import static org.apache.commons.io.FilenameUtils.getExtension;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class MifFileUtil {
	
	private static final String[] FILE_EXTENSIONS = new String[]{"mif", "dmif", "coremif"};

	/**
	 * <p>Scans the given directory for 'mif' and 'dmif' files
	 * 
	 * @param mifDirectory
	 * @return a list of mif files or null if not found
	 */
	@SuppressWarnings("unchecked")
	public static Collection<File> getMifFiles(File mifDirectory) {
		if (mifDirectory.isDirectory()) {
			return FileUtils.listFiles(mifDirectory, FILE_EXTENSIONS, true);
		} else if (mifDirectory.isFile() && asList(FILE_EXTENSIONS).contains(getExtension(mifDirectory.getName()))) {
			return Arrays.asList(mifDirectory);
		} else {
			return null;
		}
	}

}
