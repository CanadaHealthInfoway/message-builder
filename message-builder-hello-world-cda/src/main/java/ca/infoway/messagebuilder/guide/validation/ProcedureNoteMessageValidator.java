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
import java.util.List;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.guide.hello_world.HelloWorldAppBase;
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
public class ProcedureNoteMessageValidator {

	public static void main(final String[] args) throws Exception {
		ProcedureNoteMessageValidator app = new ProcedureNoteMessageValidator();
		app.run(args);
	}
	
	// Note: A ProcedureNote document that did not validate "cleanly" was intentionally chosen to illustrate the MB Validator.
	
	// A quick explanation as to what the reported errors/warnings might mean (a full investigation is required to know the exact nature of each problem):
	

	// 1) both of these errors are noting that the templates specified performer to have a cardinality of "1", but the message provided 2 
	
	//	ERROR: Association "performer" has a cardinality of "1", but 2 occurrences were found (<serviceEvent classCode="PCPR">)  at XPath: /ClinicalDocument/documentationOf/serviceEvent
	//	ERROR: Unexpected cardinality on : performer on ProcedureNote.ServiceEvent at XPath: /ClinicalDocument/documentationOf/serviceEvent/performer[1]

	
	// 2) a discrepancy between a fixed code in the templates and the actual code in the message
	
	//	ERROR: Invalid attribute value: expected "PPRF" but was "PRF" (<performer typeCode="PRF">) at XPath: /ClinicalDocument/documentationOf/serviceEvent/performer[1]/@typeCode
	
	
	// 3) These two errors appear contradictory, but the second is a side-effect of the first error. The first one indicates the code provided could not be found in the ActClass code 
	//    resolver. This led to the value not being passed on, and then the fixed code validation logged an error that the value was missing.
	
	//	ERROR: The code, "completed", in element <statusCode> is not a valid value for domain type "ActClass" at XPath: /ClinicalDocument/authorization/consent/statusCode
	//	ERROR: Fixed-value attribute 'statusCode' must have value 'completed' at XPath: /ClinicalDocument/authorization/consent/statusCode
	
	
	// 4) These are *likely* incorrect template ids (though these errors should warrant special attention)
	
	//	WARNING: Could not determine an appropriate match for a choice element: /ClinicalDocument/component/structuredBody/component[6] at XPath: /ClinicalDocument/component/structuredBody/component[6]
	//	WARNING: Could not determine an appropriate match for a choice element: /ClinicalDocument/component/structuredBody/component[8] at XPath: /ClinicalDocument/component/structuredBody/component[8]
	//	WARNING: Could not determine an appropriate match for a choice element: /ClinicalDocument/component/structuredBody/component[14] at XPath: /ClinicalDocument/component/structuredBody/component[14]
	
	
	public void run(String[] args) {
		try {
			System.out.println("Validating a ProcedureNote document:\n");
			
			validate();
		} catch (IOException e) {
			// Problem opening the source file to validate
			e.printStackTrace();
		} catch (SAXException e) {
			// XML parsing error
			e.printStackTrace();
		}
	}

	private void validate() throws IOException, SAXException {
		// Relaxes code vocabulary checks.
		configureCodeResolversWithTrivialDefault();
		
		MessageValidatorImpl validator = this.createNewValidator();
		
		MessageValidatorResult result = validator.validate(createDocument("ProcedureNote.xml"), HelloWorldAppBase.MBSpecificationVersion);

		System.out.printf("There are %d errors and/or warnings\n\n", countErrorsAndWarnings(result.getHl7Errors()));
		Iterator<Hl7Error> resultsIterator = result.getHl7Errors().iterator();
		while (resultsIterator.hasNext()) {
			Hl7Error hl7Err = resultsIterator.next();
			if (hl7Err.getHl7ErrorLevel() != ErrorLevel.INFO) {
				System.out.printf(hl7Err.getHl7ErrorLevel() + ": %s at XPath: %s\n", hl7Err.getMessage(), hl7Err.getPath());
			}
		}
	}

	private static int countErrorsAndWarnings(List<Hl7Error> hl7Errors) {
		int count = 0;
		for (Hl7Error hl7Error : hl7Errors) {
			if (hl7Error.getHl7ErrorLevel() != ErrorLevel.INFO) {
				count++;
			}
		}
		return count;
	}

	private Document createDocument(String resourceName) throws IOException, SAXException {
		// For our example, we'll use the resource XML document that are in the jar.
		return new DocumentFactory().createFromStream(getClass().getResourceAsStream("/"+resourceName));
	}
	
	private MessageValidatorImpl createNewValidator() {
		return new MessageValidatorImpl();
	}

}