package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.generator.java.IntermediateToXsdGenerator;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * This goal converts message sets to the corresponding xsd schemas.
 *
 * @goal xml-to-xsd
 */
public class XmlToXsdGeneratorMojo extends AbstractMojo {

    /**
     * The output directory for the report.
     * 
     * @parameter default-value="src/main/resources"
     * @required
     */
    private File xsdSourceFolder;
	
    /**
     * The base package name to use
     * 
     * @parameter
     * @required
     */
    private String basePackageName;
    
    /**
     * The output directory for the report.
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
		} else if (this.xsdSourceFolder == null || !this.xsdSourceFolder.exists() || !this.xsdSourceFolder.isDirectory()) {
			throw new MojoFailureException("Please specify a valid xsd source folder.");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException {
		try {
			MessageSet messages = new MessageSetMarshaller().unmarshall(this.messageSet);
			IntermediateToXsdGenerator generator = new IntermediateToXsdGenerator(new OutputUIImpl(this), 
					this.xsdSourceFolder, this.basePackageName);
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
