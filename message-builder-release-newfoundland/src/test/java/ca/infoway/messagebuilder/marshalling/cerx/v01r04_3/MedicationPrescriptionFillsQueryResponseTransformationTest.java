package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.cerx.MedicationDispenseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.query.MedicationPrescriptionFillsQueryResponseMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class MedicationPrescriptionFillsQueryResponseTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	private static final String MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/medicationPrescriptionFillsQueryResponse.xml";
	
	@Test
	public void shouldProduceSomeQuery() throws Exception {
		assertNotNull("query", this.transformer.transformToHl7(VERSION, createQueryResponseBean()));
	}

	@Test
	public void shouldMatchKnownQuery() throws Exception {
		MedicationPrescriptionFillsQueryResponseMessageBean model = createQueryResponseBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(MESSAGE_FILE)), actual);
	}

	private MedicationPrescriptionFillsQueryResponseMessageBean createQueryResponseBean() {
		MedicationPrescriptionFillsQueryResponseMessageBean model = new MedicationPrescriptionFillsQueryResponseMessageBean();
		model.getControlActEventBean().setCode(HL7TriggerEventCode.MEDICATION_PRESCRIPTION_FILLS_QUERY_RESPONSE);
		MessageBeanBuilderSupport.populateStandardValuesV01(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setQueryId(new Identifier("1.2.3.4.5", "1"));
		MessageBeanBuilderSupport.populateQuerySummary(model.getQuerySummary(), model.getQueryId());
		
		model.getCriteria().setIssueFilterCode(CodeResolverRegistry.lookup(IssueFilterCode.class, "A"));
		model.getCriteria().setPatientBirthDate(DateUtil.getDate(2009, 1, 1));
		model.getCriteria().setPatientGender(CodeResolverRegistry.lookup(AdministrativeGender.class, "M"));
		model.getCriteria().setPatientId(new Identifier("1.2.3", "4"));
		model.getCriteria().setPatientName(PersonName.createFirstNameLastName("John", "Doe"));
		model.getCriteria().setPrescriptionOrderNumber(new Identifier("1.2.3.4.5.6", "9"));		
		
		model.getQueryRecords().add(new RecordBean<MedicationDispenseBean>(new MedicationDispenseBeanBuilder().populate().create()));
		
		return model;
	}

	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		MessageBean messageObject = (MessageBean) result.getMessageObject(); 
		assertTrue("type", messageObject instanceof MedicationPrescriptionFillsQueryResponseMessageBean);

		MedicationPrescriptionFillsQueryResponseMessageBean bean = (MedicationPrescriptionFillsQueryResponseMessageBean) messageObject;
		assertEquals("criteria.patientGender", "M", bean.getCriteria().getPatientGender().getCodeValue());
	}

}
