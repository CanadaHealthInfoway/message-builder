package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils;
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
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DosageInstructionBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription.MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription.MedPrescriptionWithHistoryAndDispensesQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription.MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CombinedMedication3Bean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedPrescriptionWithHistoryAndDispensesQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medPrescriptionWithHistoryAndDispensesQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medPrescriptionWithHistoryAndDispensesQueryResponse.xml";

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
		assertEquals("type", MedPrescriptionWithHistoryAndDispensesQueryMessageBean.class, result.getMessageObject().getClass());
		
		MedPrescriptionWithHistoryAndDispensesQueryMessageBean messageObject = (MedPrescriptionWithHistoryAndDispensesQueryMessageBean) result.getMessageObject();
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
	
	private MedPrescriptionWithHistoryAndDispensesQueryMessageBean createQuery() {
		MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria = createCriteria();
		
		MedPrescriptionWithHistoryAndDispensesQueryMessageBean model = new MedPrescriptionWithHistoryAndDispensesQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PRESCRIPTION_WITH_HISTORY_AND_DISPENSES_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean createCriteria() {
		MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria = new MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean();
		
		criteria.setAmendedInTimeRange(IntervalUtil.createInterval(DateUtil.getDate(1970, 0, 1), DateUtil.getDate(2020, 0, 1)));
		criteria.setIncludeEventHistoryIndicator(true);
		criteria.setIncludeIssuesIndicator(true);
		criteria.setIncludeNotesIndicator(true);
		criteria.setIncludePendingChangesIndicator(true);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setPrescriptionOrderNumber(new Identifier("2.16.124.113620.1.1.8", "4814"));
		return criteria;
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		System.out.println(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}
	

	private MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean createResponseBean() {
		MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria = createCriteria();
		
		MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean model = new MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PRESCRIPTION_WITH_HISTORY_AND_DISPENSES_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());

		CombinedMedication3Bean medicationPrescription = new CombinedMedication3Bean();
		medicationPrescription.setId(new Identifier("1.2.3", "extention"));
		medicationPrescription.setAuthor(new AuthorBeanBuilder().populate().create());
		medicationPrescription.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		
		medicationPrescription.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
//		medicationPrescription.setFirstDispenseEffectiveTime(IntervalFactory.createLow(new Date(0)));
//		medicationPrescription.setFirstDispenseQuantity(1);
//		medicationPrescription.setLastDispenseEffectiveTime(IntervalFactory.createLow(new Date(0)));
//		medicationPrescription.setLastDispenseQuantity(1);
//		medicationPrescription.setPreviousDispenseQuantity(1);
//		medicationPrescription.setPreviousDispenseRepeatNumber(1);
//		medicationPrescription.setRemainingDispenseQuantity(0);
//		medicationPrescription.setRemainingDispenseRepeatNumber(0);
		
		medicationPrescription.setEligibleForTrial(true);
		medicationPrescription.setSupplyEventFirstSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventLastSummary(createSupplySummaryBean());
		medicationPrescription.setSupplyEventPastSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setSupplyEventFutureSummary(createCumulativeSupplySummaryBean());
		medicationPrescription.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		
		medicationPrescription.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().create());
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<CombinedMedication3Bean>(medicationPrescription));
		
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
