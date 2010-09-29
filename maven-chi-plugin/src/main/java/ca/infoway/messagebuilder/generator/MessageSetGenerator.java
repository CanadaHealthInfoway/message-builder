package ca.infoway.messagebuilder.generator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ca.infoway.messagebuilder.generator.maven.FileSet;

/**
 * <p>An interface describing the basic functions of a message set generator.</p>
 * 
 * <p>The message set generator is assumed to be a stateful object, which processes a
 * number of MIFs, and finally writes final output to a message set XML file.</p>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface MessageSetGenerator {
	/**
	 * <p>Process a collection of MIF files, putting the information into a 
	 * format that's ready to write to a message set XML file.</p>
	 * 
	 * @param mifSource - a source of references to MIF files.
	 * @throws GeneratorException - if the generator encounters a problem
	 * @throws IOException - if there's a problem reading any of the files
	 */
	public void processAllMifs(MifSource mifSource) throws GeneratorException, IOException;
	
	/**
	 * <p>Merge a collection of message set xml files, putting the information into a 
	 * format that's ready to write to a message set XML file.</p>
	 * 
	 * @param inputMessageSets - a list of message sets XML files.
	 * @throws GeneratorException - if the generator encounters a problem
	 * @throws IOException - if there's a problem reading any of the files
	 */
	public void processAllMessageSets(List<FileSet> inputMessageSets) throws GeneratorException, IOException;

	/**
	 * <p>Write all processed complex types to a message set XML file.
	 * 
	 * @param outputFile - the location to write the message set XML document.
	 * @throws GeneratorException - if the generator encounters a problem.
	 * @throws IOException - if an error occurs writing to the file.
	 */
	public void writeToMessageSet(File outputFile) throws GeneratorException, IOException;
	
}
