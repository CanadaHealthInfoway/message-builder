package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.MessageBean;
import ca.infoway.messagebuilder.model.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.RecordBean;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.MedicineBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.supply.NonPrescribedSupplyEventBean;
import ca.infoway.messagebuilder.model.cerx.supply.RecordSupplyEventAcceptedMessageBean;
import ca.infoway.messagebuilder.model.cerx.supply.RecordSupplyEventMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordSupplyEventTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordSupplyEventRequest.xml";

//	@Before
//	public void registerQueryRequestLimitCodeResolver() {
//		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
//	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, createRequest());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		assertEquals("type", RecordSupplyEventMessageBean.class, result.getMessageObject().getClass());
		
		RecordSupplyEventMessageBean messageObject = (RecordSupplyEventMessageBean) result.getMessageObject();
	}

	private RecordSupplyEventMessageBean createRequest() {
		RecordSupplyEventMessageBean model = new RecordSupplyEventMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_SUPPLY_EVENT_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		RecordBean<NonPrescribedSupplyEventBean> recordBean = new RecordBean<NonPrescribedSupplyEventBean>();
		NonPrescribedSupplyEventBean record = new NonPrescribedSupplyEventBean();
		record.setDispenseId(new Identifier("dispenseIdRoot", "dispenseIdExtension"));
		record.setEffectiveTime(new Date(0));
		record.setProduct(new MedicineBeanBuilder().populate().create());
		record.setQuantity(new PhysicalQuantity(
				new BigDecimal(12), 
				lookup(x_DrugUnitsOfMeasure.class, "g", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())));
		record.setCode(lookup(ActCode.class, "INFA", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		record.setDestination(new ServiceDeliveryLocationBeanBuilder().populate().create());
		recordBean.setRecord(record);
		model.getControlActEvent().setRecordBean(recordBean);
		return model;
	}
	
	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
		RecordSupplyEventAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
	}

	private RecordSupplyEventAcceptedMessageBean createAcceptedResponseBean() {
		RecordSupplyEventAcceptedMessageBean model = new RecordSupplyEventAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_SUPPLY_EVENT_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		return model;
	}
	
}
