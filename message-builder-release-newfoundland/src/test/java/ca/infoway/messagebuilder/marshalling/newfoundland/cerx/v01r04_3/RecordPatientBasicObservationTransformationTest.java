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
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.ObservationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.RecordPatientBasicObservationAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.RecordPatientBasicObservationMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.RecordPatientBasicObservationRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordPatientBasicObservationTransformationTest extends BaseTransformerTestCase {
	
	private static final String RECORD_ONE_VALUE_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordPatientBasicObservationRequestOneValue.xml";
	private static final String RECORD_TWO_VALUES_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordPatientBasicObservationRequestTwoValues.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordPatientBasicObservationRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordPatientBasicObservationRequestRefused.xml";
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBeanWithOneValue());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequestWithOneValue() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBeanWithOneValue());
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RECORD_ONE_VALUE_MESSAGE_FILE)), actual);
	}

	@Test
	public void shouldMatchKnownRequestWithTwoValues() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBeanWithTwoValues());
		Document actual = this.factory.createFromString(xml);
		System.out.println(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RECORD_TWO_VALUES_MESSAGE_FILE)), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(RECORD_ONE_VALUE_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RecordRequestMessageBean<ObservationBean> message = (RecordRequestMessageBean<ObservationBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RecordControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRecord());
		assertEquals("name", "Michelle Obama", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRecord().getPatient().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(RECORD_ONE_VALUE_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> acceptedBean = new RecordPatientBasicObservationAcceptedMessageBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(ACCEPTED_MESSAGE_FILE)), actual);
	}

	private void populateAcceptedBean(RecordResponseMessageBean<ActEventBean> acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_PATIENT_BASIC_OBSERVATION_REQUEST_ACCEPTED);
		acceptedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		acceptedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> refusedBean = new RecordPatientBasicObservationRefusedMessageBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REFUSED_MESSAGE_FILE)), actual);
	}

	protected void populateRefusedBean(RecordResponseMessageBean<ActEventBean> refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_PATIENT_BASIC_OBSERVATION_REQUEST_REFUSED);
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	private RecordPatientBasicObservationMessageBean createRequestBean() {
		RecordPatientBasicObservationMessageBean model = new RecordPatientBasicObservationMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_PATIENT_BASIC_OBSERVATION_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
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

		RecordBean<ObservationBean> recordBean = new RecordBean<ObservationBean>();
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	private RecordPatientBasicObservationMessageBean createRequestBeanWithOneValue() {
		RecordPatientBasicObservationMessageBean model = createRequestBean();
		model.getControlActEvent().getRecordBean().setRecord(new ObservationTestBeanBuilder().buildObservationBeanWithOneValue());
		return model;
	}

	private RecordPatientBasicObservationMessageBean createRequestBeanWithTwoValues() {
		RecordPatientBasicObservationMessageBean model = createRequestBean();
		model.getControlActEvent().getRecordBean().setRecord(new ObservationTestBeanBuilder().buildObservationBeanWithTwoValues());
		return model;
	}
	
}