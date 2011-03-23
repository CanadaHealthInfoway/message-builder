package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.generator.regen.MergeAllTypesUtil;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * This goal converts message sets to the corresponding Java classes.
 *
 * @goal merge-xml-to-java
 */
public class MultipleXmlToJavaGeneratorMojo extends AbstractMojo {

    /**
     * The output directory for the generated files.
     * 
     * @parameter default-value="${project.build.sourceDirectory}"
     * @required
     */
    private File javaSourceFolder;
	
	/**
     * The base package name to use
     * 
     * @parameter
     * @required
     */
    private String basePackageName;
    
    /**
     * The messageSets to be converted.
     * 
     * @parameter
     * @required
     */
    private List<String> chronologicalMessageSetsToBeMerged;
	
    /**
     * <p>Perform the generation.  Read in the message sets, merge them, and create
     * the corresponding Java classes.
     * 
     * @throws MojoExecutionException 
     *    - if an error was encountered trying to load the entries.
     */
	public void execute() throws MojoExecutionException {

		if (CollectionUtils.isEmpty(this.chronologicalMessageSetsToBeMerged) || this.chronologicalMessageSetsToBeMerged.size() == 1) {
			throw new MojoExecutionException("Please specify a chronological (older -> newer) list of at least two message sets.");
		}

	    List<File> files = new ArrayList<File>();
		
		for (String fileName : this.chronologicalMessageSetsToBeMerged) {
			File messageSet = new File(fileName);
			if (messageSet == null || !messageSet.exists() || messageSet.isDirectory()) {
				throw new MojoExecutionException(MessageFormat.format("An invalid message set was specified at position {0}.", files.size()));
			}
			files.add(messageSet);
		}
		
		if (this.javaSourceFolder == null || !this.javaSourceFolder.exists() || !this.javaSourceFolder.isDirectory()) {
			throw new MojoExecutionException("Please specify a valid Java source folder.");
		}
		
		generate(files);
	}

	private void generate(List<File> files) throws MojoExecutionException {
		try {
			MessageSetMarshaller marshaller = createMarshaller();
			IntermediateToJavaGenerator generator = createGenerator();
			createMergeUtil(marshaller, generator).generate(files);
		} catch (Exception e) {
			throw new MojoExecutionException("Exception", e);
		}
	}

	MergeAllTypesUtil createMergeUtil(MessageSetMarshaller marshaller, IntermediateToJavaGenerator generator) {
		return new MergeAllTypesUtil(marshaller, generator);
	}

	IntermediateToJavaGenerator createGenerator() {
		return new IntermediateToJavaGenerator(
				new OutputUIImpl(this),	this.javaSourceFolder, this.basePackageName, null);
	}

	MessageSetMarshaller createMarshaller() {
		return new MessageSetMarshaller();
	}

	List<String> getChronologicalMessageSetsToBeMerged() {
		return this.chronologicalMessageSetsToBeMerged;
	}
	void setChronologicalMessageSetsToBeMerged(List<String> chronologicalMessageSetsToBeMerged) {
		this.chronologicalMessageSetsToBeMerged = chronologicalMessageSetsToBeMerged;
	}
	
    void setJavaSourceFolder(File javaSourceFolder) {
		this.javaSourceFolder = javaSourceFolder;
	}

    /**
     * <p>A method to execute the plugin outside of Maven.
     * 
     * @param args - command line arguments
     * @throws Exception - indicates an underlying failure
     */
    public static void main(String[] args) throws Exception {
    	MultipleXmlToJavaGeneratorMojo mojo = new MultipleXmlToJavaGeneratorMojo();
    	
    	mojo.basePackageName = "ca.infoway.messagebuilder.model";
    	mojo.javaSourceFolder = new File("../../javi/src/");
    	mojo.chronologicalMessageSetsToBeMerged = Arrays.asList(
//    			"../message-builder-release-v02_r01/src/main/resources/messageSet_v02_r01.xml",
    			"../message-builder-release-v02_r02/src/main/resources/messageSet_v02_r02.xml", 
    			"../message-builder-release-r02_04_02/src/main/resources/messageSet_r02_04_02.xml"); 
    	mojo.execute();
	}
    
}
