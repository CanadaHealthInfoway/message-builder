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
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.apache.commons.lang.ObjectUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AllergyIntoleranceWithHistoryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.PatientAllergyIntoleranceWithHistoryQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.PatientAllergyIntoleranceWithHistoryQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class PatientAllergyIntoleranceWithHistoryQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientAllergyIntoleranceWithHistoryQuery.xml";

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
		assertEquals("type", PatientAllergyIntoleranceWithHistoryQueryMessageBean.class, result.getMessageObject().getClass());
		
		PatientAllergyIntoleranceWithHistoryQueryMessageBean messageObject = (PatientAllergyIntoleranceWithHistoryQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getPatientId());
	}

	private PatientAllergyIntoleranceWithHistoryQueryMessageBean createQuery() {
		PatientAllergyIntoleranceWithHistoryQueryCriteriaBean criteria = new PatientAllergyIntoleranceWithHistoryQueryCriteriaBean();
		
		PatientAllergyIntoleranceWithHistoryQueryMessageBean model = new PatientAllergyIntoleranceWithHistoryQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_ALLERGY_INTOLERANCE_WITH_HISTORY_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		criteria.setConditionId(new Identifier("1.2.3", "44"));
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		
		return model;
	}
	
	@Test
	@Ignore // BCH: looks like a bad mapping
	public void shouldCreateMeaningfulResponse() throws Exception {
		PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model).getXmlMessage();
		assertValidHl7Message(xml);
	}

	private PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean createResponseBean() {
		PatientAllergyIntoleranceWithHistoryQueryCriteriaBean criteria = new PatientAllergyIntoleranceWithHistoryQueryCriteriaBean();
		
		PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean model = new PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_ALLERGY_INTOLERANCE_WITH_HISTORY_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		AllergyIntoleranceWithHistoryBean allergy1 = new AllergyIntoleranceTestBeanBuilder().buildWithHistory(3);
		AllergyIntoleranceWithHistoryBean allergy2 = new AllergyIntoleranceTestBeanBuilder().buildWithHistory(0);
		AllergyIntoleranceWithHistoryBean allergy3 = new AllergyIntoleranceTestBeanBuilder().buildWithHistory(1);
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<AllergyIntoleranceWithHistoryBean>(allergy1));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<AllergyIntoleranceWithHistoryBean>(allergy2));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<AllergyIntoleranceWithHistoryBean>(allergy3));

		criteria.setConditionId(new Identifier("1.2.3", "4"));
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return model;
	}
	
	@Override
	protected void assertValidHl7Message(Document actual) {
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, actual);
		Hl7Error found = null;
		for (Hl7Error error : result.getHl7Errors()) {
			found = error;
		}
		assertNull(ObjectUtils.toString(found), found);
	}	
	
}
