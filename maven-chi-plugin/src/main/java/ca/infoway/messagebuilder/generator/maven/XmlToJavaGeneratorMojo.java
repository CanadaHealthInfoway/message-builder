package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.SystemUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * This goal converts message sets to the corresponding Java classes.
 *
 * @goal xml-to-java
 */
public class XmlToJavaGeneratorMojo extends AbstractMojo {

    /**
     * The output directory for the generated files.
     * 
     * @parameter default-value="${project.build.sourceDirectory}"
     * @required
     */
    private File javaSourceFolder;
	
    /**
     * The output directory for the report.
     * 
     * @parameter 
     */
    private File generatedReportsDirectory;
    
    /**
     * The base package name to use
     * 
     * @parameter
     * @required
     */
    private String basePackageName;
    
    /**
     * The messageSet to be converted.
     * 
     * @parameter
     * @required
     */
    private File messageSet;
	
    /**
     * <p>Perform the generation.  Read in the message set, and create
     * the corresponding Java classes.
     * 
     * @throws MojoExecutionException 
     *      - if the plugin is incorrectly configured 
     * @throws MojoFailureException
     *      - if the generator failed
     */
	public void execute() throws MojoExecutionException, MojoFailureException {

		if (this.messageSet == null || !this.messageSet.exists() || this.messageSet.isDirectory()) {
			throw new MojoFailureException("Please specify a valid message set.");
		} else if (this.javaSourceFolder == null || !this.javaSourceFolder.exists() || !this.javaSourceFolder.isDirectory()) {
			throw new MojoFailureException("Please specify a valid Java source folder.");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException {
		try {
			if (this.generatedReportsDirectory == null) {
				this.generatedReportsDirectory = SystemUtils.getJavaIoTmpDir();
			}
			this.generatedReportsDirectory.mkdirs();
			
			MessageSet messages = new MessageSetMarshaller().unmarshall(this.messageSet);
			IntermediateToJavaGenerator generator = new IntermediateToJavaGenerator(new OutputUIImpl(this), 
					this.javaSourceFolder, this.basePackageName, this.generatedReportsDirectory);
			generator.generate(messages);
		} catch (IOException e) {
			throw new MojoExecutionException("IOException", e);
		} catch (Exception e) {
			throw new MojoExecutionException("Exception", e);
		}
	}

	File getMessageSet() {
		return this.messageSet;
	}

	void setMessageSet(File messageSet) {
		this.messageSet = messageSet;
	}
}
