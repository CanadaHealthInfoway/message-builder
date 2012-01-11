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

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.model.newfoundland.cerx.medicalprofile.CombinedMedicationBeanBuilder.CombinedMedicationBeanType.PORX_MT060340CA;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.Prescription;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicalprofile.CombinedMedicationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.revise.DispenseAuthorizationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.revise.DispenseAuthorizationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.revise.ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.revise.ReviseAssignedDispenseResponsibilityRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ReviseAssignedDispenseResponsibilityRequestTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/reviseAssignedDispenseResponsibilityRequest.xml";
	private static final String RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/reviseAssignedDispenseResponsibilityRequestAccepted.xml";
	protected static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createRequestBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		ReviseAssignedDispenseResponsibilityRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) result.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}
	
	private ReviseAssignedDispenseResponsibilityRequestMessageBean createRequestBean() {
		ReviseAssignedDispenseResponsibilityRequestMessageBean model = new ReviseAssignedDispenseResponsibilityRequestMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.REVISE_ASSIGNED_DISPENSE_RESPONSIBILITY_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		RecordBean<DispenseAuthorizationBean> recordBean = new RecordBean<DispenseAuthorizationBean>();
		recordBean.setRecord(new DispenseAuthorizationBeanBuilder().populate().create());
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldProduceSomeResponseResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createResponseMessageBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownResponse() throws Exception {
		ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean model = createResponseMessageBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		System.out.println(xml);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), RESPONSE_MESSAGE_FILE)), actual);
	}

//	SPD: not important since we are only creating xml from response beans and not the other way around.
//	@Test
//	public void shouldTransformResponseBackAndForthWithoutLosingData() throws Exception {
//		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createResponseMessageBean());
//		Document message = this.factory.createFromString(xml);
//		XmlToJavaResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
//		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
//		String transformedBackToHl7Xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, messageObject);
//		assertEquals(xml, transformedBackToHl7Xml);
//	}
	
	private ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean createResponseMessageBean() {
		ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean model = new ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.REVISE_ASSIGNED_DISPENSE_RESPONSIBILITY_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		RecordBean<Prescription> recordBean = new RecordBean<Prescription>();
		recordBean.setRecord(new CombinedMedicationBeanBuilder(PORX_MT060340CA).populate().create());
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}	

}
