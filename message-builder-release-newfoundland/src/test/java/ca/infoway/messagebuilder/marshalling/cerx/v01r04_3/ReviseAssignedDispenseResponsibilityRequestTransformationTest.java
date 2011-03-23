package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder.CombinedMedicationBeanType.PORX_MT060340CA;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.cerx.Prescription;
import ca.infoway.messagebuilder.model.cerx.medicalprofile.CombinedMedicationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.revise.DispenseAuthorizationBean;
import ca.infoway.messagebuilder.model.cerx.revise.DispenseAuthorizationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.revise.ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.revise.ReviseAssignedDispenseResponsibilityRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ReviseAssignedDispenseResponsibilityRequestTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/reviseAssignedDispenseResponsibilityRequest.xml";
	private static final String RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/reviseAssignedDispenseResponsibilityRequestAccepted.xml";
	protected static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createRequestBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		ReviseAssignedDispenseResponsibilityRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) result.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}
	
	private ReviseAssignedDispenseResponsibilityRequestMessageBean createRequestBean() {
		ReviseAssignedDispenseResponsibilityRequestMessageBean model = new ReviseAssignedDispenseResponsibilityRequestMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.REVISE_ASSIGNED_DISPENSE_RESPONSIBILITY_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		RecordBean<DispenseAuthorizationBean> recordBean = new RecordBean<DispenseAuthorizationBean>();
		recordBean.setRecord(new DispenseAuthorizationBeanBuilder().populate().create());
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
	
	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldProduceSomeResponseResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createResponseMessageBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownResponse() throws Exception {
		ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean model = createResponseMessageBean();
		String xml = this.transformer.transformToHl7(VERSION, model);
		System.out.println(xml);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), RESPONSE_MESSAGE_FILE)), actual);
	}

//	SPD: not important since we are only creating xml from response beans and not the other way around.
//	@Test
//	public void shouldTransformResponseBackAndForthWithoutLosingData() throws Exception {
//		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createResponseMessageBean());
//		Document message = this.factory.createFromString(xml);
//		XmlToJavaResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
//		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
//		String transformedBackToHl7Xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, messageObject);
//		assertEquals(xml, transformedBackToHl7Xml);
//	}
	
	private ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean createResponseMessageBean() {
		ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean model = new ReviseAssignedDispenseResponsibilityRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.REVISE_ASSIGNED_DISPENSE_RESPONSIBILITY_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		RecordBean<Prescription> recordBean = new RecordBean<Prescription>();
		recordBean.setRecord(new CombinedMedicationBeanBuilder(PORX_MT060340CA).populate().create());
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}	

}
