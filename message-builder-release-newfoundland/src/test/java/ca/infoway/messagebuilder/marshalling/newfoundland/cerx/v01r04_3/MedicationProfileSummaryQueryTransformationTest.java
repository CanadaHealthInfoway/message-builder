package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
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
import ca.infoway.messagebuilder.model.newfoundland.cerx.RefusalToFillBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.MedicationPrescriptionBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ReasonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.MedicationProfileSummaryQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedicationProfileSummaryQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationProfileSummaryQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationProfileSummaryQueryResponse.xml";

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
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		ClasspathResource classpathResource = new ClasspathResource(getClass(), QUERY_MESSAGE_FILE);
		Document createFromResource = this.factory.createFromResource(classpathResource);
		assertTreeEquals(createFromResource, actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		assertEquals("type", MedicationProfileSummaryQueryMessageBean.class, result.getMessageObject().getClass());
		
		MedicationProfileSummaryQueryMessageBean messageObject = (MedicationProfileSummaryQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createQuery());
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, messageObject);
		assertEquals(xml, transformedBackToHl7Xml);
	}
	
	private MedicationProfileSummaryQueryMessageBean createQuery() {
		MedicationProfileSummaryQueryCriteriaBean criteria = createCriteria();
		
		MedicationProfileSummaryQueryMessageBean model = new MedicationProfileSummaryQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PROFILE_SUMMARY_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private MedicationProfileSummaryQueryCriteriaBean createCriteria() {
		MedicationProfileSummaryQueryCriteriaBean criteria = new MedicationProfileSummaryQueryCriteriaBean();
		
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setAdministrationEffectivePeriod(IntervalUtil.createInterval(DateUtil.getDate(1970, 0, 1), DateUtil.getDate(2020, 0, 1)));
		criteria.setAmendedInTimeRange(IntervalUtil.createInterval(DateUtil.getDate(1970, 0, 1), DateUtil.getDate(2020, 0, 1)));
		criteria.setIssueFilterCode(IssueFilterCode.ALL);
		criteria.setMostRecentByDrugIndicator(false);
		
		return criteria;
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		MedicationProfileSummaryQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldCreateResponseBeanFromXml() throws Exception {
//		
//		ClasspathResource classpathResource = new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE);
//		String responseAsString = IOUtils.toString(classpathResource.getInputStream());
//		assertPassesMessageValidation(responseAsString, SpecificationVersion.NEWFOUNDLAND);
//		
		Document response = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, response);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		Assert.assertNotNull(messageObject);
		for (Hl7Error hl7Error : xmlToJavaResult.getHl7Errors()) {
			Assert.assertFalse("xsi:nil specified", hl7Error.getMessage().contains("does not specify xsi:nil=\"true\""));
		}
	}
	
	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
		MedicationProfileSummaryQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, this.factory.createFromString(xml1));
		String xml2 = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}
	
	private MedicationProfileSummaryQueryResponseMessageBean createResponseBean() {
		MedicationProfileSummaryQueryCriteriaBean criteria = createCriteria();
		
		MedicationProfileSummaryQueryResponseMessageBean model = new MedicationProfileSummaryQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1.2.3.4.5.6.7.8"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
//		MessageAttributeBeanTestData.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PROFILE_SUMMARY_RESPONSE);
		model.setQueryId(new Identifier("1.2.3.4.5.6.7.8.9"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());

		MedicationPrescriptionBean medicationPrescription = new MedicationPrescriptionBean();
		medicationPrescription.setId(new Identifier("1.2.3", "extention"));
		medicationPrescription.setAuthor(new AuthorBeanBuilder().populate().create());
		medicationPrescription.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		medicationPrescription.setUsageInstructions("usageInstructions");
		medicationPrescription.setCode(lookup(ActCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		
		medicationPrescription.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		medicationPrescription.getReasons().add(new ReasonBeanBuilder().populate().create());
		medicationPrescription.getRefusalToFill().add(new RefusalToFillBeanBuilder().populate().create());
//		medicationPrescription.setFirstDispenseEffectiveTime(IntervalFactory.createLow(new Date(0)));
//		medicationPrescription.setFirstDispenseQuantity(1);
//		medicationPrescription.setLastDispenseEffectiveTime(IntervalFactory.createLow(new Date(0)));
//		medicationPrescription.setLastDispenseQuantity(1);
//		medicationPrescription.setPreviousDispenseQuantity(1);
//		medicationPrescription.setPreviousDispenseRepeatNumber(1);
//		medicationPrescription.setRemainingDispenseQuantity(0);
//		medicationPrescription.setRemainingDispenseRepeatNumber(0);
		medicationPrescription.setSupplyEventFirstSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventLastSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventPastSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setSupplyEventFutureSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		medicationPrescription.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		medicationPrescription.setUsageInstructions("usage instructions");
		
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<MedicationProfileSummaryBean>(medicationPrescription));
		
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
		XmlToModelResult result = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, actual);
		Hl7Error found = null;
		for (Hl7Error error : result.getHl7Errors()) {
			found = error;
		}
		assertNull(ObjectUtils.toString(found), found);
	}	
}
