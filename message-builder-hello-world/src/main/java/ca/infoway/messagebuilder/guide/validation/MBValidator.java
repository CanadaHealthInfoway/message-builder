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

import ca.infoway.messagebuilder.guide.hello_world.HelloWorldApp;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;
import ca.infoway.messagebuilder.xml.validator.MessageValidatorResult;
import ca.infoway.messagebuilder.xml.validator.Validator;

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
public class MBValidator {

	public static void main(final String[] args) throws Exception {
		MBValidator app = new MBValidator();
		app.run(args);
	}

	public void run(String[] args) {
		try {
			configureCodeResolversWithTrivialDefault(); // Relaxes code
														// vocabulary code
														// checks.
			Validator validator = this.createNewValidator("PRPA_EX101104CA.xml");
			MessageValidatorResult result = validator.validate();

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

	public static void validate(String xmlString) {
		try {
			
			System.out.println("\nValidation Errors:");
			Document document = new DocumentFactory().createFromString(xmlString);
			MessageDefinitionService messageDefinitionService = new MessageDefinitionServiceFactory().create();
			Validator validator = new Validator(messageDefinitionService, document, HelloWorldApp.MBSpecificationVersion);
			MessageValidatorResult result = validator.validate();
				
			System.out.printf("There are %d errors\n", result.getHl7Errors().size());
			Iterator<Hl7Error> resultsIterator = result.getHl7Errors().iterator();
			while (resultsIterator.hasNext()) {
				Hl7Error hl7Err = resultsIterator.next();
				System.out.printf("Error: %s at XPath: %s\n", hl7Err.getMessage(), hl7Err.getPath());
			}
		} catch (SAXException e) {
			// XML parsing error
			e.printStackTrace();
		}
	}

	private Validator createNewValidator(String resourceName) throws IOException, SAXException {

		// For our example, we'll use the resource XML document that are in the
		// jar.
		Document document = new DocumentFactory().createFromStream(getClass().getResourceAsStream(resourceName));
		// Document document = new
		// DocumentFactory().createFromString(xmlString);
		// Document document = new
		// DocumentFactory().createFromResource(inputStreamResource);
		// Document document = new DocumentFactory().createFromFile(file);

		MessageDefinitionService messageDefinitionService = new MessageDefinitionServiceFactory().create();
		return new Validator(messageDefinitionService, document, HelloWorldApp.MBSpecificationVersion);
	}

}