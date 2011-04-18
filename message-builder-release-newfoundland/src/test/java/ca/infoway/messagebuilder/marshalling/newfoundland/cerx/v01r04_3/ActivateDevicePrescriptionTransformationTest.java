package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
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
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ActivateDevicePrescriptionRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ActivateDevicePrescriptionRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.ActivateDevicePrescriptionRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ActivateDevicePrescriptionTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE =  "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/activateDevicePrescriptionRequest.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xmlString = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createRequestBean());
		assertNotNull("result", xmlString);
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownRequest() throws Exception {
		ActivateDevicePrescriptionRequestMessageBean model = createRequestBean();
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

	private ActivateDevicePrescriptionRequestMessageBean createRequestBean() {
		return new ActivateDevicePrescriptionRequestMessageBeanBuilder().populate().create();
	}
	
	@Test
	public void shouldFormatAcceptedResponse() throws Exception {
		ActivateDevicePrescriptionRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
	}


	private ActivateDevicePrescriptionRequestAcceptedMessageBean createAcceptedResponseBean() {
		ActivateDevicePrescriptionRequestAcceptedMessageBean model = new ActivateDevicePrescriptionRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.ACTIVATE_DEVICE_PRESCRIPTION_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		ActRequestBean actRequestBean = new ActRequestBeanBuilder().populate().create();
		model.getControlActEvent().setRecordBean(new RecordBean<ActRequestBean>(actRequestBean));
		
		return model;
	}

}
