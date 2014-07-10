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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.NameFormatter;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.abort.AbortPrescriptionAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.abort.AbortPrescriptionMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.abort.AbortPrescriptionRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class AbortPrescriptionTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/abortPrescriptionRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/abortPrescriptionRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/abortPrescriptionRequestRefused.xml";
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean()).getXmlMessage();
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createRequestBean()).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldParseRequest() throws Exception {
		Document document = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, document);
		RecordRequestMessageBean<ActRequestBean> message = (RecordRequestMessageBean<ActRequestBean>) result.getMessageObject();
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
		String xmlString = this.transformer.transformToHl7(VERSION, (NewBaseMessageBean) xmlToJavaResult.getMessageObject()).getXmlMessage();
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordResponseMessageBean<ActRequestBean> acceptedBean = new AbortPrescriptionAcceptedMessageBean();
		populateAcceptedBean(acceptedBean);
		String xml = this.transformer.transformToHl7(VERSION, acceptedBean).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(ACCEPTED_MESSAGE_FILE)), actual);
	}

	private void populateAcceptedBean(RecordResponseMessageBean<ActRequestBean> acceptedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(acceptedBean.getMessageAttributes());
		acceptedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(acceptedBean.getControlActEvent());
		acceptedBean.getControlActEvent().setCode(HL7TriggerEventCode.ABORT_PRESCRIPTION_REQUEST_ACCEPTED);
		acceptedBean.getControlActEvent().setRecordBean(new RecordBean<ActRequestBean>());
		acceptedBean.getControlActEvent().getRecordBean().setRecord(new ActRequestBeanBuilder().populate().create());
		acceptedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordResponseMessageBean<ActRequestBean> refusedBean = new AbortPrescriptionRefusedMessageBean();
		populateRefusedBean(refusedBean);
		String xml = this.transformer.transformToHl7(VERSION, refusedBean).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REFUSED_MESSAGE_FILE)), actual);
	}

	protected void populateRefusedBean(RecordResponseMessageBean<ActRequestBean> refusedBean) {
		MessageBeanBuilderSupport.populateStandardValuesV02(refusedBean.getMessageAttributes());
		refusedBean.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(refusedBean.getControlActEvent());
		refusedBean.getControlActEvent().setCode(HL7TriggerEventCode.ABORT_PRESCRIPTION_REQUEST_REFUSED);
		refusedBean.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		refusedBean.getControlActEvent().setRecordBean(new RecordBean<ActRequestBean>());
		refusedBean.getControlActEvent().getRecordBean().setRecord(new ActRequestBeanBuilder().populate().create());
	}

	private AbortPrescriptionMessageBean createRequestBean() {
		AbortPrescriptionMessageBean model = new AbortPrescriptionMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.ABORT_PRESCRIPTION_REQUEST);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bae22"));
		model.getControlActEvent().setEffectiveTime(MessageBeanBuilderSupport.EFFECTIVE_TIME);
		model.getControlActEvent().setAuthor(new AuthorBeanBuilder().populate().create());
		model.getControlActEvent().setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());

		ActRequestBean actRequestBean = new ActRequestBeanBuilder().populate().create();
		RecordBean<ActRequestBean> recordBean = new RecordBean<ActRequestBean>(actRequestBean);
		model.getControlActEvent().setRecordBean(recordBean);
		
		return model;
	}
}
