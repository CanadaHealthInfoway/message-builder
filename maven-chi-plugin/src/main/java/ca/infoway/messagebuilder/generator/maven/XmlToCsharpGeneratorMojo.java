package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.dotnet.IntermediateToCsharpGenerator;
import ca.infoway.messagebuilder.generator.java.IntermediateToModelConfiguration;
import ca.infoway.messagebuilder.generator.java.IntermediateToModelGenerator;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * <p>This goal converts message sets to the corresponding C# classes.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @goal xml-to-csharp
 */
public class XmlToCsharpGeneratorMojo extends AbstractMojo {

    /**
     * The output directory for the generated files.
     * 
     * @parameter
     * @required
     */
    private File csSourceFolder;
	
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
     * The policy for handling the naming of the resulting classes and properties.
     * 
     * @parameter
     */
    private String namingPolicy;
    
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
		} else if (this.csSourceFolder == null || !this.csSourceFolder.exists() || !this.csSourceFolder.isDirectory()) {
			throw new MojoFailureException("Please specify a valid C# source folder.");
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
			IntermediateToModelGenerator generator = new IntermediateToCsharpGenerator(
					new OutputUIImpl(this), createConfiguration());
			generator.generate(messages);
		} catch (IOException e) {
			throw new MojoExecutionException("IOException", e);
		} catch (Exception e) {
			throw new MojoExecutionException("Exception", e);
		}
	}

	private IntermediateToModelConfiguration createConfiguration() throws MojoFailureException {
		return new IntermediateToModelConfiguration(
				this.csSourceFolder, this.basePackageName, 
				this.generatedReportsDirectory, getNamingPolicy());
	}
	
	private NamingPolicy getNamingPolicy() throws MojoFailureException {
		NamingPolicy policy = NamingPolicy.from(this.namingPolicy);
		if (StringUtils.isNotBlank(this.namingPolicy) && policy == null) {
			throw new MojoFailureException("Naming policy \"" + this.namingPolicy + "\" is not a valid value.");
		} else {
			return policy;
		}
	}

	File getMessageSet() {
		return this.messageSet;
	}

	void setMessageSet(File messageSet) {
		this.messageSet = messageSet;
	}
}
