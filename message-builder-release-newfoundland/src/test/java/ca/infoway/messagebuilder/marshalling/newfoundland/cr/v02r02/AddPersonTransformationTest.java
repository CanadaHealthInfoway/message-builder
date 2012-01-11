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

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_PERSON_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.PERSON_CREATE_ACCEPT;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.PERSON_CREATE_REJECT;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.AddPersonAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.AddPersonMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.AddPersonRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class AddPersonTransformationTest extends BaseTransformerTestCase {
	
	protected static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequestRefused.xml";
	
	public String getRequestMessageFile() {
		return REQUEST_MESSAGE_FILE;
	}
	public String getAcceptedMessageFile() {
		return ACCEPTED_MESSAGE_FILE;
	}
	public String getRefusedMessageFile() {
		return REFUSED_MESSAGE_FILE;
	}
	protected AddPersonMessageBean createRequestBean() {
		return new AddPersonMessageBean();
	}
	protected AddPersonAcceptedMessageBean createAcceptedBean() {
		return new AddPersonAcceptedMessageBean();
	}
	protected AddPersonRefusedMessageBean createRefusedBean() {
		return new AddPersonRefusedMessageBean();
	}
	protected HL7TriggerEventCode getRequestHL7TriggerEventCode() {
		return ADD_PERSON_REQUEST;
	}
	protected HL7TriggerEventCode getAcceptedHL7TriggerEventCode() {
		return PERSON_CREATE_ACCEPT;
	}
	protected HL7TriggerEventCode getRefusedHL7TriggerEventCode() {
		return PERSON_CREATE_REJECT;	
	}

	@Before
	public void setup() {
	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = toHl7UsingNewRenderer(createRequest(), VERSION);
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = toHl7UsingNewRenderer(createRequest(), VERSION);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRequestMessageFile())), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(
				getRequestMessageFile()));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RegistrationRequestMessageBean<IdentifiedPersonBean> message = (RegistrationRequestMessageBean<IdentifiedPersonBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RegistrationControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRegistrationBean().getRecord());
		assertEquals("name", "Hannah Lambert", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRegistrationBean().getRecord().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getRequestMessageFile()));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = toHl7UsingNewRenderer((NewBaseMessageBean) xmlToJavaResult.getMessageObject(), VERSION);
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	private AddPersonMessageBean createRequest() {
		AddPersonMessageBean model = createRequestBean();
		model.getControlActEvent().setCode(getRequestHL7TriggerEventCode());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBean());
		model.getControlActEvent().getResponsibleParty().setId(new Identifier("3.16.840.1.113883.1.133", "223344"));
		model.getControlActEvent().getResponsibleParty().setName(new PersonName());
		model.getControlActEvent().getResponsibleParty().getName().addNamePart(new EntityNamePart("Laura", PersonNamePartType.GIVEN));
		model.getControlActEvent().getResponsibleParty().getName().addNamePart(new EntityNamePart("Bush", PersonNamePartType.FAMILY));
		model.getControlActEvent().getResponsibleParty().setLicenseNumber(new Identifier("3.21.456.1.113883.1.133", "445566"));
		model.getControlActEvent().getResponsibleParty().setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));

		RegistrationRequestBean<IdentifiedPersonBean> recordBean = new RegistrationRequestBean<IdentifiedPersonBean>();
		
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());

		model.getControlActEvent().setRegistrationBean(recordBean);
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		model.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
		
		return model;
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		AddPersonAcceptedMessageBean acceptedBean = createAcceptedBean();
		populateAcceptedBean(acceptedBean);
		String xml = toHl7UsingNewRenderer(acceptedBean, VERSION);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getAcceptedMessageFile())), actual);
	}

	private void populateAcceptedBean(AddPersonAcceptedMessageBean acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		
		RegistrationEventBean<IdentifiedPersonBean> recordBean = new RegistrationEventBean<IdentifiedPersonBean>();
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());
		acceptedBean.getControlActEvent().setRegistrationBean(recordBean);
		acceptedBean.getControlActEvent().setCode(getAcceptedHL7TriggerEventCode());
		
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		acceptedBean.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		AddPersonRefusedMessageBean refusedBean = createRefusedBean();
		populateRefusedBean(refusedBean);
		String xml = toHl7UsingNewRenderer(refusedBean, VERSION);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRefusedMessageFile())), actual);
	}

	protected void populateRefusedBean(AddPersonRefusedMessageBean refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(getRefusedHL7TriggerEventCode());
		
		RegistrationEventBean<IdentifiedPersonBean> recordBean = new RegistrationEventBean<IdentifiedPersonBean>();
		recordBean.setRecord(new IdentifiedPersonBeanBuilder().populate().create());
		refusedBean.getControlActEvent().setRegistrationBean(recordBean);
		
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		
		refusedBean.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
	}
}
