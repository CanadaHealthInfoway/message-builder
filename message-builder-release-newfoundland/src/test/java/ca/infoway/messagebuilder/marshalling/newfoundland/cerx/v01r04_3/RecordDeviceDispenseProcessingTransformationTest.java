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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RecordDeviceDispenseProcessingRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.DispenseRecordedConfirmationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDeviceDispenseProcessingRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDeviceDispenseProcessingRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordDeviceDispenseProcessingTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE =  "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordDeviceDispenseProcessingRequest_newTeal.xml";

	@Test @Ignore
	public void shouldProduceSomeResult() throws Exception {
		String xmlString = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean()).getXmlMessage();
		assertNotNull("result", xmlString);
	}

	@Test
	@Ignore // TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownRequest() throws Exception {
		RecordDeviceDispenseProcessingRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		
		InputStream inputStream = new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE).getInputStream();
		String string = IOUtils.toString(inputStream);
		
		Assert.assertEquals(string, xml);
		
//		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test @Ignore
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean()).getXmlMessage();
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject).getXmlMessage();
		assertEquals(xml, transformedBackToHl7Xml);
	}

	@Test
	public void shouldFormatAcceptedResponse() throws Exception {
		RecordDeviceDispenseProcessingRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model).getXmlMessage();
	}

	private RecordDeviceDispenseProcessingRequestMessageBean createRequestBean() {
		return new RecordDeviceDispenseProcessingRequestMessageBeanBuilder().populate().create();
	}

	private RecordDeviceDispenseProcessingRequestAcceptedMessageBean createAcceptedResponseBean() {
		RecordDeviceDispenseProcessingRequestAcceptedMessageBean model = new RecordDeviceDispenseProcessingRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_DEVICE_DISP_PROCESSING_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad55"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		DispenseRecordedConfirmationBean confirmationBean = new DispenseRecordedConfirmationBean();
		confirmationBean.setDispenseId(new Identifier("2.16.124.113620.1.1.7", "12345679"));
		confirmationBean.setPrescriptionId(new Identifier("2.16.124.113620.1.1.8", "12345679"));
		model.getControlActEvent().setRecordBean(new RecordBean<DispenseRecordedConfirmationBean>(confirmationBean));

		return model;
	}
}
