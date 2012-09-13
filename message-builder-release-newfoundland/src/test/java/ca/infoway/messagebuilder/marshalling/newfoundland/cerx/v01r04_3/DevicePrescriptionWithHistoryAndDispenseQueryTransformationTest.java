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

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DetectedIssueBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.HistoricalControlActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DeviceDispenseBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionDetailQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionWithHistoryAndDispenseQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class DevicePrescriptionWithHistoryAndDispenseQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/devicePrescriptionWithHistoryAndDispenseQuery.xml";
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
		CodeResolverRegistry.registerResolver(ActCode.class,
				new CompositeCodeResolver( 
						new EnumBasedCodeResolver(MockActCodeEnum.class),
						new TrivialCodeResolver()));
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
		assertEquals("type", DevicePrescriptionWithHistoryAndDispenseQueryMessageBean.class, result.getMessageObject().getClass());
		
		DevicePrescriptionWithHistoryAndDispenseQueryMessageBean messageObject = (DevicePrescriptionWithHistoryAndDispenseQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getPatientId());
	}

	private DevicePrescriptionWithHistoryAndDispenseQueryMessageBean createQuery() {
		DevicePrescriptionDetailQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionWithHistoryAndDispenseQueryMessageBean model = new DevicePrescriptionWithHistoryAndDispenseQueryMessageBean(criteria);
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_WITH_HISTORY_AND_DISPENSE_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private DevicePrescriptionDetailQueryCriteriaBean createCriteria() {
		DevicePrescriptionDetailQueryCriteriaBean criteria = new DevicePrescriptionDetailQueryCriteriaBean();
		
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setAmendedInTimeRange(IntervalFactory.createLow(new Date(0)));
		criteria.setIncludeEventHistoryIndicator(false);
		criteria.setPrescriptionOrderNumber(new Identifier("5.4.3.2.1", "1.2.3"));
		return criteria;
	}

	@Test @Ignore
	public void shouldCreateAMeaningfulResponse() throws Exception {
		DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(VERSION, model);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, new DocumentFactory().createFromString(xml1));
		String xml2 = toHl7((NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}

	private DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean createResponseBean() {
		DevicePrescriptionDetailQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean model = new DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_DETAILS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		DeviceDispenseBean deviceDispenseBean = new DeviceDispenseBean();
		deviceDispenseBean.setPrescriptionDispenseNumber(new Identifier("prescription dispense", "number"));
		deviceDispenseBean.setDispenseStatus(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		deviceDispenseBean.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot() ));
		deviceDispenseBean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		deviceDispenseBean.setPerformer(new AssignedPersonBeanBuilder().populate().create());
		deviceDispenseBean.setServiceDeliveryLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		deviceDispenseBean.setUsageInstructions("usage instructions");
		deviceDispenseBean.setSupplyEvent(new SupplyEventBeanBuilder().populateDevice().create());
		deviceDispenseBean.setPrescriptionOrderNumber(new Identifier("prescription order", "number"));
		deviceDispenseBean.setSupplyRequestResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		deviceDispenseBean.setSupplyRequestAuthor(new AssignedPersonBeanBuilder().populate().create());
		deviceDispenseBean.getDeviceDispenseHistoryRecords().add(new HistoricalControlActEventBeanBuilder().withTriggerEventCode("PORX_TE060250UV").populate().create());
		deviceDispenseBean.getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
		deviceDispenseBean.getNotes().add(new NoteBeanBuilder().populate().create());

		model.getControlActEventBean().getQueryRecords().add(new RecordBean<DeviceDispenseBean>(deviceDispenseBean));
		
		return model;
	}

}
