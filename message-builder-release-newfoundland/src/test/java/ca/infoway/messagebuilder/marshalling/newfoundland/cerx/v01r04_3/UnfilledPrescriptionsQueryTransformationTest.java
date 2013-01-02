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

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UNFILLED_PRESCRIPTIONS_QUERY;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.UNFILLED_PRESCRIPTIONS_QUERY_RESPONSE;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.ObjectUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.BasePrescriptionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.MedicationPrescriptionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ReasonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.unfilledprescription.UnfilledPrescriptionQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.unfilledprescription.UnfilledPrescriptionQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.unfilledprescription.UnfilledPrescriptionQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class UnfilledPrescriptionsQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/unfilledPrescriptionsQuery.xml";
	//private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/unfilledPrescriptionsQuery.xml";

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
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		assertEquals("type", UnfilledPrescriptionQueryMessageBean.class, result.getMessageObject().getClass());
		
		UnfilledPrescriptionQueryMessageBean messageObject = (UnfilledPrescriptionQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}

	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createQuery());
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject);
		assertEquals(xml, transformedBackToHl7Xml);
	}
	
	private UnfilledPrescriptionQueryMessageBean createQuery() {
		UnfilledPrescriptionQueryCriteriaBean criteria = createCriteria();
		
		UnfilledPrescriptionQueryMessageBean model = new UnfilledPrescriptionQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(UNFILLED_PRESCRIPTIONS_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	
	
	private UnfilledPrescriptionQueryCriteriaBean createCriteria() {
		UnfilledPrescriptionQueryCriteriaBean criteria = new UnfilledPrescriptionQueryCriteriaBean();
		
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto")));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setAdministrationEffectivePeriod(IntervalUtil.createInterval(new Date(0), new Date(5)));
		criteria.getPrescriptionStatus().add(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		criteria.getPrescriptionStatus().add(lookup(ActStatus.class, "new", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		return criteria;
	}

	@Test @Ignore
	public void shouldCreateAMeaningfulResponse() throws Exception {
		UnfilledPrescriptionQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, this.factory.createFromString(xml1));
		String xml2 = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}
	
	private UnfilledPrescriptionQueryResponseMessageBean createResponseBean() {
		UnfilledPrescriptionQueryCriteriaBean criteria = createCriteria();
		
		UnfilledPrescriptionQueryResponseMessageBean model = new UnfilledPrescriptionQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(UNFILLED_PRESCRIPTIONS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		DevicePrescriptionBean devicePrescription = new DevicePrescriptionBean();
		devicePrescription.setId(new Identifier("1.2.3", "extention"));
		devicePrescription.setAuthor(new AuthorBeanBuilder().populate().create());
		devicePrescription.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		devicePrescription.setDirectTarget(new ClinicalDeviceBeanBuilder().populate().create());
		devicePrescription.setDispenseInstructions(new DeviceDispenseInstructionsBeanBuilder().populate().create());
		devicePrescription.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		devicePrescription.getReasons().add(new ReasonBeanBuilder().populate().create());
		devicePrescription.getRefusalToFill().add(new RefusalToFillBeanBuilder().populate().create());
		devicePrescription.setSupplyEventFirstSummary(createSupplySummaryBean());
		devicePrescription.setSupplyEventLastSummary(createSupplySummaryBean());
		devicePrescription.setSupplyEventPastSummary(createCumulativeSupplySummaryBean());
		devicePrescription.setSupplyEventFutureSummary(createCumulativeSupplySummaryBean());
		devicePrescription.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		devicePrescription.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		devicePrescription.setUsageInstructions("usage instructions");

		MedicationPrescriptionBean medicationPrescription = new MedicationPrescriptionBean();
		medicationPrescription.setId(new Identifier("1.2.3", "extention"));
		medicationPrescription.setCode(lookup(ActCode.class, "12345678", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		medicationPrescription.setAuthor(new AuthorBeanBuilder().populate().create());
		medicationPrescription.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		medicationPrescription.setDispenseInstructions(new MedicationDispenseInstructionsBeanBuilder().populate().create());
		medicationPrescription.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		medicationPrescription.getReasons().add(new ReasonBeanBuilder().populate().create());
		medicationPrescription.getRefusalToFill().add(new RefusalToFillBeanBuilder().populate().create());
		medicationPrescription.setSupplyEventFirstSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventLastSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventPastSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setSupplyEventFutureSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		medicationPrescription.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		medicationPrescription.setUsageInstructions("usage instructions");
		medicationPrescription.setAnnotationIndicator(true);
		medicationPrescription.setDetectedIssueIndicator(true);
		medicationPrescription.setMedication(new MedicineBeanBuilder().populate().create());
		
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<BasePrescriptionBean>(medicationPrescription));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<BasePrescriptionBean>(devicePrescription));
		
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
	
	@Override // we want to use v01r04_3 hotfix 2 rather than NEWFOUNDLAND
	protected void assertValidHl7Message(Document actual) {
		XmlToModelResult result = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, actual);
		Hl7Error found = null;
		for (Hl7Error error : result.getHl7Errors()) {
			found = error;
		}
		assertNull(ObjectUtils.toString(found), found);
	}	
		
}
