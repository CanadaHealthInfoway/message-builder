/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.QueryResponse;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ProfessionalServicesBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServiceRecord;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServicesQueryCriteria;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServicesQueryResponseMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ProfessionalServicesQueryResponseTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientPharmacyProfServicesQueryResponse.xml";
	
	@Test
	public void shouldProduceSomeQueryResponseForSimpleObservation() throws Exception {
		assertNotNull("response", toHl7(createResponseBean()));
	}
	
	@Test
	public void shouldMatchKnownQueryResponseWithSimpleObservation() throws Exception {
		ProfessionalServicesQueryResponseMessageBean model = createResponseBean();
		String xml = toHl7(model);
		Document actual = this.factory.createFromString(xml);
		XmlAssert.assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		MessageBean messageObject = (MessageBean) this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message).getMessageObject();
		
		String xml = toHl7(messageObject);
		assertTreeEquals(
				message, 
				this.factory.createFromString(xml));
	}

	private ProfessionalServicesQueryResponseMessageBean createResponseBean() {
		ProfessionalServicesQueryResponseMessageBean model = createBasicResponseBean();
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<ProfessionalServiceRecord>(createProfServiceRecord()));
		return model;
	}

	private ProfessionalServicesQueryResponseMessageBean createBasicResponseBean() {
		PersonName patientName = PersonName.createFirstNameLastName("John", "Doe");
		
		ProfessionalServicesQueryCriteria criteria = new ProfessionalServicesQueryCriteria();
		criteria.setIncludeNotesIndicator(true);
		criteria.setPatientBirthDate(DateUtil.getDate(2009, 0, 1));
		criteria.setPatientGender(AdministrativeGender.FEMALE);
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "1"));
		criteria.setName(patientName);
		
		ProfessionalServicesQueryResponseMessageBean model = new ProfessionalServicesQueryResponseMessageBean(criteria);
		model.getControlActEventBean().setCode(HL7TriggerEventCode.PATIENT_BASIC_OBSERVATIONS_QUERY_RESPONSE);
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEventBean());
		model.setQueryId(new Identifier("1.2.3.4.5", "1"));
		
		model.getQuerySummary().setQueryResponseCode(QueryResponse.DATA_FOUND);
		model.getQuerySummary().setResultTotalQuantity(1);
		model.getQuerySummary().setResultCurrentQuantity(1);
		model.getQuerySummary().setResultRemainingQuantity(0);
		model.getQuerySummary().setQueryId(model.getQueryId());
		return model;
	}
	
	private ProfessionalServiceRecord createProfServiceRecord() {
		return new ProfessionalServicesBeanBuilder().populate().create();
	}
}
