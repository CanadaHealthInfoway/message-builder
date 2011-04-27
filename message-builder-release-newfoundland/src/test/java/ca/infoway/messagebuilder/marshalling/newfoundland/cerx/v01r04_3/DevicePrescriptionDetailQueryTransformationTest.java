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
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionDetailQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionDetailQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionDetailQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionDetailsBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ReasonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class DevicePrescriptionDetailQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/devicePrescriptionDetailQuery.xml";
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

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
		assertEquals("type", DevicePrescriptionDetailQueryMessageBean.class, result.getMessageObject().getClass());
		
		DevicePrescriptionDetailQueryMessageBean messageObject = (DevicePrescriptionDetailQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getPatientId());
	}

	private DevicePrescriptionDetailQueryMessageBean createQuery() {
		DevicePrescriptionDetailQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionDetailQueryMessageBean model = new DevicePrescriptionDetailQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_DETAILS_QUERY);
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
		DevicePrescriptionDetailQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(VERSION, model);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, new DocumentFactory().createFromString(xml1));
		String xml2 = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}

	private DevicePrescriptionDetailQueryResponseMessageBean createResponseBean() {
		DevicePrescriptionDetailQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionDetailQueryResponseMessageBean model = new DevicePrescriptionDetailQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_DETAILS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		DevicePrescriptionDetailsBean devicePrescriptionDetails = new DevicePrescriptionDetailsBean();
		devicePrescriptionDetails.setId(new Identifier("1.2.3", "extention"));
		devicePrescriptionDetails.setAuthor(new AuthorBeanBuilder().populate().create());
		devicePrescriptionDetails.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot() ));
		devicePrescriptionDetails.setDirectTarget(new ClinicalDeviceBeanBuilder().populate().create());
		devicePrescriptionDetails.setDispenseInstructions(new DeviceDispenseInstructionsBeanBuilder().populate().create());
		devicePrescriptionDetails.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		devicePrescriptionDetails.getReasons().add(new ReasonBeanBuilder().populate().create());
		devicePrescriptionDetails.getRefusalToFill().add(new RefusalToFillBeanBuilder().populate().create());
		devicePrescriptionDetails.setSupplyEventFirstSummary(createSupplySummaryBean());
		devicePrescriptionDetails.setSupplyEventLastSummary(createSupplySummaryBean());
		devicePrescriptionDetails.setSupplyEventPastSummary(createCumulativeSupplySummaryBean());
		devicePrescriptionDetails.setSupplyEventFutureSummary(createCumulativeSupplySummaryBean());
		devicePrescriptionDetails.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		devicePrescriptionDetails.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		devicePrescriptionDetails.setUsageInstructions("usage instructions");
		devicePrescriptionDetails.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<DevicePrescriptionDetailsBean>(devicePrescriptionDetails));
		
		return model;
	}

	private CumulativeSupplySummaryBean createCumulativeSupplySummaryBean() {
		CumulativeSupplySummaryBean bean = new CumulativeSupplySummaryBean();
		bean.setRepeatNumber(1);
		bean.setQuantity(createPhysicalQuantity(1));
		return bean;
	}

	private SupplySummaryBean createSupplySummaryBean() {
		SupplySummaryBean bean = new SupplySummaryBean();
		bean.setEffectiveTime(IntervalFactory.createLow(new Date(0)));
		bean.setQuantity(createPhysicalQuantity(1));
		return bean;
	}

	private PhysicalQuantity createPhysicalQuantity(int integer) {
		PhysicalQuantity physicalQuantity = new PhysicalQuantity(new BigDecimal(new Integer(integer)), CodeResolverRegistry.lookup(x_DrugUnitsOfMeasure.class, "U", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot()));
		return physicalQuantity;
	}
}
