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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.generator.lang.IntermediateToXsdGenerator;
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
     * The location of the xsdSimpleDataTypes.xsd file
     * 
     * @parameter
     * @required
     */
   //private File xsdSimpleDataTypeLocation;
    
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
	//	} else if (this.xsdSimpleDataTypeLocation == null || !this.xsdSimpleDataTypeLocation.exists()) {
			//throw new MojoFailureException("Please specify a valid file for the simple data types");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException {
		try {
			MessageSet messages = new MessageSetMarshaller().unmarshall(this.messageSet);
			IntermediateToXsdGenerator generator = new IntermediateToXsdGenerator(new OutputUIImpl(this), 
					this.xsdSourceFolder, this.basePackageName, messages.isGeneratedAsR2());
			//XsdMessageWriterUtil.setXsdSDFolder(this.xsdSimpleDataTypeLocation);
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
