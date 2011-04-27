/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.java;

import java.io.StringWriter;

import org.junit.Assert;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;


public class Hl7XsdInteractionTypeWriterTest {

	@Test
	public void shouldSimplifyTypeNameForFirstLevelOnly() throws Exception {
		
		System.setProperty("jaxp.debug", "1");
		
		InteractionType interactionType = new InteractionType(new TypeName("PRPA_IN101103CA"));
		interactionType.setBusinessName("Find Candidates Query");
		
		Argument controlActArgument = new Argument();
		Type controlActType = new Type(new TypeName("MFMI_MT700751CA.ControlActEvent"));
		Relationship controlActRelationship = new Relationship();
		controlActRelationship.setName("queryByParameter");
		controlActRelationship.setType("MFMI_MT700751CA.QueryByParameter");

		Type queryByParameterType = new Type(new TypeName("MFMI_MT700751CA.QueryByParameter"));
		Relationship parameterListRelationship = new Relationship();
		parameterListRelationship.setTemplateParameterName("parameterList");
		parameterListRelationship.setName("PRPA_MT101103CA.ParameterList");
		queryByParameterType.getRelationships().add(new Association(parameterListRelationship, new TemplateVariable("T")));

		controlActType.getRelationships().add(Association.createStandardAssociation(controlActRelationship, queryByParameterType ));
		controlActArgument.setName("MFMI_MT700751CA.ControlActEvent");
		controlActArgument.setTemplateParameterName("ControlActEvent");
		ArgumentType controlActArgumentType = new ArgumentType(controlActArgument, controlActType.getTypeName());
		
		Argument payload = new Argument();
		Type payloadType = new Type(new TypeName("PRPA_MT101103CA.ParameterList"));
		payload.setName("PRPA_MT101103CA.ParameterList");
		payload.setTemplateParameterName("parameterList");
		ArgumentType payloadArgumentType = new ArgumentType(payload, payloadType.getTypeName());
		controlActArgumentType.getArgumentTypes().add(payloadArgumentType);
		
		interactionType.getArguments().add(controlActArgumentType);
		TypeName parentTypeName = new TypeName("MCCI_MT002100CA.Message");
		Type type = new Type(parentTypeName);
		interactionType.setParentType(type);
		Relationship messageRelationship = new Relationship();
		messageRelationship.setTemplateParameterName("ControlActEvent");
		messageRelationship.setName("controlActEvent");
		type.getRelationships().add(new Association(messageRelationship, new TemplateVariable("T")));

		TypeAnalysisResult typeResults = new TypeAnalysisResult();
		typeResults.getTypes().put(controlActType.getTypeName(), controlActType);
		typeResults.getTypes().put(queryByParameterType.getTypeName(), queryByParameterType);
		typeResults.getTypes().put(payloadType.getTypeName(), payloadType);
		typeResults.getTypes().put(type.getTypeName(), type);
		
		Hl7XsdInteractionTypeWriter writer = new Hl7XsdInteractionTypeWriter(interactionType, typeResults);
		StringWriter stringWriter = new StringWriter();
		writer.write(stringWriter);
		String resultString = stringWriter.toString();
		System.out.println(resultString);

		Assert.assertTrue("1st level element has simple type", resultString.contains(
				"<xs:element name=\"findCandidatesQuery\" " +
				"type=\"chi:PRPA_IN101103CA\"/>"));
		Assert.assertTrue("1st level type is simple", resultString.contains(
				"<xs:complexType name=\"PRPA_IN101103CA\">"));
		
		// this assert needs to be different if using Xalan or Saxon
		Assert.assertTrue("2nd level has full", resultString.contains( 
				"<xs:element name=\"controlActEvent\"\n" +    // Xalan
				"                           type=\"chi:PRPA_IN101103CA.MFMI_MT700751CA.ControlActEvent\"/>"));
//				"<xs:element name=\"controlActEvent\" " +     // Saxon
//				"type=\"chi:PRPA_IN101103CA.MFMI_MT700751CA.ControlActEvent\"/>"));
		
		Assert.assertTrue("2nd level type is not simple", resultString.contains(
				"<xs:complexType name=\"PRPA_IN101103CA.MFMI_MT700751CA.ControlActEvent\">"));		
	}
}
