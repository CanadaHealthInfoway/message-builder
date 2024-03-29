/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicineBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.supply.NonPrescribedSupplyEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.supply.RecordSupplyEventAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.supply.RecordSupplyEventMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordSupplyEventTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordSupplyEventRequest.xml";

//	@Before
//	public void registerQueryRequestLimitCodeResolver() {
//		CodeResolverRegistry.registerResolver(QueryRequestLimit.class, new EnumBasedCodeResolver(QueryRequestLimitEnum.class));
//	}
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		RecordSupplyEventMessageBean bean = createRequest();
		bean.getMessageAttributes().getReceiver().setTelecommunicationAddress(new TelecommunicationAddress(CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.0"));
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, bean).getXmlMessage();
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}
	
	@Test
	public void shouldMatchKnownMessage() throws Exception {
		MessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		assertEquals("type", RecordSupplyEventMessageBean.class, result.getMessageObject().getClass());
		
//		RecordSupplyEventMessageBean messageObject = (RecordSupplyEventMessageBean) result.getMessageObject();
	}

	private RecordSupplyEventMessageBean createRequest() {
		RecordSupplyEventMessageBean model = new RecordSupplyEventMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_SUPPLY_EVENT_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		RecordBean<NonPrescribedSupplyEventBean> recordBean = new RecordBean<NonPrescribedSupplyEventBean>();
		NonPrescribedSupplyEventBean record = new NonPrescribedSupplyEventBean();
		record.setDispenseId(new Identifier("3.2.1", "dispenseIdExt"));
		record.setEffectiveTime(new Date(0));
		MedicineBean medicineBean = new MedicineBeanBuilder().populate().create();
		medicineBean.setExpirationTime(IntervalFactory.createHigh(DateUtil.getDate(2009, 0, 1, 0, 0, 0, 0, TimeZone.getTimeZone("America/Toronto"))));
		
		record.setProduct(medicineBean);
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
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model).getXmlMessage();
		Assert.assertNotNull(xml);
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
