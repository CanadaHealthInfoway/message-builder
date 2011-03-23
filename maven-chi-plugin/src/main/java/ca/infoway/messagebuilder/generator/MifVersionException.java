package ca.infoway.messagebuilder.generator;

import java.io.File;

/**
 * <p>An exception that gets thrown when trying to process more than one MIF that are
 * not all of the same version.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MifVersionException extends GeneratorException {

	private static final long serialVersionUID = 7127767928650429991L;
	
	/**
	 * <p>Standard constructor.
	 * 
	 * @param file - the file containing the MIF
	 * @param version - the version number of the file.
	 * @param mifVersion - the version number of the other files processed so far.
	 */
	public MifVersionException(File file, String version, String mifVersion) {
		super("File " + file.getName() + " uses MIF version " + version + " although other files use version " + mifVersion);
	}
}
