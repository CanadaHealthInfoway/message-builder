package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;

/**
 * <p>This goal converts MIFs to the XML message sets.  
 *
 * @goal mif-to-xml
 */
public class MifToXmlGeneratorMojo extends AbstractMojo {
	
    /**
     * <p>The version number of the output.
     * 
     * @parameter 
     * @required
     */
    private String version;
    
    /**
     * <p>The output message set file.
     * 
     * @parameter default-value="${project.build.directory}/messageSet.xml"
     * @required
     */
    private File messageSet;
    
    /**
     * <p>Information about the list of files/directories in which 
     * MIFs can be found.</p>
     * 
     * @parameter 
     * @required
     */
    private List<FileSet> fileSets;

    /**
     * <p>The xsl transform file used to convert Mif2 versions 2.1.4/2.1.5/2.1.6 to 2.1.3.
     * 
     * @parameter
     * @required
     */
    private File mifTransformer;
    
	private final MessageSetGeneratorFactory factory;
    
	/**
	 * <p>Default constructor.
	 */
    public MifToXmlGeneratorMojo() {
    	this(new MessageSetGeneratorFactoryImpl());
    }
    
	MifToXmlGeneratorMojo(MessageSetGeneratorFactory factory) {
		this.factory = factory;
	}

	/**
	 * <p>Perform the major conversion from MIF files to XML message sets.
	 * 
	 * <p>This method first checks all configuration options and then runs the 
	 * message set generator to transform the MIFs into the output message set.
	 * 
     * @throws MojoExecutionException 
     *      - if the plugin is incorrectly configured 
     * @throws MojoFailureException
     *      - if the generator failed
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (CollectionUtils.isEmpty(this.fileSets)) {
			throw new MojoExecutionException("Please specify a valid file sets that contain MIFs.");
		} else if (StringUtils.isBlank(this.version)) {
			throw new MojoExecutionException("Version must be provided.");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException, MojoFailureException {
		try {
			MessageSetGenerator generator = this.factory.create(this, this.version, this.mifTransformer);
			generator.processAllMifs(new MifSourceImpl(this.fileSets));
			generator.writeToMessageSet(this.messageSet);
		} catch (GeneratorException e) {
			getLog().error(e);
			throw new MojoExecutionException("An exception occurred while trying to generate the message set", e);
		} catch (IOException e) {
			getLog().error(e);
			throw new MojoExecutionException("An I/O exception occurred while trying to generate the message set", e);
		} catch (RuntimeException e) {
			getLog().error(e);
			throw new MojoExecutionException("An exception occurred while processing the MIF files", e);
		}
	}

	File getOutputFile() {
		return this.messageSet;
	}
	void setOutputFile(File outputFile) {
		this.messageSet = outputFile;
	}
	String getVersion() {
		return this.version;
	}
	void setVersion(String version) {
		this.version = version;
	}
	List<FileSet> getFileSets() {
		return this.fileSets;
	}
	void setFileSets(List<FileSet> fileSets) {
		this.fileSets = fileSets;
	}
}
