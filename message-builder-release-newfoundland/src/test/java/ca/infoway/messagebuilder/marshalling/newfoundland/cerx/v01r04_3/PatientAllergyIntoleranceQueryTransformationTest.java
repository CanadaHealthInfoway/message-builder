package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.newfoundland.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.AllergyIntoleranceQueryCriteriaBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.PatientAllergyIntoleranceQueryMessageBeanNew;
import ca.infoway.messagebuilder.model.newfoundland.cerx.allergy.PatientAllergyIntoleranceQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;


public class PatientAllergyIntoleranceQueryTransformationTest extends BaseTransformerTestCase {
	
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientAllergyIntoleranceQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientAllergyIntoleranceQueryResponse.xml";


	@Before
	public void registerQueryRequestLimitCodeResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}	

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		PatientAllergyIntoleranceQueryMessageBeanNew model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", PatientAllergyIntoleranceQueryMessageBeanNew.class, result.getMessageObject().getClass());
		
		PatientAllergyIntoleranceQueryMessageBeanNew messageObject = (PatientAllergyIntoleranceQueryMessageBeanNew) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}
	
	private PatientAllergyIntoleranceQueryMessageBeanNew createQuery() {
		AllergyIntoleranceQueryCriteriaBean criteria = new AllergyIntoleranceQueryCriteriaBean();
		
		PatientAllergyIntoleranceQueryMessageBeanNew model = new PatientAllergyIntoleranceQueryMessageBeanNew(criteria);
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_ADVERSE_REACTION_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		criteria.setIncludeNotesIndicator(false);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return model;
	}
	
	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
		PatientAllergyIntoleranceQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		PatientAllergyIntoleranceQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
//		
//		ClasspathResource resource = new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE);
//		Assert.assertEquals(IOUtils.toString(resource.getInputStream()), xml);
//		
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}

	private PatientAllergyIntoleranceQueryResponseMessageBean createResponseBean() {
		AllergyIntoleranceQueryCriteriaBean criteria = new AllergyIntoleranceQueryCriteriaBean();
		
		PatientAllergyIntoleranceQueryResponseMessageBean model = new PatientAllergyIntoleranceQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_MEDICAL_CONDITIONS_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		AllergyIntoleranceBean allergyIntolerance = new AllergyIntoleranceTestBeanBuilder().build();
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<AllergyIntoleranceBean>(allergyIntolerance));
		
//		MessageAttributeBeanTestData.populateAcknowledgement(model.getAcknowledgement());
		
		criteria.setIncludeNotesIndicator(true);
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		return model;
	}

}
