/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
		String xmlString = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean());
		assertNotNull("result", xmlString);
	}

	@Test
	@Ignore // FIXME - TM - TRANSFORMATION TEST BEING IGNORED 
	public void shouldMatchKnownRequest() throws Exception {
		ActivateDevicePrescriptionRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean());
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject);
		assertEquals(xml, transformedBackToHl7Xml);
	}

	private ActivateDevicePrescriptionRequestMessageBean createRequestBean() {
		return new ActivateDevicePrescriptionRequestMessageBeanBuilder().populate().create();
	}
	
	@Test
	public void shouldFormatAcceptedResponse() throws Exception {
		ActivateDevicePrescriptionRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
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
