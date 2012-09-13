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

package ca.infoway.messagebuilder.marshalling.newfoundland.location.newfoundland;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.CustodianBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventRecordBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationDetailsBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationDetailsQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationDetailsQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationDetailsQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class LocationDetailsQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/location/newfoundland/locationDetailsQuery.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = toHl7UsingNewRenderer(createQuery(), BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK);
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = toHl7(model);
		System.out.println(xml);
		Document actual = this.factory.createFromString(xml);
		XmlAssert.assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		assertEquals("type", LocationDetailsQueryMessageBean.class, result.getMessageObject().getClass());
		
		LocationDetailsQueryMessageBean messageBean = (LocationDetailsQueryMessageBean) result.getMessageObject();
		assertEquals("criteria", 1, messageBean.getCriteria().getRecordIds().size());
	}

	private LocationDetailsQueryMessageBean createQuery() {
		LocationDetailsQueryMessageBean model = new LocationDetailsQueryMessageBean(createCriteria());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setStatusCode(ActStatus.COMPLETED);
		model.getControlActEvent().setCode(HL7TriggerEventCode.LOCATION_DETAILS_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getMessageReceiver().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getSender().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		
		return model;
	}

	private LocationDetailsQueryCriteriaBean createCriteria() {
		LocationDetailsQueryCriteriaBean criteria = new LocationDetailsQueryCriteriaBean();
		criteria.getRecordIds().add(new Identifier("2.1.3.4.5.67.123", "123456"));
		return criteria;
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldProduceMeaningfulResponse() throws Exception {
		LocationDetailsQueryResponseMessageBean model = createResponseBean();
		String xml = toHl7(model);
		assertValidHl7Message(xml);
	}

	private LocationDetailsQueryResponseMessageBean createResponseBean() {
		LocationDetailsQueryResponseMessageBean model = new LocationDetailsQueryResponseMessageBean(createCriteria());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEventBean());
		model.getControlActEvent().setCode(HL7TriggerEventCode.LOCATION_DETAILS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getMessageReceiver().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getSender().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
		model.getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		
		LocationDetailsBean summary = new LocationDetailsBean();
		summary.setId(new Identifier("2.16.840.1.113883.4.267", "NL.00111.3"));
		summary.setCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationRoleType.class, "HOSP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		summary.getName().add("Greg Betty Memorial Hospital");
		summary.setPlaceCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationPlaceType.class, "BLDG", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		summary.setMobileInd(false);
		summary.setStatusCode(CodeResolverRegistry.lookup(
				ServiceDeliveryRoleStatus.class, "active", CodeSystem.VOCABULARY_ROLE_STATUS.getRoot()));

		
		RegistrationEventRecordBean<LocationDetailsBean> registrationEvent = new RegistrationEventRecordBean<LocationDetailsBean>(summary, ActStatus.ACTIVE);
		registrationEvent.setCustodian(new CustodianBeanBuilder().populate().create());
		model.getControlActEventBean().getQueryRecords().add(registrationEvent);
		
		MessageBeanBuilderSupport.populateQuerySummary(model);
		
		return model;
	}
}
