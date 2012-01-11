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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ProfessionalServicesBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.ProfessionalServiceRecord;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.RecordProfessionalServiceRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.RecordProfessionalServiceRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.professionalservice.RecordProfessionalServiceRequestRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordProfessionalServiceTransformationTest extends BaseTransformerTestCase {
	
	private static final String RESPONSE_REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordProfessionalServiceRequestRefused.xml";
	private static final String RESPONSE_ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordProfessionalServiceRequestAccepted.xml";
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordProfessionalServiceRequest.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		assertNotNull("result", toHl7(createRequestBean()));
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		RecordProfessionalServiceRequestMessageBean model = createRequestBean();
		String xml = toHl7(model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), 
				actual);
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordProfessionalServiceRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = toHl7(model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RESPONSE_ACCEPTED_MESSAGE_FILE)), actual);
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordProfessionalServiceRequestRefusedMessageBean model = createRefusedResponseBean();
		String xml = toHl7(model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RESPONSE_REFUSED_MESSAGE_FILE)), actual);
	}

	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		MessageBean messageObject = fromtHl7(message);
		assertTrue("type", messageObject instanceof RecordProfessionalServiceRequestMessageBean);
	}

	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		MessageBean messageObject = fromtHl7(message);
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), 
				this.factory.createFromString(toHl7(messageObject)));
	}
	
	private RecordProfessionalServiceRequestRefusedMessageBean createRefusedResponseBean() {
		RecordProfessionalServiceRequestRefusedMessageBean model = 
			new RecordProfessionalServiceRequestRefusedMessageBean();
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_PROFESSIONAL_SERVICE_REQUEST_REFUSED);
		
		return model;
	}
	
	private RecordProfessionalServiceRequestAcceptedMessageBean createAcceptedResponseBean() {
		
		RecordProfessionalServiceRequestAcceptedMessageBean model = 
			new RecordProfessionalServiceRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_PROFESSIONAL_SERVICE_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		model.getControlActEventBean().setRecordBean(new RecordBean<ActEventBean>(new ActEventBeanBuilder().populate().create()));
		
		return model;
	}

	private RecordProfessionalServiceRequestMessageBean createRequestBean() {
		RecordProfessionalServiceRequestMessageBean model = new RecordProfessionalServiceRequestMessageBean();
		model.getControlActEventBean().setCode(HL7TriggerEventCode.RECORD_PROFESSIONAL_SERVICE_REQUEST);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEventBean());
		
		model.getControlActEvent().setRecordBean(
				new RecordBean<ProfessionalServiceRecord>(
						new ProfessionalServicesBeanBuilder().populate().create()));
		
		return model;
	}
	
}
