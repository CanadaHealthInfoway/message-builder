package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.cerx.ActRequestBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.refusal.RecordRefusalToDispenseRequestRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordRefusalToDispenseRequestRefusedTransformationTest extends BaseTransformerTestCase {
	
	private static final String MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordRefusalToDispenseRequestRefused.xml";
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String transformToXml = this.transformer.transformToHl7(VERSION, createResponseBean());
		assertNotNull("result", transformToXml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		RecordRefusalToDispenseRequestRefusedMessageBean model = createResponseBean();
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

	
	private RecordRefusalToDispenseRequestRefusedMessageBean createResponseBean() {
		RecordRefusalToDispenseRequestRefusedMessageBean refusedBean = new RecordRefusalToDispenseRequestRefusedMessageBean();
		MessageBeanBuilderSupport.populateBetterStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_REFUSAL_TO_DISPENSE_REQUEST_REFUSED);
		refusedBean.getControlActEvent().setRecordBean(new RecordBean<ActRequestBean>());
		refusedBean.getControlActEvent().getRecordBean().setRecord(new ActRequestBeanBuilder().populate().create());
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		return refusedBean;
	}

}
