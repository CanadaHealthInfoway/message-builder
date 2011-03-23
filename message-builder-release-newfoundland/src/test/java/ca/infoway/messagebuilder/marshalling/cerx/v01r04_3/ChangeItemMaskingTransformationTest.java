package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.DEPRECATE_PATIENT_NOTE_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.DEPRECATE_PATIENT_NOTE_REQUEST_ACCEPTED;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.DEPRECATE_PATIENT_NOTE_REQUEST_REFUSED;
import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.util.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.domainvalue.MaskableMaterialEntityType;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.consent.ChangeItemMaskingAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.consent.ChangeItemMaskingMessageBean;
import ca.infoway.messagebuilder.model.cerx.consent.ChangeItemMaskingRefusedMessageBean;
import ca.infoway.messagebuilder.model.cerx.consent.MaskableActTypeBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ChangeItemMaskingTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/changeItemMaskingRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/changeItemMaskingRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/changeItemMaskingRequestRefused.xml";
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
		RecordRequestMessageBean<MaskableActTypeBean> message = (RecordRequestMessageBean<MaskableActTypeBean>) result.getMessageObject();
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
		ChangeItemMaskingAcceptedMessageBean acceptedBean = new ChangeItemMaskingAcceptedMessageBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(ACCEPTED_MESSAGE_FILE)), actual);
	}

	private void populateAcceptedBean(ChangeItemMaskingAcceptedMessageBean acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(DEPRECATE_PATIENT_NOTE_REQUEST_ACCEPTED);
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		ChangeItemMaskingRefusedMessageBean refusedBean = new ChangeItemMaskingRefusedMessageBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REFUSED_MESSAGE_FILE)), actual);
	}

	protected void populateRefusedBean(ChangeItemMaskingRefusedMessageBean refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(DEPRECATE_PATIENT_NOTE_REQUEST_REFUSED);
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	private ChangeItemMaskingMessageBean createRequestBean() {
		ChangeItemMaskingMessageBean model = new ChangeItemMaskingMessageBean();
		model.getControlActEvent().setCode(DEPRECATE_PATIENT_NOTE_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());

		MaskableActTypeBean payload = createPayload();
		RecordBean<MaskableActTypeBean> recordBean = new RecordBean<MaskableActTypeBean>(payload);
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}

	private MaskableActTypeBean createPayload() {
		MaskableActTypeBean model = new MaskableActTypeBean();
		model.setItemToMaskId(new Identifier("4.3.2.1", "itemToMask_extension"));
		model.setConfidentialityCode(Confidentiality.NORMAL);
		model.setInfoCode(lookup(ActInformationCategoryCode.class, "MEDCCAT", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		model.setDiagnosisCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		model.setDiagnosisValue(lookup(DiagnosisValue.class, "402261004", CodeSystem.SNOMED.getRoot()));
		model.setMaskableMaterialCode(lookup(MaskableMaterialEntityType.class, "00888982", CodeSystem.DRUG_IDENTIFICATION_NUMBER.getRoot()));
		model.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		return model;
	}
}
