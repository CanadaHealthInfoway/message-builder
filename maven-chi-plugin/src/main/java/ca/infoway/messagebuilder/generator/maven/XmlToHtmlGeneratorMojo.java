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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.generator.maven;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import ca.infoway.messagebuilder.maven.util.OutputUIImpl;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * <p>This goal creates HTML Pages of the various packages and interactions.  
 *
 * @goal xml-to-html
 */
public class XmlToHtmlGeneratorMojo extends AbstractMojo {

    /**
     * The output directory for the generated svg files.
     * 
     * @parameter
     * @required
     */
    File htmlFolder;
	
    /**
     * The messageSet used to derive diagrams.
     * 
     * @parameter
     * @required
     */
    File messageSet;
    
    /**
     * The messageSet used to derive diagrams.
     * 
     * @parameter
     */
    Boolean excludeStructuralAttributes;
    
    private HtmlGeneratorFactory factory;
    
    public XmlToHtmlGeneratorMojo() {
    	this(new HtmlGeneratorFactory());
    }
	
	XmlToHtmlGeneratorMojo(HtmlGeneratorFactory htmlGeneratorFactory) {
		this.factory = htmlGeneratorFactory;
	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (this.messageSet == null || !this.messageSet.exists() || this.messageSet.isDirectory()) {
			throw new MojoFailureException("Please specify a valid message set.");
		} else if (this.htmlFolder == null || !this.htmlFolder.exists() || !this.htmlFolder.isDirectory()) {
			throw new MojoFailureException("Please specify a valid HTML output folder.");
		} else {
			generate();
		}
		
	}

	private void generate() throws MojoExecutionException {
		try {
			MessageSet messageSet = new MessageSetMarshaller().unmarshall(this.messageSet);
			this.factory.create(new OutputUIImpl(this)).execute(messageSet, this.htmlFolder, this.excludeStructuralAttributes);
		} catch (IOException e) {
			throw new MojoExecutionException("IOException", e);
		} catch (Exception e) {
			throw new MojoExecutionException("Exception", e);
		}
	}
}
