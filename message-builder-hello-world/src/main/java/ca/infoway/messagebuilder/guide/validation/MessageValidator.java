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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.guide.validation;

import static ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault;

import java.io.IOException;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.guide.hello_world.HelloWorldApp;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.validator.MessageValidatorImpl;
import ca.infoway.messagebuilder.xml.validator.MessageValidatorResult;

/**
 * <p>
 * Example Message Validation. Uses the MB validation API to validate the files
 * in the command-line arguments
 * </p>
 * <p>
 * The pan-Canadian specifications supported used are base R02.04.02 release.
 * 
 * </p>
 */
public class MessageValidator {

	public static void main(final String[] args) throws Exception {
		MessageValidator app = new MessageValidator();
		app.run(args);
	}

	public void run(String[] args) {
		try {
			configureCodeResolversWithTrivialDefault(); // Relaxes code
														// vocabulary code
														// checks.
			MessageValidatorImpl validator = this.createNewValidator();
			MessageValidatorResult result = validator.validate(createDocument("PRPA_EX101104CA.xml"), HelloWorldApp.MBSpecificationVersion);

			System.out.printf("There are %d errors\n", result.getHl7Errors().size());
			Iterator<Hl7Error> resultsIterator = result.getHl7Errors().iterator();
			while (resultsIterator.hasNext()) {
				Hl7Error hl7Err = resultsIterator.next();
				System.out.printf("Error: %s at XPath: %s\n", hl7Err.getMessage(), hl7Err.getPath());
			}
		} catch (IOException e) {
			// Problem opening the source file to validate
			e.printStackTrace();
		} catch (SAXException e) {
			// XML parsing error
			e.printStackTrace();
		}
	}

	public static void validate(String xmlString, VersionNumber versionNumber) {
		try {
			
			System.out.println("\nValidation Errors:");
			Document document = new DocumentFactory().createFromString(xmlString);
			MessageValidatorImpl validator = new MessageValidatorImpl();
			MessageValidatorResult result = validator.validate(document, versionNumber);
				
			System.out.printf("There are %d errors\n", result.getHl7Errors().size());
			Iterator<Hl7Error> resultsIterator = result.getHl7Errors().iterator();
			while (resultsIterator.hasNext()) {
				Hl7Error hl7Err = resultsIterator.next();
				System.out.printf("Error (%s): %s at XPath: %s\n", hl7Err.getHl7ErrorCode(), hl7Err.getMessage(), hl7Err.getPath());				
			}
		} catch (SAXException e) {
			// XML parsing error
			e.printStackTrace();
		}
	}

	private Document createDocument(String resourceName) throws IOException, SAXException {
		// For our example, we'll use the resource XML document that are in the
		// jar.
		return new DocumentFactory().createFromStream(getClass().getResourceAsStream(resourceName));
	}
	
	private MessageValidatorImpl createNewValidator() {
		return new MessageValidatorImpl();
	}

}