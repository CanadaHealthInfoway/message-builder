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

import java.util.Calendar;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IndeterminatePersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.MedicalConditionBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public abstract class BaseMedicalConditionTransformationTest extends BaseTransformerTestCase {
	
	protected static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	protected abstract String getRequestMessageFile(); 
	protected abstract String getAcceptedMessageFile(); 
	protected abstract String getRefusedMessageFile();
	protected abstract HL7TriggerEventCode getRequestHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getAcceptedHL7TriggerEventCode(); 
	protected abstract HL7TriggerEventCode getRefusedHL7TriggerEventCode();
	protected abstract RecordResponseMessageBean<ActEventBean> createAcceptedBean();
	protected abstract RecordResponseMessageBean<ActEventBean> createRefusedBean();
	protected abstract RecordRequestMessageBean<MedicalConditionBean> createRequestBean();
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
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
		RecordRequestMessageBean<MedicalConditionBean> message = (RecordRequestMessageBean<MedicalConditionBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RecordControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRecord());
		assertEquals("name", "Mabel Hauptman", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRecord().getPatient().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getRequestMessageFile()));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	private RecordRequestMessageBean<MedicalConditionBean> createRequest() {
		RecordRequestMessageBean<MedicalConditionBean> model = createRequestBean();
		model.getControlActEvent().setCode(getRequestHL7TriggerEventCode());
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
		
		RecordBean<MedicalConditionBean> recordBean = new RecordBean<MedicalConditionBean>();
		
		MedicalConditionBean medicationCondition = new MedicalConditionBean();

		medicationCondition.setId(new Identifier("2.16.840.1.113883.1.13", "7"));
		
		medicationCondition.getPatient().setId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		medicationCondition.getPatient().getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		medicationCondition.getPatient().getIndeterminatePerson().setName(PersonName.createFirstNameLastName("Mabel", "Hauptman"));
		medicationCondition.getPatient().getIndeterminatePerson().setBirthTime(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		
		ActStatus status = lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot());
		
		medicationCondition.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		medicationCondition.setStatusCode(status);
		medicationCondition.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		medicationCondition.setDiagnosisValue(lookup(DiagnosisValue.class, "402261004", CodeSystem.SNOMED.getRoot()));
		medicationCondition.setEffectiveTime(IntervalUtil.createInterval(DateUtil.getDate(2009, 3, 22), DateUtil.getDate(2009, 5, 28)));
		medicationCondition.setChronicIndicator(true);
		
		NoteBean noteBean = new NoteBean();
		noteBean.setText("condition note");
		noteBean.setLanguageCode(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		noteBean.getAuthor().setId(new Identifier("2.16.840.1.113883.1.133", "112233"));
		noteBean.getAuthor().setLicenseNumber(new Identifier("2.16.840.1.113883.1.133", "332211"));
		noteBean.getAuthor().setTime(DateUtil.getDate(2008, 8, 20));
		noteBean.getAuthor().setName(new PersonName());
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Michelle", PersonNamePartType.GIVEN));
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Obama", PersonNamePartType.FAMILY));
		
		medicationCondition.getNotes().add(noteBean);
		
		ResponsiblePartyBean responsibleParty = new ResponsiblePartyBean();
		responsibleParty.setId(new Identifier("3.14", "159"));
		PostalAddress address = new PostalAddress();
		address.addUse(X_BasicPostalAddressUse.HOME);
		address.addPostalAddressPart(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		responsibleParty.setAddress(address);
		responsibleParty.getTelecom().add(new TelecommunicationAddress(
				CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.10"));
		responsibleParty.setIndeterminatePerson(new IndeterminatePersonBeanBuilder().populate().create());		
		medicationCondition.setInformant(responsibleParty);
		medicationCondition.setInformantTime(DateUtil.getDate(2009, Calendar.SEPTEMBER, 29));
		
		recordBean.setRecord(medicationCondition);
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> acceptedBean = createAcceptedBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getAcceptedMessageFile())), actual);
	}

	@SuppressWarnings("deprecation")
	private void populateAcceptedBean(RecordResponseMessageBean<ActEventBean> acceptedBean) {
		MessageBeanBuilderSupport.populateBetterStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(getAcceptedHL7TriggerEventCode());
		acceptedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		acceptedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> refusedBean = createRefusedBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getRefusedMessageFile())), actual);
	}

	@SuppressWarnings("deprecation")
	protected void populateRefusedBean(RecordResponseMessageBean<ActEventBean> refusedBean) {
		MessageBeanBuilderSupport.populateBetterStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(getRefusedHL7TriggerEventCode());
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}
}
