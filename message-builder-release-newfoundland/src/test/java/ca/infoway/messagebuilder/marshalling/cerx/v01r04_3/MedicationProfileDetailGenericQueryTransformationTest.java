package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.j5goodies.DateUtil.getDate;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder.CombinedMedicationBeanType.PORX_MT060340CA;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import ca.infoway.messagebuilder.domainvalue.ActNonConditionIndicationCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBean;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.MedicationProfileDetailGenericQueryCriteriaBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.MedicationProfileDetailGenericQueryMessageBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.MedicationProfileDetailGenericQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.MedicationRecordBean;
import ca.infoway.messagebuilder.model.cerx.othermedication.OtherMedicationBean;
import ca.infoway.messagebuilder.model.cerx.othermedication.OtherMedicationBeanBuilder;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedicationProfileDetailGenericQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationProfileDetailGenericQuery.xml";

	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));

	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml, VERSION);
	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
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
		assertEquals("type", MedicationProfileDetailGenericQueryMessageBean.class, result.getMessageObject().getClass());
		
		MedicationProfileDetailGenericQueryMessageBean messageObject = (MedicationProfileDetailGenericQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}

	private MedicationProfileDetailGenericQueryMessageBean createQuery() {
		MedicationProfileDetailGenericQueryCriteriaBean criteria = new MedicationProfileDetailGenericQueryCriteriaBean();
		
		MedicationProfileDetailGenericQueryMessageBean model = new MedicationProfileDetailGenericQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PROFILE_DETAIL_GENERIC_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		criteria.setAdministrationEffectivePeriod(IntervalFactory.createLowHigh(getDate(2009, 01, 01), getDate(2010, 01, 01)));
		criteria.setAmendedInTimeRange(IntervalFactory.createLowHigh(getDate(2009, 02, 02), getDate(2010, 02, 02)));
		criteria.setDiagnosisCode(lookup(DiagnosisValue.class, "402261004", CodeSystem.SNOMED.getRoot()));
		criteria.setDrugCode(lookup(ClinicalDrug.class, "02237726", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		criteria.setIncludeEventHistoryIndicator(true);
		criteria.setIncludeIssuesIndicator(true);
		criteria.setIncludeNotesIndicator(true);
		criteria.setIncludePendingChangesIndicator(true);
		criteria.setIssueFilterCode(lookup(IssueFilterCode.class, "A", CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot()));
		criteria.setMostRecentByDrugIndicator(true);
		criteria.setMostRecentDispenseForEachRxIndicator(true);
		
		criteria.setOtherIndicationCode(lookup(ActNonConditionIndicationCode.class, "IND01", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		criteria.setOtherMedicationRecordId(new Identifier("1.2.3.4.5", "4.5.6"));
		criteria.setPrescriberProviderId(new Identifier("1.1.1.1.1", "2.2.2"));
		criteria.setPrescriptionOrderNumber(new Identifier("3.3.3.3.3", "4.4.4"));
		criteria.setPrescriptionDispenseNumber(new Identifier("5.5.5.5.5", "6.6.6"));
		criteria.setPrescriptionStatus(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		criteria.getRxDispenseIndicator().add(lookup(PrescriptionDispenseFilterCode.class, "N", CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot()));
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987,11,01));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		
		return model;
	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldCreateAMeaningfulResponse() throws Exception {
		MedicationProfileDetailGenericQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml, VERSION);
	}

	private MedicationProfileDetailGenericQueryResponseMessageBean createResponseBean() {
		MedicationProfileDetailGenericQueryCriteriaBean criteria = new MedicationProfileDetailGenericQueryCriteriaBean();
		
		MedicationProfileDetailGenericQueryResponseMessageBean model = new MedicationProfileDetailGenericQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad58"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PROFILE_DETAIL_GENERIC_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad38"));
		
		model.getControlActEvent().getQueryRecords().add(
				new RecordBean<MedicationRecordBean>(new CombinedMedicationBeanBuilder(PORX_MT060340CA).populate().create()));
		OtherMedicationBean otherMedicationBean = new OtherMedicationBeanBuilder().populate().create();
		otherMedicationBean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		model.getControlActEvent().getQueryRecords().add(new RecordBean<MedicationRecordBean>(otherMedicationBean));

		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987,11,01));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setIssueFilterCode(lookup(IssueFilterCode.class, "A", CodeSystem.VOCABULARY_QUERY_PARAMETER_VALUE.getRoot()));
		
		return model;
	}

}
