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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.ConsentEventBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.InformDefinitionBean;
import ca.infoway.messagebuilder.model.newfoundland.InformationAccessTypeBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.PatientIdentifierBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.PatientMedicalConditionsQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.condition.PatientMedicalConditionsQueryMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

public class PatientMedicalConditionsWithConsentOverridenTransformationTest
		extends BaseTransformerTestCase {

	@Before
	public void setup() {
		CodeResolverRegistry.registerResolver(ActCode.class,
				new CompositeCodeResolver( 
						new EnumBasedCodeResolver(MockActCodeEnum.class),
						new TrivialCodeResolver()));
		
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}

	@Test
	public void shouldProduceSomeResultWithConsentEvent() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createQueryWithConsentOverriden());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	private PatientMedicalConditionsQueryMessageBean createQueryWithConsentOverriden() {
		PatientMedicalConditionsQueryCriteriaBean criteria = new PatientMedicalConditionsQueryCriteriaBean();
		
		PatientMedicalConditionsQueryMessageBean model = new PatientMedicalConditionsQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_MEDICAL_CONDITIONS_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		ConsentEventBean consentEvent = new ConsentEventBean();
		consentEvent.setId(new Identifier("6.5.4.3.2.1", "987654"));
		
		consentEvent.setConsenter(new PatientIdentifierBean());
		
		InformDefinitionBean informDefinition = new InformDefinitionBean();
		InformationAccessTypeBean actDefinition = new InformationAccessTypeBean();
		actDefinition.setCode(lookup(ActInformationAccessTypeCode.class, "ACADR", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		informDefinition.getActDefinitions().add(actDefinition);
//		informDefinition.setRecipient(new AssignedPersonBeanBuilder().populate().create());
		informDefinition.setRecipient(new ServiceDeliveryLocationBeanBuilder().populate().create());
		consentEvent.setInformDefinition(informDefinition);

		IdentifiedPersonBean patient = new IdentifiedPersonBeanBuilder().populate().create();
		consentEvent.setPatient(patient);

		consentEvent.setReasonCode(lookup(ActConsentInformationAccessReason.class, "EMERG", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		consentEvent.setSignatureText("my keyword");
		model.getControlActEvent().setConsentEvent(consentEvent);
		
		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		
		return model;
	}
	
}
