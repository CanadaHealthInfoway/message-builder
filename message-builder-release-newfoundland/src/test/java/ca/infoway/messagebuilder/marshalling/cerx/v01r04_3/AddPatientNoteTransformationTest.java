package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_PATIENT_NOTE_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_PATIENT_NOTE_REQUEST_REFUSED;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.annotation.AddPatientNoteAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.annotation.AddPatientNoteMessageBean;
import ca.infoway.messagebuilder.model.cerx.annotation.AddPatientNoteRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class AddPatientNoteTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addPatientNoteRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addPatientNoteRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/addPatientNoteRequestRefused.xml";
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean());
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RecordRequestMessageBean<NoteBean> message = (RecordRequestMessageBean<NoteBean>) result.getMessageObject();
		assertNotNull("object", message);
		
		assertEquals("control act", RecordControlActEventBean.class, message.getControlActEventBean().getClass());
		assertNotNull("record", message.getControlActEventBean().getRecord());
		assertEquals("name", "Hannah Lambert", 
				NameFormatter.getSimpleNameFormatter().format(
						message.getControlActEventBean().getRecord().getPatient().getIndeterminatePerson().getName()));
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActEventBean> acceptedBean = new AddPatientNoteAcceptedMessageBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(ACCEPTED_MESSAGE_FILE)), actual);
	}

	private void populateAcceptedBean(RecordResponseMessageBean<ActEventBean> acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(ADD_PATIENT_NOTE_REQUEST_ACCEPTED);
		acceptedBean.getControlActEvent().setRecordBean(new RecordBean<ActEventBean>());
		acceptedBean.getControlActEvent().getRecordBean().setRecord(new ActEventBeanBuilder().populate().create());
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		AddPatientNoteRefusedMessageBean refusedBean = new AddPatientNoteRefusedMessageBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REFUSED_MESSAGE_FILE)), actual);
	}

	protected void populateRefusedBean(AddPatientNoteRefusedMessageBean refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(ADD_PATIENT_NOTE_REQUEST_REFUSED);
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	private AddPatientNoteMessageBean createRequestBean() {
		AddPatientNoteMessageBean model = new AddPatientNoteMessageBean();
		model.getControlActEvent().setCode(ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_PATIENT_NOTE_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());

		NoteBean noteBean = new NoteBeanBuilder().populate().create();
		RecordBean<NoteBean> recordBean = new RecordBean<NoteBean>(noteBean);
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
}