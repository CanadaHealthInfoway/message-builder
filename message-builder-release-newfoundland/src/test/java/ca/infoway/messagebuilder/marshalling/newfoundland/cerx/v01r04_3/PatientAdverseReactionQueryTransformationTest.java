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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IndeterminatePersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponsiblePartyBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.AdverseReactionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.PatientAdverseReactionQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.PatientAdverseReactionQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction.PatientAdverseReactionQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;


public class PatientAdverseReactionQueryTransformationTest extends BaseTransformerTestCase {
	
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientAdverseReactionQuery.xml";


	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}	

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery()).getXmlMessage();
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", PatientAdverseReactionQueryMessageBean.class, result.getMessageObject().getClass());
		
		PatientAdverseReactionQueryMessageBean messageObject = (PatientAdverseReactionQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}
	
	private PatientAdverseReactionQueryMessageBean createQuery() {
		PatientAdverseReactionQueryCriteriaBean criteria = new PatientAdverseReactionQueryCriteriaBean();
		
		PatientAdverseReactionQueryMessageBean model = new PatientAdverseReactionQueryMessageBean(criteria);
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_ADVERSE_REACTION_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));

		return model;
	}
	
	@Test
	@Ignore // BCH: looks like a bad mapping
	public void shouldCreateAMeaningfulResponse() throws Exception {
		PatientAdverseReactionQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		assertValidHl7Message(xml);
		Assert.assertFalse("Response should not have warnings", xml.contains("<!-- WARNING:"));
	}
	
	private PatientAdverseReactionQueryResponseMessageBean createResponseBean() {
		PatientAdverseReactionQueryCriteriaBean criteria = new PatientAdverseReactionQueryCriteriaBean();
		
		PatientAdverseReactionQueryResponseMessageBean model = new PatientAdverseReactionQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_MEDICAL_CONDITIONS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		AdverseReactionBean adverseRxn = new AdverseReactionBean();
		adverseRxn.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		adverseRxn.setAuthor(new AuthorBeanBuilder().populate().create());
		adverseRxn.setSeverityObservation(lookup(SeverityObservation.class, "SEVERITY"));
		
		adverseRxn.setId(new Identifier("1.2.3", "extension"));
		adverseRxn.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		
		IdentifiedPersonBean patient = new IdentifiedPersonBeanBuilder().populate().create();
		patient.setId(new Identifier("patient root", "patient extention"));
		patient.setIndeterminatePerson(new IndeterminatePersonBeanBuilder().populate().create());
		adverseRxn.setPatient(patient);

		ResponsiblePartyBean informant = new ResponsiblePartyBeanBuilder().populate().create();
		adverseRxn.setInformant(informant);
		adverseRxn.setInformantTime(new Date());
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<AdverseReactionBean>(adverseRxn));

		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return model;
	}

}
