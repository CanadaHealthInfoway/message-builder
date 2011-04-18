package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActivatePrescriptionRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.prescription.ActivatePrescriptionRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.prescription.ActivatePrescriptionRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ActivatePrescriptionTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE =  "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/activatePrescriptionRequest.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xmlString = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createRequestBean());
		assertNotNull("result", xmlString);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		ActivatePrescriptionRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	 
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createRequestBean());
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, messageObject);
		assertEquals(xml, transformedBackToHl7Xml);
	}

	@Test
	public void shouldFormatAcceptedResponse() throws Exception {
		ActivatePrescriptionRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
	}

	private ActivatePrescriptionRequestMessageBean createRequestBean() {
		return new ActivatePrescriptionRequestMessageBeanBuilder().populate().create();
	}

	private ActivatePrescriptionRequestAcceptedMessageBean createAcceptedResponseBean() {
		ActivatePrescriptionRequestAcceptedMessageBean model = new ActivatePrescriptionRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.ACTIVATE_PRESCRIPTION_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		ActRequestBean actRequestBean = new ActRequestBeanBuilder().populate().create();
		model.getControlActEvent().setRecordBean(new RecordBean<ActRequestBean>(actRequestBean));
		
		return model;
	}

}
