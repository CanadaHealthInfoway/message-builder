/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessagePartResolver;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class Mif2InteractionDefinitionTest {
	
	private Mockery jmock = new Mockery();
	private MessagePartResolver resolver = this.jmock.mock(MessagePartResolver.class);
	
	@Test
	public void shouldExtractInteraction() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(resolver).getPackageLocationRootType("MCCI_MT002300CA"); will(returnValue("MCCI_MT002300CA.Message"));
			one(resolver).getPackageLocationRootType("MFMI_MT700726CA"); will(returnValue("MFMI_MT700726CA.ControlActEvent"));
			one(resolver).getPackageLocationRootType("PRPA_MT101102CA"); will(returnValue("PRPA_MT101102CA.IdentifiedEntity"));
			allowing(resolver).getMessagePart( with(any(String.class)) ); will(returnValue(new MessagePart()));
		}});
		
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(getClass(), "PRPA_IN101205CA - Person Revise Event Accept.mif"));
		Interaction interaction = new Mif2InteractionDefinition(document, "myCategory", null, null).extract(this.resolver);
		assertEquals("name", "PRPA_IN101205CA", interaction.getName());
		assertEquals("category", "myCategory", interaction.getCategory());
		assertEquals("businessName", "Person Revise Event Accept", interaction.getBusinessName());
		assertEquals("super type", "MCCI_MT002300CA.Message", interaction.getSuperTypeName());
		assertEquals("arguments", 1, interaction.getArguments().size());
		assertEquals("argument name", "MFMI_MT700726CA.ControlActEvent", interaction.getArguments().get(0).getName());
	}

	@Test
	public void shouldResolveUnbelievablyComplexChoiceItems() throws Exception {
		final MessagePart messagePartSummary = new MessagePart("COMT_MT111111CA.Summary");
		messagePartSummary.getSpecializationChilds().addAll(Arrays.asList("COMT_MT111111CA.RenderedContent", 
				"COMT_MT111111CA.SHR", 
				"COMT_MT111111CA.Pharmacy",
				"COMT_MT111111CA.Lab", 
				"ABCD_MT123456CA.SomethingExternal"));
		final MessagePart messagePartRenderedContent = new MessagePart("COMT_MT111111CA.RenderedContent");
		final MessagePart messagePartSHR = new MessagePart("COMT_MT111111CA.SHR");
		
		messagePartSHR.getSpecializationChilds().addAll(Arrays.asList(
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.ProcedureEvent1",
				"ABCD_MT123456CA.IntoleranceCondition1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1",
				"ABCD_MT123456CA.PatientCareProvisionEvent1"
				));
		final MessagePart messagePartPharmacy = new MessagePart("COMT_MT111111CA.Pharmacy");
		messagePartPharmacy.getSpecializationChilds().addAll(Arrays.asList(
				"ABCD_MT123456CA.CombinedMedicationRequest1",
				"ABCD_MT123456CA.DevicePrescription1",
				"ABCD_MT123456CA.OtherMedication1"));
		final MessagePart messagePartLab = new MessagePart("COMT_MT111111CA.Lab");
		messagePartLab.getSpecializationChilds().addAll(Arrays.asList(
				"ABCD_MT123456CA.RequestChoice1",
				"ABCD_MT123456CA.ResultInstancePayloadChoice"));
		final MessagePart messagePartRequestChoice = new MessagePart("ABCD_MT123456CA.RequestChoice1");
		messagePartRequestChoice.getSpecializationChilds().addAll(Arrays.asList(
				"ABCD_MT123456CA.PlacerGroup1",
				"ABCD_MT123456CA.BatteryRequest1",
				"ABCD_MT123456CA.ObservationRequest1"));
		final MessagePart messagePartPayloadChoice = new MessagePart("ABCD_MT123456CA.PayloadChoice1");
		messagePartPayloadChoice.getSpecializationChilds().addAll(Arrays.asList(
				"ABCD_MT123456CA.RequestChoice1",
				"ABCD_MT123456CA.ObservationReport2",
				"ABCD_MT123456CA.RequestChoice1"));
		this.jmock.checking(new Expectations() {{
			allowing(resolver).getPackageLocationRootType("MCCI_MT002300CA"); will(returnValue("MCCI_MT002300CA.Message"));
			allowing(resolver).getPackageLocationRootType("QUQI_MT120006CA"); will(returnValue("QUQI_MT120006CA.ControlActEvent"));
			allowing(resolver).getPackageLocationRootType("COMT_MT111111CA"); will(returnValue("COMT_MT111111CA.RenderedContent"));
			allowing(resolver).getMessagePart("COMT_MT111111CA.Summary"); will(returnValue(messagePartSummary));
			allowing(resolver).getMessagePart("COMT_MT111111CA.RenderedContent"); will(returnValue(messagePartRenderedContent));
			allowing(resolver).getMessagePart("COMT_MT111111CA.SHR"); will(returnValue(messagePartSHR));
			allowing(resolver).getMessagePart("COMT_MT111111CA.Pharmacy"); will(returnValue(messagePartPharmacy));
			allowing(resolver).getMessagePart("COMT_MT111111CA.Lab"); will(returnValue(messagePartLab));
			allowing(resolver).getMessagePart("ABCD_MT123456CA.RequestChoice1"); will(returnValue(messagePartRequestChoice));
			allowing(resolver).getMessagePart("ABCD_MT123456CA.ResultInstancePayloadChoice"); will(returnValue(messagePartPayloadChoice));
			allowing(resolver).getMessagePart("ABCD_MT123456CA.SomethingExternal"); will(returnValue(new MessagePart("ABCD_MT123456CA.SomethingExternal")));
			allowing(resolver).getMessagePart( with(any(String.class)) ); will(returnValue(new MessagePart()));
		}});
		
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(getClass(), "COMT_IN200000CA - Clinical summary-profile query response.mif"));
		TypeName argument = new TypeName("COMT_MT111111CA.Summary");
		List<MifChoiceItem> choices = new Mif2InteractionDefinition(document, "myCategory", null, null).getAllChoices(
				argument,
				Mif2XPathHelper.getSingleElement(
						document.getDocumentElement(), "//mif2:parameterModel[@parameterName='Act']"), 
				"specialization",
				this.resolver);
				
		assertEquals("top level choices", 5, choices.size());
		assertEquals("second sub-choices", 10, choices.get(1).getChoiceItems().size());
		assertEquals("third sub-choices", 3, choices.get(2).getChoiceItems().size());
		assertEquals("fourth sub-choices", 2, choices.get(3).getChoiceItems().size());
		assertEquals("fifth sub-choices", 0, choices.get(4).getChoiceItems().size());
	}
}
