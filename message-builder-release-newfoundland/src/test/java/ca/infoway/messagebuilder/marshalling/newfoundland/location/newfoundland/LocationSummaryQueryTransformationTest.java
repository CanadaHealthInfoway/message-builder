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

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationPlaceType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryRoleStatus;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.CustodianBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventRecordBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationSummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationSummaryQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationSummaryQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.location.LocationSummaryQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class LocationSummaryQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/location/newfoundland/locationSummaryQuery.xml";
	private static final String QUERY_BY_NAME_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/location/newfoundland/locationSummaryQuery_byName.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = toHl7UsingNewRenderer(createQuery(), VERSION);
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
		assertPassesMessageValidation(xml, VERSION);
	}

	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = toHl7UsingNewRenderer(model, VERSION);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", LocationSummaryQueryMessageBean.class, result.getMessageObject().getClass());
		
		LocationSummaryQueryMessageBean messageObject = (LocationSummaryQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getEHRRepositoryId());
	}

	@Test
	public void shouldParseSecondMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_BY_NAME_MESSAGE_FILE));
		MessageBean messageObject = (MessageBean) this.transformer.transformFromHl7(VERSION, message).getMessageObject();
		assertEquals("type", LocationSummaryQueryMessageBean.class, messageObject.getClass());
		
		assertEquals("name contains", "Greg Betty Memorial", ((LocationSummaryQueryMessageBean) messageObject).getCriteria().getNameContains());
	}

	private LocationSummaryQueryMessageBean createQuery() {
		LocationSummaryQueryCriteriaBean criteria = new LocationSummaryQueryCriteriaBean();
		
		LocationSummaryQueryMessageBean model = new LocationSummaryQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.LOCATION_SUMMARY_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		criteria.setEHRRepositoryId(new Identifier("1.2.3.4.5.6", "987654"));
		
		return model;
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldCreateAMeaningfulResponse() throws Exception {
		
//      FIXME - TM/BC - using the new renderer, this test will fail (detected issue not written)		
		
//		LocationSummaryQueryResponseMessageBean model = createResponseBean();
//		String xml = toHl7UsingNewRenderer(model, VERSION);
//		assertValidHl7Message(xml);
		
		LocationSummaryQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml);
		
		// TE/SPD: MANDATORY_FIELD_NOT_PROVIDED > Expected populated association "detectedIssueEvent" for element (<subjectOf/>)
		// we're commenting out validation for now
//		assertPassesMessageValidation(xml, BaseTransformerTestCase.NEWFOUNDLAND);
	}

	private LocationSummaryQueryResponseMessageBean createResponseBean() {
		LocationSummaryQueryCriteriaBean criteria = new LocationSummaryQueryCriteriaBean();
		
		LocationSummaryQueryResponseMessageBean model = new LocationSummaryQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.LOCATION_DETAILS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		LocationSummaryBean summary = new LocationSummaryBean();
		summary.setId(new Identifier("2.16.840.1.113883.4.267", "NL.00111.3"));
		summary.setCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationRoleType.class, "HOSP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		summary.getName().add("Greg Betty Memorial Hospital");
		summary.setPlaceCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationPlaceType.class, "BLDG", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		summary.setMobileInd(false);
		summary.setStatusCode(CodeResolverRegistry.lookup(
				ServiceDeliveryRoleStatus.class, "active", CodeSystem.VOCABULARY_ROLE_STATUS.getRoot()));
		
		LocationSummaryBean summary2 = new LocationSummaryBean();
		summary2.setId(new Identifier("2.16.840.1.113883.4.267", "NL.00111.4"));
		summary2.setCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationRoleType.class, "ER", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		summary2.getName().add("Greg Betty Memorial Emergency Department");
		summary2.setPlaceCode(CodeResolverRegistry.lookup(
				ServiceDeliveryLocationPlaceType.class, "BLDG", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		summary2.setMobileInd(false);
		summary2.setStatusCode(CodeResolverRegistry.lookup(
				ServiceDeliveryRoleStatus.class, "active", CodeSystem.VOCABULARY_ROLE_STATUS.getRoot()));
		
		RegistrationEventRecordBean<LocationSummaryBean> registrationEvent = new RegistrationEventRecordBean<LocationSummaryBean>(summary, ActStatus.ACTIVE);
		registrationEvent.setCustodian(new CustodianBeanBuilder().populate().create());
		model.getControlActEventBean().getQueryRecords().add(registrationEvent);

		RegistrationEventRecordBean<LocationSummaryBean> registrationEvent2 = new RegistrationEventRecordBean<LocationSummaryBean>(summary2, ActStatus.ACTIVE);
		registrationEvent2.setCustodian(new CustodianBeanBuilder().populate().create());
		model.getControlActEventBean().getQueryRecords().add(registrationEvent2);
		
		criteria.setNameContains("Greg Betty");
		MessageBeanBuilderSupport.populateQuerySummary(model);
		return model;
	}
}
