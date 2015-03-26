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

package ca.infoway.messagebuilder.guide.examples;

import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.devtools.DefaultValueHolder;
import ca.infoway.messagebuilder.devtools.MessageBeanFactory;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt090102ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240012ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.prpa_mt101103ca.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;

/**
 * <p>This class shows how to create a simple FindCandidates HL7 query bean.
 * 
 */
public class FindCandidatesExampleCreator {

	private MessageBeanFactory messageBeanFactory = new MessageBeanFactory(new DefaultValueHolder());
	
	protected FindCandidatesQueryBean createFindCandidatesQuery() {

		// construct message bean
		FindCandidatesQueryBean messageBean = new FindCandidatesQueryBean();

		// populate values standard for all messages
		populateMessageAttributesStandardValues(messageBean);
		messageBean.getProfileId().add(new Identifier("2.16.840.1.113883.2.20.2", "R02.04.02"));
		
		// standard control act initialization for this specific message 
		initializeQueryControlAct(messageBean);
		
		// populate control act fields for this message instance
		// (this could be standardized across all instances of this message, or even across all messages)  
		populateQueryControlActStandardValues(messageBean.getControlActEvent());
		
		// set specific payload values for this message instance
		populatePayload(messageBean);
		
		return messageBean;
	}

	private void populateMessageAttributesStandardValues(InteractionBean messageBean) {
		this.messageBeanFactory.populate(messageBean);
	}

	private void initializeQueryControlAct(FindCandidatesQueryBean messageBean) {
		messageBean.setControlActEvent(new TriggerEventBean<ParameterListBean>());
		messageBean.getControlActEvent().setQueryByParameter(new QueryByParameterBean<ParameterListBean>());
		messageBean.getControlActEvent().getQueryByParameter().setParameterList(new ParameterListBean());
		messageBean.getControlActEvent().setCode(HL7TriggerEventCode.FIND_CANDIDATES_QUERY);
	}
	
	private void populateQueryControlActStandardValues(TriggerEventBean<ParameterListBean> triggerEventBean) {
		triggerEventBean.setId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		triggerEventBean.setEffectiveTime(IntervalFactory.<Date>createLowHigh(new Date(0), new Date()));
		triggerEventBean.setSpecializationType("effectiveTime", StandardDataType.IVL_FULL_DATE_TIME);		
		triggerEventBean.setAuthor(createAuthorBean());
		triggerEventBean.setDataEntryLocationServiceDeliveryLocation(createServiceLocationBean());
		triggerEventBean.getQueryByParameter().setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
	}
	
	private ServiceLocationBean createServiceLocationBean() {
		ServiceLocationBean result = new ServiceLocationBean();
		result.setId(new Identifier("2.16.124.113620.1.1.11111", "1"));
		result.setLocationName("Intelliware's Pharmacy");
		return result;
	}

	private CreatedBy_2Bean createAuthorBean() {
		CreatedBy_2Bean authorBean = new CreatedBy_2Bean();
		authorBean.setAuthorPerson(createHealthcareWorkerBean(authorBean));
		return authorBean;
	}

	private HealthcareWorkerBean createHealthcareWorkerBean(
			CreatedBy_2Bean authorBean) {
		HealthcareWorkerBean person = new HealthcareWorkerBean();
		person.getId().add(new Identifier("1.1.1", "1"));
		authorBean.setTime(new Date());
		person.setAssignedPersonName(createFirstNameLastName("John", "Doe"));
		return person;
	}
	
	private void populatePayload(FindCandidatesQueryBean messageBean) {
		
		ParameterListBean parameterList = messageBean.getControlActEvent().getQueryByParameter().getParameterList();
		
		parameterList.getPersonNameValue().add(createFirstNameLastName("Rober", "Smith"));
		parameterList.setAdministrativeGenderValue(AdministrativeGender.MALE);
		parameterList.setPersonBirthtimeValue(DateUtil.getDate(1974, 7, 20));
		
	}

}