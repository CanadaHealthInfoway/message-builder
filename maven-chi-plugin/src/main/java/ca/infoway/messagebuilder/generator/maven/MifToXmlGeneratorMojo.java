/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.FileSet;
import ca.infoway.messagebuilder.generator.MessageSetGenerator;
import ca.infoway.messagebuilder.tools.MessageSetValidator;
import ca.infoway.messagebuilder.tools.MessageSetValidator.MessageSetValidatorError;
import ca.infoway.messagebuilder.xml.MessageSet;

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
     * <p>The realmCode of the output.
     * 
     * @parameter 
     */
    private String realmCode;
    
    /**
     * <p>The descriptive name of the output.
     * 
     * @parameter 
     */
    private String descriptiveName;
    
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
    
    /**
     * The output directory for any reports.
     * 
     * @parameter 
     */
    private File generatedReportsDirectory;

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
			if (this.generatedReportsDirectory == null) {
				this.generatedReportsDirectory = SystemUtils.getJavaIoTmpDir();
			}
			this.generatedReportsDirectory.mkdirs();

			MessageSetGenerator generator = this.factory.create(this, this.version, this.realmCode, this.descriptiveName, this.mifTransformer, this.generatedReportsDirectory);
			MessageSet generatedMessageSet = generator.processAllMifs(new MifSourceImpl(this.fileSets));
			generator.writeToMessageSet(this.messageSet);
			
			if (generatedMessageSet != null) { 
				List<MessageSetValidatorError> results = new MessageSetValidator(generatedMessageSet).validate();
				for (MessageSetValidatorError error : results) {
					getLog().info(error.toString());
				}
			}
			
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

	String getRealmCode() {
		return realmCode;
	}
	void setRealmCode(String realmCode) {
		this.realmCode = realmCode;
	}

	String getDescriptiveName() {
		return descriptiveName;
	}
	void setDescriptiveName(String descriptiveName) {
		this.descriptiveName = descriptiveName;
	}

	List<FileSet> getFileSets() {
		return this.fileSets;
	}
	void setFileSets(List<FileSet> fileSets) {
		this.fileSets = fileSets;
	}

}
