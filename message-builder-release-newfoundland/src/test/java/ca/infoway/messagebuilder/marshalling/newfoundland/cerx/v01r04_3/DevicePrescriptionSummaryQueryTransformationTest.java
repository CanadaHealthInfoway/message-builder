package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

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
import ca.infoway.messagebuilder.codeset.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.cerx.RefusalToFillBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ClinicalDeviceBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.DeviceDispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ReasonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionSummaryQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionSummaryQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.DevicePrescriptionSummaryQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class DevicePrescriptionSummaryQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/devicePrescriptionSummaryQuery.xml";
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
		assertEquals("type", DevicePrescriptionSummaryQueryMessageBean.class, result.getMessageObject().getClass());
		
		DevicePrescriptionSummaryQueryMessageBean messageObject = (DevicePrescriptionSummaryQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("1.2.3.4.5.6", "987654"), messageObject.getCriteria().getPatientId());
	}

	private DevicePrescriptionSummaryQueryMessageBean createQuery() {
		DevicePrescriptionSummaryQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionSummaryQueryMessageBean model = new DevicePrescriptionSummaryQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_SUMMARY_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private DevicePrescriptionSummaryQueryCriteriaBean createCriteria() {
		DevicePrescriptionSummaryQueryCriteriaBean criteria = new DevicePrescriptionSummaryQueryCriteriaBean();
		
		criteria.setPatientId(new Identifier("1.2.3.4.5.6", "987654"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(new Date(0));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setAmendedInTimeRange(IntervalFactory.createLow(new Date(0)));
		criteria.setIssueFilterCode(lookup(IssueFilterCode.class, "A", CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot()));
		criteria.setMostRecentByDeviceIndicator(true);
		criteria.getRxDispenseIndicator().add(lookup(PrescriptionDispenseFilterCode.class, "N", CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot()));
		criteria.setUsageEffectivePeriod(IntervalFactory.createLow(new Date(0)));
		return criteria;
	}

	@Test @Ignore
	public void shouldCreateAMeaningfulResponse() throws Exception {
		DevicePrescriptionSummaryQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(VERSION, model);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, new DocumentFactory().createFromString(xml1));
		String xml2 = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}
	
	private DevicePrescriptionSummaryQueryResponseMessageBean createResponseBean() {
		DevicePrescriptionSummaryQueryCriteriaBean criteria = createCriteria();
		
		DevicePrescriptionSummaryQueryResponseMessageBean model = new DevicePrescriptionSummaryQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.DEVICE_PRESCRIPTION_SUMMARY_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		DevicePrescriptionBean devicePrescription = new DevicePrescriptionBean();
		devicePrescription.setId(new Identifier("root", "extention"));
		devicePrescription.setAuthor(new AuthorBeanBuilder().populate().create());
		devicePrescription.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot() ));
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
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<DevicePrescriptionBean>(devicePrescription));
		
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
