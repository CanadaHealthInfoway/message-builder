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

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.RoleStatus;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.LanguageCommunicationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.ReplacementOfBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.ResolveDuplicatePersonRegistrationsMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ResolveDuplicatePersonRegistrationTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequest());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		ResolveDuplicatePersonRegistrationsMessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource("ca/infoway/messagebuilder/sample/cr/v02r02/resolveDuplicatePersonRegistrations.xml")), 
				actual);
	}

	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(
				"ca/infoway/messagebuilder/sample/cr/v02r02/resolveDuplicatePersonRegistrations.xml"));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		ResolveDuplicatePersonRegistrationsMessageBean message = (ResolveDuplicatePersonRegistrationsMessageBean) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RegistrationControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("registration", message.getControlActEventBean().getRegistrationBean());
		assertEquals("name", "Mabel Hauptman", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRegistrationBean().getRecord().getIndeterminatePerson().getName()));
		
		assertFalse(((RegistrationRequestBean) message.getControlActEventBean().getRegistrationBean()).getPriorRegistrations().isEmpty());
	}
	
	private ResolveDuplicatePersonRegistrationsMessageBean createRequest() {
		ResolveDuplicatePersonRegistrationsMessageBean model = new ResolveDuplicatePersonRegistrationsMessageBean();
		model.getControlActEventBean().setCode(HL7TriggerEventCode.RESOLVE_DUPLICATE_PERSON_REGISTRATIONS);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEventBean().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEventBean().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		RegistrationRequestBean<IdentifiedPersonBean> registration = 
				new RegistrationRequestBean<IdentifiedPersonBean>();
		
		IdentifiedPersonBean identifiedEntityBean = new IdentifiedPersonBean();
		identifiedEntityBean.setStatusCode(RoleStatus.ACTIVE);
		
		registration.setRecord(identifiedEntityBean);
		registration.getRecord().getIds().add(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		registration.getRecord().getIds().add(new Identifier("2.16.840.1.113883.1.133", "9283489"));
		
		registration.getRecord().getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		registration.getRecord().getIndeterminatePerson().setName(PersonName.createFirstNameLastName("Mabel", "Hauptman"));
		registration.getRecord().getIndeterminatePerson().setBirthTime(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		registration.getRecord().getIndeterminatePerson().getLanguageCommunications().add(
				new LanguageCommunicationBeanBuilder().withLanguageCode("en").create());

		ReplacementOfBean replacementOf = new ReplacementOfBean();
		replacementOf.setId(new Identifier("2.16.840.1.113883.1.133", "9283410"));
		registration.getPriorRegistrations().add(replacementOf);
		
		registration.setAssignedDevice(new AssignedDeviceBean());
		registration.getAssignedDevice().setId(new Identifier("1.2.3", "112233"));
		registration.getAssignedDevice().setAssignedRepository("Newfoundland/Panacea");
		registration.getAssignedDevice().setRepresentedRepositoryJurisdiction("Newfoundland");
		
		model.getControlActEventBean().setRegistrationBean(registration);
		
		return model;
	}
	
}
