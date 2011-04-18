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
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.MockActCodeEnum;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationdispense.MedicationDispenseSummaryQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationdispense.NewMedicationDispenseSummaryQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationdispense.NewMedicationDispenseSummaryQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CumulativeSupplySummaryBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.SupplySummaryBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedicationDispenseSummaryQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationDispenseSummaryQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationDispenseSummaryQueryResponse.xml";

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
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		assertEquals("type", NewMedicationDispenseSummaryQueryMessageBean.class, result.getMessageObject().getClass());
		
		NewMedicationDispenseSummaryQueryMessageBean messageObject = (NewMedicationDispenseSummaryQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}

	private NewMedicationDispenseSummaryQueryMessageBean createQuery() {
		MedicationDispenseSummaryQueryCriteriaBean criteria = createCriteria();
		
		NewMedicationDispenseSummaryQueryMessageBean model = new NewMedicationDispenseSummaryQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_DISPENSE_SUMMARY_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private MedicationDispenseSummaryQueryCriteriaBean createCriteria() {
		MedicationDispenseSummaryQueryCriteriaBean criteria = new MedicationDispenseSummaryQueryCriteriaBean();
		
		criteria.setAdministrationEffectivePeriod(IntervalUtil.createInterval(new Date(0), new Date(5)));
		criteria.setIssueFilterCode(IssueFilterCode.ALL);
		criteria.setMostRecentByDrugIndicator(false);
		criteria.setMostRecentDispenseForEachRxIndicator(false);
		
		
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "F", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return criteria;
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		NewMedicationDispenseSummaryQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}

	@Test @Ignore
	public void shouldCreateAMeaningfulResponse() throws Exception {
		NewMedicationDispenseSummaryQueryResponseMessageBean model = createResponseBean();
		String xml1 = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, this.factory.createFromString(xml1));
		String xml2 = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertValidHl7Message(xml2);
		Assert.assertFalse("Response should not have warnings", xml2.contains("<!-- WARNING:"));
		Assert.assertEquals(xml1, xml2);
	}
	
	private NewMedicationDispenseSummaryQueryResponseMessageBean createResponseBean() {
		MedicationDispenseSummaryQueryCriteriaBean criteria = createCriteria();
		
		NewMedicationDispenseSummaryQueryResponseMessageBean model = new NewMedicationDispenseSummaryQueryResponseMessageBean(criteria);
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_DISPENSE_SUMMARY_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		MedicationDispenseBean dispenseBean = new MedicationDispenseBeanBuilder().populate().create();
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<MedicationDispenseBean>(dispenseBean));
		
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
