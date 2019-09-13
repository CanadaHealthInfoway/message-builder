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

package ca.infoway.messagebuilder.generator.lang;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.lang.InteractionType.ArgumentType;
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
		//System.out.println(resultString);

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
	
	@Test
	public void shouldAddComplexTypeForNoArguments() throws IOException {
		System.setProperty("jaxp.debug", "1");
		
		InteractionType interactionType = new InteractionType(new TypeName("MCCI_IN000002CA"));
		interactionType.setBusinessName("Accept Ack");
		
		TypeName parentTypeName = new TypeName("MCCI_MT002200CA.Message");
		Type type = new Type(parentTypeName);
		interactionType.setParentType(type);

		TypeAnalysisResult typeResults = new TypeAnalysisResult();
		typeResults.getTypes().put(type.getTypeName(), type);
		
		Hl7XsdInteractionTypeWriter writer = new Hl7XsdInteractionTypeWriter(interactionType, typeResults);
		StringWriter stringWriter = new StringWriter();
		writer.write(stringWriter);
		String resultString = stringWriter.toString();
		
		Assert.assertTrue(resultString.contains("<xs:element name=\"acceptAck\" " +	"type=\"chi:MCCI_IN000002CA\"/>"));
		Assert.assertTrue(resultString.contains("<xs:include schemaLocation=\"MCCI_MT002200CA.xsd\"/>"));
		Assert.assertTrue(resultString.contains("<xs:complexType name=\"MCCI_IN000002CA\"") && resultString.contains("<xs:extension base=\"chi:MCCI_MT002200CA.Message\">"));
	}
	
	@Test
	public void shouldAddComplexTypeForArgumentWithChoices() throws IOException {
			
		InteractionType interactionType = new InteractionType(new TypeName("COMT_IN200000CA"));
		interactionType.setBusinessName("Clinical summary/profile query response");
		
		Argument controlActArgument = new Argument();
		Type controlActType = new Type(new TypeName("QUQI_MT120006CA.ControlActEvent"));
		TypeName parentTypeName = new TypeName("MCCI_MT002300CA.Message");
		
		Type type = new Type(parentTypeName);
		interactionType.setParentType(type);
		Relationship messageRelationship = new Relationship();
		messageRelationship.setTemplateParameterName("ControlActEvent");
		messageRelationship.setName("controlActEvent");
		type.getRelationships().add(new Association(messageRelationship, new TemplateVariable("T")));

		Relationship controlActRelationship = new Relationship();
		controlActRelationship.setName("queryByParameter");
		controlActRelationship.setType("QUQI_MT120006CA.QueryByParameter");
		
		Type queryByParameterType = new Type(new TypeName("QUQI_MT120006CA.QueryByParameter"));
		Relationship parameterListRelationship = new Relationship();
		parameterListRelationship.setTemplateParameterName("parameterList");
		parameterListRelationship.setName("REPC_MT000008CA.ParameterList");
		queryByParameterType.getRelationships().add(new Association(parameterListRelationship, new TemplateVariable("T")));
		controlActType.getRelationships().add(Association.createStandardAssociation(controlActRelationship, queryByParameterType));

		Relationship controlActRelationship2 = new Relationship();
		controlActRelationship2.setName("subject");
		controlActRelationship2.setType("QUQI_MT120006CA.Subject2");

		Type subjectType = new Type(new TypeName("QUQI_MT120006CA.Subject2"));
		Relationship summaryRelationship = new Relationship();
		summaryRelationship.setTemplateParameterName("act");
		summaryRelationship.setName("COMT_MT111111CA.Summary");
		subjectType.getRelationships().add(new Association(summaryRelationship, new TemplateVariable("T")));
		
		Relationship choice1 = new Relationship();
		choice1.setName("renderedContent1");
		choice1.setType("COMT_MT111111CA.RenderedContent");
		
		Relationship choice2 = new Relationship();
		choice2.setName("sHR1");
		choice2.setType("COMT_MT111111CA.SHR");
		
		Relationship choice3 = new Relationship();
		choice1.setName("immunization");
		choice1.setType("POIZ_MT061150CA.Immunization");

		Relationship subChoice21 = new Relationship();
		subChoice21.setName("document1");
		subChoice21.setType("REPC_MT230002CA.Document");
		
		Relationship subChoice22 = new Relationship();
		subChoice21.setName("document2");
		subChoice21.setType("REPC_MT220002CA.Document");
		
		Relationship subChoice23 = new Relationship();
		subChoice21.setName("document3");
		subChoice21.setType("REPC_MT210002CA.Document");
		
		choice2.getChoices().add(subChoice21);
		choice2.getChoices().add(subChoice22);
		choice2.getChoices().add(subChoice23);
		
		controlActType.getRelationships().add(Association.createStandardAssociation(controlActRelationship2, subjectType));

		controlActArgument.setName("MFMI_MT700751CA.ControlActEvent");
		controlActArgument.setTemplateParameterName("ControlActEvent");
		ArgumentType controlActArgumentType = new ArgumentType(controlActArgument, controlActType.getTypeName());

		Argument paramPayload = new Argument();
		Type paramPayloadType = new Type(new TypeName("REPC_MT000008CA.ParameterList"));
		paramPayload.setName("PRPA_MT101103CA.ParameterList");
		paramPayload.setTemplateParameterName("parameterList");
		ArgumentType paramPayloadArgumentType = new ArgumentType(paramPayload, paramPayloadType.getTypeName());
		controlActArgumentType.getArgumentTypes().add(paramPayloadArgumentType);

		Argument sumPayload = new Argument();
		Type sumPayloadType = new Type(new TypeName("COMT_MT111111CA.Summary"));
		sumPayloadType.setAbstract(true);
		sumPayload.setName("COMT_MT111111CA.Summary");
		sumPayload.setTemplateParameterName("act");
		sumPayload.getChoices().add(choice1);
		sumPayload.getChoices().add(choice2);
		sumPayload.getChoices().add(choice3);
		
		ArgumentType sumPayloadArgumentType = new ArgumentType(sumPayload, sumPayloadType.getTypeName());
		controlActArgumentType.getArgumentTypes().add(sumPayloadArgumentType);
		
		interactionType.getArguments().add(controlActArgumentType);

		TypeAnalysisResult typeResults = new TypeAnalysisResult();
		typeResults.getTypes().put(controlActType.getTypeName(), controlActType);
		typeResults.getTypes().put(type.getTypeName(), type);
		typeResults.getTypes().put(queryByParameterType.getTypeName(), queryByParameterType);
		typeResults.getTypes().put(paramPayloadType.getTypeName(), paramPayloadType);
		typeResults.getTypes().put(subjectType.getTypeName(), subjectType);
		typeResults.getTypes().put(sumPayloadType.getTypeName(), sumPayloadType);
		
		Hl7XsdInteractionTypeWriter interactionWriter = new Hl7XsdInteractionTypeWriter(interactionType, typeResults);
		StringWriter stringWriter = new StringWriter();
		interactionWriter.write(stringWriter);
		String resultString = stringWriter.toString();

		Assert.assertTrue(resultString.contains("<xs:include schemaLocation=\"COMT_MT111111CA.xsd\"/>"));
		Assert.assertTrue(resultString.contains("<xs:complexType name=\"COMT_MT111111CA.Summary\""));
		Assert.assertTrue(resultString.contains("<xs:group maxOccurs=\"1\" minOccurs=\"0\" ref=\"chi:COMT_MT111111CA.Summary\"/>"));
	}
}
