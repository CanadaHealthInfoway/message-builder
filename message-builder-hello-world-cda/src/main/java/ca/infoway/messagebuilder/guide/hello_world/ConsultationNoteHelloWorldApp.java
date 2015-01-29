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
package ca.infoway.messagebuilder.guide.hello_world;

import ca.infoway.messagebuilder.model.ccda_r00_alpha.interaction.ConsultationNoteBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;


/**
 * <p>CDA Hello world example for a Consultation Note.</p>
 * <p>This example illustrates the use of the Message Builder library to create and receive
 *   a ConsultationNote.</p> 
 *
 * For this example, a ConsultationNote will be created to send, and a ConsultationNote xml message will be received. However, it is quite likely 
 * for a real case to receive something other than a ConsultationNote in response.  
 * 
 */
public class ConsultationNoteHelloWorldApp extends HelloWorldAppBase {

	private String documentXml = "/ConsultationNote.xml";
	
	public static void main(final String[] args) throws Exception {
		ConsultationNoteHelloWorldApp app = new ConsultationNoteHelloWorldApp();
		
		app.createDocumentBeanAndConvertToXml();
		
		app.obtainDocumentXmlAndConvertToBean();
		
		System.out.println("\nDone");
	}
	
	public final void createDocumentBeanAndConvertToXml() {
		
		// this method creates a ConsultationNote object and populates various fields (attempting to match some but not all values in the sample CDA ConsultationNote xml)
		
		// Relaxes code vocabulary code checks and sets up some basic code resolvers
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
		
		ConsultationNoteCreator consultationNoteCreator = new ConsultationNoteCreator();
		ConsultationNoteBean consultationNote = consultationNoteCreator.createConsultationNoteBean();

		@SuppressWarnings("unused")
		String xml = processDocumentObject(consultationNote);

		// note the errors reported about missing the "History of Present Illness Section" - so let's add that section now
		consultationNoteCreator.addHistoryOfPresentIllness(consultationNote);
		
		System.out.println("\n\nModifying objects to clear out some errors. Re-converting to xml");
		xml = processDocumentObject(consultationNote);
		
		// xml can now be used as necessary (embedded in message, sent using a transport mechanism, etc)
	}
	
	public final void obtainDocumentXmlAndConvertToBean() {

		System.out.println("\n\nNow taking a large sample document (as xml) and converting to objects.\n");
		
		// this method takes a full sample ConsultationNote document and converts it into objects, walking the object model and printing out various fields

		// Relaxes code vocabulary code checks and sets up some basic code resolvers.
		// This only needs to be done once (which occurred in createDocumentBeanAndConvertToXml()), but including it here for completeness.
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
		
		String xml = readResourceFile(this.documentXml);
		
		ConsultationNoteBean consultationNote = (ConsultationNoteBean) processDocumentXml(xml);
		
		ConsultationNoteAccessor consultationNoteAccessor = new ConsultationNoteAccessor();
		consultationNoteAccessor.processConsultationNote(consultationNote);
		
	}
	
	

}
