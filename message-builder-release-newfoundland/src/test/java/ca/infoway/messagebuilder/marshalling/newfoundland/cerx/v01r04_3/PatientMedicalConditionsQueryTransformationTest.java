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

import static ca.infoway.messagebuilder.domainvalue.controlact.ActStatus.ACTIVE;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.basic.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IndeterminatePersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.MedicalConditionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.PatientMedicalConditionsQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.PatientMedicalConditionsQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.PatientMedicalConditionsQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class PatientMedicalConditionsQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientMedicalConditionsQuery.xml";

	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	
	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", PatientMedicalConditionsQueryMessageBean.class, result.getMessageObject().getClass());
		
		PatientMedicalConditionsQueryMessageBean messageObject = (PatientMedicalConditionsQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getPatientId());
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		PatientMedicalConditionsQueryResponseMessageBean responseBean = createResponseBean();
		String originalXml = this.transformer.transformToHl7(VERSION, responseBean);
		XmlToModelResult transformedXml = this.transformer.transformFromHl7(VERSION, new DocumentFactory().createFromString(originalXml));
		String xmlString = this.transformer.transformToHl7(VERSION, (PatientMedicalConditionsQueryResponseMessageBean) transformedXml.getMessageObject());
		assertEquals(originalXml, xmlString);
	}

	private PatientMedicalConditionsQueryMessageBean createQuery() {
		PatientMedicalConditionsQueryCriteriaBean criteria = new PatientMedicalConditionsQueryCriteriaBean();
		
		PatientMedicalConditionsQueryMessageBean model = new PatientMedicalConditionsQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_MEDICAL_CONDITIONS_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		
		return model;
	}

	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
		PatientMedicalConditionsQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml);
		Assert.assertFalse("Response should not have warnings", xml.contains("<!-- WARNING:"));
	}
	
	private PatientMedicalConditionsQueryResponseMessageBean createResponseBean() {
		PatientMedicalConditionsQueryCriteriaBean criteria = new PatientMedicalConditionsQueryCriteriaBean();
		
		PatientMedicalConditionsQueryResponseMessageBean model = new PatientMedicalConditionsQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_MEDICAL_CONDITIONS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		MedicalConditionBean condition = new MedicalConditionBean();
		condition.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		condition.setId(new Identifier("1.2.3", "extension"));
		condition.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		condition.setStatusCode(lookup(ActStatus.class, ACTIVE.getCodeValue()));
		
		AuthorBeanBuilder authorBuilder = new AuthorBeanBuilder();
		authorBuilder.populate();
		condition.setAuthor(authorBuilder.create());
		
		IdentifiedPersonBeanBuilder identifiedPersonBuilder = new IdentifiedPersonBeanBuilder();
		identifiedPersonBuilder.populate();
		
		IdentifiedPersonBean patient = identifiedPersonBuilder.create();
		patient.setId(new Identifier("1.2.3", "patient extention"));
		PostalAddress address = new PostalAddress();
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.STREET_NAME, "Bloor"));
		address.getUses().add(PostalAddressUse.HOME);
		patient.setAddress(address);
//		patient.getTelecom().add(new TelecomAddressBeanAdapter().adaptToHl7(new TelecomAddressBean("416-762-0032", URLScheme.TEL, TelecommunicationAddressUse.WORKPLACE)));
		
		IndeterminatePersonBeanBuilder indeterminatePersonBuilder = new IndeterminatePersonBeanBuilder();
		indeterminatePersonBuilder.populate();
		patient.setIndeterminatePerson(indeterminatePersonBuilder.create());
		condition.setPatient(patient);
		
		AssignedPersonBean responsibleParty = new AssignedPersonBean();
		responsibleParty.setId(new Identifier("1.1.2", "resp party ext"));
		responsibleParty.setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		responsibleParty.setLicenseNumber(new Identifier("1.2.3.1", "provider lic ext"));
		responsibleParty.setName(new PersonName());
		responsibleParty.getName().addNamePart(new EntityNamePart("Joe", PersonNamePartType.GIVEN));
		responsibleParty.getName().addNamePart(new EntityNamePart("Last", PersonNamePartType.FAMILY));
		condition.setResponsibleParty(responsibleParty);
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<MedicalConditionBean>(condition));
		
		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return model;
	}
	
}
