package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codeset.QueryRequestLimitEnum;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBean;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.cerx.query.MedicationPrescriptionFillsQueryCriteriaBean;
import ca.infoway.messagebuilder.model.cerx.query.MedicationPrescriptionFillsQueryMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedicationPrescriptionFillsQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String QUERY_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationPrescriptionFillsQuery.xml";

	@Before
	public void registerQueryRequestLimitResolver() {
		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
	}
	
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createQuery());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createQuery();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		XmlAssert.assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), QUERY_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertEquals("type", MedicationPrescriptionFillsQueryMessageBean.class, result.getMessageObject().getClass());
		
		MedicationPrescriptionFillsQueryMessageBean messageBean = (MedicationPrescriptionFillsQueryMessageBean) result.getMessageObject();
		
		assertNotNull(messageBean.getCriteria().getPatientBirthDate());
	}

	private MedicationPrescriptionFillsQueryMessageBean createQuery() {
		MedicationPrescriptionFillsQueryCriteriaBean criteria = new MedicationPrescriptionFillsQueryCriteriaBean();
		
		MedicationPrescriptionFillsQueryMessageBean model = new MedicationPrescriptionFillsQueryMessageBean(criteria);
		MessageBeanBuilderSupport.populateBetterStandardValuesV02(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.MEDICATION_PRESCRIPTION_FILLS_QUERY);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getMessageReceiver().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getSender().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		
		model.getCriteria().setIssueFilterCode(CodeResolverRegistry.lookup(IssueFilterCode.class, "A"));
		model.getCriteria().setPatientBirthDate(DateUtil.getDate(2009, 1, 1));
		model.getCriteria().setPatientGender(CodeResolverRegistry.lookup(AdministrativeGender.class, "M"));
		model.getCriteria().setPatientId(new Identifier("1.2.3", "4"));
		model.getCriteria().setPatientName(PersonName.createFirstNameLastName("John", "Doe"));
		model.getCriteria().setPrescriptionOrderNumber(new Identifier("1.2.3.4.5.6", "9"));
		
		return model;
	}

}
