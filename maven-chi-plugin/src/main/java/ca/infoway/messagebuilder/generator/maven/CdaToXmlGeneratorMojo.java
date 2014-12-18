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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.cda.CdaToXmlGenerator;
import ca.infoway.messagebuilder.tools.CdaMessageSetValidator;
import ca.infoway.messagebuilder.tools.MessageSetValidator.MessageSetValidatorError;
import ca.infoway.messagebuilder.xml.MessageSet;

/**
 * <p>This goal converts MIFs to the XML message sets.  
 *
 * @goal cda-to-xml
 */
public class CdaToXmlGeneratorMojo extends AbstractMojo {
	
    /**
     * <p>The base schema file.
     * 
     * @parameter default-value="${project.build.directory}/POCD_MT000040.xsd
     * @required
     */
    private File schema;
    
    /**
     * <p>The supplementary schema file.
     * 
     * @parameter
     */
    private File supplementarySchema;
    
    /**
     * <p>The template file.
     * 
     * @parameter 
     * @required
     */
    private File template;
    
    /**
     * <p>The vocabulary definition file.
     * 
     * @parameter 
     * @required
     */
    private File vocabulary;
    
    /**
     * <p>Indicates whether to use R2 datatypes.
     * 
     * @parameter 
     */
    private Boolean r2Datatypes;
    
    /**
     * <p>The output message set file.
     * 
     * @parameter default-value="${project.build.directory}/messageSet.xml"
     * @required
     */
    private File messageSet;
    
    private final MessageSetGeneratorFactory factory;
    
	/**
	 * <p>Default constructor.
	 */
    public CdaToXmlGeneratorMojo() {
    	this(new MessageSetGeneratorFactoryImpl());
    }
    
	CdaToXmlGeneratorMojo(MessageSetGeneratorFactory factory) {
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
		if (schema == null || !schema.exists() || !schema.isFile()) {
			throw new MojoExecutionException("Please specify a valid base model schema.");
		} else if (template == null || !template.exists() || !template.isFile()) {
			throw new MojoExecutionException("Please specify a valid template file.");
		} else if (vocabulary == null || !vocabulary.exists() || !vocabulary.isFile()) {
			throw new MojoExecutionException("Please specify a valid vocabulary definition file.");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException, MojoFailureException {
		try {
			CdaToXmlGenerator generator = this.factory.createForCda(this, this.r2Datatypes);
			MessageSet generatedMessageSet = generator.processAllCdaFiles(this.schema, this.supplementarySchema, this.template, this.vocabulary);
			generator.writeToMessageSet(this.messageSet);
			
			if (generatedMessageSet != null) { 
				List<MessageSetValidatorError> results = new CdaMessageSetValidator(generatedMessageSet).validate();
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

	public File getSchema() {
		return schema;
	}

	public void setSchema(File schema) {
		this.schema = schema;
	}

	public File getSupplementarySchema() {
		return supplementarySchema;
	}

	public void setSupplementarySchema(File supplementarySchema) {
		this.supplementarySchema = supplementarySchema;
	}

	public File getTemplate() {
		return template;
	}

	public void setTemplate(File template) {
		this.template = template;
	}

	public File getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(File vocabulary) {
		this.vocabulary = vocabulary;
	}

	public boolean isR2Datatypes() {
		return r2Datatypes;
	}

	public void setR2Datatypes(boolean r2Datatypes) {
		this.r2Datatypes = r2Datatypes;
	}

}
