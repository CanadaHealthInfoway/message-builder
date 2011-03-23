package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.cerx.annotation.PatientNoteQueryCriteriaBean;
import ca.infoway.messagebuilder.model.cerx.annotation.PatientNoteQueryMessageBean;
import ca.infoway.messagebuilder.model.cerx.annotation.PatientNoteQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class PatientNoteQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientNoteQuery.xml";
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/patientNoteQueryResponse.xml";

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
		PatientNoteQueryMessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", PatientNoteQueryMessageBean.class, result.getMessageObject().getClass());
		
		PatientNoteQueryMessageBean messageObject = (PatientNoteQueryMessageBean) result.getMessageObject();
		assertEquals("repository id", new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"), messageObject.getCriteria().getPatientId());
	}
	
	private PatientNoteQueryMessageBean createQuery() {
		PatientNoteQueryMessageBean model = new PatientNoteQueryMessageBean(createCriteriaBean());
		
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_NOTE_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		
		return model;
	}

	private PatientNoteQueryCriteriaBean createCriteriaBean() {
		PatientNoteQueryCriteriaBean criteria = new PatientNoteQueryCriteriaBean();
		criteria.setPatientId(new Identifier("2.16.840.1.113883.1.133", "8048151067070480384"));
		criteria.setPatientGender(lookup(AdministrativeGender.class, "M", CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		criteria.setPatientBirthDate(DateUtil.getDate(1987, 11, 1));
		criteria.setPatientName(PersonName.createFirstNameLastName("Tim", "Eapen"));
		criteria.setAnnotationCode(lookup(ActPatientAnnotationCode.class, "GEN", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		return criteria;
	}
	
	@Test
	public void shouldCreateMeaningfulResponse() throws Exception {
		PatientNoteQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownResponse() throws Exception {
		PatientNoteQueryResponseMessageBean model = createResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
System.out.println(xml);		
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_RESPONSE_MESSAGE_FILE)), actual);
	}

	private PatientNoteQueryResponseMessageBean createResponseBean() {
		PatientNoteQueryResponseMessageBean model = new PatientNoteQueryResponseMessageBean(createCriteriaBean());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.PATIENT_NOTE_QUERY_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
		model.getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<NoteBean>(
				new NoteBeanBuilder().populate().create()));
		model.getControlActEventBean().getQueryRecords().add(new RecordBean<NoteBean>(
				new NoteBeanBuilder().populate().create()));
		
		return model;
	}

}
