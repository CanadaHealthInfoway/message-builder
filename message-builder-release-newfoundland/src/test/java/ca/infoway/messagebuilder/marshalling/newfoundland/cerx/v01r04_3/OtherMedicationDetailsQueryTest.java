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

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodDefEvnRqo;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageInstructionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication.OtherMedicationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication.OtherMedicationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication.OtherMedicationDetailQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication.OtherMedicationQueryCriteriaBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;


public class OtherMedicationDetailsQueryTest extends BaseTransformerTestCase {

//	@Override
	@Before
	public void setUp() throws Exception {
//		super.setUp();
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}
	
	@Test
	public void shouldProduceValidResponse() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createResponse());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}

	private MessageBean createResponse() {
		OtherMedicationDetailQueryResponseMessageBean response = new OtherMedicationDetailQueryResponseMessageBean(createCriteria());
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(response.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(response.getControlActEventBean());
		response.getControlActEventBean().setCode(HL7TriggerEventCode.OTHER_MEDICATION_DETAIL_QUERY_RESPONSE);
		
		OtherMedicationBean record = new OtherMedicationBeanBuilder().populate().create();
		
		AssignedPersonBean responsibleParty = new AssignedPersonBean();
		responsibleParty.setId(new Identifier("13.23", "329377"));
		responsibleParty.setName(PersonName.createFirstNameLastName("Nancy", "Drew"));
		record.setResponsibleParty(responsibleParty);
		
		DosageInstructionBean instruction = new DosageInstructionBean();
		instruction.setCode(lookup(ActCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		instruction.setMoodCode(lookup(x_ActMoodDefEvnRqo.class, "RQO"));
		instruction.setText("Swallow three times per day");
		instruction.setRouteCode(lookup(RouteOfAdministration.class, "CHEW", CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
		record.getDosageInstructions().add(instruction);
		response.getQueryRecords().add(new RecordBean<OtherMedicationBean>(record));
		response.setQueryId(new Identifier(UUID.randomUUID().toString()));

		MessageBeanBuilderSupport.populateQuerySummary(
				response.getQuerySummary(), 
				response.getQueryId(), response.getQueryRecords());
		
		return response;
	}

	private OtherMedicationQueryCriteriaBean createCriteria() {
		OtherMedicationQueryCriteriaBean criteria = new OtherMedicationQueryCriteriaBean();
		
		PersonName patientName = new PersonName();
		patientName.addNamePart(new EntityNamePart("Mabel", PersonNamePartType.GIVEN));
		patientName.addNamePart(new EntityNamePart("Hauptman", PersonNamePartType.FAMILY));
		criteria.setIncludeIssuesIndicator(false);
		criteria.setIncludeNotesIndicator(false);
		criteria.setIssueFilterCode(IssueFilterCode.ALL);
		criteria.setPatientBirthDate(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		criteria.setPatientName(patientName);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		criteria.setPatientGender(AdministrativeGender.FEMALE);
		
		return criteria;
	}
}
