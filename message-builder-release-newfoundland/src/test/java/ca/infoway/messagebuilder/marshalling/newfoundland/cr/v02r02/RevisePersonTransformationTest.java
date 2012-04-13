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

package ca.infoway.messagebuilder.marshalling.newfoundland.cr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.reviseperson.RevisePersonAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.reviseperson.RevisePersonMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.reviseperson.RevisePersonRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RevisePersonTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/revisePersonRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/revisePersonRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/revisePersonRequestRefused.xml";
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean());
		System.out.println(xml);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RegistrationRequestMessageBean<IdentifiedPersonBean> message = (RegistrationRequestMessageBean<IdentifiedPersonBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RegistrationControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEvent().getRegistrationBean().getRecord());
		assertEquals("name", "Hannah Lambert", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEvent().getRegistrationBean().getRecord().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RevisePersonAcceptedMessageBean acceptedBean = new RevisePersonAcceptedMessageBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(ACCEPTED_MESSAGE_FILE)), actual);
	}

	private void populateAcceptedBean(RevisePersonAcceptedMessageBean acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(HL7TriggerEventCode.PERSON_REVISE_ACCEPT);
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		RegistrationEventBean<IdentifiedPersonBean> recordBean = new RegistrationEventBean<IdentifiedPersonBean>();
		
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());

		acceptedBean.getControlActEvent().setRegistrationBean(recordBean);
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		acceptedBean.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RevisePersonRefusedMessageBean refusedBean = new RevisePersonRefusedMessageBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REFUSED_MESSAGE_FILE)), actual);
	}

	protected void populateRefusedBean(RevisePersonRefusedMessageBean refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(HL7TriggerEventCode.PERSON_REVISE_REJECT);
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		RegistrationEventBean<IdentifiedPersonBean> recordBean = new RegistrationEventBean<IdentifiedPersonBean>();
		
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());

		refusedBean.getControlActEvent().setRegistrationBean(recordBean);
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		refusedBean.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
	}

	private RevisePersonMessageBean createRequestBean() {
		RevisePersonMessageBean model = new RevisePersonMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.REVISE_PERSON_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		AssignedPersonBean responsibleParty = new AssignedPersonBeanBuilder().populate().create();
		responsibleParty.getId().setRoot("1.2.3");
		responsibleParty.getLicenseNumber().setRoot("1.2.3");
		model.getControlActEvent().setResponsibleParty(responsibleParty);

		RegistrationRequestBean<IdentifiedPersonBean> recordBean = new RegistrationRequestBean<IdentifiedPersonBean>();
		
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());

		model.getControlActEvent().setRegistrationBean(recordBean);
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		model.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
	
		model.getMessageReceiver().getDeviceId().setRoot("1.2.3.4");
		model.getSender().getDeviceId().setRoot("1.2.3.4");
		
		return model;
	}
	
}