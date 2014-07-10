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

/**
 * <p>This goal merges two XML message sets into a single XML message set.  
 *
 * @goal multiple-xml-to-xml
 */
public class MultipleXmlToXmlGeneratorMojo extends AbstractMojo {
	
    private static final int MAX_INPUT_MESSAGE_SETS = 2;

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
    private File outputMessageSet;
    
    /**
     * <p>The list of messagesets to merge. Currently only two messagesets can be merged at one time.</p>
     * 
     * @parameter 
     * @required
     */
    private List<FileSet> inputMessageSets;

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
    public MultipleXmlToXmlGeneratorMojo() {
    	this(new MessageSetGeneratorFactoryImpl());
    }
    
	MultipleXmlToXmlGeneratorMojo(MessageSetGeneratorFactory factory) {
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
		if (CollectionUtils.isEmpty(this.inputMessageSets)) {
			throw new MojoExecutionException("Please specify a valid set of input messageset xml files.");
		} else if (CollectionUtils.size(this.inputMessageSets) == 1) {
			throw new MojoExecutionException("Must supply more than 1 messageset to be able to merge.");
		} else if (CollectionUtils.size(this.inputMessageSets) > MAX_INPUT_MESSAGE_SETS) {
			throw new MojoExecutionException("Currently only " + MAX_INPUT_MESSAGE_SETS + "message sets can be merged at one time.");
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

			MessageSetGenerator generator = this.factory.create(this, this.version, this.realmCode, this.descriptiveName, this.generatedReportsDirectory);
			generator.processAllMessageSets(this.inputMessageSets);
			generator.writeToMessageSet(this.outputMessageSet);
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
		return this.outputMessageSet;
	}
	void setOutputFile(File outputFile) {
		this.outputMessageSet = outputFile;
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

	List<FileSet> getInputMessageSets() {
		return this.inputMessageSets;
	}
	void setInputMessageSets(List<FileSet> inputMessageSets) {
		this.inputMessageSets = inputMessageSets;
	}
}
