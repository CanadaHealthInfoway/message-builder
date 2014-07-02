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
package ca.infoway.messagebuilder.guide.examples.devtools;

import java.io.File;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ChoiceOption;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.ConformanceOption;
import ca.infoway.messagebuilder.util.messagegenerator.InteractionPopulatingUtility.MultipleCardinalityOption;
import ca.infoway.messagebuilder.util.messagegenerator.SampleMessageGenerator;

public class GenerateSampleMessage {

	private static final VersionNumber versionNumber = SpecificationVersion.R02_04_02;

	public static void main(final String[] args) throws Exception {
		GenerateSampleMessage app = new GenerateSampleMessage();
		app.run(args);
	}

	public void run(final String args[]) {

		// *********************************************************************
		// README:
		// There are numerous ways to generate sample messages as illustrated below.
		// You can run the code below and see how it works.		
		// Further documentation can be found on InfoCentral - https://infocentral.infoway-inforoute.ca/3_Tools_and_solutions/Message_Builder/User_Guide/4_Advanced_Usage/Sample_Message_Generator 
		// *********************************************************************
		
		SampleMessageGenerator sampleMessageGenerator;
		String message = "";

		// *********************************************************************
		// Generate a sample message with default settings
		// *********************************************************************
		sampleMessageGenerator = new SampleMessageGenerator();
		message = sampleMessageGenerator.generateSampleMessage("PRPA_IN101103CA", versionNumber);
		System.out.println("Generate a sample message with default settings for version " + versionNumber + " ...");
		System.out.println(message + "\n\n");

		// *********************************************************************
		// Generate a sample message with custom settings
		// *********************************************************************
		sampleMessageGenerator = new SampleMessageGenerator();
		message = sampleMessageGenerator.generateSampleMessage("PRPA_IN101103CA", versionNumber, ConformanceOption.ALL, MultipleCardinalityOption.MAXIMUM_WITH_LIMIT_3, ChoiceOption.ALWAYS_LAST);
		System.out.println("Generate a sample message with custom settings for version " + versionNumber + " ...");
		System.out.println(message + "\n\n");
	
		// *********************************************************************
		// Generate a sample message with a custom datatype value store (ie. custom sample values)
		// *********************************************************************
		sampleMessageGenerator = new SampleMessageGenerator(new MyDefaultDataTypeValueStore());
		message = sampleMessageGenerator.generateSampleMessage("PRPA_IN101103CA", versionNumber);
		System.out.println("Generate a sample message with a custom datatype value store for version " + versionNumber + " ...");
		System.out.println(message + "\n\n");
		
		// *********************************************************************
		// Generate all samples messages for a specific version
		// *********************************************************************
		sampleMessageGenerator = new SampleMessageGenerator();
		File file = new File("C:\\message_builder_sample_messages"); // define the folder where to store all the sample messages
		System.out.println("Generate all sample messages for version " + versionNumber + " ...");
		sampleMessageGenerator.generateSampleMessagesForAllInteractions(versionNumber, file);
		
		// *********************************************************************
		// Generate all samples messages for a specific version
		// *********************************************************************
		InteractionPopulatingUtility ipu = new InteractionPopulatingUtility();
		InteractionBean unKnownInteraction = ipu.createAndPopulateInteraction("PRPA_IN101103CA", versionNumber);
		FindCandidatesQueryBean interaction = (FindCandidatesQueryBean) unKnownInteraction;
		System.out.println("Convert a sample message to java bean and read from it...");
		System.out.println("interaction id is " + interaction.getId());

	}
}
